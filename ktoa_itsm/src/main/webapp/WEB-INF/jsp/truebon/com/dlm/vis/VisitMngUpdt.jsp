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
<title>방문자 상세 조회</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<!-- validator 클라이언트 -->
<script type="text/javascript" src="<c:url value="/validator.do" />"></script>
<validator:javascript formName="visitVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script language="javascript1.2" type="text/javaScript">
$(document).ready(function () {
	getSvgImg();
	if($("#levofcTime").val() == ""){
		$("#btnUserSign").css("display","none");
	}
});

/* ********************************************************
 * 수정처리 함수(관리자,일반 사용자)
 ******************************************************** */
function updateVisitMng() {
	var objForm = document.getElementById("visitMngForm");
	
	if(confirm("<spring:message code="common.save.msg" />")){
		if(!validateVisitVO(objForm)){
			return;
		}else{
			objForm.submit();
		}
	}
}

/* ********************************************************
 * 목록조회  함수
 ******************************************************** */
function selectList(){
	var objForm = document.getElementById("visitMngForm");
	objForm.action = "<c:url value='/dlm/vis/VisitMngList.do' />";
	objForm.submit();
}

// 사인자 정보 등록 및 사인 출력
function updateConfrSign(){
	$.ajax({
		url :"<c:url value='/dlm/vis/updateConfrSign.do'/>"
        ,type: "POST"
        ,data : $("#visitMngForm").serializeArray()
        ,dataType: 'json'  	   
        ,success : function(data){
        	//console.log("사인 등록 메시지:"+data.resultMsg);
        	if(data.resultMsg == "1"){
        		alert("사인이 저장되었습니다.");
        		// 저장된 이미지 값 hidden 값으로 저장.
        		$("#strUserSign").val(data.resultVisiVO.strUserSign);
        		// 이미지 출력 및 버튼 삭제
        		getSvgImg();
        	}else{
        		alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.
        	}
		}
	    ,error: function(){
	    	alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.
	    }
	});
}

/* ********************************************************
 * 이미지 출력
 ******************************************************** */
function getSvgImg(){
	let strUserSign = $("#strUserSign").val();
	// 이미지가 있는 경우 출력
	if(strUserSign != null && strUserSign.length != 0){
		let usersign = getSvgData2(strUserSign);
		$("#userSignArea").html(usersign);
		
		if(typeof $("svg[name=imgSvg]") != "undefined"){
			// 이미지 사이즈 조절
			$("svg[name=imgSvg]").css("width","100%");
			$("svg[name=imgSvg]").css("height","100%");	
		}
		
		// 사인 값이 있는 경우 버튼 삭제, 변경 버튼 추가
		$("#btnUserSign").css("display","none");
		$("#btnUserSignUpdate").css("display","inline");
	}
}

//SVG 데이터를 base64 디코딩(공통)
function getSvgData2(dataURL){
	const parts = dataURL.split(';base64,');
	let raw = "";
	if(typeof parts[1] != "undefined"){
		raw = window.atob(parts[1]);
	}else{
		raw = dataURL;
	}
	return raw;
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
</script>

</head>
<body>

<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript><!-- 자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다. -->

<form:form commandName="visitVO" id="visitMngForm" name="visitMngForm" method="post" action="${pageContext.request.contextPath}/dlm/vis/updateVisitMngUpdt.do">
	<!-- 검색조건 유지 -->
    <input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
    <input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
    <input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}' default='1' />"/>
    <input type="hidden" id="chrgrNo" name="chrgrNo" value="<c:out value='${searchVO.chrgrNo}'/>"/>
    <input type="hidden" id="startDate" name="startDate" value="<c:out value='${searchVO.startDate}'/>"/>
    <input type="hidden" id="endDate" name="endDate" value="<c:out value='${searchVO.endDate}'/>"/>
    <form:hidden path="strUserSign" />
    
