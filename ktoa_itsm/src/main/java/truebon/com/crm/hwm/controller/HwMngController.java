package truebon.com.crm.hwm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import truebon.com.crm.hwm.model.HwMngVO;
import truebon.com.crm.hwm.service.HwMngService;
import truebon.com.opm.biz.model.BizSytmVO;
import truebon.com.opm.biz.service.BizSytmService;
import truebon.com.opm.com.model.ComnCdNewVO;
import truebon.com.opm.com.service.ComnCdNewService;
import truebon.com.sys.chr.model.ChargerVO;
import truebon.com.sys.chr.service.ChargerService;

@Controller
public class HwMngController {

	@Autowired
	private DefaultBeanValidator beanValidator;

	/** 담당자 Service */
	@Resource(name = "ChargerService")
	private ChargerService chargerService;

	/** 공통코드 Service */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	/** 새공통코드 Service */
	@Resource(name = "ComnCdNewService")
	private ComnCdNewService comnCdNewService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/** HWMng Service */
	@Resource(name = "HwMngService")
	private HwMngService hwMngService;

	/** 업무시스템 Service */
	@Resource(name = "BizSytmService")
	private BizSytmService bizSytmService;

	/**
	 * HW 목록화면 (paging)
	 * 
	 * @param HwMngVO - 조회할 정보가 담긴 HwMngVO
	 * @exception Exception
	 */
	@RequestMapping(value = "/crm/hwm/HwMngList.do")
	public String HwMngList(@ModelAttribute("searchVO") HwMngVO searchVO, ModelMap model) throws Exception {

		System.out.println("controller1 = " + searchVO);
		//이스케이프 문자  처리
		if(searchVO.getSearchKeyword1()!=null && searchVO.getSearchKeyword1()!="") {
			if(searchVO.getSearchKeyword1().contains(",")) {
				int idx = searchVO.getSearchKeyword1().indexOf(",");
				searchVO.setSearchKeyword1(searchVO.getSearchKeyword1().substring(0,idx));			
				if (searchVO.getSearchKeyword1().contains("&apos;")) {
					searchVO.setSearchKeyword1(searchVO.getSearchKeyword1().replaceAll("&apos;", "'"));
					searchVO.setSearchList1(searchVO.getSearchKeyword1());
				}
			}					
		}
		if(searchVO.getSearchKeyword8()!=null && searchVO.getSearchKeyword8()!="") {
			if(searchVO.getSearchKeyword8().contains(",")) {
				int idx = searchVO.getSearchKeyword8().indexOf(",");
				searchVO.setSearchKeyword8(searchVO.getSearchKeyword8().substring(0,idx));			
				if (searchVO.getSearchKeyword8().contains("&apos;")) {
					searchVO.setSearchKeyword8(searchVO.getSearchKeyword8().replaceAll("&apos;", "'"));
					searchVO.setSearchList2(searchVO.getSearchKeyword8());
				}
			}
		}
		if(searchVO.getSearchKeyword4()!=null && searchVO.getSearchKeyword4()!="") {
			if(searchVO.getSearchKeyword4().contains(",")) {
				int idx = searchVO.getSearchKeyword4().indexOf(",");
				searchVO.setSearchKeyword4(searchVO.getSearchKeyword4().substring(0,idx));			
				if (searchVO.getSearchKeyword4().contains("&apos;")) {
					searchVO.setSearchKeyword4(searchVO.getSearchKeyword4().replaceAll("&apos;", "'"));
					searchVO.setSearchList3(searchVO.getSearchKeyword4());
				}
			}
		}
		
		//검색 초기값 설정
		if(searchVO.getSearchKeyword7()==null) {
			searchVO.setSearchKeyword7("ITA0101");
		}
		if(searchVO.getSearchKeyword3()==null) {
			searchVO.setSearchKeyword3("ITA0302");
		}
		System.out.println("controller2 = " + searchVO);
		// 공통코드NEW(네트워크)
		ComDefaultCodeVO vo1 = new ComDefaultCodeVO();
		vo1.setComnCdId("ITA02");
		List<CmmnDetailCode> ntwrkCdList = cmmUseService.selectCmmCodeNewDetail(vo1);
		model.addAttribute("ntwrkCdList", ntwrkCdList);

		// 공통코드NEW(HW유형)
		ComDefaultCodeVO vo2 = new ComDefaultCodeVO();
		vo2.setComnCdId("ITA09");
		vo2.setDetailCondition("2");
		List<CmmnDetailCode> hwTypeCdList = cmmUseService.selectCmmCodeNewDetail(vo2);
		model.addAttribute("hwTypeCdList", hwTypeCdList);

		// 공통코드NEW(자산상태)
		ComDefaultCodeVO vo3 = new ComDefaultCodeVO();
		vo3.setComnCdId("ITA03");
		List<CmmnDetailCode> assetStatCdList = cmmUseService.selectCmmCodeNewDetail(vo3);
		model.addAttribute("assetStatCdList", assetStatCdList);

		// 공통코드NEW(업무시스템)
		BizSytmVO vo4 = new BizSytmVO();
		vo4.setBizSytmCdLvl("2");
		List<?> bizSysmCdList = bizSytmService.selectBizSytmNmList(vo4);
		model.addAttribute("bizSysmCdList", bizSysmCdList);

		// 공통코드NEW(가상화구분)
		ComDefaultCodeVO vo5 = new ComDefaultCodeVO();
		vo5.setComnCdId("ITA01");
		List<CmmnDetailCode> vrtlzDstnctCdList = cmmUseService.selectCmmCodeNewDetail(vo5);
		model.addAttribute("vrtlzDstnctCdList", vrtlzDstnctCdList);	
		
		// 공통코드NEW(자산소유)
		ComDefaultCodeVO vo6 = new ComDefaultCodeVO();
		vo6.setComnCdId("ITA04");
		List<CmmnDetailCode> assetOwnCdList = cmmUseService.selectCmmCodeNewDetail(vo6);
		model.addAttribute("assetOwnCdList", assetOwnCdList);	
				
		/** EgovPropertyService.sample */
		if(searchVO.getPageUnit()!=10) {			
			searchVO.setPageUnit(searchVO.getPageUnit());
		}else {
			searchVO.setPageUnit(10);
		}
		
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** paging */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = hwMngService.selectHwMngListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		List<HwMngVO> hwMngList = hwMngService.selectHwMngList(searchVO);		
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("hwMngList", hwMngList);
		
		return "/truebon/com/crm/hwm/HwMngList";
	}

