<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	/**
* @Class Name : EgovUnitContent.jsp
* @Description : 로그인 성공후 컨텐츠 영역
* @Modification Information
* 
* @수정일               수정자            수정내용
*  ----------   --------   ---------------------------
*  2020.06.23   신용호            세션만료시간 보여주기
*  2023.06.16   최호용            대시보드 보여주기
*
*  @author 공통서비스 개발팀 신용호
*  @since 2009.03.03
*  @version 1.0
*  @see
*
*  Copyright (C) 2009 by MOPAS  All right reserved.
*/
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>KTOA ITSM</title>
<style type="text/css">
.pwdTitleClass .ui-widget-header {
	background-color: #F9A7AE;
	background-image: none;
	color: Black;
}
</style>
<style>
body {
	width: 1260px; /* 원하는 가로 크기로 설정 */
	height: 560px; /* 원하는 세로 크기로 설정 */
}
</style>
<link type="text/css" rel="stylesheet"
	href="/css/egovframework/com/cmm/jqueryui.css">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<!-- jQuery Modal CSS -->
<link rel="stylesheet"
	href="/css/truebon/com/cmm/jquery-modal/0.9.1/jquery.modal.min.css" />
<!-- jQuery Modal JS -->
<script src="/js/truebon/com/cmm/jquery-modal/0.9.1/jquery.modal.min.js"></script>

<script type="text/javascript">
$(document).ready(function () {
	<c:if test="${loginVO.authorCode eq 'ROLE_ADMIN'}">
		comnDateRegistAlarm();     
	</c:if>	  
	dashboard();
	Popup()	  
});

//휴가자 상세 정보 팝업 호출 함수
function Popup() {	
	$('#popupAttendance1').click(function (e) {
		e.preventDefault();
	    var pagetitle = $(this).attr("title");
	    var page = "<c:url value='/cmm/dsb/Popup.do?popupType=1'/>";
	    var $dialog = $('<div style="overflow:hidden;padding: 0px 0px 0px 0px;"></div>')
	    	.html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
	    	.dialog({
	    		autoOpen: false,
	            modal: true,
	            width: 550,
	            height: 650,
	            title: pagetitle,
	            open: function () {
	                var iframe = document.getElementById('popupIframe');
	                iframe.onload = function () {
	                    var message = iframe.contentDocument.body.innerHTML;
	                    alert(message); // 메시지를 팝업 창에서 알림으로 표시
	                };
	            }
	    	});
	    $dialog.dialog('open');
	});
	
	$('#popupAttendance2').click(function (e) {
		e.preventDefault();
	    var pagetitle = $(this).attr("title");
	    var page = "<c:url value='/cmm/dsb/Popup.do?popupType=2'/>";
	    var $dialog = $('<div style="overflow:hidden;padding: 0px 0px 0px 0px;"></div>')
	    	.html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
	    	.dialog({
	    		autoOpen: false,
	            modal: true,
	            width: 550,
	            height: 650,
	            title: pagetitle
	    	});
	    $dialog.dialog('open');
	});
}
	
// 대시보드 데이터 호출 함수
function dashboard() {
	$.ajax({
		url: "/cmm/dsb/serviceRequestProcessingStatistics.do",
	    method: "POST",
		dataType: 'text',
		contentType: "application/json; charset:UTF-8", 
	    success: function(data) {
	    	var srpsArrayList = JSON.parse(data);
	    	if(srpsArrayList[20] != ''){
	    		alert(srpsArrayList[20] + "출퇴근 기록이 안되어 있습니다.");
	    	}   	
	        for (var i = 0; i < srpsArrayList.length; i++) {
	        	var firstSpan = document.getElementsByClassName("srps")[i];
	        	firstSpan.textContent = srpsArrayList[i];	        
	        }  	   
	    },
	    error: function(request, status, error){   
	    	console.log(request);
	    	alert("status : " + request.status + ", error : " + error); 
	    } 
	});	 
}
    
// 공통일자 등록 알림
function comnDateRegistAlarm(){
	var today = new Date();
    var month = today.getMonth()+1;
    var date = today.getDate();
    var year = today.getFullYear();
    var checkDate = "";
    if(month == 12 && date >=15){
    	checkDate = (year+1).toString().concat("0101");
    }else{
        checkDate = year.toString().concat("0101");
    }  
            
    $.ajax({
    	url :"<c:url value='/dlm/cod/checkComnDateExist.do'/>",
    	type: "POST",
    	data : {
        	"checkDate":checkDate
        },
        dataType: 'json',
        success : function(data){
        	//값에 따라 메시지 표시 
            const getData = $.trim(data.existDate);
            if(getData == 0){
            	// 모달 메시지
                $("#modalMsg").html(data.resultMsg);
                // 모달 실행
                $("#modalMsg").modal({
                	fadeDuration: 250
                });   
                // 모달 종료
                setTimeout(closeModal, 3000);
             }
         }
         ,error: function(){
         	alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.
         }
	});         
}

