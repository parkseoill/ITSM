<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OffDay</title>
<script type="text/javascript">
$(document).ready(function () {

});
</script>
<style>
td, th {
	width: 90px;
	text-align: center;
}
</style>
</head>
<body>
	<h3 style="text-align: center"><strong>휴가자</strong></h3>
	<table>
		<tr>
			<th>날짜</th>
			<th>이름</th>
			<th>유형</th>
		</tr>
		<c:forEach var="offday" items="${resultList}">
			<tr>
				<c:choose>
					<c:when test="${offday.offday_cd eq '2'}">
						<td>${offday.offday_date}</td>
						<td>${offday.chrgr_nm}</td>
						<td>전일휴무</td>
					</c:when>
					<c:when test="${offday.offday_cd eq '3'}">
						<td>${offday.offday_date}</td>
						<td>${offday.chrgr_nm}</td>
						<c:choose>
							<c:when test="${offday.hlfday_cd eq '1'}">
								<td>오전반차</td>
							</c:when>
							<c:when test="${offday.hlfday_cd eq '2'}">
								<td>오후반차</td>
							</c:when>
						</c:choose>
					</c:when>					
				</c:choose>
			</tr>
		</c:forEach>
	</table>
	<p/>
	<h3 style="text-align: center"><strong>MNP당직</strong></h3>
	<table>
		<tr>
			<th>날짜</th>
			<th>이름</th>
			<th>유형</th>
		</tr>
		<c:forEach var="mnp" items="${resultList}">
			<tr>
				<c:choose>
					<c:when test="${mnp.offday_cd eq '1'}">
						<td>${mnp.offday_date}</td>
						<td>${mnp.chrgr_nm}</td>
						<td>전일근무</td>
					</c:when>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
</body>
</html>