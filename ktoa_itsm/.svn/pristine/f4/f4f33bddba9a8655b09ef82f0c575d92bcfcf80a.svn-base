<%
/**
 * @Class Name  : EgovAuthorInsert.java
 * @Description : EgovAuthorInsert jsp
 * @Modification Information
 * @
 * @  수정일         수정자          수정내용
 * @ -------    --------    ---------------------------
 * @ 2009.02.01    lee.m.j          최초 생성
 *   2016.06.13    장동한            표준프레임워크 v3.6 개선
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
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="groupManage" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javaScript" language="javascript">
<!--
function fncGroupInsert() {
	if($("#deptNm1").val() != "" && $("#cmpnyNo1").val() == "") {
		alert("회사를 먼저 등록해주세요.");
	}else{ 
   		var objForm = document.getElementById("groupManageForm");    		
   		if(confirm("<spring:message code="common.save.msg" />")){
   			if(!validateGroupManage(objForm)){
   				return;
   			}else{
   				objForm.submit();
   			}
   		}
    } 
}

$(document).ready(function(){
	<c:if test="${sessionScope.loginVO.authorCode ne 'ROLE_ADMIN'}">
		disabled();
	</c:if>	
});

function disabled() {
	$("#cmpnyNo1"). attr("disabled", true);
	$("#cmpnyNm1"). attr("disabled", true);
	$("#rpsntvNm1"). attr("disabled", true);
	$("#cmpnyTelNo1"). attr("disabled", true);
	$("#cmpnyAddr1"). attr("disabled", true);
	$("#deptNo1"). attr("disabled", true);
	$("#deptNm1"). attr("disabled", true);
}
-->
</script>
</head>

<body>

<form:form commandName="groupManageVO" id="groupManageForm" name="groupManageForm" method="post" action="${pageContext.request.contextPath}/sec/gmt/EgovGroupInsert.do" onSubmit="fncGroupInsert(document.forms[0]); return false;"> 
<!-- <div class="wTableFrm">
	타이틀
	<h2>회사관리 등록</h2>
 -->
	<!-- 등록폼 -->
	<table class="wTable" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
	<caption>${pageTitle} <spring:message code="title.create" /></caption>
	<colgroup>
		<col style="width: 30%;"><col style="width: ;">
	</colgroup>
	<tbody>
		<!-- 입력 -->
		<c:set var="inputTxt"><spring:message code="input.input" /></c:set>
		<tr>
			<th>회사번호</th>
			<td class="left">
			    <form:input path="cmpnyNo" id ="cmpnyNo1" maxlength="20" style="width:90%; height:22px" class="readOnlyClass" readonly="true" />
			    <div><form:errors path="cmpnyNo" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>회사명<span class="pilsu">*</span></th>
			<td class="left">
			    <form:input path="cmpnyNm" id ="cmpnyNm1" title="회사명" maxlength="20" style="width:90%; height:22px" />
			    <div><form:errors path="cmpnyNm" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>대표자명</th>
			<td class="left">
			    <form:input path="rpsntvNm" id ="rpsntvNm1" title="대표자명" maxlength="20" style="width:90%; height:22px" />
			    <div><form:errors path="rpsntvNm" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td class="left">
			    <form:input path="cmpnyTelNo" id ="cmpnyTelNo1"  title="전화번호" maxlength="20" style="width:90%; height:22px" />
			    <div><form:errors path="cmpnyTelNo" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td class="left">
			    <form:textarea path="cmpnyAddr" id ="cmpnyAddr1"  class="textarea" title="주소" cols="30" rows="3" style="width:90%; padding-top:5px;" ></form:textarea>
			    <div><form:errors path="cmpnyAddr" cssClass="error" /></div>
			</td>
		</tr>
 		<tr class="DeptForm">
			<th>부서번호</th>
			<td class="left">
			    <form:input path="deptNo" id ="deptNo1"  maxlength="20" style="width:90%; height:22px" class="readOnlyClass" readonly="true" />
			    <div><form:errors path="deptNo" cssClass="error" /></div>
			</td>
		</tr>
		<tr class="DeptForm">
			<th>부서명</th>
			<td class="left">
			    <form:input path="deptNm" id ="deptNm1"  maxlength="20" style="width:90%; height:22px" />
			    <div><form:errors path="deptNm" cssClass="error" /></div>
			</td>
		</tr> 
	</tbody>
	</table>
	<!-- 하단 버튼 -->
	<!-- 저장 버튼 -->
	<div class="btn" id="DeptBtn">
		<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN'}">
			<input type="submit" class="s_submit" value='<spring:message code="button.save" />' title="<spring:message code="button.create" /> <spring:message code="input.button" />" /><!-- 등록 -->
		</c:if>
	</div><div style="clear:both;"></div>

<input name="groupDc" id="groupDc" type="hidden">
</form:form>	

</body>
</html>

