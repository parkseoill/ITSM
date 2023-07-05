package egovframework.com.sec.gmt.web;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.SessionVO;
import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.sec.gmt.service.EgovGroupManageService;
import egovframework.com.sec.gmt.service.GroupManage;
import egovframework.com.sec.gmt.service.GroupManageVO;
import egovframework.com.uss.umt.service.DeptManageVO;
import egovframework.com.uss.umt.service.EgovDeptManageService;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

/**
 * 그룹관리에 관한 controller 클래스를 정의한다.
 * @author 공통서비스 개발팀 이문준
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.11  이문준          최초 생성
 *   2011.8.26   정진오         IncludedInfo annotation 추가
 *
 * </pre>
 */


@Controller
@SessionAttributes(types=SessionVO.class)
public class EgovGroupManageController {
   
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;

    @Resource(name = "egovGroupManageService")
    private EgovGroupManageService egovGroupManageService;
    
	@Resource(name = "egovDeptManageService")
	private EgovDeptManageService egovDeptManageService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
   
    /** Message ID Generation */
    @Resource(name="egovGroupIdGnrService")    
    private EgovIdGnrService egovGroupIdGnrService;
    
    @Autowired
   private DefaultBeanValidator beanValidator;
    
    /**
    * 그룹 목록화면 이동
    * @return String
    * @exception Exception
    */
    @RequestMapping("/sec/gmt/EgovGroupListView.do")
    public String selectGroupListView()
            throws Exception {
        return "egovframework/com/sec/gmt/EgovGroupManage";
    }   

