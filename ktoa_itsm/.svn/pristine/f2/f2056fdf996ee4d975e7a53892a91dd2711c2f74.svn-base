<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<c:set var="ImgUrl" value="${pageContext.request.contextPath}/images/egovframework/com/sym/mnu/mpm/"/>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>메인페이지</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/uat/uia/login.css' />">

<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<!-- validator 클라이언트 -->
<script type="text/javascript" src="<c:url value="/validator.do" />"></script>
<validator:javascript formName="visitVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script language="javascript1.2" type="text/javaScript">
<!--
/* ********************************************************
 * QR출근 등록 페이지 이동 함수
 ******************************************************** */
function moveDlalzAt() {
	$(location).attr("href", "<c:url value='/dlm/dla/DlalzQRAtRegist.do'/>");
}
/* ********************************************************
 * QR퇴근 등록 페이지 이동 함수
 ******************************************************** */
function moveDlalzLe(){
		$(location).attr("href", "<c:url value='/dlm/dla/DlalzQRLeRegist.do'/>");
}
/* ********************************************************
 * 방문자출입관리 페이지 이동 함수
 ******************************************************** */
function moveVisitMng() {
	$(location).attr("href", "<c:url value='/dlm/vis/VisitMngList.do'/>");
}

-->
</script>
</head>
<body>

<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript><!-- 자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다. -->

<%-- <form:form commandName="visitVO" id="visitMngForm" name="visitMngForm" method="post" action="${pageContext.request.contextPath}/dlm/vis/VisitQRMainPage.do">
 --%>
 <form:form method="post" action="${pageContext.request.contextPath}/dlm/vis/VisitQRMainPage.do">
 
 <div class="login_form">
	<fieldset>			
		<div class="login_input">
			<ul>
				<li>
					<input type="button" class="btn_login2" value="QR출근 등록" onclick="moveDlalzAt()"> 
				</li>
				<li>
					<input type="button" class="btn_login2" value="QR퇴근 등록" onclick="moveDlalzLe()"> 
				</li>
				<li>
					<input type="button" class="btn_login2" value="방문자출입관리" onclick="moveVisitMng()"> 
				</li>
			</ul>
		</div>
	</fieldset>
</div>
</form:form> 
</body>


</html>