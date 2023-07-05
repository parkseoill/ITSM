<%

 /**
  * @Class Name : EgovUserManage.jsp
  * @Description : 사용자관리(조회,삭제) JSP
  * @Modification Information
  * @
  * @  수정일         수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2009.03.02    조재영          최초 생성
  *   2011.09.07    서준식          네비게이션명 변경 (사용자 관리 -> 업무사용자관리)
  *   2016.06.13    장동한          표준프레임워크 v3.6 개선
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
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<c:set var="pageTitle"><spring:message code="comUssUmt.deptUserManage.title"/></c:set>
<!DOCTYPE html>
<html>
<head>
<title>${pageTitle} <spring:message code="title.list" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
$(document).ready(function () {
	fn_FocusStart();
	fn_checkAll();
});


function fn_FocusStart(){
	// 첫 입력란에 포커스..
	$('#F1').focus();
}

/* ********************************************************
 * 모두선택 처리 함수
 ******************************************************** */
function fn_checkAll(){
	// 전체 체크박스 선택
	$("input[name=checkAll]").click(function() {
		if($("input[name=checkAll]").prop("checked")) {
			$("input[name=checkField]").prop("checked", true);
		} else {
			$("input[name=checkField]").prop("checked", false);
		}
	});
	
	// 전체 체크박스 선택 중 체크박스 하나를 풀때 '전체' 체크 해제
	$("input[name=checkField]").click(function() {
		let total = $("input[name=checkField]").length;
		let cntChecked = $("input[name=checkField]:checked").length;
		
		if(total != cntChecked) {
			$("input[name=checkAll]").prop("checked", false);
		} else {
			$("input[name=checkAll]").prop("checked", true);
		}
	});
}

/* ********************************************************
 * 멀티삭제 처리 함수
 ******************************************************** */
