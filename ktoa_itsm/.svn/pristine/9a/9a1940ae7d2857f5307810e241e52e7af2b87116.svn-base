<!DOCTYPE html>
<%--
 /**
  * @Class Name : SecureMngList.jsp
  * @Description : 보안관리 목록
  * @Modification Information
  * @
  * @ 수정일               수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.07.28   조경민            최초 생성
  *
  *  @author 조경민
  *  @since 2022.07.28
  *  @version 1.0
  *  @see
  *
  */
--%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<c:set var="ImgUrl" value="${pageContext.request.contextPath}/images/egovframework/com/sym/mnu/mpm/"/>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>보안관리</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<!-- validator 클라이언트 -->
<script type="text/javascript" src="<c:url value="/validator.do" />"></script>
<validator:javascript formName="vo" staticJavascript="false" xhtml="true" cdata="false"/>

<script>
	// 조회
	function selectSecure() {
		document.SecureForm.action = "<c:url value='/sys/scu/secure.do'/>";
		document.SecureForm.submit();
	}
	// 수정
	function secureDetail(date, silc) {
		document.SecureForm.inspDate.value = date;
		document.SecureForm.securInspLoacatCd.value = silc;
		document.SecureForm.action = "<c:url value='/sys/scu/SecureMngUpdt.do'/>";
		document.SecureForm.submit();
	}
	
	// 등록
	function insertSecucreMngList() {
		document.SecureForm.action = "<c:url value='/sys/scu/SecureMngRegist.do'/>";
		document.SecureForm.submit();
	}
	$(document).ready(function () {
	// 이미지 사이즈 조절
	$("svg[name=imgSvg]").css("width","100%");
	$("svg[name=imgSvg]").css("height","100%");
	});
	
	//사인자 정보 등록 및 사인 출력
	function updateConfrSign(date, silc, count){
		$.ajax({
			url			:"<c:url value='/sys/scu/updateConfrSign.do'/>"
	        ,type		: "POST"
	        ,async		: true
	        ,data		: {
	        	inspDate : date,
	        	securInspLoacatCd : silc
	        }
	        ,dataType	: 'json'  	   
	        ,success	: function(data){
	        	//console.log("사인 등록 메시지:"+data.resultMsg);
	        	if(data.resultMsg == "1"){
	        		alert("사인이 저장되었습니다.");
	        		// 저장된 이미지 값 hidden 값으로 저장.
	        		$("#strUserSign").val(data.result.strUserSign);
	        		$("#strConfrName").val(data.result.confrName);
	        		// 이미지 출력 및 버튼 삭제
	        		getSvgImg(count);
	        	}else{
	        		alert("사인이 저장되지 않았습니다.");
	        	}
			}
		    ,error: function(){
		    	alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.
		    }
		});
	}


	function getSvgImg(count){
		let strUserSign = $("#strUserSign").val();
		let strName = $("#strConfrName").val();
		// 이미지가 있는 경우 출력
		if(strUserSign != null && strUserSign.length != 0){
			let usersign = getSvgData2(strUserSign);
			$("#userSignArea"+count).html(usersign);
			$("#userNameArea"+count).html(strName);
			
			if(typeof $("svg[name=imgSvg]") != "undefined"){
				// 이미지 사이즈 조절
				$("svg[name=imgSvg]").css("width","100%");
				$("svg[name=imgSvg]").css("height","100%");
			}
			
			// 사인 값이 있는 경우 버튼 삭제
			$("#btnUserSign"+count).css("display","none");
		}
	}
	//SVG 데이터를 base64 디코딩(공통)
	function getSvgData2(dataURL){
		const parts = dataURL.split(';base64,');
		let raw = "";
		if(typeof parts[1] != "undefined"){
			raw = window.atob(parts[1]);
		}else{
			raw = dataURL;
		}
		return raw;
	}
	
