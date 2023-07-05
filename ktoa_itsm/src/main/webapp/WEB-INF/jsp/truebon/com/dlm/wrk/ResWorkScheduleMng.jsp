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
 ******************************************************* */
 $(document).ready(function(){

	    $('#offdayWrkRsnCdTr').hide();   // 초깃값 설정
	    $('#opWrkTimeCdTr').hide(); //OP 근무 유형  

	    $("input[name='updtselect']").change(function(){           
	      // 휴무수정 선택 시.
	      if($("input[name='updtselect']:checked").val() == '휴무수정'){
	            $('#off_type').show();    //휴무 유형
	            $('#rmark').show();    //휴무 특이사항
	            $('#tr').show();    //tr 공백
	            
	            $('#opWrkTimeCdTr').hide(); //OP 근무 유형
	            $('#opWrkTimeCd').prop("disabled", true );
	            
	            $('#offdayWrkRsnCdTr').hide(); //휴일 근무 사유
	            $('#offdayWrkRsnCd').prop("disabled", true );
	            
	            $('#offdayTypeCd').prop("disabled", false);
	            $('#hlfdayOffdayDstnctCd').prop("disabled", false);
	            $('#rmarkText').prop("disabled", false);//특이사항                
	      }   
	      
	      // 근무수정 결제 선택 시.
	      else if($("input[name='updtselect']:checked").val() == '근무수정'){        
	         $('#off_type').hide();    //휴무 유형
	         $('#rmark').hide();    //휴무 특이사항
	         $('#tr').hide();    //tr 공백 제거       
	         
	         $('#offdayWrkRsnCdTr').show(); //휴일 근무 사유
	         $('#offdayWrkRsnCd').prop("disabled", false);
	         
	         $('#offdayTypeCd').prop("disabled", true );
	         $('#hfdayOffdayDstnctCd').prop("disabled", true );
	         $('#rmarkText').prop("disabled", true);
	         
	         
	         if($('#comnCdNm').val() == 'OP'){    
	            $('#offdayWrkRsnCdTr').hide(); //휴일 근무 사유
	            $('#opWrkTimeCdTr').show(); //OP 근무 유형      
	            
	            $('#offdayWrkRsnCd').prop("disabled", true);
	            $('#opWrkTimeCd').prop("disabled", false );
	           }
	      }
	   });
	      
	});


