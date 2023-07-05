<%
 /**
  * @Class Name : EgovGroupManage.java
  * @Description : EgovGroupManage List 화면
  * @Modification Information
  * @
  * @  수정일                     수정자               수정내용
  * @ ----------    --------    ---------------------------
  * @ 2009.02.01    lee.m.j     최초 생성
  *   2016.06.13    장동한        표준프레임워크 v3.6 개선
  *  
  *  @author lee.m.j
  *  @since 2009.03.11
  *  @version 1.0
  *  @see
  *
  */
%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="pageTitle"><spring:message code="comCopSecGmt.title"/></c:set>
<!DOCTYPE html>
<html>
<head>
<title>회사 /부서 관리</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* ********************************************************
 * 목록 선택 함수
 ******************************************************** */
function fncSelectGroup(cmpnyNo,cmpnyNm,rpsntvNm,cmpnyTelNo,cmpnyAddr) {
	$('#cmpnyTb tbody tr').removeClass('cmpnyBg');
	function fncSelectTb(){
		   $('#cmpnyTb tbody tr').each(function(index,tr){
		          if($(this).find('td:eq(0)').text() == cmpnyNo){
		        	$(this).addClass('cmpnyBg');
					$("#groupDc").val("Update");
		          }
		   });
	}fncSelectTb();
	$.ajax({
		url : "<c:url value='/sec/gmt/EgovDeptList.do' />",
		type : 'POST',
        data: {
			"cmpnyNo":cmpnyNo ,
		},  
		dataType: 'json' , 	  
		success: function (data) {
			$('#deptList > tbody').empty();
			$("#deptNo1").val("");
			var results = data.deptManageList;
			var html = '';
			html += '<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN'}"><tr style="background-color:#f9f9f9;"><td colspan="2" onClick="deptInsert();"><button type="button" >추가</button></td></tr></c:if>';
            $.each(results , function(i){
            	html += '<tr onclick=\"fncSelectDept(\''+ results[i].deptNo +'\', \''+ results[i].deptNm +'\'); return false;\">' + '<td>' + results[i].deptNo + '</td><td class=\"Elli\">' + results[i].deptNm + '</td>';
            	html += '</tr>';
           });
           $("#deptList").append(html);
           $("#cmpnyNo1").val(cmpnyNo);
	       $("#cmpnyNm1").val(cmpnyNm);
	       $("#rpsntvNm1").val(rpsntvNm);
	       $("#cmpnyTelNo1").val(cmpnyTelNo);
	       $("#cmpnyAddr1").val(cmpnyAddr); 
	       $('.DeptForm').hide();
		},
		error: function(){
			alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.	    	
		},
 		complete: function(){
 			fncSelectDeptTb();
 			$('#deptList tbody tr').each(function(index,tr){
	    		$(this).find('td:eq(1)').attr('title',$(this).find('td:eq(1)').text());
			});
		} 
	});  	
}

function fncSelectDept(deptNo,deptNm) {
	$("#deptNo1").val(deptNo);
	$("#deptNm1").val(deptNm);
	$("#groupDc").val("");
	$('.DeptForm').show();
	$('#deptList tbody tr').removeClass('deptBg');
	function fncSelectTb2(){
		   $('#deptList tbody tr').each(function(index,tr){
		          if($(this).find('td:eq(0)').text() == deptNo){
		        	$(this).addClass('deptBg');
		          }
		   });
	}fncSelectTb2();
}
$(document).ready(function(){
	$('#getJsp').load('/sec/gmt/EgovGroupInsertView.do');
 	var cmpnyNo = '${McmpnyNo}';
	function fncSelectTb(){
	   $('#cmpnyTb tbody tr').each(function(index,tr){
	          if($(this).find('td:eq(0)').text() == cmpnyNo){
	        	  console.log(this);
	             $(this).click();
	          }
	   });
	}
	if(cmpnyNo != "") {
		fncSelectTb();
		$('.DeptForm').hide();
		cmpnyNo = "";
	}
});
var deptNo = '${MdeptNo}';
function fncSelectDeptTb(){
	   $('#deptList tbody tr').each(function(index,tr){
	          if($(this).find('td:eq(0)').text() == deptNo){
	        	  console.log(this);
	             $(this).click();
	             $("#groupDc").val("");
	          }
	  		 if(deptNo == "") {
	  			 $('.DeptForm').hide();	
			 }
	   });
	   deptNo = "";
}
/* ********************************************************
 * focus 시작점 지정함수
 ******************************************************** */
function fn_FocusStart(){
	$('#F1').focus();
}

