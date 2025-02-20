package truebon.com.crm.swm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import truebon.com.crm.swm.model.SwMngVO;
import truebon.com.crm.swm.service.SwMngService;
import truebon.com.opm.biz.model.BizSytmVO;
import truebon.com.opm.biz.service.BizSytmService;
import truebon.com.opm.com.model.ComnCdNewVO;
import truebon.com.opm.com.service.ComnCdNewService;
/**
 * 1. SW전산자원 등록
 * 2. SW전산자원 수정
 * 3. Excel 내보내기
 */

@Controller
public class SwMngController {
	/* Validator */
    @Autowired
    private DefaultBeanValidator beanValidator;
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /** EgovMessageSource */
    @Resource(name = "egovMessageSource")
    
    EgovMessageSource egovMessageSource;
    /** Message ID Generation */
    @Resource(name="egovSwMngIdGnrService")    
    private EgovIdGnrService egovSwMngIdGnrService;
    
    /** 공통코드 Service */
    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
    
	/** 새공통코드 Service */
	@Resource(name = "ComnCdNewService")
	private ComnCdNewService comnCdNewService;

    /** SW자산 목록관리 Service */
    @Resource(name = "SwMngService")
    private SwMngService swMngService;
	
    /** 업무시스템 Service */
	@Resource(name = "BizSytmService")
	private BizSytmService bizSytmService;

    /**
     * SW 전산자원 목록화면 (paging)
     * @param searchVO - 조회할 정보가 담긴 SwMngVO
     * @exception Exception
     */
	@RequestMapping(value = "/crm/swm/SwMngList.do")
	public String SwMngList(@ModelAttribute("SwMngVO") SwMngVO searchVO, ModelMap model) throws Exception {
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
        //searchKeyword 배열로 넣어주기
        if (searchVO.getSearchKeyword() != null && searchVO.getSearchKeyword() != "") {
        	searchVO.setSearchNtwrkCdList(searchVO.getSearchNtwrkCdList()[0].split(","));
        	searchVO.setSearchSwTypeCdList(searchVO.getSearchSwTypeCdList()[0].split(","));
        	searchVO.setSearchAssetStatCdList(searchVO.getSearchAssetStatCdList()[0].split(","));
        	searchVO.setSearchMaintceCdList(searchVO.getSearchMaintceCdList()[0].split(","));
        	searchVO.setSearchMaintceInspCdList(searchVO.getSearchMaintceInspCdList()[0].split(","));
        	//searchVO.setSearchCondition(searchVO.getSearchCondition().replace("&quot;", "''"));
        }
        
        // 목록
        List<SwMngVO> swAssetList = swMngService.selectSwAssetList(searchVO);
        model.addAttribute("resultList", swAssetList);
        model.addAttribute("searchVO", searchVO);
        //네트워크 목록
        ComnCdNewVO vo = new ComnCdNewVO();
        vo.setUpprNewComnCd("ITA02");
        List<?> ntwrkList = comnCdNewService.selectComnCdNewList(vo);
        //자산상태 목록
        ComnCdNewVO vo2 = new ComnCdNewVO();
        vo2.setUpprNewComnCd("ITA03");
        List<?> assetStatList = comnCdNewService.selectComnCdNewList(vo2);
        //자산소유목록
        ComnCdNewVO vo3 = new ComnCdNewVO();
        vo3.setUpprNewComnCd("ITA04");
        List<?> assetOwnList = comnCdNewService.selectComnCdNewList(vo3);
        //유지보수계약 목록
        ComnCdNewVO vo4 = new ComnCdNewVO();
        vo4.setUpprNewComnCd("ITA05");
        List<?> maintceCntrList = comnCdNewService.selectComnCdNewList(vo4);
        //점검주기 목록
        ComnCdNewVO vo5 = new ComnCdNewVO();
        vo5.setUpprNewComnCd("ITA06");
        List<?> maintceInspList = comnCdNewService.selectComnCdNewList(vo5);
        //SW유형코드 목록
        ComnCdNewVO vo7 = new ComnCdNewVO();
        vo7.setUpprNewComnCd("ITA10");
        List<?> swTypeList = comnCdNewService.selectComnCdNewList(vo7);
        // 업무시스템목록
     	BizSytmVO vo6 = new BizSytmVO();
     	vo6.setBizSytmCdLvl("2");
     	List<?> bizSytmList = bizSytmService.selectBizSytmNmList(vo6);
     		
        model.addAttribute("ntwrkList", ntwrkList);
		model.addAttribute("assetStatList", assetStatList);
		model.addAttribute("assetOwnList", assetOwnList);
		model.addAttribute("maintceCntrList", maintceCntrList);
		model.addAttribute("maintceInspList", maintceInspList);
		model.addAttribute("bizSytmList", bizSytmList);
		model.addAttribute("swTypeList", swTypeList);
		
		// 전체 개수
        int totCnt = swMngService.selectSwAssetListTotCnt(searchVO);
        paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "/truebon/com/crm/swm/SwMngList";
	}
	
