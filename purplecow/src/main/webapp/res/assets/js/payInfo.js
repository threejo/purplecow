function showPayInfo() {
	
	//userAPI 요청
	$.ajax({
		url: "/users/6",
		type: "get",		
		success: function(user) {
			console.log(user);

			//카드정보 가져오기
			document.getElementById("ajax_cardid").innerHTML = user.card_id;
			//운전면허 정보 가져오기
			document.getElementById("ajax_licenseid").innerHTML = user.license_id;
			
		},
		error: function() {
			alert("에러다 이놈아");
		}
	});
	
}


document.addEventListener("DOMContentLoaded", ()=>{

	showPayInfo();
});