	/**
	 * HW 수정화면 (paging)
	 * 
	 * @param HwMngVO - 조회할 정보가 담긴 HwMngVO
	 * @exception Exception
	 */
	@RequestMapping(value = "/crm/hwm/HwMngDetail.do")
	public String HwMngDetail(@ModelAttribute("searchVO") HwMngVO searchVO, ModelMap model) throws Exception {
		
		// 공통코드NEW(네트워크)
		ComDefaultCodeVO vo1 = new ComDefaultCodeVO();
		vo1.setComnCdId("ITA02");
		List<CmmnDetailCode> ntwrkCdList = cmmUseService.selectCmmCodeNewDetail(vo1);
		model.addAttribute("ntwrkCdList", ntwrkCdList);

		// 공통코드NEW(HW유형)
		ComDefaultCodeVO vo2 = new ComDefaultCodeVO();
		vo2.setComnCdId("ITA09");
		vo2.setDetailCondition("2");
		List<CmmnDetailCode> hwTypeCdList = cmmUseService.selectCmmCodeNewDetail(vo2);
		model.addAttribute("hwTypeCdList", hwTypeCdList);

		// 공통코드NEW(자산상태)
		ComDefaultCodeVO vo3 = new ComDefaultCodeVO();
		vo3.setComnCdId("ITA03");
		List<CmmnDetailCode> assetStatCdList = cmmUseService.selectCmmCodeNewDetail(vo3);
		model.addAttribute("assetStatCdList", assetStatCdList);

		// 공통코드NEW(업무시스템)
		BizSytmVO vo4 = new BizSytmVO();
		vo4.setBizSytmCdLvl("2");
		List<?> bizSysmCdList = bizSytmService.selectBizSytmNmList(vo4);
		model.addAttribute("bizSysmCdList", bizSysmCdList);

		// 공통코드NEW(가상화구분코드)
		ComDefaultCodeVO vo5 = new ComDefaultCodeVO();
		vo5.setComnCdId("ITA01");
		List<CmmnDetailCode> vrtlzDstnctCdList = cmmUseService.selectCmmCodeNewDetail(vo5);
		model.addAttribute("vrtlzDstnctCdList", vrtlzDstnctCdList);

		// 공통코드NEW(HW상세)
		ComDefaultCodeVO vo6 = new ComDefaultCodeVO();
		vo6.setComnCdId("ITA09");
		vo6.setDetailCondition("3");
		List<CmmnDetailCode> hwTypeDetailCdList = cmmUseService.selectCmmCodeNewDetail(vo6);
		model.addAttribute("hwTypeDetailCdList", hwTypeDetailCdList);

		// 공통코드NEW(가상화 유형코드)
		ComDefaultCodeVO vo7 = new ComDefaultCodeVO();
		vo7.setComnCdId("ITA08");
		List<CmmnDetailCode> vrtlzTypeCdList = cmmUseService.selectCmmCodeNewDetail(vo7);
		model.addAttribute("vrtlzTypeCdList", vrtlzTypeCdList);

		// 공통코드NEW(자산소유)
		ComDefaultCodeVO vo8 = new ComDefaultCodeVO();
		vo8.setComnCdId("ITA04");
		List<CmmnDetailCode> assetOwnCd = cmmUseService.selectCmmCodeNewDetail(vo8);
		model.addAttribute("assetOwnCd", assetOwnCd);

		// 공통코드NEW(유지보수계약)
		ComDefaultCodeVO vo10 = new ComDefaultCodeVO();
		vo10.setComnCdId("ITA05");
		List<CmmnDetailCode> maintceCntrCd = cmmUseService.selectCmmCodeNewDetail(vo10);
		model.addAttribute("maintceCntrCd", maintceCntrCd);

		// 공통코드NEW(유지보수점검주기)
		ComDefaultCodeVO vo11 = new ComDefaultCodeVO();
		vo11.setComnCdId("ITA06");
		List<CmmnDetailCode> maintceInspCycleCd = cmmUseService.selectCmmCodeNewDetail(vo11);
		model.addAttribute("maintceInspCycleCd", maintceInspCycleCd);

		HwMngVO result = hwMngService.selectHwMng(searchVO);
		model.addAttribute("result", result);
		model.addAttribute("searchVO", searchVO);
		
		return "/truebon/com/crm/hwm/HwMngUpdt";
	}

