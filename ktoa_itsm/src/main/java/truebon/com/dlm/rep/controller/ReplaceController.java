package truebon.com.dlm.rep.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import truebon.com.dlm.rep.model.ReplaceVO;
import truebon.com.dlm.rep.service.ReplaceService;

@Controller
public class ReplaceController {

  
     @Resource(name = "ReplaceService")
      private ReplaceService replaceService;
   
     /** 공통코드 Service */
     @Resource(name = "EgovCmmUseService")
     private EgovCmmUseService cmmUseService;
     
     /**
       * 대휴 조회
       */

       @RequestMapping(value="/dlm/rep/ReplaceOffdayMng.do")
       public String ReplaceOffdayMng(@ModelAttribute("searchVO") ReplaceVO searchVO, ModelMap model) throws Exception {
          
    	  //공통코드(휴일 근무 사유 구분)
    	  ComDefaultCodeVO vo5 = new ComDefaultCodeVO();
    	  vo5.setComnCdId("ISM017");
    	  List<?> offdayWrkRsnCdList = cmmUseService.selectCmmCodeDetail(vo5);
    	      
          List<ReplaceVO> replaceList = replaceService.selectReplaceList(searchVO);   
         
          List<ReplaceVO> replaceUseList = replaceService.selectReplaceUseList(searchVO);  
          
          float repSum = 0;     //총 대휴
          float useSum = 0;     //사용 대휴 합계
          float residnCnt = 0;  //잔여 대휴

          
          if(!replaceList.isEmpty()){
             repSum = replaceList.get(0).getRepSum(); 
          }

          if(!replaceUseList.isEmpty()){
             useSum = replaceUseList.get(0).getUseSum(); 
          }
         
          residnCnt = repSum - useSum; 
         
          
          model.addAttribute("repSum", repSum);  
          model.addAttribute("useSum", useSum);  
          model.addAttribute("residnCnt", residnCnt);  
 
          model.addAttribute("resultList", replaceList);      
          model.addAttribute("resultUseList", replaceUseList);
          model.addAttribute("offdayWrkRsnCdList", offdayWrkRsnCdList);
          model.addAttribute("searchVO", searchVO);

          return "/truebon/com/dlm/rep/ReplaceOffdayMng";
          
       }


       /**
        * 대휴 입력
        */
       @RequestMapping(value="/dlm/rep/ReplaceOffdayInsert.do")
       public String ReplaceOffdayInsert(@ModelAttribute("searchVO") ReplaceVO searchVO, ModelMap model) throws Exception {         
    	  
    	  replaceService.insertReOffday(searchVO);   
   
    	  return "/truebon/com/dlm/rep/ReplaceOffdayMng";
       }
       
}