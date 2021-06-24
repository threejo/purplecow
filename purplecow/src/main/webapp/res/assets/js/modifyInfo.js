

function showUserInfo() {
	
	//userAPI 요청
	$.ajax({
		url: "/users/test1@test.com",
		type: "get",		
		success: function(user) {
			console.log(user);

			//이름 가져오기
			document.getElementById("name").value = user.name;
			//이메일 가져오기
			document.getElementById("email").value = user.email;
			//핸드폰 번호 가져오기
			document.getElementById("phoneNumber").value = user.phone_no;		
			
		},
		error: function() {
			alert("에러다 이놈아");
		}
	});
	
}


document.addEventListener("DOMContentLoaded", ()=>{

	showUserInfo();
});

$("#modifyButton").on("click", function() {
	
	$.ajax({
		url: "/users/test1@test.com",
		type: "put",
		contentType: 'application/json',
		dataType: 'json',
		success: function() {
			alert("성공이다 이놈아");
		},
		error: function() {
			alert("에러다 이놈아");
		}
	});
});