	/**
	 * SW전산자원 등록화면
	 * 
	 * @param swMngVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/crm/swm/SwMngRegist.do")
	public String SwMngRegist(@ModelAttribute("swMngVO") SwMngVO swMngVO, 
			Model model) throws Exception {
		//저장할 데이터 형식 확인
		model.addAttribute("swMngVO", swMngVO);

		//네트워크 목록
        ComnCdNewVO vo = new ComnCdNewVO();
        vo.setUpprNewComnCd("ITA02");
        List<?> ntwrkList = comnCdNewService.selectComnCdNewList(vo);
        //자산상태 목록
        ComnCdNewVO vo2 = new ComnCdNewVO();
        vo2.setUpprNewComnCd("ITA03");
        List<?> assetStatList = comnCdNewService.selectComnCdNewList(vo2);
        //자산소유목록
        ComnCdNewVO vo3 = new ComnCdNewVO();
        vo3.setUpprNewComnCd("ITA04");
        List<?> assetOwnList = comnCdNewService.selectComnCdNewList(vo3);
        //유지보수계약 목록
        ComnCdNewVO vo4 = new ComnCdNewVO();
        vo4.setUpprNewComnCd("ITA05");
        List<?> maintceCntrList = comnCdNewService.selectComnCdNewList(vo4);
        //점검주기 목록
        ComnCdNewVO vo5 = new ComnCdNewVO();
        vo5.setUpprNewComnCd("ITA06");
        List<?> maintceInspList = comnCdNewService.selectComnCdNewList(vo5);
        //SW유형코드 목록
        ComnCdNewVO vo7 = new ComnCdNewVO();
        vo7.setUpprNewComnCd("ITA10");
        List<?> swTypeList = comnCdNewService.selectComnCdNewList(vo7);
        // 업무시스템목록
     	BizSytmVO vo6 = new BizSytmVO();
     	vo6.setBizSytmCdLvl("2");
     	List<?> bizSytmList = bizSytmService.selectBizSytmNmList(vo6);
     		
        model.addAttribute("ntwrkList", ntwrkList);
		model.addAttribute("assetStatList", assetStatList);
		model.addAttribute("assetOwnList", assetOwnList);
		model.addAttribute("maintceCntrList", maintceCntrList);
		model.addAttribute("maintceInspList", maintceInspList);
		model.addAttribute("bizSytmList", bizSytmList);
		model.addAttribute("swTypeList", swTypeList);
		return "/truebon/com/crm/swm/SwMngRegist";
	}
	
	/**
	 * SW전산자원 등록
	 * 
	 * @param swMngVO
	 * @param bindingResult
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/crm/swm/insertSwMngRegist.do")
	public String insertSwMngRegist(@ModelAttribute("") SwMngVO swMngVO, BindingResult bindingResult,
			Model model) throws Exception {
		String sLocationUrl = "";
		String resultMsg = "";

		// 유효성 검사
		beanValidator.validate(swMngVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "/truebon/com/crm/swm/SwMngRegist";
			return sLocationUrl;
		} else {
			// swAssetId
			swMngVO.setSwAssetId(egovSwMngIdGnrService.getNextStringId());
			swMngVO.setSwAssetId(swMngVO.getSwAssetId());
			swMngService.insertSwAsset(swMngVO);
			resultMsg = egovMessageSource.getMessage("success.common.insert");
			sLocationUrl = "forward:/crm/swm/SwMngList.do";
		}

		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}
	
	/**
	 * SW전산자원 수정화면
	 * 
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/crm/swm/SwMngUpdt.do")
	public String SwMngUpdt(@ModelAttribute("searchVO") SwMngVO searchVO, Model model) throws Exception {
		// 상세정보 조회
		SwMngVO resultVO = swMngService.selectSwAsset(searchVO);
		model.addAttribute("swMngVO", resultVO);

		//네트워크 목록
        ComnCdNewVO vo = new ComnCdNewVO();
        vo.setUpprNewComnCd("ITA02");
        List<?> ntwrkList = comnCdNewService.selectComnCdNewList(vo);
        //자산상태 목록
        ComnCdNewVO vo2 = new ComnCdNewVO();
        vo2.setUpprNewComnCd("ITA03");
        List<?> assetStatList = comnCdNewService.selectComnCdNewList(vo2);
        //자산소유목록
        ComnCdNewVO vo3 = new ComnCdNewVO();
        vo3.setUpprNewComnCd("ITA04");
        List<?> assetOwnList = comnCdNewService.selectComnCdNewList(vo3);
        //유지보수계약 목록
        ComnCdNewVO vo4 = new ComnCdNewVO();
        vo4.setUpprNewComnCd("ITA05");
        List<?> maintceCntrList = comnCdNewService.selectComnCdNewList(vo4);
        //점검주기 목록
        ComnCdNewVO vo5 = new ComnCdNewVO();
        vo5.setUpprNewComnCd("ITA06");
        List<?> maintceInspList = comnCdNewService.selectComnCdNewList(vo5); 
        //SW유형코드 목록
        ComnCdNewVO vo7 = new ComnCdNewVO();
        vo7.setUpprNewComnCd("ITA10");
        List<?> swTypeList = comnCdNewService.selectComnCdNewList(vo7);
        // 업무시스템목록
     	BizSytmVO vo6 = new BizSytmVO();
     	vo6.setBizSytmCdLvl("2");
     	List<?> bizSytmList = bizSytmService.selectBizSytmNmList(vo6);
     		
        model.addAttribute("ntwrkList", ntwrkList);
		model.addAttribute("assetStatList", assetStatList);
		model.addAttribute("assetOwnList", assetOwnList);
		model.addAttribute("maintceCntrList", maintceCntrList);
		model.addAttribute("maintceInspList", maintceInspList);
		model.addAttribute("bizSytmList", bizSytmList);
		model.addAttribute("swTypeList", swTypeList);
		
		return "/truebon/com/crm/swm/SwMngUpdt";
	}
	/**
	 * SW전산자원 수정
	 * 
	 * @param swMngVO
	 * @param searchVO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/crm/swm/updateSwMngUpdt.do")
	public String updateSwMngUpdt(@ModelAttribute("swMngVO") SwMngVO swMngVO, BindingResult bindingResult,
			ModelMap model) throws Exception {
		String sLocationUrl = "";
		String resultMsg = "";
		// 유효성 검사
		beanValidator.validate(swMngVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "/truebon/com/crm/swm/SwMngUpdt";
			return sLocationUrl;
		} else {
			swMngService.updateSwAsset(swMngVO);
			resultMsg = egovMessageSource.getMessage("success.common.update");
			sLocationUrl = "forward:/crm/swm/SwMngList.do";
				}
		model.addAttribute("resultMsg", resultMsg);
		return "forward:/crm/swm/SwMngList.do";
	}
	
	/**
	 * 유지보수 계약코드에 따른 분류
	 * 
	 * @param swMngVO
	 * @param comnCdNewVO
	 * @param bindingResult
	 * @param searchVO
	 * @param model
	 * @param status
	 * @return
	 * @throws Exception
	 */

