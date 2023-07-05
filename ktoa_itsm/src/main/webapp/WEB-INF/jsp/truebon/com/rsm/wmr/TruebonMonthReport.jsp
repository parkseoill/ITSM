<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : TruebonMonthReport.jsp
  * @Description : 업무 보고서
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2023.04.22   박서일            최초 생성
  *
  *  @author 박서일
  *  @since 2023.04.22
  *  @version 1.0
  *  @see
  *
  */
%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>업무 보고서</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<!-- 달력 기본 설정 -->
<script type="text/javascript" src="<c:url value='/js/truebon/com/cmm/initDatepicker.js' />"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		// 달력
		$( "#startDate" ).datepicker({
			changeMonth: true, 
			changeYear: true,
			onClose: function( selectedDate ) {    
			     //시작일(startDate) datepicker가 닫힐때
			     //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
			    $("#endDate").datepicker( "option", "minDate", selectedDate );
			},
			onSelect: function(dateText) {
			    // jr정보 전송
			    fn_jrView();
		    }
		});
		$( "#endDate" ).datepicker({
			changeMonth: true, 
			changeYear: true,
			onClose: function( selectedDate ) {
			    // 종료일(endDate) datepicker가 닫힐때 실행
			    // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
			    $("#startDate").datepicker( "option", "maxDate", selectedDate );
			},
			onSelect: function(dateText) {
				// jr정보 전송
			    fn_jrView();
		    }
		});
		
		$("#startDate").val(getWeekDay('', -2));
		$("#endDate").val(getWeekDay('', 5));
		
    	// jr정보 전송
    	fn_jrView();
	});

	// jrParam 정보 생성
	function getArrJrParamList(){
		//배열 선언
        let arrJrParam = new Array();
		
     	// jrParam1 (달력(Start) 선택한 날짜 정보)
		let startDate = $("#startDate").val();
		arrJrParam.push(startDate);

		// jrParam2 (달력(End) 선택한 날짜 정보)
		let endDate = $("#endDate").val();
		arrJrParam.push(endDate);
		
		return arrJrParam;
	}	
	
	// 리포트 생성 및 출력
	function fn_jrView(){
		const jrXmlFilePathAdd = "truebon/com/rsm/wmr/";	// jrxml 파일 경로 sub
		let jrFileNm = "TruebonMonthReport";	// jrxml, 기타 파일 명
		const jrServiceNm = "";	// DB 서비스 사용 시 등록
		//console.log('값:'+JSON.stringify(getArrJrParamList()));
	
		
		$.ajax({
    		url :"<c:url value='/cmm/jasper/viewRepoFile.do'/>"
            ,type: "POST"
            ,data : {
            	"jrXmlFilePathAdd":jrXmlFilePathAdd,
            	"jrFileNm":jrFileNm,
            	"jrServiceNm":jrServiceNm,
            	"arrJrParamListJson":JSON.stringify(getArrJrParamList())
            }
            ,dataType: 'json'  	   
            ,success : function(data){
            	console.log("파일 경로:"+data.filePath);
            	if(data.resultMsg == "성공"){
            		$("#jrView").attr("src", "/plugin/pdfjs-2.15.349-dist/web/viewer.html?file=" + data.filePath);
            	}else{
            		alert(data.resultMsg);
            	}
    		}
			,beforeSend:function(){
				// loading중 이미지 보여주기 처리
				$('#loading').css('display', 'block');
    		}
			,complete:function(){
    			// loading중 이미지 감추기 처리
    			$('#loading').css('display', 'none');
			}
			,error: function(jqXHR, textStatus, errorThrown){
				// loading중 이미지 감추기 처리
				$('#loading').css('display', 'none');
    	    	
				//console.log(jqXHR);  //응답 메시지
				//console.log(textStatus);
				//console.log(errorThrown);
				alert("<spring:message code="comCopBlog.articleBlogList.validate.occurError" />");//에러가 발생했습니다.
			}
    	});
	}
	
	function exportFile(pFileType){
		const jrXmlFilePathAdd = "truebon/com/rsm/wmr/";	// jrxml 파일 경로 sub
		let jrFileNm = "TruebonMonthReport";	// jrxml, 기타 파일 명
		const jrServiceNm = "";	// DB 서비스 사용 시 등록
		const paramFileType = pFileType;	// Export File Type
		
		// 파일 경로
		$("#jrXmlFilePathAdd").val(jrXmlFilePathAdd);
		// 파일 명
		$("#jrFileNm").val(jrFileNm);
		// 서비스 명
		$("#jrServiceNm").val(jrServiceNm);
		// Export File Type
		$("#paramFileType").val(paramFileType);
		// 파라미터(jrParam1, jrParam2 ...)
		$("#arrJrParamListJson").val(JSON.stringify(getArrJrParamList()));
		
		$("#jrExportForm").submit();
	}
</script>
 
</head>
<body>
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<div class="board">
	<!-- 달력 -->
	<input name="startDate" id="startDate" type="text"  value="" style="width:80px;" readonly="true" />
					~	<input name="endDate" id="endDate" type="text"  value="" style="width:80px;"  readonly="true" />&emsp;&emsp;&emsp;
		<!-- 버튼 -->
	<div class="btn">
		<span class="btn_s2"><a href="#LINK" onclick="exportFile('PDF'); return false;" title="PDF 내보내기">PDF 내보내기</a></span>
		<span class="btn_s2"><a href="#LINK" onclick="exportFile('EXCEL'); return false;" title="EXCEL 내보내기">EXCEL 내보내기</a></span>
		<span class="btn_s2"><a href="#LINK" onclick="exportFile('DOC'); return false;" title="WORD내보내기">WORD 내보내기</a></span>
	</div>
	<!-- 파일 다운로드 -->
	<form id="jrExportForm" name="jrExportForm" action ="/cmm/jasper/exportRepoFile.do" method="post">
		<input type="hidden" id="jrXmlFilePathAdd" name="jrXmlFilePathAdd"/>
		<input type="hidden" id="jrFileNm" name="jrFileNm"/>
		<input type="hidden" id="jrServiceNm" name="jrServiceNm"/>
		<input type="hidden" id="arrJrParamListJson" name="arrJrParamListJson"/>
		<input type="hidden" id="paramFileType" name="paramFileType"/>
	</form>
	<!-- loading -->
	<div id="loading" style="width: 100%; height: 100%; z-index: 1; position: absolute; top: 50vh; left: 50vw;">
		<img src="<c:out value="/images/truebon/com/cmm/loding/repoLoding.gif"></c:out>">
	</div> 
	<!-- jasper Reports View -->
	<div style="width:100%; height:800px; padding-top:10px;">
		<iframe id="jrView" name="jrView" src="" width="100%" height="100%" border="0" scrolling="no"></iframe>
	</div>
</div>
</body>
</html>