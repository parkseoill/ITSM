<%
/**
 * @Class Name : EgovDeptManageList.java
 * @Description : EgovDeptManageListPopup jsp
 * @Modification Information
 * @
 * @  수정일                    수정자                수정내용
 * @ ---------     --------    ---------------------------
 * @ 2022.05.25    이태신      최초 생성
 *
 *  @author 이태신
 *  @since 2022.05.25
 *  @version 1.0
 *  @see
 * 
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
// 조회
function fncSelectDeptManageList(pageNo){
	document.listForm.searchCondition.value = "1";
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/uss/umt/dpt/selectDeptManageListPopup.do'/>";
    document.listForm.submit();
}

// 페이지 링크
function linkPage(pageNo){
    document.listForm.searchCondition.value = "1";
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/uss/umt/dpt/selectDeptManageListPopup.do'/>";
    document.listForm.submit();
}

// 엔터
function press() {
    if (event.keyCode==13) {
    	fncSelectDeptManageList('1');
    }
}

/* ********************************************************
 * 부서목록 선택 처리 함수
 ******************************************************** */
function choiceDeptListSearch(pCmpnyNo, pCmpnyNm, pDeptNo, pDeptNm) {
	var parentFrom = parent.document.getElementsByTagName('form');
	var deptGubun = $("#deptGubun").val();	// posit(소속), cosn(위탁)
	
	if(deptGubun=="" || deptGubun=="posit"){ // 소속 회사, 소속 부서
		parentFrom[0].positCmpnyNo.value = pCmpnyNo;
		parentFrom[0].positCmpnyNm.value = pCmpnyNm;
		parentFrom[0].positDeptNo.value = pDeptNo;
		parentFrom[0].positDeptNm.value = pDeptNm;
	}else{ // 위탁 회사, 위탁 부서
		parentFrom[0].cosnCmpnyNo.value = pCmpnyNo;
		parentFrom[0].cosnCmpnyNm.value = pCmpnyNm;
		parentFrom[0].cosnDeptNo.value = pDeptNo;
		parentFrom[0].cosnDeptNm.value = pDeptNm;
	}
	
    parent.$('.ui-dialog-content').dialog('close');
}
</script>

</head>

<body>

<!-- javascript warning tag  -->
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<form name="listForm" method="post" action="<c:url value='/uss/umt/dpt/selectDeptManageListPopup.do'/>">
<input type="hidden" id="deptGubun" name="deptGubun" value="${deptGubun}">
<div class="popup">
	<h1>${pageTitle} <spring:message code="title.list" /></h1>
	<!-- 검색영역 -->
	<div class="pop_search_box" title="<spring:message code="common.searchCondition.msg" />">
		<ul>
			<li><div style="line-height:4px;">&nbsp;</div><div>부서명 : </div></li><!-- 부서명 -->
			<!-- 검색키워드 및 조회버튼 -->
			<li>
				<input class="s_input" name="searchKeyword" type="text"  size="35" title="<spring:message code="title.search" /> <spring:message code="input.input" />" value='<c:out value="${deptManageVO.searchKeyword}"/>'  maxlength="155" >
				<input type="submit" class="s_btn" value="<spring:message code="button.inquire" />" title="<spring:message code="title.inquire" /> <spring:message code="input.button" />" /><!-- 조회 -->
			</li>
		</ul>
	</div>
	
	<!-- 목록영역 -->
	<table class="pop_board_list" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
		<caption>${pageTitle} <spring:message code="title.list" /></caption>
		<colgroup>
			<col style="width: 50%;">
			<col style="width: 50%;">
		</colgroup>
		<thead>
		<tr>
			<th>회사명</th>
			<th class="board_th_link">부서명</th>
		</tr>
		</thead>
		<tbody class="ov">
		<c:if test="${fn:length(deptManageList) == 0}">
		<tr>
			<td colspan="2"><spring:message code="common.nodata.msg" /></td>
		</tr>
		</c:if>
		<c:forEach var="deptManage" items="${deptManageList}" varStatus="status">
		<tr onclick="choiceDeptListSearch('<c:out value="${deptManage.cmpnyNo}"/>','<c:out value="${deptManage.cmpnyNm}"/>','<c:out value="${deptManage.deptNo}"/>','<c:out value="${deptManage.deptNm}"/>'); return false;">
			<td><c:out value="${deptManage.cmpnyNm}"/></td>
			<td><c:out value="${deptManage.deptNm}"/></td>
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

<input name="pageIndex" type="hidden" value="<c:out value='${deptManageVO.pageIndex}'/>">
<input type="hidden" name="searchCondition" value="1">
</form>


</body>
</html>
