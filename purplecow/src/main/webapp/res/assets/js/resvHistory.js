function showResvInfo() {

	//reservationAPI 요청
	$.ajax({
		url: "/reservations/1",
		type: "get",
		success: function(reservations) {

			console.log(reservations);
			
				const table = document.querySelector('table');
				const tbody = document.querySelector('tbody');

			//reservations.forEach((reservation) => {

				//1행
				const tr_01 = document.createElement('tr');

				//차량 정보 가져오기(차종, 유종)
				const td_01 = document.createElement('td');
				td_01.textContent = reservations.cars_id;
				
				//이용시간 가져오기(예약시간, 반납시간, 이용시간)
				const td_02 = document.createElement('td');
				td_02.textContent = reservations.start_time;
				
				//퍼플존 정보 가져오기(퍼플존 위치)
				const td_03 = document.createElement('td');
				td_03.textContent = reservations.zones_id;

				//결제요금 정보 가져오기(대여요금, 결제요금, 주행요금)
				const td_04 = document.createElement('td');
				td_04.textContent = reservations.payments_id;

				//결제카드 정보 가져오기
				const td_05 = document.createElement('td');
				td_05.textContent = reservations.cards_id;
				
				tr_01.appendChild(td_01);
				tr_01.appendChild(td_02);
				tr_01.appendChild(td_03);
				tr_01.appendChild(td_04);
				tr_01.appendChild(td_05);

				tbody.appendChild(tr_01);
				
				//2행
				const tr_02 = table.insertRow();
				
				//차량 정보 가져오기(차종, 유종)
				const td_06 = tr_02.insertCell(0);
				td_06.textContent = reservations.cars_id;
				
				//이용시간 가져오기(예약시간, 반납시간, 이용시간)
				const td_07 = tr_02.insertCell(1);
				td_07.textContent = reservations.start_time;
				
				//퍼플존 정보 가져오기(퍼플존 위치)
				const td_08 = tr_02.insertCell(2);
				td_08.textContent = reservations.zones_id;

				//결제요금 정보 가져오기(대여요금, 결제요금, 주행요금)
				const td_09 = tr_02.insertCell(3);
				td_09.textContent = reservations.payments_id;

				//결제카드 정보 가져오기
				const td_10 = tr_02.insertCell(4);
				td_10.textContent = reservations.cards_id;
				
				tr_02.appendChild(td_06);
				tr_02.appendChild(td_07);
				tr_02.appendChild(td_08);
				tr_02.appendChild(td_09);
				tr_02.appendChild(td_10);

				tbody.appendChild(tr_02);			
				
				

			//});

		},
		error: function() {
			alert("에러다 이놈아");
		}
	});

}


document.addEventListener("DOMContentLoaded", () => {
	showResvInfo();
});

