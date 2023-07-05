<!DOCTYPE html>
<%--
 /**
  * @Class Name : SrMasterMngUpdt.jsp
  * @Description : 서비스 요청 수정 화면
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.07.28       김도아    	      최초 생성
  *
  *  @author 김도아
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
<title>서비스 요청 수정</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<!-- 달력 기본 설정 -->
<script type="text/javascript" src="<c:url value='/js/truebon/com/cmm/initDatepicker.js' />"></script>
<!-- validator 클라이언트 -->
<script type="text/javascript" src="<c:url value="/validator.do" />"></script>
<validator:javascript formName="srMasterVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script language="javascript1.2" type="text/javaScript">
<!--
$(document).ready(function () {
	// 담당자 부서목록 이동 화면 호출 함수
    $('#popupPositDeptList').click(function (e) {
    	e.preventDefault();
        var pagetitle = $(this).attr("title");
        var page = "<c:url value='/opm/srm/SrMasterMngListPopup.do'/>";
        var $dialog = $('<div style="overflow:hidden;padding: 0px 0px 0px 0px;"></div>')
        .html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
        .dialog({
        	autoOpen: false,
            modal: true,
            width: 500,
            height: 550,
            title: pagetitle
    	});
    	$dialog.dialog('open');
	});
});

/* ********************************************************
 * 수정처리 함수
 ******************************************************** */
function updateSrMasterMng() {
	// 폼체크
	if($("#bizSytmCd").val() == null || $("#bizSytmCd").val() == "" || $("#bizSytmCd").val() == "--선택하세요--") {
		alert("업무시스템명을 선택해 주세요");
		$("#bizSytmCd").focus();
	}else if($("#srTypeClasC").val() == null || $("#srTypeClasC").val() == "" || $("#srTypeClasC").val() == "--선택하세요--") {
		alert("요청분류를 선택해 주세요");
	}else if($("#reqTitle").val() == null || $("#reqTitle").val() == "" ) {
		alert("요청 제목을 입력해 주세요");
		$("#reqTitle").focus();
	}else{
		var objForm = document.getElementById("srMasterMngForm");
		
		if(confirm("<spring:message code="common.update.msg" />")){
			if(!validateSrMasterVO(objForm)){
				return;
			}else{
				objForm.submit();
			}
		}
	}
}

/* ********************************************************
 * 저장처리 함수
 ******************************************************** */
function insertSrMasterMng() {
	// 폼체크
	if($("#positDeptNm").val() == null || $("#positDeptNm").val() == "" || $("#positDeptNm").val() == "--선택하세요--") {
		alert("요청부서를 선택해 주세요");
		$("#positDeptNm").focus();
		return;
	}else if($("#bizSytmCd").val() == null || $("#bizSytmCd").val() == "" || $("#bizSytmCd").val() == "--선택하세요--") {
		alert("업무시스템명을 선택해 주세요");
		$("#bizSytmCd").focus();
	}else if($("#srTypeClasC").val() == null || $("#srTypeClasC").val() == "" || $("#srTypeClasC").val() == "--선택하세요--") {
		alert("요청분류를 선택해 주세요");
	}else if($("#reqTitle").val() == null || $("#reqTitle").val() == "" ) {
		alert("요청 제목을 입력해 주세요");
		$("#reqTitle").focus();
	}else{
		var objForm = document.getElementById("srMasterMngForm");
		if(confirm("<spring:message code="common.save2.msg" />")){
			if(!validateSrMasterVO(objForm)){
				return;
			}else{
				objForm.action = "<c:url value='/opm/srm/insertSrMasterMngRegist.do' />";
				objForm.submit();
			}
		}
	}
}
/* ********************************************************
 * 목록조회  함수
 ******************************************************** */
function selectList(){
	var objForm = document.getElementById("srMasterMngForm");
	objForm.action = "<c:url value='/opm/srm/SrMasterMngList.do' />";
	objForm.submit();
}

/* ********************************************************
 * 삭제처리함수
 ******************************************************** */
function deleteSrMaster() {
	var objForm = document.getElementById("srMasterMngForm");
	
	if(confirm("<spring:message code="common.delete.msg"/>")){
		objForm.action="<c:url value='/opm/srm/deleteSrMaster.do' />";
		objForm.submit();
	}
}

 /* ********************************************************
  * 달력 박스 날짜 세팅
  ******************************************************** */