/* ********************************************************
 * 계획 처리 함수 
 ******************************************************** */
 function WorkScheduleMng() { 
	 var getDate = document.getElementById('selectedDate').value;
	 location.href = "<c:url value='/dlm/wrk/WorkScheduleMng.do' />?selectedDate=<c:out value='${searchVO.selectedDate}'/>";
   } 


 /* ********************************************************
  * 삭제 처리 함수
  ******************************************************** */
  function deleteWrk() { 
	  if($("input[name='updtselect']:checked").val() == '휴무수정'){
		  document.updateWorkForm.offdayTypeCd.value = '';
		  document.updateWorkForm.action = "<c:url value='/dlm/wrk/ResUpdateWorkScheUpdt.do'/>";
		  document.updateWorkForm.submit();
	  }
	  else if($("input[name='updtselect']:checked").val() == '근무수정'){
		  document.updateWorkForm.offdayWrkRsnCd.value = '';
		  document.updateWorkForm.opWrkTimeCd.value = '';
		  document.updateWorkForm.action = "<c:url value='/dlm/wrk/ResUpdateWorkScheUpdt.do'/>";
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
    document.WorkScheduleMngForm.action = "<c:url value='/dlm/wrk/ResWorkScheduleMng.do'/>";
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
function openPop(resultName, dlalzDate, chrgrNo, comnCdNm , rmarkText, offdayTypeCd, hlfdayOffdayDstnctCd, offdayWrkRsnCd, opWrkTimeCd) {
	
 	if("${nowDate}".substring(0,7) == "${searchVO.selectedDate}"){	//현재 달만 클릭 가능 
 		var nowDate = parseInt("${nowDate}".substring(8,10));  //현재 날짜
 		var clickDate = parseInt(dlalzDate.substring(6,8));  //클릭 날짜
 		if(nowDate <= clickDate || "${user}" == "webmaster" ){  //오늘 날짜보다  같거나 클때 or 관리자 일때
	 	    document.getElementById("popup_layer").style.display = "block";	
		    document.getElementById("chrgrNm").value = resultName;
			document.getElementById("chrgrNo").value = chrgrNo;
		    document.getElementById("dlalzDate").value = dlalzDate;  
		    document.getElementById("rmarkText").value = rmarkText;	
		    document.getElementById("offdayTypeCd").value = offdayTypeCd;	
		    document.getElementById("hlfdayOffdayDstnctCd").value = hlfdayOffdayDstnctCd;	
		    document.getElementById("offdayWrkRsnCd").value = offdayWrkRsnCd;	
			document.getElementById("opWrkTimeCd").value = opWrkTimeCd;
		    document.getElementById("comnCdNm").value = comnCdNm;  
		    
		    if($('#comnCdNm').val() == 'OP' && $("input[name='updtselect']:checked").val() == '근무수정'){
		    	$('#offdayWrkRsnCdTr').hide();
		        $('#opWrkTimeCdTr').show(); //OP 근무 유형
		       }
		    else if($('#comnCdNm' ).val() != 'OP' && $("input[name='updtselect']:checked").val() == '근무수정') {
		    	$('#offdayWrkRsnCdTr').show();
		        $('#opWrkTimeCdTr').hide(); //OP 근무 유형
		    }
 		}
 		else{
 			alert("지난 날짜는 수정이 불가 합니다. 관리자에게 문의 하십시오.");	
 		}
 	}	
	else{
		alert("실적은 현재달만 수정이 가능합니다.");
	}
}


//팝업 닫기
function closePop() {   
    document.getElementById("popup_layer").style.display = "none";
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

// 기간 설정
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
   <form name="WorkScheduleMngForm" action ="<c:url value='/dlm/wrk/ResWorkScheduleMng.do' />" method="post">
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
            <span>  ※ 현황 페이지는 근태 관리(실적)에 바로 반영 됩니다.</span>
         </li>
       <li style="padding-right:4%;">
            <label for="">구분 : </label>
         <input type="radio" class="res" id="res" name="plnresselect" value="현황" checked="checked">현황</input>
         <input type="radio" class="pln" id="pln" name="plnresselect" value="계획" onclick="javascript:WorkScheduleMng()">계획</input>       
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
   	<!-- 근무편성표  (현황) -->
	   	<div id="reswrkcontent">
		   <table class="t1" id="table">
	         <thead>            
	            <tr>                 
	               <c:forEach var="result" items="${resultList}" varStatus="status"   >
	                   <c:if test="${status.first}">  
	                      <th colspan="33" style="font-size: 24px; font-weight:blod; background-color:#DAE7F6; padding:0.7% ;"/> ${fn:substring(result.dlalzDate,4,6)}월 근무편성표 - 현황</th>
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
		            <c:if test = "${fn:contains(fn:substring(result.dlalzDate,6,8), '01')  && result.chrgrNm != '관리자'}">
		               <c:set var="name" value="${result.chrgrNm}"/>
		               <tr class="WrkSche-table">
		                  <td>${result.comnCdNm}</td>
		                  <td title="<c:out value="${result.chrgrNm}"/>"><c:out value="${result.chrgrNm}"/></td>
		                  <c:forEach var="result" items="${resultList}" varStatus="status"   >
	                        <c:if test="${name eq result.chrgrNm}"> 
	                          <div>
	                            <c:if test="${result.hlfdayOffdayDstnctCd == '1' &&  result.offdayTypeCd != '3' && result.offdayTypeCd != '2'}">
	                               <td class="td-am" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="연전"/></td></c:if>
	                            <c:if test="${result.hlfdayOffdayDstnctCd == '2'  && result.offdayTypeCd != '3' && result.offdayTypeCd != '2'}">
	                               <td class="td-pm" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="연후"/></td></c:if>                                
	                            <c:if test="${result.offdayTypeCd == '1' && result.hlfdayOffdayDstnctCd != '1' && result.hlfdayOffdayDstnctCd != '2'}">
	                               <td class="td-offday" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="연차"/></td></c:if>
	                            <c:if test="${result.offdayTypeCd == '2' && result.hlfdayOffdayDstnctCd != '1' && result.hlfdayOffdayDstnctCd != '2'&& result.comnCdNm !='OP'}">
	                               <td class="td-reoffday" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="대휴"/></td></c:if>
	                            <c:if test="${result.offdayTypeCd == '2' && result.hlfdayOffdayDstnctCd != '1' && result.hlfdayOffdayDstnctCd != '2'&& result.comnCdNm =='OP' 
	                                && (result.opWrkTimeCd !='2' && result.opWrkTimeCd !='1')}">
	                               <td onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}', '${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               </td></c:if>
	                            <c:if test="${result.hlfdayOffdayDstnctCd == '1'  && result.offdayTypeCd != '1' && result.offdayTypeCd != '3'}">
	                               <td class="td-am" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="대전"/></td></c:if>
	                            <c:if test="${result.hlfdayOffdayDstnctCd == '2'  && result.offdayTypeCd != '1' && result.offdayTypeCd != '3'}">
	                               <td class="td-pm" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="대후"/></td></c:if>
	                            <c:if test="${result.offdayTypeCd == '3' && result.hlfdayOffdayDstnctCd != '1' && result.hlfdayOffdayDstnctCd != '2'}">
	                               <td class="td-reoffday" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="공가"/></td></c:if>
	                            <c:if test="${result.hlfdayOffdayDstnctCd == '1'  && result.offdayTypeCd != '1' && result.offdayTypeCd != '2'}">
	                               <td class="td-am" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="공전"/></td></c:if>
	                            <c:if test="${result.hlfdayOffdayDstnctCd == '2'  && result.offdayTypeCd != '1' && result.offdayTypeCd != '2'}">
	                               <td class="td-pm" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="공후"/></td></c:if>   
	                            <c:if test="${result.offdayWrkRsnCd == '1'}">
	                               <td class="td-work" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="당직"/></td></c:if>
	                            <c:if test="${result.offdayWrkRsnCd == '2' || result.offdayWrkRsnCd == '3'}">
	                               <td class="td-work" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="PM"/></td></c:if>  
	                            <c:if test="${result.offdayWrkRsnCd == '4'}">
	                               <td class="td-work" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="기타"/></td></c:if> 
	                            <c:if test="${result.opWrkTimeCd == '1'}">
	                               <td class="td-work" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="주간"/></td></c:if>  
	                            <c:if test="${result.opWrkTimeCd == '2'}">
	                               <td class="td-work" onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')">
	                               <c:out value="야간"/></td></c:if>                             
	                            <c:if test="${(result.offdayWrkRsnCd == '' || result.offdayWrkRsnCd == null) && (result.offdayTypeCd == null || result.offdayTypeCd == '') && 
	                               (result.opWrkTimeCd !='2' && result.opWrkTimeCd !='1') && (result.chrgrNm != '관리자') }">
	                               <td onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}', '${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')"></td> </c:if>
	                            <c:if test="${result.offdayTypeCd == '0' && (result.hlfdayOffdayDstnctCd != '1'&& result.hlfdayOffdayDstnctCd != '2') && 
	                                 (result.offdayWrkRsnCd == null ||result.offdayWrkRsnCd == ''||result.offdayWrkRsnCd == '0')
	                                  && (result.chrgrNm != '관리자') && (result.opWrkTimeCd !='2' && result.opWrkTimeCd !='1')}">
	                               <td onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')"></td></c:if>
	                            <c:if test="${(result.offdayTypeCd == '4') && result.offdayWrkRsnCd != '1' && result.offdayWrkRsnCd != '2' && result.offdayWrkRsnCd != '3'}">
	                               <td onClick="openPop('${result.chrgrNm }','${result.dlalzDate}','${result.chrgrNo}','${result.comnCdNm}','${result.rmarkText}','${result.offdayTypeCd}','${result.hlfdayOffdayDstnctCd}','${result.offdayWrkRsnCd}','${result.opWrkTimeCd}')"></td></c:if>
	                          </div>
                        	</c:if>
	                      </c:forEach>                    
	               	    </tr>                     
	                 </c:if>
	                 <fmt:parseDate var="DlalzDate" value="${result.dlalzDate}" pattern="yyyyMMdd" />
		          </c:forEach>                                          
	           </tbody>
           </table>
       
           <%-- 특이사항 --%>      
           <div><br>
             <table class="rmark">
                 <tr>
                    <th class="rmark_name">성명</th>
                    <th class="rmark_rmark">특이사항</th>
                 </tr>
                  <c:forEach var="result" items="${rmarkList}" varStatus="status"   > 
                  <c:if test="${result.sumOffdayRmark != null && result.chrgrNm !='관리자'}">
                    <tr>                   
                       <td><c:out value="${result.chrgrNm}" /></td>
                       <td class="rmark_rmark_td"><c:out value="${result.sumOffdayRmark}" /></td>
                    </tr>
                  </c:if>
                  </c:forEach>  
              </table><br>
           </div> <br>
        </div>
      </c:if> 
   </form>
	 
	 <%-- 클릭시 팝업 --%> 
	<form method="POST" name="updateWorkForm" action="/dlm/wrk/ResUpdateWorkScheUpdt.do">
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
                   
                   <tr style="height:20px;"></tr>
                   <tr style="height:36.8px; ">
                      <td class="popup-list">날짜 <span>*</span></td>
                      <td style="padding-left: 6px">
                         <input type="text" class = "dlalzDate" name="dlalzDate"  id="dlalzDate"  readonly="true" style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%;height: 23px;"/>
                      </td>
                   </tr>
                   <tr style="height:20px;" ></tr>
                  
                   <tr style="height:70px;" id="off_type">
                      <td class="popup-list">휴무 유형 <span>*</span></td>
                      <td style="padding-left: 6px">   
                         <select path="offdayTypeCd" id="offdayTypeCd" name="offdayTypeCd" size="1"  style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%; height: 23px; border: 1px solid #dedede;">                                       
                            <option value="" selected label="==선택하세요=="/>
                            <option value="1" label="연차"/>
                            <option value="2" label="대휴"/>
                            <option value="3" label="공가"/>
                         </select>
                         <select path="hlfdayOffdayDstnctCd" id="hlfdayOffdayDstnctCd" name="hlfdayOffdayDstnctCd" size="1"  style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%; height: 23px; border: 1px solid #dedede; margin-top:8px;">         
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
                         <input type="text" class = "rmarkText" name="rmarkText"  id="rmarkText"   style=" float: left; background:white; text-align:left; font-size: 16px; width:60%;height: 23px;"/>
                      </td>
                   </tr>	                                   
                  
                   <tr style="height:36.8px;" id="offdayWrkRsnCdTr">
                      <td class="popup-list">휴일 근무 사유 <span>*</span></td>
                      <td style="padding-left: 6px">
                         <select path="offdayWrkRsnCd" id="offdayWrkRsnCd" name="offdayWrkRsnCd" size="1"  style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%; height: 23px; border: 1px solid #dedede;">         
                            <option value="" selected label="==선택하세요=="/>
                            <option value="1" label="당직"/>
                            <option value="2" label="정기 PM"/>
                            <option value="3" label="비정기 PM"/>
                            <option value="4" label="기타"/>
                         </select>
                      </td>               
                   </tr>                   
                   
                   <tr style="height:36.8px;" id="opWrkTimeCdTr">
                      <td class="popup-list">근무 유형<span>*</span></td>
                      <td style="padding-left: 6px">
                         <select path="opWrkTimeCd" id="opWrkTimeCd" name="opWrkTimeCd" size="1"  style=" float: left; color:gray; text-align:left; font-size: 16px; width:60%; height: 23px; border: 1px solid #dedede;">         
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
</div>
</body>
</html>