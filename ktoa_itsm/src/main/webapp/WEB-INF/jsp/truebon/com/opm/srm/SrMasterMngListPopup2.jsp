<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
/**
 * @Class Name : SrMasterMngListPopup2.jsp
 * @Description : 서비스 요청 목록 팝업 화면
 * @Modification Information
 * @
 * @  수정일             수정자             수정내용
 * @ ----------   --------   ---------------------------
 * @ 2022.09.01   이태신               최초 생성
 * 
 *
 *  @author 이태신
 *  @since 2022.09.01
 *  @version 1.0
 *  @see
 *
 */
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>서비스 요청 목록</title>
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
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
   	$("#pageIndex").val(pageNo);
   	$("#SrMasterMngForm").attr("action", "<c:url value='/opm/srm/SrMasterMngListPopup2.do'/>");
	$("#SrMasterMngForm").submit();
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectSrMasterMng() {
	$("#SrMasterMngForm").attr("action", "<c:url value='/opm/srm/SrMasterMngListPopup2.do'/>");
	$("#SrMasterMngForm").submit();
}

/* ********************************************************
 * 서비스 요청 목록 선택 처리 함수
 ******************************************************** */
function getSrMngtNo() {
	let checkIds = "";
    let checkedCount = 0;
    
    $("input[name=checkField]").each(function() {
    	if($(this).is(":checked") == true) {
    		checkIds += checkedCount==0? $(this).val() : "," + $(this).val();
    		checkedCount++;
    	}
    });

    if(checkedCount ==0){
		alert("선택된 서비스 요청이 없습니다.");
		return false;
    }

    if(confirm("선택한 서비스 요청은 보고서(주간, 월간) 대상 여부가 자동 저장됩니다.\r\n\r\n선택한 서비스 요청을 적용합니까?")){
    	// 함수 실행(서비스 요청 번호 전달 및 주간, 월간 보고 대상 여부 저장)
        $(parent.document.location).attr("href", "javascript:insertSrMngt('" + checkIds + "');");
    	
        // dialog 닫기
        parent.$('.ui-dialog-content').dialog('close');
    }
}

/* ********************************************************
 * 엔터key 목록조회  함수
 ******************************************************** */
function press() {
    if (event.keyCode==13) {
    	selectSrMasterMng();
    }
}

/* ********************************************************
 * 주간, 월간 체크 저장  함수
 ******************************************************** */
