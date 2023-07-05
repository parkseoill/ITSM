package egovframework.com.sym.ccm.cde.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.sym.ccm.cca.service.CmmnCodeVO;
import egovframework.com.sym.ccm.cca.service.EgovCcmCmmnCodeManageService;
import egovframework.com.sym.ccm.ccc.service.CmmnClCodeVO;
import egovframework.com.sym.ccm.ccc.service.EgovCcmCmmnClCodeManageService;
import egovframework.com.sym.ccm.cde.service.CmmnDetailCodeVO;
import egovframework.com.sym.ccm.cde.service.EgovCcmCmmnDetailCodeManageService;
import egovframework.rte.fdl.property.EgovPropertyService;

/**
*
* 공통상세코드에 관한 요청을 받아 서비스 클래스로 요청을 전달하고 서비스클래스에서 처리한 결과를 웹 화면으로 전달을 위한 Controller를 정의한다
* @author 공통서비스 개발팀 이중호
* @since 2009.04.01
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
*   수정일      수정자           수정내용
*  -------    --------    ---------------------------
*   2009.04.01  이중호       최초 생성
*   2011.08.26	정진오	IncludedInfo annotation 추가
*   2017.08.08	이정은	표준프레임워크 v3.7 개선
*
* </pre>
*/

@Controller
public class EgovCcmCmmnDetailCodeManageController {

	@Resource(name = "CmmnDetailCodeManageService")
   private EgovCcmCmmnDetailCodeManageService cmmnDetailCodeManageService;

	@Resource(name = "CmmnClCodeManageService")
   private EgovCcmCmmnClCodeManageService cmmnClCodeManageService;

	@Resource(name = "CmmnCodeManageService")
   private EgovCcmCmmnCodeManageService cmmnCodeManageService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	@Autowired
	private DefaultBeanValidator beanValidator;
	
	   /**
		 * 공통상세코드 목록을 조회한다.
	     * @param loginVO
	     * @param searchVO
	     * @param model
	     * @return "egovframework/com/sym/ccm/cde/EgovCcmCmmnDetailCodeList"
	     * @throws Exception
	     */
		@IncludedInfo(name="공통상세코드", listUrl="/sym/ccm/cde/SelectCcmCmmnDetailCodeList.do", order = 970 ,gid = 60)
	    @RequestMapping(value="/sym/ccm/cde/SelectCcmCmmnDetailCodeList.do")
		public ModelAndView selectCmmnDetailCodeList (@RequestParam("searchKeyword") String searchKeyword
				, @ModelAttribute("searchVO") CmmnDetailCodeVO searchVO
				, ModelMap model
				) throws Exception {
			
			ModelAndView mav = new ModelAndView("jsonView");
			searchVO.setSearchKeyword(searchKeyword);
	        List<?> CmmnCodeList = cmmnDetailCodeManageService.selectCmmnDetailCodeList(searchVO);
	        mav.addObject("ccmCdeCdTb", CmmnCodeList);
	        return mav;
	        
		}
		
		/**
		 * 공통상세코드 상세항목을 조회한다.
		 * @param loginVO
		 * @param cmmnDetailCodeVO
		 * @param model
		 * @return "egovframework/com/sym/ccm/cde/EgovCcmCmmnDetailCodeDetail"
		 * @throws Exception
		 */
		@RequestMapping(value="/sym/ccm/cde/SelectCcmCmmnDetailCodeDetail.do")
	 	public String selectCmmnDetailCodeDetail (@ModelAttribute("searchVO") CmmnDetailCodeVO searchVO
	 			, ModelMap model
	 			) throws Exception {
	    	CmmnDetailCode vo = cmmnDetailCodeManageService.selectCmmnDetailCodeDetail(searchVO);
			model.addAttribute("result", vo);
			return "egovframework/com/sym/ccm/cde/EgovCcmCmmnDetailCodeDetail";
		}
	    
