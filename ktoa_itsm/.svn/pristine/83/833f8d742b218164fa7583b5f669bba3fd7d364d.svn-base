package truebon.com.crm.slc.controller;


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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import truebon.com.crm.slc.model.SvclifeCodeMngVO;
import truebon.com.crm.slc.service.SvclifeCodeService;
import truebon.com.opm.biz.service.BizSytmService;
import truebon.com.opm.com.model.ComnCdNewVO;
import truebon.com.opm.com.service.ComnCdNewService;


@Controller
public class SvclifeCodeMngController {

	/* Validator */
	@Autowired
	private DefaultBeanValidator beanValidator;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/** 공통코드 Service */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	/** 새공통코드 Service */
	@Resource(name = "ComnCdNewService")
	private ComnCdNewService comnCdNewService;
	
	/** 업무시스템 Service */
	@Resource(name = "BizSytmService")
	private BizSytmService bizSytmService;
	
	/** SvclifeCode Service */
	@Resource(name = "SvclifeCodeService")
	private SvclifeCodeService svcLifeCodeService;
	
	
    
    /**
     * 내용연수 관리 목록화면 (paging)
     * @param searchVO - 조회할 정보가 담긴 SvclifeCodeMngVO
     * @exception Exception
     */
	@RequestMapping(value = "/crm/slc/SvclifeCodeMngList.do")
	public String selectSvclifeCodeList(@ModelAttribute("SvclifeCodeMngVO") SvclifeCodeMngVO searchVO, ModelMap model) throws Exception {
		
		//HW유형
		ComDefaultCodeVO vo1 = new ComDefaultCodeVO();
		vo1.setComnCdId("ITA09");
		vo1.setDetailCondition("2");
		List<CmmnDetailCode> hwTypeCdList = this.cmmUseService.selectCmmCodeNewDetail(vo1);
		model.addAttribute("hwTypeCdList", hwTypeCdList);
		
		
		/** EgovPropertyService.sample */
	    if(searchVO.getPageUnit()!=10) {			
			searchVO.setPageUnit(searchVO.getPageUnit());
		}else {
			searchVO.setPageUnit(10);
		}
		
		searchVO.setPageSize(propertiesService.getInt("pageSize"));
		
		/** paging */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		//총개수
		int totCnt = svcLifeCodeService.selectSvclifeCodeListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		//목록
		List<SvclifeCodeMngVO> svclifeCodeMngList = svcLifeCodeService.selectSvclifeCodeList(searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("svclifeCodeMngList", svclifeCodeMngList);
		
		return "/truebon/com/crm/slc/SvclifeCodeMngList";
	}
	
	
	/**
     * 내용연수 관리 수정화면 (paging)
     * @param searchVO - 조회할 정보가 담긴 SvclifeCodeMngVO
     * @exception Exception
     */
	@RequestMapping(value = "/crm/slc/SvclifeCodeMngDetail.do")
	public String selectSvclifeCodeDetail(@ModelAttribute("searchVO") SvclifeCodeMngVO searchVO, ModelMap model) throws Exception {

		        //공통코드NEW (HW유형)
				ComDefaultCodeVO vo1 = new ComDefaultCodeVO();
				vo1.setComnCdId("ITA09");
				vo1.setDetailCondition("2");
				List<CmmnDetailCode> hwTypeCdList = this.cmmUseService.selectCmmCodeNewDetail(vo1);
				model.addAttribute("hwTypeCdList", hwTypeCdList);
				
				// 공통코드NEW (HW유형상세)
				ComDefaultCodeVO vo2 = new ComDefaultCodeVO();
				vo2.setComnCdId("ITA09");
				vo2.setDetailCondition("3");
				List<CmmnDetailCode> hwTypeDetailCdList = cmmUseService.selectCmmCodeNewDetail(vo2);
				model.addAttribute("hwTypeDetailCdList", hwTypeDetailCdList);
				
				SvclifeCodeMngVO result = svcLifeCodeService.selectSvclifeCode(searchVO);
				model.addAttribute("result", result);
				model.addAttribute("searchVO", searchVO);
				
				return "/truebon/com/crm/slc/SvclifeCodeMngUpdt";
	}
	
	
	/**
	 * 내용연수 관리 수정
	 * 
	 * @param SvclifeCodeMngVO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/crm/slc/SvclifeCodeMngUpdt.do")
	public String SvclifeCodeMngUpdt(@ModelAttribute("SvclifeCodeMngVO") SvclifeCodeMngVO svclifeCodeMngVO, ModelMap model, BindingResult bindingResult) throws Exception {
    	
    	String sLocationUrl = "";
    	String resultMsg    = "";
    	
    	// 유효성 검사
    	beanValidator.validate(svclifeCodeMngVO, bindingResult);
    	if (bindingResult.hasErrors()){
			sLocationUrl = "/truebon/com/crm/slc/SvclifeCodeMngList";
			return sLocationUrl;
		}else {
			svcLifeCodeService.updateSvclifeCode(svclifeCodeMngVO);
			sLocationUrl = "forward:/crm/slc/SvclifeCodeMngList.do";
			resultMsg = egovMessageSource.getMessage("success.common.update");
		}
    	
    	model.addAttribute("resultMsg", resultMsg);
        return sLocationUrl;
    } 
	
	
	/**
	 * HW 유형 선택에 따른 HW 유형 상세 조회
	 * 
	 * @param SvclifeCodeMngVO
	 * @param comnCdNewVO
	 * @param bindingResult
	 * @param searchVO
	 * @param model
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/crm/slc/HwType.do")
	@ResponseBody
	public ModelAndView HwType(@ModelAttribute("SvclifeCodeMngVO") SvclifeCodeMngVO svcLifeCodeMngVO, ComnCdNewVO comnCdNewVO,
			BindingResult bindingResult, Model model, @RequestParam("newComnCd") String newComnCd) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");

		ComnCdNewVO vo = new ComnCdNewVO();
		vo.setUpprNewComnCd(newComnCd);
		List<?> hwTypeDtlList = comnCdNewService.selectComnCdNewList(vo);

		mav.addObject("hwTypeDtlList", hwTypeDtlList);

		return mav;
	}
	
	
	/**
     * 내용연수 관리 등록화면 (paging)
     * @param searchVO - 조회할 정보가 담긴 SvclifeCodeMngVO
     * @exception Exception
     */
	@RequestMapping(value = "/crm/slc/SvclifeCodeMngRegistDetail.do")
	public String SvclifeCodeMngRegistDetail(@ModelAttribute("searchVO") SvclifeCodeMngVO searchVO, ModelMap model) throws Exception {

		        //공통코드NEW (HW유형)
				ComDefaultCodeVO vo1 = new ComDefaultCodeVO();
				vo1.setComnCdId("ITA09");
				vo1.setDetailCondition("2");
				List<CmmnDetailCode> hwTypeCdList = this.cmmUseService.selectCmmCodeNewDetail(vo1);
				model.addAttribute("hwTypeCdList", hwTypeCdList);
				
				// 공통코드NEW (HW유형상세)
				ComDefaultCodeVO vo2 = new ComDefaultCodeVO();
				vo2.setComnCdId("ITA09");
				vo2.setDetailCondition("3");
				List<CmmnDetailCode> hwTypeDetailCdList = cmmUseService.selectCmmCodeNewDetail(vo2);
				model.addAttribute("hwTypeDetailCdList", hwTypeDetailCdList);
				
				model.addAttribute("searchVO", searchVO);
				model.addAttribute("pageIndex",searchVO.getPageIndex());
				
				return "/truebon/com/crm/slc/SvclifeCodeMngRegist";
	}
	
	
	/**
	 * 내용연수 관리 등록
	 * 
	 * @param SvclifeCodeMngVO
	 * @param SvclifeCodeMngVO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/crm/slc/SvclifeCodeMngRegist.do")
	public String SvclifeCodeMngRegist(@ModelAttribute("SvclifeCodeMngVO") SvclifeCodeMngVO svcLifeCodeMngVO, BindingResult bindingResult, ModelMap model)
			throws Exception {
		String sLocationUrl = "";
		String resultMsg = "";
		// 유효성 검사
		beanValidator.validate(svcLifeCodeMngVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "/truebon/com/crm/slc/SvclifeCodeMngRegist";
			return sLocationUrl;
		} else {
			svcLifeCodeService.registSvclifeCode(svcLifeCodeMngVO);
			resultMsg = egovMessageSource.getMessage("success.common.insert");
			sLocationUrl = "forward:/crm/slc/SvclifeCodeMngList.do";
		}
		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}

}
