<!DOCTYPE html>
<%--
 /**
  * @Class Name : SecureMngUpdt.jsp
  * @Description : 보안관리 수정
  * @Modification Information
  * @
  * @ 수정일               수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.07.28   조경민            최초 생성
  *
  *  @author 조경민
  *  @since 2022.07.28
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
<title>보안관리수정</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<!-- validator 클라이언트 -->
<script type="text/javascript" src="<c:url value="/validator.do" />"></script>
<validator:javascript formName="secureVO" staticJavascript="false" xhtml="true" cdata="false"/>

<script>

// 목록조회
function selectList(){
	var objForm = document.getElementById("SecureMngForm");
	objForm.action = "<c:url value='/sys/scu/secure.do'/>";
	objForm.submit();
}

// 삭제
function fn_DeleteSecureMng() {
	var objForm = document.getElementById("SecureMngForm");
	if(confirm("<spring:message code="common.delete.msg"/>")){
		objForm.action="<c:url value='/sys/scu/deleteSecureMng.do' />";
		objForm.submit();
	}
}

//수정
function secureUpdtMng() {
	var objForm = document.getElementById("SecureMngForm");
	if(confirm("<spring:message code="common.save.msg" />")){
		if(!validateSecureVO(objForm)){
			return;
		}else{
			objForm.submit();
		}
	}
}

</script>

<script  xlink:href="example.js">
$(document).ready(function () {
	getSvgImg();
	// 이미지 사이즈 조절
	$("svg[name=imgSvg]").css("width","100%");
	$("svg[name=imgSvg]").css("height","100%");
}); 

//사인자 정보 등록 및 사인 출력
function updateConfrSign(){
	$.ajax({
		url			:"<c:url value='/sys/scu/updateConfrSign.do'/>"
        ,type		: "POST"
        ,async		: true
        ,data		: $("#SecureMngForm").serializeArray()
        ,dataType	: 'json'  	   
        ,success	: function(data){
        	//console.log("사인 등록 메시지:"+data.resultMsg);
        	if(data.resultMsg == "1"){
        		alert("사인이 저장되었습니다.");
        		// 저장된 이미지 값 hidden 값으로 저장.
        		$("#strUserSign").val(data.result.strUserSign);
        		// 이미지 출력 및 버튼 삭제
        		getSvgImg();
        	}else{
        		alert("사인이 저장되지 않았습니다.");
        	}
		}
	    ,error: function(){
	    	alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.
	    }
	});
}


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



</script>
</head>
<body>
	<form:form commandName="vo" id="SecureMngForm" name="SecureMngForm" method="POST" action="${pageContext.request.contextPath}/sys/scu/SecureMngUpdate.do">
	<input type="hidden" name="dateSearch" value='<c:out value="${vo.dateSearch }"></c:out>'>
	<input type="hidden" name="inspLocatSearch" value='<c:out value="${vo.inspLocatSearch }"></c:out>'>
	<form:hidden path="strUserSign" />
	<div class="wTableFrm">
		<h2>보안점검 수정</h2>
		<table class="wTable">
			<colgroup>
				<col style="width:15%" />
				<col style="width:33%" />
				<col style="width:15%" />
				<col style="" />
			</colgroup>
			<tr>
				<th>날짜<span class="pilsu">*</span></th>
				<td class="left">
					<form:input path="inspDate" type="date" title="날짜" readonly="true"/>
					<div><form:errors path="inspDate" cssClass="error" /></div>
				</td>
				<th>점검시각<span class="pilsu">*</span></th>
				<td class="left">
					<form:input path="inspTime" type="time" title="점검 시각" id="inspTime" />
					<div><form:errors path="inspTime" cssClass="error" /></div>		
				</td>
			</tr>
			<tr>
				<th>위치<span class="pilsu">*</span></th>
				<td class="left">
				<select id="securInspLoacatCd" name="securInspLoacatCd" onFocus='this.initialSelect = this.selectedIndex;' onChange='this.selectedIndex = this.initialSelect;' style="padding:3px 3px 3px 4px;">
					<option value="1" <c:if test="${secureVO.securInspLoacatCd eq '1'}">selected</c:if>>본관</option>
					<option value="2" <c:if test="${secureVO.securInspLoacatCd eq '2'}">selected</c:if>>별관</option>
				</select>
				</td>
				<th>점검자 성명<span class="pilsu">*</span></th>
				<td class="left">
					<form:input path="isprName" id="isprId" type="text" title="성명" placeholder="점검자 성명" required="ture" readonly="true" class="readOnlyClass" cssStyle="width:150px"/>
					<div><form:errors path="isprId" cssClass="error" /></div>
				</td>
			</tr>
			<tr>
				<th>PC전원 보안 점검</th>
				<td class="left">
					<form:select path="pcPwrSecurInspResltCd" id="pcPwrSecurInspResltCd" class="secure" name="pcPwrSecurInspResltCd" disabled="${secureVO.securInspLoacatCd == 2 ? true: false}">
						<form:option value="" label="--선택하세요--" />
						<form:options items="${inspList}" itemValue="comnCd" itemLabel="comnCdNm" />
					</form:select>
				</td>
				<th>기타 전원 보안 점검</th>
				<td class="left">
					<form:select path="etcPwrSecurInspResltCd" id="etcPwrSecurInspResltCd" class="secure" name="etcPwrSecurInspResltCd" disabled="${secureVO.securInspLoacatCd == 2 ? true: false}">
						<form:option value="" label="--선택하세요--" />
						<form:options items="${inspList}" itemValue="comnCd" itemLabel="comnCdNm" />
					</form:select>
				</td>
			</tr>
			<tr>
				<th>서류 보안 상태</th>
				<td class="left">
					<form:select path="paperSecurInspResltCd" id="paperSecurInspResltCd" class="secure" name="paperSecurInspResltCd" disabled="${secureVO.securInspLoacatCd == 2 ? true: false}">
						<form:option value="" label="--선택하세요--" />
						<form:options items="${inspList}" itemValue="comnCd" itemLabel="comnCdNm" />
					</form:select>
				</td>
				<th>화기 단속</th>
				<td class="left">
				<form:select path="frcntlSecurInspResltCd" id="frcntlSecurInspResltCd" class="secure" name="frcntlSecurInspResltCd" disabled="${secureVO.securInspLoacatCd == 2 ? true: false}">
					<form:option value="" label="--선택하세요--" />
					<form:options items="${inspList}" itemValue="comnCd" itemLabel="comnCdNm" />
				</form:select>
				</td>
			</tr>
			<tr>
				<th>소등 및 문단속</th>
				<td class="left">
				<form:select path="ltoutLckdSecurInspResltCd" id="ltoutLckdSecurInspResltCd" class="secure" name="ltoutLckdSecurInspResltCd" disabled="${secureVO.securInspLoacatCd == 1 ? true: false}">
					<form:option value="" label="--선택하세요--" />
					<form:options items="${inspList}" itemValue="comnCd" itemLabel="comnCdNm" />
				</form:select>
				</td>
				<th>확인자 사인</th>
				<td class="left">
						<div id="userSignArea"></div>
				<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN' || sessionScope.loginVO.authorCode eq 'ROLE_USER'}">
						<input class="btn_s" type="button" value="확인(사인)" onclick="updateConfrSign(); return false;" id="btnUserSign" />
						<input class="btn_s" type="button" value="확인(사인) 변경" onclick="updateConfrSign(); return false;" id="btnUserSignUpdate" style="display:none"/>						
				</c:if>
				</td>
			</tr>
			<tr>
				<th>비고</th>
				<td colspan="3">
				<form:textarea path="rmarkText" cssClass="repo_txt" placeholder="미흡한 부분을 기입해 주세요."/>
				</td>
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
			<input class="s_submit" type="submit" value='<spring:message code="button.update" />' onclick="secureUpdtMng(); return false;" /><!-- 수정 -->
			<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN'}">
				<span class="btn_s"><a href="#LINK" onclick="fn_DeleteSecureMng(); return false;" title='<spring:message code="button.delete" />'><spring:message code="button.delete" /></a></span><!-- 삭제 -->
			</c:if>
			<span class="btn_s"><a href="#LINK'/>" onclick="selectList(); return false;"><spring:message code="button.list"/></a></span><!-- 목록 -->
		</div>
		<div style="clear:both;"></div>	
	</div>
	</form:form>
</body>
</html>
