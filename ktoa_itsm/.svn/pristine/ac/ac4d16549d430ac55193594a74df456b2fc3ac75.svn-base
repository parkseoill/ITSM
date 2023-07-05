<%
 /**
  * @Class Name : EgovCcmCmmnDetailCodeRegist.jsp
  * @Description : 공통상세코드 등록 화면
  * @Modification Information
  * @
  * @  수정일             수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2009.02.01   박정규              최초 생성
  *   2017.09.04   이정은              표준프레임워크 v3.7 개선
  *
  *  @author 공통서비스팀 
  *  @since 2009.02.01
  *  @version 1.0
  *  @see
  *  
  */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<c:set var="pageTitle"><spring:message code="comSymCcmCde.cmmnDetailCodeVO.title"/></c:set>
<!DOCTYPE html>
<html>
<head>
<title>${pageTitle} <spring:message code="title.create" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="cmmnDetailCodeVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javascript">
/* ********************************************************
 * 초기화
 ******************************************************** */
function fn_egov_init(){

	// 첫 입력란에 포커스
	document.getElementById("cmmnDetailCodeVO").comnCdId.focus();

}

/* ********************************************************
 * 목록으로 가기
 ******************************************************** */
function fn_egov_list_code(){
	location.href = "<c:url value='/sym/ccm/cde/SelectCcmCmmnDetailCodeList.do' />";
}

/* ********************************************************
 * 저장처리화면
 ******************************************************** */
function fn_egov_regist_code(form){
	if(!checkComnCd($('.comnCd').val())){
		$('.comnCd').focus();
	}else if(!checkComnCdNm($('.comnCdNm').val())){
		$('.comnCdNm').focus();
	}else if(!checkSortOrde($('.sortOrde').val())){
		$('.sortOrde').focus();
	}else{
		//input item Client-Side validate
		if(confirm("<spring:message code="common.regist.msg" />")){
   			if(!validateCmmnDetailCodeVO(form)){
   				return;
   			}else{
   				form.submit();
   			}
   		}	
	}
}

/* ********************************************************
* 등록폼 유효성 검사
******************************************************** */
$(document).ready(function(){
	$('.comnCd').blur(function(){
		if(checkComnCd($(this).val())){
			$("#comnCdP").text("");
		}
	});
	$('.comnCdNm').blur(function(){
		if(checkComnCdNm($(this).val())){
			$("#comnCdNmP").text("");
		}
	});
	$('.sortOrde').blur(function(){
		if(checkSortOrde($(this).val())){
			$("#sortOrdeP").text("");
		}
	});
});

function checkComnCd(comnCd){
	$("#comnCdP").css("color","red");
	if(comnCd == ''){
		$("#comnCdP").text("공통코드는 필수 입력값입니다.");
		return false;
	}else if(comnCd.includes(" ")){
		$("#comnCdP").text("공통코드는 공백을 포함할 수 없습니다.");
		return false;
	}else if(comnCd.length > 10){
		$("#comnCdP").text("공통코드는 10자 이내로 입력 가능합니다.");
		return false;
	}else{
		return true;
	}
}

function checkComnCdNm(comnCdNm){
	$("#comnCdNmP").css("color","red");
	if(comnCdNm == ''){
		$("#comnCdNmP").text("공통코드명은 필수 입력값입니다.");
		return false;
	}else{
		return true;
	}
}

function checkSortOrde(sortOrde){
	var checkNum = /^[0-9]+$/;
	$("#sortOrdeP").css("color","red");
	if(sortOrde == ''){
		$("#sortOrdeP").text("정렬순서는 필수 입력값입니다.");
		return false;
	}else if(sortOrde.length > 2){
		$("#sortOrdeP").text("정렬순서는 2자 이내로 입력 가능합니다.");
		return false;
	}else if(!checkNum.test(sortOrde)){
		$("#sortOrdeP").text("정렬순서는 숫자만 입력 가능합니다.");
		return false;
	}else{
		return true;
	}
}

/* ********************************************************
 * CodeId 가져오기
 ******************************************************** */
function fn_egov_get_CodeId(form){
	
	form.action="<c:url value='/sym/ccm/cde/RegistCcmCmmnDetailCodeView.do'/>";
	form.submit();
}

/* ********************************************************
* 서버 처리 후 메세지 화면에 보여주기
******************************************************** */
function fncShowMessg(){
	if("<c:out value='${message}'/>" != ''){
	alert("<c:out value='${message}'/>");
	}
}

</script>

</head>
<body onLoad="fn_egov_init(); fncShowMessg();">

