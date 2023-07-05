<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
 /**
  * @Class Name : BizReportList.jsp
  * @Description : 업무보고서 조회 화면
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.08.25   이태신               최초 생성
  *
  *  @author 이태신
  *  @since 2022.08.25
  *  @version 1.0
  *  @see
  *
  */
%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title><c:out value="${searchVO.getBizReportKindNm()}"/> 목록</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<!-- 달력 기본 설정 -->
<script type="text/javascript" src="<c:url value='/js/truebon/com/cmm/initDatepicker.js' />"></script>

<script language="javascript1.2" type="text/javaScript">
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
		}
	});
	$( "#endDate" ).datepicker({
		changeMonth: true, 
		changeYear: true,
		onClose: function( selectedDate ) {    
		    // 종료일(endDate) datepicker가 닫힐때
		    // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
		    $("#startDate").datepicker( "option", "maxDate", selectedDate );
		}
	});
	
	// 체크박스 전체 선택 및 해제
	fn_checkAll();
});

/* ********************************************************
 * 체크박스 모두선택 및 해제 처리 함수
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
    let checkIds = "";
    let checkedCount = 0;
    
    $("input[name=checkField]").each(function() {
    	if($(this).is(":checked") == true) {
    		checkIds += checkedCount==0? $(this).val() : "," + $(this).val();
    		checkedCount++;
    	}
    });

    if(checkedCount ==0){
		alert("선택된 업무보고서가 없습니다.");
		return false;
    }

    if(confirm("<spring:message code="common.delete.msg" />")){	//삭제하시겠습니까?
    	$("input[name=checkedValueForDel]").val(checkIds);
    	$("#bizReportForm").attr("action", "<c:url value='/rsm/wmr/deleteBizReportList.do'/>");
    	$("#bizReportForm").submit();
    }
}

/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
   	$("#pageIndex").val(pageNo);
	$("#bizReportForm").attr("action", "<c:url value='/rsm/wmr/BizReportList.do'/>");
	$("#bizReportForm").submit();
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectBizReport() {
	$("#pageIndex").val(1);
	$("#bizReportForm").attr("action", "<c:url value='/rsm/wmr/BizReportList.do'/>");
	$("#bizReportForm").submit();
}

/* ********************************************************
 * 입력 화면 호출 함수
 ******************************************************** */
function insertBizReportList() {
	$("#bizReportForm").attr("action", "<c:url value='/rsm/wmr/BizReportRegist.do'/>");
	$("#bizReportForm").submit();
}

/* ********************************************************
 * 상세조회처리 함수
 ******************************************************** */
function selectBizReportListDetail(bizReportId) {
	$("#bizReportId").val(bizReportId);
	$("#bizReportForm").attr("action", "<c:url value='/rsm/wmr/BizReportUpdt.do'/>");
	$("#bizReportForm").submit();
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
    	selectBizReport();
    }
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
</script>
</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<div class="board">
	<h1><c:out value="${searchVO.getBizReportKindNm()}"/> 목록</h1>
	<form:form commandName="searchVO" id="bizReportForm" name="bizReportForm" method="post" action="${pageContext.request.contextPath}/rsm/wmr/BizReportList.do">
	<form:hidden path="pageIndex" /><!-- 페이지 인덱스 -->
	<form:hidden path="checkedValueForDel" /><!-- 삭제 키 -->
	<form:hidden path="bizReportKindCd" /><!-- 업무보고서 종류 -->
	<form:hidden path="bizReportId" /><!-- 업무보고서 ID -->
	
	<div class="search_box">
		<ul>
			<li style="padding-left:3%; float:left;">
				<label for="">작성 일자</label> &nbsp;
				<form:input path="startDate" cssClass="s_input4 vat" title="시작일" onkeypress="press();" />
				~	<form:input path="endDate" cssClass="s_input4 vat" title="종료일" onkeypress="press();" />
			</li>
			<li>
				<label for="">담당자 : </label>
				<select id="creatChrgrNo" name="creatChrgrNo">
						<option value="">== 선택 ==</option>
						<c:forEach var="name" items="${nameList}" varStatus="status">         
							<option value='${name.chrgrNo}' <c:if test="${searchVO.creatChrgrNo == name.chrgrNo}">selected="selected"</c:if>>${name.chrgrNm} (${name.chrgrNo})</option>  
						</c:forEach>
				</select>
				<input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectBizReport(); return false;" /><!-- 조회 -->
				<span class="btn_b"><a href="#LINK" onclick="insertBizReportList(); return false;" title='<spring:message code="button.create" />'><spring:message code="button.create" /></a></span><!-- 등록 -->
				<span class="btn_b"><a href="#LINK" onclick="fn_DeleteList(); return false;" title='<spring:message code="button.delete" />'><spring:message code="button.delete" /></a></span><!-- 삭제 -->
			</li>
		</ul>
	</div>

	<table class="board_list">
		<caption></caption>
		<colgroup>
			<col style="width:5px" />
			<col style="width:53%" />
			<col style="width:8%" />
			<col style="width:17%" />
			<col style="width:17%" />
		</colgroup>
		<thead>
			<tr>
			   <th scope="col"><input type="checkbox" name="checkAll" title="전체선택" /></th>
			   <th scope="col"><c:out value="${searchVO.getBizReportKindNm()}"/>명</th>
			   <th scope="col">작성자</th>
			   <th scope="col">등록일</th>
			   <th scope="col">수정일</th>
			</tr>
		</thead>
		<tbody class="ov">
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(resultList) == 0}">
			<tr>
				<td colspan="5">
					<spring:message code="common.nodata.msg" />
				</td>
			</tr>
			</c:if>
			 
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr onclick="selectBizReportListDetail('<c:out value="${result.bizReportId}"/>'); return false;">
				<td onclick="event.cancelBubble=true">
				<!-- 작성자만 선택 가능 -->
				<c:if test="${sessionScope.loginVO.chrgrNo eq result.creatChrgrNo}">
					<input type="checkbox" name="checkField" title="선택" value="<c:out value='${result.bizReportId}'/>">
				</c:if>
				</td>
				<td class="leftElli" title="<c:out value="${result.bizReportNm}"/>">
					<c:out value="${result.bizReportNm}"/>
				</td>
				<td>
					<c:out value="${result.creatChrgrNm}"/>
				</td>
				<td>			    
					<c:out value="${result.rdtt}"/>
				</td>
				<td>
					<c:out value="${result.mdtt}"/>
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
	
	</form:form>

</div>

</body>
</html>