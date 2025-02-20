package truebon.com.crm.lcm.controller;

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

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import truebon.com.crm.lcm.model.LcnVO;
import truebon.com.crm.lcm.service.LcnService;
import truebon.com.sys.chr.model.ChargerVO;

@Controller
public class LcnMngController {

	/* Validator */
	@Autowired
	private DefaultBeanValidator beanValidator;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/* 라이센스 Service */
	@Resource(name = "LcnService")
	private LcnService lcnService;

	/**
	 * 라이센스 목록화면 (paging)
	 * 
	 * @param LcnVO - 조회할 정보가 담긴 LcnMngVO
	 * @exception Exception
	 */
	@RequestMapping(value = "/crm/lcm/LcnMngList.do")
	public String LcnMngList(@ModelAttribute("searchVO") LcnVO searchVO, ModelMap model) throws Exception {
		
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

		// 라이센스 목록 조회
		List<LcnVO> lcnList = lcnService.selectLcnList(searchVO);

		// 페이징
		int totCnt = lcnService.selectLcnListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);

		model.addAttribute("lcnList", lcnList);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/truebon/com/crm/lcm/LcnMngList";
	}

	/**
	 * 라이센스 등록화면
	 * 
	 * @param LcnVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/crm/lcm/LcnMngRegist.do")
	public String LcnMngRegist(@ModelAttribute("lcnVO") LcnVO lcnVO, ModelMap model) throws Exception {
		return "/truebon/com/crm/lcm/LcnMngRegist";
	}

	/**
	 * 라이센스 등록
	 * 
	 * @param LcnVO
	 * @param bindingResult
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/crm/lcm/inseartLcnMngRegist.do")
	public String inseartLcnMngRegist(@ModelAttribute("lcnVO") LcnVO lcnVO, BindingResult bindingResult, Model model)
			throws Exception {

		String resultMsg = "";
		String sLocationUrl = "";

		// 유효성 검사
		beanValidator.validate(lcnVO, bindingResult);
		if (bindingResult.hasErrors()) {
			sLocationUrl = "/truebon/com/crm/lcm/LcnMngRegist";
			return sLocationUrl;
		} else {
			lcnService.insertLcn(lcnVO);
			resultMsg = egovMessageSource.getMessage("success.common.insert");
			sLocationUrl = "forward:/crm/lcm/LcnMngList.do";
		}

		model.addAttribute("resultMsg", resultMsg);
		return sLocationUrl;
	}
	
    /**
     * 라이센스 수정화면
     * @param searchVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/crm/lcm/LcnMngUpdt.do")
    public String LcnMngUpdt(@ModelAttribute("searchVO") LcnVO searchVO, Model model) throws Exception {
		// 상세정보 조회
    	LcnVO resultVO = lcnService.selectLcn(searchVO);
    	
        model.addAttribute("lcnVO", resultVO);
        
        return "/truebon/com/crm/lcm/LcnMngUpdt";
    }
    
    
    
    /**
     * 라이센스 수정
     * @param lcnVO
     * @param searchVO
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping("/crm/lcm/updateLcnMngUpdt.do")
    public String updateLcnMngUpdt(@ModelAttribute("lcnVO") LcnVO lcnVO, BindingResult bindingResult, ModelMap model) throws Exception {
    	
    	String sLocationUrl = "";
    	String resultMsg    = "";
    	
    	// 유효성 검사
    	beanValidator.validate(lcnVO, bindingResult);
    	if (bindingResult.hasErrors()){
			sLocationUrl = "/truebon/com/crm/lcm/LcnMngUpdt";
			return sLocationUrl;
		}else {
			lcnService.updateLcn(lcnVO);
			sLocationUrl = "forward:/crm/lcm/LcnMngList.do";
			resultMsg = egovMessageSource.getMessage("success.common.update");
		}
    	
    	model.addAttribute("resultMsg", resultMsg);
        return sLocationUrl;
    }
    
    /**
     * 라이센스 삭제
     * @param lcnVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/crm/lcm/deleteLcnMng.do")
    public String deleteLcnMng(@ModelAttribute("lcnVO") LcnVO lcnVO,ModelMap model)throws Exception {
    	
    	String resultMsg    = "";
    	
    	lcnService.deleteLcn(lcnVO);
    	resultMsg = egovMessageSource.getMessage("success.common.delete");
        
    	model.addAttribute("resultMsg", resultMsg);
        return "forward:/crm/lcm/LcnMngList.do";
    }
    
    /**
     * 라이센스목록 멀티 삭제
     * @param searchVO
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping("/crm/lcm/deleteLcnMngList.do")
    public String deleteLcnMngList(@ModelAttribute("searchVO") LcnVO searchVO, ModelMap model) throws Exception {
    	
    	// 결과 메시지
        String resultMsg    = "";
        String [] delLcnId = searchVO.getCheckedValueForDel().split(",");
        
		if (delLcnId == null || (delLcnId.length ==0)){
    		resultMsg = egovMessageSource.getMessage("fail.common.delete");
		}else{
			lcnService.deleteLcnMngList(searchVO);
			resultMsg = egovMessageSource.getMessage("success.common.delete");
		}
		model.addAttribute("resultMsg", resultMsg);
		
        return "forward:/crm/lcm/LcnMngList.do";
    }
    
    /**
	 * 팝업 라이센스 목록 화면 (SW전산자원 관리)
	 * 
	 * @param searchVO - 조회할 정보가 담긴 LcnVO
	 * @exception Exception
	 */
	@RequestMapping(value = "/crm/swm/SwMngLcnPopup.do")
	public String SwMngLcnPopup(@ModelAttribute("searchVO") LcnVO searchVO, ModelMap model) throws Exception {

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
		List<LcnVO> lcnList = lcnService.selectLcnList(searchVO);
		model.addAttribute("resultList", lcnList);
		model.addAttribute("searchVO", searchVO);

		int totCnt = lcnService.selectLcnListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/truebon/com/crm/swm/SwMngLcnPopup";
	}
    
}
