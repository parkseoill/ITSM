<%
 /**
  * @Class Name : EgovCcmCmmnClCodeDetail.jsp
  * @Description : 공통분류코드 상세조회 화면
  * @Modification Information
  * @
  * @  수정일             수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2009.02.01   박정규              최초 생성
  *   2017.08.03   이정은              표준프레임워크 v3.7 개선
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
<c:set var="pageTitle"><spring:message code="comSymCcmCcc.cmmnClCodeVO.title"/></c:set>
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
 function fn_egov_delete_code(comnCdId){
	if(confirm("<spring:message code="common.delete.msg" />")){	
		// Delete하기 위한 키값을 셋팅
		document.CcmClCodeForm.comnCdId.value = comnCdId;	
		document.CcmClCodeForm.action = "<c:url value='/sym/ccm/ccc/RemoveCcmCmmnClCode.do'/>";
		document.CcmClCodeForm.submit();
	}	
}	

 /* ********************************************************
  * 목록조회  함수
  ******************************************************** */
 function selectList(){
 	var objForm = document.getElementById("CcmClCodeForm");
 	objForm.action = "<c:url value='/sym/ccm/ccc/SelectCcmCmmnClCodeList.do' />";
 	objForm.submit();
 }
</script>
</head>
<body>

<form name="CcmClCodeForm" id="CcmClCodeForm" action="<c:url value='/sym/ccm/ccc/UpdateCcmCmmnClCodeView.do'/>" method="post">
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
			<th><spring:message code="comSymCcmCcc.cmmnClCodeVO.comnCdId" /></th>
			<td class="left"><c:out value="${result.comnCdId}"/></td>
		</tr>
		<!-- 공통코드ID명 -->
		<tr>
			<th><spring:message code="comSymCcmCcc.cmmnClCodeVO.comnCdIdNm" /></th>
			<td class="left"><c:out value="${result.comnCdIdNm}"/></td>
		</tr>
		<!-- 공통코드ID설명 -->
		<tr>
			<th ><spring:message code="comSymCcmCcc.cmmnClCodeVO.comnCdIdDc" /></th>
			<td class="cnt">
				<c:out value="${fn:replace(result.comnCdIdDc , crlf , '<br/>')}" escapeXml="false" />
			</td>
		</tr>
		<!-- 사용여부 -->
		<tr>
			<th><spring:message code="comSymCcmCcc.cmmnClCodeVO.useYn" /></th>
			<td class="left"><c:out value="${result.useYn}"/></td>
		</tr>
		
		
	</tbody>
	</table>
	<!-- 하단 버튼 -->
	<div class="btn">
		<input type="submit" class="s_submit" value="<spring:message code="button.update" />" title="<spring:message code="title.update" /> <spring:message code="input.button" />" />
		<span class="btn_s"><a href="<c:url value='/sym/ccm/ccc/RemoveCcmCmmnClCode.do?comnCdId=${result.comnCdId}' />" onClick="fn_egov_delete_code('<c:out value="${result.comnCdId}"/>'); return false;" title="<spring:message code="title.delete" /> <spring:message code="input.button" />"><spring:message code="button.delete" /></a></span>
		<span class="btn_s"><a href="#LINK'/>" onclick="selectList(); return false;"><spring:message code="button.list"/></a></span><!-- 목록 -->
	</div><div style="clear:both;"></div>
	
</div>

<input name="comnCdId" type="hidden" value="<c:out value="${result.comnCdId}" />">
<input name="searchCondition" type="hidden" value="<c:out value="${searchVO.searchCondition}" />">
<input name="searchKeyword" type="hidden" value="<c:out value="${searchVO.searchKeyword}" />">
<input name="pageIndex" type="hidden" value="<c:out value="${searchVO.pageIndex}" />">
</form>

</body>
</html>
