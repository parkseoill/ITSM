<%
 /**
  * @Class Name : EgovUserSelectUpdt.jsp
  * @Description : 사용자상세조회, 수정 JSP
  * @Modification Information
  * @
  * @  수정일         수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2009.03.02    조재영          최초 생성
  * @ 2015.06.16	조정국		  password 중복필드 정리
  * @ 2016.07.26    장동한          표준프레임워크 v3.6 개선
  * @ 2017.07.21  장동한 			로그인인증제한 작업
  *
  *  @author 공통서비스 개발팀 조재영
  *  @since 2009.03.02
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
<c:set var="pageTitle"><spring:message code="comUssUmt.deptUserManage.title"/></c:set>
<!DOCTYPE html>
<html>
<head>
<title>${pageTitle} <spring:message code="title.update" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<!-- signature CSS -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/truebon/com/cmm/signature_pad/signature-pad.css' />">
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="userManageVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javascript" src="<c:url value='/js/egovframework/com/sym/ccm/zip/EgovZipPopup.js' />" ></script>

<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<script type="text/javaScript" language="javascript" defer="defer">
function fnListPage(){
    document.userManageVO.action = "<c:url value='/uss/umt/EgovUserManage.do'/>";
    document.userManageVO.submit();
}
function fnDeleteUser(checkedIds) {
	if(confirm("<spring:message code="common.delete.msg" />")){
	    document.userManageVO.checkedIdForDel.value=checkedIds;
	    document.userManageVO.action = "<c:url value='/uss/umt/EgovUserDelete.do'/>";
	    document.userManageVO.submit();
	}
}
function fnPasswordMove(){
	document.userManageVO.action = "<c:url value='/uss/umt/EgovUserPasswordUpdtView.do'/>";
    document.userManageVO.submit();
}

function fnUpdate(form){
	if(signaturePad.isEmpty()){
		//alert("사인을 입력해 주십시오");
	} else {
		let dataURL = signaturePad.toDataURL('image/svg+xml');
		//console.log("signaturePad toDataURL ::::: " + dataURL);
		//console.log("signaturePad dataURLToBlob ::::: " + dataURLToBlob(dataURL));
		//console.log("signaturePad URL.createObjectURL ::::: " + URL.createObjectURL(dataURLToBlob(dataURL)));
		//console.log("signaturePad getSvgData ::::: " + getSvgData(dataURL));
		
		// 새로 그려진 정보가 있다면 수정
		if(signaturePad.toData() != ""){
			$("#strUserSign").val(dataURL);	
		}
	}
	//console.log("strUserSign:"+$("#strUserSign").val());

	// 사인이 없어도 등록되도록 처리
	if(confirm("<spring:message code="common.save.msg" />")){
	    if(validateUserManageVO(form)){
	    	form.action="<c:url value='/uss/umt/EgovUserSelectUpdt.do' />"; //수정
	    	form.submit();
	        return true;
	    }else{
	    	return false;
	    }
	}
}
function fn_egov_inqire_cert() {
	var url = "<c:url value='/uat/uia/EgovGpkiRegist.do' />";
	var popupwidth = '500';
	var popupheight = '400';
	var title = '인증서';

	Top = (window.screen.height - popupheight) / 3;
	Left = (window.screen.width - popupwidth) / 2;
	if (Top < 0) Top = 0;
	if (Left < 0) Left = 0;
	Future = "fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,	scrollbars=no,resizable=no,left=" + Left + ",top=" + Top + ",width=" + popupwidth + ",height=" + popupheight;
	PopUpWindow = window.open(url, title, Future)
	PopUpWindow.focus();
}

function fn_egov_dn_info_setting(dn) {
	var frm = document.userManageVO;

	frm.subDn.value = dn;
}

/* ********************************************************
 * 목록조회  함수
 ******************************************************** */
function selectList(){
	var objForm = document.getElementById("userManageForm");
	objForm.action = "<c:url value='/uss/umt/EgovUserManage.do' />";
	objForm.submit();
}

