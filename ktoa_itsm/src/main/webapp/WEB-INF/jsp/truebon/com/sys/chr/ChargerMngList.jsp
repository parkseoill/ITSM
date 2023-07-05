<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : ChargerList.jsp
  * @Description : 담당자 조회 화면
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.05.04   이태신               최초 생성
  *
  *  @author 이태신
  *  @since 2022.05.04
  *  @version 1.0
  *  @see
  *
  */
%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>담당자 목록</title>
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
	<c:if test="${sessionScope.loginVO.authorCode ne 'ROLE_ADMIN'}">
    	disabled();
	</c:if>	
	
	fn_checkAll();
	<c:if test="${searchVO.getSearchCondition() == ''}">
		$("input:checkbox[id='#ktoa']").prop("checked", true);
	</c:if>	
	
});

function disabled() {
	$('table input[type=checkbox]').attr('disabled','true');
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
    let checkChargerNos = "";
    let checkedCount = 0;
    
    $("input[name=checkField]").each(function() {
    	if($(this).is(":checked") == true) {
    		checkChargerNos += checkedCount==0? $(this).val() : "," + $(this).val();
    		checkedCount++;
    	}
    });

    if(checkedCount ==0){
		alert("선택된 담당자가 없습니다.");
		return false;
    }

    if(confirm("<spring:message code="common.delete.msg" />")){	//삭제하시겠습니까?
    	$("input[name=checkedValueForDel]").val(checkChargerNos);
    	$("#chargerMngForm").attr("action", "<c:url value='/sys/chr/deleteChargerMngList.do'/>");
    	$("#chargerMngForm").submit();
    }
}

/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
	document.chargerMngForm.pageIndex.value = pageNo;
	document.chargerMngForm.action = "<c:url value='/sys/chr/ChargerMngList.do'/>";
   	document.chargerMngForm.submit();
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectChargerMng() {
	document.chargerMngForm.pageIndex.value = 1;
	document.chargerMngForm.action = "<c:url value='/sys/chr/ChargerMngList.do'/>";
	document.chargerMngForm.submit();
}
/* ********************************************************
 * 입력 화면 호출 함수
 ******************************************************** */
function insertChargerMngList() {
   	document.chargerMngForm.action = "<c:url value='/sys/chr/ChargerMngRegist.do'/>";
   	document.chargerMngForm.submit();
}
/* ********************************************************
 * 상세조회처리 함수
 ******************************************************** */
function selectChargerMngListDetail(chrgrNo) {
	document.chargerMngForm.chrgrNo.value = chrgrNo;
   	document.chargerMngForm.action = "<c:url value='/sys/chr/ChargerMngUpdt.do'/>";
   	document.chargerMngForm.submit();
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
    	selectChargerMng();
    }
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
//-->
</script>
</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<div class="board">
	<h1>담당자 목록</h1>
	<form name="chargerMngForm" id="chargerMngForm" action ="<c:url value='/sys/chr/ChargerMngList.do' />" method="post">
	<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
	<input type="hidden" name="checkedValueForDel" />
	<input type="hidden" name="chrgrNo">
	<div class="search_box" title="담당자명">
		<ul>
			<li style="padding-left:2%; float:left;">
				<label for="">구분 :</label>&nbsp;
				<input style="vertical-align: middle;" type="checkbox" id="ktoa"  name="searchCode" <c:forEach var="List" items="${searchCodeList}"><c:if test="${fn:contains(List,1)}">checked="checked"</c:if></c:forEach> value="1"> ktoa</input>&nbsp;
				<input style="vertical-align: middle;" type="checkbox" name="searchCode" <c:forEach var="List" items="${searchCodeList}"><c:if test="${fn:contains(List,2)}">checked="checked"</c:if></c:forEach> value="2">위탁운영</input>&nbsp;
				<input style="vertical-align: middle;" type="checkbox" name="searchCode" <c:forEach var="List" items="${searchCodeList}"><c:if test="${fn:contains(List,3)}">checked="checked"</c:if></c:forEach> value="3">협력업체</input>&nbsp;				
				<input style="vertical-align: middle;" type="checkbox" name="searchCode" <c:forEach var="List" items="${searchCodeList}"><c:if test="${fn:contains(List,4)}">checked="checked"</c:if></c:forEach> value="4">기타</input>		
			</li>
			<li style="padding-right:2%;">
				<label for="">검색조건 : </label>
				<input style="vertical-align: middle;" checked="checked" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '1'}">checked="checked"</c:if> value="1">담당자명</input>
				<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '2'}">checked="checked"</c:if> value="2">회사명</input>
				<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '3'}">checked="checked"</c:if> value="3">무선전화</input>
				<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '4'}">checked="checked"</c:if> value="4">이메일</input>
			</li>
			<li>
				<label for="">검색어 : </label>
				<input id="F1" class="s_input2 vat" name="searchKeyword" type="text" value="<c:out value='${searchVO.searchKeyword}'/>" size="60" maxlength="60" onkeypress="press();" title="<spring:message code="title.searchCondition" />" /><!-- 검색조건 -->
				
				<input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectChargerMng(); return false;" /><!-- 조회 -->
				<!-- 관리자만 출력 -->
				<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN'}">
					<span class="btn_b"><a href="#LINK" onclick="insertChargerMngList(); return false;" title='<spring:message code="button.create" />'><spring:message code="button.create" /></a></span><!-- 등록 -->
					<span class="btn_b"><a href="#LINK" onclick="fn_DeleteList(); return false;" title='<spring:message code="button.delete" />'><spring:message code="button.delete" /></a></span><!-- 삭제 -->
				</c:if>
			</li>
		</ul>
	</div>

	<table class="board_list">
		<caption></caption>
		<colgroup>
			<col style="width:5px" />
			<col style="width:10%" />
			<col style="width:10%" />
			<col style="width:13%" />
			<col style="width:13%" />
			<col style="width:15%" />
			<col style="width:15%" />
			<col style="width:19%" />
		</colgroup>
		<thead>
			<tr>
			   <th scope="col"><input type="checkbox" name="checkAll" class="check2" id="checkboxTh" onclick="fCheckAll();" title="전체선택" /></th>
			   <th scope="col">담당자명</th>
			   <th scope="col">직급</th>
			   <th scope="col">유선전화</th>
			   <th scope="col">무선전화</th>
			   <th scope="col">담당자회사</th>
			   <th scope="col">담당자부서</th>
			   <th scope="col">이메일</th>
			</tr>
		</thead>
		<tbody class="ov" id="checkboxTb">
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(resultList) == 0}">
			<tr>
				<td colspan="8">
					<spring:message code="common.nodata.msg" />
				</td>
			</tr>
			</c:if>
			 
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr onclick="selectChargerMngListDetail('<c:out value="${result.chrgrNo}"/>'); return false;">
				<td onclick="event.cancelBubble=true">
					<input type="checkbox" name="checkField" class="check2" title="선택" id="checkbox" value="<c:out value='${result.chrgrNo}'/>">
				</td>
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
				<td class="Elli" title="<c:out value="${result.positCmpnyNm}"/>">
					<c:out value="${result.positCmpnyNm}"/>
				</td>
				<td class="Elli" title="<c:out value="${result.positDeptNm}"/>">
					<c:out value="${result.positDeptNm}"/>
				</td>
				<td class="Elli" title="<c:out value="${result.chrgrEaddr}"/>">
					<c:out value="${result.chrgrEaddr}"/>
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