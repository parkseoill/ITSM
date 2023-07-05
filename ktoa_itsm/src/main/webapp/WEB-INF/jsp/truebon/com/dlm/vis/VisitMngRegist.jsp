<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<c:set var="ImgUrl" value="${pageContext.request.contextPath}/images/egovframework/com/sym/mnu/mpm/"/>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>입실 등록</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">

<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<!-- 달력 기본 설정 -->
<script type="text/javascript" src="<c:url value='/js/truebon/com/cmm/initDatepicker.js' />"></script>

<!-- validator 클라이언트 -->
<script type="text/javascript" src="<c:url value="/validator.do" />"></script>
<validator:javascript formName="visitVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script language="javascript1.2" type="text/javaScript">
<!--
/* ********************************************************
 * 입력처리 함수
 ******************************************************** */
function insertVisitMng() {
	// 폼체크
	if($("#chrgrNm").val() == null || $("#chrgrNm").val() == "" ) {
		alert("방문자를 입력해 주세요");
		$("#chrgrNm").focus();
		return;
	}else if($("#vstPurpsCd").val() == null || $("#vstPurpsCd").val() == "" || $("#vstPurpsCd").val() == "--선택하세요--") {
		alert("방문목적을 선택해 주세요");
		$("#vstPurpsCd").focus();
	}else{
		var vstDate = $("#Date").val();
		var chrgrNo = $("#chrgrNo").val();
 		$.ajax({
			url : "<c:url value='/dlm/vis/checkVisitMng.do' />",
			type : 'POST',
	        data: {
				"vstDate":vstDate ,
				"chrgrNo":chrgrNo
			},  
			dataType: 'json' , 	  
			success: function (data) {
				if(data.resultMsg != ""){
					alert(data.resultMsg);
				}else if(data.resultMsg == ""){
					var objForm = document.getElementById("visitMngForm");
	  	 			if(confirm("<spring:message code="common.save.msg" />")){
	  	 				if(!validateVisitVO(objForm)){
	  	 					return;
	  	 				}else{
	  	 					objForm.submit();
	  	 				}
	  	 			}			
				}			
			},
			error: function(){
				alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.  	
			} 
		});  
 		
	}
}

/* ********************************************************
 * 목록조회  함수
 ******************************************************** */
function selectList(){
	location.href = "<c:url value='/dlm/vis/VisitMngList.do' />";
}
<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
-->
</script>
<script type="text/javascript">
<!--
$(document).ready(function () {
	// 담당자 명 검색 화면 호출 함수
    $('#popupChargerNm').click(function (e) {
    	e.preventDefault();
        var pagetitle = $(this).attr("title");
        var page = "<c:url value='/dlm/vis/VisitMngListPopup.do'/>";
        var $dialog = $('<div style="overflow:hidden;padding: 0px 0px 0px 0px;"></div>')
        .html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
        .dialog({
        	autoOpen: false,
            modal: true,
            width: 550,
            height: 650,
            title: pagetitle
    	});
    	$dialog.dialog('open');
	});
	
	//방문자를 등록할 수 있는 팝업창
	$('#popupRegVisitor').click(function(e){
    	e.preventDefault();
        var pagetitle = $(this).attr("title");
        var page = "<c:url value='/sys/ptn/PartnersMngRegistPopup.do'/>";
        var $dialog = $('<div style="overflow:hidden;padding: 0px 0px 0px 0px;"></div>')
        .html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
        .dialog({
        	autoOpen: false,
            modal: true,
            width: 800,
            height: 700,
            title: pagetitle
    	});
    	$dialog.dialog('open');
	});
	
    /* ********************************************************
     * 방문일자 선택 함수
     ******************************************************** */
 	$("#Date").datepicker({
 		changeMonth: true, 
 		changeYear: true,
 		maxDate: 0
 	});
 	//초기값 오늘 날짜
 	$('#Date').datepicker('setDate', 'today'); 
});
-->
</script>
</head>
<body>

<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript><!-- 자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다. -->

<form:form commandName="visitVO" id="visitMngForm" name="visitMngForm" method="post" action="${pageContext.request.contextPath}/dlm/vis/inseartVisitMngRegist.do">

