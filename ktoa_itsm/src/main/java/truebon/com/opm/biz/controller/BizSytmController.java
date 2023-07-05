package truebon.com.opm.biz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import truebon.com.opm.biz.model.BizSytmVO;
import truebon.com.opm.biz.service.BizSytmService;

/**
 * @Class Name : BizSytmMngController.java
 * @Description : BizSytm Controller class
 * @Modification Information
 *
 * @author 이유리
 * @since 2022.07.26
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
public class BizSytmController {
	
	/* Validator */
	@Autowired
	private DefaultBeanValidator beanValidator;
	
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
	/** EgovMessageSource */
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    /** 업무시스템 Service */
	@Resource(name ="BizSytmService")
	private BizSytmService bizSytmService;
	
	/**
	 * 업무시스템 목록화면 (paging)
	 * @param searchVO - 조회할 정보가 담긴 BizSytmVO
	 * @exception Exception
	 */
    @RequestMapping(value="/opm/biz/BizSytmMngList.do")
    public String BizSytmMngList(@ModelAttribute("searchVO") BizSytmVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** paging */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		// 목록
        List<BizSytmVO> bizSytmList = bizSytmService.selectBizSytmList(searchVO);
        model.addAttribute("resultList", bizSytmList);
        model.addAttribute("searchVO", searchVO);
        
        int totCnt = bizSytmService.selectBizSytmListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/truebon/com/opm/biz/BizSytmMngList";
    } 
    
    /**
     * 업무시스템 등록화면
     * @param BizSytmVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/opm/biz/BizSytmMngRegist.do")
    public String BizSytmMngRegist(
            @ModelAttribute("bizSytmVO") BizSytmVO bizSytmVO,
            Model model)
            throws Exception {

		model.addAttribute("bizSytmVO", bizSytmVO);
        return "/truebon/com/opm/biz/BizSytmMngRegist";
    }
    
    /**
     * 업무시스템 등록
     * @param bizSytmVO
     * @param bindingResult
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/opm/biz/insertBizSytmMngRegist.do")
    public String insertBizSytmMngRegist(
            @ModelAttribute("bizSytmVO") BizSytmVO bizSytmVO,
            BindingResult bindingResult,
            Model model)
            throws Exception {
    	String sLocationUrl = "";
    	String resultMsg    = "";
    	
    	// 유효성 검사
    	beanValidator.validate(bizSytmVO, bindingResult);
    	if (bindingResult.hasErrors()){
			sLocationUrl = "/truebon/com/opm/biz/BizSytmMngRegist";
			return sLocationUrl;
		}else {
			if(bizSytmVO.getBizSytmCd() != null) {
				BizSytmVO vo = bizSytmService.selectBizSytm(bizSytmVO);
				if(vo != null) {
					model.addAttribute("resultMsg", "해당 시스템 코드가 이미 등록되어 있습니다.");
					return "truebon/com/opm/biz/BizSytmMngRegist";
				}
			}
			bizSytmService.insertBizSytm(bizSytmVO);
	    	resultMsg = egovMessageSource.getMessage("success.common.insert");
	        sLocationUrl = "forward:/opm/biz/BizSytmMngList.do";
		}
    	
    	model.addAttribute("resultMsg", resultMsg);
        return sLocationUrl;
    }
    
    /**
     * 업무시스템 수정화면
     * @param searchVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/opm/biz/BizSytmMngUpdt.do")
    public String BizSytmMngUpdt(
            @ModelAttribute("searchVO") BizSytmVO searchVO,
            Model model)
            throws Exception {
    	
    	// 상세정보 조회
    	BizSytmVO resultVO = bizSytmService.selectBizSytm(searchVO);
        model.addAttribute("bizSytmVO", resultVO);
        
        return "/truebon/com/opm/biz/BizSytmMngUpdt";
    }

    /**
     * 업무시스템 수정
     * @param bizSytmVO
     * @param searchVO
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping("/opm/biz/updateBizSytmMngUpdt.do")
    public String updateBizSytmMngUpdt(
            @ModelAttribute("bizSytmVO") BizSytmVO bizSytmVO,
            BindingResult bindingResult,
    		ModelMap model)
            throws Exception {
    	String sLocationUrl = "";
    	String resultMsg    = "";
    	
    	// 유효성 검사
    	beanValidator.validate(bizSytmVO, bindingResult);
    	if (bindingResult.hasErrors()){
			sLocationUrl = "/truebon/com/opm/biz/BizSytmMngUpdt";
			return sLocationUrl;
		}else {
			bizSytmService.updateBizSytm(bizSytmVO);
			resultMsg = egovMessageSource.getMessage("success.common.update");
			sLocationUrl = "forward:/opm/biz/BizSytmMngList.do";
		}
    	
    	model.addAttribute("resultMsg", resultMsg);
        return "forward:/opm/biz/BizSytmMngList.do";
    } 
}