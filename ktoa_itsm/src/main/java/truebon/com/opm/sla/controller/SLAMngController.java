package truebon.com.opm.sla.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import truebon.com.dlm.wrk.service.WorkService;
import truebon.com.opm.sla.ExcelRequestManager;
import truebon.com.opm.sla.model.SLAMngVO;
import truebon.com.opm.sla.service.SLAMngService;

/**
 * @Class Name : SLAMngController.java
 * @Description : SLAMng Controller class
 * @Modification Information
 *
 * @author 김승현
 * @since 2023.08.07
 * @version 1.0
 * @see
 * 
 *      Copyright (C) All right reserved.
 */

@Controller

public class SLAMngController {

	
	/** 근무 Service */
	@Resource(name = "SLAMngService")
	private SLAMngService slaMngService;
	
	/**
	 * SLA 목록화면 (paging)
	 * 
	 * @param searchVO - 조회할 정보가 담긴 SLAMngVO
	 * @exception Exception
	 */
	@RequestMapping("/opm/sla/SLAMngList.do")
	public String SLAMngList(@ModelAttribute("SLAMngVO") SLAMngVO SLAMngVO, ModelMap model) throws Exception {

		return "/truebon/com/opm/sla/SLAMngList";
	}
	
	
	/**
	 * EXCEL 데이터 DB에 넣기
	 */
	@RequestMapping(value = "/opm/sla/SLAMngList2.do", method = RequestMethod.POST)
	public String SLAMngList2(@ModelAttribute("searchVO") SLAMngVO searchVO, RedirectAttributes redirectAttributes,
			HttpServletRequest request, final MultipartHttpServletRequest multiRequest, ModelMap model)
			throws Exception {

		ExcelRequestManager em = new ExcelRequestManager();
		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		List<HashMap<String, String>> apply = null;

		apply = em.parseExcelSpringMultiPart(files, "applicant", 0, "", "reserve");

		for (int i = 0; i < apply.size(); i++) {
			searchVO.setType1(apply.get(i).get("cell_0"));
			searchVO.setType2(apply.get(i).get("cell_1"));
			searchVO.setType3(apply.get(i).get("cell_2"));
			searchVO.setType4(apply.get(i).get("cell_3"));
			
			slaMngService.insertExcel(searchVO);
			
			System.out.println(apply.get(i).get("cell_0"));
			System.out.println(apply.get(i).get("cell_1"));
			System.out.println(apply.get(i).get("cell_2"));
			System.out.println(apply.get(i).get("cell_3"));
		}

		return "/truebon/com/opm/sla/SLAMngList";
	}



	/**
	 * SLA관리 대장 	
	 * 
	 * @param SLAMngVO
	 * @param SLAMngVO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/opm/sla/SLAReport.do")
	public String SLAReport(@ModelAttribute("SLAMngVO") SLAMngVO SLAMngVO, ModelMap model) throws Exception {

		return "/truebon/com/opm/sla/SLAReport";
	}

}