	/**
	 * HW 수정
	 * 
	 * @param HwMngVO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/crm/hwm/HwMngUpdt.do")
	public String HwMngUpdt(@ModelAttribute("hwMngVO") HwMngVO hwMngVO, String chngCheck, ModelMap model, BindingResult bindingResult)
			throws Exception {
		String sLocationUrl = "";
		String resultMsg = "";
		
		// 유효성 검사
		beanValidator.validate(hwMngVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "/truebon/com/crm/hwm/HwMngUpdt";
			return sLocationUrl;
		} else {
			//이력 내용 입력시 
			if(!chngCheck.equals("")) {
				hwMngService.registHwHstry(hwMngVO);
			}	 
			hwMngService.updateHwMng(hwMngVO);
			resultMsg = egovMessageSource.getMessage("success.common.update");
			sLocationUrl = "forward:/crm/hwm/HwMngList.do";
		}
		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}

	/**
	 * HW 등록화면 (paging)
	 * 
	 * @param HwMngVO - 조회할 정보가 담긴 HwMngVO
	 * @exception Exception
	 */
	@RequestMapping(value = "/crm/hwm/HwMngRegistDetail.do")
	public String HwMngRegistDetail(@ModelAttribute("searchVO") HwMngVO searchVO, ModelMap model) throws Exception {
	
		// 공통코드NEW(네트워크)
		ComDefaultCodeVO vo1 = new ComDefaultCodeVO();
		vo1.setComnCdId("ITA02");
		List<CmmnDetailCode> ntwrkCdList = cmmUseService.selectCmmCodeNewDetail(vo1);
		model.addAttribute("ntwrkCdList", ntwrkCdList);

		// 공통코드NEW(HW유형)
		ComDefaultCodeVO vo2 = new ComDefaultCodeVO();
		vo2.setComnCdId("ITA09");
		vo2.setDetailCondition("2");
		List<CmmnDetailCode> hwTypeCdList = cmmUseService.selectCmmCodeNewDetail(vo2);
		model.addAttribute("hwTypeCdList", hwTypeCdList);

		// 공통코드NEW(자산상태)
		ComDefaultCodeVO vo3 = new ComDefaultCodeVO();
		vo3.setComnCdId("ITA03");
		List<CmmnDetailCode> assetStatCdList = cmmUseService.selectCmmCodeNewDetail(vo3);
		model.addAttribute("assetStatCdList", assetStatCdList);

		// 공통코드NEW(업무시스템)
		BizSytmVO vo4 = new BizSytmVO();
		vo4.setBizSytmCdLvl("2");
		List<?> bizSysmCdList = bizSytmService.selectBizSytmNmList(vo4);
		model.addAttribute("bizSysmCdList", bizSysmCdList);

		// 공통코드NEW(가상화구분코드)
		ComDefaultCodeVO vo5 = new ComDefaultCodeVO();
		vo5.setComnCdId("ITA01");
		List<CmmnDetailCode> vrtlzDstnctCdList = cmmUseService.selectCmmCodeNewDetail(vo5);
		model.addAttribute("vrtlzDstnctCdList", vrtlzDstnctCdList);

		// 공통코드NEW(HW상세)
		ComDefaultCodeVO vo6 = new ComDefaultCodeVO();
		vo6.setComnCdId("ITA09");
		vo6.setDetailCondition("3");
		List<CmmnDetailCode> hwTypeDetailCdList = cmmUseService.selectCmmCodeNewDetail(vo6);
		model.addAttribute("hwTypeDetailCdList", hwTypeDetailCdList);

		// 공통코드NEW(가상화 유형코드)
		ComDefaultCodeVO vo7 = new ComDefaultCodeVO();
		vo7.setComnCdId("ITA08");
		List<CmmnDetailCode> vrtlzTypeCdList = cmmUseService.selectCmmCodeNewDetail(vo7);
		model.addAttribute("vrtlzTypeCdList", vrtlzTypeCdList);

		// 공통코드NEW(자산소유)
		ComDefaultCodeVO vo8 = new ComDefaultCodeVO();
		vo8.setComnCdId("ITA04");
		List<CmmnDetailCode> assetOwnCd = cmmUseService.selectCmmCodeNewDetail(vo8);
		model.addAttribute("assetOwnCd", assetOwnCd);

		// 공통코드NEW(유지보수계약)
		ComDefaultCodeVO vo10 = new ComDefaultCodeVO();
		vo10.setComnCdId("ITA05");
		List<CmmnDetailCode> maintceCntrCd = cmmUseService.selectCmmCodeNewDetail(vo10);
		model.addAttribute("maintceCntrCd", maintceCntrCd);

		// 공통코드NEW(유지보수점검주기)
		ComDefaultCodeVO vo11 = new ComDefaultCodeVO();
		vo11.setComnCdId("ITA06");
		List<CmmnDetailCode> maintceInspCycleCd = cmmUseService.selectCmmCodeNewDetail(vo11);
		model.addAttribute("maintceInspCycleCd", maintceInspCycleCd);

		model.addAttribute("searchVO", searchVO);
		model.addAttribute("pageIndex",searchVO.getPageIndex());

		return "/truebon/com/crm/hwm/HwMngRegist";
	}

