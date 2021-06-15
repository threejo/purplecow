$("#submit").bind("click", function() {
	var data = {
               
                "email": $('input[name="email"]').val(),
                "password": $('input[name="password"]').val(),
                
                
        }
	$.ajax({
		url: "/users/{email}",
		type: "get",
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function() {
	//		if(item.password == data.password)
				alert("로그인 성공" + data.email + data.password  );
	//		else
		//		alert("로그인 실패"+  data.email + data.password );	
		},
		error: function() {
			alert("에러"+  data.email + data.password );
		}
	});
});
