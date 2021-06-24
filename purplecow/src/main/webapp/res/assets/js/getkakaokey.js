window.onload = function() {

	$.ajax({
		url: "/getkey",
		type: "get",
		contentType: 'String',
		success: function(item) {
			var direction = "https://kauth.kakao.com/oauth/authorize?client_id="+ item +"&redirect_uri=http://localhost:8088/kakaologin&response_type=code"
			alert("정보 로딩 성공" );
			document.getElementById("kakao").setAttribute("href", 
			direction);
			
		},
		error: function() {
			alert("에러" );
		}
	});
};



//https://kauth.kakao.com/oauth/authorize?client_id=93f0f6f4970c0e42fd6386051d315ea3&redirect_uri=http://localhost:8088/kakaologin&response_type=code