<div class="wTableFrm">
	<!-- 타이틀 -->
	<h2>출입 상세 조회 /수정</h2>

	<!-- 등록폼 -->
	<table class="wTable">
		<colgroup>
			<col style="width:15%" />
			<col style="" />
		</colgroup>
		<tr>
			<th>방문일<span class="pilsu">*</span></th>
			<td class="left">
			    <form:input path="vstDate" id="vstDate" maxlength="10" title="방문일" cssStyle="width:180px" readonly="true" class="readOnlyClass" />
      			<div><form:errors path="vstDate" cssClass="error" /></div>
			</td>
			<th>소속</th>
			<td class="left">
			    <form:input path="cmpnyNm" maxlength="10" title="소속" readonly="true" cssStyle="width:180px" />
      			<div><form:errors path="cmpnyNm" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>성명</th>
			<td class="left">
			    <form:input path="chrgrNm" maxlength="15" title="성명" readonly="true" cssStyle="width:180px" />
      			<div><form:errors path="chrgrNm" cssClass="error" /></div>
			</td>
			<th>연락처</th>
			<td class="left">
			    <form:input path="chrgrWirelsTelNo" maxlength="15" readonly="true" title="연락처" cssStyle="width:180px" />
				<div><form:errors path="chrgrWirelsTelNo" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>입실 시간 <span class="pilsu">*</span></th>
			<td class="left">
				<form:input path="entofcTime" id="entofcTime"  maxlength="250" readonly="true" title="입실시간" cssStyle="width:180px" />
			    <div><form:errors path="entofcTime" cssClass="error" /></div>
			</td>
			<th>퇴실 시간 <span class="pilsu">*</span></th>
			<td class="left">
				<form:input path="levofcTime" id="levofcTime" name="levofcTime"  readonly="true" title="퇴실시간" size="30" maxlength="30"  class="readOnlyClass" cssStyle="width:180px"/>      			
			    <!-- 퇴실 처리 안되어있을 경우만 퇴실 버튼 -->
				<%-- <c:if test="${visitVO.levofcTime = '' || visitVO.levofcTime eq null}">
			    	&nbsp;<input class="btn_s" type="button" value=' 퇴실  ' onclick="updateExit(); return false;" />
				</c:if> --%>
			    <div><form:errors path="levofcTime" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>방문 목적<span class="pilsu">*</span></th>
			<td class="left">
				    <form:select path="vstPurpsCd" title="방문 목적" cssClass="txt"  cssStyle="width:180px">
						<form:option value="" label="--선택하세요--" />
						<form:options items="${vstPurpsCdList}" itemValue="comnCd" itemLabel="comnCdNm" />
					</form:select>
                    <div><form:errors path="vstPurpsCd" cssClass="error"/></div>
			</td>
			<th>방문 목적 내용</th>
			<td class="left">
			    <form:input path="vstPurpsText" id="vstPurpsText"  maxlength="80" title="방문 목적 내용" cssStyle="width:95%; padding-left:5px;" />
      			<form:errors path="vstPurpsText" />
			</td>
		</tr>
		<tr>
			<c:if test="${sessionScope.loginVO.authorCode ne 'ROLE_ADMIN' && sessionScope.loginVO.authorCode ne 'ROLE_USER' && sessionScope.loginVO.authorCode ne 'ROLE_RESTRICTION'}">
				<th>휴대폰 보관 여부 <span class="pilsu">*</span></th>
				<td class="left">
				 	<form:radiobutton path="hnphRstorYn" value="Y" label=" O " />&emsp;
					<form:radiobutton path="hnphRstorYn" value="N" label=" ✖  "/>
					<form:errors path="hnphRstorYn" />
				</td>
				<th>확인자 사인</th>
				<td class="left">
					<div id="userSignArea"></div>
				</td>
			</c:if>
			<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN' || sessionScope.loginVO.authorCode eq 'ROLE_USER' || sessionScope.loginVO.authorCode eq 'ROLE_RESTRICTION'}">
				<th>휴대폰 보관 여부 <span class="pilsu">*</span></th>
				<td class="left">
				 	<form:radiobutton path="hnphRstorYn" value="Y" label=" O " />&emsp;
					<form:radiobutton path="hnphRstorYn" value="N" label=" ✖  "/>
					<form:errors path="hnphRstorYn" />
				</td>
				<th>확인자 사인</th>
				<td class="left">
					<div id="userSignArea"></div>
					<input class="btn_s" type="button" value="확인(사인)" onclick="updateConfrSign(); return false;" id="btnUserSign" />
					<input class="btn_s" type="button" value="확인(사인) 변경" onclick="updateConfrSign(); return false;" id="btnUserSignUpdate" style="display:none"/>
				</td>
			</c:if>
		</tr>
		<tr>
				<th>수정일</th>
				<td class="left">
				    <form:input path="mdtt" title="수정일" readonly="true" class="readOnlyClass" cssStyle="width:150px"/>
		      		<div><form:errors path="mdtt" cssClass="error" /></div>
				</td>
				<th>수정자</th>
				<td class="left">
		      		<form:input path="amndrNm" title="수정자" readonly="true" class="readOnlyClass" cssStyle="width:150px"/>
		      		<div><form:errors path="amndrNm" cssClass="error" /></div>
				</td>
		</tr>
	</table>
	
	<!-- 하단 버튼 -->
	<div class="btn">
		<input class="s_submit" type="submit" value='수정' onclick="updateVisitMng(); return false;" /><!-- 수정 -->
		<span class="btn_s"><a href="#LINK'/>" onclick="selectList(); return false;"><spring:message code="button.list"/></a></span><!-- 목록 -->
	</div>
	<div style="clear:both;"></div>
</div>

</form:form>

</body>
</html>