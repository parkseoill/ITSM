<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : DlalzQRCodeMngList.jsp
  * @Description : QR코드관리 조회 화면
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.07.05   이태신               최초 생성
  *
  *  @author 이태신
  *  @since 2022.07.05
  *  @version 1.0
  *  @see
  *
  */
%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>QR코드관리 목록</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<script language="javascript1.2" type="text/javaScript">
<!--
$(document).ready(function () {
	fn_FocusStart();
});

/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
	document.chargerMngForm.pageIndex.value = pageNo;
	document.chargerMngForm.action = "<c:url value='/dlm/dla/DlalzQRCodeMngList.do'/>";
   	document.chargerMngForm.submit();
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectDlalzQRCodeMng() {
	document.chargerMngForm.pageIndex.value = 1;
	document.chargerMngForm.action = "<c:url value='/dlm/dla/DlalzQRCodeMngList.do'/>";
	document.chargerMngForm.submit();
}

/* ********************************************************
 * 상세조회처리 함수
 ******************************************************** */
function selectDlalzQRCodeDetail(chrgrNo, chrgrNm) {
	var pagetitle = chrgrNm + "님 QR 코드";
    var page = "<c:url value='https://chart.apis.google.com/chart?cht=qr&chs=250x250&chl='/>" + chrgrNo;
    var $dialog = $('<div style="overflow:hidden;padding: 0px 0px 0px 0px;"></div>')
    .html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%" scrolling="no"></iframe>')
    .dialog({
    	autoOpen: false,
        modal: true,
        width: 250,
        height: 285,
        title: pagetitle
	});
	$dialog.dialog('open');
}

/* ********************************************************
 * focus 시작점 지정함수
 ******************************************************** */
function fn_FocusStart(){
	$('#F1').focus();
}

/* ********************************************************
 * 엔터key 목록조회  함수
 ******************************************************** */
function press() {
    if (event.keyCode==13) {
    	selectDlalzQRCodeMng();
    }
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
//-->
</script>
</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<div class="board">
	<h1>QR코드관리 목록</h1>
	<form name="chargerMngForm" action ="<c:url value='/sys/chr/ChargerMngList.do' />" method="post">
	<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
	<input type="hidden" name="checkedValueForDel" />
	<input type="hidden" name="chrgrNo">
	
	<div class="search_box" title="담당자명">
		<ul>
			<li style="padding-right:2%;">
					<label for="">검색조건 : </label>
					<input style="vertical-align: middle;" checked="checked" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '1'}">checked="checked"</c:if> value="1">담당자명</input>
					<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '2'}">checked="checked"</c:if> value="2">회사명</input>
			</li>
			<li>
				<label for="">검색어 : </label>
				<input id="F1" class="s_input2 vat" name="searchKeyword" type="text" value="<c:out value='${searchVO.searchKeyword}'/>" size="60" maxlength="60" onkeypress="press();" title="<spring:message code="title.searchCondition" />" /><!-- 검색조건 -->
				<input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectDlalzQRCodeMng(); return false;" /><!-- 조회 -->
			</li>
		</ul>
	</div>

	<table class="board_list">
		<caption></caption>
		<colgroup>
			<col style="" />
			<col style="width:10%" />
			<col style="width:15%" />
			<col style="width:15%" />
			<col style="width:20%" />
			<col style="width:20%" />
		</colgroup>
		<thead>
			<tr>
			   <th scope="col">담당자명</th>
			   <th scope="col">직급</th>
			   <th scope="col">유선전화</th>
			   <th scope="col">무선전화</th>
			   <th scope="col">담당자회사</th>
			   <th scope="col">담당자부서</th>
			</tr>
		</thead>
		<tbody class="ov">
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			 <c:if test="${fn:length(resultList) == 0}">
			 <tr>
			 <td colspan="6">
				<spring:message code="common.nodata.msg" />
			 </td>
			 </tr>
			 </c:if>
			 
			 <c:forEach var="result" items="${resultList}" varStatus="status">
			  <tr onclick="selectDlalzQRCodeDetail('<c:out value="${result.chrgrNo}"/>', '<c:out value="${result.chrgrNm}"/>'); return false;">
			    <td>
		            <c:out value="${result.chrgrNm}"/>
			    </td>
			    <td>
		            <c:out value="${result.clspos}"/>
			    </td>
			    <td>			    
			    	<c:out value="${result.chrgrWirelnTelNo}"/>
			    </td>
			    <td>
			    	<c:out value="${result.chrgrWirelsTelNo}"/>
			    </td>
			    <td>
			    	<c:out value="${result.positCmpnyNm}"/>
			    </td>
			    <td>
			    	<c:out value="${result.positDeptNm}"/>
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
	
	</form>

</div>

</body>
</html>