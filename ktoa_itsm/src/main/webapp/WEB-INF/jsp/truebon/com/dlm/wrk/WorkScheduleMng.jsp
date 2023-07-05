<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
 /**
  * @Class Name : WorkScheduleMng.jsp
  * @Description : 근무편성표 관리
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2023.02.03   김승현            최초 생성
  *
  *  @author 박서일
  *  @since 2023.02.03
  *  @version 1.0
  *  @see
  *
  */
%>

<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>근무편성표관리</title>
<!-- 공통 CSS -->
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<!-- 달력 기본 설정 -->
<script type="text/javascript" src="<c:url value='/js/truebon/com/cmm/initDatepicker.js' />"></script>

<link type="text/css" rel="stylesheet" href="<c:url value='/css/truebon/com/dlm/dla/dlalz.css' />">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/truebon/com/dlm/wrk/work.css' />">
<script language="javascript1.2" type="text/javaScript">


/* ********************************************************
 * 근무편성표 수정 팝업 근무, 휴무 선택 라디오 버튼 처리 함수
 ******************************************************** */
$(document).ready(function(){
    $('#plnOffdayWrkRsnCdTr').hide();   // 초깃값 설정
    $('#plnOpWrkTimeCdTr').hide(); //OP 근무 유형  
    
    $("input[name='updtselect']").change(function(){           
      // 휴무수정 선택 시.
      if($("input[name='updtselect']:checked").val() == '휴무수정'){
            $('#off_type').show();    //휴무 유형
            $('#rmark').show();    //휴무 특이사항
            $('#tr').show();    //tr 공백
            
            $('#plnOpWrkTimeCdTr').hide(); //OP 근무 유형
            $('#plnOpWrkTimeCd').prop("disabled", true );
            
            $('#plnOffdayWrkRsnCdTr').hide(); //휴일 근무 사유
            $('#plnOffdayWrkRsnCd').prop("disabled", true );
            
            $('#plnOffdayTypeCd').prop("disabled", false);
            $('#plnHlfdayOffdayDstnctCd').prop("disabled", false);
            $('#plnOffdayRmark').prop("disabled", false);//특이사항                
      }   
      
      // 근무수정 결제 선택 시.
      else if($("input[name='updtselect']:checked").val() == '근무수정'){   
         $('#off_type').hide();    //휴무 유형
         $('#rmark').hide();    //휴무 특이사항
         $('#tr').hide();    //tr 공백 제거       
         
         $('#plnOffdayWrkRsnCdTr').show(); //휴일 근무 사유
         $('#plnOffdayWrkRsnCd').prop("disabled", false);
         
         $('#plnOffdayTypeCd').prop("disabled", true );
         $('#plnHlfdayOffdayDstnctCd').prop("disabled", true );
         $('#plnOffdayRmark').prop("disabled", true);
         
         
         if($('#comnCdNm').val() == 'OP'){       	 
            $('#plnOffdayWrkRsnCdTr').hide(); //휴일 근무 사유
            $('#plnOpWrkTimeCdTr').show(); //OP 근무 유형      
            
            $('#plnOffdayWrkRsnCd').prop("disabled", true);
            $('#plnOpWrkTimeCd').prop("disabled", false );
           }
      }    
      
   });    
      
});


/* ********************************************************
 * 현황 처리 함수
 ******************************************************** */
 function resWorkScheduleMng() { 
	 location.href = "<c:url value='/dlm/wrk/ResWorkScheduleMng.do' />?selectedDate=<c:out value='${searchVO.selectedDate}'/>";
} 


 /* ********************************************************
  * 삭제 처리 함수
  ******************************************************** */
  function deleteWrk() { 
	  if($("input[name='updtselect']:checked").val() == '휴무수정'){
		  document.updateWorkForm.plnOffdayTypeCd.value = '';
		  document.updateWorkForm.action = "<c:url value='/dlm/wrk/updateWorkScheUpdt.do'/>";
		  document.updateWorkForm.submit();
	  }
	  else if($("input[name='updtselect']:checked").val() == '근무수정'){
		  document.updateWorkForm.plnOffdayWrkRsnCd.value = '';
		  document.updateWorkForm.plnOpWrkTimeCd.value = '';
		  document.updateWorkForm.action = "<c:url value='/dlm/wrk/updateWorkScheUpdt.do'/>";
		  document.updateWorkForm.submit();		  
	  }
	  else{
		  alert("데이터 오류 입니다.")
	  }
 } 

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectWorkMng() {
   document.WorkScheduleMngForm.pageIndex.value = 1;
   document.WorkScheduleMngForm.action = "<c:url value='/dlm/wrk/WorkScheduleMng.do'/>";
   document.WorkScheduleMngForm.submit();
}


