<%
 /**
  * @Class Name : EgovAuthorManage.java
  * @Description : EgovAuthorManage List 화면
  * @Modification Information
  * @
  * @  수정일                     수정자                    수정내용
  * @ -------       --------    ---------------------------
  * @ 2009.03.01    Lee.m.j       최초 생성
  *   2016.06.13    장동한          표준프레임워크 v3.6 개선
  *
  *  @author 실행환경 개발팀 홍길동
  *  @since 2009.02.01
  *  @version 1.0
  *  @see
  *
  */
%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="pageTitle"><spring:message code="comCopSecRam.title"/></c:set>
<!DOCTYPE html>
<html>
<head>
<title>${pageTitle} <spring:message code="title.list" /></title><!-- 권한관리 목록 -->
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<script type="text/javaScript" language="javascript" defer="defer">
$(document).ready(function () {
	fn_FocusStart();
	fn_checkAll();
});

/* ********************************************************
 * 체크박스 모두선택 및 해제 처리 함수
 ******************************************************** */
function fn_checkAll(){
	// 전체 체크박스 선택
	$("input[name=checkAll]").click(function() {
		if($("input[name=checkAll]").prop("checked")) {
			$("input[name=delYn]").prop("checked", true);
		} else {
			$("input[name=delYn]").prop("checked", false);
		}
	});
	
	// 전체 체크박스 선택 중 체크박스 하나를 풀때 '전체' 체크 해제
	$("input[name=delYn]").click(function() {
		let total = $("input[name=delYn]").length;
		let cntChecked = $("input[name=delYn]:checked").length;
		
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
    let checkIds = "";
    let checkedCount = 0;
    
    $("input[name=delYn]").each(function() {
    	if($(this).is(":checked") == true) {
    		checkIds += checkedCount==0? $(this).val() : ";" + $(this).val();
    		checkedCount++;
    	}
    });

    if(checkedCount ==0){
		alert("<spring:message code="comCopSecRam.validate.authorSelect" />"); //선택된 권한이 없습니다.
		return false;
    }

    if(confirm("<spring:message code="common.delete.msg" />")){	//삭제하시겠습니까?
    	$("input[name=authorCodes]").val(checkIds);
    	$("#listForm").attr("action", "<c:url value='/sec/ram/EgovAuthorListDelete.do'/>");
    	$("#listForm").submit();
    }
}

function fncSelectAuthorList(pageNo){
    document.listForm.searchCondition.value = "1";
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/sec/ram/EgovAuthorList.do'/>";
    document.listForm.submit();
}

function fncSelectAuthor(author) {
    document.listForm.authorCode.value = author;
    document.listForm.action = "<c:url value='/sec/ram/EgovAuthor.do'/>";
    document.listForm.submit();
}

function fncAddAuthorInsert() {
    location.replace("<c:url value='/sec/ram/EgovAuthorInsertView.do'/>");
}

function fncAddAuthorView() {
    document.listForm.action = "<c:url value='/sec/ram/EgovAuthorUpdate.do'/>";
    document.listForm.submit();
}

function fncSelectAuthorRole(author) {
    document.listForm.searchKeyword.value = author;
    document.listForm.action = "<c:url value='/sec/ram/EgovAuthorRoleList.do'/>";
    document.listForm.submit();
}

function linkPage(pageNo){
    document.listForm.searchCondition.value = "1";
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/sec/ram/EgovAuthorList.do'/>";
    document.listForm.submit();
}

/* ********************************************************
 * focus 시작점 지정함수
 ******************************************************** */
function fn_FocusStart(){
	$('#F1').focus();
}

function press() {

    if (event.keyCode==13) {
    	fncSelectAuthorList('1');
    }
}

</script>
</head>
<body>
<!-- javascript warning tag  -->
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>
<form:form name="listForm" id="listForm" action="${pageContext.request.contextPath}/sec/ram/EgovAuthorList.do" method="post">
<div class="board">
	<h1>${pageTitle} <spring:message code="title.list" /></h1><!-- 권한관리 목록 -->
	<!-- 검색영역 -->
	<div class="search_box" title="<spring:message code="common.searchCondition.msg" />">
		<ul>
			<li><div style="line-height:4px;">&nbsp;</div><div><spring:message code="comCopSecRam.list.searchKeywordText" /> : </div></li><!-- 권한명 -->
			<!-- 검색키워드 및 조회버튼 -->
			<li style="border: 0px solid #d2d2d2;">
				<input id="F1" class="s_input" name="searchKeyword" type="text"  size="35" title="<spring:message code="title.search" /> <spring:message code="input.input" />" value='<c:out value="${authorManageVO.searchKeyword}"/>'  maxlength="155" >
				<input type="submit" class="s_btn" value="<spring:message code="button.inquire" />" title="<spring:message code="title.inquire" /> <spring:message code="input.button" />" />
				<input type="button" class="s_btn" onClick="fn_DeleteList()" value="<spring:message code="title.delete" />" title="<spring:message code="title.delete" /> <spring:message code="input.button" />" />
				<span class="btn_b"><a href="<c:url value='/sec/ram/EgovAuthorInsertView.do'/>" onClick="javascript:fncAddAuthorInsert();"  title="<spring:message code="button.create" /> <spring:message code="input.button" />"><spring:message code="button.create" /></a></span>
			</li>
		</ul>
	</div>
	
	<!-- 목록영역 -->
	<table class="board_list" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
	<caption>${pageTitle} <spring:message code="title.list" /></caption>
	<colgroup>
		<col style="width: 9%;">
		<col style="width: 33%;">
		<col style="width: 30%;">
		<col style="width: ;">
		<col style="width: 10%;">
		<col style="width: 7%;">
	</colgroup>
	<thead>
	<tr>
		<th><input type="checkbox" name="checkAll" class="check2" title="<spring:message code="input.selectAll.title" />"></th><!-- 체크박스 -->
		<th class="board_th_link"><spring:message code="comCopSecRam.list.authorRollId" /></th><!-- 권한 ID -->
		<th><spring:message code="comCopSecRam.list.authorNm" /></th><!-- 권한 명 -->
		<th><spring:message code="comCopSecRam.list.authorDc" /></th><!-- 설명 -->
		<th><spring:message code="table.regdate" /></th><!-- 등록일자 -->
		<th><spring:message code="comCopSecRam.list.authorRoll" /></th><!-- 롤 정보 -->
	</tr>
	</thead>
	<tbody class="ov">
	<c:if test="${fn:length(authorList) == 0}">
	<tr>
		<td colspan="6"><spring:message code="common.nodata.msg" /></td>
	</tr>
	</c:if>
	<c:forEach var="author" items="${authorList}" varStatus="status">
	<tr onclick="javascript:fncSelectAuthor('<c:out value="${author.authorCode}"/>')">
		<td onclick="event.cancelBubble=true">
			<input type="checkbox" name="delYn" class="check2" title="선택" value="<c:out value="${author.authorCode}"/>">
		</td>
		<td><c:out value="${author.authorCode}"/></td>
		<td><c:out value="${author.authorNm}"/></td>
		<td><c:out value="${author.authorDc}"/></td>
		<td><c:out value="${fn:substring(author.authorCreatDe,0,10)}"/></td>
		<td onclick="event.cancelBubble=true"><a href="<c:url value='/sec/ram/EgovAuthorRoleList.do'/>?searchKeyword=<c:out value="${author.authorCode}"/>" onclick="javascript:fncSelectAuthorRole('<c:out value="${author.authorCode}"/>')"><img src="<c:url value='/images/egovframework/com/cmm/btn/btn_search.gif'/>" width="15" height="15" align="middle" alt="롤 정보"></a></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	
	<c:if test="${!empty authorManageVO.pageIndex }">
		<!-- paging navigation -->
		<div class="pagination">
			<ul><ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage"/></ul>
		</div>
	</c:if>


</div><!-- end div board -->


<input type="hidden" name="authorCode"/>
<input type="hidden" name="authorCodes"/>
<input type="hidden" name="pageIndex" value="<c:out value='${authorManageVO.pageIndex}'/>"/>
<input type="hidden" name="searchCondition" value="1"/>
</form:form>
</body>
</html>
