<%
 /**
  * @Class Name : EgovCcmCmmnClCodeList.jsp
  * @Description : 공통분류코드 목록 화면
  * @Modification Information
  * @
  * @  수정일             수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2009.02.01   박정규              최초 생성
  *   2017.07.20   이정은              표준프레임워크 v3.7 개선
  *   2022.08.23   이유리              공통코드 공통상세코드 통합
  *  @author 공통서비스팀
  *  @since 2009.02.01
  *  @version 1.0
  *  @see
  *
  */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle"><spring:message code="comSymCcmCca.cmmnCodeVO.title"/></c:set>
<!DOCTYPE html>
<html>
<head>
<title>${pageTitle} <spring:message code="title.list" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<script type="text/javascript">
$(document).ready(function () {
	fn_FocusStart();
});

/*********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function fn_egov_select_linkPage(pageNo){
	document.CcmClCodeForm.pageIndex.value = pageNo;
	document.CcmClCodeForm.action = "<c:url value='/sym/ccm/ccc/SelectCcmCmmnClCodeList.do'/>";
   	document.CcmClCodeForm.submit();
}
/*********************************************************
 * 조회 처리 함수
 ******************************************************** */
function fn_egov_search_code(){
	document.CcmClCodeForm.pageIndex.value = 1;
	document.CcmClCodeForm.submit();
}

/* ********************************************************
 * focus 시작점 지정함수
 ******************************************************** */
function fn_FocusStart(){
	$('#F1').focus();
}

$(document).ready(function(){
	var getCdId = "<c:out value='${getCdId}'/>"; 
	function initSelCcc(){
		if(getCdId != ''){
			$('#ccmCccCdTb tbody tr').each(function(index,tr){
				if($(this).find('td:eq(1)').text() == getCdId){
					$(this).click();
				}
			});
			getCdId = '';
		}
	}
	
	var getCd = "<c:out value='${getCd}'/>"; 
	function initSelCde(){
		if(getCd != ''){
			$('#ccmCdeCdTb tbody tr').each(function(index,tr){
				if($(this).find('td:eq(1)').text() == getCd){
					$(this).click();
				}
			});
			getCd = '';
		}
	}
	
	$("#ccmCccCdTb tr:last").click(function(){
		$('#getCcmCccRegistJsp').load('/sym/ccm/ccc/RegistCcmCmmnClCodeView.do');
	});
	
	$("#ccmCccCdTb tbody tr:not(:last)").click(function(){
		$('tr').removeClass('highlight1');
		$(this).addClass('highlight1');
		var comnCdId = $(this).children().eq(1).text();
		var searchKeyword = $('#F1').val();
		var searchCondition = $('#searchCondition').val();
		$('#getCcmCccRegistJsp').load('/sym/ccm/ccc/UpdateCcmCmmnClCodeView.do?comnCdId='+comnCdId+'&searchCondition=' + searchCondition+ '&searchKeyword=' + searchKeyword);
		$.ajax({
			url: "<c:url value='/sym/ccm/cde/SelectCcmCmmnDetailCodeList.do'/>",
		    type: 'POST',
		    data:{
		    	"searchKeyword":comnCdId
		    },
		    dataType: 'json',
		    success: function (data){
		    	$('#ccmCdeCdTb > tbody').empty();
		    	var results = data.ccmCdeCdTb;
		    	var str = '<tr>';
		    	$.each(results, function(i){
		    		str += '<td>' + (i + 1) + '</td><td>'  + results[i].comnCd + '</td><td class=\"Elli\">' + results[i].comnCdNm + '</td>';
		    		str += '</tr>';
		    	});
		    	str += '<tr style="background-color:#f9f9f9;"><td colspan="3"><button type="button" >추가</button></td></tr>';
		    	$('#ccmCdeCdTb').append(str);
		    },
		    error: function(){
		    	alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.
		    },
		    complete: function (){
		    	$("#ccmCdeCdTb tbody tr:not(:last)").click(function(){
		    		$('tr').removeClass('highlight2');
					$(this).addClass('highlight2');
					var comnCd = $(this).children().eq(1).text();
					$('#getCcmCccRegistJsp').load('/sym/ccm/cde/UpdateCcmCmmnDetailCodeView.do?comnCdId='+comnCdId+'&comnCd='+comnCd+'&searchCondition=' + searchCondition+ '&searchKeyword=' + searchKeyword);
				}); 
		    	
		    	$('#ccmCdeCdTb tbody tr').each(function(index,tr){
		    		$(this).find('td:eq(2)').attr('title',$(this).find('td:eq(2)').text());
				});
		    	
		    	$("#ccmCdeCdTb tr:last").click(function(){
		    		$('#getCcmCccRegistJsp').load('/sym/ccm/cde/RegistCcmCmmnDetailCodeView.do?comnCdId='+comnCdId+'&searchCondition=' + searchCondition+ '&searchKeyword=' + searchKeyword);
				});
		    	initSelCde();
		    }
		});
	});
	initSelCcc();
});

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
</script>
<style>
tr.highlight1 {
	background-color: #eef3fb;
}
tr.highlight2 {
	background-color: #eef3fb;
}
</style>
</head>
<body onload="fn_egov_init()">

