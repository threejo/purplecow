$("#login_btn").on("click", function() {
	console.log("하이 클릭?");
	var data = {
		"email": $('input[name="email"]').val(),
		"password": $('input[name="password"]').val()
	}
	$.ajax({
		url: "/api/v1/login",
		type: "post",
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function(result) {
			setCookie('x-auth-token', result.message, {secure: true, 'max-age': 3600,httponly: true});
			window.location.href ="/";

		},
		error: function(e) {
			alert("로그인에 실패하셨습니다!");
			window.location.reload();
		}
	});
});

function setCookie(name, value, options = {}) { 

  options = {
    path: '/',
    // 필요한 경우, 옵션 기본값을 설정할 수도 있습니다.
    ...options
  };

  if (options.expires instanceof Date) {
    options.expires = options.expires.toUTCString();
  }

  let updatedCookie = encodeURIComponent(name) + "=" + encodeURIComponent(value);

  for (let optionKey in options) {
    updatedCookie += "; " + optionKey;
    let optionValue = options[optionKey];
    if (optionValue !== true) {
      updatedCookie += "=" + optionValue;
    }
  }

  document.cookie = updatedCookie;
}


