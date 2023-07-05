<%
/**
 * @Class Name : EgovDeptManageList.java
 * @Description : EgovDeptManageList jsp
 * @Modification Information
 * @
 * @  수정일                    수정자                수정내용
 * @ ---------     --------    ---------------------------
 * @ 2009.02.01    lee.m.j      최초 생성
 * @ 2015.06.16	   조정국		   	0건 조회 표시 메시지 버그수정
 *   2016.06.13    장동한         표준프레임워크 v3.6 개선
 *
 *  @author lee.m.j
 *  @since 2009.03.21
 *  @version 1.0
 *  @see
 *
 *  Copyright (C) 2009 by MOPAS  All right reserved.
 */

%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle"><spring:message code="comUssUmt.deptManage.title"/></c:set>
<!DOCTYPE html>
<html>
<head>
<title>${pageTitle} <spring:message code="title.list" /></title><!-- 부서관리 목록 -->
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<script type="text/javaScript" language="javascript" defer="defer">
$(document).ready(function () {
	fn_FocusStart();
});

function fncSelectDeptManageList(pageNo){
    document.listForm.searchCondition.value = "1";
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/uss/umt/dpt/selectDeptManageList.do'/>";
    document.listForm.submit();
}

function fncSelectDeptManage(cmpnyNo, deptNo) {
    document.listForm.cmpnyNo.value = cmpnyNo;
    document.listForm.deptNo.value = deptNo;
    document.listForm.action = "<c:url value='/uss/umt/dpt/getDeptManage.do'/>";
    document.listForm.submit();
}

function fncAddDeptManageInsert() {
	if(document.listForm.pageIndex.value == "") {
		document.listForm.pageIndex.value = 1;
	}
    document.listForm.action = "<c:url value='/uss/umt/dpt/addViewDeptManage.do'/>";
    document.listForm.submit();
}

function linkPage(pageNo){
    document.listForm.searchCondition.value = "1";
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/uss/umt/dpt/selectDeptManageList.do'/>";
    document.listForm.submit();
}

/* ********************************************************
 * focus 시작점 지정함수
 ******************************************************** */
function fn_FocusStart(){
	$('#F1').focus();
}

function press() {

    if (event.keyCode==13) {
    	fncSelectDeptManageList('1');
    }
}
</script>

</head>

<body>

<!-- javascript warning tag  -->
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<form name="listForm" method="post"> 
<div class="board">
	<h1>${pageTitle} <spring:message code="title.list" /></h1>
	<!-- 검색영역 -->
	<div class="search_box" title="<spring:message code="common.searchCondition.msg" />">
		<ul>
			<li><div style="line-height:4px;">&nbsp;</div><div>부서명 : </div></li><!-- 부서명 -->
			<!-- 검색키워드 및 조회버튼 -->
			<li>
				<input id="F1" class="s_input" name="searchKeyword" type="text"  size="35" title="<spring:message code="title.search" /> <spring:message code="input.input" />" value='<c:out value="${deptManageVO.searchKeyword}"/>'  maxlength="155" >
				<input type="submit" class="s_btn" value="<spring:message code="button.inquire" />" title="<spring:message code="title.inquire" /> <spring:message code="input.button" />" /><!-- 조회 -->
				<span class="btn_b"><a href="<c:url value='/uss/umt/dpt/addViewDeptManage.do'/>" onClick="fncAddDeptManageInsert(); return false;"  title="<spring:message code="button.create" /> <spring:message code="input.button" />"><spring:message code="button.create" /></a></span><!-- 등록 -->
			</li>
		</ul>
	</div>
	
	<!-- 목록영역 -->
	<table class="board_list" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
	<caption>${pageTitle} <spring:message code="title.list" /></caption>
	<colgroup>
		<col style="width: 100px">
		<col style="width: 100px">
		<col style="width: 100px">
		<col style="width: 100px">
	</colgroup>
	<thead>
	<tr>
		<th>회사명</th>
		<th>부서 번호</th>
		<th class="board_th_link">부서명</th>
		<th>등록일</th>
	</tr>
	</thead>
	<tbody class="ov">
	<c:if test="${fn:length(deptManageList) == 0}">
	<tr>
		<td colspan="4"><spring:message code="common.nodata.msg" /></td>
	</tr>
	</c:if>
	<c:forEach var="deptManage" items="${deptManageList}" varStatus="status">
	<tr onclick="fncSelectDeptManage('<c:out value="${deptManage.cmpnyNo}"/>', '<c:out value="${deptManage.deptNo}"/>'); return false;">  		 
		<td><c:out value="${deptManage.cmpnyNm}"/></td>
		<td><c:out value="${deptManage.deptNo}"/></td>
		<td><c:out value="${deptManage.deptNm}"/></td>
		<td><c:out value="${fn:substring(deptManage.rdtt,0,10)}"/></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	
	<!-- paging navigation -->
	<c:if test="${!empty deptManageVO.pageIndex }">
	<div class="pagination">
		<ul><ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage"/></ul>
	</div>
	</c:if>
	
</div><!-- end div board -->
<input name="deptNo" type="hidden">
<input name="cmpnyNo" type="hidden" value="<c:out value='${deptManage.cmpnyNo}'/>">
<input name="pageIndex" type="hidden" value="<c:out value='${deptManageVO.pageIndex}'/>">
<input type="hidden" name="searchCondition" value="1">
</form>


</body>
</html>
