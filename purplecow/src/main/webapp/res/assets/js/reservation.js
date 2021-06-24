/*
 이건 카카오 지도에 관련된 js 파일임
*/
var mapContainer = document.getElementById('map'); // 지도를 표시할 div 
var lat = 33.450701, lon = 126.570667;


// HTML5의 geolocation으로 사용할 수 있는지 확인합니다
// 사용할 수 있으면 내 위치를 맵 시작위치로, 아니면 카카오 본사를
if (navigator.geolocation) {
			    
	// GeoLocation을 이용해서 접속 위치를 얻어옵니다
	navigator.geolocation.getCurrentPosition( function(position) {
			       
		lat = position.coords.latitude, // 위도
		lon = position.coords.longitude; // 경도
		console.log(lat,lon,' ' + "현재위치~")
	});
	console.log(lat,lon)
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
			    
	lat = 33.450701, // 위도
	lon = 126.570667; // 경도
}
console.log(lat,lon, ' ' + "if문 끝나고 위도 경도")
var mapOption = { 
	center: new kakao.maps.LatLng(lat, lon), // 지도의 중심좌표
	level: 3 // 지도의 확대 레벨
	//console.log(lat,lon, ' ' + "if문 끝나고 위도 경도") 여기서 위,경도가 안불러짐
	};
			
// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
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
						

// 중심 좌표 변경 이벤트 
// 이동 이벤트, 지도 이동시 이동된 화면의 중심 좌표를 가져온다 ( 시작 ) --------------------------
// 마우스 드래그로 지도 이동이 완료되었을 때 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'dragend', function() {        
			    
    // 지도 중심좌표를 얻어옵니다 
    var latlng = map.getCenter(); 
    
    var resultDiv = document.getElementById('result');  
    
});
// 이동 이벤트, 지도 이동시 이동된 화면의 중심 좌표를 가져온다 ( 끝 ) --------------------------

// 마커 생성하기 시작 ---------------------------------------------
// 마커가 표시될 위치입니다 
/* var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
}); */

// 마커가 지도 위에 표시되도록 설정합니다
/* marker.setMap(map); */

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);
// 마커 생성하기 끝  ---------------------------------------------
			
// 마커를 표시할 위치와 title 객체 배열입니다 
var positions = [
	{
		title: '카카오', 
		latlng: new kakao.maps.LatLng(33.450705, 126.570677)
	},
	{
		title: '생태연못', 
		latlng: new kakao.maps.LatLng(33.450936, 126.569477)
	},
	{
		title: '텃밭', 
		latlng: new kakao.maps.LatLng(33.450879, 126.569940)
	},
	{
		title: '근린공원',
		latlng: new kakao.maps.LatLng(33.451393, 126.570738)
	}
];
			
// 마커 이미지의 이미지 주소입니다
//var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
			    
for (var i = 0; i < positions.length; i ++) {
			    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
	    
    // 마커 이미지를 생성합니다    
    //var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
	    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        //image : markerImage // 마커 이미지 
    });
}
			
			
/* 마커 클러스터러 ( 마커 모음, 지도 축소시 몇개~ 라고 표시하는거)
마커 클러스터러를 생성합니다
마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다 */
/*var clusterer = new kakao.maps.MarkerClusterer({
	map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
	averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
	minLevel: 10, // 클러스터 할 최소 지도 레벨
	disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
});*/
		
// 데이터를 가져오기 위해 jQuery를 사용합니다
// 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
$.get("/download/web/data/chicken.json", function(data) {
	// 데이터에서 좌표 값을 가지고 마커를 표시합니다
	// 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
	var markers = $(data.positions).map(function(i, position) {
		return new kakao.maps.Marker({
			position : new kakao.maps.LatLng(position.lat, position.lng)
		});
	});
		
	// 클러스터러에 마커들을 추가합니다
	clusterer.addMarkers(markers);
});
		
// 마커 클러스터러에 클릭이벤트를 등록합니다
// 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
// 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
/*kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {
		
	// 현재 지도 레벨에서 1레벨 확대한 레벨
	var level = map.getLevel()-1;
			
	// 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
	map.setLevel(level, {anchor: cluster.getCenter()});
});*/