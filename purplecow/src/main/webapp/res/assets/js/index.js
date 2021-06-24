/*function startSomething() {
	//var tbody = document.querySelector("tbody");
	
	//carAPI 요청
	$.ajax({
		url: "/cars/list",
		type: "get",		
		success: function(cars) {
			
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
				
				tbody.appendChild(tr);
			});
			
		},
		error: function() {
			alert("에러다 이놈아");
		}
	});
	
}


document.addEventListener("DOMContentLoaded", ()=>{
	startSomething();
});

*/