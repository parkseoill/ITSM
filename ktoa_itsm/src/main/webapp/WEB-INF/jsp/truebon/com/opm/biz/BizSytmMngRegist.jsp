<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--
 /**
  * @Class Name : BizSytmMngRegist.jsp
  * @Description : 업무시스템 등록 화면
  * @Modification Information
  * @
  * @ 수정일               수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.07.26   이유리            최초 생성
  *
  *  @author 이유리
  *  @since 2022.07.26
  *  @version 1.0
  *  @see
  *
  */
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<c:set var="ImgUrl" value="${pageContext.request.contextPath}/images/egovframework/com/sym/mnu/mpm/"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>업무시스템 등록</title>

<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">

<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<!-- validator 클라이언트 -->
<script type="text/javascript" src="<c:url value="/validator.do" />"></script>
<validator:javascript formName="bizSytmVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script language="javascript1.2" type="text/javaScript">

<!-- 


/* ********************************************************
 * 상위 시스템 코드 호출 함수
 ******************************************************** */
 
 $(document).ready(function () {
	 $('#selectUpprBizSytmCd').click(function (e) {
		 var sysCd = $('#bizSytmCd').val();
		 if(sysCd.length == 3){
			alert("최상위 시스템 코드입니다.");
			$('#upprBizSytmCd').val("");
		 }else if((sysCd.length - 3) % 2 == 0){
			 $('#upprBizSytmCd').val(sysCd.substring(0,sysCd.length - 2));
		 }else{
			alert("시스템 코드의 형식이 맞지 않습니다.");
			$('#upprBizSytmCd').val("");
		}
	 });
	 
	 $('#bizSytmCd').change(function(){
		 $('#upprBizSytmCd').val("");
	 });
 });


/* ********************************************************
 * 입력처리 함수
 ******************************************************** */
 
function insertBizSytmMng() {
	
	var objForm = document.getElementById("bizSytmMngForm");
	
	if(confirm("<spring:message code="common.save.msg" />")){
		if(!validateBizSytmVO(objForm)){
			return;
		}else{
			objForm.submit();
		}
	}
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
 
function selectList() {
	location.href = "<c:url value='/opm/biz/BizSytmMngList.do'/>";
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
-->
</script>
</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript><!-- 자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다. -->

<form:form commandName="bizSytmVO" id="bizSytmMngForm" name="bizSytmMngForm" method="post" action="${pageContext.request.contextPath}/opm/biz/insertBizSytmMngRegist.do">
	<!-- 검색조건 유지 -->
    <input type="hidden" name="searchCondition" value="<c:out value='${bizSytmVO.searchCondition}'/>"/>
    <input type="hidden" name="searchKeyword" value="<c:out value='${bizSytmVO.searchKeyword}'/>"/>
    <input type="hidden" name="pageIndex" value="<c:out value='${bizSytmVO.pageIndex}' default='1' />"/>
	
	<div class="wTableFrm">
		<!-- 타이틀 -->
		<h2>업무시스템 등록</h2>
		
		<!-- 등록폼 -->
		<table class="wTable">
		<colgroup>
			<col style="width:15%" />
			<col style="width:35%" />
			<col style="width:15%" />
			<col style="" />
		</colgroup>
		<tr>
			<th>시스템코드<span class="pilsu">*</span></th>
			<td class="left">
			    <form:input id="bizSytmCd" path="bizSytmCd" maxlength="30" title="시스템코드" cssStyle="width:150px" />
      			<div><form:errors path="bizSytmCd" cssClass="error" /></div>
      			<label>대분류 코드: 5자리 (예시: SYS01), 중분류 코드: 7자리 (예시: SYS0101)</label>
			</td>
			<th>시스템명<span class="pilsu">*</span></th>
			<td class="left">
			    <form:input path="bizSytmNm" maxlength="100" title="시스템명" cssStyle="width:150px" />
      			<div><form:errors path="bizSytmNm" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>시스템코드 레벨 <span class="pilsu">*</span></th>
			<td class="left">
			    <form:input path="bizSytmCdLvl" maxlength="1" title="시스템코드 레벨" cssStyle="width:150px" />
      			<div><form:errors path="bizSytmCdLvl" cssClass="error" /></div>
			</td>
			<th>상위 시스템 코드</th>
		 	<td class="left">
			    <form:input id="upprBizSytmCd" path="upprBizSytmCd" title="상위 시스템 코드" readonly="true" class="readOnlyClass" cssStyle="width:150px"/>
	      		<a id="selectUpprBizSytmCd" href="#"><img src="<c:url value='/images/egovframework/com/cmm/icon/search2.gif' />" alt='' /> (코드 불러오기)</a>
				<div><form:errors path="upprBizSytmCd" cssClass="error" /></div>
			</td> 
		</tr>
		<tr>
			<th>우선순위<span class="pilsu">*</span></th>
			<td class="left">
			    <form:input path="frstRank" maxlength="2" title="우선순위" cssStyle="width:150px" />
      			<div><form:errors path="frstRank" cssClass="error" /></div>
			</td>
			<th>사용여부<span class="pilsu">*</span></th>
			<td class="left">
				<form:select path="useYn" title="사용여부" cssClass="txt" cssStyle="width:150px">
					<form:option value="Y"  label="Y"/>
					<form:option value="N"  label="N"/>
				</form:select>
				<div><form:errors path="useYn" cssClass="error" /></div>       
			</td>
		</tr>
		</table>
		<!-- 하단 버튼 -->
		<div class="btn">
			<input class="s_submit" type="submit" value='<spring:message code="button.create" />' onclick="insertBizSytmMng(); return false;" /><!-- 등록 -->
			<span class="btn_s"><a href="#LINK'/>" onclick="selectList(); return false;"><spring:message code="button.list"/></a></span><!-- 목록 -->
		</div>
		<div style="clear:both;"></div>
	</div>
</form:form>
</body>
</html>