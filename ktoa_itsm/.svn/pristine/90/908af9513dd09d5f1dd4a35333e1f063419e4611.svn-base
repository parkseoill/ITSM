<!DOCTYPE html>
<%--
 /**
  * @Class Name : SecureMngRegist.jsp
  * @Description : 보안관리 등록
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
<title>보안관리</title>
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
<validator:javascript formName="secureVO" staticJavascript="false" xhtml="true" cdata="false"/>

<script>

// 목록
function selectList() {
	location.href = "<c:url value='/sys/scu/secure.do'/>";
}

// 등록
function insertSecureMng() {
	// 폼체크
	if($("#inspTime").val() == ""){
		alert("점검시간을 입력해주세요.");
		$("#inspTime").focus();
	}else if($("#securInspLoacatCd").val()=='1' && ($("#pcPwrSecurInspResltCd").val() == "" || $("#etcPwrSecurInspResltCd").val() == "" || $("#paperSecurInspResltCd").val() == "" || $("#frcntlSecurInspResltCd").val() == "")){
		alert("점검 상태를 모두 선택해주세요.");	
	}else if($("#securInspLoacatCd").val()=='2' && $("#ltoutLckdSecurInspResltCd").val() == ""){
		alert("소등 및 문단속 상태를 선택해주세요.");
		$("#ltoutLckdSecurInspResltCd").focus();
	}else{	
		var inspDate = $("#inspDate").val();
		var securInspLoacatCd = $("#securInspLoacatCd").val();
		// 동일 점검 기록 존재하는지 확인
 		$.ajax({
			url : "<c:url value='/sys/scu/checkSecureMng.do' />",
			type : 'POST',
	        data: {
				"inspDate":inspDate ,
				"securInspLoacatCd":securInspLoacatCd
			},  
			dataType: 'json' , 	  
			success: function (data) {
				if(data.resultMsg != ""){
					alert(data.resultMsg);
				}else if(data.resultMsg == ""){
					// 보안 점검 등록
					const objForm = document.getElementById("SecureMngForm");
					if(confirm("<spring:message code="common.save.msg" />")){
						if(!validateSecureVO(objForm)){
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

$(document).ready(function() {
	$("#securInspLoacatCd").val()=='1';
	$("#securInspLoacatCd").on("change", function(){
		// 위치 본관 선택시
		if($(this).val()=='1'){
			$("#pcPwrSecurInspResltCd").val('').prop("selected",true);
			$("#pcPwrSecurInspResltCd").attr("disabled",false);
		
			$("#etcPwrSecurInspResltCd").val('').prop("selected",true);
			$("#etcPwrSecurInspResltCd").attr("disabled",false);
		
			$("#paperSecurInspResltCd").val('').prop("selected",true);
			$("#paperSecurInspResltCd").attr("disabled",false);
		
			$("#frcntlSecurInspResltCd").val('').prop("selected",true);
			$("#frcntlSecurInspResltCd").attr("disabled",false);
				
			$("#ltoutLckdSecurInspResltCd").val('').prop("selected",true);
			$("#ltoutLckdSecurInspResltCd").attr("disabled",true);
			$("#ltoutLckdSecurInspResltCd").removeClass("readonly");
		// 위치 별관 선택시
		}if($(this).val()=='2'){
			$("#pcPwrSecurInspResltCd").val('').prop("selected",true);
			$("#pcPwrSecurInspResltCd").attr("disabled",true);
		
			$("#etcPwrSecurInspResltCd").val('').prop("selected",true);
			$("#etcPwrSecurInspResltCd").attr("disabled",true);
		
			$("#paperSecurInspResltCd").val('').prop("selected",true);
			$("#paperSecurInspResltCd").attr("disabled",true);
		
			$("#frcntlSecurInspResltCd").val('').prop("selected",true);
			$("#frcntlSecurInspResltCd").attr("disabled",true);
	
			$("#ltoutLckdSecurInspResltCd").val('').prop("selected",true);
			$("#ltoutLckdSecurInspResltCd").attr("disabled",false);
			$("#ltoutLckdSecurInspResltCd").removeClass("readonly");
		}
	});
});
$(document).ready(function () {
	// 관리자 검색
	$('#popupConfrId').click(function (e) {
		e.preventDefault();
	   	//var page = $(this).attr("href");
		var pagetitle = $(this).attr("title");
		var page = "<c:url value='/sys/scu/ChargerSearchPopup.do'/>";
		var $dialog = $('<div style="overflow:hidden;padding: 0px 0px 0px 0px;"></div>')
		.html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
		.dialog({
			autoOpen: false,
			modal: true,
			width: 530,
			height: 570,
			title: pagetitle
		});
		$dialog.dialog('open');
	});
	
	$( "#inspDate" ).datepicker({
		changeMonth: true, 
		changeYear: true
	});
	
	$('#inspDate').datepicker('setDate', 'today'); 
});
	
</script>
</head>
<body>
	<form:form commandName="secureVO" id="SecureMngForm" name="SecureMngForm" method="POST" action="${pageContext.request.contextPath}/sys/scu/insertSecureMngRegist.do">
	<input type="hidden" id="resultMsg" value="${resultMsg }">
	<div class="wTableFrm">
		<h2>보안점검 등록</h2>
		<table class="wTable">
			<colgroup>
				<col style="width:15%" />
				<col style="width:35%" />
				<col style="width:15%" />
				<col style="" />
			</colgroup>
			<tr>
				<th>날짜<span class="pilsu">*</span></th>
				<td class="left">
					<form:input path="inspDate" id="inspDate" maxlength="10" title="날짜" cssStyle="width:150px" readonly="true"/>
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
				<form:select path="securInspLoacatCd" id="securInspLoacatCd" name="securInspLoacatCd" style="padding:3px 3px 3px 4px;">
					<form:options items="${InspLocat}" itemValue="comnCd" itemLabel="comnCdNm" />
				</form:select>
				</td>
				<th>점검자 성명<span class="pilsu">*</span></th>
				<td class="left">
					<form:input path="isprId" id="isprId" value="${sessionScope.loginVO.name}" type="text" title="성명" readonly="true" class="readOnlyClass" cssStyle="width:150px"/>
					<div><form:errors path="isprId" cssClass="error" /></div>
				</td>
			</tr>
			<tr>
				<th>PC전원 보안 점검</th>
				<td class="left">
					<form:select path="pcPwrSecurInspResltCd" id="pcPwrSecurInspResltCd" class="secure" name="pcPwrSecurInspResltCd">
						<form:option value="" label="--선택하세요--" />
						<form:options items="${inspList}" itemValue="comnCd" itemLabel="comnCdNm" />
					</form:select>
				</td>
				<th>기타 전원 보안 점검</th>
				<td class="left">
					<form:select path="etcPwrSecurInspResltCd" id="etcPwrSecurInspResltCd" class="secure" name="etcPwrSecurInspResltCd">
						<form:option value="" label="--선택하세요--" />
						<form:options items="${inspList}" itemValue="comnCd" itemLabel="comnCdNm" />
					</form:select>
				</td>
			</tr>
			<tr>
				<th>서류 보안 상태</th>
				<td class="left">
					<form:select path="paperSecurInspResltCd" id="paperSecurInspResltCd" class="secure" name="paperSecurInspResltCd">
						<form:option value="" label="--선택하세요--" />
						<form:options items="${inspList}" itemValue="comnCd" itemLabel="comnCdNm" />
					</form:select>
				</td>
				<th>화기 단속</th>
				<td class="left">
				<form:select path="frcntlSecurInspResltCd" id="frcntlSecurInspResltCd" class="secure" name="frcntlSecurInspResltCd">
					<form:option value="" label="--선택하세요--" />
					<form:options items="${inspList}" itemValue="comnCd" itemLabel="comnCdNm" />
				</form:select>
				</td>
			</tr>
			<tr>
				<th>소등 및 문단속</th>
				<td class="left" colspan="3">
				<form:select path="ltoutLckdSecurInspResltCd" id="ltoutLckdSecurInspResltCd" class="secure" name="ltoutLckdSecurInspResltCd" disabled="true">
					<form:option value="" label="--선택하세요--" />
					<form:options items="${inspList}" itemValue="comnCd" itemLabel="comnCdNm" />
				</form:select>
				</td>
			</tr>
			<tr>
				<th>비고내용</th>
				<td colspan="3">
				<form:textarea path="rmarkText" cssClass="repo_txt" placeholder="미흡한 부분을 기입해 주세요."/>
				</td>
			</tr>
		</table>
		<!-- 하단 버튼 -->
		<div class="btn">
			<input class="s_submit" type="submit" value='<spring:message code="button.create" />' onclick="insertSecureMng(); return false;" /><!-- 등록 -->
			<span class="btn_s"><a href="#LINK'/>" onclick="selectList(); return false;"><spring:message code="button.list"/></a></span><!-- 목록 -->
		</div>
		<div style="clear:both;"></div>	
	</div>
	</form:form>
<script>
	const getTime = document.querySelector('#inspTime');
	const time = new Date();
	
	const hours = ('0' + time.getHours()).slice(-2);
	const minutes = ('0' + time.getMinutes()).slice(-2);
	
	getTime.value = hours + ':' + minutes;
</script>


</body>
</html>