<%
 /**
  * @Class Name : EgovGroupSearch.java
  * @Description : EgovGroupSearch Search 화면
  * @Modification Information
  * @
  * @  수정일                     수정자               수정내용
  * @ ----------    --------    ---------------------------
  * @ 2009.03.23    lee.m.j     최초 생성
  *   2016.07.06    장동한          표준프레임워크 v3.6 개선
  *
  *  @author lee.m.j
  *  @since 2009.03.23
  *  @version 1.0
  *  @see
  *
  */
%>
<%
 /**
  * @Class Name : EgovFileNmSearch.jsp
  * @Description : 프로그램파일명 검색 화면
  * @Modification Information
  * @
  * @  수정일         수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2009.03.10    이용          최초 생성
  *   2011.10.18    서준식       프로그램파일명 검색 결과를 부모창으로 넘겨주는 자바스크립트 수정(브라우저 호환성 문제로 수정함)
  
  *  @author 공통서비스 개발팀 이용
  *  @since 2009.03.10
  *  @version 1.0
  *  @see
  *
  */
  /* Image Path 설정 */
  String imagePath_icon   = "/images/egovframework/com/sym/prm/icon/";
  String imagePath_button = "/images/egovframework/com/sym/prm/button/";
%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="pageTitle"><spring:message code="comCopSecGmt.groupPopup.title"/></c:set>
<!DOCTYPE html>

<html>
<head>
<title>회사목록</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery-1.4.2.min.js' />" ></script>
<script type="text/javaScript" language="javascript1.2"">

function fncManageChecked() {

//    var checkField = document.listForm.delYn;
    var checkId = document.listForm.checkId;
    var returnValue = "";
    var checkCount = 0;
    var returnBoolean = false;

/*     if(checkField) {
        if(checkField.length > 1) {
            for(var i=0; i<checkField.length; i++) {
                if(checkField[i].checked) {
                	checkCount++;
                    checkField[i].value = checkId[i].value;
                    returnValue = checkField[i].value;
                }
            }

            if(checkCount > 1) {
                alert("<spring:message code="comCopSecGmt.validate.groupOneSelect"/>");
                return;
            } else if(checkCount < 1) {
                alert("<spring:message code="comCopSecGmt.validate.groupSelect"/>");
                return;
            }
        } else {
        	if(checkField.checked == true) {
        		returnValue = checkId.value;
        	} else {
                alert("<spring:message code="comCopSecGmt.validate.groupSelect"/>");
                return;
            }
        }

        returnBoolean = true;

    } else {
    	alert("<spring:message code="comCopSecGmt.validate.groupSelectResult"/>");
    }

    document.listForm.cmpnyNo.value = returnValue;

    return returnBoolean;
*/
} // end fncManageChecked

function fncSelectGroupList(pageNo){
    document.listForm.searchCondition.value = "1";
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/sec/gmt/EgovGroupSearchList.do'/>";
    document.listForm.submit();
}

function fncSelectGroup(cmpnyNo) {
    window.returnValue = cmpnyNo;
    opener.listForm.searchKeyword.value = cmpnyNo;
    window.close();
}

function fncSelectGroupConfirm() {
	if(fncManageChecked()) {
		opener.listForm.searchKeyword.value = document.listForm.cmpnyNo.value;
        window.returnValue = document.listForm.cmpnyNo.value;
		window.close();
	}
}

function linkPage(pageNo){
    document.listForm.searchCondition.value = "1";
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/sec/gmt/EgovGroupSearchList.do'/>";
    document.listForm.submit();
}

function press() {

    if (event.keyCode==13) {
    	fncSelectGroupList('1');
    }
}
function choisGroupSearch(vCmpnyNo,vCmpnyNm) {
/* 	// eval("opener.document.all."+opener.document.all.tmp_SearchElementName.value).value = vCmpnyNo;
	// opener.document.groupVO.cmpnyNo.value = vCmpnyNo;
	var parentFrom = parent.parent.parent.parent.document.getElementsByTagName('form');
	var test = $(parent.document).find("#deptManage");
	alert(test.cmpnyNo);
	
	parentFrom[0].cmpnyNo.value = vCmpnyNo;
	alert(parentFrom[0].cmpnyNo.value);
    // window.close();
	parent.$('.ui-dialog-content').dialog('close'); */
	//eval("opener.document.all."+opener.document.all.tmp_SearchElementName.value).value = vFileNm;
	//opener.document.menuManageVO.progrmFileNm.value = vFileNm;

	var parentFrom = parent.document.getElementsByTagName('form');
	parentFrom[0].cmpnyNo.value = vCmpnyNo;
	parentFrom[0].cmpnyNm.value = vCmpnyNm;
    parent.$('.ui-dialog-content').dialog('close');
}
</script>

</head>

<body>
<DIV id="main" style="display:">

<!-- javascript warning tag  -->
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>
<form name="listForm" action ="<c:url value='/sec/gmt/EgovGroupSearchList.do'/>" method="post">
<div class="popup">
	<h1>회사 목록</h1>
	<!-- 검색영역 -->
	<div class="pop_search_box" title="<spring:message code="common.searchCondition.msg" />">
		<ul>
			<li><div style="line-height:4px;">&nbsp;</div><div>그룹명 : </div></li><!-- 그룹명 -->
			<!-- 검색키워드 및 조회버튼 -->
			<li>
				<input class="s_input" name="searchKeyword" type="text"  size="35" title="<spring:message code="title.search" /> <spring:message code="input.input" />" value='<c:out value="${groupManageVO.searchKeyword}"/>'  maxlength="155" >
				<input type="submit" class="s_btn" value="<spring:message code="button.inquire" />" title="<spring:message code="title.inquire" /> <spring:message code="input.button" />" /><!-- 조회 -->
			</li>
		</ul>
	</div>
	
	<!-- 목록영역 -->
	<table class="pop_board_list" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
	<caption>${pageTitle} <spring:message code="title.list" /></caption>
		<colgroup>
			<col style="width: 50%;">
			<col style="width: 50%;">
		</colgroup>
	<thead>
	<tr>
<!-- 		<th></th>선택 -->
		<th class="board_th_link">회사 번호</th><!-- 회사 번호 -->
		<th>회사 명</th><!-- 회사 명 -->
	</tr>
	</thead>
	<tbody class="ov">
	<c:if test="${fn:length(groupList) == 0}">
	<tr>
		<td colspan="6"><spring:message code="common.nodata.msg" /></td>
	</tr>
	</c:if>
	<c:forEach var="group" items="${groupList}" varStatus="status">
	<tr onClick="choisGroupSearch('<c:out value="${group.cmpnyNo}"/>','<c:out value="${group.cmpnyNm}"/>'); return false;">
		<td class="lt_text" nowrap="nowrap"><c:out value="${group.cmpnyNo}"/></td>
		<td class="lt_text" nowrap="nowrap"><c:out value="${group.cmpnyNm}"/></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	
	<c:if test="${!empty groupManageVO.pageIndex }">
		<!-- paging navigation -->
		<div class="pagination">
			<ul><ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage"/></ul>
		</div>
	</c:if>


</div><!-- end div board -->

<input type="hidden" name="cmpnyNo"/>
<input type="hidden" name="groupIds"/>
<input type="hidden" name="pageIndex" value="<c:out value='${groupManageVO.pageIndex}'/>"/>
<input type="hidden" name="searchCondition"/>
</form>

</DIV>
</body>
</html>