function fn_DeleteList() {
    let checkedIds = "";
    let checkedCount = 0;
    
    $("input[name=checkField]").each(function() {
    	if($(this).is(":checked") == true) {
    		checkedIds += checkedCount==0? $(this).val() : "," + $(this).val();
    		checkedCount++;
    	}
    });

    if(checkedCount ==0){
		alert("선택된 계정이 없습니다.");
		return false;
    }

    if(confirm("<spring:message code="common.delete.msg" />")){	//삭제하시겠습니까?
    	$("input[name=checkedIdForDel]").val(checkedIds);
    	$("#listForm").attr("action", "<c:url value='/uss/umt/EgovUserDelete.do'/>");
    	$("#listForm").submit();
    }
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function fnSelectUser(id) {
    document.listForm.selectedId.value = id;
  
    document.listForm.action = "<c:url value='/uss/umt/EgovUserSelectUpdtView.do'/>";
    document.listForm.submit();

}

/* ********************************************************
 * 입력 화면 호출 함수
 ******************************************************** */
function fnAddUserView() {
    document.listForm.action = "<c:url value='/uss/umt/EgovUserInsertView.do'/>";
    document.listForm.submit();
}

/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function fnLinkPage(pageNo){
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/uss/umt/EgovUserManage.do'/>";
    document.listForm.submit();
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function fnSearch(){
	document.listForm.pageIndex.value = 1;
	
    document.listForm.submit();
}

function fnViewCheck(){
    if(insert_msg.style.visibility == 'hidden'){
    	insert_msg.style.visibility = 'visible';
    }else{
    	insert_msg.style.visibility = 'hidden';
    }
}

<c:if test="${!empty resultMsg}">alert("<spring:message code="${resultMsg}" />");</c:if>

-->

</script>
</head>
<body onload="fn_egov_init()">
<!-- javascript warning tag  -->
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<form name="listForm" id="listForm" action="<c:url value='/uss/umt/EgovUserManage.do'/>" method="post"> 
<div class="board">
	<h1>${pageTitle} <spring:message code="title.list" /></h1>
	
	<!-- 검색영역 -->
	<div class="search_box" title="<spring:message code="common.searchCondition.msg" />">
		<ul>
			<li style="padding-right:2%;">
				<label for="">사용여부 : </label>
				<input style="vertical-align: middle;" checked="checked" type="radio" name="searchCondition2" <c:if test="${userSearchVO.searchCondition2 == ''}">checked="checked"</c:if> value="">전체</input>
				<input style="vertical-align: middle;" type="radio" name="searchCondition2" <c:if test="${userSearchVO.searchCondition2 == '1'}">checked="checked"</c:if> value="1">Y</input>
				<input style="vertical-align: middle;" type="radio" name="searchCondition2" <c:if test="${userSearchVO.searchCondition2 == '2'}">checked="checked"</c:if> value="2">N</input>
			</li>
			<li style="padding-right:2%;">
				<label for="">검색조건 : </label>
				<input style="vertical-align: middle;" checked="checked" type="radio" name="searchCondition" <c:if test="${userSearchVO.searchCondition == '1'}">checked="checked"</c:if> value="1">사용자 ID</input>
				<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${userSearchVO.searchCondition == '2'}">checked="checked"</c:if> value="2">담당자명</input>
			</li>
			<!-- 검색키워드 및 조회버튼 -->
			<li>
				<label for="">검색어 : </label>
				<input id="F1" class="s_input" name="searchKeyword" type="text"  size="35" title="<spring:message code="title.search" /> <spring:message code="input.input" />" value='<c:out value="${userSearchVO.searchKeyword}"/>'  maxlength="255" >
				<input type="submit" class="s_btn" value="<spring:message code="button.inquire" />" title="<spring:message code="title.inquire" /> <spring:message code="input.button" />" />
				<input type="button" class="s_btn" onClick="fn_DeleteList(); return false;" value="<spring:message code="title.delete" />" title="<spring:message code="title.delete" /> <spring:message code="input.button" />" />
				<span class="btn_b"><a href="<c:url value='/uss/umt/EgovUserInsertView.do'/>" onClick="fnAddUserView(); return false;"  title="<spring:message code="button.create" /> <spring:message code="input.button" />"><spring:message code="button.create" /></a></span>
			</li>
		</ul>
	</div>

	<table class="board_list" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
	<caption>${pageTitle} <spring:message code="title.list" /></caption>
	<colgroup>
		<col style="width: 5%;">
		<col style="width: 10%;">
		<col style="width: 10%;">
		<col style="width: 13%;">
		<col style="width: 10%;">
		<col style="width: 13%;">
		<col style="width: 9%;">
	</colgroup>
	<thead>
	<tr>
		<th><input type="checkbox" name="checkAll" class="check2" onclick="javascript:fncCheckAll()" title="<spring:message code="input.selectAll.title" />"></th><!-- 전체선택 -->
		<th class="board_th_link">사용자 ID</th><!--사용자 ID -->
		<th>담당자명</th><!-- 담당자명 -->
		<th>담당자 유선번호</th><!-- 담당자 유선번호 -->
		<th>사용여부</th><!-- 사용여부 -->
		<th>수정자</th><!-- 수정자 -->
		<th>수정일</th><!-- 수정일 -->
	</tr>
	</thead>
	<tbody class="ov">
	<c:if test="${fn:length(resultList) == 0}">
	<tr>
		<td colspan="8"><spring:message code="common.nodata.msg" /></td>
	</tr>
	</c:if>
	<c:forEach var="result" items="${resultList}" varStatus="status">
	<tr href="<c:url value='/uss/umt/EgovUserSelectUpdtView.do'/>?selectedId=<c:out value="${result.uniqId}"/>"  
	    onclick="javascript:fnSelectUser('<c:out value="${result.uniqId}"/>'); return false;">
	    <td onclick="event.cancelBubble=true">
	        <input type="checkbox" name="checkField" class="check2" title="선택" value="<c:out value='${result.uniqId}'/>"/>
	    </td>
	    <td><c:out value="${result.userId}"/></td>
	    <td><c:out value="${result.chrgrNm}"/></td>
	    <td><c:out value="${result.chrgrWirelnTelNo}"/></td>
		<td><c:out value="${result.useYn}"/></td>
	    <td><c:out value="${result.amndrId}"/></td>
	    <td><c:out value="${fn:substring(result.mdtt,0,10)}"/></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	
	<!-- paging navigation -->
	<div class="pagination">
		<ul><ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fnLinkPage"/></ul>
	</div>
	
	<input name="selectedId" type="hidden" />
	<input name="checkedIdForDel" type="hidden" />
	<input name="pageIndex" type="hidden" value="<c:out value='${userSearchVO.pageIndex}'/>"/>
	<input name="chargerNo" type="hidden" value="<c:out value='${result.chargerNo}'/>"/>
</div>
</form>
	


</body>
</html>
