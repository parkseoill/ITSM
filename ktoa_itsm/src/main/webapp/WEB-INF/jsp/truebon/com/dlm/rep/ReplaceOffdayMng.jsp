<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
 /**
  * @Class Name : WorkScheduleMng.jsp
  * @Description : 근무편성표 관리
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2023.02.03   김승현            최초 생성
  *
  *  @author 박서일
  *  @since 2023.02.03
  *  @version 1.0
  *  @see
  *
  */
%>

<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통 CSS -->
<link href="<c:url value="/css/egovframework/com/com.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>"
	rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<!-- 달력 기본 설정 -->
<script type="text/javascript"
	src="<c:url value='/js/truebon/com/cmm/initDatepicker.js' />"></script>

<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/truebon/com/dlm/dla/dlalz.css' />">

<script language="javascript1.2" type="text/javaScript">

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectWorkMng() {
   document.WorkScheduleMngForm.pageIndex.value = 1;
   document.WorkScheduleMngForm.action = "<c:url value='/dlm/wrk/WorkScheduleMng.do'/>";
   document.WorkScheduleMngForm.submit();
}

/* ********************************************************
 * 날짜체크처리 함수
 ******************************************************** */
function checkDate(){
   var getDate = document.getElementById('selectedDate').value;
   if(getDate != ""){
      document.WorkScheduleMngForm.checkDate.value = getDate.concat('01');
   }else{
      alert("년도를 입력해주세요.");
   } 
}


/* ********************************************************
 * 날짜 초기화 함수
 ******************************************************** */
function initializeDate(){
   document.getElementById("selectedDate").value = null;
}

$(function() {
   $('.sdate').datepicker( {
        changeYear: true,
        showButtonPanel: true,
        gotoCurrent: true,
        currentText:"현재년도",
        dateFormat: 'yy',
        stepMonths: 12,
        beforeShow: function(input) {
            $(input).datepicker("widget").addClass('hide-month-calendar');
        },
        onClose: function(dateText, inst) { 
            $(this).datepicker('setDate', new Date(inst.selectedYear, 1));
            $(this).datepicker("widget").removeClass('hide-month-calendar');
        } 
    });     
   	
   $(".colorChange").each(function(){
      if($(this).find('#hdayNm').html() != ""){
         $(this).find('#dyweek').css('color','#FF0000');
      }
   });
   
   
	$("#currDate").val(getToday('yyyy-mm-dd'));
	// 달력 생성
	$('#currDate').datepicker({
		onSelect: function(dateText){
		console.log("Selected date:"+dateText+",current value"+this.value);
		}
	});
   
});


</script>

<style>
/* 달력 날짜 선택 안보이게 */
.hide-calendar .ui-datepicker-calendar {
	display: none;
}

.hide-month-calendar .ui-datepicker-calendar {
	display: none;
}

.hide-month-calendar .ui-datepicker-month {
	display: none;
}

.replaceList, .replaceUseList {
	width: 100%;
	border-top: 1px solid #444444;
	border-collapse: collapse;
}

.replaceList th, td, .replaceUseList th, td {
	border-bottom: 1px solid #444444;
	padding: 10px;
}
</style>

