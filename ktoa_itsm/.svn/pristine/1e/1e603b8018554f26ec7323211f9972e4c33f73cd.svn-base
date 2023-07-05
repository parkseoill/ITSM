<!DOCTYPE html>
<%--
 /**
  * @Class Name : PartnersMngRegist.jsp
  * @Description : 협력업체담당자 등록 화면
  * @Modification Information
  * @
  * @ 수정일               수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.07.08   조경민            최초 생성
  *
  *  @author 조경민
  *  @since 2022.07.08
  *  @version 1.0
  *  @see
  *
  */
--%>
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
<title>협력업체 등록</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<!-- validator 클라이언트 -->
<script type="text/javascript" src="<c:url value="/validator.do" />"></script>
<validator:javascript formName="chargerVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script>
$(document).ready(function () {
	// 소속회사, 부서목록 이동 화면 호출 함수
	$('#popupPositDeptList').click(function (e) {
		e.preventDefault();
		var pagetitle = $(this).attr("title");
		var page = "<c:url value='/uss/umt/dpt/selectDeptManageListPopup.do?deptGubun=posit'/>";
		var $dialog = $('<div style="overflow:hidden;padding: 0px 0px 0px 0px;"></div>')
		.html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
		.dialog({
			autoOpen: false,
			modal: true,
			width: 410,
			height: 550,
			title: pagetitle
		});
		$dialog.dialog('open');
	});
	
 	// 위탁회사, 부서목록 이동 화면 호출 함수
	$('#popupCosnDeptList').click(function (e) {
		e.preventDefault();
		var pagetitle = $(this).attr("title");
		var page = "<c:url value='/uss/umt/dpt/selectDeptManageListPopup.do?deptGubun=cosn'/>";
		var $dialog = $('<div style="overflow:hidden;padding: 0px 0px 0px 0px;"></div>')
		.html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
		.dialog({
			autoOpen: false,
			modal: true,
			width: 410,
			height: 550,
			title: pagetitle
		});
		$dialog.dialog('open');
	});
});

// 등록
function insertPartnersMng() {
	const objForm = document.getElementById("partnersMngForm");
	document.getElementById("chrgrDstnctCd").value = "3"
	if(!validateChargerVO(objForm)){
		return;
	}else{
		objForm.submit();
	}
}

function checkPartner(){
	var chrgrNm = $('#chrgrNm').val();
	var positCmpnyNo = $('#positCmpnyNo').val();
	$.ajax({
		url: "<c:url value='/sys/ptn/checkVisitor.do'/>",
	    type: 'POST',
	    data:{
	    	"chrgrNm":chrgrNm,
	    	"positCmpnyNo":positCmpnyNo,
	    },
	    dataType: 'json',
	    success: function (data){
	    	if(data.checkVst > 0){
	    		if(confirm(" 이미 담당자가 존재합니다. \n 등록을 진행하시겠습니까?")){
	    			insertPartnersMng();
	    		}
	    	}else{
	    		if(confirm("<spring:message code="common.regist.msg" />")){
	    			insertPartnersMng();
	    		}
	    	}
	    },
	    error: function(){
	    	alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.
	    }
	});
}

