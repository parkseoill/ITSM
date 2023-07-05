package truebon.com.dlm.vis.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import truebon.com.dlm.dla.controller.DlalzQRController;
import truebon.com.dlm.vis.model.Visit;
import truebon.com.dlm.vis.model.VisitVO;
import truebon.com.dlm.vis.service.VisitService;

@Controller
@SessionAttributes(types = Visit.class)
public class VisitController {

	/* Validator */
	@Autowired
	private DefaultBeanValidator beanValidator;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/** 방문 Service */
	@Resource(name = "VisitService")
	private VisitService visitService;

	/** 공통코드 Service */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;
	
	/** 로그설정 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DlalzQRController.class);


	/**
	 * 방문 목록화면 (pageing)
	 * 
	 * @param searchVO - 조회할 정보가 담긴 VisitVO
	 * @exception Exception
	 */
	@RequestMapping(value = "/dlm/vis/VisitMngList.do")
	public String VisitMngList(@ModelAttribute("searchVO") VisitVO searchVO, ModelMap model) throws Exception {
		
		// 로그인 안했을 경우
		/*
		 * LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		 * if(user == null) { LocalDateTime currDateTime = LocalDateTime.now(); String
		 * formatedCurrDateTime =
		 * currDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		 * System.out.println("formatedCurrDateTime:"+formatedCurrDateTime);
		 * 
		 * searchVO.setStartDate(formatedCurrDateTime);
		 * searchVO.setEndDate(formatedCurrDateTime); }
		 */

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
		
		// 목록
		List<VisitVO> visitList = visitService.selectVisitList(searchVO);
		model.addAttribute("visitList", visitList);
		model.addAttribute("searchVO", searchVO);

		int totCnt = visitService.selectVisitListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/truebon/com/dlm/vis/VisitMngList";
	}

