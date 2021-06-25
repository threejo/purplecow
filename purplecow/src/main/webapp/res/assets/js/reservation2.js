 function showZoneList() {
	var tbody = document.querySelector("tbody");
	
	
	//zoneAPI 요청
	$.ajax({
		url: "/zones",
		type: "get",		
		success: function(zones) {
			console.log(zones);
				zones.forEach((zone)=>{
				const tr = document.createElement("tr");
				tr.onclick = function(){
					location.href='/carList';
				};
				//퍼플존 id 가져오기
				const th = document.createElement("th");
				th.textContent = zone.id;
				tr.appendChild(th);
				
				//퍼플존 이름 가져오기
				const th2 = document.createElement("th");
				th2.textContent = zone.name;
				tr.appendChild(th2);
				//퍼플존 주소 가져오기
				const td3 = document.createElement("td");
				td3.textContent = zone.address;
				tr.appendChild(td3);
			

				tbody.appendChild(tr);
			});
			
		},
		error: function() {
			alert("에러다 이놈아");
		}
	});
	
}

document.addEventListener("DOMContentLoaded", ()=>{
	showZoneList();
});
