<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : EgovLoginUsr.jsp
  * @Description : Login 인증 화면
  * @Modification Information
  * 
  * @수정일               수정자            수정내용
  *  ----------   --------   ---------------------------
  *  2009.03.03   박지욱            최초 생성
  *  2011.09.25   서준식            사용자 관리 패키지가 미포함 되었을때에 회원가입 오류 메시지 표시
  *  2011.10.27   서준식            사용자 입력 탭 순서 변경
  *  2017.07.21   장동한            로그인인증제한 작업
  *  2019.12.11   신용호            KISA 보안약점 조치 (크로스사이트 스크립트)
  *  2020.06.23   신용호            세션만료시간 보여주기
  *
  *  @author 공통서비스 개발팀 박지욱
  *  @since 2009.03.03
  *  @version 1.0
  *  @see
  *
  *  Copyright (C) 2009 by MOPAS  All right reserved.
  */
%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="comUatUia.title" /></title><!-- 로그인 -->
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/uat/uia/login.css' />">
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/showModalDialog.js'/>" ></script>
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery.js'/>" ></script>
<script type="text/javaScript" language="javascript">

function actionLogin() {
	if (document.loginForm.id.value =="") {
        alert("<spring:message code="comUatUia.validate.idCheck" />"); <%-- 아이디를 입력하세요 --%>
    } else if (document.loginForm.password.value =="") {
        alert("<spring:message code="comUatUia.validate.passCheck" />"); <%-- 비밀번호를 입력하세요 --%>
    } else {
        document.loginForm.action="<c:url value='/uat/uia/actionLogin.do'/>";
        //document.loginForm.j_username.value = document.loginForm.userSe.value + document.loginForm.username.value;
        //document.loginForm.action="<c:url value='/j_spring_security_check'/>";
        document.loginForm.submit();
    }
}

function actionCrtfctLogin() {
    document.defaultForm.action="<c:url value='/uat/uia/actionCrtfctLogin.do'/>";
    document.defaultForm.submit();
}

function goFindId() {
    document.defaultForm.action="<c:url value='/uat/uia/egovIdPasswordSearch.do'/>";
    document.defaultForm.submit();
}

function setCookie (name, value, expires) {
    document.cookie = name + "=" + escape (value) + "; path=/; expires=" + expires.toGMTString();
}

function getCookie(Name) {
    var search = Name + "=";
    if (document.cookie.length > 0) { // 쿠키가 설정되어 있다면
        offset = document.cookie.indexOf(search);
        if (offset != -1) { // 쿠키가 존재하면
            offset += search.length;
            // set index of beginning of value
            end = document.cookie.indexOf(";", offset);
            // 쿠키 값의 마지막 위치 인덱스 번호 설정
            if (end == -1)
                end = document.cookie.length;
            return unescape(document.cookie.substring(offset, end));
        }
    }
    return "";
}

function saveid(form) {
    var expdate = new Date();
    // 기본적으로 30일동안 기억하게 함. 일수를 조절하려면 * 30에서 숫자를 조절하면 됨
    if (form.checkId.checked)
        expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 30); // 30일
    else
        expdate.setTime(expdate.getTime() - 1); // 쿠키 삭제조건
    setCookie("saveid", form.id.value, expdate);
}

function getid(form) {
	form.checkId.checked = ((form.id.value = getCookie("saveid")) != "");
}

function fnInit() {
	    
    getid(document.loginForm);

    <c:if test="${not empty fn:trim(loginMessage) &&  loginMessage ne ''}">
    alert("loginMessage:<c:out value='${loginMessage}'/>");
    </c:if>
    
    // reload "_top" frame page
    if (parent.frames["_top"] == undefined)
    	console.log("'_top' frame is not exist!");
    parent.frames["_top"].location.reload();
}

$(document).ready(function(){
	// 엔터키 선택 시 로그인 처리
	$("#password").keydown(function(key){
		if(key.keyCode==13){
			actionLogin();
		}
	});
});

</script>
</head>
<body onLoad="fnInit();">

<!-- javascript warning tag  -->
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>


<!-- 일반로그인 -->
<div class="login_form">
	<form name="loginForm" id="loginForm" action="<c:url value='/uat/uia/actionLogin.do'/>" method="post">
	<input type="hidden" id="message" name="message" value="<c:out value='${message}'/>">
	
	<fieldset>
		<img src="<c:url value='/images/egovframework/com/cmm/main/ktoa_logo.png'/>" style="margin:30px 0 0px 10px" alt="login title image"  title="login title image">
			
		<div class="login_input">
			<ul>
				<!-- 아이디 -->
				<c:set var="title"><spring:message code="comUatUia.loginForm.id"/></c:set>
				<li>
					<label for="id">${title}</label>
					<input type="text" name="id" id="id" maxlength="20" title="${title} ${inputTxt}" placeholder="${title} ${inputTxt}">
				</li>
				<!-- 비밀번호 -->
				<c:set var="title"><spring:message code="comUatUia.loginForm.pw"/></c:set>
				<li>
					<label for="password">${title}</label>
					<input type="password" name="password" id="password" maxlength="20" title="${title} ${inputTxt}" placeholder="${title} ${inputTxt}">
				</li>
				<!-- 아이디 저장 -->
				<c:set var="title"><spring:message code="comUatUia.loginForm.idSave"/></c:set>
				<li class="chk">
					<input type="checkbox" name="checkId" class="check2" onclick="javascript:saveid(document.loginForm);" id="checkId">${title}
				</li>
				<li>
					<input type="button" class="btn_login" value="<spring:message code="comUatUia.loginForm.login"/>" onclick="actionLogin()"> <!-- 로그인  -->
				</li>
			</ul>
		</div>
	</fieldset>
	
	<input name="userSe" type="hidden" value="USR"/>
	<input name="j_username" type="hidden"/>
	</form>
</div>

<!-- 팝업 폼 -->
<form name="defaultForm" action ="" method="post" target="_blank">
<div style="visibility:hidden;display:none;">
<input name="iptSubmit3" type="submit" value="<spring:message code="comUatUia.loginForm.submit"/>" title="<spring:message code="comUatUia.loginForm.submit"/>">
</div>
</form>
<!-- login영역 //-->



</body>
</html>