function fn_chkWeekMonthSave(pObj) {
    // 체크박스 명
	let chkName = $(pObj).attr("name");
	// 체크박스 값
    let chkValue = $(pObj).val();
    // 체크박스 변경될 값
	let chgChkValue = "";
    // 서비스 요청 번호
    let srMngtNo = $(pObj).parent().parent().find("[name=checkField]").val();
    // 주간보고 저장 여부
    let weekyReportTargtYn = "";
 	// 월간보고 저장 여부
    let monthyReportTargtYn = "";
    
    // 체크 값 변경
    if(chkValue == "N") {
    	$(pObj).val("Y");
    	chgChkValue = "Y";
    } else {
    	$(pObj).val("N");
    	chgChkValue = "N";
    }
    
    if(chkName == "checkWeekyReportTargtYn") {
    	// 주간보고 저장 여부가 선택된 경우 Y, N 저장
    	weekyReportTargtYn = chgChkValue;
    } else {
    	// 월간보고 저장 여부가 선택된 경우 Y, N 저장
    	monthyReportTargtYn = chgChkValue;
    }
    
    $.ajax({
		url :"<c:url value='/opm/srm/chkWeekMonthSave.do'/>"
        ,type: "POST"
        ,data : {
        	"srMngtNo":srMngtNo,
        	"weekyReportTargtYn":weekyReportTargtYn,
        	"monthyReportTargtYn":monthyReportTargtYn
        }
        ,dataType: 'json'  	   
        ,success : function(data){
        	//alert(data.resultMsg);
        	console.log(data.resultMsg);
		}
	    ,error: function(){
	    	alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.
	    }
	});
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>

</script>

</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<div class="popup" style="min-width:680px;" >
	<h1>서비스 요청 목록</h1>
	
	<form:form commandName="searchVO" id="SrMasterMngForm" name="SrMasterMngForm" method="post" action="${pageContext.request.contextPath}/opm/srm/SrMasterMngListPopup2.do">
	<form:hidden path="pageIndex" /><!-- 페이지 인덱스 -->
	<form:hidden path="checkedValueForDel" /><!-- 삭제 키 -->
	<form:hidden path="searchSytmCd" /><!-- 업무시스템 코드 -->

	<div class="pop_search_box" title="검색 영역" Style="min-width:430px;">
		<ul>
			<li style="padding-left:3%; float:left;">
				<label for="">요청 일자 : </label>
				<form:input path="startDate" cssClass="s_input4 vat" title="시작일" onkeypress="press();" />
				~	<form:input path="endDate" cssClass="s_input4 vat" title="종료일" onkeypress="press();" />
			</li>
			<li>
				&nbsp;<input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectChargerMng(); return false;" /><!-- 조회 -->
				<input class="s_btn" type="button" value='적용' title='적용' onclick="getSrMngtNo(); return false;" /><!-- 적용 -->
			</li>
		</ul>
	</div>

	<table class="pop_board_list">
		<caption></caption>
		<colgroup>
			<col style="width: 5%;">
			<col style="width: 15%;">
			<col style="width: 35%;">
			<col style="width: 10%;">
			<col style="width: 15%;">
			<col style="width: 10%;">
			<col style="width: 5%;">
			<col style="width: 5%;">
		</colgroup>
		<thead>
			<tr>
				<th scope="col"><input type="checkbox" name="checkAll" title="전체선택" /></th>
				<th scope="col">업무시스템명</th>
				<th scope="col">요청제목</th>
				<th scope="col">요청자</th>
				<th scope="col">요청일</th>
				<th scope="col">진행상태</th>
				<th scope="col">주간</th>
				<th scope="col">월간</th>
			</tr>
		</thead>
		<tbody class="ov">
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(resultList) == 0}">
			<tr>
				<td colspan="8">
					<spring:message code="common.nodata.msg" />
				</td>
			</tr>
			</c:if>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
				<td>
					<input type="checkbox" name="checkField" title="선택" value="<c:out value='${result.srMngtNo}'/>">
				</td>
				<td class="elli" title="<c:out value="${result.bizSytmNm}"/>">
					<c:out value="${result.bizSytmNm}"/>
				</td>
				<td class="leftElli" title="<c:out value="${result.reqTitle}"/>">
					<c:out value="${result.reqTitle}"/>
				</td>
				<td>
					<c:out value="${result.reqChrgrNm}"/>
				</td>
				<td>
					<fmt:parseDate var="ReqDate" value="${result.reqDate}" pattern="yyyyMMdd" />
					<fmt:formatDate value="${ReqDate}" pattern="yyyy-MM-dd" />
				</td>
				<td>
					<c:out value="${result.srProgStat}"/>
				</td>
				<td>
					<input type="checkbox" name="checkWeekyReportTargtYn" title="주간보고 사용 여부&#10;단순 표시용" onclick="fn_chkWeekMonthSave(this);" value="<c:out value='${result.weekyReportTargtYn}'/>" <c:if test="${result.weekyReportTargtYn == 'Y'}"> checked="checked"</c:if>>
				</td>
				<td>
					<input type="checkbox" name="checkMonthyReportTargtYn" title="월간보고 사용 여부&#10;단순 표시용" onclick="fn_chkWeekMonthSave(this);" value="<c:out value='${result.monthyReportTargtYn}'/>" <c:if test="${result.monthyReportTargtYn == 'Y'}"> checked="checked"</c:if>>
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