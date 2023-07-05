package truebon.com.dlm.cod.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import truebon.com.dlm.cod.model.ComnDate;
import truebon.com.dlm.cod.model.ComnDateVO;
import truebon.com.dlm.cod.service.ComnDateService;

/**
 * @Class Name : ComnDateMngController.java
 * @Description : ComnDate Controller class
 * @Modification Information
 *
 * @author 이유리
 * @since 2022.05.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */


@Controller
@SessionAttributes(types=ComnDate.class)
public class ComnDateController {
	
	/* Validator */
	@Autowired
	private DefaultBeanValidator beanValidator;
	
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	/** EgovMessageSource */
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    /** 공통일자 Service */
    @Resource(name = "ComnDateService")
    private ComnDateService comnDateService;

    /**
 	 * 공통일자 목록화면 (paging)
 	 * @param searchVO - 조회할 정보가 담긴 ComnDateVO
 	 * @exception Exception
 	 */
	   @RequestMapping(value="/dlm/cod/ComnDateMngList.do")
	    public String ComnDateMngList(@ModelAttribute("searchVO") ComnDateVO searchVO, 
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
			
	    	List<ComnDateVO> comnDateList = comnDateService.selectComnDateList(searchVO);
	        model.addAttribute("resultList", comnDateList);
	        model.addAttribute("searchVO", searchVO);
	        
	        int totCnt = comnDateService.selectComnDateListTotCnt(searchVO);
			paginationInfo.setTotalRecordCount(totCnt);
	        model.addAttribute("paginationInfo", paginationInfo);
	        
	        return "/truebon/com/dlm/cod/ComnDateMngList";
	    } 
	    
	    /**
	     * 공통일자 등록
	     * @param ComnDateVO
	     * @param bindingResult
	     * @param model
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping("/dlm/cod/insertComnDateMngRegist.do")
	    public String insertComnDateMngRegist(@RequestParam("checkDate") String checkDate,
	            @ModelAttribute("comnDateVO") ComnDateVO comnDateVO,
	            BindingResult bindingResult,
	            Model model)
	            throws Exception {
	    	String sLocationUrl = "";
	    	String resultMsg    = "";
	    	int existDate = 1;
	    
				existDate = comnDateService.checkComnDate(checkDate);
				
				if(existDate == 0) {
					comnDateService.insertComnDate(comnDateVO);
					resultMsg = egovMessageSource.getMessage("success.common.insert");
				}else {
					resultMsg = "해당 년도는 이미 존재하므로 등록이 불가합니다.";
				}
					sLocationUrl = "forward:/dlm/cod/ComnDateMngList.do";
	    	
	    	model.addAttribute("resultMsg", resultMsg);
	        return sLocationUrl;
	    }
	    
	    /**
	     * 공통일자 수정화면
	     * @param searchVO
	     * @param model
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping("/dlm/cod/ComnDateMngUpdt.do")
	    public String ComnDateMngUpdt(
	            @ModelAttribute("searchVO") ComnDateVO searchVO,
	            Model model)
	            throws Exception {
	    	
	    	// 상세정보 조회
	    	ComnDateVO resultVO = comnDateService.selectComnDate(searchVO);
	        model.addAttribute("comnDateVO", resultVO);
	        
	        return "/truebon/com/dlm/cod/ComnDateMngUpdt";
	    }

	    /**
	     * 공통일자 수정
	     * @param comnDateVO
	     * @param searchVO
	     * @param status
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping("/dlm/cod/updateComnDateMngUpdt.do")
	    public String updateComnDateMngUpdt(
	            @ModelAttribute("comnDateVO") ComnDateVO comnDateVO,
	            BindingResult bindingResult,
	    		ModelMap model)
	            throws Exception {
	    	String sLocationUrl = "";
	    	String resultMsg    = "";
	    	
	    	// 유효성 검사
	    	beanValidator.validate(comnDateVO, bindingResult);
	    	if (bindingResult.hasErrors()){
				sLocationUrl = "/truebon/com/dlm/cod/ComnDateMngUpdt";
				return sLocationUrl;
			}else {
				comnDateService.updateComnDate(comnDateVO);
				resultMsg = egovMessageSource.getMessage("success.common.update");
				sLocationUrl = "forward:/dlm/cod/ComnDateMngList.do";
			}
	    	
	    	model.addAttribute("resultMsg", resultMsg);
	        return "forward:/dlm/cod/ComnDateMngList.do";
	    }
	    
	    /**
	     * 공통일자 체크
	     * @param ComnDateVO
	     * @param bindingResult
	     * @param model
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping("/dlm/cod/checkComnDateExist.do")
	    public ModelAndView checkComnDateExist(@RequestParam("checkDate") String checkDate,
	            @ModelAttribute("comnDateVO") ComnDateVO comnDateVO,
	            BindingResult bindingResult,
	            Model model)
	            throws Exception {
	    
	    	String resultMsg    = "";
	    	int existDate = -1;
	    	ModelAndView mav = new ModelAndView("jsonView");
	    	
				existDate = comnDateService.checkComnDate(checkDate);
				resultMsg = "공통 일자에서 다음 해의 날짜 데이터를 등록해주세요.";
				
			mav.addObject("resultMsg", resultMsg);
			mav.addObject("existDate", existDate);
	        return mav;
	    }
}