	/**
	 * HW 등록
	 * 
	 * @param HwMngVO
	 * @param hwMngVO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/crm/hwm/HwMngRegist.do")
	public String HwMngRegist(@ModelAttribute("hwMngVO") HwMngVO hwMngVO, BindingResult bindingResult, ModelMap model)
			throws Exception {
		String sLocationUrl = "";
		String resultMsg = "";
		// 유효성 검사
		beanValidator.validate(hwMngVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "/truebon/com/crm/hwm/HwMngRegist";
			return sLocationUrl;
		} else {
			hwMngService.registHwMng(hwMngVO);
			resultMsg = egovMessageSource.getMessage("success.common.insert");
			sLocationUrl = "forward:/crm/hwm/HwMngList.do";
		}
		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}

	/**
	 * 회사, 부서 조회 팝업
	 * 
	 * @param deptManageVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/crm/hwm/HwMngPopupUser.do")
	public String ChargerMngListPopup(@ModelAttribute("searchVO") ChargerVO searchVO, ModelMap model) throws Exception {

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
		List<ChargerVO> chargerList = chargerService.selectChargerSwList(searchVO);
		model.addAttribute("resultList", chargerList);
		model.addAttribute("searchVO", searchVO);

		int totCnt = chargerService.selectChargerListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/truebon/com/crm/hwm/HwMngPopupUser";
	}

	/**
	 * 이력 조회 팝업
	 * 
	 * @param HwMngVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/crm/hwm/HwMngPopupHstry.do")
	public String HwMngPopupHstry(@ModelAttribute("searchVO") HwMngVO searchVO, ModelMap model) throws Exception { 
		
		List<HwMngVO> hstryList = hwMngService.selectHwPopUpHstryList(searchVO);
		model.addAttribute("hstryList", hstryList);
		
		return "/truebon/com/crm/hwm/HwMngPopupHstry";
	}
	
	/**
	 * 이력 상세 조회 팝업
	 * 
	 * @param HwMngVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/crm/hwm/HwMngPopupHstryDetail.do")
	public String HwMngPopupHstryDetail(@ModelAttribute("searchVO") HwMngVO searchVO, ModelMap model) throws Exception {
		
		HwMngVO hwHstry  = hwMngService.selectHwPopUpHstry(searchVO);
		model.addAttribute("hwHstry", hwHstry);
		
		return "/truebon/com/crm/hwm/HwMngPopupHstryDetail";
	}
	
	/**
	 * 팝업 상위 HW ID HW 목록 화면 (HW전산자원 관리)
	 * 
	 * @param searchVO - 조회할 정보가 담긴 HwMngVO
	 * @exception Exception
	 */
	@RequestMapping(value = "/crm/hwm/HwMngHwPopup.do")
	public String HwMngHwPopup(@ModelAttribute("searchVO") HwMngVO searchVO, ModelMap model) throws Exception {
		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** paging */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		// 목록
		List<HwMngVO> hwList = hwMngService.selectHwPopUpMngList(searchVO);
		model.addAttribute("resultList", hwList);
		model.addAttribute("searchVO", searchVO);

		int totCnt = hwMngService.selectHwPopUpMngListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/truebon/com/crm/hwm/HwMngHwPopup";

	}