   /**
    * 시스템사용 목적별 그룹 목록 조회
    * @param groupManageVO GroupManageVO
    * @return String
    * @exception Exception
    */
    @IncludedInfo(name="그룹관리", listUrl="/sec/gmt/EgovGroupList.do", order = 80,gid = 20)
    @RequestMapping(value="/sec/gmt/EgovGroupList.do")
   public String selectGroupList(@ModelAttribute("groupManageVO") GroupManageVO groupManageVO, 
                                   ModelMap model) throws Exception {
       /** paging */
       PaginationInfo paginationInfo = new PaginationInfo();
      paginationInfo.setCurrentPageNo(groupManageVO.getPageIndex());
      paginationInfo.setRecordCountPerPage(groupManageVO.getPageUnit());
      paginationInfo.setPageSize(groupManageVO.getPageSize());
      
      groupManageVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
      groupManageVO.setLastIndex(paginationInfo.getLastRecordIndex());
      groupManageVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
      
      groupManageVO.setGroupManageList(egovGroupManageService.selectGroupList(groupManageVO));
      model.addAttribute("groupList", groupManageVO.getGroupManageList());
        
      int totCnt = egovGroupManageService.selectGroupListTotCnt(groupManageVO);
      paginationInfo.setTotalRecordCount(totCnt);
      model.addAttribute("paginationInfo", paginationInfo);
      model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));

      	return "egovframework/com/sec/gmt/EgovGroupManage";
   }

   /**
    * 검색조건에 따른 그룹정보를 조회
    * @param groupManageVO GroupManageVO
    * @return String
    * @exception Exception
    */
    @RequestMapping(value="/sec/gmt/EgovGroup.do")
    public String selectGroup(@ModelAttribute("groupManageVO") GroupManageVO groupManageVO, 
                        @ModelAttribute("groupManage") GroupManage groupManage,
                            ModelMap model) throws Exception {

     model.addAttribute("groupManage", egovGroupManageService.selectGroup(groupManageVO));
     	
     	return "egovframework/com/sec/gmt/EgovGroupUpdate";
   }
	/**
	 * 회사별 부서 목록 조회
	 * @param deptManageVO   
	 * @param bindingResult
	 * @param model
	 * @param status
	 * @return 
	 * @exception Exception
	 */
	 @RequestMapping(value="/sec/gmt/EgovDeptList.do")
	 @ResponseBody
	 public ModelAndView selectDeptList(@ModelAttribute("deptManageVO") DeptManageVO deptManageVO,
		   						@RequestParam("cmpnyNo") String cmpnyNo,
		   						BindingResult bindingResult, ModelMap model) throws Exception {	 
    	
	 ModelAndView mav = new ModelAndView("jsonView");
	 
	 // 부서목록
     DeptManageVO vo = new DeptManageVO();
	 vo.setCmpnyNo(cmpnyNo);
	 vo.setUseYn("Y");
	 List<?> deptManageList = egovDeptManageService.selectDeptManageList(vo);
	
	 mav.addObject("deptManageList", deptManageList);
	 System.out.println("mav : " + mav); 
	 return mav;
     }  

    /**
    * 그룹 등록화면 이동
    * @return String
    * @exception Exception
    */     
    @RequestMapping(value="/sec/gmt/EgovGroupInsertView.do")
    public String insertGroupView(@ModelAttribute("groupManageVO") GroupManageVO groupManageVO)throws Exception {
        
    	return "egovframework/com/sec/gmt/EgovGroupInsert";
    }

   /**
    * 그룹 기본정보를 화면에서 입력하여 항목의 정합성을 체크하고 데이터베이스에 저장
    * @param groupManage GroupManage
    * @param groupManageVO GroupManageVO
    * @param loginVO 
    * @return String
    * @exception Exception
    */ 
    @RequestMapping(value="/sec/gmt/EgovGroupInsert.do")
   public String insertGroup(@ModelAttribute("groupManage") GroupManage groupManage, 
                           @ModelAttribute("groupManageVO") GroupManageVO groupManageVO,
                           @ModelAttribute("deptManageVO") DeptManageVO deptManageVO,
                            BindingResult bindingResult,
                            ModelMap model) throws Exception {
       beanValidator.validate(groupManage, bindingResult); //validation 수행
       String resultMsg = "";
       
       if (bindingResult.hasErrors()) { 
         return "egovframework/com/sec/gmt/EgovGroupInsert";
      } else {
    	  // 회사 등록
    	  if (groupManage.getCmpnyNo().equals("") && groupManageVO.getDeptNm().equals("") ) {
    		  groupManage.setCmpnyNo(egovGroupIdGnrService.getNextStringId());
    		  groupManageVO.setCmpnyNo(groupManage.getCmpnyNo());
    		  egovGroupManageService.insertGroup(groupManage, groupManageVO);   		  
    		  resultMsg = egovMessageSource.getMessage("success.common.insert");
    	  }
    	  // 회사 수정
    	  else if (!groupManage.getCmpnyNo().equals("") && groupManageVO.getGroupDc().equals("Update")) {
    		  egovGroupManageService.updateGroup(groupManage);		  
    		  resultMsg = egovMessageSource.getMessage("success.common.save");
    	  }
    	  // 회사 수정, 부서 등록
    	  else if (!groupManage.getCmpnyNo().equals("") && groupManageVO.getDeptNo().equals("")) {
    		  egovGroupManageService.updateGroup(groupManage);
    		  egovDeptManageService.insertDeptManage(deptManageVO);
    		  resultMsg = egovMessageSource.getMessage("success.common.save");
    	  }
    	  // 회사 수정, 부서 수정
    	  else if (!groupManage.getCmpnyNo().equals("") && !groupManageVO.getDeptNo().equals("")) {
    		  egovGroupManageService.updateGroup(groupManage);
    		  egovDeptManageService.updateDeptManage(deptManageVO);
    		  resultMsg = egovMessageSource.getMessage("success.common.save");
    	  }
    	   model.addAttribute("MdeptNo",deptManageVO.getDeptNo());
    	   model.addAttribute("McmpnyNo",groupManageVO.getCmpnyNo());
    	   model.addAttribute("resultMsg", resultMsg);
           return "forward:/sec/gmt/EgovGroupList.do";
      }
   }
    
   /**
    * 화면에 조회된 그룹의 기본정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영
    * @param groupManage GroupManage
    * @return String
    * @exception Exception
    */     
    @RequestMapping(value="/sec/gmt/EgovGroupUpdate.do")
   public String updateGroup(@ModelAttribute("groupManage") GroupManageVO groupManage, 
                            BindingResult bindingResult,
                               Model model) throws Exception {
       
       beanValidator.validate(groupManage, bindingResult); //validation 수행
       
       if (bindingResult.hasErrors()) { 
         return "egovframework/com/sec/gmt/EgovGroupUpdate";
      } else {
           egovGroupManageService.updateGroup(groupManage);
           model.addAttribute("message", egovMessageSource.getMessage("success.common.update"));
           
           return "forward:/sec/gmt/EgovGroupList.do";
      }
   }   
   
   /**
    * 불필요한 그룹정보를 화면에 조회하여 데이터베이스에서 삭제
    * @param groupManage GroupManage
    * @return String
    * @exception Exception
    */
   @RequestMapping(value="/sec/gmt/EgovGroupDelete.do")
   public String deleteGroup(@ModelAttribute("groupManage") GroupManage groupManage, 
                             Model model) throws Exception {
      egovGroupManageService.deleteGroup(groupManage);
      model.addAttribute("message", egovMessageSource.getMessage("success.common.delete"));
      return "forward:/sec/gmt/EgovGroupList.do";
   }
   
    /**
    * 그룹팝업 화면 이동
    * @return String
    * @exception Exception
    */
    @RequestMapping("/sec/gmt/EgovGroupSearchView.do")
    public String selectGroupSearchView(
      @ModelAttribute("searchVO") ComDefaultVO searchVO,
      ModelMap model)
       throws Exception {
   // 0. Spring Security 사용자권한 처리
   Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
   if(!isAuthenticated) {
      model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
      return "egovframework/com/uat/uia/EgovLoginUsr";
   }
   // 내역 조회
   searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
   searchVO.setPageSize(propertiesService.getInt("pageSize"));
   return "egovframework/com/sec/gmt/EgovGroupInsert";
       }   
       
   /**
    * 시스템사용 목적별 그룹 목록 조회
    * @param groupManageVO GroupManageVO
    * @return String
    * @exception Exception
    */
    @RequestMapping(value="/sec/gmt/EgovGroupSearchList.do")
   public String selectGroupSearchList(@ModelAttribute("groupManageVO") GroupManageVO groupManageVO, 
                                   ModelMap model) throws Exception {
      /** paging */
      PaginationInfo paginationInfo = new PaginationInfo();
      paginationInfo.setCurrentPageNo(groupManageVO.getPageIndex());
      paginationInfo.setRecordCountPerPage(groupManageVO.getPageUnit());
      paginationInfo.setPageSize(groupManageVO.getPageSize());
      
      groupManageVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
      groupManageVO.setLastIndex(paginationInfo.getLastRecordIndex());
      groupManageVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
      
      groupManageVO.setGroupManageList(egovGroupManageService.selectGroupList(groupManageVO));
      model.addAttribute("groupList", groupManageVO.getGroupManageList());
        
      int totCnt = egovGroupManageService.selectGroupListTotCnt(groupManageVO);
      paginationInfo.setTotalRecordCount(totCnt);
      model.addAttribute("paginationInfo", paginationInfo);
      model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));

      return "egovframework/com/sec/gmt/EgovGroupSearch";
   }
}