$(document).ready(function(){
  	$.datepicker.setDefaults($.datepicker.regional['ko']); 
  	$( "#Date, #dlngDate, #PrDate" ).datepicker({
  		changeMonth: true, 
  		changeYear: true
  	});
}); 	
 
 
 /* ********************************************************
  * 요청 분류 선택 함수
  ******************************************************** */
$(document).ready(function(){
     //대분류, 중분류, 소분류 값 
      var type = document.getElementById('srTypeClasCd').value;
      var type1 = type.substring(0,5);
      var type2 = type.substring(0,7);
     
      //처음 페이지가 로딩되었을 때 대분류, 중분류, 소분류 값 select에 불러오기
     $('#srTypeClasa').val(type1).trigger('change');
     $('#srTypeClasa option').each(function(){
          if($(this).is(':selected')){
            getSrtTypeClalsa();
        }
     }); 
         
      function getSrtTypeClalsa(){          
        var temp1 =$('#srTypeClasa option:selected').val();
           
          $.ajax({
            url : "<c:url value='/opm/srm/SrMasterType.do'/>",
            type : 'POST',
              data: {
               "newComnCd":temp1 
            },  
            dataType: 'json' ,      
            success: function (data) {                                    
               $(data.srTypeClasCdList).each(function(i){                                          
                  $("#srTypeCla").append("<option value='"+ data.srTypeClasCdList[i].newComnCd +"'>"+ data.srTypeClasCdList[i].comnCdNm +"</option>");                  
               });
            },
            error: function(){
               alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.                
            }
            , 
            complete: function (data) { 
              //처음 페이지가 로딩 되었을 때 대분류 값에 따른 중분류, 소분류 값 select에 불러오기
                if(type2 != null){
                $('#srTypeCla').val(type2).trigger('change');
                $('#srTypeCla option').each(function(){
                       if($(this).is(':selected')){
                      getSrtTypeCla(); 
                      }
                  });
              }
            }
          });
        }

        function getSrtTypeCla(){  
            var temp2 =$('#srTypeCla option:selected').val();

            $.ajax({
              url : "<c:url value='/opm/srm/SrMasterType.do'/>",
              type : 'POST',
                data: {
                 "newComnCd":temp2 
              },  
              dataType: 'json' ,      
              success: function (data) {
                 $(data.srTypeClasCdList).each(function(i){                                          
                    $("#srTypeClasC").append("<option value='"+ data.srTypeClasCdList[i].newComnCd +"'>"+ data.srTypeClasCdList[i].comnCdNm +"</option>");                                       
                 });
              },
              error: function(){
                 alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.
                  
              },
              complete: function (data) {
                  //처음 페이지가 로딩 되었을 때 중분류 값에 따른 소분류 값 select에 불러오기
                    if(type != null){
                    $("#srTypeClasC").val(type).prop("selected", true);
                    //초기값 삭제
                    type = null;
                    type2 = null;
                    }
              }
           });
        }
      
        //새로 선택한 대분류, 중분류, 소분류 값 불러오기 
        $('#srTypeClasa').change(function(){
            if(type2 == null){
               $("#srTypeCla option").not("[value='none']").remove();
               $("#srTypeClasC option").not("[value='']").remove();
                getSrtTypeClalsa();
            }
        });
         $('#srTypeCla').change(function(){
            if(type == null){
               $("#srTypeClasC option").not("[value='']").remove();
               getSrtTypeCla();
            }
        });
		
        // 처리일 입력시 요청진행상태 변경
		$('#dlngDate').change(function(){
			if($("#dlngDate").val() != null || $("#dlngDate").val() != "") {
				$("input:radio[name=srProgStatCd]:input[value='3']").attr("checked", true);
			}
		});
        
        <c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_USER'}">
        	var loginUserNm = "${sessionScope.loginVO.name}";
	        if($('#dlngChrgrNm').val() != loginUserNm){
	        	disabled();
	        }
		</c:if>	
});

function disabled() {
	$("#bizSytmCd").attr("disabled", true);
	$("#srTypeClasa").attr("disabled", true);
	$("#srTypeCla").attr("disabled", true);
	$("#srTypeClasC").attr("disabled", true);
	$("#PrDate").attr("disabled", true);
	$("#PrDate").datepicker('disable');
	$(".srProgStatCd").attr("disabled", true);
	$("#reqTitle").attr("disabled", true);
	$("#reqText").attr("disabled", true);
	$("#Date").datepicker('disable');
	$("#dlngDate").datepicker('disable');
	$("#dlngText").attr("disabled", true);
}

