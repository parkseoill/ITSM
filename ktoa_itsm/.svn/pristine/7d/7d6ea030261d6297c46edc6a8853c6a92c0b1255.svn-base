$(document).ready(function () {
	// 달력 기본 설정
	$.datepicker.setDefaults($.datepicker.regional['ko']);
	$.datepicker.setDefaults({
		dateFormat: 'yy-mm-dd',
		prevText: '이전 달',
		nextText: '다음 달',
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		dayNames: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		showMonthAfterYear: true,
		yearSuffix: '년',
		showOn: 'button', 
		buttonImage: '/images/egovframework/com/cmm/icon/bu_icon_carlendar.gif',   
		buttonImageOnly: true,
		beforeShow:function(input) {
			$(input).css({
				"position": "relative",
				"z-index": 999999
			});
		}
	});
});

// 현재 시간
function getTime(gbn){
	var theDay = new Date(); 
	var hours = theDay.getHours();
	var minutes = theDay.getMinutes();
	var seconds = theDay.getSeconds();
	
	if(hours < 10) hours = "0" + hours;
	if(minutes < 10) minutes = "0" + minutes;
	if(seconds < 10) seconds = "0" + seconds;
	
	return hours + gbn + minutes + gbn + seconds;
} 

// 현재 날짜
function getToday(type){
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	if(month < 10){
		month = "0"+month;
	}
	if(day < 10){
		day = "0"+day;
	}
	var today = '';
	if(type == 'yyyy-mm-dd'){
		today = year + "-" + month + "-" + day;
	} else if (type == 'yyyy-mm') {
		today = year + "-" + month
	} else {
		today = year + "" + month + "" + day;
	}
	
	return today;
}

/* 주간보고용(pDate 날짜가 없다면 현재 날짜 확인 후 해당 주 일요일 기준 플러스, 마이너스 한 날짜 출력,
 * pDate날짜가 있다면 해당 일부터 플러스, 마이너스 한 날짜 출력)
 * 
 * parameter pDate 예시) 2022-09-26
 * parameter pAddDate 예시) -1 or 1
 * return yyyy-mm-dd
 */
function getWeekDay(pDate, pAddDate) {
	let currentDay = new Date();
	let currentYear = currentDay.getFullYear();
	let currentMonth = currentDay.getMonth();
	let currentDate = currentDay.getDate();
	let currentDayOfWeek = currentDay.getDay();
	let resultDay = new Date(currentYear, currentMonth, currentDate - currentDayOfWeek + pAddDate);
	
	// 기준이 되는 날짜가 있다면 기준 날짜로 생성
	if(pDate != '') {
		currentDay = new Date(pDate);
		currentYear = currentDay.getFullYear();
		currentMonth = currentDay.getMonth();
		currentDate = currentDay.getDate();
		
		resultDay = new Date(currentYear, currentMonth, currentDate + pAddDate);
	}
	
	
	let yyyy = resultDay.getFullYear();
	let mm = Number(resultDay.getMonth()) + 1;
	let dd = resultDay.getDate();
	
	mm = String(mm).length === 1 ? '0' + mm : mm;
	dd = String(dd).length === 1 ? '0' + dd : dd;
	
	let rtnStr = yyyy + '-' + mm + '-' + dd;
	
	return rtnStr;
}

/* 월간보고용(현재 월에 시작과 끝 출력)
 * parameter pDate 예시) 2022-09-26
 * parameter pAddDate 예시) -1 or 1
 * parameter pGubun 예시) 'S' or 'E'
 * return yyyy-mm-dd
 */
function getOneMonthStartEndDay(pDate, pAddDate, pGubun) {
	let currentDay = new Date();
	let currentYear = currentDay.getFullYear();
	let currentMonth = currentDay.getMonth() + 1 + pAddDate;
	let tempDate = '';
	let resultDate = '';
	
	// 기준이 되는 날짜가 있다면 기준 날짜로 생성
	if(pDate != '') {
		currentDay = new Date(pDate);
		currentYear = currentDay.getFullYear();
		currentMonth = currentDay.getMonth() + 1 + pAddDate;
	}
	
	// 월 한자리일 경우 두자리로 생성
	currentMonth = String(currentMonth).length === 1 ? '0' + currentMonth : currentMonth;
	// 마지막 날짜
	tempDate = new Date(currentYear, currentMonth, 0).getDate();
	
	if(pGubun == 'E') {
		// 월에 마지막 날
		resultDate = currentYear + "-" + currentMonth + "-" + tempDate;
	} else {
		// 월에 첫번째 날
		resultDate = currentYear + "-" + currentMonth + "-" + "01";
	}
	
	return resultDate;
}