package truebon.com.crm.csc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.property.EgovPropertyService;
import truebon.com.crm.csc.model.CompuSytmVO;
import truebon.com.crm.csc.service.CompuSytmService;
import truebon.com.opm.biz.service.BizSytmService;
import truebon.com.opm.com.service.ComnCdNewService;

@Controller
public class CompuSytmController {

	
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
	
	/** 전산시스템 Service */
	@Resource(name = "CompuSytmService")
	private CompuSytmService compuSytmService;


	
    /**
     * 전산시스템현황 목록화면 (paging)
     * @param searchVO - 조회할 정보가 담긴 CompuSytmVO
     * @exception Exception
     */
	@RequestMapping("/crm/csc/CompuSytmList.do")
	public String selectSvclifeList(@ModelAttribute("CompuSytmVO") CompuSytmVO searchVO, ModelMap model) throws Exception {
		
		// 현황 
		ComDefaultCodeVO vo1 = new ComDefaultCodeVO();
		vo1.setComnCdId("ITA03");

		List<CmmnDetailCode> assetStatCdList = this.cmmUseService.selectCmmCodeNewDetail(vo1);

		// ITA0304 제외한 목록 (ITA0304=폐기 )
		List<CmmnDetailCode> assetStatCdListExcept = new ArrayList<>();
		for (CmmnDetailCode asset : assetStatCdList) {
		    if (!"ITA0304".equals(asset.getComnCdId())) {
		    	assetStatCdListExcept.add(asset);
		    }
		}
		model.addAttribute("assetStatCdList", assetStatCdListExcept);
	    
		
	    //목록
	    List<CompuSytmVO> compuSytmList = compuSytmService.selectCompuSytmList(searchVO);
	    
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("compuSytmList", compuSytmList);
		
		
		//HW, SW 합계 목록 
		List<CompuSytmVO> compuSytmSumList = compuSytmService.selectCompuSytmSumList(searchVO);

		String hwTypeSum = compuSytmSumList.get(0).getTotalHwTypeSt();
		String swTypeSum = compuSytmSumList.get(0).getSwTypeCountSt();
		
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("hwTypeSum", hwTypeSum);
		model.addAttribute("swTypeSum", swTypeSum);
		
		return "/truebon/com/crm/csc/CompuSytmList";
	}
	
	
	
	/**
	 * 전산시스템현황  Excel 다운로드
	 * 
	 * @param CompuSytmVO - 다운로드할 정보가 담긴 CompuSytmVO
	 * @exception Exception
	 */
	@RequestMapping("/crm/csc/downloadExcel.do")
	public ModelAndView downloadExcel(HttpServletResponse response, HttpServletRequest request, 
			@ModelAttribute("CompuSytmVO") CompuSytmVO compuSytmVO) throws Exception {

		   
			ModelAndView mav = new ModelAndView("excelView");
		    Map<String, Object> dataMap = new HashMap<String, Object>();

		    List<?> compuSytmEgoMapList = compuSytmService.selectCompuSytmEgoMap(compuSytmVO);
		    
		    SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd'_'HH:mm:ss");
		    Date date = new Date(System.currentTimeMillis());
		    String dateStr = formatter.format(date);

		    String filename = "CompuSytm_" + dateStr;
		    String[] columnTitle = {"업무시스템", "서버", "VM", "네트워크", "보안장비", "스토리지", "백업장비", "기반시설", "기타장비", "SW", "총계"}; 
		    String[] columnName = {"bizSytm", "hwTypeServer","vrType","hwTypeNtwrk", "hwTypeSecurity", "hwTypeStorage", "hwTypeBackup","hwTypeBase" ,"hwTypeEtc", "swTypeCount", "totalTypeCount"};

		    dataMap.put("columnTitle", columnTitle);
		    dataMap.put("columnName", columnName);
		    dataMap.put("sheetNm", "CompuSytm");    
		    dataMap.put("list", compuSytmEgoMapList);
		    
		    mav.addObject("dataMap", dataMap);
		    mav.addObject("filename", filename);
		    
		    return mav;
	}
	
}