<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
//-->	
</script>
</head>
<body>

<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript><!-- 자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다. -->

<form:form commandName="srMasterVO" id="srMasterMngForm" name="srMasterMngForm" method="post" action="${pageContext.request.contextPath}/opm/srm/updateSrMasterMngUpdt.do">
	<!-- 검색조건 유지 -->
    <input type="hidden" name="startDate" value="<c:out value='${searchVO.startDate}'/>"/>
    <input type="hidden" name="endDate" value="<c:out value='${searchVO.endDate}'/>"/>
    <input type="hidden" name="searchSytmCd" value="<c:out value='${searchVO.searchSytmCd}'/>"/>
    <input type="hidden" name="searchName" value="<c:out value='${searchVO.searchName}'/>"/>
    <input type="hidden" name="searchSytmCdNm" value="<c:out value='${searchVO.searchSytmCdNm}'/>"/>
	<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
    <!-- 서비스요청관리번호 -->
    <input type="hidden" name="srMngtNo" value="<c:out value='${searchVO.srMngtNo}'/>"/>
    <!-- 요청분류코드 -->
    <input type="hidden" id="srTypeClasCd" value="<c:out value='${searchVO.srTypeClasCd}'/>"/>
	<!-- 담당자 번호 -->
    <input type="hidden" id="dlngChrgrNo" name="dlngChrgrNo" value="<c:out value='${searchVO.dlngChrgrNo}'/>"/>
	<c:set var="placeholder">작성예시)
