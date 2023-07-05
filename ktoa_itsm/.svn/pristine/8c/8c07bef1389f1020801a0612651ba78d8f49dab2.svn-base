<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>KTOA ITSM</title>
<link href="<c:url value='/css/egovframework/com/cmm/main.css' />" rel="stylesheet" type="text/css">
<style type="text/css">
link { color: #666666; text-decoration: none; }
link:hover { color: #000000; text-decoration: none; }
</style>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<!-- 좌측메뉴 트리 Start -->
<link href="<c:url value="/css/egovframework/com/com.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/egovframework/com/button.css"/>" rel="stylesheet" type="text/css">
<script type="text/javascript">
var imgpath = "<c:url value='/images/egovframework/com/cmm/utl/'/>";
</script>
<script language="javascript1.2" type="text/javaScript" src="<c:url value='/js/egovframework/com/cmm/EgovUnitLeftMenuList.js' />"></script>
<!-- 좌측메뉴 트리 End -->
</head>
<body>
<div id="lnb">
<!-- DB에서 조회된 메뉴 목록 Start -->
<ul class="lnb_title">
	<c:if test="${loginVO == null}">
	<li>
		<b><a href="/uat/uia/egovLoginUsr.do" target="_content">로그인</a></b>이 필요합니다.
	</li>
	</c:if>
	<li>
		<c:forEach var="result" items="${list_menulist}" varStatus="status" >
			<input type="hidden" name="tmp_menuNmVal" value="${result.menuNo}|${result.upperMenuId}|${result.menuNm}|${result.relateImagePath}|${result.relateImageNm}|${result.chkURL}|"/>
			<!-- <input type="text" name="tmp_menuNmVal" value="${result.menuNo}|${result.upperMenuId}|${result.menuNm}|${result.progrmFileNm}|${result.menuNo}|${result.menuOrdr}|${result.menuNm}|${result.upperMenuId}|${result.menuDc}|${result.relateImagePath}|${result.relateImageNm}|${result.progrmFileNm}|"> -->
		</c:forEach>
	
		<script language="javascript" type="text/javaScript">
		var Tree = new Array;
		
		if ( typeof $("input[name=tmp_menuNmVal]") == "object"
			&& typeof $("input[name=tmp_menuNmVal]") == "object"
			&& $("input[name=tmp_menuNmVal]").length > 0 ) {
		
			$("input[name=tmp_menuNmVal]").each(function(index, obj){
				Tree[index] = obj.value;
				//console.log(index + ";" + obj.value);
			});
			createTree(Tree, true);
		}
		</script>
	</li>
</ul>
<!-- DB에서 조회된 메뉴 목록 End -->
</body>
</html>