		/**
		 * 공통상세코드 등록을 위한 등록페이지로 이동한다.
		 * 
		 * @param cmmnDetailCodeVO
		 * @param model
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("/sym/ccm/cde/RegistCcmCmmnDetailCodeView.do")
		public String insertCmmnDetailCodeView(@ModelAttribute("cmmnCodeVO") CmmnCodeVO cmmnCodeVO
				, @ModelAttribute("cmmnDetailCodeVO") CmmnDetailCodeVO cmmnDetailCodeVO
				, ModelMap model
				) throws Exception {
			
			CmmnClCodeVO searchClCodeVO = new CmmnClCodeVO();
            searchClCodeVO.setFirstIndex(0);
            searchClCodeVO.setRecordCountPerPage(999999);
	        List<?> CmmnClCodeList = cmmnClCodeManageService.selectCmmnClCodeList(searchClCodeVO);
	        model.addAttribute("clCodeList", CmmnClCodeList);
	        
			return "egovframework/com/sym/ccm/cde/EgovCcmCmmnDetailCodeRegist";
		}
		
		/**
	     * 공통상세코드를 등록한다.
	     * 
	     * @param CmmnDetailCodeVO
	     * @param CmmnDetailCodeVO
	     * @param status
	     * @param model
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping("/sym/ccm/cde/RegistCcmCmmnDetailCode.do")
	    public String insertCmmnDetailCode(@ModelAttribute("cmmnDetailCodeVO") CmmnDetailCodeVO cmmnDetailCodeVO
	    		, BindingResult bindingResult
	    		, ModelMap model
	    		) throws Exception {
			
	    	CmmnClCodeVO searchClCodeVO = new CmmnClCodeVO();
			beanValidator.validate(cmmnDetailCodeVO, bindingResult);
			if (bindingResult.hasErrors()) {
				List<?> CmmnClCodeList = cmmnClCodeManageService.selectCmmnClCodeList(searchClCodeVO);
				model.addAttribute("clCodeList", CmmnClCodeList);
			    return "egovframework/com/sym/ccm/cde/EgovCcmCmmnDetailCodeRegist";
			}
			
			if(cmmnDetailCodeVO.getComnCdId() != null){
				CmmnDetailCode vo = cmmnDetailCodeManageService.selectCmmnDetailCodeDetail(cmmnDetailCodeVO);
				if(vo != null){
					model.addAttribute("resultMsg", egovMessageSource.getMessage("comSymCcmCde.validate.codeCheck"));
					List<?> CmmnClCodeList = cmmnClCodeManageService.selectCmmnClCodeList(searchClCodeVO);
					model.addAttribute("clCodeList", CmmnClCodeList);
				    return "forward:/sym/ccm/ccc/SelectCcmCmmnClCodeList.do";
				}
			}
			model.addAttribute("getCdId",cmmnDetailCodeVO.getComnCdId());
			model.addAttribute("getCd",cmmnDetailCodeVO.getComnCd());
	    	cmmnDetailCodeManageService.insertCmmnDetailCode(cmmnDetailCodeVO);
			model.addAttribute("resultMsg", egovMessageSource.getMessage("success.common.insert"));
			return "forward:/sym/ccm/ccc/SelectCcmCmmnClCodeList.do";
	    }
	    
	    /**
	     * 공통상세코드 수정을 위한 수정페이지로 이동한다.
	     * 
	     * @param cmmnDetailCodeVO
	     * @param model
	     * @return "egovframework/com/sym/ccm/cde/EgovCcmCmmnDetailCodeUpdt"
	     * @throws Exception
	     */
	    @RequestMapping("/sym/ccm/cde/UpdateCcmCmmnDetailCodeView.do")
	    public String updateCmmnDetailCodeView(@ModelAttribute("searchVO") CmmnDetailCodeVO searchVO
	    		, ModelMap model
	    		) throws Exception {
			
	    	CmmnDetailCode result = cmmnDetailCodeManageService.selectCmmnDetailCodeDetail(searchVO);
			model.addAttribute("cmmnDetailCodeVO", result);
			return "egovframework/com/sym/ccm/cde/EgovCcmCmmnDetailCodeUpdt";  
	    }
	    
	    /**
	     * 공통상세코드를 수정한다.
	     * 
	     * @param cmmnDetailCodeVO
	     * @param model
	     * @return "egovframework/com/sym/ccm/cde/EgovCcmCmmnDetailCodeUpdt", "/sym/ccm/cde/SelectCcmCmmnDetailCodeList.do"
	     * @throws Exception
	     */
	    @RequestMapping("/sym/ccm/cde/UpdateCcmCmmnDetailCode.do")
	    public String updateCmmnDetailCode(@ModelAttribute("searchVO") CmmnDetailCodeVO searchVO
	    		, ModelMap model, BindingResult bindingResult 
	    		) throws Exception {
	    	
	    	beanValidator.validate(searchVO, bindingResult);
	    	if (bindingResult.hasErrors()){
		    	CmmnDetailCode result = cmmnDetailCodeManageService.selectCmmnDetailCodeDetail(searchVO);
		    	model.addAttribute("cmmnDetailCodeVO", result);
		    	return "forward:/sym/ccm/ccc/SelectCcmCmmnClCodeList.do";
	    	}
	    	
	    	model.addAttribute("getCdId",searchVO.getComnCdId());
	    	model.addAttribute("getCd",searchVO.getComnCd());
	    	cmmnDetailCodeManageService.updateCmmnDetailCode(searchVO);
			model.addAttribute("resultMsg", egovMessageSource.getMessage("success.common.update"));
	        return "forward:/sym/ccm/ccc/SelectCcmCmmnClCodeList.do";
	    }	
}
