package truebon.com.dlm.wrk.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import truebon.com.dlm.wrk.model.WorkVO;
import truebon.com.dlm.wrk.service.WorkService;

@Controller

public class WorkScheduleController {

   /* Validator */
   @Autowired
   private DefaultBeanValidator beanValidator;

   /** EgovMessageSource */
   @Resource(name = "egovMessageSource")
   EgovMessageSource egovMessageSource;

   /** 근무 Service */
   @Resource(name = "WorkService")
   private WorkService workService;
 
 
   /**
    * 근무편성표 조회
    */

    @RequestMapping(value="/dlm/wrk/WorkScheduleMng.do")
    public String WorkScheduleMng(@ModelAttribute("searchVO") WorkVO searchVO, ModelMap model) throws Exception {
    	
         // 목록
    	 List<WorkVO> workList = workService.selectWorkList(searchVO);
         List<WorkVO> rmarkList = workService.selectRmark(searchVO);
         List<String> date = new ArrayList<>();
         String emptyData = "";
         
         //데이터가 없는 경우
         if(workList.size() == 0){
        	 emptyData = "N";
         }         
         else { 
	         for (int i = 0; i < workList.size(); i++) {
	 			if(workList.get(i).getChrgrNm().equals(workList.get(31).getChrgrNm())) {
	 				 date.add(workList.get(i).getDlalzDate());
	 			}
	 		 }
	         
	         String closing = "N";
	         
	         //요일 설정
	         for (int i = 0; i < workList.size(); i++) {
	           if(workList.get(i).getDyweekDstnctCd().equals("1")) {
	              workList.get(i).setDyweekDstnctCd("일");
	           }
	           if(workList.get(i).getDyweekDstnctCd().equals("2")) {
	              workList.get(i).setDyweekDstnctCd("월");
	           }
	           if(workList.get(i).getDyweekDstnctCd().equals("3")) {
	              workList.get(i).setDyweekDstnctCd("화");
	           }     
	           if(workList.get(i).getDyweekDstnctCd().equals("4")) {
	              workList.get(i).setDyweekDstnctCd("수");
	           }
	           if(workList.get(i).getDyweekDstnctCd().equals("5")) {
	              workList.get(i).setDyweekDstnctCd("목");
	           }
	           if(workList.get(i).getDyweekDstnctCd().equals("6")) {
	              workList.get(i).setDyweekDstnctCd("금");
	           }
	           if(workList.get(i).getDyweekDstnctCd().equals("7")) {
	              workList.get(i).setDyweekDstnctCd("토");
	           }
	           if(workList.get(i).getChrgrNo().contains("0072")) {
	          	   closing = "Y";
	         	   model.addAttribute("closing", closing); 
	  	       }
	                           
	        }	        
	          
	          String month = workList.get(0).getDlalzDate();
	          month =month.substring(4,6);
	          
	          model.addAttribute("closing", closing); 	          
	          model.addAttribute("date", date); 
	          model.addAttribute("month", month); 
	          model.addAttribute("resultList", workList);      
	          model.addAttribute("name", workList.get(31).getChrgrNm()); 
	          model.addAttribute("searchVO", searchVO);
	          model.addAttribute("rmarkList", rmarkList);
          }     
 
         LocalDate currentdate = LocalDate.now();
         String nowDate =(currentdate.format(DateTimeFormatter.ofPattern("yyyy-MM")));
         
         model.addAttribute("nowDate", nowDate); 
         model.addAttribute("emptyData", emptyData); 
          
      return "/truebon/com/dlm/wrk/WorkScheduleMng";
   }
    
    
    /**
     * 근무편성표 현황 조회
     */
    
