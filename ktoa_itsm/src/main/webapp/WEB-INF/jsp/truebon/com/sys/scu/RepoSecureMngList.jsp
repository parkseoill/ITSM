<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : RepoSecureMngList.jsp
  * @Description : 보안점검 보고서
  * @Modification Information
  * @
  * @  수정일             수정자             수정내용
  * @ ----------   --------   ---------------------------
  * @ 2022.08.12   조경민            최초 생성
  *
  *  @author 조경민
  *  @since 2022.08.12
  *  @version 1.0
  *  @see
  *
  */
%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>보안점검관리 보고서</title>
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
	// currDate value 현재날짜  yyyymm
	const sysDate = new Date();
	const year = sysDate.getFullYear();
	const month = sysDate.getMonth() + 1;
	$('#currDate').val(year+""+month);
	
	//연도-월(MonthPicker options)
	var monthPickerOptions = {
		MonthFormat: 'yymm',
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
	$('#currDate').val(getToday('yyyy-mm'));
	const nvalue = $('#currDate').val().replace('-', '');
	$('#currDate').val(nvalue);
	$('#currDate').MonthPicker(monthPickerOptions);
	// jr정보 전송
	fn_jrView();
});

//jr정보 전송
function jrViewSubmit(){
	// jrParam 정보를 생성
	setJrParam();
	// 최종 jrSubmit
	jrSubmit();
}

//jrxml 파일 세팅
function setJrFile(){
	// 파일 경로
	$("#jrXmlFilePathAdd").val("truebon/com/sys/scu/");
	// 파일 명
	$("#jrFileNm").val("securReport.jrxml");
	console.log("setJrFileName = " + $("jrFileNm").val("securReport.jrxml"));
}

//최종 jrSubmit
function jrSubmit(){
	// jrxml 파일 세팅
	setJrFile();
	
	$("#jrForm").attr("target", "jrView");
	$("#jrForm").attr("action", "/cmm/jasper/viewRepo.do");
	//console.log("jrSubmit(jrForom) = " + $("#jrForm"))
	$("#jrForm").submit();
}

//jrParam 정보를 생성(주로 여기서 변경)
function setJrParam(){
	// 달력 선택한 날짜 정보
	let currDate = $("#currDate").val();
	currDate = currDate.substring(0, 7);
	currDate = currDate.replace("-", "");
	//console.log("setJrParam" + currDate);
	// 파라미터(jrParam1, jrParam2 ...)
	$("#arrJrParamListJson").val(JSON.stringify(getArrJrParamList()));
}

// jrParam 정보 생성
function getArrJrParamList(){
	//배열 선언
	let arrJrParam = new Array();
	
    // jrParam1 (달력 선택한 날짜 정보)
	let currDate = $("#currDate").val();
	arrJrParam.push(currDate);
	// jrParam2 (위치 정보)
	let inspLocatSearch = $("#inspLocatSearch").val();
	arrJrParam.push(inspLocatSearch);
	
	//console.log("arrJrParam = " + arrJrParam);
	return arrJrParam;
}	
	
// 리포트 생성 및 출력
function fn_jrView(){
	const jrXmlFilePathAdd = "truebon/com/sys/scu/";	// jrxml 파일 경로 sub
	const jrFileNm = "securReport";	// jrxml, 기타 파일 명
	const jrServiceNm = "";	// DB 서비스 사용 시 등록
	let sysdate
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
				console.log(data.filePath);
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
			//로딩완료
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
		const jrXmlFilePathAdd = "truebon/com/sys/scu/";	// jrxml 파일 경로 sub
		const jrFileNm = "securReport";	// jrxml, 기타 파일 명
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
	<h1>보안점검결과 보고서</h1>
	<!-- 위치 -->
	<select id="inspLocatSearch" title="위치검색" onChange="fn_jrView()" style="width:80px; height:18px;">
		<option value="1">본관</option>
		<option value="2">별관</option>
	</select>
	<!-- 달력 -->
	<input type="text" id="currDate" style="width:80px; height:18px;">
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