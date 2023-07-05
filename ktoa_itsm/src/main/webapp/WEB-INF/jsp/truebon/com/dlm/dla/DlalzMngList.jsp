<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
 /**
  * @Class Name : DlalzList.jsp
  * @Description : 근태 조회 화면
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.05.31   이유리            최초 생성
  *
  *  @author 이유리
  *  @since 2022.05.31
  *  @version 1.0
  *  @see
  *
  */
%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>근태관리 목록</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<!-- 달력 기본 설정 -->
<script type="text/javascript" src="<c:url value='/js/truebon/com/cmm/initDatepicker.js' />"></script>

<link type="text/css" rel="stylesheet" href="<c:url value='/css/truebon/com/dlm/dla/dlalz.css' />">

<script language="javascript1.2" type="text/javaScript">
<!--

/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
	document.dlalzMngForm.pageIndex.value = pageNo;
	document.dlalzMngForm.action = "<c:url value='/dlm/dla/DlalzMngList.do'/>";
   	document.dlalzMngForm.submit();
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectDlalzMng() {
	document.dlalzMngForm.pageIndex.value = 1;
	document.dlalzMngForm.action = "<c:url value='/dlm/dla/DlalzMngList.do'/>";
	document.dlalzMngForm.submit();
}

/* ********************************************************
 * 상세조회처리 함수
 ******************************************************** */
function selectDlalzMngListDetail(dlalzDate,chrgrNo) {
	document.dlalzMngForm.dlalzDate.value = dlalzDate;
	document.dlalzMngForm.chrgrNo.value = chrgrNo;
   	document.dlalzMngForm.action = "<c:url value='/dlm/dla/DlalzMngUpdt.do'/>";
   	document.dlalzMngForm.submit();
}

/* ********************************************************
 * 날짜체크처리 함수
 ******************************************************** */
function checkDate(){
	var getDate = document.getElementById('selectedDate').value;
	if(getDate != ""){
		document.dlalzMngForm.checkDate.value = getDate.concat('01');
		insertDlalzMngList()
	}else{
		alert("년도를 입력해주세요.");
	} 
}

/* ********************************************************
 * 입력 화면 호출 함수
 ******************************************************** */
function insertDlalzMngList() {
	document.dlalzMngForm.action = "<c:url value='/dlm/dla/insertDlalzMngRegist.do'/>";
	document.dlalzMngForm.submit(); 
}

/* ********************************************************
 * 날짜 초기화 함수
 ******************************************************** */
function initializeDate(){
	document.getElementById("selectedDate").value = null;
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
-->
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$('input[type="radio"][name="searchKeyword2"]').on('click', function(){
			var chkValue = $('input[type="radio"][name="searchKeyword2"]:checked').val();
			if(chkValue == ""){
				$('.0').show();
				$('.1').hide();
				$('.2').hide();
				$("#searchKeyword3").val("").prop("selected", true);
				$("#searchKeyword5").val("").prop("selected", true);
				$("#searchKeyword6").val("").prop("selected", true);
				$('.search_box-ul_top').css("background-image", "none");
			}else if(chkValue == "1"){
				$('.0').hide();
				$('.1').show();
				$('.2').hide();
				$("#searchKeyword5").val("").prop("selected", true);
				$("#searchKeyword6").val("").prop("selected", true);
				$('.search_box-ul_top').css("background-image", "url(/images/truebon/com/dlm/cod/dash_line.gif)");
				$('.search_box-ul_top').css("background-position", "60% top");
				$('.search_box-ul_top').css("background-repeat", "no-repeat");
			}else{
				$('.0').hide();
				$('.1').hide();
				$('.2').show();
				$("#searchKeyword3").val("").prop("selected", true);
				$('.search_box-ul_top').css("background-image", "url(/images/truebon/com/dlm/cod/dash_line.gif)");
				$('.search_box-ul_top').css("background-position", "60% top");
				$('.search_box-ul_top').css("background-repeat", "no-repeat");
			}
		});
	});
	
	$(document).ready(function(){
	    $('#create').click(function() {
	    	var selectedYear = $('#selectedDate').val().substring(0,4);
	    	var selectedMonth = $('#selectedDate').val().substring(5);
	    	var result = confirm('모든 사용자의 '+selectedYear+'년 ' +selectedMonth+ '월 데이터를 생성하시겠습니까?');
	    	
	        if(result) {
	        	checkDate();
	        }
	    });
	});
	
	$(function() {
	    $('.sdate').datepicker( {
	        changeYear: true,
	        changeMonth: true,
	        showButtonPanel: true,
	        gotoCurrent: true,
	        currentText:"현재달",
	        dateFormat: 'yy-mm',
	        onClose: function(dateText, inst) { 
	            $(this).datepicker('setDate', new Date(inst.selectedYear, inst.selectedMonth, 1));
	        } 
	    });	   
	});

	$(document).ready(function(){
		var temp = $('input[type="radio"][name="searchKeyword2"]:checked').val();
		if(temp == ""){
			$('.all').trigger("click");
		}else if(temp == "1"){
			$('.wrk').trigger("click");
		}else {
			$('.offday').trigger("click");	
		}
	}); 
	