function press() {
    if (event.keyCode==13) {
    	fncSelectGroupList('1');
    }
}
/* ********************************************************
 * 회사등록폼 세팅 함수
 ******************************************************** */
function cmpnyInsert() {
	$('#cmpnyTb tbody tr').removeClass('cmpnyBg');
	$('#deptList > tbody').empty();
	$("#cmpnyNo1").val("");
	$("#cmpnyNm1").val("");
	$("#rpsntvNm1").val("");
	$("#cmpnyTelNo1").val("");
	$("#cmpnyAddr1").val(""); 
	$("#deptNm1").val("");
	$("#deptNo1").val("");
	$('.DeptForm').hide();
}
function deptInsert() {
	$("#groupDc").val("");
	$('.DeptForm').show();
	$('#deptList tbody tr').removeClass('deptBg');
	$("#deptNm1").val("");
	$("#deptNo1").val("");
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
-->
</script>
<style>
      .cmpnyBg { background-color: #eef3fb; }
      .deptBg { background-color: #eef3fb; }
    </style>
</head>

<body>
<!-- javascript warning tag  -->
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>
<form:form name="listForm" action="${pageContext.request.contextPath}/sec/gmt/EgovGroupList.do" method="post">
<div class="board">
	<h1>회사 /부서 관리</h1>
	<!-- 검색영역 -->
	<div class="search_box" style="display:flow-root;" title="<spring:message code="common.searchCondition.msg" />">
		<ul>
			<!-- 검색키워드 및 조회버튼 -->
			<li style="float:left; padding-left:8%; ">
				<label for="">회사명 : </label> 
				<input id="F1" class="s_input" name="searchKeyword" type="text"  size="35" title="<spring:message code="title.search" /> <spring:message code="input.input" />" value='<c:out value="${groupManageVO.searchKeyword}"/>'  maxlength="155" >
				<input type="submit" class="s_btn" value="<spring:message code="button.inquire" />" title="<spring:message code="title.inquire" /> <spring:message code="input.button" />" /><!-- 조회 -->
			</li>
		</ul>
	</div>
<table>	
	<colgroup>
		<col style="width:33%" />
		<col style="width:33%" />
		<col style="" />
	</colgroup>
	<!-- 회사목록영역 -->
	<td style="vertical-align:top; padding-right:15px">
	<div id="cmpnyTable">
		<table class="board_list">
			<colgroup>
				<col style="width:38%" />
				<col style="" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col">회사번호</th>
					<th scope="col">회사명</th>
				</tr>
			</thead>
		</table>
		<div style="overflow:auto; height:400px; border:1px solid #ddd">
		<table class="board_list"  style="border-top:none;" id="cmpnyTb">
			<colgroup>
				<col style="width:40%" />
				<col style="" />
			</colgroup>
			<tbody class="ov">
			<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN'}">
			<tr style="background-color:#f9f9f9;">
               <td colspan="2" onClick="cmpnyInsert();">   
                  <button type="button" >추가</button>
               </td>
            </tr>
            </c:if>
			<c:forEach var="group" items="${groupList}" varStatus="status">
			<tr id="cmpnySelect" onclick="fncSelectGroup('<c:out value="${group.cmpnyNo}"/>','<c:out value="${group.cmpnyNm}"/>','<c:out value="${group.rpsntvNm}"/>','<c:out value="${group.cmpnyTelNo}"/>','<c:out value="${group.cmpnyAddr}"/>'); return false;">  			      
			    <td><c:out value="${group.cmpnyNo}"/></td>
			    <td class="Elli" title="<c:out value="${group.cmpnyNm}"/>"><c:out value="${group.cmpnyNm}"/></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
	</td>
	<!-- 부서목록영역 -->
	<td style="vertical-align:top; padding-right:15px;">
	<div id="deptTable">
		<table class="board_list">
			<colgroup>
				<col style="width:40%" />
				<col style="" />
			</colgroup>
			<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
			</tr>
			</thead>
		</table>
		<div style="overflow:auto; height:400px; border:1px solid #ddd">
		<table class="board_list" id="deptList"  style="border-top:none;">
			<colgroup>
				<col style="width:40%" />
				<col style="" />
			</colgroup>
			<tbody class="ov">
			</tbody>
		</table>
		</div>
	</div>
	</td>
	<!-- 등록 ,수정 폼  -->
	<td style="vertical-align:top">
	<div id="getJsp"></div>
	</td>
</table>	
<!-- 검색조건 유지 -->
<input type="hidden" name="cmpnyNo" value="<c:out value='${group.cmpnyNo}'/>"/>
<input name="deptNo" type="hidden">
<input name="cmpnyNo" type="hidden">
</div><!-- end div board -->
</form:form>
</body>

</html>