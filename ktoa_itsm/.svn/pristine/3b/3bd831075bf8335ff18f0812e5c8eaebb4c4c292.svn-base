<!DOCTYPE html>
<%--
 /**
  * @Class Name : SrMasterMngList.jsp
  * @Description : 서비스 요청  조회 화면
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.07.28       김도아    	      최초 생성
  *
  *  @author 김도아
  *  @since 2022.07.28
  *  @version 1.0
  *  @see
  *
  */
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>서비스요청관리 목록</title>
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
$(document).ready(function () {
	fn_FocusStart();
	
	fn_checkAll();
});
/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
	document.SrMasterMngForm.pageIndex.value = pageNo;
	document.SrMasterMngForm.action = "<c:url value='/opm/srm/SrMasterMngList.do'/>";
   	document.SrMasterMngForm.submit();
}
/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectSrMasterMng() {
	document.SrMasterMngForm.pageIndex.value = 1;
	document.SrMasterMngForm.action = "<c:url value='/opm/srm/SrMasterMngList.do'/>";
	document.SrMasterMngForm.submit();
}
/* ********************************************************
 * 입력 화면 호출 함수
 ******************************************************** */
function insertSrMasterMngList() {
   	document.SrMasterMngForm.action = "<c:url value='/opm/srm/SrMasterMngRegist.do'/>";
   	document.SrMasterMngForm.submit();
}
/* ********************************************************
 * 상세조회처리 함수
 ******************************************************** */
function selectSrMasterMngListDetail(srMngtNo,srTypeClasCd,dlngChrgrNo) {
	document.SrMasterMngForm.srMngtNo.value = srMngtNo;
	document.SrMasterMngForm.srTypeClasCd.value = srTypeClasCd;
	document.SrMasterMngForm.dlngChrgrNo.value = dlngChrgrNo;
   	document.SrMasterMngForm.action = "<c:url value='/opm/srm/SrMasterMngUpdt.do'/>";
   	document.SrMasterMngForm.submit();
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
    	selectSrMasterMng();
    }
}

