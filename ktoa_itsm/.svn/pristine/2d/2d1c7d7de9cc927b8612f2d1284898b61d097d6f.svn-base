package truebon.com.opm.com.controller;

import java.util.ArrayList;
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

import truebon.com.opm.com.model.ComnCdNewVO;
import truebon.com.opm.com.service.ComnCdNewService;
/**
 * @Class Name : ComnCdNewController.java
 * @Description : ComnCdNewController class
 * @Modification Information
 *
 * @author 이정하
 * @since 2023.10.19
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
public class ComnCdNewController {

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	
	@Resource(name = "ComnCdNewService")
	private ComnCdNewService comnCdNewService;

	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * 공통코드NEW 목록을 조회한다.
	 * 
	 * @param loginVO
	 * @param searchVO
	 * @param model
	 * @return "truebon/com/opm/com/ComnCdNewList"
	 * @throws Exception
	 */
	@RequestMapping(value = "/opm/com/ComnCdNewList.do")
	public String selectComnCdNewList(@ModelAttribute("searchVO") ComnCdNewVO searchVO, ModelMap model) throws Exception {
		
		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		/* 검색 필터 추가 */
		List<String> arrConditionTypes = new ArrayList<String>();
		if(searchVO.getSearchConditionTypes() == "") {
			arrConditionTypes.add("SRT");
			arrConditionTypes.add("ITA");
			arrConditionTypes.add("FLR");
		}
		if(searchVO.getSearchConditionTypes()!=null && searchVO.getSearchConditionTypes()!="") {
			String str = searchVO.getSearchConditionTypes();
			String[] splitStr = str.split(",");
			for(int i=0; i<splitStr.length; i++){
				arrConditionTypes.add(splitStr[i]);
			}
		}
		searchVO.setArrConditionTypes(arrConditionTypes);
		model.addAttribute("searchCodeList", arrConditionTypes);

		// 목록
		List<?> ComnCdNewList = comnCdNewService.selectComnCdList(searchVO);
		model.addAttribute("resultList", ComnCdNewList);

		int totCnt = comnCdNewService.selectComnCdNewListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/truebon/com/opm/com/ComnCdNewList";
	}
	/**
     * 공통코드NEW 등록화면
     * @param ComnCdNewVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/opm/com/ComnCdNewRegist.do")
    public String ComnCdNewRegist(
            @ModelAttribute("searchVO") ComnCdNewVO comnCdNewVO,
            Model model)
            throws Exception {

		model.addAttribute("comnCdNewVO", comnCdNewVO);
        return "/truebon/com/opm/com/ComnCdNewRegist";
    }
    /**
     * 공통코드NEW 등록
     * @param comnCdNewVO
     * @param bindingResult
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/opm/com/insertComnCdNewRegist.do")
    public String insertComnCdNewRegist(
            @ModelAttribute("comnCdNewVO") ComnCdNewVO comnCdNewVO,
            BindingResult bindingResult,
            Model model)
            throws Exception {
    	String sLocationUrl = "";
    	String resultMsg    = "";
    	
    	// 유효성 검사
    	beanValidator.validate(comnCdNewVO, bindingResult);
    	if (bindingResult.hasErrors()){
			sLocationUrl = "/truebon/com/opm/com/ComnCdNewRegist";
			return sLocationUrl;
		}else {
			if(comnCdNewVO.getNewComnCd() != null) {
				ComnCdNewVO vo = comnCdNewService.selectComnCdNew(comnCdNewVO);
				if(vo != null) {
					model.addAttribute("resultMsg", "해당 시스템 코드가 이미 등록되어 있습니다.");
					return "truebon/com/opm/com/ComnCdNewRegist";
				}
			}
			comnCdNewService.insertComnCdNew(comnCdNewVO);
	    	resultMsg = egovMessageSource.getMessage("success.common.insert");
	        sLocationUrl = "forward:/opm/com/ComnCdNewList.do";
		}
    	
    	model.addAttribute("resultMsg", resultMsg);
        return sLocationUrl;
    }
    
    /**
     * 공통코드NEW 수정화면
     * @param searchVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/opm/com/ComnCdNewUpdt.do")
    public String ComnCdNewUpdt(
            @ModelAttribute("searchVO") ComnCdNewVO searchVO,
            Model model)
            throws Exception {
    	
    	// 상세정보 조회
    	ComnCdNewVO resultVO = comnCdNewService.selectComnCdNew(searchVO);
        model.addAttribute("comnCdNewVO", resultVO);
        
        return "/truebon/com/opm/com/ComnCdNewUpdt";
    }

    /**
     * 공통코드NEW 수정
     * @param comnCdNewVO
     * @param searchVO
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping("/opm/com/updateComnCdNewUpdt.do")
    public String updateComnCdNewUpdt(
            @ModelAttribute("comnCdNewVO") ComnCdNewVO comnCdNewVO,
            BindingResult bindingResult,
    		ModelMap model)
            throws Exception {
    	String sLocationUrl = "";
    	String resultMsg    = "";
    	
    	// 유효성 검사
    	beanValidator.validate(comnCdNewVO, bindingResult);
    	if (bindingResult.hasErrors()){
			sLocationUrl = "/truebon/com/opm/com/ComnCdNewUpdt";
			return sLocationUrl;
		}else {
			comnCdNewService.updateComnCdNew(comnCdNewVO);
			resultMsg = egovMessageSource.getMessage("success.common.update");
			sLocationUrl = "forward:/opm/com/ComnCdNewList.do";
		}
    	
    	model.addAttribute("resultMsg", resultMsg);
        return "forward:/opm/com/ComnCdNewList.do";
    } 

    
}
