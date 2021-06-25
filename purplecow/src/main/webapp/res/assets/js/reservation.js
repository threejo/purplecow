/*
 이건 카카오 지도에 관련된 js 파일임
*/

var mapContainer = document.getElementById('map'); // 지도를 표시할 div 
var lat = 33.450701, lon = 126.570667;

// GeoLocation을 이용해서 접속 위치를 얻어옵니다
navigator.geolocation.getCurrentPosition( function(position) {
	lat = position.coords.latitude, // 위도
	lon = position.coords.longitude; // 경도
});

var mapOption = { 
	center: new kakao.maps.LatLng(lat, lon), // 지도의 중심좌표
	level: 3 // 지도의 확대 레벨
	};
			
// 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// 지도 이동시키기 시작 --------------------------------------------
function panTo() {
	
	// 이동할 위도 경도 위치를 생성합니다 
	var moveLatLon = new kakao.maps.LatLng(lat, lon);
				    
	// 지도 중심을 부드럽게 이동시킵니다
	// 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
	map.panTo(moveLatLon);
}
// 지도 이동시키기 끝 --------------------------------------------

 $.ajax({
   url: '/zones',
   type: 'GET',
   dataType: 'json',
   success: function(data){
		/* 마커 클러스터러 ( 마커 모음, 지도 축소시 몇개~ 라고 표시하는거)
		마커 클러스터러를 생성합니다
		마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
		클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
		이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
		클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다 */
        var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 10, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
       });
        
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        var markers = $(data).map(function(i, zones) {
            
            return new kakao.maps.Marker({
                position : new kakao.maps.LatLng(zones.latitude, zones.longitude)
            });
        });

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
		
        // 마커 클러스터러에 클릭이벤트를 등록합니다
        // 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
        // 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
        kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

            // 현재 지도 레벨에서 1레벨 확대한 레벨
            var level = map.getLevel()-1;

            // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
            map.setLevel(level, {
                anchor: cluster.getCenter()
            });
      });
        
   },
       error: function() {
         console.log("에러임")
   }
});


	// 주소를 좌표로 바구기 위한 geocoder 생성
	var geocoder = new kakao.maps.services.Geocoder();
    
    function kakaoPostcode() {
		console.log("실행되냐?");
        new kakao.Postcode({
            oncomplete: function(search) {
                var addr = search.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("search_address").value = addr;
                // 주소로 상세 정보를 검색
                geocoder.addressSearch(search.address, function(results, status) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === kakao.maps.services.Status.OK) {

                        var result = results[0]; //첫번째 결과의 값을 활용

                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new kakao.maps.LatLng(result.y, result.x);
                        // 지도를 보여준다.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                       
                    }
                });
            }
        }).open();
    }
		