<form name="CcmClCodeForm" action="<c:url value='/sym/ccm/ccc/SelectCcmCmmnClCodeList.do'/>" method="post" onSubmit="fn_egov_search_code(); return false;"> 
<div class="board">
	<h1>${pageTitle} <spring:message code="title.list" /></h1>
	<!-- 검색영역 -->
	<!-- 검색조건선택 -->
	<div class="search_box" title="<spring:message code="common.searchCondition.msg" />">
		<ul>
			<li style="padding-right:2%;">
				<label for="">검색조건 : </label>
				<input style="vertical-align: middle;" checked="checked" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '1'}">checked="checked"</c:if> value="1">공통코드ID</input>
				<input style="vertical-align: middle;" type="radio" name="searchCondition" <c:if test="${searchVO.searchCondition == '2'}">checked="checked"</c:if> value="2">공통코드ID명</input>
			</li>
			<!-- 검색키워드 및 조회버튼 -->
			<li>
				<label for="">검색어 : </label>
				<input id="F1" class="s_input" name="searchKeyword" type="text"  size="35" title="<spring:message code="title.search" /> <spring:message code="input.input" />" value='<c:out value="${searchVO.searchKeyword}"/>'  maxlength="155" >
				<input type="submit" class="s_btn" value="<spring:message code="button.inquire" />" title="<spring:message code="title.inquire" /> <spring:message code="input.button" />" />
			</li>
		</ul>
	</div>
	
	<!-- 목록영역 -->
	<div style="width:28%; height:550px; float:left; overflow:auto; border-top:2px solid #4688d2; border-left:1px solid #ddd; border-bottom:1px solid #ddd; border-right:1px solid #ddd;">		
		<table id="ccmCccCdTb" class="board_list" style="border-collapse:collapse; border:0px;" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
			<caption>${pageTitle}<spring:message code="title.list" /></caption>
			<colgroup>
				<col style="width: 17%;">
				<col style="width: 38%;">
				<col style="width: 55%;">
			</colgroup>
			<thead>
				<tr>
					<th style="position:sticky; top:0px;"><spring:message code="table.num" /></th><!-- 번호 -->
					<th style="position:sticky; top:0px;">공통코드ID</th><!-- 공통코드ID -->
					<th style="position:sticky; top:0px;" class="board_th_link">공통코드ID명</th><!-- 공통코드ID명 -->
				</tr>
			</thead>
			<tbody class="ov" style="overflow:auto;">
				<c:if test="${fn:length(resultList) == 0}">
					<tr>
						<td colspan="3"><spring:message code="common.nodata.msg" /></td>
					</tr>
				</c:if>
				<c:forEach items="${resultList}" var="resultInfo" varStatus="status">
					<tr href="<c:url value='/sym/ccm/ccc/SelectCcmCmmnClCodeDetail.do'/>?comnCdId=${resultInfo.comnCdId}" onClick="fn_egov_inquire_codedetail('<c:out value="${resultInfo.comnCdId}"/>');return false;">
						<td>
							<c:out value="${(searchVO.pageIndex-1) * searchVO.pageSize + status.count}"/>
						</td>
						<td>
							<c:out value='${fn:substring(resultInfo.comnCdId, 0, 40)}'/>
						</td>
						<td class="Elli" title="<c:out value="${resultInfo.comnCdIdNm}"/>">
							<c:out value='${resultInfo.comnCdIdNm}'/>
						</td>
					</tr>
				</c:forEach>
				<tr style="background-color:#f9f9f9;">
					<td colspan="3">   
						<button type="button" >추가</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div  style="width:34%; float:left; margin-left:1%; height:550px; overflow:auto; border-top:2px solid #4688d2; border-left:1px solid #ddd; border-bottom:1px solid #ddd; border-right:1px solid #ddd;">
		<table class="board_list" id="ccmCdeCdTb" style="border-collapse:collapse; border:0px; summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
			<caption>${pageTitle}<spring:message code="title.list" /></caption>
			<colgroup>
		 		<col style="width: 15%;"> 
				<col style="width: 30%;">
				<col style="width: 55%;">
			</colgroup>
			<thead>
				<tr>
					<th style="position:sticky; top:0px;"><spring:message code="table.num" /></th><!-- 번호 --> 
					<th style="position:sticky; top:0px;" class="board_th_link">공통코드</th><!-- 상세 공통코드 -->
					<th style="position:sticky; top:0px;">공통코드명</th><!-- 상세 공통코드명 -->
				</tr>
			</thead>
			<tbody class="ov"></tbody>
		</table>
	</div>
	<div id="getCcmCccRegistJsp" style="width:35%; margin-left:1%; height:550px; float:right;"></div>
</div>

<input name="comnCdId" type="hidden" value="">
<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>">
</form>

</body>
</html>