<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>담당자 목록</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<script language="javascript1.2" type="text/javaScript">
<!--
/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
	document.chargerMngForm.pageIndex.value = pageNo;
	document.chargerMngForm.action = "<c:url value='/dlm/vis/VisitMngListPopup.do'/>";
   	document.chargerMngForm.submit();
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectChargerMng() {
	document.chargerMngForm.pageIndex.value = 1;
	document.chargerMngForm.action = "<c:url value='/dlm/vis/VisitMngListPopup.do'/>";
	document.chargerMngForm.submit();
}
/* ********************************************************
 * 담당자목록 선택 처리 함수
 ******************************************************** */
 function getChargerNm(vCmpnyNm,vChrgrNm,vTel,vChrgrNo) {
		var parentFrom = parent.document.getElementsByTagName('form');
		parentFrom[0].cmpnyNm.value = vCmpnyNm;
		parentFrom[0].chrgrNm.value = vChrgrNm;
		parentFrom[0].chrgrWirelsTelNo.value = vTel;
		parentFrom[0].chrgrNo.value = vChrgrNo;
	    parent.$('.ui-dialog-content').dialog('close');
	}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
-->

</script>
<script type="text/javascript">
    $(document).ready(function () {
    	
	});
</script>

</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<div class="popup" >
	<h1>담당자 목록</h1>
	<form name="chargerMngForm" action ="<c:url value='/dlm/vis/VisitMngListPopup.do' />" method="post">
	<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
	
	<div class="pop_search_box" title="담당자명">
		<ul>
			<li>
				<input style="vertical-align: middle;" checked="checked" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '1'}">checked="checked"</c:if> value="1">담당자명 </input>
				<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '2'}">checked="checked"</c:if> value="2">회사명 </input>
				<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '3'}">checked="checked"</c:if> value="3">연락처 </input>
			</li>
			<li>
				<input id="F1" class="s_input"  style="width: 140px; height:19px;" name="searchKeyword" type="text" value="<c:out value='${searchVO.searchKeyword}'/>" size="60" maxlength="60" onkeypress="press();" title="<spring:message code="title.searchCondition" />" /><!-- 검색조건 -->
				
				<input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectChargerMng(); return false;" /><!-- 조회 -->
			</li>
		</ul>
	</div>

	<table class="pop_board_list" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
		<caption>${pageTitle} <spring:message code="title.list" /></caption>
		
		<thead>
			<tr>
			   <th class="board_th_link">회사</th>
			   <th>담당자명</th>
			   <th>연락처</th>
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
			  	<tr onClick="getChargerNm('<c:out value="${result.positCmpnyNm}"/>','<c:out value="${result.chrgrNm}"/>','<c:out value="${result.chrgrWirelsTelNo}"/>','<c:out value="${result.chrgrNo}"/>'); return false;">
			    <td class="lt_text" nowrap="nowrap">
		            <c:out value="${result.positCmpnyNm}"/>
			    </td>
			    <td class="lt_text" nowrap="nowrap">
		            <c:out value="${result.chrgrNm}" />
			    </td>
			    <td class="lt_text" nowrap="nowrap">
		            <c:out value="${result.chrgrWirelsTelNo}" />
			    </td>
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