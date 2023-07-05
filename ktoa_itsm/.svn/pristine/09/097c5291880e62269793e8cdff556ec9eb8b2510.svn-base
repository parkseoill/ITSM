<%
 /**
  * @Class Name :  EgovCcmCmmnClCodeUpdt.jsp
  * @Description :  공통분류코드 수정하는 화면
  * @Modification Information
  * @
  * @  수정일             수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2009.02.01   박정규              최초 생성
  *   2017.08.04  이정은              표준프레임워크 v3.7 개선
  *  @author 공통서비스팀 
  *  @since 2009.02.01
  *  @version 1.0
  *  @see
  *  
  */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<c:set var="pageTitle"><spring:message code="comSymCcmCcc.cmmnClCodeVO.title"/></c:set>
<!DOCTYPE html>
<html>
<head>
<title>${pageTitle } <spring:message code="title.update" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="cmmnClCodeVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javascript">
/* ********************************************************
 * 초기화
 ******************************************************** */
function fn_egov_init(){
	// 첫 입력란에 포커스..
	document.getElementById("cmmnClCodeVO").comnCdIdNm.focus();
}

/* ********************************************************
 * 저장처리화면
 ******************************************************** */
function fn_egov_updt_code(form){
	if(!checkComnCdIdNm($('.comnCdIdNm').val())){
		$('.comnCdIdNm').focus();
	}else{
		if(confirm("<spring:message code="common.update.msg" />")){
   			if(!validateCmmnClCodeVO(form)){
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
	$('.comnCdIdNm').blur(function(){
		if(checkComnCdIdNm($(this).val())){
			$("#comnCdIdNmP").text("");
		}
	});
});

function checkComnCdIdNm(comnCdIdNm){
	$("#comnCdIdNmP").css("color","red");
	if(comnCdIdNm == ''){
		$("#comnCdIdNmP").text("공통코드ID명은 필수 입력값입니다.");
		return false;
	}else{
		return true;
	}
}

/* ********************************************************
 * 목록 으로 가기
 ******************************************************** */
function fn_egov_inqire_code() {
	cmmnClCodeVO.action = "<c:url value='/sym/ccm/ccc/SelectCcmCmmnClCodeList.do'/>";
	cmmnClCodeVO.submit();	
}

/* ********************************************************
 * 목록조회  함수
 ******************************************************** */
function selectList(){
	var objForm = document.getElementById("cmmnClCodeForm");
	objForm.action = "<c:url value='/sym/ccm/ccc/SelectCcmCmmnClCodeList.do' />";
	objForm.submit();
}
</script>
</head>
<body onLoad="fn_egov_init();">

<!-- 상단타이틀 -->
<form:form commandName="cmmnClCodeVO" id="cmmnClCodeForm" action="${pageContext.request.contextPath}/sym/ccm/ccc/UpdateCcmCmmnClCode.do" method="post" onSubmit="fn_egov_updt_code(document.forms[0]); return false;">  
<input name="searchCondition" type="hidden" value="<c:out value="${searchVO.searchCondition}" />">
<input name="searchKeyword" type="hidden" value="<c:out value="${searchVO.searchKeyword}" />">
<input name="pageIndex" type="hidden" value="<c:out value="${searchVO.pageIndex}" />">

<%--  <div class="wTableFrm">
	<h2>${pageTitle} <spring:message code="title.update" /></h2>  --%>

	<!-- 수정폼 -->
	<table class="wTable" style="border-left:1px solid #ddd; border-right:1px solid #ddd; summary="<spring:message code="common.summary.update" arguments="${pageTitle}" />">
	<caption>${pageTitle} <spring:message code="title.update" /></caption>
	<colgroup>
		<col style="width: 20%;"><col style="width: ;">
	</colgroup>
	<tbody>
		<!-- 입력 -->
		<c:set var="inputTxt"><spring:message code="input.input" /></c:set>
		<c:set var="inputYes"><spring:message code="input.yes" /></c:set>
		<c:set var="inputNo"><spring:message code="input.no" /></c:set>
		
		<!-- 공통코드ID -->
		<c:set var="title"><spring:message code="comSymCcmCcc.cmmnClCodeVO.comnCdId"/> </c:set>
		<tr>
			<th><label for="comnCdId">${title} <span class="pilsu">*</span></label></th>
			<td class="left">
			    <form:input path="comnCdId" title="${title} ${inputTxt}" size="70" maxlength="6" readonly="true" />
   				<div><form:errors path="comnCdId" cssClass="error" /></div>     
			</td>
		</tr>
		<!-- 공통코드ID명 -->
		<c:set var="title"><spring:message code="comSymCcmCcc.cmmnClCodeVO.comnCdIdNm"/> </c:set>
		<tr>
			<th><label for="comnCdIdNm">${title} <span class="pilsu">*</span></label></th>
			<td class="left">
			    <form:input class="comnCdIdNm" path="comnCdIdNm" title="${title} ${inputTxt}" size="70" maxlength="100" />
   				<div><form:errors path="comnCdIdNm" cssClass="error" /></div>     
				<p id="comnCdIdNmP"></p>
			</td>
		</tr>
		
		<!-- 공통코드ID설명 -->
		<c:set var="title"><spring:message code="comSymCcmCcc.cmmnClCodeVO.comnCdIdDc"/> </c:set>
		<tr>
			<th><label for="comnCdIdDc">${title }</label></th>
			<td class="left">
				<form:textarea path="comnCdIdDc" title="${title} ${inputTxt}" cols="300" rows="20" maxlength="1000"/>   
				<div><form:errors path="comnCdIdDc" cssClass="error" /></div>  
			</td>
		</tr>
		
		<!-- 사용여부 -->
		<c:set var="title"><spring:message code="comSymCcmCcc.cmmnClCodeVO.useYn"/> </c:set>
		<tr>
			<th><label for="useYn">${title } <span class="pilsu">*</span></label></th>
			<td class="left">
				<form:select path="useYn" title="${title} ${inputTxt }" cssClass="txt">
	  		   		<form:option value="Y"  label=" ${inputYes}"/>
					<form:option value="N" label=" ${inputNo}"/>
				</form:select>
				<div><form:errors path="useYn" cssClass="error" /></div>       
			</td>
		</tr>
		
	</tbody>
	</table>

	<!-- 하단 버튼 -->
	<div class="btn">
		<input type="submit" class="s_submit" value="<spring:message code="button.save" />" title="<spring:message code="button.save" /> <spring:message code="input.button" />" />
	</div><div style="clear:both;"></div>
	
<!--  </div>  -->
</form:form>

</body>
</html>