<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
 /**
  * @Class Name : ComnDateMngList.jsp
  * @Description : 공통일자 조회 및 날짜 일괄등록 화면 
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.05.23   이유리               최초 생성
  *
  *  @author 이유리
  *  @since 2022.05.23
  *  @version 1.0
  *  @see
  *
  */
%>

<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>공통일자 관리 목록</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<!-- 달력 기본 설정 -->
<script type="text/javascript" src="<c:url value='/js/truebon/com/cmm/initDatepicker.js' />"></script>

<script language="javascript1.2" type="text/javaScript">
<!--
$(document).ready(function () {
	fn_FocusStart();
});

/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
	document.comnDateMngForm.pageIndex.value = pageNo;
	document.comnDateMngForm.action = "<c:url value='/dlm/cod/ComnDateMngList.do'/>";
   	document.comnDateMngForm.submit();
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectComnDateMng() {
	document.comnDateMngForm.pageIndex.value = 1;
	document.comnDateMngForm.action = "<c:url value='/dlm/cod/ComnDateMngList.do'/>";
	document.comnDateMngForm.submit();
}

/* ********************************************************
 * 입력 화면 호출 함수
 ******************************************************** */
function insertComnDateMngList() {
	var getYear = document.getElementById('selectedDate').value;
	if(getYear != ""){
		var getDay="";
		var getLastDate="";
		for(var i=1;i<13;i++){
			getLastDate += (new Date(getYear,i,0).getDate().toString()) + ",";
			getDay += (new Date(getYear+"-"+i.toString()+"-01").getDay().toString()) + ",";
		}
		document.comnDateMngForm.checkDate.value = getYear+"0101";
		document.comnDateMngForm.lastDate.value = getLastDate;
		document.comnDateMngForm.DayOfCheckDate.value = getDay;
		document.comnDateMngForm.action = "<c:url value='/dlm/cod/insertComnDateMngRegist.do'/>";
   		document.comnDateMngForm.submit(); 
	}else{
		alert("년도를 선택해주세요.");
	}
}

/* ********************************************************
 * 상세조회처리 함수
 ******************************************************** */
function selectComnDateMngListDetail(stdrDate,dyweekDstnctCd) {
	document.comnDateMngForm.stdrDate.value = stdrDate;
	document.comnDateMngForm.dyweekDstnctCd.value = dyweekDstnctCd;
   	document.comnDateMngForm.action = "<c:url value='/dlm/cod/ComnDateMngUpdt.do'/>";
   	document.comnDateMngForm.submit();
}

/* ********************************************************
 * focus 시작점 지정함수
 ******************************************************** */
function fn_FocusStart(){
	$('#F1').focus();
}

/* ********************************************************
 * 엔터key 목록조회  함수
 ******************************************************** */
function press() {
    if (event.keyCode==13) {
    	selectComnDateMng();
    }
}

/* ********************************************************
 * 날짜 초기화 함수
 ******************************************************** */
function initializeDate(){
	document.getElementById("searchDate").value = null;
}


<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
-->

</script>
<script type="text/javascript">

	$(document).ready(function(){

		
		$('.searchDate').datepicker( {		
	        changeYear: true,
	        changeMonth: true,
	        showButtonPanel: true,
	        gotoCurrent: true,
	        currentText:"현재달",
	        dateFormat: 'yy-mm',
	        beforeShow: function(input) {
	            $(input).datepicker("widget").addClass('hide-calendar');
	        },
	        onClose: function(dateText, inst) { 
	            $(this).datepicker('setDate', new Date(inst.selectedYear, inst.selectedMonth, 1)); 
	        } 
	    });	   
 		
 		
 		$('.sdate').datepicker( {
	        changeYear: true,
	        showButtonPanel: true,
	        gotoCurrent: true,
	        currentText:"현재년도",
	        dateFormat: 'yy',
	        stepMonths: 12,
	        beforeShow: function(input) {
	            $(input).datepicker("widget").addClass('hide-month-calendar');
	        },
	        onClose: function(dateText, inst) { 
	            $(this).datepicker('setDate', new Date(inst.selectedYear, 1));
	            $(this).datepicker("widget").removeClass('hide-month-calendar');
	        } 
	    });	  
		
		$(".colorChange").each(function(){
			if($(this).find('#hdayNm').html() != ""){
				$(this).find('#dyweek').css('color','#FF0000');
			}
		});
	});
	