/* ********************************************************
 * 달력 텍스트 박스 날짜 세팅
 ******************************************************** */
	$(document).ready(function(){
		$.datepicker.setDefaults($.datepicker.regional['ko']); 
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
    let checkSrs = "";
    let checkedCount = 0;
    
    $("input[name=checkField]").each(function() {
    	if($(this).is(":checked") == true) {
    		checkSrs += checkedCount==0? $(this).val() : "," + $(this).val();
    		checkedCount++;
    	}
    });

    if(checkedCount ==0){
		alert("선택된 서비스요청이 없습니다.");
		return false;
    }

    if(confirm("<spring:message code="common.delete.msg" />")){	//삭제하시겠습니까?
    	$("input[name=checkedValueForDel]").val(checkSrs);
    	$("#SrMasterMngForm").attr("action", "<c:url value='/opm/srm/deleteSrMasterList.do'/>");
    	$("#SrMasterMngForm").submit();
    }
}

/* ********************************************************
 * 엑셀 다운로드하기
 ******************************************************** */
 function downloadExcel() {
	$("#SrMasterMngForm").attr("action", "<c:url value='/opm/srm/downloadExcel.do'/>");
   	$("#SrMasterMngForm").submit();
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
//-->
</script>
</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<div class="board">
	<h1>서비스요청관리 목록</h1>
	<form name="SrMasterMngForm" id="SrMasterMngForm" action ="<c:url value='/opm/srm/SrMasterMngList.do' />" method="post">
	<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
	<input type="hidden" name="srMngtNo" value="<c:out value='${result.srMngtNo}'/>">
	<input type="hidden" name="srTypeClasCd" value="<c:out value='${result.srTypeClasCd}'/>"/>
	<input type="hidden" name="dlngChrgrNo" value="<c:out value='${result.dlngChrgrNo}'/>">
	<input type="hidden" name="checkedValueForDel" /><!-- 삭제 키 -->
	
	<div class="search_box">
		<ul style="text-align:center; display: flex; justify-content: space-around;">
			<li>
				<label for="">요청일 : </label> &nbsp;
				<input class="s_input4 vat" name="startDate" id="startDate" type="text"  value="<c:out value='${searchVO.startDate}'/>" onkeypress="press();"   />
				~	<input class="s_input4 vat" name="endDate" id="endDate" type="text"  value="<c:out value='${searchVO.endDate}'/>" onkeypress="press();"  />
			</li> 
			<li>
				<label for="">요청부서 : </label> &nbsp;
				<select id="searchDeptCd" name="searchDeptCd" title="검색조건">
				<option value=""> == 선택 ==</option>
					<c:forEach var="dept" items="${deptList}" varStatus="status">         
						<option value='${dept.positDeptNm}' <c:if test="${searchVO.searchDeptCd == dept.positDeptNm}">selected="selected"</c:if>>${dept.positDeptNm}</option>  
					</c:forEach>
				</select>
			</li>
			<li style="">
				<label for="">요청자 : </label> 
				<input id="searchSytmCdNm" class="s_input3 vat" name="searchSytmCdNm" type="text" value="<c:out value='${searchVO.searchSytmCdNm}'/>" size="60" maxlength="60" onkeypress="press();"/>
			</li>
		</ul>
		<ul style="display: flex; justify-content: space-around; border-top:1px solid #dddddd; padding-top:10px; margin-top:10px;">
			<li style=" float:left;">
				<label for="">담당자 : </label> &nbsp;
				<select id="searchName" name="searchName" title="검색조건">
				<option value="showAll"> == 선택 ==</option>
					<c:forEach var="name" items="${nameList}" varStatus="status">         
						<option value='${name.chrgrNo}' <c:if test="${searchVO.searchName == name.chrgrNo}">selected="selected"</c:if>>${name.chrgrNm} (${name.chrgrNo})</option>  
					</c:forEach>

				</select>
			</li> 
			<li style="padding-left:9%;">
				<label for="">업무시스템명 : </label> 
				<select id="searchSytmCd" name="searchSytmCd" title="검색조건" >
				<option value=""> == 선택 ==</option>
					<c:forEach var="bizSytm" items="${bizSytmList}" varStatus="status" >         
						<option value='${bizSytm.bizSytmCd}' <c:if test="${searchVO.searchSytmCd == bizSytm.bizSytmCd}">selected="selected"</c:if>>${bizSytm.bizSytmNm}</option>  
					</c:forEach>
				</select>
			</li>
			<li style="float:right;">
				<input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectSrMasterMng(); return false;" /><!-- 조회 -->
				<span class="btn_b"><a href="#LINK" onclick="insertSrMasterMngList(); return false;" title='<spring:message code="button.create" />'><spring:message code="button.create" /></a></span><!-- 등록 -->
				<span class="btn_b"><a href="#LINK" onclick="fn_DeleteList(); return false;" title='<spring:message code="button.delete" />'><spring:message code="button.delete" /></a></span><!-- 삭제 -->
			</li>
		</ul>
	</div>

	<table class="board_list">
		<caption></caption>
		<colgroup>
			<col style="width:5px" />
			<col style="width:24px" />
			<col style="width:18px" />
			<col style="width:17px" />
			<col style="width:33px" />
			<col style="width:17px" />
			<col style="width:12px" />
			<col style="width:21px" />
			<col style="width:12px" />
			<col style="width:21px" />
			<col style="width:10px" />
		</colgroup>
		<thead>
			<tr>
			   <th scope="col"><input type="checkbox" name="checkAll" title="전체선택" /></th>
			   <th scope="col">요청관리번호</th>
			   <th scope="col">업무시스템명</th>
			   <th scope="col">요청중분류</th>
			   <th scope="col">요청제목</th>
			   <th scope="col">요청부서</th>
			   <th scope="col">요청자</th>
			   <th scope="col">요청일</th>
			   <th scope="col">담당자</th>
			   <th scope="col">처리일</th>
			   <th scope="col">진행상태</th>
			</tr>
		</thead>
		<tbody class="ov">
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(resultList) == 0}">
			<tr>
				<td colspan="11">
					<spring:message code="common.nodata.msg" />
				</td>
			</tr>
			</c:if>
			 
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr onclick="selectSrMasterMngListDetail('<c:out value="${result.srMngtNo}"/>','<c:out value="${result.srTypeClasCd}"/>','<c:out value="${result.dlngChrgrNo}"/>'); return false;">
				<td onclick="event.cancelBubble=true">
					<!-- 작성자만 선택 가능 -->
					<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN' || sessionScope.loginVO.chrgrNo eq result.dlngChrgrNo}">
						<input type="checkbox" name="checkField" title="선택" value="<c:out value='${result.srMngtNo}'/>">
					</c:if> 
				</td>
				<td>
					<c:out value="${result.srMngtNo}"/>
				</td>
				<td title="<c:out value="${result.bizSytmNm}"/>" class="Elli">
					<c:out value="${result.bizSytmNm}"/>
				</td>
				<td title="<c:out value="${result.srTypeClasNm}"/>" class="Elli">
					<c:out value="${result.srTypeClasNm}"/>
				</td>
				<td title="<c:out  value="${result.reqTitle}"/>" class="leftElli">			    
					<c:out  value="${result.reqTitle}"/>
				</td>
				<td title="<c:out  value="${result.positDeptNm}"/>" class="Elli">			    
					<c:out  value="${result.positDeptNm}"/>
				</td>
				<td>
					<c:out value="${result.reqChrgrNm}"/>
				</td>
				<td>
					<fmt:parseDate var="ReqDate" value="${result.reqDate}" pattern="yyyyMMdd" />
					<fmt:formatDate value="${ReqDate}" pattern="yyyy-MM-dd" />					
				</td>
				<td>
					<c:out value="${result.dlngChrgrNm}"/>
				</td>
				<td>
					<fmt:parseDate var="DlngDate" value="${result.dlngDate}" pattern="yyyyMMdd" />
					<fmt:formatDate value="${DlngDate}" pattern="yyyy-MM-dd" />			
				</td>
				<td>
					<c:out value="${result.srProgStat}"/>
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
	<div>
		<span class="btn_s2"><a href="#LINK" onclick="downloadExcel(); return false;" title='엑셀 다운로드'>엑셀 다운로드</a></span><!-- 엑셀 다운로드 -->
	</div>
	</form>
</div>

</body>
</html>