	/**
	 * 팝업 어플라이언스HW 목록 화면 (SW전산자원 관리)
	 * 
	 * @param searchVO - 조회할 정보가 담긴 HwMngVO
	 * @exception Exception
	 */
	@RequestMapping(value = "/crm/swm/SwMngHwPopup.do")
	public String SwMngHwPopup(@ModelAttribute("searchVO") HwMngVO searchVO, ModelMap model) throws Exception {
		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** paging */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		// 목록
		List<HwMngVO> hwList = hwMngService.selectAppliHwMngList(searchVO);
		model.addAttribute("resultList", hwList);
		model.addAttribute("searchVO", searchVO);

		int totCnt = hwMngService.selectAppliHwMngListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/truebon/com/crm/swm/SwMngHwPopup";
	}

	/**
	 * HW 유형 선택에 따른 HW 유형 상세 조회
	 * 
	 * @param hwMngVO
	 * @param comnCdNewVO
	 * @param bindingResult
	 * @param searchVO
	 * @param model
	 * @param status
	 * @return
	 * @throws Exception
	 */

	@RequestMapping("/crm/swm/HwType.do")
	@ResponseBody
	public ModelAndView HwType(@ModelAttribute("searchVO") HwMngVO hwMngVO, ComnCdNewVO comnCdNewVO,
			BindingResult bindingResult, Model model, @RequestParam("newComnCd") String newComnCd) throws Exception {

		ModelAndView mav = new ModelAndView("jsonView");

		ComnCdNewVO vo = new ComnCdNewVO();
		vo.setUpprNewComnCd(newComnCd);
		List<?> hwTypeDtlList = comnCdNewService.selectComnCdNewList(vo);
		
		mav.addObject("hwTypeDtlList", hwTypeDtlList);

		return mav;
	}

