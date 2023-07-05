<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : ChargerNoSearchNew.jsp
  * @Description : 담당자 조회 화면
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.05.04   이태신               최초 생성
  * 
  *
  *  @author 이태신
  *  @since 2022.05.04
  *  @version 1.0
  *  @see
  *
  */
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>담당자 목록</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<script language="javascript1.2" type="text/javaScript">
<!--
/* ********************************************************
 * 모두선택 처리 함수
 ******************************************************** */
function fCheckAll() {
    var checkField = document.chargerMngForm.checkField;
    if(document.chargerMngForm.checkAll.checked) {
        if(checkField) {
            if(checkField.length > 1) {
                for(var i=0; i < checkField.length; i++) {
                    checkField[i].checked = true;
                }
            } else {
                checkField.checked = true;
            }
        }
    } else {
        if(checkField) {
            if(checkField.length > 1) {
                for(var j=0; j < checkField.length; j++) {
                    checkField[j].checked = false;
                }
            } else {
                checkField.checked = false;
            }
        }
    }
}



/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
	document.chargerMngForm.pageIndex.value = pageNo;
	document.chargerMngForm.action = "<c:url value='/sys/chr/ChargerMngListPopup.do'/>";
   	document.chargerMngForm.submit();
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectChargerMng() {
	document.chargerMngForm.pageIndex.value = 1;
	document.chargerMngForm.action = "<c:url value='/sys/chr/ChargerMngListPopup.do'/>";
	document.chargerMngForm.submit();
}
/* ********************************************************
 * 입력 화면 호출 함수
 ******************************************************** */
function insertChargerMngList() {
   	document.chargerMngForm.action = "<c:url value='/sys/chr/ChargerMngListPopup.do'/>";
   	document.chargerMngForm.submit();
}
/* ********************************************************
 * 상세조회처리 함수
 ******************************************************** */
function selectChargerMngListDetail(chrgrNo) {
	document.chargerMngForm.chrgrNo.value = chrgrNo;
   	document.chargerMngForm.action = "<c:url value='/sys/chr/ChargerMngListPopup.do'/>";
   	document.chargerMngForm.submit();
}
/* ********************************************************
 * focus 시작점 지정함수
 ******************************************************** */
 function fn_FocusStart(){
		var objFocus = document.getElementById('F1');
		objFocus.focus();
	}

 function getChargerNo(vChrgrNo, vChrgrNm) {
		var parentFrom = parent.document.getElementsByTagName('form');
		parentFrom[0].chargerNo.value = vChrgrNo;
		parentFrom[0].chrgrNm.value = vChrgrNm;
	    parent.$('.ui-dialog-content').dialog('close');
	}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
-->


</script>
<script type="text/javascript">
    $(document).ready(function () {
    	
	});
</script>

</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>


	<form name="chargerMngForm" action ="<c:url value='/sys/chr/ChargerMngListPopup.do' />" method="post">
	<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
	<input type="hidden" name="checkedValueForDel" />	
	<div class="popup">
	<h1>담당자명 목록</h1>
	<div class="pop_search_box" title="담당자명">
		<ul>
			<li>
				<select name="searchCondition" title="검색조건">
					<option value="1" <c:if test="${searchVO.searchCondition eq '1'}">selected</c:if>>담당자명</option>
					<option value="2" <c:if test="${searchVO.searchCondition eq '2'}">selected</c:if>>회사명</option>
				</select>
			</li>
			<li>
				<div style="line-height:4px;">&nbsp;</div><div>검색어 : </div></li><!-- 검색어 -->
			<li>
				<input id="F1" class="s_input2 vat" name="searchKeyword" type="text" value="<c:out value='${searchVO.searchKeyword}'/>" size="25" maxlength="25" onkeypress="press();" title="<spring:message code="title.searchCondition" />" /><!-- 검색조건 -->
				<input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectChargerMng(); return false;" /><!-- 조회 -->
			</li>
		</ul>
	</div>

	<table class="pop_board_list">
		<caption></caption>
		<colgroup>
			<col style="width: 33%;">
			<col style="width: 34%;">
			<col style="width: 33%;">
		</colgroup>
		<thead>
			<tr>
			   <th class="board_th_link">담당자명</th>
			   <th>담당자 회사</th>
			   <th>담당자 부서</th>
			</tr>
		</thead>
		<tbody class="ov">
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			 <c:if test="${fn:length(resultList) == 0}">
			 <tr>
			 <td colspan="3">
				<spring:message code="common.nodata.msg" />
			 </td>
			 </tr>
			 </c:if>
			 
			 <c:forEach var="result" items="${resultList}" varStatus="status">
			  <tr onclick="getChargerNo('<c:out value="${result.chrgrNo}"/>','<c:out value="${result.chrgrNm}"/>'); return false;">
			    <td class="lt_text" nowrap="nowrap">
		            <c:out value="${result.chrgrNm}"/>
			    </td>
			    <td class="lt_text" nowrap="nowrap">
		            <c:out value="${result.positCmpnyNm}"/>
			    </td>
			    <td class="lt_text" nowrap="nowrap">
		            <c:out value="${result.positDeptNm}"/>
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
	
	</form>

</div>

</body>
</html>