</script>
<style>
.hide-calendar .ui-datepicker-calendar {
    display: none;
}
.hide-month-calendar .ui-datepicker-calendar {
    display: none;
}
.hide-month-calendar .ui-datepicker-month{
	display: none;	
}
</style>
</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<div class="board">
	<h1>공통일자관리 목록</h1>
	<form name="comnDateMngForm" action ="<c:url value='/dlm/cod/ComnDateMngList.do' />" method="post">
	<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
	<input name="stdrDate" type="hidden" />
	<input name="DayOfCheckDate" type="hidden" />
	<input name="lastDate" type="hidden" />
	<input name="checkDate" type="hidden" />
	<input name="dyweekDstnctCd" type="hidden" />
	
	<div class="search_box" title="공통일자" style="background-image: url(/images/truebon/com/dlm/cod/dash_line.gif); background-position:77% center; background-repeat:no-repeat;">
		<ul class="search_box_in">
 			<li>
				<label for="">날짜(월) : </label>
				<input id="searchDate" name="searchKeyword" type="text" class="searchDate" value="${searchVO.searchKeyword}" />
				<input class="s_btn" type="submit"  value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectComnDateMng(); return false;" /><!-- 조회 -->
				<span class="btn_b"><a href="#LINK'/>" onclick="initializeDate(); return false;">초기화</a></span><!-- 초기화 -->
			</li>
			<li style="margin-left: 55px">
				<label for="">날짜(년도) : </label>
				<input id="selectedDate" name="selectedDate" type="text" class="sdate" value=""/>
				<span class="btn_b"><a href="#LINK" onclick="insertComnDateMngList(); return false;" title='<spring:message code="button.create" />'><spring:message code="button.create" /></a></span><!-- 등록 -->
			</li>
		</ul>
	</div>

	<table class="board_list">
		<caption></caption>
		<colgroup>
			<col style="width:15%" />
			<col style="width:15%" />
			<col style="width:15%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">날짜</th>
				<th scope="col">요일</th>
				<th scope="col">공휴일명</th>
			 </tr>
		</thead>
		<tbody class="ov">
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			 <c:if test="${fn:length(resultList) == 0}">
				 <tr>
					 <td colspan="3">
						<spring:message code="common.nodata.msg" />
					 </td>
				 </tr>
			 </c:if>
			 
			 <c:forEach var="result" items="${resultList}" varStatus="status">
				<tr class="colorChange" href="#LINK"  onclick="selectComnDateMngListDetail('<c:out value="${result.stdrDate}"/>','<c:out value="${result.dyweekDstnctCd}"/>'); return false;" >
					<td>
						<fmt:parseDate var="StdrDate" value="${result.stdrDate}" pattern="yyyyMMdd" />
					 	<fmt:formatDate value="${StdrDate}" pattern="yyyy-MM-dd" />	
					</td>
					<td id="dyweek">
						<c:if test="${result.dyweekDstnctCd eq '1'}">일요일</c:if>
						<c:if test="${result.dyweekDstnctCd eq '2'}">월요일</c:if>
						<c:if test="${result.dyweekDstnctCd eq '3'}">화요일</c:if>
						<c:if test="${result.dyweekDstnctCd eq '4'}">수요일</c:if>
						<c:if test="${result.dyweekDstnctCd eq '5'}">목요일</c:if>
						<c:if test="${result.dyweekDstnctCd eq '6'}">금요일</c:if>
						<c:if test="${result.dyweekDstnctCd eq '7'}">토요일</c:if>
					</td>
					<td id="hdayNm"><c:out value="${result.hdayNm}"/></td>
				  </tr>
			 </c:forEach>
		</tbody>
	</table>

	<!-- paging navigation -->
	<div class="pagination">
		<ul>
			<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage"/>
		</ul>
	</div>
	</form>
</div>
</body>
</html>