/* ********************************************************
 * 날짜체크처리 함수
 ******************************************************** */
function checkDate(){
   var getDate = document.getElementById('selectedDate').value;
   if(getDate != ""){
      document.WorkScheduleMngForm.checkDate.value = getDate.concat('01');
   }else{
      alert("년도를 입력해주세요.");
   } 
}


/* ********************************************************
 * 날짜 초기화 함수
 ******************************************************** */
function initializeDate(){
   document.getElementById("selectedDate").value = null;
}


//팝업 띄우기
function openPop(resultName, dlalzDate, chrgrNo, comnCdNm, plnOffdayRmark, plnOffdayTypeCd, plnHlfdayOffdayDstnctCd, plnOffdayWrkRsnCd, plnOpWrkTimeCd) {	
	if("${closing}" == "Y"){
	    	alert("마감 되었습니다.");
	 }
	else{
	    document.getElementById("popup_layer").style.display = "block";
	    document.getElementById("chrgrNm").value = resultName;
		document.getElementById("chrgrNo").value = chrgrNo;
	    document.getElementById("dlalzDate").value = dlalzDate;  
	    document.getElementById("comnCdNm").value = comnCdNm;
	    document.getElementById("plnOffdayRmark").value = plnOffdayRmark;	
	    document.getElementById("plnOffdayTypeCd").value = plnOffdayTypeCd;	
	    document.getElementById("plnHlfdayOffdayDstnctCd").value = plnHlfdayOffdayDstnctCd;	
	    document.getElementById("plnOffdayWrkRsnCd").value = plnOffdayWrkRsnCd;	
		document.getElementById("plnOpWrkTimeCd").value = plnOpWrkTimeCd;
		

		 if($('#comnCdNm').val() == 'OP' && $("input[name='updtselect']:checked").val() == '근무수정'){
	    	$('#plnOffdayWrkRsnCdTr').hide();
	        $('#plnOpWrkTimeCdTr').show(); //OP 근무 유형
	       }
	    else if($('#comnCdNm' ).val() != 'OP' && $("input[name='updtselect']:checked").val() == '근무수정') {
	    	$('#plnOffdayWrkRsnCdTr').show();
	        $('#plnOpWrkTimeCdTr').hide(); //OP 근무 유형
	    }	        
	    
	}	
}


//팝업 닫기
function closePop() {   
    document.getElementById("popup_layer").style.display = "none";
}


//OP팝업 
function opPopUp() {   
    document.getElementById("opPopup_layer").style.display = "block";
}

//OP팝업 닫기
function closeOpPop() {   
    document.getElementById("opPopup_layer").style.display = "none";
}


