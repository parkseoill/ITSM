<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>방문자 목록</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<!-- 달력 기본 설정 -->
<script type="text/javascript" src="<c:url value='/js/truebon/com/cmm/initDatepicker.js' />"></script>
<script language="javascript1.2" type="text/javaScript">
<!--
/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
	document.visitMngForm.pageIndex.value = pageNo;
	document.visitMngForm.action = "<c:url value='/dlm/vis/VisitMngList.do'/>";
   	document.visitMngForm.submit();	
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectVisitMng() {
	document.visitMngForm.pageIndex.value = 1;
	document.visitMngForm.action = "<c:url value='/dlm/vis/VisitMngList.do'/>";
	document.visitMngForm.submit();	
}
/* ********************************************************
 * 입력 화면 호출 함수
 ******************************************************** */
function insertVisitMngList() {
   	document.visitMngForm.action = "<c:url value='/dlm/vis/VisitMngRegist.do'/>";
   	document.visitMngForm.submit();
}
/* ********************************************************
 * 화면 호출 함수
 ******************************************************** */
function VisitMngExitList() {
   	document.visitMngForm.action = "<c:url value='/dlm/vis/VisitMngExit.do'/>";
   	document.visitMngForm.submit();
}
/* ********************************************************
 * 상세조회처리 함수
 ******************************************************** */
function selectVisitMngListDetail(vstDate,chrgrNo) {
	document.visitMngForm.vstDate.value = vstDate;
	document.visitMngForm.chrgrNo.value = chrgrNo;
   	document.visitMngForm.action = "<c:url value='/dlm/vis/VisitMngUpdt.do'/>";
   	document.visitMngForm.submit();
}
// 버튼 페이지 이동
function moveVisitQRMain(){
	$(location).attr("href", "<c:url value='/dlm/vis/VisitQRMainPage.do'/>");
}
/* ********************************************************
 * 방문일자 선택 함수
 ******************************************************** */
$(document).ready(function () {
	fn_FocusStart();
	
	// 달력
	$( "#startDate" ).datepicker({
		changeMonth: true, 
		changeYear: true,
		onClose: function( selectedDate ) {    
		     //시작일(startDate) datepicker가 닫힐때
		     //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
		    $("#endDate").datepicker( "option", "minDate", selectedDate );
		},
	});
	$( "#endDate" ).datepicker({
		changeMonth: true, 
		changeYear: true,
		onClose: function( selectedDate ) {    
		    // 종료일(endDate) datepicker가 닫힐때
		    // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
		    $("#startDate").datepicker( "option", "maxDate", selectedDate );
		},
	});
      
	// 이미지 사이즈 조절
	$("svg[name=imgSvg]").css("width","100%");
	$("svg[name=imgSvg]").css("height","100%");
	
	<c:if test="${sessionScope.loginVO.authorCode ne 'ROLE_ADMIN' || sessionScope.loginVO.authorCode ne 'ROLE_USER' || sessionScope.loginVO.authorCode ne 'ROLE_RESTRICTION'}">
		// 초기화 시간
		const listAutoRefreshTime = 60;
		// 목록 자동 이동(60분후)
		setTimeout(autoPageRefresh, 60000 * listAutoRefreshTime);
	</c:if>

});
// 목록 이동 함수 
function autoPageRefresh(){
	setTimeout("location.href='/dlm/vis/VisitQRMainPage.do'", 1000);
}
/* ********************************************************
 * 퇴실 시간처리  함수
 ******************************************************** */	
function updateExit(pVstDate,pChrgrNo,count){
	$.ajax({
		url : "<c:url value='/dlm/vis/updateVisitMngExit.do' />",
		type : 'POST',
        data: {
			"vstDate":pVstDate ,
			"chrgrNo":pChrgrNo
		},  
		dataType: 'json' , 	  
		success: function (data) {
			alert(data.resultMsg);
			$("#exitArea"+count).html(data.resultVisiVO.levofcTime);
			$("#btnUser"+count).css("display","inline");
			$("#btnExit"+count).css("display","none");
		},
		error: function(){
			alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.	    	
		}
	});    
}

/* ********************************************************
 * focus 시작점 지정함수
 ******************************************************** */
function fn_FocusStart(){
	$('#F1').focus();
}