$(document).ready(function () {
	// 담당자 번호 검색 화면 호출 함수
    $('#popupChargerNo').click(function (e) {
    	e.preventDefault();
        //var page = $(this).attr("href");
        var pagetitle = $(this).attr("title");
        var page = "<c:url value='/sys/chr/ChargerMngListPopup.do'/>";
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
	
	// 저장된 사인값이 있다면 사인 영역에 값을 추가
    if($("#strUserSign").val() != ""){
    	signaturePad.fromDataURL($("#strUserSign").val());
    	signaturePad.off(); // 이벤트 종료
    }else{
    	// 사인 등록된 정보가 없다면 수정 버튼 삭제
    	$(updateButton).css("display", "none");
    }
});

<c:if test="${!empty resultMsg}">alert("<spring:message code="${resultMsg}" />");</c:if> 
</script>
</head>
<body>
<!-- content start -->
<form:form commandName="userManageVO" id="userManageForm" action="${pageContext.request.contextPath}/uss/umt/EgovUserSelectUpdt.do" name="userManageVO" method="post"> 
<div class="wTableFrm">
	<!-- 상세정보 사용자 삭제시 prameter 전달용 input -->
	<input name="checkedIdForDel" type="hidden" />
	<!-- 검색조건 유지 -->
	<input type="hidden" name="searchCondition" value="<c:out value='${userSearchVO.searchCondition}'/>"/>
	<input type="hidden" name="searchCondition2" value="<c:out value='${userSearchVO.searchCondition2}'/>"/>
	<input type="hidden" name="searchKeyword" value="<c:out value='${userSearchVO.searchKeyword}'/>"/>
	<input type="hidden" name="pageIndex" value="<c:out value='${userSearchVO.pageIndex}'/>"/>

	<!-- for validation -->
	<input type="hidden" name="password" id="password" value="ex~Test#$12"/>
	<input type="hidden" name="selectedId" id="selectedId" value=""/>  
	
	<!-- Svg Data -->
	<input type="hidden" name="strUserSign" id="strUserSign" value="<c:out value='${userManageVO.strUserSign}'/>"/>
	
	<!-- 타이틀 -->
	<h2>${pageTitle} <spring:message code="title.update" /></h2>
	
	<table class="wTable" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
	<caption>${pageTitle} <spring:message code="title.create" /></caption>
	<colgroup>
		<col style="width: 22%;"><col style="width: ;">
	</colgroup>
	<tbody>
		<!-- 입력/선택 -->
		<c:set var="inputTxt"><spring:message code="input.input" /></c:set>
		<c:set var="inputSelect"><spring:message code="input.cSelect" /></c:set>
		<c:set var="inputSelect"><spring:message code="input.select"/></c:set>
		<c:set var="inputYes"><spring:message code="input.yes" /></c:set>
		<c:set var="inputNo"><spring:message code="input.no" /></c:set>
		<!-- 일반회원아이디 -->
		<c:set var="title"><spring:message code="comUssUmt.deptUserManageRegist.id"/></c:set>
		<tr>
			<th><label for="userId">${title}</label> <span class="pilsu">*</span></th>
			<td class="left">
                    <form:input path="userId" id="userId" cssClass="txaIpUmt" size="20" maxlength="20" readonly="true" title="${title} ${inputTxt}" />
                    <form:errors path="userId" cssClass="error"/>
                    <form:hidden path="uniqId" />
			</td>
		</tr>
		<!-- 사용가능 여부 -->
		<c:choose>
			<c:when test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN'}">
				<c:set var="title"><spring:message code="comUssUmt.userManageRegist.useYn"/></c:set>
				<tr>
					<th><label for="useYn">${title}</label></th>
					<td class="left">
		                  <form:select path="useYn" id="useYn" title="${title} ${inputTxt}" cssClass="txt">
								<form:option value="Y"  label=" ${inputYes}"/>
								<form:option value="N"  label=" ${inputNo}"/>
		                    </form:select>
		                    
					</td>
				</tr>
			</c:when>
			<c:when test="${sessionScope.loginVO.authorCode eq 'ROLE_USER'}">
				<form:input path="useYn" type="hidden"/>
			</c:when>
		</c:choose>
		<div><form:errors path="useYn" cssClass="error"/></div>
		<!-- 담당자명 -->
		<c:set var="title">담당자명</c:set>
		<tr>
			<th><label for="chrgrNm">${title}</label></th>
			<td class="left">
					<form:input type="hidden" path="chargerNo" id="chargerNo"/>
					<form:errors path="chargerNo" cssClass="error" />
                    <form:input path="chrgrNm" id="chrgrNm" title="${title} ${inputTxt}" size="20" maxlength="50" readonly="true" class="readOnlyClass" cssStyle="width:350px"/>
                    <form:errors path="chrgrNm" cssClass="error" />
                    <c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN'}">
	                    <a id="popupChargerNo" target="_blank" title="담당자명 선택">
						<img src="<c:url value='/images/egovframework/com/cmm/icon/search2.gif' />" alt='' />(담당자명 검색)</a><!-- 새창으로 --><!-- 담당자 검색 -->
                    </c:if>
			</td>
		</tr>
	</tbody>
	</table>
	<div id="signature-pad" class="signature-pad">
		<div class="signature-pad--body">
			<canvas></canvas>
		</div>
		<div class="signature-pad--footer">
			<div class="description">이 곳에 사인해 주세요.</div>
			<div class="signature-pad--actions">
				<div>
					<button type="button" class="button clear" data-action="clear">초기화</button>
					<button type="button" class="button" data-action="change-color" style="display:none;">Change color</button>
					<button type="button" class="button" data-action="undo">되돌리기</button>
					<button type="button" class="button" data-action="update">수정</button>
				</div>
				<div>
					<button type="button" class="button save" data-action="save-png" style="display:none;">Save as PNG</button>
					<button type="button" class="button save" data-action="save-jpg" style="display:none;">Save as JPG</button>
					<button type="button" class="button save" data-action="save-svg" style="display:none;">Save as SVG</button>
				</div>
			</div>
		</div>
	</div>
	<!-- signature JS -->
	<script src="<c:url value='/js/truebon/com/cmm/signature_pad/signature_pad.umd.js' />"></script>
	<script src="<c:url value='/js/truebon/com/cmm/signature_pad/app.js' />"></script>

	<!-- 하단 버튼 -->
	<div class="btn">
		<input type="submit" class="s_submit" value="<spring:message code="button.update" />" title="<spring:message code="button.update" /> <spring:message code="input.button" />" onclick="fnUpdate(document.forms[0]); return false;"/>
		<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN'}">
			<button class="btn_s2" onClick="fnDeleteUser('<c:out value='${userManageVO.uniqId}'/>'); return false;" title="<spring:message code="button.delete" /> <spring:message code="input.button" />"><spring:message code="button.delete" /></button>
		</c:if>
		<button class="btn_s2" onClick="fnPasswordMove(); return false;" title="<spring:message code="comUssUmt.userManageModifyBtn.passwordChange" /> <spring:message code="input.button" />"><spring:message code="comUssUmt.userManageModifyBtn.passwordChange" /></button>
		<c:choose>
			<c:when test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN'}">
				<span class="btn_s"><a href="#LINK'/>" onclick="selectList(); return false;"><spring:message code="button.list"/></a></span><!-- 목록 -->
			</c:when>
			<c:when test="${sessionScope.loginVO.authorCode eq 'ROLE_USER'}">
				<span class="btn_s"><a href="<c:url value='/EgovContent.do' />"  title="<spring:message code="button.list" /> <spring:message code="input.button" />"><spring:message code="button.list" /></a></span>
			</c:when>
		</c:choose>
	</div>
	<div style="clear:both;"></div>
</div>
</form:form>
<!-- content end -->

</body>
</html>
