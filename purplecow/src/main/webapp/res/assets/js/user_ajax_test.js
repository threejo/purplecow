$("#submit").bind("click", function() {
	var data = {
                "name": $('input[name="name"]').val(),
                "email": $('input[name="email"]').val(),
                "password": $('input[name="password"]').val(),
                "check": $('input[name="check"]').val()
                
        }
    //    alert("데이터입력 성공" + data.email + data.password  );
	$.ajax({
		url: "/users",
		type: "post",
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function() {
			alert("성공이다 이놈아" + data.name + data.email + data.password + data.check );
		},
		error: function() {
			alert("에러다 이놈아"+ data.name + data.email + data.password + data.check);
		}
	});
});
