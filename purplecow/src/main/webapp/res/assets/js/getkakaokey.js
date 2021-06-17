window.onload = function() {

	$.ajax({
		url: "/getkey",
		type: "get",
		contentType: 'application/json',
		success: function(item) {
			alert("정보 로딩 성공" + item.key );
			
		},
		error: function() {
			alert("에러" );
		}
	});
};