</head>
<body>
	<noscript class="noScriptTitle">
		<spring:message code="common.noScriptTitle.msg" />
	</noscript>
	<!-- 자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다. -->

	<div class="board">
		<!-- 타이틀 -->
		<h1>대휴 관리</h1>
		<form name="ReplaceOffdayMng"
			action="<c:url value='/dlm/rep/ReplaceOffdayMng.do' />" method="post">
			<input type="hidden" name="name" id="name" value="${loginVO.name}" />
			<!-- 달력 -->

			<div class="search_box">
				<ul class="search_box-ul_bottom">
					<li style="padding-Right: 70%;"><label for="">기간 : </label> <input
						id="selectedDate" name="selectedDate" type="text" class="sdate"
						value="${searchVO.selectedDate}" /> <input class="s_btn"
						type="submit" value='<spring:message code="button.inquire" />'
						title='<spring:message code="button.inquire" />'
						onclick="selectReplaceOffdayMng(); return false;" /> <!-- 조회 -->
						<span class="btn_b"><a href="#LINK'/>"
							onclick="initializeDate(); return false;">초기화</a></span> <!-- 초기화 --></li>
				</ul>
			</div>
		</form>

		<c:if test="${loginVO.name == '관리자'}">
			<form name="ReplaceOffdayMng"
				action="<c:url value='/dlm/rep/ReplaceOffdayInsert.do' />"
				method="post">
				<div style="border-color: black;">
					<h2 style="font: blod; font-size: 18px;">대휴 생성</h2>
					날짜 : <input type="text" id="currDate" name="selectedDate2"
						value="${searchVO.selectedDate2}">
					<!--달력  -->
					이름 : <input type="text" class="chrgrNm" name="chrgrNm" id="chrgrNm">
					대휴 수 : <input type="text" class="insertCnt" name="insertCnt"
						id="insertCnt"> 
						사유 : <input type="text"
						class="replacOffdayRsnCd" name="replacOffdayRsnCd"
						id="replacOffdayRsnCd">
					<button type="submit">생성</button>
				</div>
				  <c:forEach var="result" items="${offdayWrkRsnCdList}" varStatus="status">
                           <tr style="text-align: center;">
                              <td>${result.comnCdNm}</td>
                        </c:forEach>
				<p>
				<div style="border-bottom: 2px solid #4688d2; margin: 20px 0px 20px 0px;"></div>
			</form>
		</c:if>

		<p style="font-size: 20px; font-weight: 900;">${searchVO.selectedDate}년도
			대휴 현황</p>
		<div class="contentDiv"
			style="margin: 0 auto; width: 100%; height: 120px; margin: 0 auto; text-align: center;">
			<div class="myOwnDaysTxt"
				style="width: 15%; height: 60px; text-align: center; padding: 23px 25px; display: inline-block;">
				<p style="font-size: 20px; font-weight: bold;">잔여대휴</p>
				<p style="font-size: 30px; margin-top: 10px;">
					<span style="color: #4688d2; font-weight: bolder;">${residnCnt}</span>
					일
				</p>
			</div>

			<div class="extDayInfo"
				style="width: 15%; height: 60px; padding: 23px 25px; display: inline-block; text-align: left;">
				<p style="font-size: 20px;">
					<span style="padding-right: 24px; font-weight: bold;">총 대휴</span> <span
						style="font-weight: bold; color: #4688d2;">${repSum}</span> 일
				</p>

				<p style="font-size: 20px; margin-top: 20px;">
					<span style="padding-right: 10px; font-weight: bold;">사용대휴</span> <span
						style="font-weight: bold; color: #4688d2;">${useSum}</span> 일
				</p>
			</div>
		</div>
		<div
			style="border-bottom: 2px solid #4688d2; margin: 20px 0px 20px 0px;"></div>
		<div style="width: 100%; height: 500px;">
			<div class="replaceList" style="float: left; width: 30%;">
				<div>
					<p style="font-size: 18px; font-weight: bolder; padding: 10px;">대휴
						발생 현황</p>
				</div>
				<div>
					<table class="replaceList">
						<tbody style="font-size: 20px;">
							<tr>
								<th>이름</th>
								<th>발생일</th>
								<th>발생대휴</th>
								<th>사유</th>
							</tr>
                        <c:forEach var="result" items="${resultList}" varStatus="status">
                           <tr style="text-align: center;">
                              <td>${result.chrgrNm}</td>
                              <td>${result.replacOffdayDate}</td>
                              <td>${result.replacOffdayCnt}</td>
                              <td>                    
                               <c:if test="${result.replacOffdayRsnCd eq '1'}">당직</c:if>
                               <c:if test="${result.replacOffdayRsnCd eq '2'}">정기 PM</c:if>
                               <c:if test="${result.replacOffdayRsnCd eq '3'}">비정기 PM</c:if>
                               <c:if test="${result.replacOffdayRsnCd eq '4'}">기타</c:if>
                               </td>
                           </tr>
                        </c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- <div style="float: left; border-left: 2px solid #4688d2; height : 100%; margin-left: 13%;"></div> -->
			<div class="replaceUseList"
				style="float: left; width: 30%; margin: 0 0 0 20%;">
				<div>
					<p style="font-size: 18px; font-weight: bolder; padding: 10px;">대휴
						사용 현황</p>
				</div>
				<div>
					<table class="replaceUseList">
						<tbody style="font-size: 20px;">
							<tr>
								<th>이름</th>
								<th>사용일</th>
								<th>사용대휴</th>
							</tr>
							<c:forEach var="result" items="${resultUseList}"
								varStatus="status">
								<tr style="text-align: center;">
									<td>${result.chrgrNm}</td>
									<td>${result.dlalzDate}</td>
									<td>${result.useRep}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>