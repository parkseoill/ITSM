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
<validator:javascript formName="deptManage" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javaScript" language="javascript">

function fncSelectDeptManageList() {
    var varFrom = document.getElementById("deptManage");
    varFrom.action = "<c:url value='/uss/umt/dpt/selectDeptManageList.do'/>";
    varFrom.submit();
}

function fncDeptManageUpdate() {
    var varFrom = document.getElementById("deptManage");
    varFrom.action = "<c:url value='/uss/umt/dpt/updtDeptManage.do'/>";

    if(confirm("<spring:message code="common.save.msg" />")){
        if(!validateBanner(varFrom)){
            return;
        }else{
            varFrom.submit();
        }
    }
}

function fncDeptManageDelete() {
    var varFrom = document.getElementById("deptManage");
    varFrom.action = "<c:url value='/uss/umt/dpt/removeDeptManage.do'/>";
    if(confirm("<spring:message code="common.delete.msg" />")){	
        varFrom.submit();
    }
}

</script>
</head>

<body>

<!-- javascript warning tag  -->
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>
<form:form commandName="deptManage" method="post" action="${pageContext.request.contextPath}/uss/umt/dpt/updtDeptManage.do' />" onSubmit="fncDeptManageUpdate(); return false;" enctype="multipart/form-data">
	<input type="hidden" name="cmpnyNo" value="<c:out value='${deptManage.cmpnyNo}'/>" >
	<input type="hidden" name="deptNo" value="<c:out value='${deptManage.deptNo}'/>" >
	<!-- 검색조건 유지 -->
	<input type="hidden" name="searchCondition" value="<c:out value='${deptManageVO.searchCondition}'/>" >
	<input type="hidden" name="searchKeyword" value="<c:out value='${deptManageVO.searchKeyword}'/>" >
	<input type="hidden" name="pageIndex" value="<c:out value='${deptManageVO.pageIndex}'/>" >

<div class="wTableFrm">
	<!-- 타이틀 -->
	<h2>부서 상세조회/수정</h2>

	<!-- 등록폼 -->
	<table class="wTable" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
	<caption>${pageTitle} <spring:message code="title.create" /></caption>
	<colgroup>
		<col style="width: 16%;"><col style="width: ;">
	</colgroup>
	<tbody>
		<!-- 입력 -->
		<c:set var="inputTxt"><spring:message code="input.input" /></c:set>
		<!-- 부서ID -->
		<c:set var="title">회사 번호</c:set>
		<tr>
			<th>${title}<span class="pilsu">*</span></th>
			<td class="left">
				${deptManage.cmpnyNo}
			</td>
		</tr>
		<c:set var="title">회사 명</c:set>
		<tr>
			<th>${title}<span class="pilsu">*</span></th>
			<td class="left">
				${deptManage.cmpnyNm}
			</td>
		</tr>
		<!-- 부서명 -->
		<c:set var="title">부서 번호</c:set>
		<tr>
			<th>${title}<span class="pilsu">*</span></th>
			<td class="left">
				${deptManage.deptNo}
			</td>
		</tr>
		<c:set var="title">부서 명</c:set>
		<tr>
			<th>${title}<span class="pilsu">*</span></th>
			<td class="left">
				<form:input path="deptNm" title="${title} ${inputTxt}" size="40" maxlength="200" />
				<div><form:errors path="deptNm" cssClass="error" /></div> 
			</td>
		</tr>
	</tbody>
	</table>
	<!-- 하단 버튼 -->
	<div class="btn">
		<span class="btn_s"><a href="#LINK'/>" onclick="fncSelectDeptManageList(); return false;"><spring:message code="button.list"/></a></span><!-- 목록 -->
		<button class="btn_s2" onClick="fncDeptManageDelete();return false;" title="<spring:message code="button.delete" /> <spring:message code="input.button" />"><spring:message code="button.delete" /></button><!-- 삭제 -->
		<input type="submit" class="s_submit" value="<spring:message code="button.save" />" title="<spring:message code="button.save" /> <spring:message code="input.button" />" /><!-- 저장 -->
	</div><div style="clear:both;"></div>
</div>
</form:form>

</body>
</html>

