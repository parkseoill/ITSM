package truebon.com.fai.fcs.controller;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.property.EgovPropertyService;
import truebon.com.fai.fcs.model.FailureMngCsVO;
import truebon.com.fai.fcs.service.FailureMngCsService;
import truebon.com.opm.biz.service.BizSytmService;
import truebon.com.opm.com.service.ComnCdNewService;

/**
 * @Class Name : FailureMngCsController.java
 * @Description : FailureMngCs Controller class
 * @Modification Information
 *
 * @author 이미현
 * @since 2023.10.26
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
public class FailureMngCsController {
	
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
	  
	  /** FailureMngCs Service */
	  @Resource(name = "FailureMngCsService")
	  private FailureMngCsService failureMngCsService;
	  
	  
	  
	  
	   /**
	   * 장애관리현황 목록화면 (paging)
	   * @param searchVO - 조회할 정보가 담긴 FailureMngCsVO
	   * @exception Exception
	   */
	  @RequestMapping("/fai/fcs/FailureMngCsList.do")
	  public String FailureMngCsList(@ModelAttribute("FailureMngCsVO") FailureMngCsVO searchVO, ModelMap model) throws Exception {
	   
		//검색창에 현재년도 나타내기  
		int currentYear = Year.now().getValue();
	    if (searchVO.getSearchKeyword() == null || searchVO.getSearchKeyword().isEmpty())
	        searchVO.setSearchKeyword(String.valueOf(currentYear)); 
	    
	    //목록
	    List<FailureMngCsVO> failureMngCsList = failureMngCsService.selectFailureMngCsList(searchVO);
	    model.addAttribute("searchVO", searchVO);
	    model.addAttribute("failureMngCsList", failureMngCsList);
	    
	    return "/truebon/com/fai/fcs/FailureMngCsList";
	  }
	  
	  
	   /**
		* 장애관리현황 Excel 다운로드
		* @param FailureMngCsVO - 다운로드할 정보가 담긴 FailureMngCsVO
		* @exception Exception
		*/
	  @RequestMapping("/fai/fcs/downloadExcel.do")
		public ModelAndView downloadExcel(HttpServletResponse response, HttpServletRequest request, 
				@ModelAttribute("FailureMngCsVO") FailureMngCsVO failureMngCsVO) throws Exception {

				ModelAndView mav = new ModelAndView("excelView");
			    Map<String, Object> dataMap = new HashMap<String, Object>();

			    List<?> failureMngCsEgoMapList = failureMngCsService.selectFailureMngCsEgoMap(failureMngCsVO);
			    
			    SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd'_'HH:mm:ss");
			    Date date = new Date(System.currentTimeMillis());
			    String dateStr = formatter.format(date);

			    String filename = "FailureMngCs_" + dateStr;
			    String[] columnTitle = {"업무시스템", "H/W", "N/W", "S/W", "AP", "외부", "기타"}; 
			    String[] columnName = {"bizSytm", "failrDstnctHw", "failrDstnctNw", "failrDstnctSw", "failrDstnctAp", "failrDstnctOut", "failrDstnctEtc"};

			    dataMap.put("columnTitle", columnTitle);
			    dataMap.put("columnName", columnName);
			    dataMap.put("sheetNm", "FailureMngCs");    
			    dataMap.put("list", failureMngCsEgoMapList);
			    
			    mav.addObject("dataMap", dataMap);
			    mav.addObject("filename", filename);
			    
			    return mav;
		}
}