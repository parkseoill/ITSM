<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : RepoDlalzMngList.jsp
  * @Description : 출퇴근 기록부
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2023.02.28   박서일               박서일
  *
  *  @author 이태신
  *  @since 2022.07.14
  *  @version 1.0
  *  @see
  *
  */
%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>연차휴가 사용 실적 보고서</title>
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<!-- jQuery -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<!-- 달력 기본 설정 -->
<script type="text/javascript" src="<c:url value='/js/truebon/com/cmm/initDatepicker.js' />"></script>
<!-- 달력(연도, 월) API -->
<link type="text/css" rel="stylesheet" href="<c:url value='/css/truebon/com/cmm/jquery-monthPicker/MonthPicker.css' />">
<script src="<c:url value='/js/truebon/com/cmm/jquery-monthPicker/MonthPicker.js' />"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//연도-월(MonthPicker options)
		var monthPickerOptions = {
			MonthFormat: 'yy-mm',
			ShowIcon: true,
			i18n: {
				year: '년도',
				prevYear: '이전년도',
				nextYear: '다음년도',
				next12Years: '다음 12년',
				prev12Years: '이전 12년',
				nextLabel: '다음',
				prevLabel: '이전',
				buttonText: '달력보기',
				jumpYears: '년도로 이동',
				backTo: '뒤로',
				months: ['1 월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
			},
			OnAfterChooseMonth: function(dateText){
    			console.log("Selected date:"+dateText+",current value:"+this.value);
    			// jr정보 전송
    			fn_jrView();
    		}
		};
		// 현재 날짜 입력(연도-월)
		$('#currDate').val(getToday('yyyy-mm'));
		$('#currDate').MonthPicker(monthPickerOptions);
		
    	// jr정보 전송
    	fn_jrView();
	});

/* JasperController /cmm/jasper/viewRepoHeader.do 사용 시 이용. 예시) */
/*
	// jr정보 전송
	function jrViewSubmit(){
		// jrParam 정보를 생성
		setJrParam();
		// 최종 jrSubmit
		jrSubmit();
	}
	
	// jrxml 파일 세팅
	function setJrFile(){
		// 파일 경로
		$("#jrXmlFilePathAdd").val("truebon/com/dlm/dla/");
		// 파일 명
		$("#jrFileNm").val("dlalzReport.jrxml");
	}
	
	// 최종 jrSubmit
	function jrSubmit(){
		// jrxml 파일 세팅
		setJrFile();
		
		$("#jrForm").attr("target", "jrView");
		$("#jrForm").attr("action", "/cmm/jasper/viewRepo.do");
		
		$("#jrForm").submit();
	}
	
	// jrParam 정보를 생성(주로 여기서 변경)
	function setJrParam(){
		// 달력 선택한 날짜 정보
		let currDate = $("#currDate").val();
		currDate = currDate.substring(0, 7);
		currDate = currDate.replace("-", "");
		//console.log(currDate.replace("-", ""));
		// 파라미터(jrParam1, jrParam2 ...)
		$("#arrJrParamListJson").val(JSON.stringify(getArrJrParamList()));
	}
*/
	
	// jrParam 정보 생성
	function getArrJrParamList(){
		//배열 선언
        let arrJrParam = new Array();
		
     	// jrParam1 (달력 선택한 날짜 정보)
		let currDate = $("#currDate").val();
		currDate = currDate.substring(0, 7);
		currDate = currDate.replace("-", "");
		arrJrParam.push(currDate);
		//arrJrParam.push("테스트");
		
		return arrJrParam;
	}	

	// 리포트 생성 및 출력
	function fn_jrView(){
		const jrXmlFilePathAdd = "truebon/com/rsm/wmr/";	// jrxml 파일 경로 sub
		const jrFileNm = "YrvacatUseReport";	// jrxml, 기타 파일 명
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
		const jrFileNm = "YrvacatUseReport";	// jrxml, 기타 파일 명
		const paramFileType = pFileType;	// Export File Type
		
		// 파일 경로
		$("#jrXmlFilePathAdd").val(jrXmlFilePathAdd);
		// 파일 명
		$("#jrFileNm").val(jrFileNm);
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
	<h1>연차실적보고서</h1>
	<!-- 달력 -->
	<input type="text" id="currDate" style="width:60px;height:18px;">
	<!-- 버튼 -->
	<div class="btn">
		<span class="btn_s2"><a href="#LINK" onclick="exportFile('PDF'); return false;" title="PDF 내보내기">PDF 내보내기</a></span>
		<span class="btn_s2"><a href="#LINK" onclick="exportFile('EXCEL'); return false;" title="EXCEL 내보내기">EXCEL 내보내기</a></span>
		<span class="btn_s2"><a href="#LINK" onclick="exportFile('DOC'); return false;" title="WORD내보내기">WORD 내보내기</a></span>
	</div>
	<!-- header사용 시 -->
	<!--
	<form id="jrForm" name="jrForm" action ="" method="post">
		<input type="hidden" id="jrXmlFilePathAdd" name="jrXmlFilePathAdd"/>
		<input type="hidden" id="jrFileNm" name="jrFileNm"/>
		<input type="hidden" id="arrJrParamListJson" name="arrJrParamListJson"/>
	</form>
	-->
	<!-- 파일 다운로드 -->
	<form id="jrExportForm" name="jrExportForm" action ="/cmm/jasper/exportRepoFile.do" method="post">
		<input type="hidden" id="jrXmlFilePathAdd" name="jrXmlFilePathAdd"/>
		<input type="hidden" id="jrFileNm" name="jrFileNm"/>
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