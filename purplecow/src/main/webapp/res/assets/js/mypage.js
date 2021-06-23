function startSomething() {
	
	//userAPI 요청
	$.ajax({
		url: "/users/6",
		type: "get",		
		success: function(user) {
			console.log(user);

			//이름 가져오기
			document.getElementById("ajax_username").innerHTML = user.name;
			//이메일 가져오기
			document.getElementById("ajax_email").innerHTML = user.email;
			//핸드폰 번호 가져오기
			document.getElementById("ajax_phone").innerHTML = user.phone_no;
			
		},
		error: function() {
			alert("에러다 이놈아");
		}
	});
	
}


document.addEventListener("DOMContentLoaded", ()=>{

	startSomething();
});