     @RequestMapping(value="/dlm/wrk/ResWorkScheduleMng.do")
     public String ResWorkScheduleMng(@ModelAttribute("searchVO") WorkVO searchVO, ModelMap model) throws Exception {
    	 
    	  // 목록
    	 List<WorkVO> workList = workService.selectWorkList(searchVO);
         List<WorkVO> rmarkList = workService.selectRmark(searchVO);
         List<String> date = new ArrayList<>();
         String emptyData = "";
         
         //데이터가 없는 경우
         if(workList.size() == 0){
        	 emptyData = "N";
         }
         else {      
	         for (int i = 0; i < workList.size(); i++) {
	 			if(workList.get(i).getChrgrNm().equals(workList.get(31).getChrgrNm())) {
	 				 date.add(workList.get(i).getDlalzDate());
	 			}
	 		 }
	         
	         for (int i = 0; i < workList.size(); i++) {
	           if(workList.get(i).getDyweekDstnctCd().equals("1")) {
	              workList.get(i).setDyweekDstnctCd("일");
	           }
	           if(workList.get(i).getDyweekDstnctCd().equals("2")) {
	              workList.get(i).setDyweekDstnctCd("월");
	           }
	           if(workList.get(i).getDyweekDstnctCd().equals("3")) {
	              workList.get(i).setDyweekDstnctCd("화");
	           }     
	           if(workList.get(i).getDyweekDstnctCd().equals("4")) {
	              workList.get(i).setDyweekDstnctCd("수");
	           }
	           if(workList.get(i).getDyweekDstnctCd().equals("5")) {
	              workList.get(i).setDyweekDstnctCd("목");
	           }
	           if(workList.get(i).getDyweekDstnctCd().equals("6")) {
	              workList.get(i).setDyweekDstnctCd("금");
	           }
	           if(workList.get(i).getDyweekDstnctCd().equals("7")) {
	              workList.get(i).setDyweekDstnctCd("토");
	           }         	                
	         }
	        	          
	          String month = workList.get(0).getDlalzDate();
	          month =month.substring(4,6);
	                   
	          model.addAttribute("date", date); 
	          model.addAttribute("month", month); 
	          model.addAttribute("resultList", workList);      
	          model.addAttribute("name", workList.get(31).getChrgrNm()); 
	          model.addAttribute("searchVO", searchVO);
	          model.addAttribute("rmarkList", rmarkList);
          }     
 
         LocalDate currentdate = LocalDate.now();
         String nowDate =(currentdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
         LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    
         model.addAttribute("nowDate", nowDate); 
         model.addAttribute("emptyData", emptyData); 
         model.addAttribute("user", user.getId()); 
 
       return "/truebon/com/dlm/wrk/ResWorkScheduleMng";
       
    }

     
   /**
    * 근무편성 수정
    * 
    * @param WorkVO
    * @param searchVO
    */
   @RequestMapping("/dlm/wrk/updateWorkScheUpdt.do")
   public String updateWorkScheUpdt(@ModelAttribute("workVO") WorkVO workVO, BindingResult bindingResult,
         ModelMap model) throws Exception {
      String sLocationUrl = "";
      String resultMsg = "";
      
      // 유효성 검사
      beanValidator.validate(workVO, bindingResult);
      if (bindingResult.hasErrors()) {
         sLocationUrl = "/truebon/com/dlm/wrk/WorkScheUpdt";
         return sLocationUrl;
      } else {
         workService.updateWork(workVO); 
         resultMsg = egovMessageSource.getMessage("success.common.update");
         sLocationUrl = "forward:/dlm/wrk/WorkScheduleMng.do";
      }

      model.addAttribute("resultMsg", resultMsg);
      return "forward:/dlm/wrk/WorkScheduleMng.do";
      
   }   
   
   
   /**
    * 실적 근무편성 수정
    * 
    * @param WorkVO
    * @param searchVO
    */
   @RequestMapping("/dlm/wrk/ResUpdateWorkScheUpdt.do")
   public String ResUpdateWorkScheUpdt(@ModelAttribute("workVO") WorkVO workVO, BindingResult bindingResult,
         ModelMap model) throws Exception {
      String sLocationUrl = "";
      String resultMsg = "";
      

      beanValidator.validate(workVO, bindingResult);
      if (bindingResult.hasErrors()) {
         sLocationUrl = "/truebon/com/dlm/wrk/ResWorkScheUpdt";
         return sLocationUrl;
      } else {
         workService.updateResWork(workVO);          
         resultMsg = egovMessageSource.getMessage("success.common.update");
         sLocationUrl = "forward:/dlm/wrk/ResWorkScheduleMng.do";
      }

      model.addAttribute("resultMsg", resultMsg);
      return "forward:/dlm/wrk/ResWorkScheduleMng.do";
      
   }   
   

   /**
    * 마감 버튼
    * 
    * @param WorkVO
    * @param searchVO
    */
   @RequestMapping("/dlm/wrk/closing.do")
   public String closing(@ModelAttribute("searchVO") WorkVO searchVO, BindingResult bindingResult, ModelMap model)
         throws Exception {
	   
	  workService.closing(searchVO);
	  String selectedDate = searchVO.getSelectedDate() + "-01";
	  searchVO.setSelectedDate(selectedDate);
	  workService.insertClosing(searchVO);
     
      return "forward:/dlm/wrk/WorkScheduleMng.do";
      
   }
   
   
   /**
    * OP 일괄 입력 
    * 
    * @param WorkVO
    */
   @RequestMapping("/dlm/wrk/opWorkScheUpdt.do")
   public String opWorkScheUpdt(@ModelAttribute("workVO") WorkVO workVO, BindingResult bindingResult,
         ModelMap model) throws Exception {
      String sLocationUrl = "";
      String resultMsg = "";
      
      if (bindingResult.hasErrors()) {
         sLocationUrl = "/truebon/com/dlm/wrk/WorkScheduleMng";
         return sLocationUrl;
      } else {
    	  
    	String chk = workVO.getSelectedOpDate().substring(8,10);  //선택날짜 1일 or 2일 체크
    	if(chk.equals("01")) {    		
    		workVO.setSelectedDate((workVO.getSelectedOpDate().substring(0,7).replace("-","")));
     		workVO.setOpDatechk("1");
    	    workService.updateOp(workVO);
    	}
    	else if(chk.equals("02")){
    		workVO.setSelectedDate((workVO.getSelectedOpDate().substring(0,7).replace("-","")));
    		workVO.setOpDatechk("2");
    		workService.updateOp(workVO);
    	}
    	else {
    		workVO.setSelectedDate((workVO.getSelectedOpDate().substring(0,7).replace("-","")));
    		workVO.setOpDatechk("3");
    		workService.updateOp(workVO);
    	}
    	     
         resultMsg = egovMessageSource.getMessage("success.common.update");
         sLocationUrl = "forward:/dlm/wrk/WorkScheduleMng.do";
      }
      String returnDate = workVO.getSelectedOpDate().substring(0,7);
      returnDate = "forward:/dlm/wrk/WorkScheduleMng.do?selectedDate="+returnDate;
      System.out.println(returnDate);
      model.addAttribute("resultMsg", resultMsg);
      
      return returnDate;
      
   }  

}