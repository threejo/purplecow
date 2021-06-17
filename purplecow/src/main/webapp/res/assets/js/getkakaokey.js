window.onload = function() {

	$.ajax({
		url: "/getkey",
		type: "get",
		contentType: 'String',
		success: function(item) {
			alert("정보 로딩 성공" + item );
			
		},
		error: function() {
			alert("에러"+ item.key + item );
		}
	});
};