-요청내용1
-요청내용2
-요청내용3</c:set>
<div class="wTableFrm">
	<!-- 타이틀 -->
	<h2>서비스 요청 수정</h2>

	<!-- 등록폼 -->
	<table class="wTable">
		<colgroup>
			<col style="width:15%" />
			<col style="width:35%" />
			<col style="width:15%" />
			<col style="" />
		</colgroup>
		<tr>
			<th>요청부서 <span class="pilsu">*</span></th>
			<td class="left">
      			<form:input path="positDeptNm" id="positDeptNm" title="요청부서" readonly="true" class="readOnlyClass" cssStyle="width:140px; padding-left:5px;"/>
	      		<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN' || sessionScope.loginVO.chrgrNo == searchVO.dlngChrgrNo}">
	      		<a id="popupPositDeptList" href="#LINK" target="_blank" title="부서 선택">
					<img src="<c:url value='/images/egovframework/com/cmm/icon/search2.gif' />" alt='' />(부서 선택)</a>
				</c:if>
				<div><form:errors path="positDeptNm" cssClass="error" /></div>
			</td>
			<th>요청자<span class="pilsu">*</span></th>
			<td class="left">
      			<form:input path="reqChrgrNm" id="reqChrgrNm" title="요청자" readonly="true" class="readOnlyClass" cssStyle="width:140px; padding-left:5px;"/>
	      		<form:input type="hidden" path="reqChrgrNo" id="reqChrgrNo" />
	      		<div><form:errors path="reqChrgrNm" cssClass="error" /></div>
	      		<div><form:errors path="reqChrgrNo" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>업무 시스템명<span class="pilsu">*</span></th>
			<td class="left">
      			<form:select path="bizSytmCd" id="bizSytmCd" title="업무 시스템명" cssClass="txt"  cssStyle="width:220px;">
					<form:option value=""  label="--선택하세요--" />
					<form:options items="${bizSytmList}" itemLabel="bizSytmNm" itemValue="bizSytmCd" />
				</form:select>
				<div><form:errors path="bizSytmNm" cssClass="error" /></div>
			</td>
			<th>담당자<span class="pilsu">*</span></th>
			<td class="left">
				<form:input path="dlngChrgrNm" id="dlngChrgrNm" title="담당자"  readonly="true" class="readOnlyClass" cssStyle="width:140px; padding-left:5px;"/>
				<div><form:errors path="dlngChrgrNo" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>요청 대분류<span class="pilsu">*</span></th>
			<td class="left">
				<form:select id="srTypeClasa" path="srType" title="요청 대분류" cssClass="txt"  cssStyle="width:220px">
					<form:option value="none" id="srType" label="--선택하세요--" />
					<form:options  id="srType" items="${srTypeList}" itemValue="newComnCd" itemLabel="comnCdNm" />
				</form:select>
				<div><form:errors path="srType" cssClass="error" /></div>
			</td>
			<th>요청 중분류<span class="pilsu">*</span></th>
			<td class="left">
				<form:select id="srTypeCla" path="srTypeClas" title="요청 중분류" cssClass="txt"  cssStyle="width:220px">
					<form:option value="none" label="--선택하세요--" />
				</form:select>
				<div><form:errors path="srTypeClas" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>요청 소분류<span class="pilsu">*</span></th>
			<td class="left">
				<form:select id="srTypeClasC" path="srTypeClasCd" title="요청 소분류"  cssClass="txt"  cssStyle="width:220px">
					<form:option value="" label="--선택하세요--" />
				</form:select>
      			<div><form:errors path="srTypeClasCd" cssClass="error" /></div>
			</td>
			<th>요청일<span class="pilsu">*</span></th>
			<td class="left">
				<form:input path="reqDate" id="Date" name="reqDate"  title="요청일" maxlength="30" cssStyle="width:140px; padding-left:5px;"  class="readOnlyClass" readonly="true"/>      			
				<div><form:errors path="reqDate" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>요청 처리예정일</th>
			<td class="left">
			    <form:input path="dlngPrargDate" id="PrDate" maxlength="20" title="요청 처리예정일" cssStyle="width:140px; padding-left:5px;"  class="readOnlyClass"/>
			    <div><form:errors path="dlngPrargDate" cssClass="error" /></div>
			</td>
			<th>요청진행상태 <span class="pilsu">*</span></th>
			<td class="left">
				<%-- <form:radiobuttons path="srProgStatCd" items="${srProgStatCdList}" itemValue="comnCd" itemLabel="comnCdNm"/> --%>
				<form:radiobutton path="srProgStatCd" class="srProgStatCd" name="srProgStatCd" value="1" label=" 대기" />&emsp;
				<form:radiobutton path="srProgStatCd" class="srProgStatCd" name="srProgStatCd" value="2" label=" 진행" />&emsp;
				<form:radiobutton path="srProgStatCd" class="srProgStatCd" name="srProgStatCd" value="3" label=" 완료" />
				<div><form:errors path="srProgStatCd" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>요청 제목<span class="pilsu">*</span></th>
			<td class="left" colspan="3">
			    <form:input path="reqTitle" id="reqTitle" maxlength="250" title="요청 제목" cssStyle="width:84%; padding-left:5px;" />
			    <div><form:errors path="reqTitle" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>요청 내용</th>
			<td class="left" colspan="3">
			    <form:textarea path="reqText" id="reqText" rows="5" cols="100" cssClass="repo_txt" title="요청 내용" placeholder="${placeholder}" cssStyle="width:84%; height:140px; padding:5px;"/>
      			<div><form:errors path="reqText" cssClass="error" /></div>
			</td>
		</tr>
				<tr>
			<th>처리일</th>
			<td class="left" colspan="3">
			    <form:input path="dlngDate" id="dlngDate" maxlength="250" title="처리일" cssStyle="width:150px; padding-left:5px;"  class="readOnlyClass"/>
			    <div><form:errors path="dlngDate" cssClass="error" /></div>
			</td>
		</tr>
		<tr>
			<th>처리 내용</th>
			<td class="left" colspan="3">
			    <form:textarea path="dlngText" id="dlngText" rows="5" cols="100" cssClass="txaClass" title="처리 내용" cssStyle="width:84%; height:140px; padding:5px;"/>
      			<div><form:errors path="dlngText" cssClass="error" /></div>
			</td>
		</tr>
	</table>

	<!-- 하단 버튼 -->
	<div class="btn">
		<c:if test="${sessionScope.loginVO.authorCode eq 'ROLE_ADMIN' || sessionScope.loginVO.chrgrNo == searchVO.dlngChrgrNo}">
			<input class="s_submit" type="submit" value='<spring:message code="button.create" />' onclick="insertSrMasterMng(); return false;" /><!-- 등록 -->
			<input class="s_submit" type="submit" value='<spring:message code="button.update" />' onclick="updateSrMasterMng(); return false;" /><!-- 수정 -->
			<span class="btn_s"><a href="#LINK" onclick="deleteSrMaster(); return false;"><spring:message code="button.delete" /></a></span><!-- 삭제 -->
		</c:if>
		<span class="btn_s"><a href="#LINK'/>" onclick="selectList(); return false;"><spring:message code="button.list"/></a></span><!-- 목록 -->
	</div>
	
	<div style="clear:both;"></div>
</div>

</form:form>

</body>
</html>