//마감 버튼클릭 
function closing() {
    alert("마감 되었습니다.");   
    document.WorkScheduleMngForm.action = "<c:url value='/dlm/wrk/closing.do'/>";
    document.WorkScheduleMngForm.submit();
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>


//엑셀로 내보내기
function fnExcelReport(id, title) {
    var tab_text = '<html xmlns:x="urn:schemas-microsoft-com:office:excel">';
    tab_text = tab_text + '<head><meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';
    tab_text = tab_text + '<xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet>'
    tab_text = tab_text + '<x:Name>Test Sheet</x:Name>';
    tab_text = tab_text + '<x:WorksheetOptions><x:Panes></x:Panes></x:WorksheetOptions></x:ExcelWorksheet>';
    tab_text = tab_text + '</x:ExcelWorksheets></x:ExcelWorkbook></xml></head><body>';
    tab_text = tab_text + "<table border='1px'>";
    var exportTable = $('#' + id).clone();
    exportTable.find('input').each(function (index, elem) { $(elem).remove(); });
    tab_text = tab_text + exportTable.html();
    tab_text = tab_text + '</table></body></html>';
    var data_type = 'data:application/vnd.ms-excel';
    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE ");
 
    var fileName = title + '.xls';
    //Explorer 환경에서 다운로드
    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) {
        if (window.navigator.msSaveBlob) {
            var blob = new Blob([tab_text], {
                type: "application/csv;charset=utf-8;"
            });
            navigator.msSaveBlob(blob, fileName);
        }
    } else {
        var blob2 = new Blob([tab_text], {
            type: "application/csv;charset=utf-8;"
        });
        var filename = fileName;
        var elem = window.document.createElement('a');
        elem.href = window.URL.createObjectURL(blob2);
        elem.download = filename;
        document.body.appendChild(elem);
        elem.click();
        document.body.removeChild(elem);
    }
}


//기간 설정
$(function() {
    $('.sdate').datepicker( {
        changeYear: true,
        changeMonth: true,
        showButtonPanel: true,
        gotoCurrent: true,
        currentText:"현재달",
        dateFormat: 'yy-mm',
        onClose: function(dateText, inst) {    
            $(this).datepicker('setDate', new Date(inst.selectedYear, inst.selectedMonth, 1));
        } 
    });      
});
   

</script>
</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript><!-- 자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다. -->	
	
