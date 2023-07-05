package egovframework.com.sym.ccm.ccc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.sym.ccm.ccc.service.CmmnClCode;
import egovframework.com.sym.ccm.ccc.service.CmmnClCodeVO;
import egovframework.com.sym.ccm.ccc.service.EgovCcmCmmnClCodeManageService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 *
 * 공통분류코드에 관한 요청을 받아 서비스 클래스로 요청을 전달하고 서비스클래스에서 처리한 결과를 웹 화면으로 전달을 위한 Controller를 정의한다
 * 
 * @author 공통서비스 개발팀 이중호
 * @since 2009.04.01
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *	     수정일		수정자          			 수정내용
 *  ---------  -------   ---------------------------
 *  2009.04.01	이중호         최초 생성
 *  2011.8.26	정진오	 IncludedInfo annotation 추가
 *  2017.06.08	이정은	 표준프레임워크 v3.7 개선
 *
 *      </pre>
 */

@Controller
public class EgovCcmCmmnClCodeManageController {
	@Resource(name = "CmmnClCodeManageService")
	private EgovCcmCmmnClCodeManageService cmmnClCodeManageService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * 공통분류코드 목록을 조회한다.
	 * 
	 * @param loginVO
	 * @param searchVO
	 * @param model
	 * @return "egovframework/com/sym/ccm/ccc/SelectCcmCmmnClCodeList"
	 * @throws Exception
	 */
//	@IncludedInfo(name = "공통분류코드", listUrl = "/sym/ccm/ccc/SelectCcmCmmnClCodeList.do", order = 960, gid = 60)
	@RequestMapping(value = "/sym/ccm/ccc/SelectCcmCmmnClCodeList.do")
	public String selectCmmnClCodeList(@ModelAttribute("searchVO") CmmnClCodeVO searchVO, ModelMap model) throws Exception {
		
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

		List<?> CmmnCodeList = cmmnClCodeManageService.selectCmmnClCodeList(searchVO);
		model.addAttribute("resultList", CmmnCodeList);

		int totCnt = cmmnClCodeManageService.selectCmmnClCodeListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "egovframework/com/sym/ccm/ccc/EgovCcmCmmnClCodeList";
	}

	/**
	 * 공통분류코드 상세항목을 조회한다.
	 * 
	 * @param loginVO
	 * @param cmmnClCode
	 * @param model
	 * @return "egovframework/com/sym/ccm/ccc/SelectCcmCmmnClCodeDetail.do"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sym/ccm/ccc/SelectCcmCmmnClCodeDetail.do")
	public String selectCmmnClCodeDetail(@ModelAttribute("searchVO") CmmnClCodeVO searchVO,
			ModelMap model) throws Exception {

		CmmnClCode vo = cmmnClCodeManageService.selectCmmnClCodeDetail(searchVO);

		model.addAttribute("result", vo);

		return "egovframework/com/sym/ccm/ccc/EgovCcmCmmnClCodeDetail";
	}
	
	/**
	 * 공통분류코드 등록을 위한 등록페이지로 이동한다.
	 * 
	 * @param cmmnClCodeVO
	 * @param model
	 * @return "egovframework/com/sym/ccm/ccc/EgovCcmCmmnClCodeRegist";
	 * @throws Exception
	 */
	@RequestMapping("/sym/ccm/ccc/RegistCcmCmmnClCodeView.do")
	public String insertCmmnClCodeView(@ModelAttribute("searchVO") CmmnClCodeVO cmmnClCodeVO, ModelMap model) throws Exception {
		model.addAttribute("cmmnClCodeVO", new CmmnClCodeVO());

		return "egovframework/com/sym/ccm/ccc/EgovCcmCmmnClCodeRegist";
	}
	
	 /**
     * 공통분류코드를 등록한다.
     * 
     * @param CmmnClCodeVO
     * @param CmmnClCodeVO
     * @param status
     * @param model
     * @return /sym/ccm/ccc/SelectCcmCmmnClCodeList.do";
     * @throws Exception
     */
    @RequestMapping("/sym/ccm/ccc/RegistCcmCmmnClCode.do")
    public String insertCmmnClCode(@ModelAttribute("cmmnClCodeVO") CmmnClCodeVO cmmnClCodeVO,
	    BindingResult bindingResult, ModelMap model) throws Exception {
	
		beanValidator.validate(cmmnClCodeVO, bindingResult);
	
		if (bindingResult.hasErrors()) {
		    return "egovframework/com/sym/ccm/ccc/EgovCcmCmmnClCodeRegist";
			
		}
		
		if(cmmnClCodeVO.getComnCdId() != null){
			CmmnClCode vo = cmmnClCodeManageService.selectCmmnClCodeDetail(cmmnClCodeVO);
			if(vo != null){
				model.addAttribute("resultMsg", egovMessageSource.getMessage("comSymCcmCcc.validate.codeCheck"));
				return "forward:/sym/ccm/ccc/SelectCcmCmmnClCodeList.do";
			}
		}
			model.addAttribute("getCdId",cmmnClCodeVO.getComnCdId());
			cmmnClCodeManageService.insertCmmnClCode(cmmnClCodeVO);
			model.addAttribute("resultMsg", egovMessageSource.getMessage("success.common.insert"));
		return "forward:/sym/ccm/ccc/SelectCcmCmmnClCodeList.do";
    }
    
    /**
     * 공통분류코드 수정을 위한 수정페이지로 이동한다.
     * 
     * @param cmmnClCodeVO
     * @param model
     * @return "egovframework/com/sym/ccm/ccc/EgovCcmCmmnClCodeUpdt";  
     * @throws Exception
     */
    @RequestMapping("/sym/ccm/ccc/UpdateCcmCmmnClCodeView.do")
    public String updateCmmnClCodeView(@ModelAttribute("searchVO") CmmnClCodeVO searchVO
    		, ModelMap model
    		) throws Exception {
		
    	CmmnClCode result = cmmnClCodeManageService.selectCmmnClCodeDetail(searchVO);
		model.addAttribute("cmmnClCodeVO", result);
	
		return "egovframework/com/sym/ccm/ccc/EgovCcmCmmnClCodeUpdt";  
    }
    
    /**
     * 공통분류코드를 수정한다.
     * 
     * @param cmmnClCodeVO
     * @param status
     * @param model
     * @return /sym/ccm/ccc/SelectCcmCmmnClCodeList.do"
     * @throws Exception
     */
    @RequestMapping("/sym/ccm/ccc/UpdateCcmCmmnClCode.do")
    public String updateCmmnClCode(@ModelAttribute("searchVO") CmmnClCodeVO searchVO
    		, @ModelAttribute("cmmnClCodeVO") CmmnClCodeVO cmmnClCodeVO
    		, BindingResult bindingResult, ModelMap model
    		) throws Exception {

		beanValidator.validate(cmmnClCodeVO, bindingResult);
		if (bindingResult.hasErrors()) {
	
			CmmnClCode result = cmmnClCodeManageService.selectCmmnClCodeDetail(searchVO);
		    model.addAttribute("cmmnClCodeVO", result);
		    return "egovframework/com/sym/ccm/ccc/EgovCcmCmmnClCodeUpdt";
		}
		cmmnClCodeManageService.updateCmmnClCode(cmmnClCodeVO);
		model.addAttribute("getCdId",searchVO.getComnCdId());
		model.addAttribute("resultMsg", egovMessageSource.getMessage("success.common.update"));
		return "forward:/sym/ccm/ccc/SelectCcmCmmnClCodeList.do";
    }
}