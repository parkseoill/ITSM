<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : BizSytmMngList.jsp
  * @Description : 업무시스템 조회 화면
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.07.26   이유리               최초 생성
  *
  *  @author 이유리
  *  @since 2022.07.26
  *  @version 1.0
  *  @see
  *
  */
%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>업무시스템관리 목록</title>

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
	document.bizMngForm.pageIndex.value = pageNo;
	document.bizMngForm.action = "<c:url value='/opm/biz/BizSytmMngList.do'/>";
   	document.bizMngForm.submit();
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectBizSytmMng() {
	document.bizMngForm.pageIndex.value = 1;
	document.bizMngForm.action = "<c:url value='/opm/biz/BizSytmMngList.do'/>";
	document.bizMngForm.submit();
}

/* ********************************************************
 * 등록 화면 호출 함수
 ******************************************************** */
function insertBizSytmMngList(){
	document.bizMngForm.action = "<c:url value='/opm/biz/BizSytmMngRegist.do'/>";
   	document.bizMngForm.submit();
}

/* ********************************************************
 * 상세수정 처리 함수
 ******************************************************** */
function selectBizSytmMngListDetail(bizSytmCd) {
	document.bizMngForm.bizSytmCd.value = bizSytmCd;
   	document.bizMngForm.action = "<c:url value='/opm/biz/BizSytmMngUpdt.do'/>";
   	document.bizMngForm.submit();
}

/* ********************************************************
 * focus 시작점 지정함수
 ******************************************************** */
function fn_FocusStart(){
	$('#F1').focus();
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
//-->
</script>
</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>
<div class="board">
	<h1>업무시스템관리 목록</h1>
	<form name="bizMngForm" action ="<c:url value='/opm/biz/BizSytmMngList.do' />" method="post">
		<input type="hidden" name="bizSytmCd">
		<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
		<div class="search_box" title="업무시스템">
			<ul>
				<li style="padding-right:2%;">
					<label for="">검색조건 : </label>
					<input style="vertical-align: middle;" checked="checked" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '1'}">checked="checked"</c:if> value="1">시스템 코드</input>
					<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '2'}">checked="checked"</c:if> value="2">시스템명</input>
					<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '3'}">checked="checked"</c:if> value="3">상위 시스템 코드</input>
			  	</li>
				<li>  
					<label for="">검색어 : </label>
					<input id="F1" class="s_input2 vat" name="searchKeyword" type="text" value="<c:out value='${searchVO.searchKeyword}'/>" size="60" maxlength="60" onkeypress="press();" title="<spring:message code="title.searchCondition" />" /><!-- 검색조건 -->
					<input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectBizSytmMng(); return false;" /><!-- 조회 -->
					<span class="btn_b"><a href="#LINK" onclick="insertBizSytmMngList(); return false;" title='<spring:message code="button.create" />'><spring:message code="button.create" /></a></span><!-- 등록 -->		
				</li>
			</ul>
		</div>
		<table class="board_list">
			<caption></caption>
			<colgroup>
				<col style="width:20%" />
				<col style="width:20%" />
				<col style="width:15%" />
				<col style="width:15%" />
				<col style="width:15%" />
				<col style="width:15%" />
			</colgroup>
			<thead>
				<tr>
				   <th scope="col">시스템코드</th>
				   <th scope="col">시스템명</th>
				   <th scope="col">시스템코드 레벨</th>
				   <th scope="col">상위 시스템 코드</th>
				   <th scope="col">사용여부</th>
				   <th scope="col">우선순위</th>
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
				<tr onclick="selectBizSytmMngListDetail('<c:out value="${result.bizSytmCd}"/>'); return false;">	
					<td>
						<c:out value="${result.bizSytmCd}"/>
					</td>
					<td title="<c:out value="${result.bizSytmNm}"/>" class="leftElli">
						<c:out value="${result.bizSytmNm}"/>
					</td>
					<td>			    
						<c:out value="${result.bizSytmCdLvl}"/>
					</td>
					<td>
						<c:out value="${result.upprBizSytmCd}"/>
					</td>
					<td>
						<c:out value="${result.useYn}"/>
					</td>
					<td>
						<c:out value="${result.frstRank}"/>
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