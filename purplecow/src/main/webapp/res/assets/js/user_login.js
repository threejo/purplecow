$("#submit").bind("click", function() {
	var data = {
      
                "email": $('input[name="email"]').val(),
                "password": $('input[name="password"]').val()
                
                
        }
        alert("데이터입력 성공" + data.email + data.password  );
      
	$.ajax({
		url: "/users/login/" + data.email,
		type: "get",
		contentType: 'application/json',
		//data: data.eamil,
		success: function(item) {
			alert("정보 로딩 성공"  );
			if(item.password == data.password)
				alert("로그인 성공" );
			else
				alert("로그인 실패");	
		},
		error: function() {
			alert("에러" );
		}
	});
});