// 목록
function selectList(){
	location.href = "<c:url value='/sys/ptn/PartnersMngList.do' />";
	document.getElementById("chrgrDstnctCd").value = "협력업체";
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>

//담당자명으로 포커스 이동, 담당자 구분 value변경
window.onload = function(){
	document.querySelector("input:nth-child(1)").focus();
	document.getElementById("chrgrDstnctCd").value = "협력업체"
}


</script>
</head>
<body>

<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript><!-- 자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다. -->

<form:form commandName="chargerVO" id="partnersMngForm" name="partnersMngForm" method="post" action="${pageContext.request.contextPath}/sys/ptn/inseartPartnersMngRegist.do">
<div class="wTableFrm">

<h2>협력업체 등록</h2>

	<table class="wTable">
		<colgroup>
			<col style="width:15%" />
			<col style="width:35%" />
			<col style="width:15%" />
			<col style="" />
		</colgroup>
		<tr>
			<th>담당자명 <span class="pilsu">*</span></th>
			<td class="left">
			    <form:input path="chrgrNm" maxlength="10" title="담당자명" cssStyle="width:100px" />
      			<div><form:errors path="chrgrNm" id="chrgrNm" cssClass="error" /></div>
			</td>
			<th>직급</th>
			<td class="left">
			    <form:input path="clspos" maxlength="10" title="직급" cssStyle="width:100px" />
      			<div><form:errors path="clspos" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>유선전화번호</th>
			<td class="left">
			    <form:input path="chrgrWirelnTelNo" maxlength="15" title="유선전화번호" cssStyle="width:100px" />
      			<div><form:errors path="chrgrWirelnTelNo" cssClass="error" /></div>
			</td>
			<th>무선전화번호</th>
			<td class="left">
			    <form:input path="chrgrWirelsTelNo" maxlength="15" title="무선전화번호" cssStyle="width:100px" />
				<div><form:errors path="chrgrWirelsTelNo" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>담당자 주소</th>
			<td class="left">
			    <form:input path="chrgrAddr" maxlength="250" title="담당자 주소" />
			    <div><form:errors path="chrgrAddr" cssClass="error" /></div>
			</td>
			<th>담당자 구분</th>
			<td class="left">
				<form:input value="3" path="chrgrDstnctCd" title="담당자 구분" cssClass="txt" readonly="true"/>
			    <div><form:errors path="chrgrDstnctCd" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>소속회사명 <span class="pilsu">*</span></th>
			<td class="left">
			    <form:input path="positCmpnyNm" title="소속회사명" readonly="true" class="readOnlyClass" cssStyle="width:150px"/>
	      		<div><form:errors path="positCmpnyNm" cssClass="error" /></div>
	      		<input type="hidden" id="positCmpnyNo" name="positCmpnyNo" value="">
			</td>
			<th>소속부서명 <span class="pilsu">*</span></th>
			<td class="left">
			    <form:input path="positDeptNm" title="소속부서명" readonly="true" class="readOnlyClass" cssStyle="width:150px"/>
	      		<a id="popupPositDeptList" href="#LINK" target="_blank" title="부서 선택">
					<img src="<c:url value='/images/egovframework/com/cmm/icon/search2.gif' />" alt='' />(부서 선택)</a>
				<div><form:errors path="positDeptNm" cssClass="error" /></div>
				<input type="hidden" name="positDeptNo" value="">
			</td>
		</tr>
		<tr>
			<th>위탁회사명</th>
			<td class="left">
			    <form:input path="cosnCmpnyNm" title="위탁회사명" readonly="true" class="readOnlyClass" cssStyle="width:150px"/>
	      		<div><form:errors path="cosnCmpnyNm" cssClass="error" /></div>
	      		<input type="hidden" name="cosnCmpnyNo" value="">
			</td>
			<th>위탁부서명</th>
			<td class="left">
			    <form:input path="cosnDeptNm" title="위탁부서명" readonly="true" class="readOnlyClass" cssStyle="width:150px"/>
	      		<a id="popupCosnDeptList" href="#LINK" target="_blank" title="부서 선택">
					<img src="<c:url value='/images/egovframework/com/cmm/icon/search2.gif' />" alt='' />(부서 선택)</a>
				<div><form:errors path="cosnDeptNm" cssClass="error" /></div>
				<input type="hidden" name="cosnDeptNo" value="">
			</td>
		</tr>
	</table>
	
<!-- 하단 버튼 -->
<div class="btn">
		<input class="s_submit" type="submit" value='<spring:message code="button.create" />' onclick="checkPartner(); return false;" /><!-- 등록 -->
		<span class="btn_s"><a href="#LINK'/>" onclick="selectList(); return false;"><spring:message code="button.list"/></a></span><!-- 목록 -->
	</div>
	<div style="clear:both;"></div>
</div>

</form:form>

</body>
</html>