function startSomething() {
	var x_auth_token = getCookie('x-auth-token');
	console.log(x_auth_token);

	//API 요청
	$.ajax({
		url: "api/v1/users",
		type: "get",
		beforeSend: function(xhr) {
			xhr.setRequestHeader("x-auth-token", x_auth_token);
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		},
		success: function(user) {
			console.log("ajax결과는" + JSON.stringify(user));


			if (user.name != null) {
				$("#signupbtn1").hide();
				$("#signinbtn1").empty();
				$("#signinbtn1").text("♥"+user.name + "님 환영합니다!♥");
				$("#signinbtn1").css("color", "white");
			}






		},
		error: function() {
			console.log("에러다 이놈아");
			var link = document.getElementById("purplecow_start");
			link.setAttribute("href", "/login");
		}
	});

}


document.addEventListener("DOMContentLoaded", () => {
	startSomething();
});

function getCookie(cookieName) {
	var cookieValue = null;
	console.log("cookie의 값은" + document.cookie);
	if (document.cookie) {
		var array = document.cookie.split((escape(cookieName) + '='));
		if (array.length >= 2) {
			var arraySub = array[1].split(';');
			cookieValue = unescape(arraySub[0]);
		}
	}
	return cookieValue;
}