package truebon.com.fai.grd.controller;

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
import truebon.com.crm.swm.model.SwMngVO;
import truebon.com.fai.grd.model.FailGrade;
import truebon.com.fai.grd.model.FailGradeVO;
import truebon.com.fai.grd.service.FailGradeCdService;
import truebon.com.opm.com.model.ComnCdNewVO;
import truebon.com.opm.com.service.ComnCdNewService;
/**
 * @Class Name : FailGradeCdController.java
 * @Description : FailGradeCdController class
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
public class FailGradeCdController {

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	
	@Resource(name = "ComnCdNewService")
	private ComnCdNewService comnCdNewService;

	@Resource(name = "FailGradeCdService")
	private FailGradeCdService failGradeCdService;
	
	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * TB_FAIL_GRADE 목록을 조회한다.
	 * 
	 * @param loginVO
	 * @param searchVO
	 * @param model
	 * @return "truebon/com/fai/grd/GrdMngList"
	 * @throws Exception
	 */
	@RequestMapping(value = "/fai/grd/FailGradeCodeMngList.do")
	public String selectFailGradeCodeMngList(@ModelAttribute("searchVO") FailGradeVO searchVO, ModelMap model) throws Exception {
		
		List<?> GradeList = failGradeCdService.selectFailGradeList(searchVO);
		model.addAttribute("resultList", GradeList);
		System.out.println(GradeList); //for check
		return "/truebon/com/fai/grd/GrdMngList";
	}
	
	/**
	 * 장애등급관리 수정 화면
	 * 
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/fai/grd/GrdUpdt.do")
	public String GrdUpdt(@ModelAttribute("searchVO") FailGradeVO searchVO, Model model) throws Exception {
		FailGradeVO resultVO = failGradeCdService.selectFailGrade(searchVO);
		model.addAttribute("resultVO", resultVO);
		
		//등급 리스트 가져오기
		ComnCdNewVO vo = new ComnCdNewVO();
		List<ComnCdNewVO> gradeList = failGradeCdService.selectGradeList(vo);
		model.addAttribute("gradeList", gradeList);

		return "/truebon/com/fai/grd/GrdUpdt";
	
	}
	/**
	 * 장애등급관리 수정 
	 * 
	 * @param failGradeVO
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/fai/grd/updateGrdUpdt.do")
	public String updateGrdUpdt(@ModelAttribute("failGradeVO") FailGradeVO failGradeVO, BindingResult bindingResult,
			ModelMap model) throws Exception {
		String sLocationUrl = "";
		String resultMsg = "";
		//유효성 검사
		beanValidator.validate(failGradeVO, bindingResult);
		System.out.println(failGradeVO);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "/truebon/com/fai/grd/GrdUpdt";
			return sLocationUrl;
		} else {
			failGradeCdService.updateFailGrade(failGradeVO);
			resultMsg = egovMessageSource.getMessage("success.common.update");
			sLocationUrl = "forward:/fai/grd/FailGradeCodeMngList.do";
				}
		model.addAttribute("resultMsg", resultMsg);
		return "forward:/fai/grd/FailGradeCodeMngList.do";
	}
}
