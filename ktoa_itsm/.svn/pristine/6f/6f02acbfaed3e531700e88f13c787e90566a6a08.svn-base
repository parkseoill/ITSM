package truebon.com.sys.scu.controller;

import java.sql.SQLException;
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
import truebon.com.dlm.dla.controller.DlalzQRController;
import truebon.com.sys.chr.model.Charger;
import truebon.com.sys.chr.service.ChargerService;
import truebon.com.sys.scu.model.SecureVO;
import truebon.com.sys.scu.service.SecureService;

/**
 * @Class Name : SecureController.java
 * @Description : Secure Controller class
 * @Modification Information
 *
 * @author 조경민
 * @since 2022.07.28
 * @version 1.0
 * @see
 * 
 *      Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes(types = Charger.class)
public class SecureController {

	/** 보안점검 Service */
	@Resource(name = "SecureService")
	private SecureService secureService;

	/* Validator */
	@Autowired
	private DefaultBeanValidator beanValidator;

	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    /** 담당자 Service */
    @Resource(name = "ChargerService")
    private ChargerService chargerService;
	
    /** 공통코드 Service */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;
	
	/** 로그설정 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DlalzQRController.class);

	/**
	 * 보안점검 목록화면
	 * 
	 * @param vo - 조회할 정보가 담긴 Secure
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/scu/secure.do")
	public String Secure(@ModelAttribute("vo") SecureVO vo, ModelMap model) throws Exception {
		
		vo.setDateSearch(vo.getDateSearch().replaceAll("-", ""));
		// 목록
		List<SecureVO> secureList = secureService.selectSecureList(vo);
		
		model.addAttribute("secureList", secureList);
		model.addAttribute("vo", vo);
		return "truebon/com/sys/scu/SecureMngList";
	}

	/**
	 * 보안점검 등록 화면
	 * 
	 * @param vo - 조회할 정보가 담긴 Secure
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/scu/SecureMngRegist.do")
	public String SecureMngRegist(@ModelAttribute("secureVO") SecureVO secureVO, BindingResult bindingResult,
			Model model) throws Exception {
		
		secureVO.setDateSearch(secureVO.getDateSearch().replaceAll("-", ""));
		
		ComDefaultCodeVO inspListvo = new ComDefaultCodeVO();
		inspListvo.setComnCdId("ISM012");
		List<?> inspList = cmmUseService.selectCmmCodeDetail(inspListvo);
		ComDefaultCodeVO InspLocatvo = new ComDefaultCodeVO();
		InspLocatvo.setComnCdId("ISM011");
		List<?> InspLocat = cmmUseService.selectCmmCodeDetail(InspLocatvo);
		
		model.addAttribute("InspLocat", InspLocat);
		model.addAttribute("inspList", inspList);
		model.addAttribute("secureVO", secureVO);
		return "truebon/com/sys/scu/SecureMngRegist";
	}

	/**
	 * 보안점검 등록
	 * 
	 * @param secureVO
	 * @param bindingResult
	 * @param model
	 * @return	sLocationUrl
	 * @throws Exception
	 */
	@RequestMapping("/sys/scu/insertSecureMngRegist.do")
	public String insertSecureMngRegist(@ModelAttribute("secureVO") SecureVO secureVO, BindingResult bindingResult,
			Model model) throws Exception {

		secureVO.setInspTime(secureVO.getInspDate() + " " + secureVO.getInspTime());
		secureVO.setInspDate(secureVO.getInspDate().replaceAll("-", ""));
		
		String sLocationUrl = "";
		String resultMsg = "";

		beanValidator.validate(secureVO, bindingResult);
			SecureVO resultVO = secureService.selectSecure(secureVO);
			if(resultVO == null) {// 중복되는 날짜가 없을 때
				if (bindingResult.hasErrors()) {
					sLocationUrl = "truebon/com/sys/scu/SecureMngRegist";
					return sLocationUrl;
				} else {//정상적으로 작동
					secureService.insertSecure(secureVO);
					resultMsg = egovMessageSource.getMessage("success.common.insert");
					sLocationUrl = "forward:/sys/scu/secure.do";
				}
			} else {// 중복되는 날짜가 있을 때
				resultMsg = egovMessageSource.getMessage("common.isExist.msg");
				sLocationUrl = "forward:/sys/scu/secure.do";
				return sLocationUrl;
			}
			model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}
	
	/**
	 * 보안점검 등록 전 오류확인 
	 * 
	 * @param secureVO
	 * @param bindingResult
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/sys/scu/checkSecureMng.do")
	@ResponseBody
	public ModelAndView checkVisitMng(@ModelAttribute("vo") SecureVO vo,
								BindingResult bindingResult,
								@RequestParam("inspDate") String inspDate ,
								@RequestParam("securInspLoacatCd") String securInspLoacatCd	,						
			Model model) throws Exception {
		String resultMsg    = "";

		ModelAndView mav = new ModelAndView("jsonView");

		try {	
			int iResult = 0;
			vo.setInspDate(inspDate);
			vo.setSecurInspLoacatCd(securInspLoacatCd);
			iResult += Math.abs(secureService.selectSecureCnt(vo));
			if(iResult>0) {
				resultMsg = "동일한 일자의 점검 기록이 존재합니다.";	
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
 	 * 보안점검업데이트화면
 	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @param model
 	 * @exception Exception
 	 */
	@RequestMapping(value = "/sys/scu/SecureMngUpdt.do")
	public String SecureMngUpdt(
			@ModelAttribute("secureVO") SecureVO secureVO, 
			Model model) throws Exception {
		
		secureVO.setDateSearch(secureVO.getDateSearch().replaceAll("-", ""));
		secureVO.setInspDate(secureVO.getInspDate().replaceAll("-", ""));
		SecureVO resultVO = secureService.selectSecure(secureVO);
		
		resultVO.setInspTime(resultVO.getInspTime().substring(11, 19));
		resultVO.setDateSearch(secureVO.getDateSearch());
		resultVO.setInspLocatSearch(secureVO.getInspLocatSearch());
		
		ComDefaultCodeVO InspLocatvo = new ComDefaultCodeVO();
		InspLocatvo.setComnCdId("ISM011");
		List<?> InspLocat = cmmUseService.selectCmmCodeDetail(InspLocatvo);
		
		ComDefaultCodeVO inspListvo = new ComDefaultCodeVO();
		inspListvo.setComnCdId("ISM012");
		List<?> inspList = cmmUseService.selectCmmCodeDetail(inspListvo);
		
		model.addAttribute("InspLocat", InspLocat);
		model.addAttribute("inspList", inspList);
		model.addAttribute("vo", resultVO);
			
		return "truebon/com/sys/scu/SecureMngUpdt";
	}
	
	/**
 	 * 보안점검업데이트
 	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @param bindingResult
	 * @param model
 	 * @exception Exception
 	 */
	@RequestMapping(value = "/sys/scu/SecureMngUpdate.do")
	public String SecureMngUpdate(@ModelAttribute("secureVO") SecureVO secureVO,
			BindingResult bindingResult,
			Model model) throws Exception {
		
		
		secureVO.setInspTime(secureVO.getInspDate() + " " + secureVO.getInspTime());
		secureVO.setInspDate(secureVO.getInspDate().replaceAll("-", ""));
		
		String sLocationUrl = "";
		String resultMsg = "";

		beanValidator.validate(secureVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "truebon/com/sys/scu/SecureMngUpdt";
			return sLocationUrl;
		} else {
			secureService.updateSecure(secureVO);
			resultMsg = egovMessageSource.getMessage("success.common.update");
			sLocationUrl = "forward:/sys/scu/secure.do";
		}

		model.addAttribute("resultMsg", resultMsg);
		return "forward:/sys/scu/secure.do";
	}
	
	/**
 	 * 보안점검삭제
 	 * 
 	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @param model
 	 * @exception Exception
 	 */
	@RequestMapping(value = "/sys/scu/deleteSecureMng.do")
	public String deleteSecureMng(@ModelAttribute("secureVO") SecureVO secureVO, ModelMap model) throws Exception {

		String resultMsg = "";

		secureVO.setInspDate(secureVO.getInspDate().replaceAll("-", ""));

		secureService.deleteSecure(secureVO);
		resultMsg = egovMessageSource.getMessage("success.common.delete");

		model.addAttribute("resultMsg", resultMsg);
		return "forward:/sys/scu/secure.do";
	}

	
     
     /**
 	 * 보안점검보고서 (jasper)
 	 * @param searchVO - 조회할 정보가 담긴 VisitVO
 	 * @exception Exception
 	 */
 	@RequestMapping(value = "/sys/scu/RepoSecureMngList.do")
 	public String RepoVisitMngList(@ModelAttribute("secureVO") SecureVO secureVO,
			ModelMap model) throws Exception {
 		
 		return "/truebon/com/sys/scu/RepoSecureMngList";
 	}
     
 	/**
	 * 확인자 사인 등록
	 * @exception Exception
	 */
 	@RequestMapping(value = "/sys/scu/updateConfrSign.do")
 	public ModelAndView updateConfrSign(@ModelAttribute("secureVO") SecureVO secureVO,
									BindingResult bindingResult,
									Model model) throws Exception {
 		secureVO.setInspTime(secureVO.getInspDate() + " " + secureVO.getInspTime());
		secureVO.setInspDate(secureVO.getInspDate().replaceAll("-", ""));
 		String resultMsg = "";
		ModelAndView mav = new ModelAndView("jsonView");
		SecureVO result = new SecureVO();
		// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();

		// 로그인 사용자만 확인(사인) 저장
    	if(user != null) {
    		try {
    			secureVO.setConfrId(user.getChrgrNo());
    			secureVO.setConfrName(user.getName());
	    		secureService.updateConfrSign(secureVO);
	    		result = secureService.selectSecure(secureVO);
    		} catch (Exception e) {
    			LOGGER.error(e.getMessage());
    		}
        	resultMsg = "1";
    	}else {
    		resultMsg = "0";
    	}
    	
		mav.addObject("resultMsg", resultMsg);
    	mav.addObject("result", result);
 		return mav;
 	}
 	
}
