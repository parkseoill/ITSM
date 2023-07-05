package truebon.com.cmm.jasper.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import truebon.com.cmm.jasper.model.JasperVO;
import truebon.com.cmm.jasper.service.JasperService;

/**
 * @Class Name : JasperController.java
 * @Description : Jasper Controller class
 * @Modification Information
 *
 * @author 이태신
 * @since 2022.07.15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
public class JasperController {

    /** Jasper Report Service */
    @Resource(name = "JasperService")
    private JasperService jasperService;
	
	/** 로그설정 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JasperController.class);
    
	 /**
	 * Jasper Reports 공통 View Header
	 * @param jasperVO - 조회할 정보가 담긴 JasperVO
	 * @exception Exception
	 */
	@RequestMapping("/cmm/jasper/viewRepoHeader.do")
	public ResponseEntity<byte[]> viewRepoHeader(@ModelAttribute("jasperVO") JasperVO jasperVO)
			throws Exception {		
		
		return jasperService.resultJasperReportHeader(jasperVO);
	}
    
	/**
	 * Jasper Reports 공통 View File
	 * @param jasperVO - 조회할 정보가 담긴 JasperVO
	 * @exception Exception
	 */
	@RequestMapping("/cmm/jasper/viewRepoFile.do")
	public ModelAndView viewRepoFile(@ModelAttribute("jasperVO") JasperVO jasperVO)
			throws Exception {
			
		return jasperService.resultJasperReport(jasperVO);
	}
	
	/**
	 * Jasper Reports 공통 Export File
	 * @param jasperVO - 조회할 정보가 담긴 JasperVO
	 * @exception Exception
	 */
	@RequestMapping("/cmm/jasper/exportRepoFile.do")
	public ResponseEntity<Void> exportRepoFile(@ModelAttribute("jasperVO") JasperVO jasperVO,
			HttpServletResponse response)
			throws Exception {
		
		jasperService.resultJasperReport(jasperVO, response);
		
	    return ResponseEntity.ok().build();
	}
}
