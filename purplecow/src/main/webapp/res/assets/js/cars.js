 /**
ajax의 기본 샘플
 
	$.ajax({
		url: "클라이언트의 요청을 보낼 주소(요청 url)",
		dataType:"서버로 부터 받아오는 데이터 타입(서버로부터 어떤 데이터를 받을것인가?)",
		type: "받아올 때의 형식:GET,POST",
		contentType : "클라이언트 요청의 타입",
		data: 클라이언트 요청이나 데이터(내가 전달하고자 하는 데이터),
		success: function(result) {
			데이터 전송 성공시 실행
		}
	},
	error:function(){
		데이터 전송 실패시 실행
	}
});
 */
 
 

/*PurpleCow의 퍼플존을 클릭시 해당 퍼플존에 있는 차 리스트를 가져올거다.*/
$('#purple_zone').click(function(){
	var zones_id = $('#purple_zone').val()
	console.log(zones_id)
	$.ajax({
		url: '/cars/zones_id',
		type: 'get',
		dataType: 'json',
		/*contentType: '',*/
		data: {zones_id: $("#purple_zone").val()},
		success: function(data) {
			/*데이터 전송 성공시 실행문구*/
			console.log(data);
			console.log("성공");
			
			document.getElementById("name").innerHTML = data.name;
			document.getElementById("model_color").innerHTML = data.model_color;
			document.getElementById("oil_type").innerHTML = data.oil_type;
			
			
		}, error: function(){
		console.log(zones_id);
		console.log("에러");
		}
	})
})
 
 