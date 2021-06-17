function startSomething() {
	
	//userAPI 요청
	$.ajax({
		url: "/users/accountMgt/6",
		type: "get",		
		success: function(user) {
			console.log(user);
			
			
			
			document.getElementById('#ajax_username').innerHTML="user.name";
			$('#ajax_username').innerHTML = user.name;
			$('#ajax_email').innerHTML = user.email;
			$('#ajax_phone').innerHTML = user.phone_no;
			
		},
		error: function() {
			alert("에러다 이놈아");
		}
	});
	
}


document.addEventListener("DOMContentLoaded", ()=>{
	startSomething();
});