	/**
	 * 입실 등록화면
	 * 
	 * @param visitVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dlm/vis/VisitMngRegist.do")
	public String VisitMngRegist(@ModelAttribute("visitVO") VisitVO visitVO, Model model) throws Exception {

		// 공통코드(담당자 구분)
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setComnCdId("ISM010");
		List<?> vstPurpsCdList = cmmUseService.selectCmmCodeDetail(vo);

		model.addAttribute("vstPurpsCdList", vstPurpsCdList);
		model.addAttribute("visitVO", visitVO);
		return "/truebon/com/dlm/vis/VisitMngRegist";
	}

	/**
	 * 입실 등록
	 * 
	 * @param visitVO
	 * @param bindingResult
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dlm/vis/inseartVisitMngRegist.do")
	public String inseartVisitMngRegist(@ModelAttribute("visitVO") VisitVO visitVO, BindingResult bindingResult,
			Model model) throws Exception {
		String sLocationUrl = "";
		String resultMsg = "";

		// 유효성 검사
		beanValidator.validate(visitVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "/truebon/com/dlm/vis/VisitMngRegist";
			return sLocationUrl;
		} else {
			visitService.insertVisit(visitVO);
			resultMsg = egovMessageSource.getMessage("success.common.ent");
			resultMsg = "정상적으로 입실 등록되었습니다.";
			sLocationUrl = "forward:/dlm/vis/VisitMngList.do";
		}

		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}
	
	/**
	 * 입실 등록 전 오류확인 
	 * 
	 * @param visitVO
	 * @param bindingResult
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dlm/vis/checkVisitMng.do")
	@ResponseBody
	public ModelAndView checkVisitMng(@ModelAttribute("visitVO") VisitVO visitVO, 
								@ModelAttribute("searchVO") VisitVO searchVO,BindingResult bindingResult,
								@RequestParam("chrgrNo") String chrgrNo ,
								@RequestParam("vstDate") String vstDate	,						
			Model model) throws Exception {
		String resultMsg    = "";

		ModelAndView mav = new ModelAndView("jsonView");

		try {	
			int iResult = 0;
			searchVO.setSearchCondition("4");
			searchVO.setChrgrNo(chrgrNo);	
			searchVO.setStartDate(vstDate);
			searchVO.setEndDate(vstDate);
			iResult += Math.abs(visitService.selectVisitListTotCnt(searchVO));
			if(iResult>0) {
				resultMsg = "이미 입실 처리되었습니다.";	
			}else {
				resultMsg = "";
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} 
		
		mav.addObject("resultMsg", resultMsg);
    	
    	return mav;
	}

	/**
	 * 방문 수정화면
	 * 
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dlm/vis/VisitMngUpdt.do")
	public String VisitMngUpdt(@ModelAttribute("searchVO") VisitVO searchVO, Model model) throws Exception {

		// 공통코드(방문목적)
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setComnCdId("ISM010");
		List<?> vstPurpsCdList = cmmUseService.selectCmmCodeDetail(vo);

		model.addAttribute("vstPurpsCdList", vstPurpsCdList);

		// 상세정보 조회
		VisitVO resultVO = visitService.selectVisit(searchVO);
		model.addAttribute("visitVO", resultVO);

		return "/truebon/com/dlm/vis/VisitMngUpdt";
	}

	/**
	 * 방문 수정
	 * 
	 * @param visitVO
	 * @param searchVO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dlm/vis/updateVisitMngUpdt.do")
	public String updateVisitMngUpdt(@ModelAttribute("visitVO") VisitVO visitVO, BindingResult bindingResult,
			ModelMap model) throws Exception {
		String sLocationUrl = "";
		String resultMsg = "";

		// 유효성 검사
		beanValidator.validate(visitVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "/truebon/com/dlm/vis/VisitMngUpdt";
			return sLocationUrl;
		} else {
			visitService.updateVisit(visitVO);
			resultMsg = egovMessageSource.getMessage("success.common.update");
			sLocationUrl = "forward:/dlm/vis/VisitMngList.do";
		}

		model.addAttribute("resultMsg", resultMsg);
		return "forward:/dlm/vis/VisitMngList.do";
	}

	/**
	 * 퇴실 등록
	 * 
	 * @param visitVO
	 * @param bindingResult
	 * @param levofcTime 
	 * @param searchVO
	 * @param model
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dlm/vis/updateVisitMngExit.do")
	@ResponseBody
	public ModelAndView updateVisitMngExit(@ModelAttribute("visitVO") VisitVO visitVO, 
			BindingResult bindingResult, Model model ,
			@RequestParam("chrgrNo") String chrgrNo ,
			@RequestParam("vstDate") String vstDate) throws Exception {
		String resultMsg    = "";
		VisitVO resultVisiVO = new VisitVO();

		ModelAndView mav = new ModelAndView("jsonView");
		
		try {	
			int iResult = 0;
			iResult = visitService.updateVisitExit(visitVO);
			resultVisiVO = visitService.selectVisit(visitVO);
			resultVisiVO.setLevofcTime(resultVisiVO.getLevofcTime().substring(11,16));
			if(iResult>0) {
				resultMsg = "정상적으로 퇴실 처리되었습니다.";	
			} else{
				resultMsg = "퇴실 실패하였습니다.";
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} 

		mav.addObject("resultMsg", resultMsg);
		mav.addObject("resultVisiVO", resultVisiVO);
    	
    	return mav;
	}
	
	/**
	 * 확인자 사인 등록
	 * @exception Exception
	 */
    @RequestMapping(value="/dlm/vis/updateConfrSign.do")
    public ModelAndView upssateConfrSign(@ModelAttribute("visitVO") VisitVO visitVO)
            throws Exception {
    	String resultMsg = "";
    	ModelAndView mav = new ModelAndView("jsonView");
    	VisitVO resultVisiVO = new VisitVO();
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	
    	// 로그인 사용자만 확인(사인) 저장
    	if(user != null) {
    		try {
    			visitVO.setConfrNm(user.getName());
	    		visitVO.setConfrId(user.getId());
	    		visitService.updateConfrSign(visitVO);
	    		
	    		resultVisiVO = visitService.selectVisit(visitVO);
	    		
    		} catch (Exception e) {
    			LOGGER.error(e.getMessage());
    			resultMsg = "0";
    		}
    		
        	resultMsg = "1";
    	} else {
    		resultMsg = "0";
    	}
    	
    	mav.addObject("resultMsg", resultMsg);
    	mav.addObject("resultVisiVO", resultVisiVO);
    	
    	return mav;
    }
    
    /**
	 * 방문 출입관리 보고서
	 *
	 * @exception Exception
	 */
	@RequestMapping(value = "/dlm/vis/RepoVisitMngList.do")
	public String RepoVisitMngList() throws Exception {
		
		return "/truebon/com/dlm/vis/RepoVisitMngList";
	}
	
    /**
	 * QR출퇴근 및 출입관리 버튼 메인페이지
	 *
	 * @exception Exception
	 */
	@RequestMapping(value ="/dlm/vis/VisitQRMainPage.do")
	public String MainPage() throws Exception {

		return "/truebon/com/dlm/vis/VisitQRMainPage";
	}


}