<form:form commandName="cmmnDetailCodeVO" method="post" action="${pageContext.request.contextPath}/sym/ccm/cde/RegistCcmCmmnDetailCode.do" onSubmit="fn_egov_regist_code(document.forms[0]); return false;"> 
	<input name="searchCondition" type="hidden" value="<c:out value='${cmmnCodeVO.searchCondition}'/>">
	<input name="searchKeyword" type="hidden" value="<c:out value='${cmmnCodeVO.searchKeyword}'/>">
<%-- <div class="wTableFrm">
	<!-- 타이틀 -->
	<h2>${pageTitle} <spring:message code="title.create" /></h2> --%>
	
	<!-- 등록폼 -->
	<table class="wTable" style="border-left:1px solid #ddd; border-right:1px solid #ddd; summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
	<caption>${pageTitle } <spring:message code="title.create" /></caption>
	<colgroup>
		<col style="width: 20%;"><col style="width: ;">
	</colgroup>
	<tbody>
		<!-- 입력/선택 -->
		<c:set var="inputTxt"><spring:message code="input.input" /></c:set>
		<c:set var="inputSelect"><spring:message code="input.select"/></c:set> <!-- 선택하세요 -->
		<c:set var="inputYes"><spring:message code="input.yes" /></c:set>
		<c:set var="inputNo"><spring:message code="input.no" /></c:set>
		<!-- 공통코드ID -->

		<c:set var="title"><spring:message code="comSymCcmCde.cmmnDetailCodeVO.comnCdId"/> </c:set>
		<tr>
			<th><label for="comnCdId">${title} <span class="pilsu">*</span></label></th>
			<td class="left">
			    <form:input path="comnCdId" title="${title} ${inputTxt}" size="70" maxlength="6" readonly="true"/>
   				<div><form:errors path="comnCdId" cssClass="error" /></div>     
			</td>
		</tr>		
		<!-- 상세 공통코드 -->
		<c:set var="title"><spring:message code="comSymCcmCde.cmmnDetailCodeVO.comnCd"/> </c:set>
		<tr>
			<th><label for="comnCd">${title} <span class="pilsu">*</span></label></th>
			<td class="left">
			    <form:input class="comnCd" path="comnCd" title="${title} ${inputTxt}" size="70" maxlength="20" />
   				<div><form:errors path="comnCd" cssClass="error" /></div>     
   				<p id="comnCdP"></p>
			</td>
		</tr>
		<!-- 상세 공통코드명 -->
		<c:set var="title"><spring:message code="comSymCcmCde.cmmnDetailCodeVO.comnCdNm"/> </c:set>
		<tr>
			<th><label for="comnCdNm">${title} <span class="pilsu">*</span></label></th>
			<td class="left">
			    <form:input class="comnCdNm" path="comnCdNm" title="${title} ${inputTxt}" size="70" maxlength="100" />
   				<div><form:errors path="comnCdNm" cssClass="error" /></div>     
				<p id="comnCdNmP"></p>
			</td>
		</tr>
		<!-- 상세 공통코드설명 -->
		<c:set var="title"><spring:message code="comSymCcmCde.cmmnDetailCodeVO.comnCdDc"/> </c:set>
		<tr>
			<th><label for="comnCdDc">${title }</label></th>
			<td class="left">
				<form:textarea path="comnCdDc" title="${title} ${inputTxt}" cols="300" rows="20" maxlength="1000" />   
				<div><form:errors path="comnCdDc" cssClass="error" /></div>  
			</td>
		</tr>
		<!-- 사용여부 -->
		<c:set var="title"><spring:message code="comSymCcmCde.cmmnDetailCodeVO.useYn"/> </c:set>
		<tr>
			<th>${title } <span class="pilsu">*</span></th>
			<td class="left">
				<form:select path="useYn" title="${title} ${inputTxt }" cssClass="txt">
					<form:option value="Y"  label=" ${inputYes}"/>
					<form:option value="N" label=" ${inputNo}"/>
				</form:select>
				<div><form:errors path="useYn" cssClass="error" /></div>       
			</td>
		</tr>
		<!-- 정렬순서 -->
		<c:set var="title">정렬순서</c:set>
		<tr>
			<th><label for="sortOrde">${title} <span class="pilsu">*</span></label></th>
			<td class="left">
			    <form:input class="sortOrde" path="sortOrde" title="${title} ${inputTxt}" size="70" maxlength="10" />
   				<div><form:errors path="sortOrde" cssClass="error" /></div>     
   				<p id="sortOrdeP"></p>
			</td>
		</tr>
	</tbody>
	</table>

	<!-- 하단 버튼 -->
	<div class="btn">
		<input type="submit" class="s_submit" value="<spring:message code="button.save" />" title="<spring:message code="button.save" /> <spring:message code="input.button" />" />
	</div><div style="clear:both;"></div>
	
<!-- </div> -->

<%-- <input name="cmd" type="hidden" value="<c:out value='save'/>"> --%>
</form:form>

</body>
</html>
