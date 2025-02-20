package truebon.com.fai.prd.controller;

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
import truebon.com.fai.prd.model.FailPeriod;
import truebon.com.fai.prd.model.FailPeriodVO;
import truebon.com.fai.prd.service.FailPeriodCdService;
import truebon.com.opm.biz.model.BizSytmVO;
import truebon.com.opm.biz.service.BizSytmService;
import truebon.com.opm.com.service.ComnCdNewService;
/**
 * @Class Name : FailPeriodCdController.java
 * @Description : FailPeriodCdController class
 * @Modification Information
 *
 * @author 이정하
 * @since 2023.10.26
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
public class FailPeriodCdController {

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	
	/* 공통코드 NEW 서비스 */
	@Resource(name = "ComnCdNewService")
	private ComnCdNewService comnCdNewService;
	
	/* 장애조치기한 서비스 */
	@Resource(name = "FailPeriodCdService")
	private FailPeriodCdService failPeriodCdService;
	
    /** 업무시스템 Service */
	@Resource(name = "BizSytmService")
	private BizSytmService bizSytmService;
	
	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * TB_FAIL_PERIOD 목록을 조회한다.
	 * 
	 * @param loginVO
	 * @param searchVO
	 * @param model
	 * @return "truebon/com/fai/prd/PrdMngList"
	 * @throws Exception
	 */
	@RequestMapping(value = "/fai/prd/FailPeriodCodeMngList.do")
	public String selectFailPeriodCodeMngList(@ModelAttribute("searchVO") FailPeriodVO searchVO, ModelMap model) throws Exception {
		List<?> PeriodList = failPeriodCdService.selectFailPeriodList(searchVO);
		//for문으로 ?
		
		model.addAttribute("resultList", PeriodList);

		return "/truebon/com/fai/prd/PrdMngList";
	}
	/**
	 * 장애조치기간  수정 화면
	 * 
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/fai/prd/PrdUpdt.do")
	public String PrdUpdt(@ModelAttribute("searchVO") FailPeriodVO searchVO, Model model) throws Exception {
		FailPeriodVO resultVO = failPeriodCdService.selectFailPeriod(searchVO);
		model.addAttribute("resultVO", resultVO);
		return "/truebon/com/fai/prd/PrdUpdt";
	
	}
	/**
	 * 장애조치기간 수정 
	 * 
	 * @param failGradeVO
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/fai/prd/updatePrdUpdt.do")
	public String updatePrdUpdt(@ModelAttribute("failPeriodVO") FailPeriodVO failPeriodVO, BindingResult bindingResult,
			ModelMap model) throws Exception {
		String sLocationUrl = "";
		String resultMsg = "";
		//유효성 검사
		beanValidator.validate(failPeriodVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "/truebon/com/fai/prd/PrdUpdt";
			return sLocationUrl;
		} else {
			failPeriodCdService.updateFailPeriod(failPeriodVO);
			resultMsg = egovMessageSource.getMessage("success.common.update");
			sLocationUrl = "forward:/fai/prd/FailPeriodCodeMngList.do";
				}
		model.addAttribute("resultMsg", resultMsg);
		return "forward:/fai/prd/FailPeriodCodeMngList.do";
	}
	
	/**
	 * 장애조치기간 추가 화면
	 * 
	 * @param failPeriodVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/fai/prd/PrdRegist.do")
	public String PrdRegist(@ModelAttribute("failPeriodVO") FailPeriodVO failPeriodVO, Model model) throws Exception {
		//저장할 데이터
		model.addAttribute("failPeriodVO", failPeriodVO);
		//시스템 목록
		// 업무시스템목록
     	BizSytmVO vo = new BizSytmVO();
     	//vo.setBizSytmCdLvl("2");
     	List<?> bizSytmList = failPeriodCdService.selectFailBizSytmList(vo);
		//
     	model.addAttribute("bizSytmList", bizSytmList);
     	
		return "/truebon/com/fai/prd/PrdRegist";
	}
	/**
	 * 장애조치기간 추가
	 * 
	 * @param failPeriodVO
	 * @param bindingResult
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/fai/prd/insertPrdRegist.do")
	public String insertPrdRegist(@ModelAttribute("") FailPeriodVO failPeriodVO, BindingResult bindingResult,
			Model model) throws Exception {
		String sLocationUrl = "";
		String resultMsg = "";
		
		// 유효성 검사
		beanValidator.validate(failPeriodVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "/truebon/com/fai/prd/PrdRegist";
			return sLocationUrl;
		} else {
			// failPeriodVO에서 totalMinutes를 가져와서 배열에 저장
			String totalMinutesStr = failPeriodVO.getCalculatedMinutes();
			String[] totalMinutesStrArray = totalMinutesStr.split(",");
			failPeriodVO.setTotalMinutes(totalMinutesStrArray);
			System.out.println(failPeriodVO);
			failPeriodCdService.insertFailPeriod(failPeriodVO);
			resultMsg = egovMessageSource.getMessage("success.common.insert");
			sLocationUrl = "forward:/fai/prd/FailPeriodCodeMngList.do";
		}

		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}
	
}