<div class="board">
   <!-- 타이틀 -->
   <h1>근무편성표 관리</h1>
   <form name="WorkScheduleMngForm" action ="<c:url value='/dlm/wrk/WorkScheduleMng.do' />" method="post">
   <input type="hidden" name="dlalzDate"/>
   <input type="hidden" name="chrgrNo"/>
   <input type="hidden" name="checkDate" />
   
   <!-- 달력 -->
   <div class="search_box">
      <ul class="search_box-ul_bottom">
         <li style="padding-left:4%; float:left;">
            <label for="">기간 : </label>
            <input id="selectedDate" name="selectedDate" type="text" class="sdate" value="${searchVO.selectedDate}"/>
            <input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectWorkMng(); return false;" /><!-- 조회 -->
            <span class="btn_b"><a href="#LINK'/>" onclick="initializeDate(); return false;">초기화</a></span><!-- 초기화 -->
            <span class="btn_b" style="color:white; padding: 5.55px 10px;" onclick="closing(); return false;">마감</span>   
            <span>  ※ 마감 클릭시 계획 데이터가 현황 데이터로 이전 됩니다.</span>
         </li>
         <li style="padding-right:4%;">
            <label for="">구분 : </label>
         <input type="radio" class="res" id="res" name="plnresselect" value="실적" onclick="javascript:resWorkScheduleMng()">현황</input>
         <input type="radio" class="pln" id="pln" name="plnresselect" value="계획" checked="checked">계획</input>
       </li>
         <li style="padding-right:4%;">
            <button style="float: right;" type="button" onclick="fnExcelReport('table','${month}월 근무편성표');">Excel 다운로드</button>
         </li>
      </ul>
   </div>
   
	 <%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
	 <c:if test='${emptyData == "N"}'>
		<table>
		    <tr>
				 <td colspan="13">
					<spring:message code="common.nodata.msg" />
				 </td>
			</tr>
		 </table>
	 </c:if>    
	
	 <%-- 데이터를 있을때 화면에 메세지를 출력해준다 --%>
    <c:if test="${emptyData != 'N'}">	
	   <!-- 근무편성표  (계획) -->
	  <div id="plnwrkcontent">
      <table class="t1" id="table">     	    
	     <thead>            
	            <tr>                 
	               <c:forEach var="result" items="${resultList}" varStatus="status"   >
	                   <c:if test="${status.first}">  
	                      <th colspan="33" style="font-size: 24px; font-weight:blod; background-color:#DAE7F6; padding:0.7% ;"/> ${fn:substring(result.dlalzDate,4,6)}월 근무편성표 - 계획</th>
	                   </c:if>                                                    
	               </c:forEach>                       
	            </tr>
	            <tr>
	                 <th rowspan="2" style="width:8%;  background-color:#ECF3FA;">구분</th>
	                 <th rowspan="2" style="width:6%; background-color:#ECF3FA;">성명</th>
	                 <c:forEach var="result" items="${resultList}" varStatus="status"   >         
	                    <c:if test="${result.chrgrNm == name}">
	                       <c:if test="${result.hdayDstinctCd == '2'}">           
	                           <td style="background-color:#d7d7db; color:red;  font-weight: bold;">  ${(fn:substring(result.stdrDate,6,8))}</td>
	                        </c:if>
	                        <c:if test="${result.hdayDstinctCd != '2'}">           
	                           <td style="background-color:#ECF3FA;">  ${(fn:substring(result.stdrDate,6,8))}</td>
	                        </c:if>
	                    </c:if>
	                 </c:forEach>   
	            </tr>
	            <tr>  
	                 <c:forEach var="result" items="${resultList}" varStatus="status"   >              
	                    <c:if test="${result.chrgrNm == name}">               
	                      <td style="background-color:#ECF3FA;"> ${result.dyweekDstnctCd}</td>                      
	                    </c:if>
	                 </c:forEach>  
	            </tr>       
	     </thead>
         <tbody class="ov">
	      	<c:forEach var="result" items="${resultList}" varStatus="status"   >                 
	           <c:if test = "${fn:contains(fn:substring(result.dlalzDate,6,8), '01') && result.chrgrNm != '관리자'}">
	              <c:set var="name" value="${result.chrgrNm}"/>
	              <tr class="WrkSche-table">
	                 <td>${result.comnCdNm}</td>
	                 <td title="<c:out value="${result.chrgrNm}"/>"><c:out value="${result.chrgrNm}"/></td>
	                 <c:forEach var="result" items="${resultList}" varStatus="status"   >
	                    <c:if test="${name eq result.chrgrNm}"> 
	                       <div>                     	
	                          <c:if test="${result.plnHlfdayOffdayDstnctCd == '1' &&  result.plnOffdayTypeCd != '3' && result.plnOffdayTypeCd != '2'}">
	                             <td class="td-am" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
	                             <c:out value="연전"/></td></c:if>
	                          <c:if test="${result.plnHlfdayOffdayDstnctCd == '2'  && result.plnOffdayTypeCd != '3' && result.plnOffdayTypeCd != '2'}">
	                             <td class="td-pm" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
	                             <c:out value="연후"/></td></c:if>                                
	                          <c:if test="${result.plnOffdayTypeCd == '1' && result.plnHlfdayOffdayDstnctCd != '1' && result.plnHlfdayOffdayDstnctCd != '2'}">
	                             <td class="td-offday" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
	                             <c:out value="연차"/></td></c:if>
	                          <c:if test="${result.plnOffdayTypeCd == '2' && result.plnHlfdayOffdayDstnctCd != '1' && result.plnHlfdayOffdayDstnctCd != '2'}">
	                             <td class="td-reoffday" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
	                             <c:out value="대휴"/></td></c:if>
	                          <c:if test="${result.plnHlfdayOffdayDstnctCd == '1'  && result.plnOffdayTypeCd != '1' && result.plnOffdayTypeCd != '3'}">
	                             <td class="td-am" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
	                             <c:out value="대전"/></td></c:if>
	                          <c:if test="${result.plnHlfdayOffdayDstnctCd == '2'  && result.plnOffdayTypeCd != '1' && result.plnOffdayTypeCd != '3'}">
	                             <td class="td-pm" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
	                             <c:out value="대후"/></td></c:if>
	                          <c:if test="${result.plnOffdayTypeCd == '3' && result.plnHlfdayOffdayDstnctCd != '1' && result.plnHlfdayOffdayDstnctCd != '2'}">
	                             <td class="td-reoffday" onClick="openPop('	${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
	                             <c:out value="공가"/></td></c:if>
	                          <c:if test="${result.plnHlfdayOffdayDstnctCd == '1'  && result.plnOffdayTypeCd != '1' && result.plnOffdayTypeCd != '2'}">
	                             <td class="td-am" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
                                 <c:out value="공전"/></td></c:if>
	                          <c:if test="${result.plnHlfdayOffdayDstnctCd == '2'  && result.plnOffdayTypeCd != '1' && result.plnOffdayTypeCd != '2'}">
	                             <td class="td-pm" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
	                             <c:out value="공후"/></td></c:if>   
	                          <c:if test="${result.plnOffdayWrkRsnCd == '1'}">
	                             <td class="td-work" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
	                             <c:out value="당직"/></td></c:if>
	                          <c:if test="${result.plnOffdayWrkRsnCd == '2' || result.plnOffdayWrkRsnCd == '3'}">
	                             <td class="td-work" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
	                             <c:out value="PM"/></td></c:if>  
	                          <c:if test="${result.plnOffdayWrkRsnCd == '4'}">
	                             <td class="td-work" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
	                             <c:out value="기타"/></td></c:if>                       
	                          <c:if test="${result.plnOpWrkTimeCd == '1'}">
                                 <td class="td-work" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
                                 <c:out value="주간"/></td></c:if>  
	                          <c:if test="${result.plnOpWrkTimeCd == '2'}">
	                             <td class="td-work" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')">
	                             <c:out value="야간"/></td></c:if>                     
	                          <c:if test="${(result.plnOffdayWrkRsnCd == '' || result.plnOffdayWrkRsnCd == null) && (result.plnOffdayTypeCd == null || result.plnOffdayTypeCd == '')
	                              && (result.plnOpWrkTimeCd !='2' && result.plnOpWrkTimeCd !='1') && (result.chrgrNm != '관리자')}">
	                             <td onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.plnOffdayRmark}','${result.plnOffdayTypeCd}','${result.plnHlfdayOffdayDstnctCd}','${result.plnOffdayWrkRsnCd}','${result.plnOpWrkTimeCd}')"></td>
	                          </c:if>                         
	                       </div>
	                    </c:if>
	                 </c:forEach>                    
	              </tr>                     
	           </c:if>
	           <fmt:parseDate var="DlalzDate" value="${result.dlalzDate}" pattern="yyyyMMdd" />
	        </c:forEach>                                          
	     </tbody>
	  </table>
	  <p style="padding-top:7px;">※연전 : 연차오전 / 연후 : 연차오후 / 공전 : 공가오전 / 공후 : 공가오후 / 대전 : 대휴오전 / 대후 : 대휴오후 	  
	  <button type="button" onClick="opPopUp()" style="float: Right;">OP 일괄 입력</button>    
	      <%--특이사항 --%>
		  <div><br>
		     <table class="rmark">
		        <tr>
	               <th class="rmark_name">성명</th>
	               <th class="rmark_rmark">특이사항</th>
	            </tr>
	            <c:forEach var="result" items="${rmarkList}" varStatus="status"   > 
	               <c:if test="${result.sumPlnOffdayRmark != null && result.chrgrNm !='관리자'}">
	                  <tr>                   
	                     <td><c:out value="${result.chrgrNm}" /></td>
	                     <td class="rmark_rmark_td"><c:out value="${result.sumPlnOffdayRmark}" /></td>
	                  </tr>
	               </c:if>                   
	            </c:forEach>  
	         </table> <br>
		  </div> <br>
	    </div>        
	  </c:if> 
	</form>
	
	 <%-- 클릭시 팝업 --%>
	<div id="plnwrkpopup">
	<form method="POST" name="updateWorkForm" action="/dlm/wrk/updateWorkScheUpdt.do">
	<div class="popup_layer" id="popup_layer" style="display: none;">
	   <input id="selectedDate" name="selectedDate" type="hidden" value="${searchVO.selectedDate}"/>
	   <input type="hidden" class = "chrgrNo" name="chrgrNo"  id="chrgrNo"/>
	   <input type="hidden" class = "comnCdNm" name="comnCdNm"  id="comnCdNm"/>
	      <div class="popup_box">
	        <div style=" width: 500px; float: top;"></div>
	        
	        <%-- 삭제 버튼 --%>    
	        <div class="popup_btn">
	            <a href="javascript:closePop();"></a>
	        </div>
	        
	            <div class="popup_cont">
	               <h1 style="font-size:20px; padding-left : 25px; background:url(../../../images/egovframework/com/cmm/icon/tit_icon.png) no-repeat left 0px; ">근무편성표  수정</h1>
	               <div class="updtselect" >
	                  <input type="radio" name="updtselect" id="off_updt" value="휴무수정" class="radio" checked="checked"/><span class="radiotext">휴무수정</span>
	                  <input type="radio" name="updtselect" id="wrk_updt" value="근무수정" class="radio"/><span class="radiotext">근무수정</span>
	               </div>
                   <table style = "margin-top: 6%; ">         
                  
                      <tr style="height:36.8px;">          
                         <td class="popup-list">성명 <span>*</span></td>
                         <td style="padding-left: 6px">
                            <input type="text" class = "chrgrNm" name="chrgrNm"  id="chrgrNm"  readonly="true" style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%; height: 23px;"/>            
                         </td>               
                      </tr>
                      <tr style="height:20px;" ></tr>
                      <tr>                     
                  <tr style="height:36.8px; ">
                       <td class="popup-list">날짜 <span>*</span></td>
                       <td style="padding-left: 6px">
                          <input type="text" class = "dlalzDate" name="dlalzDate"  id="dlalzDate"  readonly="true" style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%;height: 23px;"/>
                       </td>
                  </tr>
                  <tr style="height:20px;" ></tr>
                  
                  <tr style="height:70px; "  id="off_type">
                       <td class="popup-list">휴무 유형 <span>*</span></td>
                       <td style="padding-left: 6px">   
                          <select path="plnOffdayTypeCd" id="plnOffdayTypeCd" name="plnOffdayTypeCd" size="1"  style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%; height: 23px; border: 1px solid #dedede;">                                       
                             <option value="" selected label="==선택하세요=="/>
                             <option value="1" label="연차"/>
                             <option value="2" label="대휴"/>
                             <option value="3" label="공가"/>
                          </select>
                          <select path="plnHlfdayOffdayDstnctCd" id="plnHlfdayOffdayDstnctCd" name="plnHlfdayOffdayDstnctCd" size="1"  style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%; height: 23px; border: 1px solid #dedede; margin-top:8px;">         
                             <option value="" selected label="전일"/>
                             <option value="1" label="오전"/>
                             <option value="2" label="오후"/>
                          </select>
                       </td>
                  </tr>
                  <tr style="height:20px;" id="tr"></tr>
                  
                  <tr style="height:36.8px; " id="rmark">
                       <td class="popup-list">특이사항 </td>
                       <td style="padding-left: 6px">
                          <input type="text" class = "plnOffdayRmark" name="plnOffdayRmark"  id="plnOffdayRmark"   style=" float: left; background:white; text-align:left; font-size: 16px; width:60%;height: 23px;"/>
                       </td>
                  </tr>
                                                    
                  <tr style="height:36.8px;" id="plnOffdayWrkRsnCdTr">
                       <td class="popup-list">휴일 근무 사유 <span>*</span></td>
                       <td style="padding-left: 6px">
                          <select path="plnOffdayWrkRsnCd" id="plnOffdayWrkRsnCd" name="plnOffdayWrkRsnCd" size="1"  style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%; height: 23px; border: 1px solid #dedede;">         
                             <option value="" selected label="==선택하세요=="/>
                             <option value="1" label="MNP당직"/>
                             <option value="2" label="정기 PM"/>
                             <option value="3" label="비정기 PM"/>
                             <option value="4" label="기타"/>
                          </select>
                       </td>               
                  </tr> 
                  
                  <tr style="height:36.8px;" id="plnOpWrkTimeCdTr">
                       <td class="popup-list">근무 유형<span>*</span></td>
                       <td style="padding-left: 6px">
                          <select path="plnOpWrkTimeCd" id="plnOpWrkTimeCd" name="plnOpWrkTimeCd" size="1"  style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%; height: 23px; border: 1px solid #dedede;">         
                             <option value="" selected label="==선택하세요=="/>
                             <option value="1" label="주간근무"/>
                             <option value="2" label="야간근무"/>
                          </select>
                       </td>               
                  </tr> 
                  </table>
                  <button type="submit" style="float: Right; margin-top:5%;">수정</button>
                  <button type="button" onClick="deleteWrk()" style="float: Right; margin-top:5%;">삭제</button>
	            </div>
	         </div>
	      </div>
	   </form>
	   
	   
	   <form method="POST" name="updateOp" action="/dlm/wrk/opWorkScheUpdt.do">
	   <!-- OP 팝업 열기 -->	
		   	<div class="opPopup_layer" id="opPopup_layer" style="display: none;">
		   		<div class="popup_box">   	
		   		
		   			<!-- 팝업 닫기 -->		
		   			<div class="popup_btn">
		            	<a href="javascript:closeOpPop();"></a>
		      		</div>
	
		            <div class="popup_cont">	            	        	        
		        		<h1 style="font-size:20px; padding-left : 25px; background:url(../../../images/egovframework/com/cmm/icon/tit_icon.png) no-repeat left 0px; ">OP 일괄 입력</h1>
						<table style = "margin-top: 6%; "> 
						        				          
		                    <tr style="height:20px;" >
		                    </tr>
		                    
							<tr style="height:36.8px;">          
		                         <td class="popup-list">근무자 선택 <span>*</span></td>
		                         <td style="padding-left: 6px">
			                         <select path="chrgrNm" id="chrgrNm" name="chrgrNm" size="1"  style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%; height: 23px; border: 1px solid #dedede;"> 
				               	        <option value="" selected label="==선택하세요=="/>        
				                        <c:forEach var="result" items="${resultList}" varStatus="status"   > 
				                            <c:if test = "${fn:contains(fn:substring(result.dlalzDate,6,8), '01') && result.chrgrNm != '관리자' && result.comnCdNm == 'OP'}">	      
				                            	<option value="${result.chrgrNm}" label="${result.chrgrNm}"/>
				                            </c:if>
				                        </c:forEach>
				                    </select>      
			                    </td>     
		                    </tr>
		                    
		                    <tr style="height:20px;" >
		                    </tr>
		                    
	                      	<tr style="height:36.8px;">
			                       <td class="popup-list">근무 시작일 <span>*</span></td>
			                       <td style="padding-left: 6px">
			                          <select path="selectedOpDate" id="selectedOpDate" name="selectedOpDate" size="1"  style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%; height: 23px; border: 1px solid #dedede;">         
			                             <option value="${searchVO.selectedDate}-03" selected label="==선택하세요=="/>
			                             <option value="${searchVO.selectedDate}-01"  label="${searchVO.selectedDate}-01"/>
			                             <option value="${searchVO.selectedDate}-02"  label="${searchVO.selectedDate}-02"/>
			                             <option value="${searchVO.selectedDate}-03"  label="삭제"/>
			                          </select>
			                       </td>               
			                  </tr>  
			                  
			                  <tr style="height:20px;" >
		                      </tr>
		                    
			                  <tr style="height:36.8px;">
			                       <td class="popup-list">근무 유형 <span>*</span></td>
			                       <td style="padding-left: 6px">
			                          <select path="plnOpWrkTimeCd" id="plnOpWrkTimeCd" name="plnOpWrkTimeCd" size="1"  style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%; height: 23px; border: 1px solid #dedede;">         
			                             <option value="" selected label="==선택하세요=="/>
			                             <option value="1"  label="주간"/>
			                             <option value="2"  label="야간"/>
			                          </select>
			                       </td>               
			                  </tr>       			                                         
	                    </table>  
	                    <button type="submit" style="float: Right; margin-top:5%;">수정</button>                     	
		   			</div>
		   	    </div>
		   	</div>
	   	</form>
	</div>
</div>
</body>
</html>