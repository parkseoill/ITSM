<%
/**
 * @Class Name  : EgovRoleUpdate.java
 * @Description : EgovRoleUpdate jsp
 * @Modification Information
 * @
 * @  수정일         수정자          수정내용
 * @ -------    --------    ---------------------------
 * @ 2009.02.01    lee.m.j      최초 생성
 *   2016.06.13    장동한         표준프레임워크 v3.6 개선
 *
 *  @author lee.m.j
 *  @since 2009.03.11
 *  @version 1.0
 *  @see
 *
 *  Copyright (C) 2009 by MOPAS  All right reserved.
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<c:set var="pageTitle"><spring:message code="comUssUmt.deptManage.title"/></c:set>
<!DOCTYPE html>
<html>
<head>
<title>${pageTitle} <spring:message code="title.create" /></title><!-- 부서관리 등록 -->
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<%-- <script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/fms/EgovMultiFile.js'/>" ></script> --%>
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/fms/EgovMultiFiles.js'/>" ></script>
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>

<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<validator:javascript formName="deptManageVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script language="javascript1.2" type="text/javaScript">
<!--
/* ********************************************************
 * 엔터key 목록조회  함수
 ******************************************************** */
function press() {
    if (event.keyCode==13) {
    	fncSelectDeptManageList();    
    }
}
<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
-->
</script>

<script type="text/javascript">
$(document).ready(function () {
//	alert('du');
	// 회사 번호 검색 화면 호출 함수
    $('#popupProgrmCmpnyNo').click(function (e) {
    	e.preventDefault();
        //var page = $(this).attr("href");
        var pagetitle = $(this).attr("title");
        var page = "<c:url value='/sec/gmt/EgovGroupSearchList.do'/>";
        var $dialog = $('<div style="overflow:hidden;padding: 0px 0px 0px 0px;"></div>')
        .html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
        .dialog({
        	autoOpen: false,
            modal: true,
            width: 400,
            height: 550,
            title: pagetitle
    	});
    	$dialog.dialog('open');
	});
});

function fncSelectDeptManageList() {
    var varFrom = document.getElementById("deptManage");
    varFrom.action = "<c:url value='/uss/umt/dpt/selectDeptManageList.do'/>";
    varFrom.submit();
}

function fncDeptManageInsert() {
	var varFrom = document.getElementById("deptManage");
	varFrom.action = "<c:url value='/uss/umt/dpt/addDeptManage.do'/>";

	if(confirm("<spring:message code="common.save.msg" />")){	
		if (!validateDeptManage(varFrom)) {
			return;
		} else {
			varFrom.submit();
		}
	}
}
</script>
</head>

<body>
<!-- javascript warning tag  -->
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>
<form:form commandName="deptManage" method="post" action="${pageContext.request.contextPath}/uss/umt/dpt/addDeptManage.do' />" onSubmit="fncDeptManageInsert(); return false;" enctype="multipart/form-data">
<div class="wTableFrm">
	<!-- 타이틀 -->
	<h2>${pageTitle} <spring:message code="title.create" /></h2>

	<!-- 등록폼 -->
	<table class="wTable" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
	<caption>${pageTitle} <spring:message code="title.create" /></caption>
	<colgroup>
		<col style="width: 16%;"><col style="width: ;">
	</colgroup>
	<tbody>
		<!-- 입력 -->
		<c:set var="inputTxt"><spring:message code="input.input" /></c:set>
		<!--  -->
		<c:set var="title">회사 번호</c:set>
		<tr>
			<th>회사 번호 <span class="pilsu">*</span></th><!--  -->
			<td class="left" colspan="3">
			    <form:input path="cmpnyNo" maxlength="60" onkeypress="press();" title="회사 번호" readonly="true" class="readOnlyClass" cssStyle="width:350px" /><!-- 파일명 -->
			    <form:errors path="cmpnyNo" />
		        <a id="popupProgrmCmpnyNo" href="#LINK" target="_blank" title="회사 선택">
					<img src="<c:url value='/images/egovframework/com/cmm/icon/search2.gif' />" alt='' />(회사 번호 검색)</a><!-- 새창으로 --><!-- 프로그램파일명 검색 -->
			</td>
		</tr>
		<tr>
			<th>회사 명 <span class="pilsu">*</span></th><!--  -->
			<td class="left" colspan="3">
			    <form:input path="cmpnyNm" maxlength="60" onkeypress="press();" title="회사 명" readonly="true" class="readOnlyClass" cssStyle="width:350px" /><!-- 파일명 -->
			    <form:errors path="cmpnyNm" />
			</td>
		</tr>
		<tr>
		<!-- 부서명 -->
		<c:set var="title">부서 명</c:set>
		<tr>
			<th>${title}</label> <span class="pilsu">*</span></th>
			<td class="left">
				<form:input path="deptNm" title="${title} ${inputTxt}" size="20" maxlength="50" />
				<div><form:errors path="deptNm" cssClass="error" /></div>
			</td>
		</tr>
	</tbody>
	</table>

	<!-- 하단 버튼 -->
	<div class="btn">
		<span class="btn_s"><a href="<c:url value='/uss/umt/dpt/selectDeptManageList.do'/>"  title="<spring:message code="button.list" />  <spring:message code="input.button" />"><spring:message code="button.list" /></a></span>
		<input type="submit" class="s_submit" value="<spring:message code="button.create" />" title="<spring:message code="button.create" /> <spring:message code="input.button" />" />
	</div><div style="clear:both;"></div>
	
</div>

<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="<c:out value='${deptManageVO.searchCondition}'/>" >
<input type="hidden" name="searchKeyword" value="<c:out value='${deptManageVO.searchKeyword}'/>" >
<input type="hidden" name="pageIndex" value="<c:out value='${deptManageVO.pageIndex}'/>" >
<input name="cmd" type="hidden" value="<c:out value='insert'/>">

 </form:form>


</body>
</html>

