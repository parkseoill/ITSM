package truebon.com.opm.fix.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import truebon.com.opm.biz.model.BizSytmVO;
import truebon.com.opm.biz.service.BizSytmService;
import truebon.com.opm.fix.model.FixedInspMngVO;
import truebon.com.opm.fix.service.FixedInspMngService;

/**
 * @Class Name : FixedInspMngController.java
 * @Description : FixedInspMng Controller class
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

public class FixedInspMngController {

	@Autowired
	private DefaultBeanValidator beanValidator;

	/** FailureMng Service */
	@Resource(name = "FixedInspMngService")
	private FixedInspMngService fixedInspMngService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** 업무시스템 Service */
	@Resource(name = "BizSytmService")
	private BizSytmService bizSytmService;

	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/**
	 * 정기점검 목록화면 (paging)
	 * 
	 * @param searchVO - 조회할 정보가 담긴 FixedInspMngVO
	 * @exception Exception
	 */
	@RequestMapping(value = "/opm/fix/FixedInspMngList.do")
	public String FixedInspMngList(@ModelAttribute("searchVO") FixedInspMngVO searchVO, ModelMap model, String sleep)
			throws Exception {
		
		//멀티수정 후 수정보다 조회가 빠른걸 방지
		if(sleep != null) {
			Thread.sleep(500);
		}
		
		// 공통코드NEW(업무시스템)
		BizSytmVO vo7 = new BizSytmVO();
		vo7.setBizSytmCdLvl("2");
		List<?> bizSysmCdList = bizSytmService.selectBizSytmNmList(vo7);
		model.addAttribute("bizSysmCdList", bizSysmCdList);

		/** EgovPropertyService.sample */
		if (searchVO.getPageUnit() != 10) {
			searchVO.setPageUnit(searchVO.getPageUnit());
		} else {
			searchVO.setPageUnit(10);
		}
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		// 페이징
		int totCnt = fixedInspMngService.selectFixedInspListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);

		// 목록
		List<FixedInspMngVO> fixedInpscList = fixedInspMngService.selectFixedInspList(searchVO);
		model.addAttribute("searchVO", searchVO);

		List<FixedInspMngVO> CmpnyList = fixedInspMngService.selectCmpnyList(searchVO);
		
		
		model.addAttribute("fixedInpscList", fixedInpscList);
		model.addAttribute("CmpnyList", CmpnyList);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "/truebon/com/opm/fix/FixedInspMngList";
	}

	/**
	 * 정기점검을 멀티 삭제한다.
	 * 
	 * @param searchVO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/opm/fix/DeleteFixedInspList.do")
	public String DeleteFixedInspList(@ModelAttribute("searchVO") FixedInspMngVO searchVO, ModelMap model)
			throws Exception {

		// 결과 메시지
		String resultMsg = "";

		String[] delFixedInsp = searchVO.getCheckedValueForDel().split(",");

		if (delFixedInsp == null || (delFixedInsp.length == 0)) {
			resultMsg = egovMessageSource.getMessage("fail.common.delete");
		} else {
			fixedInspMngService.deleteFixedInspList(searchVO);
			resultMsg = egovMessageSource.getMessage("success.common.delete");
		}
		model.addAttribute("resultMsg", resultMsg);

		return "forward:/opm/fix/FixedInspMngList.do";
	}

	/**
	 * 정기점검 수정화면
	 * 
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/opm/fix/FixedInspMngUpdt.do")
	public String FixedInspMngUpdt(@ModelAttribute("searchVO") FixedInspMngVO searchVO, ModelMap model)
			throws Exception {
		// 상세정보 조회
		FixedInspMngVO resultVO = fixedInspMngService.selectFixedInsp(searchVO);
		List<FixedInspMngVO> CmpnyList = fixedInspMngService.selectAllCmpnyList(searchVO);

		model.addAttribute("CmpnyList", CmpnyList);
		model.addAttribute("resultVO", resultVO);

		return "/truebon/com/opm/fix/FixedInspMngUpdt";
	}

	/**
	 * 정기점검 수정
	 * 
	 * @param fixedInspMngVO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/opm/fix/updateFixedInspMng.do")
	public String updateFixedInspMng(@ModelAttribute("fixedInspMngVO") FixedInspMngVO fixedInspMngVO,
			BindingResult bindingResult, ModelMap model) throws Exception {

		String sLocationUrl = "";
		String resultMsg = "";

		// 유효성 검사
		beanValidator.validate(fixedInspMngVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "/truebon/com/opm/fix/FixedInspMngUpdt";
			return sLocationUrl;
		} else {
			fixedInspMngService.updateFixedInsp(fixedInspMngVO);
			sLocationUrl = "forward:/opm/fix/FixedInspMngList.do";
			resultMsg = egovMessageSource.getMessage("success.common.update");
		}

		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}

	/**
	 * 정기점검 삭제
	 * 
	 * @param fixedInspMngVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/crm/lcm/deleteFixedInspMng.do")
	public String deleteFixedInspMng(@ModelAttribute("fixedInspMngVO") FixedInspMngVO fixedInspMngVO, ModelMap model)
			throws Exception {

		String resultMsg = "";

		fixedInspMngService.deleteFixedInsp(fixedInspMngVO);
		resultMsg = egovMessageSource.getMessage("success.common.delete");

		model.addAttribute("resultMsg", resultMsg);
		return "forward:/opm/fix/FixedInspMngList.do";
	}

	/**
	 * 멀티 수정 팝업
	 * 
	 * @param FixedInspMngVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/opm/fix/MltplUpdtPopup.do")
	public String MltplUpdtPopup(@ModelAttribute("searchVO") FixedInspMngVO searchVO, ModelMap model) throws Exception {

		model.addAttribute(searchVO);

		return "/truebon/com/opm/fix/MltplUpdtPopup";
	}

	/**
	 * 멀티 수정
	 * 
	 * @param FixedInspMngVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/opm/fix/FixedInspMltplUpdt.do")
	public void  FixedInspMltplUpdt(@ModelAttribute("searchVO") FixedInspMngVO searchVO, ModelMap model) throws Exception {
    	// 결과 메시지
        String resultMsg = "";
        
        String [] updtFixedInsp = searchVO.getCheckedValueForDel().split(",");
        
		if (updtFixedInsp == null || (updtFixedInsp.length ==0)){
    		resultMsg = egovMessageSource.getMessage("fail.common.update");
		}else{
			fixedInspMngService.fixedInspMltplUpdt(searchVO);
			resultMsg = egovMessageSource.getMessage("success.common.update");
		}
		
		model.addAttribute(searchVO);
		model.addAttribute("resultMsg", resultMsg);
		
	}

	/**
	 * 정기점검 현황화면 
	 * @param searchVO - 조회할 정보가 담긴 FixedInspMngVO
	 * @exception Exception
	 */
    @RequestMapping(value="/opm/fix/FixedInspStus.do")
    public String FixedInspStus(@ModelAttribute("searchVO") FixedInspMngVO searchVO, ModelMap model) throws Exception {

    	LocalDate currentdate = LocalDate.now();
		if (searchVO.getSelectedDate() == "") {
			searchVO.setSelectedDate(currentdate.format(DateTimeFormatter.ofPattern("yyyy")));
		}    	
		
		List<FixedInspMngVO> CmpnyList = fixedInspMngService.selectCmpnyList(searchVO);	
		List<Map<String, Object>> fixedInpscStus = fixedInspMngService.selectFixedInspStus(searchVO);
    	
    	List<String> month = new ArrayList<>();
    	List<String> quarter = new ArrayList<>();
    	List<String> half = new ArrayList<>();
    	
        int m=0;
        int q=0;
        int h=0;
        
        //계획 합계, 현황 합계
        int monPlnSum = 0; 
        int monResSum = 0;
        int quarterPlnSum = 0;
        int quarterResSum = 0;
        int halfPlnSum = 0;
        int halfResSum = 0;
        int plnSum = 0;
        int resSum = 0;
        
        //월  현황 
        for(int i = 0; i < 12; i ++) {	        	
        	month.add(m, fixedInpscStus.get(0).get((i+1)+"MON_PLN")+"");	
        	monPlnSum += Integer.parseInt(fixedInpscStus.get(0).get((i+1)+"MON_PLN")+"");
        	plnSum += Integer.parseInt(fixedInpscStus.get(0).get((i+1)+"MON_PLN")+"");
        	m++;
        	month.add(m, fixedInpscStus.get(0).get((i+1)+"MON_RES")+"");
        	monResSum += Integer.parseInt(fixedInpscStus.get(0).get((i+1)+"MON_RES")+"");
        	resSum += Integer.parseInt(fixedInpscStus.get(0).get((i+1)+"MON_RES")+"");
        	m++;
        }       
    	model.addAttribute("month", month);
    	model.addAttribute("monPlnSum", monPlnSum);
    	model.addAttribute("monResSum", monResSum);

    	//분기 현황
        for(int i = 0; i < 4; i ++) {	        	
        	quarter.add(q, fixedInpscStus.get(0).get((i+1)+"QU_PLN")+"");	
        	quarterPlnSum += Integer.parseInt(fixedInpscStus.get(0).get((i+1)+"QU_PLN")+"");
        	plnSum += Integer.parseInt(fixedInpscStus.get(0).get((i+1)+"QU_PLN")+"");
        	q++;
        	quarter.add(q, fixedInpscStus.get(0).get((i+1)+"QU_RES")+"");
        	quarterResSum += Integer.parseInt(fixedInpscStus.get(0).get((i+1)+"QU_RES")+"");
        	resSum += Integer.parseInt(fixedInpscStus.get(0).get((i+1)+"QU_RES")+"");
        	q++;
        }       
    	model.addAttribute("quarter", quarter);
    	model.addAttribute("quarterPlnSum", quarterPlnSum);
    	model.addAttribute("quarterResSum", quarterResSum);

    	//반기 현황 
        for(int i = 0; i < 2; i ++) {	        	
        	half.add(h, fixedInpscStus.get(0).get((i+1)+"HALF_PLN")+"");
        	halfPlnSum += Integer.parseInt(fixedInpscStus.get(0).get((i+1)+"HALF_PLN")+"");
        	plnSum += Integer.parseInt(fixedInpscStus.get(0).get((i+1)+"HALF_PLN")+"");
        	h++;
        	half.add(h, fixedInpscStus.get(0).get((i+1)+"HALF_RES")+"");
        	halfResSum += Integer.parseInt(fixedInpscStus.get(0).get((i+1)+"HALF_RES")+"");
        	resSum += Integer.parseInt(fixedInpscStus.get(0).get((i+1)+"HALF_RES")+"");
        	h++;
        }       

    	model.addAttribute("half", half);
    	model.addAttribute("halfPlnSum", halfPlnSum);
    	model.addAttribute("halfResSum", halfResSum);
    	model.addAttribute("plnSum", plnSum);
    	model.addAttribute("resSum", resSum);
		model.addAttribute("CmpnyList", CmpnyList);
		model.addAttribute("searchVO", searchVO);
		
    	return "/truebon/com/opm/fix/FixedInspStus";
    }
    
	/**
	 * 정기점검 월등록 (paging)
	 * 
	 * @param searchVO - 등록할 정보
	 * @exception Exception
	 */
	@RequestMapping(value = "/opm/fix/InsertFixedInspStus.do")
	public String InsertFixedInspStus(@ModelAttribute("searchVO") FixedInspMngVO searchVO, ModelMap model)
			throws Exception {
		String sLocationUrl = "";
		String resultMsg = "";

		searchVO.setInsertMonth(searchVO.getInsertMonth().replace("-", ""));
		searchVO.setSelectedDate(searchVO.getInsertMonth().substring(0, 4));

		List<Map<String, Object>> fixedInpscStus = fixedInspMngService.selectFixedInspStus(searchVO);

		// 데이터가 없을 경우
		if ((fixedInpscStus.get(0).get((Integer.parseInt(searchVO.getInsertMonth().substring(4, 6))) + "MON_PLN") + "")
				.equals("0")) {

			fixedInspMngService.insertFixedInspStus(searchVO);
			resultMsg = egovMessageSource.getMessage("success.common.insert");

			sLocationUrl = "forward:/opm/fix/FixedInspStus.do";
		} else {
			resultMsg = "이미 생성한 데이터 입니다.";
			model.addAttribute("resultMsg", resultMsg);
			sLocationUrl = "forward:/opm/fix/FixedInspStus.do";
			return sLocationUrl;
		}
		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}

	/**
	 * 정기점검 Excel 다운로드
	 * 
	 * @param FixedInspMngVO - 다운로드할 정보가 담긴 FixedInspMngVO
	 * @exception Exception
	 */
	@RequestMapping("/opm/fix/downloadExcel.do")
	public ModelAndView downloadExcel(HttpServletResponse response, HttpServletRequest request,
			@ModelAttribute("fixedInspMngVO") FixedInspMngVO fixedInspMngVO) throws Exception {
		
		/** EgovPropertyService.sample */
		fixedInspMngVO.setPageUnit(propertiesService.getInt("pageUnit"));
		fixedInspMngVO.setPageSize(propertiesService.getInt("pageSize"));

		/** paging */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(fixedInspMngVO.getPageIndex());
		paginationInfo.setPageSize(fixedInspMngVO.getPageSize());

		fixedInspMngVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		fixedInspMngVO.setLastIndex(paginationInfo.getLastRecordIndex());

		ModelAndView mav = new ModelAndView("excelView");
		Map<String, Object> dataMap = new HashMap<String, Object>();

		int tot = fixedInspMngService.selectFixedInspListTotCnt(fixedInspMngVO);
		fixedInspMngVO.setRecordCountPerPage(tot);
		List<?> fixedInspEgovMapList = fixedInspMngService.selectFixedInspMngEgovMap(fixedInspMngVO);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd'_'HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String dateStr = formatter.format(date);

		String filename = "FixedInspMng_" + dateStr;
		String[] columnTitle = { "자산ID", "장비구분", "점검협력사", "점검주기", "점검여부", "점검일자", "정기점검계획월", "제품명", "제품용도", "업무시스템", "비고내용"};
		String[] columnName = { "assetId", "assetDstnct", "cmpnyNm", "maintceInspCycle", "fixedInspYn", "fixedInspDate", "fixedInspPlnMon", "prodNm", "prodPurp", "bizSytmNm", "rmarkText"};

		dataMap.put("columnTitle", columnTitle);
		dataMap.put("columnName", columnName);
		dataMap.put("sheetNm", "fixedInspMng");
		dataMap.put("list", fixedInspEgovMapList);

		mav.addObject("dataMap", dataMap);
		mav.addObject("filename", filename);

		return mav;
	}
}
