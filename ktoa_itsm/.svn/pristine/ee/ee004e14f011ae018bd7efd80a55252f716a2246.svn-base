<%
/**
 * @Class Name  : EgovAuthorUpdate.java
 * @Description : EgovAuthorUpdate jsp
 * @Modification Information
 * @
 * @  수정일         수정자          수정내용
 * @ -------    --------    ---------------------------
 * @ 2009.02.01    lee.m.j          최초 생성
 *   2016.06.13    장동한             표준프레임워크 v3.6 개선
 *
 *  @author lee.m.j
 *  @since 2009.03.11
 *  @version 1.0
 *  @see
 *
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
<c:set var="pageTitle"><spring:message code="comCopSecGmt.title"/></c:set>
<!DOCTYPE html>
<html>
<head>
<title>회사 상세조회/수정</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">

<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="groupManage" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javaScript" language="javascript">
function fncSelectGroupList() {
    var varFrom = document.getElementById("groupManage");
    varFrom.action = "<c:url value='/sec/gmt/EgovGroupList.do'/>";
    varFrom.submit();
}

function fncGroupUpdate(form) {
	if(confirm("<spring:message code="common.save.msg" />")){ //저장하시겠습니까?
        if(!validateGroupManage(form)){
            return false;
        }else{
        	form.submit();
        }
    }
}

function fncGroupDelete(form) {
    /* var varFrom = document.getElementById("frmIdDelete"); */
    var varFrom = document.getElementById("groupManage");
    varFrom.action = "<c:url value='/sec/gmt/EgovGroupDelete.do'/>";
    if(confirm("<spring:message code="common.delete.msg" />")){	//삭제하시겠습니까?
    	varFrom.submit();
    }else{
    	return false;
    }
}
</script>
</head>

<body>

<form:form commandName="groupManage" method="post" action="${pageContext.request.contextPath}/sec/gmt/EgovGroupUpdate.do" onSubmit="fncGroupUpdate(document.forms[0]); return false;"> 
<div class="wTableFrm">
	<!-- 타이틀 -->
	<h2>회사 상세조회/수정</h2><!-- 그룹관리 등록 -->

	<!-- 등록폼 -->
	<table class="wTable" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
	<caption>${pageTitle} <spring:message code="title.create" /></caption>
	<colgroup>
		<col style="width: 16%;"><col style="width: ;">
	</colgroup>
	<tbody>
		<!-- 입력 -->
		<c:set var="inputTxt"><spring:message code="input.input" /></c:set>
		<!-- 회사 번호 -->
		<c:set var="title">번호<span class="pilsu">*</span></c:set>
		<tr>
			<th>${title}</th>
			<td class="left">
				${groupManage.cmpnyNo}
			</td>
		</tr>
		
		<!-- 회사명 -->
		<c:set var="title">회사 명</c:set>
		<tr>
			<th>${title} <span class="pilsu">*</span></th>
			<td class="left">
				<form:input path="cmpnyNm" title="${title} ${inputTxt}" size="40" maxlength="50" />
				<div><form:errors path="cmpnyNm" cssClass="error" /></div> 
			</td>
		</tr>
		<!-- 대표자명 -->
		<c:set var="title">대표자 명</c:set>
		<tr>
			<th>${title}</th>
			<td class="left">
			    <form:input path="rpsntvNm" title="${title} ${inputTxt}" size="40" maxlength="50" />   
				<div><form:errors path="rpsntvNm" cssClass="error" /></div> 
			</td>
		</tr>
				<!-- 회사주소 -->
		<c:set var="title">회사 주소</c:set>
		<tr>
			<th>${title} </th>
			<td class="left">
				<form:input path="cmpnyAddr" title="${title} ${inputTxt}" size="40" maxlength="50" />
				<div><form:errors path="cmpnyAddr" cssClass="error" /></div> 
			</td>
		</tr>
				<!-- 회사 전화번호 -->
		<c:set var="title">전화번호</c:set>
		<tr>
			<th>${title}</th>
			<td class="left">
				<form:input path="cmpnyTelNo" title="${title} ${inputTxt}" size="40" maxlength="50" />
				<div><form:errors path="cmpnyTelNo" cssClass="error" /></div> 
			</td>
		</tr>
	</tbody>
	</table>

	<!-- 하단 버튼 -->
	<!-- <span class="btn_s"><a href="#" onClick="fncGroupDelete(); return false;"  title="<spring:message code="button.delete" /> <spring:message code="input.button" />"><spring:message code="button.delete" /></a></span>  -->
	<div class="btn">
	<span class="btn_s"><a href="#LINK'/>" onclick="fncSelectGroupList(); return false;"><spring:message code="button.list"/></a></span><!-- 목록 -->
	<button class="btn_s2" onClick="fncGroupDelete();return false;" title="<spring:message code="button.delete" /> <spring:message code="input.button" />"><spring:message code="button.delete" /></button><!-- 삭제 -->
	<input type="submit" class="s_submit" value="<spring:message code="button.save" />" title="<spring:message code="button.save" /> <spring:message code="input.button" />" /><!-- 저장 -->
	</div><div style="clear:both;"></div>
	
</div>
<!-- 검색조건 유지 -->
<input type="hidden" name="searchKeyword" value="<c:out value='${groupManageVO.searchKeyword}'/>"/>
<input type="hidden" name="searchCondition" value="1">
<input type="hidden" name="pageIndex" value="<c:out value='${groupManageVO.pageIndex}' default='1' />"/>
<input type="hidden" name="cmpnyNo" value="<c:out value='${groupManage.cmpnyNo}'/>"/>

</form:form>


</body>
</html>

