window.onload = function() {

	$("#show-info").on("click", function() {


		$.ajax({
			url: "/users/accountMgt/6",
			type: "get",
			contentType: 'application/json',
			success: function(data) {

				console.log(data)
				alert("성공");


			},
			error: function() {
				alert("에러");
			}

		});

	});

}