	@RequestMapping("/crm/swm/SwMaintceType.do")
	@ResponseBody
	public ModelAndView SwMaintceType(@ModelAttribute("ComnCdNewVO") SwMngVO swMngVO, ComnCdNewVO comnCdNewVO,
			BindingResult bindingResult, Model model ,
			@RequestParam("newComnCd") String newComnCd) throws Exception {

		ModelAndView mav = new ModelAndView("jsonView");
		ComnCdNewVO vo = new ComnCdNewVO();
		vo.setUpprNewComnCd("ITA06");// 'ITA06' 유지보수 점검주기 코드, 'ITA05' 유지보수 계약코드
		List<?> swMaintceCycleCdList = comnCdNewService.selectComnCdNewList(vo);
		mav.addObject("swMaintceCycleCdList", swMaintceCycleCdList);
    	
    	return mav;
	}
	
	
	/**
     * SW자산 삭제
     * @param swMngVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/crm/swm/deleteSwMng.do")
    public String deleteSwMng(
            @ModelAttribute("swMngVO") SwMngVO swMngVO,
            ModelMap model)
            throws Exception {
    	String resultMsg    = "";
        
    	swMngService.deleteSwAsset(swMngVO);
    	resultMsg = egovMessageSource.getMessage("success.common.delete");
        
    	model.addAttribute("resultMsg", resultMsg);
        return "forward:/crm/swm/SwMngList.do";
    }

    
    /**
	 * SwMng Excel 
	 * @param SwMngVO - 다운로드할 정보가 담긴 SwMngVO
	 * @exception Exception
	 */
	@RequestMapping("/crm/swm/downloadExcel.do")
	public ModelAndView downloadExcel(HttpServletResponse response
			, HttpServletRequest request
			, @ModelAttribute("swMngVO") SwMngVO swMngVO) throws Exception {

			/** EgovPropertyService.sample */
			swMngVO.setPageUnit(propertiesService.getInt("pageUnit"));
			swMngVO.setPageSize(propertiesService.getInt("pageSize"));
		
			/** paging */
			PaginationInfo paginationInfo = new PaginationInfo();
			paginationInfo.setCurrentPageNo(swMngVO.getPageIndex());
			paginationInfo.setPageSize(swMngVO.getPageSize());
	
			swMngVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
			swMngVO.setLastIndex(paginationInfo.getLastRecordIndex());
		
			ModelAndView mav = new ModelAndView("excelView");
		    Map<String, Object> dataMap = new HashMap<String, Object>();
		    
		    int tot = swMngService.selectSwAssetListTotCnt(swMngVO);
		    swMngVO.setRecordCountPerPage(tot);
		    List<?> swMngEgovMapList = swMngService.selectSwAssetEgovMap(swMngVO);

		    SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd'_'HH:mm:ss");
		    Date date = new Date(System.currentTimeMillis());
		    String dateStr = formatter.format(date);
		  
		    String filename = "SwMng_" + dateStr;
		    String[] columnTitle = {"SW자산ID", "네트워크구분", "업무시스템구분", "SW유형구분", "제품명", "자산상태", "자산소유", "유지보수계약", "점검주기", "제조사", "수량", "삭제여부"}; //
		    String[] columnName = {"swAssetId", "ntwrkDstnctCd", "bizSytmCd", "swTypeCd", "prodNm", "assetStatCd", "assetOwnCd", "maintceCntrCd", "maintceInspCycleCd", "mnftrNm", "prodCoQty", "delYn"}; // 
		  
		    dataMap.put("columnTitle", columnTitle);
		    dataMap.put("columnName", columnName);
		    dataMap.put("sheetNm", "swMng");    
		    dataMap.put("list", swMngEgovMapList);
		    
		    mav.addObject("dataMap", dataMap);
		    mav.addObject("filename", filename);
		    
		    return mav;
	}

}
