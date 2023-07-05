<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
	/**
* @Class Name : PartnersMngList.jsp
* @Description : 협력 업체 조회 화면
* @Modification Information
* @
* @  수정일             수정자             수정내용
* @ ----------   --------   ---------------------------
* @ 2022.06.29   조경민               최초 생성
*
*  @author 조경민
*  @since 2022.06.29
*  @version 1.0
*  @see
*
*/
%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>협력업체 담당자관리 목록</title>
<link href="<c:url value="/css/egovframework/com/com.css"/> " rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/> " rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<script type="text/javascript">
	
	
	function fCheckAll() {
	    const checkField = document.getElementsByName('checkField');
	    if(event.target.checked == true) {
	        for (let i = 0; i < checkField.length; i++){
	        	checkField[i].checked = true;
	        }
	    } else {
	    	for (let i = 0; i < checkField.length; i++){
	        	checkField[i].checked = false	;
	        }
	    }
	}
	
	function fn_DeletePartnersMngList() {
	    var checkField = document.partnersMngForm.checkField;
	    var chargerNo = document.partnersMngForm.checkChargerNo;
	    var checkChargerNos = "";
	    var checkedCount = 0;
	    if(checkField) {
	    	if(checkField.length > 1) {
	            for(var i=0; i < checkField.length; i++) {
	                if(checkField[i].checked) {
	                    checkChargerNos += ((checkedCount==0? "" : ",") + chargerNo[i].value);
	                    checkedCount++;
	                }
	            }
	        } else {
	            if(checkField.checked) {
	            	checkChargerNos = chargerNo.value;
	            }
	        }
	    }

	    if(checkedCount ==0){
			alert("선택된 담당자가 없습니다.");
			return false;
	    }

	    if(confirm("<spring:message code="common.delete.msg" />")){	//삭제하시겠습니까?
		    document.partnersMngForm.checkedValueForDel.value=checkChargerNos;
			document.partnersMngForm.action = "<c:url value='/sys/ptn/deletePartnersMngList.do'/>";
			document.partnersMngForm.submit();
		}
	}
	
	// page
	function linkPage(pageNo){
		document.partnersMngForm.pageIndex.value = pageNo;
		document.partnersMngForm.action = "<c:url value='/sys/ptn/PartnersMngList.do'/>";
	   	document.partnersMngForm.submit();
	}	
	// 수정
	function selectPartnersMngListDetail(chrgrNo) {
		document.partnersMngForm.chrgrNo.value = chrgrNo;
	   	document.partnersMngForm.action = "<c:url value='/sys/ptn/PartnersMngUpdt.do'/>";
	   	document.partnersMngForm.submit();
	}
	
	// 등록
	function insertPartnersMngList() {
		document.partnersMngForm.action = "<c:url value='/sys/ptn/PartnersMngRegist.do'/>";
	   	document.partnersMngForm.submit();
	}
	
	// 조회
	function selectPartnersMng() {
		document.partnersMngForm.pageIndex.value = 1;
		document.partnersMngForm.action = "<c:url value='/sys/ptn/PartnersMngList.do'/>";
		document.partnersMngForm.submit();
	}
	
	// 검색창으로 포커스 이동
	window.onload = function(){
		document.getElementById('F1').focus();
	}
	
</script>

</head>
<body>

	<noscript class="noScriptTitle">
		<spring:message code="common.noScriptTitle.msg" />
	</noscript>


	<div class="board">
		<h1>협력업체 담당자관리 목록</h1>
		<form name="partnersMngForm" action="<c:url value='/sys/ptn/PartnersMngList.do'/>" method="POST">
			<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>" /> 
			<input type="hidden" name="checkedValueForDel" />
			<input type="hidden" name="chrgrNo">
		
	<div class="search_box" title="담당자명">
		<ul>
			<li style="padding-right:2%;">
				<label for="">검색조건 : </label>
				<input style="vertical-align: middle;" checked="checked" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '1'}">checked="checked"</c:if> value="1">담당자명</input>
				<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '2'}">checked="checked"</c:if> value="2">회사명</input>
			</li>
			<li>
				<label for="">검색어 : </label>
				<input id="F1" class="s_input2 vat" name="searchKeyword" type="text" value="<c:out value='${searchVO.searchKeyword}'/>" size="60" maxlength="60" onkeypress="press();" title="<spring:message code="title.searchCondition" />" /><!-- 검색조건 -->
				
				<input class="s_btn" type="submit" value='<spring:message code="button.inquire" />' title='<spring:message code="button.inquire" />' onclick="selectPartnersMng(); return false;" /><!-- 조회 -->
				<span class="btn_b"><a href="#LINK" onclick="insertPartnersMngList(); return false;" title='<spring:message code="button.create" />'><spring:message code="button.create" /></a></span><!-- 등록 -->
				<!-- 관리자만 출력 -->
				<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN'}">
					<span class="btn_b"><a href="#LINK" onclick="fn_DeletePartnersMngList(); return false;" title='<spring:message code="button.delete" />'><spring:message code="button.delete" /></a></span><!-- 삭제 -->
				</c:if>
			</li>
		</ul>
	</div>

			<table class="board_list">
				<colgroup>
					<col style="width: 20px" />
					<col style="" />
					<col style="width: 10%" />
					<col style="width: 15%" />
					<col style="width: 15%" />
					<col style="width: 20%" />
					<col style="width: 20%" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col"><input type="checkbox" name="checkAll" class="check2" onclick="fCheckAll();" title="전체선택" /></th>
						<th scope="col">담당자명</th>
						<th scope="col">직급</th>
						<th scope="col">유선전화</th>
						<th scope="col">무선전화</th>
						<th scope="col">담당자회사</th>
						<th scope="col">담당자부서</th>
					</tr>
				</thead>
				<tbody class="ov">
					<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
					<c:if test="${fn:length(partnersList) == 0}">
						<tr>
							<td colspan="7"><spring:message code="common.nodata.msg" />
							</td>
						</tr>
					</c:if>

					<c:forEach var="list" items="${partnersList}" varStatus="status">
						<tr
							onclick="selectPartnersMngListDetail('<c:out value="${list.chrgrNo}"/>'); return false;">
							<td onclick="event.cancelBubble=true">
								<input type="checkbox" name="checkField" class="check2" title="선택"> 
								<input name="checkChargerNo" type="hidden" value="<c:out value='${list.chrgrNo}'/>" />
							</td>
							<td><c:out value="${list.chrgrNm}" /></td>
							<td><c:out value="${list.clspos}" /></td>
							<td><c:out value="${list.chrgrWirelnTelNo}" /></td>
							<td><c:out value="${list.chrgrWirelsTelNo}" /></td>
							<td><c:out value="${list.positCmpnyNm}" /></td>
							<td><c:out value="${list.positDeptNm}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<!-- paging navigation -->
			<div class="pagination">
				<ul>
					<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage" />
				</ul>
			</div>
			
		</form>
	</div>
	
</body>
</html>