	/**
	 * HW Excel 다운로드
	 * 
	 * @param HwMngVO - 다운로드할 정보가 담긴 HwMngVO
	 * @exception Exception
	 */
	@RequestMapping("/crm/hwm/downloadExcel.do")
	public ModelAndView downloadExcel(HttpServletResponse response, HttpServletRequest request,
			@ModelAttribute("hwMngVO") HwMngVO hwMngVO) throws Exception {
		/** EgovPropertyService.sample */
		hwMngVO.setPageUnit(propertiesService.getInt("pageUnit"));
		hwMngVO.setPageSize(propertiesService.getInt("pageSize"));
		System.out.println("controller = " + hwMngVO);
		/** paging */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(hwMngVO.getPageIndex());
		paginationInfo.setPageSize(hwMngVO.getPageSize());

		hwMngVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		hwMngVO.setLastIndex(paginationInfo.getLastRecordIndex());

		ModelAndView mav = new ModelAndView("excelView");
		Map<String, Object> dataMap = new HashMap<String, Object>();

		List<?> lcnEgovMapList = hwMngService.selectHwMngEgovMap(hwMngVO);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd'_'HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String dateStr = formatter.format(date);

		String filename = "HwMng_" + dateStr;
		String[] columnTitle = { "HW자산ID", "가상화 구분", "HW유형", "HW유형상세", "가상화 유형", "상위 HW자산 ID", "네트워크구분", "업무시스템",
				"자산소유", "자산상태", "어플라이언스 여부", "관제여부", "제품 용도", "서비스이중화구성 여부", "제품 수량", "제품 위치", "유지보수 계약", "유지보수 점검 주기",
				"유지보수 계약 시작일자", "유지보수 계약 종료일자", "유지보수 담당자 번호", "KTOA 자산 번호", "제조사명", "제품명", "호스트명", "EOSL 일자", "입고 날짜",
				"검수 날짜", "시리얼 넘버", "정전 보상 시간", "IP 주소", "삭제 여부", "이중화 내용", "OS 내용", "메모리 내용", "디스크 내용", "CPU 내용",
				"비고 내용", "변경내용", "유효시작일", "유효종료일", "최대소요전력", "소비전력"};
		String[] columnName = { "hwAssetId", "vrtlzDstnct", "hwType", "hwTypeDtl", "vrtlzType", "upprHwAssetId",
				"ntwrkDstnct", "bizSytm", "assetOwn", "assetStat", "appliYn", "ctrlYn", "prodPurp", "svcDupCnvrConfgYn",
				"excelProdCoQty", "prodlocat", "maintceCntr", "maintceInspCycle", "maintceCntrBeginDate",
				"maintceCntrEndDate", "maintceChrgrNo", "ktoaAssetNo", "mnftrNm", "prodNm", "hostNm", "eoslDate",
				"entrngDate", "exanDate", "serialno", "blcktRwrdTime", "ipAddr", "delYn", "dplctText", "osText",
				"mmryText", "diskText", "cpuText", "rmarkText","chngText", "avlblBeginDate" ,"avlblEndDate", "maxPowerRequired", "powerConsumption" };

		dataMap.put("columnTitle", columnTitle);
		dataMap.put("columnName", columnName);
		dataMap.put("sheetNm", "hwMng");
		dataMap.put("list", lcnEgovMapList);

		mav.addObject("dataMap", dataMap);
		mav.addObject("filename", filename);

		return mav;
	}
}