<div class="wTableFrm">
	<!-- 타이틀 -->
	<h2>입실 등록</h2>

	<!-- 등록폼 -->
	<table class="wTable">
		<colgroup>
			<col style="width:15%" />
			<col style="" />
		</colgroup>
		<tr>
			<th>방문일자 <span class="pilsu">*</span></th>
			<td class="left">
      			<form:input path="vstDate" id="Date" name="vstDate"  title="부서명" size="20" maxlength="30"  class="readOnlyClass" cssStyle="width:160px; padding-left:5px;" readonly="true"/>      			
	      		<form:errors path="vstDate" />
			</td>
			<th>방문자<span class="pilsu">*</span></th>
			<td class="left">
                    <form:input path="chrgrNm" id="chrgrNm" title="${title} ${inputTxt}" size="20" maxlength="30" readonly="true" class="readOnlyClass" cssStyle="width:160px; padding-left:5px;"/>
                    <form:errors path="chrgrNm" cssClass="error" />
                     <a id="popupChargerNm" href="#LINK" target="_blank" title="담당자 선택">
					<img src="<c:url value='/images/egovframework/com/cmm/icon/search2.gif' />" alt='' /> (방문자 검색)</a><!-- 새창으로 -->
					<input class="btn_s" id="popupRegVisitor" type="button" title="방문자 등록" value='방문자 등록'/><!-- 방문자 등록 -->
			</td>
		</tr>
		<tr>
			<th>소속<span class="pilsu">*</span></th>
			<td class="left">
			    <form:input path="cmpnyNm" id="cmpnyNm" maxlength="30" title="소속" cssStyle="width:160px; padding-left:5px;" readonly="true" />
			    <form:errors path="cmpnyNm" />
			</td>
			<th>연락처<span class="pilsu">*</span></th>
			<td class="left">
			    <form:input path="chrgrWirelsTelNo" id="chrgrWirelsTelNo"  maxlength="30" title="연락처" cssStyle="width:160px; padding-left:5px;" readonly="true" />
      			<form:errors path="chrgrWirelsTelNo" />
			</td>
		</tr>
		<tr>
			<th>방문 목적<span class="pilsu">*</span></th>
			<td class="left">
				    <form:select path="vstPurpsCd" title="방문 목적" id="vstPurpsCd" cssClass="txt"  cssStyle="width:167px">
						<form:option value="" id="vstPurpsCd" label="--선택하세요--" />
						<form:options id="vstPurpsCd" items="${vstPurpsCdList}" itemValue="comnCd" itemLabel="comnCdNm" />
					</form:select>
                    <div><form:errors path="vstPurpsCd" cssClass="error"/></div>
			</td>
			<th>휴대폰 보관 여부 <span class="pilsu">*</span></th>
			<td class="left">
			 	<form:radiobutton path="hnphRstorYn" value="Y" label=" O " />&emsp;
				<form:radiobutton path="hnphRstorYn" value="N" checked="checked" label=" ✖  " />
				<form:errors path="hnphRstorYn" />
			</td>
		</tr>
		<tr>
			<th>방문 목적 내용</th>
			<td class="left" colspan="3" >
			    <form:input path="vstPurpsText" id="vstPurpsText"  maxlength="80" title="방문 목적 내용" cssStyle="width:82%; padding-left:5px;" />
      			<form:errors path="vstPurpsText" />
			</td>
		</tr>
	</table>

	<!-- 하단 버튼 -->
	<div class="btn">
		<input class="s_submit" type="submit" value='<spring:message code="button.create" />' onclick="insertVisitMng(); return false;" /><!-- 등록 -->
		<span class="btn_s"><a href="#LINK'/>" onclick="selectList(); return false;"><spring:message code="button.list"/></a></span><!-- 목록 -->
	</div>
	<div style="clear:both;"></div>
	
 	<input type="hidden" id="chrgrNo" name="chrgrNo" value="<c:out value='${visit.chrgrNo}'/>"/>

	<!-- 임시 담당자 구분 코드  -->
	<input type="hidden" name="chrgrDstnctCd" value="2">
</div>

</form:form>

</body>
</html>