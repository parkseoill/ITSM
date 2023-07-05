<!DOCTYPE html>
<%--
 /**
  * @Class Name : RequestMngList.jsp
  * @Description : 요청 통계  조회 화면
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.10.20       김도아    	      최초 생성
  *
  *  @author 김도아
  *  @since 2022.10.20
  *  @version 1.0
  *  @see
  *
  */
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>요청 통계 목록</title>
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
/* ********************************************************
 * 달력 텍스트 박스 날짜 세팅
 ******************************************************** */
$(document).ready(function(){
	// 달력
	$( "#startDate" ).datepicker({
		changeMonth: true, 
		changeYear: true,
		onClose: function( selectedDate ) {    
		     //시작일(startDate) datepicker가 닫힐때
		     //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
		    $("#endDate").datepicker( "option", "minDate", selectedDate );
		},
	});
	$( "#endDate" ).datepicker({
		changeMonth: true, 
		changeYear: true,
		onClose: function( selectedDate ) {    
		    // 종료일(endDate) datepicker가 닫힐때
		    // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
		    $("#startDate").datepicker( "option", "maxDate", selectedDate );
		},
	});
      
}); 
$(document).ready(function () {
	fn_FocusStart();
	
	fn_checkAll();
});
/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectReqMng() {
	document.RequestMngForm.action = "<c:url value='/sta/req/RequestMngList.do'/>";
	document.RequestMngForm.submit();
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
    	selectSrMasterMng();
    }
}


$(document).ready(function(){
	$(".stareq").css("display","none");
	$(".reqdept").css("display","none");
 
	<c:if test="${searchVO.searchCondition eq '1'}">
	$(".stareq").css("display","none");
	$(".reqdept").css("display","none");
	</c:if>
	<c:if test="${searchVO.searchCondition eq '2'}">
	$(".reqchr").css("display","none");
	$(".reqdept").css("display","none");
	</c:if>
	<c:if test="${searchVO.searchCondition eq '3'}">
	$(".reqchr").css("display","none");
	$(".stareq").css("display","none");
	</c:if>
});

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
//-->
</script>

</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<div class="board">
	<h1>요청 통계 목록</h1>
	<form name="RequestMngForm" id="RequestMngForm" action ="<c:url value='/sta/req/RequestMngList.do' />" method="post">
	<input type="hidden" name="dlngChrgrNo" value="<c:out value='${result.dlngChrgrNo}'/>">

	<div class="search_box">
		<ul style="background-image: url(/images/truebon/com/dlm/cod/dash_line.gif); background-position:47% center; background-repeat:no-repeat;">
<%-- 			<li style="padding-left:10%; float:left;">
				<label for="">기간 : </label>
				<input class="s_input3 vat" id="sdate" name="selectedDate" type="text" value="${searchVO.selectedDate}" cssStyle="padding-left:5px;" />
			</li>  --%>
			<li style="padding-left:3%; float:left;">
				<label for="">기간 : </label> &nbsp;
				<input class="s_input3 vat" name="startDate" id="startDate" type="text"  value="<c:out value='${searchVO.startDate}'/>" onkeypress="press();"  />
				~	<input class="s_input3 vat" name="endDate" id="endDate" type="text"  value="<c:out value='${searchVO.endDate}'/>" onkeypress="press();"  />&emsp;&emsp;&emsp;
			</li> 
			<li style="padding-right:10%;">
				<label for="">검색조건 : </label>
				<input style="vertical-align: middle;" checked="checked" type="radio" name="searchCondition"<c:if test="${searchVO.searchCondition == '1'}">checked="checked"</c:if> value="1">담당자별   </input>&nbsp;
				<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '2'}">checked="checked"</c:if> value="2">요청구분별   </input>&nbsp;
				<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '3'}">checked="checked"</c:if> value="3">부서별   </input>
			</li>
			<li>
				<input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectReqMng(); return false;" /><!-- 조회 -->
			</li>
		</ul>
	</div>

	<table class="board_list">
		<caption></caption>
		<colgroup>
			<col style="width:25%" />
			<col style="width:21%" />
			<col style="width:21%" />
			<col style="width:21%" />
			<col style="width:22%" />
		</colgroup>
		<thead>
			<tr>	      
			<c:if test="${searchVO.searchCondition eq '1' || searchVO.searchCondition eq ''}">
			   <th scope="col" class="reqchr">담당자명</th>
			</c:if>
			<c:if test="${searchVO.searchCondition eq '2'}">
			   <th scope="col" class="stareq">요청구분</th>
			</c:if>
			<c:if test="${searchVO.searchCondition eq '3'}">
			   <th scope="col" class="reqdept">부서별</th>
			</c:if>
			   <th scope="col">요청건</th>
			   <th scope="col">처리건</th>
			   <th scope="col">미처리건</th>
			   <th scope="col">지연건</th>
			</tr>
		</thead>
		<tbody class="ov">
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(resultList) == 0}">
			<tr>
				<td colspan="5">
					<spring:message code="common.nodata.msg" />
				</td>
			</tr>
			</c:if>
			 
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr onclick="selectSrMasterMngListDetail('<c:out value="${result.dlngChrgrNm}"/>'); return false;">
				<c:if test="${searchVO.searchCondition eq '1' || searchVO.searchCondition eq ''}">
				   <td scope="col" class="reqchr"><c:out value="${result.dlngChrgrNm}"/></td>
				</c:if>
				<c:if test="${searchVO.searchCondition eq '2'}">
				   <td scope="col" class="stareq"><c:out value="${result.srTypeComNm}"/></td>
				</c:if>
				<c:if test="${searchVO.searchCondition eq '3'}">
				   <td scope="col" class="reqdept"><c:out value="${result.positDeptNm}"/></td>
				</c:if>
				<td>
					<c:out value="${result.reqCnt}"/>
				</td>
				<td>
					<c:out value="${result.proCnt}"/>
				</td>
				<td>			    
					<c:out  value="${result.unproCnt}"/>
				</td>
				<td>
					<c:out value="${result.delroCnt}"/>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	</form>

</div>

</body>
</html>