/* ********************************************************
 * 사인자 정보 등록 및 사인 출력
 ******************************************************** */
 $(document).ready(function () {
		// 이미지 사이즈 조절
		$("svg[name=imgSvg]").css("width","100%");
		$("svg[name=imgSvg]").css("height","100%");
});
function updateConfrSign(date, chrgrNo, count){
	$.ajax({
		url 		:"<c:url value='/dlm/vis/updateConfrSign.do'/>"
        ,type		: "POST"	        
        ,async		: true
        ,data		: {
        	vstDate : date,
        	chrgrNo : chrgrNo
        }
        ,dataType: 'json'  	   
        ,success : function(data){
        	//console.log("사인 등록 메시지:"+data.resultMsg);
        	if(data.resultMsg == "1"){
        		alert("사인이 저장되었습니다.");
        		// 저장된 이미지 값 hidden 값으로 저장.
        		$("#strUserSign").val(data.resultVisiVO.strUserSign);
        		// 이미지 출력 및 버튼 삭제
        		getSvgImg(count);
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
function getSvgImg(count){
	let strUserSign = $("#strUserSign").val();
	// 이미지가 있는 경우 출력
	if(strUserSign != null && strUserSign.length != 0){
		let usersign = getSvgData2(strUserSign);
		$("#userSignArea"+count).html(usersign);
		
		if(typeof $("svg[name=imgSvg]") != "undefined"){
			// 이미지 사이즈 조절
			$("svg[name=imgSvg]").css("width","100%");
			$("svg[name=imgSvg]").css("height","100%");	
		}
		
		// 사인 값이 있는 경우 버튼 삭제
		$("#btnUserSign"+count).css("display","none");
		$("#btnUser"+count).css("display","none");
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
-->
</script>
</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<div class="board">
	<h1>출입 목록</h1>
	<form name="visitMngForm" action ="<c:url value='/dlm/vis/VisitMngList.do' />" method="post">
	<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
	<input type="hidden" name="vstDate" value="<c:out value='${visit.vstDate}'/>"/>
	<input type="hidden" name="chrgrNo" value="<c:out value='${searchVO.chrgrNo}'/>"/>
	<input type="hidden" id="strUserSign" />
	<input type="hidden" id="levofcTime" />
	
	<div class="search_box">
		<ul style="background-image: url(/images/truebon/com/dlm/cod/dash_line.gif); background-position:53% center; background-repeat:no-repeat;">
			<li style="padding-left:3%; float:left;">
				<label for="">방문 일자</label> &nbsp;
				<input class="s_input4 vat" name="startDate" id="startDate" type="text"  value="<c:out value='${searchVO.startDate}'/>" onkeypress="press();"  />
				~	<input class="s_input4 vat" name="endDate" id="endDate" type="text"  value="<c:out value='${searchVO.endDate}'/>" onkeypress="press();"  />&emsp;&emsp;&emsp;
			</li> 
			<li style="padding-right:2%;">
				<label for="">검색조건 : </label>
				<input style="vertical-align: middle;" checked="checked" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '1'}">checked="checked"</c:if> value="1">방문자</input>
				<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '2'}">checked="checked"</c:if> value="2">소속</input>
			</li>
			<li>
				<label for="">검색어 : </label>
				<input id="F1" class="s_input4 vat" name="searchKeyword" type="text" value="<c:out value='${searchVO.searchKeyword}'/>" size="60" maxlength="60" onkeypress="press();" title="<spring:message code="title.searchCondition" />" /><!-- 검색조건 -->
				<input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectVisitMng(); return false;" /><!-- 조회 -->
				<span class="btn_b"><a href="#LINK" onclick="insertVisitMngList(); return false;" />입실 등록</a></span>
			</li>
		</ul>
	</div>
	<table class="board_list">
		<caption></caption>
		<colgroup>
			<col style="width:30px" />
			<col style="width:32px" />
			<col style="width:17px" />
			<col style="width:37px" />
			<col style="width:23px" />
			<col style="width:47px" />
			<col style="width:20px" />
			<col style="width:20px" />
			<col style="width:15px" />
			<col style="width:27px" />
		</colgroup>
		<thead>
			<tr>
			   <th scope="col">방문일</th>
			   <th scope="col">소속</th>
			   <th scope="col">성명</th>
			   <th scope="col">연락처</th>
			   <th scope="col">방문 목적</th>
			   <th scope="col">방문 목적 내용</th>
			   <th scope="col">입실시간</th>
			   <th scope="col">퇴실시간</th>
			   <th scope="col">휴대폰 보관(O,X)</th>
			   <th scope="col">확인자 사인</th>
			</tr>
		</thead>
		<tbody class="ov">
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(visitList) == 0}">
			<tr>
				<td colspan="10">
				<spring:message code="common.nodata.msg" />
				</td>
			</tr>
			</c:if>
			 
			<c:forEach var="visit" items="${visitList}" varStatus="status">
			<tr onclick="selectVisitMngListDetail('<c:out value="${fn:replace(visit.vstDate, '-', '')}"/>', '<c:out value="${visit.chrgrNo}"/>'); return false;">  			  
				<td>
					<c:out value="${visit.vstDate}"/>
				</td>
				<td class="Elli" title="<c:out value="${visit.cmpnyNm}"/>">
					<c:out value="${visit.cmpnyNm}"/>
				</td>
				<td>			    
					<c:out value="${visit.chrgrNm}"/>
				</td>
				<td>
					<c:out value="${visit.chrgrWirelsTelNo}"/>
				</td>
				<td>
					<c:out value="${visit.vstPurps}"/>
				</td>
				<td title="<c:out value="${visit.vstPurpsText}"/>" class="leftElli">
					<c:out value="${visit.vstPurpsText}"/>
				</td>
				<td>
					<c:out value="${fn:substring(visit.entofcTime,11,16)}"/>
				</td>
			   <td onclick="event.cancelBubble=true" >
			   		<c:if test="${visit.levofcTime != '' || visit.levofcTime ne null}">
			   			<c:set var = "check" value="y" />
			    		<c:out value="${fn:substring(visit.levofcTime,11,16)}" escapeXml="false"/>
			    	</c:if>
			    	<!-- 퇴실 처리 안되어있을 경우 -->
					<c:if test="${visit.levofcTime = '' || visit.levofcTime eq null}">
						<c:set var = "check" value="n" />
			    		<input class="btn_s" type="button" value=' 퇴실  ' onclick="event.stopPropagation(); updateExit('<c:out value="${visit.vstDate}"/>','<c:out value="${visit.chrgrNo}"/>','<c:out value="${status.count}"/>'); return false;" id="btnExit${status.count }" />
					</c:if>
					
					<div id="exitArea${status.count }"></div>
			    </td>
			    <td>
			    	<c:out value="${visit.hnphRstorYn}"/>
			    </td>
			    <td style="padding:0 0 0 0;">
			    <c:choose>
					<c:when test="${check eq 'y' && empty visit.confrId && (sessionScope.loginVO.authorCode eq 'ROLE_ADMIN' || sessionScope.loginVO.authorCode eq 'ROLE_USER' || sessionScope.loginVO.authorCode eq 'ROLE_RESTRICTION')}">
						<input class="btn_s" type="button" value="확인(사인)" onclick="event.stopPropagation(); updateConfrSign('<c:out value="${visit.vstDate}"/>','<c:out value="${visit.chrgrNo}"/>','<c:out value="${status.count}"/>'); return false;" id="btnUserSign${status.count }" />
					</c:when>
					
					<c:otherwise>
						<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN' || sessionScope.loginVO.authorCode eq 'ROLE_USER' || sessionScope.loginVO.authorCode eq 'ROLE_RESTRICTION'}">
							<input class="btn_s" type="button" value="확인(사인)" onclick="event.stopPropagation(); updateConfrSign('<c:out value="${visit.vstDate}"/>','<c:out value="${visit.chrgrNo}"/>','<c:out value="${status.count}"/>'); return false;" id="btnUser${status.count }" style="display:none";/>	 		    						
					 	</c:if>
					 	<c:out value="${visit.strUserSign}" escapeXml="false"/> 
					</c:otherwise>
				</c:choose>
			    	<div id="userSignArea${status.count }"></div>
			    </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- paging navigation -->
	<div class="pagination">
		<ul>
			<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage"/>
		</ul>
	</div>
	<c:if test="${sessionScope.loginVO.authorCode ne 'ROLE_ADMIN' && sessionScope.loginVO.authorCode ne 'ROLE_USER' && sessionScope.loginVO.authorCode ne 'ROLE_RESTRICTION'}">
	<div>
		<span class="btn_s2" style="float:right;"><a href="#LINK" onclick="moveVisitQRMain(); return false;" title='메인 페이지'>메인 페이지</a></span>
	</div>
	</c:if>
	
	</form>

</div>

</body>
</html>