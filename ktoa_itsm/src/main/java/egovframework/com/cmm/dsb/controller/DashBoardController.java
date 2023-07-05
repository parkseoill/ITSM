package egovframework.com.cmm.dsb.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import org.codehaus.jettison.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.com.cmm.dsb.model.DashBoard;
import egovframework.com.cmm.dsb.model.DashBoardOffdayVO;
import egovframework.com.cmm.dsb.model.DashBoardVO;
import egovframework.com.cmm.dsb.service.DashBoardService;


@Controller
@SessionAttributes(types = DashBoard.class)
public class DashBoardController {

	/** 대시보드 Service */
	@Resource(name = "DashBoardService")
	private DashBoardService boardService;

	/**
	 * 서비스 요청 처리 통계
	 * @param DashBoardVO - 조회된 정보가 담긴 DashBoardVO
	 * @exception Exception
	 */	
	@RequestMapping(value="/cmm/dsb/serviceRequestProcessingStatistics.do",  produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String serviceRequestProcessingStatisticsList(@ModelAttribute("dashBoardVO") DashBoardVO dashBoardVO,
			Model model  ) throws Exception {
		DashBoardVO srps = boardService.serviceRequestProcessingStatistics(dashBoardVO);

		List<DashBoardVO> dlalz =  boardService.dlalzList(dashBoardVO);
		
	      LocalDate currentdate = LocalDate.now();
	      LocalDate minusDate = currentdate.minusDays(3);
	     
	      int nowdate = Integer.parseInt(currentdate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
          int preDate = Integer.parseInt(minusDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
          String alertDate = "";
          
		  for (int i = 0; i < dlalz.size(); i++) {
			  int chkDate = Integer.parseInt(dlalz.get(i).getDlalzDate());
			  if(preDate <=chkDate && nowdate > chkDate) {				   
				  alertDate += (chkDate+"").substring(6,8)+"일 ";
			}
		}
		
		
		ArrayList<String> srpsArrayList = new ArrayList<String>();	
		
		// 서비스요청관리통계
		srpsArrayList.add(srps.getPrevious_month());
		srpsArrayList.add(srps.getCurrent_month());
		srpsArrayList.add(srps.getPrevious_month_carry());
		srpsArrayList.add(srps.getCurrent_month_carry());
		srpsArrayList.add(srps.getPrevious_month_all());
		srpsArrayList.add(srps.getCurrent_month_all());
		srpsArrayList.add(srps.getPrevious_all());
		srpsArrayList.add(srps.getCurrent_all());
		srpsArrayList.add(srps.getPrevious_success());
		srpsArrayList.add(srps.getCurrent_success());
		
		// 나의서비스현황
		srpsArrayList.add(srps.getPrevious_month());
		srpsArrayList.add(srps.getCurrent_month());
		srpsArrayList.add(srps.getMy_previous_month_all());
		srpsArrayList.add(srps.getMy_current_month_all());
		srpsArrayList.add(srps.getMy_previous_month_process());
		srpsArrayList.add(srps.getMy_current_month_process());
		srpsArrayList.add(srps.getMy_previous_month_carry());
		srpsArrayList.add(srps.getMy_current_month_carry());
		srpsArrayList.add(srps.getMy_previous_month_process_carry());
		srpsArrayList.add(srps.getMy_current_month_process_carry());
		
		//출퇴근기록부 체크
		srpsArrayList.add(alertDate);
		
//		for (int i = 0; i < srpsArrayList.size(); i++) {
//			System.out.println(i + "번째 데이터 " + srpsArrayList.get(i));
//		}
		
//		System.out.println("DashBoardController 실행");
		
		JSONArray json = new JSONArray(srpsArrayList);
		return json.toString();
	}
	
	/**
	 * 대시보드 휴가자 팝업
	 * @throws Exception 
	 */	
	@RequestMapping(value="/cmm/dsb/Popup.do")
	public String AttendancePopup(@ModelAttribute("dashBoardOffdayVO") DashBoardOffdayVO dashBoardOffdayVO,
			@RequestParam(value = "popupType", required = false) String popupType,
			Model model) throws Exception {
		
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		List<String> dateList = new ArrayList<String>();
		
		if ("1".equals(popupType)) {
	        System.out.println("금주");
	        LocalDate lastSunday = currentDate.with(DayOfWeek.SUNDAY).minusWeeks(1);
	        LocalDate thisSaturday = currentDate.with(DayOfWeek.SATURDAY);
	        	   	        	        	        
	        LocalDate date = lastSunday;
	        while (!date.isAfter(thisSaturday)) {
	            String formattedDate = date.format(formatter);
	            dateList.add(formattedDate);
//	            System.out.println(formattedDate);
	            date = date.plusDays(1);
	        }
	    } else if ("2".equals(popupType)) {
	    	System.out.println("차주");	 
	    	LocalDate thisSunday = currentDate.with(DayOfWeek.SUNDAY);
	        LocalDate nextSaturday = currentDate.with(DayOfWeek.SATURDAY).plusWeeks(1);
	        	   	        	        	        
	        LocalDate date = thisSunday;
	        while (!date.isAfter(nextSaturday)) {
	            String formattedDate = date.format(formatter);
	            dateList.add(formattedDate);
//	            System.out.println(formattedDate);
	            date = date.plusDays(1);
	        }
	    }
		dashBoardOffdayVO.setSun_date(dateList.get(0));
		dashBoardOffdayVO.setMon_date(dateList.get(1));
		dashBoardOffdayVO.setTues_date(dateList.get(2));
		dashBoardOffdayVO.setWednes_date(dateList.get(3));
		dashBoardOffdayVO.setThurs_date(dateList.get(4));
		dashBoardOffdayVO.setFri_date(dateList.get(5));
		dashBoardOffdayVO.setSatur_date(dateList.get(6));
		
		List<DashBoardOffdayVO> resultList = new ArrayList<DashBoardOffdayVO>();
		
		resultList = boardService.serviceOffday(dashBoardOffdayVO);
		
//		for (int i = 0; i < resultList.size(); i++) {
//			if(resultList.get(i).getOffday_cd().equals("2")) {
//				System.out.println(resultList.get(i).getOffday_date() + "\t" + resultList.get(i).getChrgr_nm() + "\t" + "전일휴무");
//			}
//			else if(resultList.get(i).getOffday_cd().equals("3")) {
//				System.out.println(resultList.get(i).getOffday_date() + "\t" + resultList.get(i).getChrgr_nm() + "\t" + "반일휴무");
//			}
//			else {
//				System.out.println("변순데?" + i);
//			}
//			
//		}


	    model.addAttribute("resultList", resultList);
		
		return "/egovframework/com/cmm/OffdayPopup";
	}
}