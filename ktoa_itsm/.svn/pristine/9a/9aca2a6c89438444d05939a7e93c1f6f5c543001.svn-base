package truebon.com.sys.chr.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;
import org.springframework.web.bind.annotation.ModelAttribute;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import truebon.com.sys.chr.model.Charger;
import truebon.com.sys.chr.model.ChargerVO;
import truebon.com.sys.chr.service.ChargerService;


/**
 * @Class Name : PartnersController.java
 * @Description : Partners Controller class
 * @Modification Information
 *
 * @author 조경민
 * @since 2022.06.28
 * @version 1.0
 * @see
 * 
 *      Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes(types = Charger.class)
public class PartnersController {

	/* Validator */
	@Autowired
	private DefaultBeanValidator beanValidator;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** 담당자 Service */
	@Resource(name = "ChargerService")
	private ChargerService chargerService;
	
	 /** 공통코드 Service */
    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
    
    /** EgovMessageSource */
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    /**
	 * 담당자 목록화면 (pageing)
	 * @param searchVO - 조회할 정보가 담긴 ChargerVO
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/ptn/PartnersMngList.do")
	public String PartnersList(@ModelAttribute("searchVO") ChargerVO searchVO, ModelMap model) throws Exception {

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

		// 담당자구분코드(공통코드ID(ISM001))(KTOA(1), 위탁운영(2), 협력업체(3), 기타(4))
		List<String> arrChrgrDstnctCd = new ArrayList<String>();
		arrChrgrDstnctCd.add("3");
		searchVO.setArrChrgrDstnctCd(arrChrgrDstnctCd);
		
		// 목록
		List<ChargerVO> partnersList = chargerService.selectChargerList(searchVO);
		model.addAttribute("partnersList", partnersList);
		model.addAttribute("searchVO", searchVO);
		
		int ptnCnt = chargerService.selectChargerListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(ptnCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		return "truebon/com/sys/ptn/PartnersMngList";
	}
	
	/**
	 * 방문자 존재유무 확인 (협력업체 담당자 등록)
	 * @param chargerVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/ptn/checkVisitor.do")
	public ModelAndView checkVisitor(@ModelAttribute("searchVO") ChargerVO chargerVO, Model model) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		
		int checkVst = chargerService.CheckVisitorsNmCmpny(chargerVO);

		mav.addObject("checkVst", checkVst);
		return mav;
	}
	
	/**
	 * 방문자 등록화면 (협력업체 담당자 등록)
	 * @param chargerVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/ptn/PartnersMngRegistPopup.do")
	public String PartnersMngRegistPopup(@ModelAttribute("searchVO") ChargerVO chargerVO, BindingResult bindingResult, Model model) throws Exception {
		
		//공통코드(담당자 구분)	
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setComnCdId("ISM001");
		List<?> chrgrDstnctCdList = cmmUseService.selectCmmCodeDetail(vo);
		
		model.addAttribute("chrgrDstnctCdList", chrgrDstnctCdList);		
		model.addAttribute("chargerVO", chargerVO);
				
		return "truebon/com/sys/ptn/PartnersMngRegistPopup";
	}
	
	/**
	 * 방문자 등록 (협력업체 담당자 등록)
	 * @param chargerVO
	 * @param bindingResult
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/sys/ptn/insertPartnersMngRegistPopup.do")
	public String insertPartnersMngRegistPopup(
			@ModelAttribute("chargerVO") ChargerVO chargerVO,
			BindingResult bindingResult,
			Model model)
					throws Exception {
		String sLocationUrl = "";
		String resultMsg    = "";
		
		// 유효성 검사
		beanValidator.validate(chargerVO, bindingResult);
		if (bindingResult.hasErrors()){
			sLocationUrl = "truebon/com/sys/ptn/PartnersMngRegistPopup";
			return sLocationUrl;
		}else {
			chargerService.insertCharger(chargerVO);
			resultMsg = egovMessageSource.getMessage("success.common.insert");
			sLocationUrl = "truebon/com/sys/ptn/PartnersMngRegistPopup";
		}
		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}
	
	/**
	 * 담당자 등록화면
	 * @param chargerVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/ptn/PartnersMngRegist.do")
	public String PartnersMngRegist(@ModelAttribute("searchVO") ChargerVO chargerVO, BindingResult bindingResult, Model model) throws Exception {
		
		//공통코드(담당자 구분)	
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setComnCdId("ISM001");
		List<?> chrgrDstnctCdList = cmmUseService.selectCmmCodeDetail(vo);
		
		model.addAttribute("chrgrDstnctCdList", chrgrDstnctCdList);		
		model.addAttribute("chargerVO", chargerVO);
				
		return "truebon/com/sys/ptn/PartnersMngRegist";
	}
	
	/**
	 * 담당자 등록
	 * @param chargerVO
	 * @param bindingResult
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/sys/ptn/inseartPartnersMngRegist.do")
	public String inseartPartnersMngRegist(
			@ModelAttribute("chargerVO") ChargerVO chargerVO,
			BindingResult bindingResult,
			Model model)
					throws Exception {
		String sLocationUrl = "";
		String resultMsg    = "";
		
		// 유효성 검사
		beanValidator.validate(chargerVO, bindingResult);
		if (bindingResult.hasErrors()){
			sLocationUrl = "truebon/com/sys/ptn/PartnersMngRegist";
			return sLocationUrl;
		}else {
			chargerService.insertCharger(chargerVO);
			resultMsg = egovMessageSource.getMessage("success.common.insert");
			sLocationUrl = "forward:/sys/ptn/PartnersMngList.do";
		}
		System.out.println("컨트롤러 " + sLocationUrl);
		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}
	
	/**
	 * 담당자 수정화면
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/ptn/PartnersMngUpdt.do")
	public String PartnersMngList(@ModelAttribute("searchVO") ChargerVO searchVO, ModelMap model) throws Exception {
		//공통코드(담당자 구분)
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setComnCdId("ISM001");
		List<?> chrgrDstnctCdList = cmmUseService.selectCmmCodeDetail(vo);
		
		model.addAttribute("chrgrDstnctCdList", chrgrDstnctCdList);
		
    	// 상세정보 조회
    	ChargerVO resultVO = chargerService.selectCharger(searchVO);
        model.addAttribute("chargerVO", resultVO);
		
		System.out.println("업데이트실행");
		return "truebon/com/sys/ptn/PartnersMngUpdt";
	}
	
	/**
	 * 담당자 수정
	 * @param chargerVO
	 * @param searchVO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/sys/ptn/updatePartnersMngUpdt.do")
	public String updatePartnersMngUpdt(
			@ModelAttribute("chargerVO") ChargerVO chargerVO,
			BindingResult bindingResult,
			ModelMap model)
			throws Exception {
		
		String sLocationUrl = "";
		String resultMsg    = "";
		
		// 유효성 검사
		beanValidator.validate(chargerVO, bindingResult);
		if (bindingResult.hasErrors()){
			sLocationUrl = "truebon/com/sys/ptn/PartnersMngUpdt";
			return sLocationUrl;
		}else {
			chargerService.updateCharger(chargerVO);
			resultMsg = egovMessageSource.getMessage("success.common.update");
			sLocationUrl = "forward:/sys/ptn/PartnersMngList.do";
		}
		
		model.addAttribute("resultMsg", resultMsg);
		return "forward:/sys/ptn/PartnersMngList.do";
	}
	
	/**
     * 담당자 삭제
     * @param chargerVO
     * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/sys/ptn/deletePartnersMng.do")
	public String deletePartnersMngList(@ModelAttribute("chargerVO") ChargerVO chargerVO, ModelMap model) throws Exception {
		String resultMsg = "";
        
		chargerService.deleteCharger(chargerVO);
		resultMsg = egovMessageSource.getMessage("success.common.delete");
        
		model.addAttribute("resultMsg", resultMsg);
		return "forward:/sys/ptn/PartnersMngList.do";
	}
	
	/**
     * 프로그램목록 멀티 삭제한다.
     * @param searchVO
     * @param status
     * @return
     * @throws Exception
     */
	@RequestMapping("/sys/ptn/deletePartnersMngList.do")
	public String deleteChargerMngList(
	        @ModelAttribute("searchVO") ChargerVO searchVO,
	        ModelMap model)
	        		throws Exception {
		// 결과 메시지
		String resultMsg    = "";
		String [] delChrgrNo = searchVO.getCheckedValueForDel().split(",");
		
		if (delChrgrNo == null || (delChrgrNo.length ==0)){
			resultMsg = egovMessageSource.getMessage("fail.common.delete");
		}else{
			chargerService.deleteChargerMngList(searchVO);
			resultMsg = egovMessageSource.getMessage("success.common.delete");
		}
		model.addAttribute("resultMsg", resultMsg);
		
		return "forward:/sys/ptn/PartnersMngList.do";
	}
	
}
