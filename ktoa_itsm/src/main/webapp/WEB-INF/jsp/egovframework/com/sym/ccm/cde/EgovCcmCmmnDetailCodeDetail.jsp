<%
 /**
  * @Class Name : EgovCcmCmmnDetailCodeDetail.jsp
  * @Description : 공통상세코드 상세조회 화면
  * @Modification Information
  * @
  * @  수정일             수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2009.02.01   박정규              최초 생성
  *   2017.08.09   이정은              표준프레임워크 v3.7 개선
  *  @author 공통서비스팀 
  *  @since 2009.02.01
  *  @version 1.0
  *  @see
  *  
  */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%pageContext.setAttribute("crlf", "\r\n"); %>
<c:set var="pageTitle"><spring:message code="comSymCcmCde.cmmnDetailCodeVO.title"/></c:set>
<!DOCTYPE html>
<html>
<head>
<title>${pageTitle} <spring:message code="title.detail" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<script type="text/javascript">
/* ********************************************************
 * 삭제처리
 ******************************************************** */
 function fn_egov_delete_code(comnCdId, comnCd){
	if(confirm("<spring:message code="common.delete.msg" />")){	
		// Delete하기 위한 키값을 셋팅
		document.CcmDeCodeForm.comnCdId.value = comnCdId;
		document.CcmDeCodeForm.comnCd.value = comnCd;	
		document.CcmDeCodeForm.action = "<c:url value='/sym/ccm/cde/RemoveCcmCmmnDetailCode.do'/>";
		document.CcmDeCodeForm.submit();
	}	
}	

 /* ********************************************************
  * 목록조회  함수
  ******************************************************** */
 function selectList(){
 	var objForm = document.getElementById("CcmDeCodeForm");
 	objForm.action = "<c:url value='/sym/ccm/cde/SelectCcmCmmnDetailCodeList.do' />";
 	objForm.submit();
 }
</script>
</head>
<body>

<form name="CcmDeCodeForm" id="CcmDeCodeForm" action="<c:url value='/sym/ccm/cde/UpdateCcmCmmnDetailCodeView.do'/>" method="post">
<div class="wTableFrm">
	<!-- 타이틀 -->
	<h2>${pageTitle} <spring:message code="title.detail" /></h2>

	<!-- 상세조회 -->
	<table class="wTable" summary="<spring:message code="common.summary.inqire" arguments="${pageTitle}" />">
	<caption>${pageTitle} <spring:message code="title.detail" /></caption>
	<colgroup>
		<col style="width: 20%;">
		<col style="width: ;">
	</colgroup>
	<tbody>
		<!-- 공통코드ID -->
		<tr>
			<th><spring:message code="comSymCcmCde.cmmnDetailCodeVO.comnCdId" /></th>
			<td class="left"><c:out value="${result.comnCdId}"/></td>
		</tr>
		<!-- 상세 공통코드 -->
		<tr>
			<th><spring:message code="comSymCcmCde.cmmnDetailCodeVO.comnCd" /></th>
			<td class="left"><c:out value="${result.comnCd}"/></td>
		</tr>
		<!-- 상세 공통코드명 -->
		<tr>
			<th><spring:message code="comSymCcmCde.cmmnDetailCodeVO.comnCdNm" /></th>
			<td class="left"><c:out value="${result.comnCdNm}"/></td>
		</tr>
		<!-- 상세코드설명 -->
		<tr>
			<th><spring:message code="comSymCcmCde.cmmnDetailCodeVO.comnCdDc" /></th>
			<td class="cnt">
				<c:out value="${fn:replace(result.comnCdDc , crlf , '<br/>')}" escapeXml="false" />
			</td>
		</tr>
		<!-- 사용여부 -->
		<tr>
			<th><spring:message code="comSymCcmCde.cmmnDetailCodeVO.useYn" /></th>
			<td class="left"><c:out value="${result.useYn}"/></td>
		</tr>
		<!-- 정렬순서 -->
		<tr>
			<th>정렬순서</th>
			<td class="left"><c:out value="${result.sortOrde}"/></td>
		</tr>
		
	</tbody>
	</table>
	<!-- 하단 버튼 -->
	<div class="btn">
		<input type="submit" class="s_submit" value="<spring:message code="button.update" />" title="<spring:message code="title.update" /> <spring:message code="input.button" />" />
		<span class="btn_s"><a href="<c:url value='/sym/ccm/cde/RemoveCcmCmmnDetailCode.do?comnCdId=${result.comnCdId}&amp;code=${result.comnCd}' />" onClick="fn_egov_delete_code('<c:out value="${result.comnCdId}"/>','<c:out value="${result.comnCd}"/>'); return false;" title="<spring:message code="title.delete" /> <spring:message code="input.button" />"><spring:message code="button.delete" /></a></span>
		<span class="btn_s"><a href="#LINK'/>" onclick="selectList(); return false;"><spring:message code="button.list"/></a></span><!-- 목록 -->
	</div><div style="clear:both;"></div>
	
</div>

<input name="comnCdId" type="hidden" value="<c:out value="${result.comnCdId}" />">
<input name="comnCd" type="hidden" value="<c:out value="${result.comnCd}" />">
<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>">
<input name="searchCondition" type="hidden" value="<c:out value='${searchVO.searchCondition}'/>">
<input name="searchKeyword" type="hidden" value="<c:out value='${searchVO.searchKeyword}'/>">
</form>

</body>
</html>