</script>
<style>
.ui-datepicker-calendar {
    display: none;
    }
.dayBg { background-color: #f6f6f6; }
</style>
</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<div class="board">
	<h1>근태관리 목록</h1>
	<form name="dlalzMngForm" action ="<c:url value='/dlm/dla/DlalzMngList.do' />" method="post">
	<input type="hidden" name="dlalzDate"/>
	<input type="hidden" name="chrgrNo"/>
	<input type="hidden" name="checkDate" />
	<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
	
	<div class="search_box" title="담당자명">
		<ul class="search_box-ul_top" >
			<li style="float:left; padding-left:10%;">
				<label for="">근태 구분 : </label>
				<input type="radio" class="all" checked="checked" name="searchKeyword2" value="">전체</input>
				<!-- <label class="container">전체</label> -->
				<input  type="radio" class="wrk" <c:if test="${searchVO.searchKeyword2 == '1'}">checked="checked"</c:if> id="workDay" name="searchKeyword2" value="1">근무일</input>
				<!-- <label class="container">근무일</label> -->
				<input type="radio" class="offday" <c:if test="${searchVO.searchKeyword2 == '2'}">checked="checked"</c:if> id="offDay" name="searchKeyword2" value="2">휴무일</input>
				<!-- <label class="container">휴무일</label> -->
				<%-- <input type="radio" class="offday" <c:if test="${searchVO.searchKeyword2 == '2'}">checked="checked"</c:if> id="offDay" name="searchKeyword2" value="2">
				<label class="container">전일 휴무</label>
				<input type="radio" class="hlfday" <c:if test="${searchVO.searchKeyword2 == '3'}">checked="checked"</c:if> id="hlOffDay" name="searchKeyword2" value="3">
				<label class="container">반일 휴무</label> --%>
			</li>
			<li class="0">
			<label>          </label>
			</li>
			<li class="1" style="diplay=none; padding-right:9%;">
				<label for="">근무 구분 : </label>
				<select id="searchKeyword3" name="searchKeyword3">
					<option value=""> == 선택 ==</option>
					<c:forEach var="wrkTypeCd" items="${wrkTypeCdList}" varStatus="status">         
						<option value="${wrkTypeCd.comnCd}" <c:if test="${searchVO.searchKeyword3 == wrkTypeCd.comnCd}">selected="selected"</c:if>>${wrkTypeCd.comnCdNm}</option>      
					</c:forEach>
				</select>
			</li>	
			<li class="2" style="diplay=none; padding-right:6%;">
				<label for="">휴가 구분 : </label>
				<select id="searchKeyword5" name="searchKeyword5">
					<option value=""> == 선택 ==</option>
					<option value="1" <c:if test="${searchVO.searchKeyword5 eq '1'}">selected</c:if>>연차</option>
					<option value="2" <c:if test="${searchVO.searchKeyword5 eq '2'}">selected</c:if>>대휴</option>
					<option value="3" <c:if test="${searchVO.searchKeyword5 eq '3'}">selected</c:if>>공가</option>
			<%-- 		<c:forEach var="offdayTypeCd" items="${offdayTypeCdList}" varStatus="status">         
						<option value="${offdayTypeCd.comnCd}" <c:if test="${searchVO.searchKeyword5 == offdayTypeCd.comnCd}">selected="selected"</c:if> >${offdayTypeCd.comnCdNm}</option>      
					</c:forEach>
					 --%>
				</select >
				<label for="">반차 구분 : </label>
				<select id="searchKeyword6" name="searchKeyword6">
					<option value=""> == 선택 ==</option>
					<c:forEach var="hlfdayOffdayDstnctCd" items="${hlfdayOffdayDstnctCdList}" varStatus="status">         
						<option value="${hlfdayOffdayDstnctCd.comnCd}" <c:if test="${searchVO.searchKeyword6 == hlfdayOffdayDstnctCd.comnCd}">selected="selected"</c:if> >${hlfdayOffdayDstnctCd.comnCdNm}</option>      
					</c:forEach>
				</select>
			</li>
		</ul>
		<ul class="search_box-ul_bottom">
	<%-- 	   <li style="padding-left:10%; float:left;">
				<label for="">위탁업체명 : </label>
				<select id="searchKeyword4" name="searchKeyword4">
					<option value=""> == 선택 ==</option>
					<c:forEach var="offdayTypeCd" items="${offdayTypeCdList}" varStatus="status">         
						<option value="${offdayTypeCd.comnCd}" <c:if test="${searchVO.searchKeyword4 == offdayTypeCd.comnCd}">selected="selected"</c:if> >${offdayTypeCd.comnCdNm}</option>      
					</c:forEach>
				</select>
			</li> --%>
			<li style="padding-left:10%; float:left;">
				<label for="">성명 : </label>
					<select id="searchKeyword" name="searchKeyword">
							<option value="showAll"> == 선택 ==</option>
							<c:forEach var="name" items="${nameList}" varStatus="status">         
								<option value='${name.chrgrNo}' <c:if test="${searchVO.searchKeyword == name.chrgrNo}">selected="selected"</c:if>>${name.chrgrNm} (${name.chrgrNo})</option>  
							</c:forEach>
					</select>
			</li>
			<li style="padding-right:8%;">
				<label for="">기간 : </label>
				<input id="selectedDate" name="selectedDate" type="text" class="sdate" value="${searchVO.selectedDate}"/>
				<input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectDlalzMng(); return false;" /><!-- 조회 -->
				<span class="btn_b"><a href="#LINK'/>" onclick="initializeDate(); return false;">초기화</a></span><!-- 초기화 -->
				<!-- 관리자만 생성 -->
				<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN'}">
					<span id="create" class="btn_b"><a  title='<spring:message code="button.create" />'>월 데이터 생성</a></span><!-- 월 데이터 생성 -->
				</c:if>
			</li>
		</ul>
	</div>

	<table class="board_list">
		<caption></caption>
		<colgroup>
			<col style="width:92px" />
			<col style="width:9%" />
			<col style="width:12%" />
			<col style="width:10%" />
			<col style="width:10%" />
			<col style="width:10%" />
			<col style="width:12%" />
			<col style="width:10%" />
			<col style="width:10%" />
			<col style="width:10%" />
			<col style="width:6%" />
			<col style="width:10%" />
			<col style="width:11%" />
		</colgroup>
		<thead>
			<tr>
			   <th scope="col">날짜</th>
			   <th scope="col">성명</th>
			   <th scope="col">소속</th>
			   <th scope="col">근무시간</th>
			   <th scope="col">출근시간</th>
			   <th scope="col">퇴근시간</th>
			   <th scope="col">근태구분</th>
			   <th scope="col">근무구분</th>
			   <th scope="col">휴가구분</th>
			   <th scope="col">반차구분</th>
			   <th scope="col">당직</th>
			   <th scope="col">수정자</th>
			   <th scope="col">비고</th>
			</tr>
		</thead>
		<tbody class="ov">
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(resultList) == 0}">
			 <tr>
			 <td colspan="13">
				<spring:message code="common.nodata.msg" />
			 </td>
			 </tr>
			 </c:if>
			 <c:forEach var="result" items="${resultList}" varStatus="status">
				<c:choose>
					<c:when test="${result.offdayTypeCd eq '4'}">
			  			<tr class="dayBg" onclick="selectDlalzMngListDetail('<c:out value="${result.dlalzDate}"/>','<c:out value="${result.chrgrNo}"/>'); return false;">
					</c:when>		
					<c:otherwise>
						<tr onclick="selectDlalzMngListDetail('<c:out value="${result.dlalzDate}"/>','<c:out value="${result.chrgrNo}"/>'); return false;">
					</c:otherwise>
				</c:choose>
			    
			    	<fmt:parseDate var="DlalzDate" value="${result.dlalzDate}" pattern="yyyyMMdd" />
			    <td class="Elli" title="<fmt:formatDate value="${DlalzDate}" pattern="yyyy-MM-dd"/>">
				 	<fmt:formatDate value="${DlalzDate}" pattern="yyyy-MM-dd" />	
			    </td>
			    <td title="<c:out value="${result.chrgrNm}"/>"><c:out value="${result.chrgrNm}"/></td>
			    <td class="Elli" title="<c:out value="${result.cmpnyNm}"/>"><c:out value="${result.cmpnyNm}"/></td>
			    <td>
			    	<c:if test="${result.wrkTimeCd eq '1'}">주간</c:if>
					<c:if test="${result.wrkTimeCd eq '2'}">야간</c:if>
				</td>
			    <td><c:out value="${fn:substring(result.atendTime,11,16)}"/></td>
			    <td><c:out value="${fn:substring(result.leofcTime,11,16)}"/></td>
			    <td>
		    		<c:if test="${result.dlalzDstnctCd eq '1'}">전일근무</c:if>
					<c:if test="${result.dlalzDstnctCd eq '2'}">전일휴무</c:if>
					<c:if test="${result.dlalzDstnctCd eq '3'}">반일휴무</c:if>
			    </td>
			    <td>
			    	<c:if test="${result.wrkTypeCd eq '1'}">사무실</c:if>
					<c:if test="${result.wrkTypeCd eq '2'}">재택</c:if>
					<c:if test="${result.wrkTypeCd eq '3'}">외근</c:if>
				</td>
			    <td>
					<c:if test="${result.offdayTypeCd eq '1'}">연차</c:if>
					<c:if test="${result.offdayTypeCd eq '2'}">대휴</c:if>
					<c:if test="${result.offdayTypeCd eq '3'}">공가</c:if>
					<c:if test="${result.offdayTypeCd eq '4'}"><span style="color:#FF0000">공휴일</span></c:if>
			    </td>
			    <td>
			   		<c:if test="${result.hlfdayOffdayDstnctCd eq '1'}">오전</c:if>
					<c:if test="${result.hlfdayOffdayDstnctCd eq '2'}">오후</c:if>
				</td>
			    <td>
				    <c:if test="${result.securBonduYn eq 'Y'}">O</c:if>
				    <c:if test="${result.securBonduYn eq 'N'}">X</c:if>
			    </td>
			    <td class="Elli" title="<c:out value="${result.amndrNm}"/>"><c:out value="${result.amndrNm}"/></td>
			    <td class="Elli" title="<c:out value="${result.rmarkText}"/>"><c:out value="${result.rmarkText}"/></td>
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