</script>
</head>
<body>
<div class="board">
	<h1>
		보안점검관리 목록
	</h1>
	<form name="SecureForm" action="<c:url value='/sys/scu/secure.do'/>" method="POST">
	<input type="hidden" name="inspDate" value="${vo.inspDate }">
	<input type="hidden" name="securInspLoacatCd" value="${vo.securInspLoacatCd }">
	<input type="hidden" id="strUserSign" />
	<input type="hidden" id="strConfrName" />
	<div class="search_box" title="보안목록">
		<ul>
			<c:set var="sysYear"><fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM" /></c:set>
			<fmt:parseDate var="parseDateSearch" value="${vo.dateSearch }" pattern="yyyyMM" />
			<fmt:formatDate value="${parseDateSearch}" pattern="yyyy-MM" var="formatDateSearch"/>
			<li style="padding-right:2%;">
					<label for="">검색조건 : </label>
					<input style="vertical-align: middle;" checked="checked" type="radio" name="inspLocatSearch" <c:if test="${vo.inspLocatSearch == ''}">checked="checked"</c:if> value="">전체</input>
					<input style="vertical-align: middle;" type="radio" name="inspLocatSearch" <c:if test="${vo.inspLocatSearch == '1'}">checked="checked"</c:if> value="1">본관</input>
					<input style="vertical-align: middle;" type="radio" name="inspLocatSearch" <c:if test="${vo.inspLocatSearch == '2'}">checked="checked"</c:if> value="2">별관</input>
			</li>
			<li>
				<label for="">날짜(월) : </label>
				<input type="month" name="dateSearch" min="2000-01" max="${sysYear }" title="날짜검색" value="${!empty vo.dateSearch ? formatDateSearch : sysYear}" style="height: 24px; width: 105px;">
			</li>
			<li>
				<input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectSecure(); return false;" /><!-- 조회 -->
				<span class="btn_b"><a href="#LINK" onclick="insertSecucreMngList(); return false;" title='<spring:message code="button.create" />'><spring:message code="button.create" /></a></span><!-- 등록 -->
			</li>
		</ul>
	</div>
	<div style="height: 80vh; overflow-y: auto; white-space: nowrap; border-collapse: collapse;">
	<table class="board_list" style="white-space: nowrap; border-collapse: collapse;">
		<colgroup class="board_list">
			<col style="width: 10%" />
			<col style="width: 10%" />
			<col style="width: 10%" />
			<col style="width: 10%" />
			<col style="width: 10%" />
			<col style="width: 9%" />
			<col style="width: 9%" />
			<col style="width: 9%" />
			<col style="width: 9%" />
			<col style="width: 12%" />
			<col style="width: 12%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">점검일자</th>
				<th scope="col">위치</th>
				<th scope="col">점검시간</th>
				<th scope="col">점검자</th>
				<th scope="col">확인자</th>
				<th scope="col">PC</th>
				<th scope="col">기타전원</th>
				<th scope="col">서류보안</th>
				<th scope="col">화기단속</th>
				<th scope="col">소등및문단속</th>
				<th scope="col">확인자 사인</th>
			</tr>
		</thead>
		<tbody class="ov">
		
		<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
		<c:if test="${fn:length(secureList) == 0}">
			<tr>
				<td colspan="11">
					<spring:message code="common.nodata.msg" />
				</td>
			</tr>
		</c:if>
		
		<c:forEach var="list" items="${secureList }" varStatus="status">
			<%-- <!-- 점검일자 -->
			<fmt:parseDate var="inspDate" value="${list.inspDate }" pattern="yyyyMMdd" />
			<fmt:formatDate value="${inspDate}" pattern="yyyy-MM-dd" var="date"/>
			--%>
			<!-- 점검시간 -->
			<fmt:parseDate var="inspTime" value="${list.inspTime }" pattern="yyyy-MM-dd HH:mm:ss.SSS" />
			<fmt:formatDate value="${inspTime}" pattern="HH:MM" var="time"/> 
			<tr onclick="secureDetail('<c:out value="${list.inspDate}"/>','<c:out value="${list.securInspLoacatCd}"/>'); return false">
				<td><c:out value="${list.inspDate }"/></td> 
				<td><c:out value="${list.securInspLoacatCd == 1 ? '본관' : '별관'}"/></td> 
				<%-- <td><c:out value="${time }"/></td>  --%>
				<td><c:out value="${fn:substring(list.inspTime,11,16)}" escapeXml="false"/></td>
				<td><c:out value="${empty list.isprName ? '-' : list.isprName}"/></td> 
				<td>
				<c:out value="${list.confrName}"/>
				<div id="userNameArea${status.count }"></div>
				</td> 
				<td><c:out value="${empty list.ppsirc ? '-' : list.ppsirc}"/></td> 
				<td><c:out value="${empty list.epsirc ? '-' : list.epsirc}"/></td> 
				<td><c:out value="${empty list.psirc ? '-' : list.psirc}"/></td> 
				<td><c:out value="${empty list.fsirc ? '-' : list.fsirc}"/></td> 
				<td><c:out value="${empty list.lsirc ? '-' : list.lsirc}"/></td>
				
				<td style="padding:0 0 0 0;">
				<c:choose>
					<c:when test="${empty list.confrName && !empty sessionScope.loginVO.chrgrNo}">
					<input class="btn_s" type="button" value="확인(사인)" onclick="event.stopPropagation(); updateConfrSign('<c:out value="${list.inspDate}"/>','<c:out value="${list.securInspLoacatCd}"/>','<c:out value="${status.count}"/>'); return false;" id="btnUserSign${status.count }" />
					</c:when>
					
					<c:otherwise>
					<c:out value="${empty list.strUserSign ? '-' : list.strUserSign}" escapeXml="false"/>
					</c:otherwise>
				</c:choose>
				<div id="userSignArea${status.count }"></div>
				</td>
							
			</tr> 
		</c:forEach>
		</tbody>
	</table>
	</div>
	</form>
</div>

</body>
</html>