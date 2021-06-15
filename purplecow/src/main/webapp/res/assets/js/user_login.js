$("#submit").bind("click", function() {
	var data = {
      
                "email": $('input[name="email"]').val(),
                "password": $('input[name="password"]').val()
                
                
        }
        alert("데이터입력 성공" + data.email + data.password  );
	$.ajax({
		url: "/users/email/{email}",
		type: "get",
		contentType: 'string', //'application/json',
		data: data.email,
		success: function(item) {
			alert("정보 로딩 성공" + item.email + item.password  );
			if(item.password == data.password)
				alert("로그인 성공"  );
			else
				alert("로그인 실패");	
		},
		error: function() {
			alert("에러" );
		}
	});
});
