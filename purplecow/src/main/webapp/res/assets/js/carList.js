 function showCarsList() {
   var tbody = document.querySelector("tbody");
   
   
   //carAPI 요청
   $.ajax({
      url: "/cars/2",
      type: "get",      
      success: function(cars) {
         console.log(cars);
         cars.forEach((car)=>{
            const tr = document.createElement("tr");
            
            //모델명 가져오기
            const th = document.createElement("th");
            th.textContent = car.name;
            tr.appendChild(th);
            //차급 가져오기
            const td2 = document.createElement("td");
            td2.textContent = car.scale;
            tr.appendChild(td2);
            //km당 주행요금 가져오기
            const td3 = document.createElement("td");
            td3.textContent = car.driving_fee_per_km;
            tr.appendChild(td3);
            //일일 주행요금 가져오기
            const td4 = document.createElement("td");
            td4.textContent = car.daily_rental_fee;
            tr.appendChild(td4);
            //라디오버튼으로 선택하기
            const td5 = document.createElement("td");
            var input = document.createElement("input");
            input.setAttribute("type","radio");
            input.setAttribute("name","carList");
            input.setAttribute("value",car.id);
            
            td5.appendChild(input);
            tr.appendChild(td5);
            tbody.appendChild(tr);
         });
         
      },
      error: function() {
         alert("에러다 이놈아");
      }
   });
   
}


document.addEventListener("DOMContentLoaded", ()=>{
   showCarsList();
});


$('#modal_btn').click(function(){
	var carnum =  $('input[name="carList"]:checked').val();
	
	
	
	$.ajax({
		url: '/reservations/'+carnum, 
		type: 'POST',
		dataType: 'json',
		/*contentType: '',*/
		
		success: function() {
			/*데이터 전송 성공시 실행문구*/
			alert("차량 예약정보 생성 성공");
			
									
		}, error: function(){
			alert("실패");
		
		}
	})
	
	$.ajax({
		url: '/cars/cars_id/' + carnum, 
		type: 'GET',
		dataType: 'json',
		/*contentType: '',*/
		
		success: function(data) {
			/*데이터 전송 성공시 실행문구*/
			alert("차량 정보 id로 가져오기 성공" + data);
			
									
		}, error: function(){
			alert("차량 정보 id로 가져오기 실패");
		
		}
	})
	
})


 