<c:if test="${!empty resultMsg}">alert("<spring:message code="${resultMsg}" />");</c:if> 
</script>

<link type="text/css" rel="stylesheet"
	href="/css/egovframework/com/cmm/dashboard.css">
</head>
<body>
	<c:if test="${loginVO != null}">
		<!--
      ${loginVO.name}(${loginVO.id})<spring:message code="comCmm.unitContent.2"/> <a href="${pageContext.request.contextPath }/uat/uia/actionLogout.do"><spring:message code="comCmm.unitContent.3"/></a>
      -->
		<!--
      <br>passedDay = ${passedDay}
      <br>expirePwdDay = ${expirePwdDay}
      <br>elapsedTimeExpiration = ${elapsedTimeExpiration}
      -->
		<script type="text/javaScript" language="javascript">
         parent.frames["_top"].location.reload();
         parent.frames["_left"].location.reload();
      </script>
	</c:if>
	<c:if test="${loginVO == null }">
		<jsp:forward page="/uat/uia/egovLoginUsr.do" />
	</c:if>
	<!-- <p/><p/><p/> -->
	<h2>대시보드 - 개발중</h2>                  	
	<div class="board">
		<div class="nemo">
			<div class="nemo-title">
				<h3><spring:message code="comCmm.dashboardContent.1" /></h3><!-- 서비스 요청 처리 통계 -->
			</div>
			<table>
				<tr>
					<td></td>
					<th><span class="srps"></span><spring:message code="comCmm.dashboardContent.14" /></th><!-- 월 -->
					<th><span class="srps"></span><spring:message code="comCmm.dashboardContent.14" /></th><!-- 월 -->
				</tr>
				<tr>
					<td><spring:message code="comCmm.dashboardContent.10" /></td><!-- 전월이월 -->					
					<td><span class="srps"></span></td>
					<td><span class="srps"></span></td>
				</tr>
				<tr>
					<td><spring:message code="comCmm.dashboardContent.11" /></td><!-- 당월접수 -->
					<td><span class="srps"></span></td>
					<td><span class="srps"></span></td>
				</tr>
				<tr>
					<td><spring:message code="comCmm.dashboardContent.12" /></td><!-- 총 건수 -->
					<td><span class="srps"></span></td>
					<td><span class="srps"></span></td>
				</tr>				
				<tr>
					<td><spring:message code="comCmm.dashboardContent.13" /></td><!-- 완료건수 -->
					<td><span class="srps"></span></td>
					<td><span class="srps"></span></td>
				</tr>
			</table>
		</div>
		<div class="nemo">
			<div class="nemo-title">
				<h3><spring:message code="comCmm.dashboardContent.2" /></h3><!-- 나의 서비스 요청 처리 현황 -->				
			</div>
			
			<table>
				<tr>
					<td></td>
					<th class="th"><span class="srps"></span><spring:message code="comCmm.dashboardContent.14" /></th><!-- 월 -->
					<th class="th"><span class="srps"></span><spring:message code="comCmm.dashboardContent.14" /></th><!-- 월 -->
				</tr>
				<tr>
					<td><spring:message code="comCmm.dashboardContent.10" /></td><!-- 전월이월 -->
					<td><span class="srps"></span></td>
					<td><span class="srps"></span></td>
				</tr>
				<tr>
					<td><spring:message code="comCmm.dashboardContent.11" /></td><!-- 당월접수 -->
					<td><span class="srps"></span></td>
					<td><span class="srps"></span></td>
				</tr>
				<tr>
					<td><spring:message code="comCmm.dashboardContent.12" /></td><!-- 총 건수 -->
					<td><span class="srps"></span></td>
					<td><span class="srps"></span></td>
				</tr>
				<tr>
					<td><spring:message code="comCmm.dashboardContent.13" /></td><!-- 완료건수 -->
					<td><span class="srps"></span></td>
					<td><span class="srps"></span></td>
				</tr>
			</table>
		</div>
		<div class="nemo-dev">
			<div class="nemo-title">
				<h3><spring:message code="comCmm.dashboardContent.3" /></h3><!-- 보고 현황(금주) -->
			</div>
			<table>
				<tr class="tr-content3">
					<th class="th-content3"><spring:message code="comCmm.dashboardContent.30" /></th><!-- 문서 -->
					<th class="th-content3"><spring:message code="comCmm.dashboardContent.31" /></th><!-- 작성 여부 -->
				</tr>
				<tr>
					<td class="td-none"></td>
					<td class="td-left"><spring:message code="comCmm.dashboardContent.32" /></td><!-- 주간 보고서(금주) -->
					<td class="td-right"><spring:message code="comCmm.dashboardContent.35" /></td><!-- 작성  -->
				</tr>
				<tr class="tr-content3">
					<td class="td-none"></td>
					<td class="td-left"><spring:message code="comCmm.dashboardContent.33" /></td><!-- 월간 보고서(금월) -->
					<td class="td-right"><spring:message code="comCmm.dashboardContent.36" /></td><!-- 미작성 -->
				</tr>
				<tr class="tr-content3">
					<td class="td-none"></td>
					<td class="td-left"><spring:message code="comCmm.dashboardContent.34" /></td><!-- 근무 편성표(내달) -->
					<td class="td-right"><spring:message code="comCmm.dashboardContent.36" /></td><!-- 미작성 -->
				</tr>
			</table>
		</div>
		<div class="nemo-dev">
			<div class="nemo-title">
				<h3><spring:message code="comCmm.dashboardContent.4" /></h3><!-- 근태 현황 -->
			</div>
			<table>
				<tr class="tr-content3">
					<th class="th-dev"><spring:message code="comCmm.dashboardContent.40" /><!-- 금주 --></th>
					<th class="th-dev"><spring:message code="comCmm.dashboardContent.41" /><!-- 차주 --></th>
				</tr>
				<tr class="tr-content3">
					<th class="th-content4-2"><a id="popupAttendance1" target="_blank" title="금주 휴가자 상세">휴가자:?명</a><br><br>MNP당직<!-- <br>06-25 짱구<br>06-26 철수<br>06-27 맹구 --></th>
					<th class="th-content4-2"><a id="popupAttendance2" target="_blank" title="차주 휴가자 상세">휴가자:?명</a><br><br>MNP당직</th>
				</tr>
			</table>
		</div>
		<div class="nemo-dev">
			<div class="nemo-title">
				<h3><spring:message code="comCmm.dashboardContent.5" /></h3><!-- 기타 현황 -->
			</div>
			<table>
				<tr class="tr-content3">
					<th class="th-content4">06월</th>
				</tr>				
				<tr class="tr-left">
					<td class="td-left2"><spring:message code="comCmm.dashboardContent.51" /></td><!-- 정기점검현황 -->
				</tr>
				<tr class="tr-left">
					<td class="td-left2"><spring:message code="comCmm.dashboardContent.52" /></td><!-- 작업현황 -->
				</tr>
				<tr class="tr-left">
					<td class="td-left2"><spring:message code="comCmm.dashboardContent.53" /></td><!-- 자체점검현황 -->
				</tr>
			</table>
		</div>
		<div class="nemo-dev">
			<div class="nemo-title">
				<h3><spring:message code="comCmm.dashboardContent.6" /></h3><!-- 장애 현황 -->
			</div>
			<table>
				<tr class="tr-content3">
					<th class="th-content4">
						06월
					</th>
				</tr>
				<tr class="tr-content3">
					<th class="th-content4-1">
						<h3>개발중</h3>
					</th>
				</tr>
			</table>
		</div>
	</div>

	<%-- <b>해당 페이지는 로그인 후 메인 페이지이며, 개발이 모두 완료된 후 출력할 화면을 선택하여 구성 예정입니다.</br><br/>
   <b><img src="${pageContext.request.contextPath }/images/egovframework/com/cmm/icon/tit_icon.png"> <spring:message code="comCmm.unitContent.5"/></b><p/><!-- 화면 설명 -->
   <spring:message code="comCmm.unitContent.6"/><p/><!-- 왼쪽 메뉴는 메뉴와 관련된 컴포넌트(메뉴관리, 사이트맵 등)들의 영향을 받지 않으며, -->
   <spring:message code="comCmm.unitContent.7"/><p/><!-- 각 컴포넌트를 쉽게 찾아볼 수 있는 바로 가기 링크페이지입니다. -->
   트리 메뉴는 DB 저장된 권한별 메뉴를 출력합니다.(신규 추가)<p/>

   <br /><b><img src="${pageContext.request.contextPath }/images/egovframework/com/cmm/icon/tit_icon.png"> egovframework.com.cmm.web.EgovComIndexController.java</b><p/>

   <spring:message code="comCmm.unitContent.8"/><p/><!-- 컴포넌트 설치 후 설치된 컴포넌트들을 IncludedInfo annotation을 통해 찾아낸 후 -->
   <spring:message code="comCmm.unitContent.9"/><p/><br /><!-- 화면에 표시할 정보를 처리하는 Controller 클래스입니다. -->
   <spring:message code="comCmm.unitContent.10"/><p/><!-- 개발 시 메뉴 구조가 잡히기 전에 배포 파일들에 포함된 공통 컴포넌트들의 목록성 화면에 URL을 제공하여 -->
   <spring:message code="comCmm.unitContent.11"/><p/><!-- 개발자가 편리하게 활용할 수 있도록 작성되었습니다. -->
   운영 시에 본 기능은 삭제 예정이며, 트리구조 메뉴를 사용하여 배포할 예정입니다. <p/> --%>

	<!-- Modal HTML -->
	<div id="modalMsg" class="modal">메시지</div>
</body>
</html>