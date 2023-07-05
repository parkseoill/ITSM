<!DOCTYPE html>
<%--
 /**
  * @Class Name : ComnDateMngUpdt.jsp
  * @Description : 담당자 수정 화면
  * @Modification Information
  * @
  * @ 수정일               수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.05.24   이유리            최초 생성
  *
  *  @author 이유리
  *  @since 2022.05.24
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
<title>공통일자관리 수정</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<!-- validator 클라이언트 -->
<script type="text/javascript" src="<c:url value="/validator.do" />"></script>
<validator:javascript formName="comnDateVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script language="javascript1.2" type="text/javaScript">
<!--
/* ********************************************************
 * 수정처리 함수
 ******************************************************** */
function updateComnDateMng() {
	var objForm = document.getElementById("comnDateMngForm");
	
	if(confirm("<spring:message code="common.save.msg" />")){
		if(!validateComnDateVO(form)){
			return;
		}else{
			objForm.submit();
		}
	}
}

/* ********************************************************
 * 목록조회  함수
 ******************************************************** */
function selectList(){
	var objForm = document.getElementById("comnDateMngForm");
	objForm.action = "<c:url value='/dlm/cod/ComnDateMngList.do' />";
	objForm.submit();
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
-->
</script>
</head>
<body>

<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript><!-- 자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다. -->

<form:form commandName="comnDateVO" id="comnDateMngForm" name="comnDateMngForm" method="post" action="${pageContext.request.contextPath}/dlm/cod/updateComnDateMngUpdt.do">
	<!-- 검색조건 유지 -->
    <input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
    <input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
    <input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}' default='1' />"/>
<div class="wTableFrm">
	<!-- 타이틀 -->
	<h2>공통일자 수정</h2>

	<!-- 등록폼 -->
	<table class="wTable">
		<colgroup>
			<col style="width: 22%;"><col style="width: ;">
		</colgroup>
		<tr>
			<th>기준일자 <span class="pilsu">*</span></th>
			<td class="left">
			    <form:input type="text" id="stdrDatePicker" path="stdrDate" maxlength="20" title="기준일자" readonly="true" class="readOnlyClass"/>
      			<form:errors path="stdrDate" />
			</td>
		</tr>
		<tr>
			<th>요일 <span class="pilsu">*</span></th>
			<td class="left">
				<c:if test="${searchVO.dyweekDstnctCd eq '1'}">일요일</c:if>
				<c:if test="${searchVO.dyweekDstnctCd eq '2'}">월요일</c:if>
				<c:if test="${searchVO.dyweekDstnctCd eq '3'}">화요일</c:if>
				<c:if test="${searchVO.dyweekDstnctCd eq '4'}">수요일</c:if>
				<c:if test="${searchVO.dyweekDstnctCd eq '5'}">목요일</c:if>
				<c:if test="${searchVO.dyweekDstnctCd eq '6'}">금요일</c:if>
				<c:if test="${searchVO.dyweekDstnctCd eq '7'}">토요일</c:if>
				<form:input type="hidden" id="dyweekDstnctCd" path="dyweekDstnctCd" />
				<div><form:errors path="dyweekDstnctCd" cssClass="error" /></div>       
			</td>
		</tr>
		<tr>
			<th>공휴일 구분 <span class="pilsu">*</span></th>
			<td class="left">
				<form:select path="hdayDstnctCd" title="공휴일구분코드" cssClass="txt">
					<form:option value="1"  label="일반"/>
					<form:option value="2" label="공휴일"/>
				</form:select>
				<div><form:errors path="hdayDstnctCd" cssClass="error" /></div>       
			</td>
		</tr>
		<tr>
			<th>공휴일명</th>
			<td class="left">
			    <form:input path="hdayNm" maxlength="70"  title="공휴일명" size="70" />
				<form:errors path="hdayNm" />
			</td>
		</tr>
	</table>

	<!-- 하단 버튼 -->
	<div class="btn">
		<input class="s_submit" type="submit" value='<spring:message code="button.update" />' onclick="updateComnDateMng(); return false;" /><!-- 수정 -->
		<span class="btn_s"><a href="#LINK" onclick="selectList(); return false;"><spring:message code="button.list"/></a></span><!-- 목록 -->
	</div>
	<div style="clear:both;"></div>
	
	<!-- 임시 담당자 구분 코드  -->
<%-- 	<input type="hidden" name="chrgrDstnctCd" value="<c:out value="${chargerVO.chrgrDstnctCd}"/>"> --%>
</div>

</form:form>

</body>
</html>