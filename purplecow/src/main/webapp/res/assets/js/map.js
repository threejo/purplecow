/**
 * 
 */
 
/*var mapContainer = document.getElementById('map');// 지도를 표시할 div 
var mapOptions = {
	center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표, 위도,경도로 표시됨 
	level:3  //지도의 확대레벨
}
		
// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 지도 이동시키기 시작 --------------------------------------------
function setCenter() {            
	// 이동할 위도 경도 위치를 생성합니다 
	var moveLatLon = new kakao.maps.LatLng(33.452613, 126.570888);
    
	// 지도 중심을 이동 시킵니다
	map.setCenter(moveLatLon);
}

function panTo() {
	// 이동할 위도 경도 위치를 생성합니다 
	var moveLatLon = new kakao.maps.LatLng(33.450580, 126.574942);
				    
	// 지도 중심을 부드럽게 이동시킵니다
	// 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
	map.panTo(moveLatLon);            
}
// 지도 이동시키기 끝 --------------------------------------------
			
// 지도 레벨 바꾸기 시작 -----------------------------------------
// 지도 레벨을 표시합니다
displayLevel();
			 
// 지도 레벨은 지도의 확대 수준을 의미합니다
// 지도 레벨은 1부터 14레벨이 있으며 숫자가 작을수록 지도 확대 수준이 높습니다
function zoomIn() {        
	// 현재 지도의 레벨을 얻어옵니다
	var level = map.getLevel();
				    
	// 지도를 1레벨 내립니다 (지도가 확대됩니다)
	map.setLevel(level - 1);
				    
	// 지도 레벨을 표시합니다
	displayLevel();
}    
			
function zoomOut() {    
	// 현재 지도의 레벨을 얻어옵니다
	var level = map.getLevel(); 
				    
	// 지도를 1레벨 올립니다 (지도가 축소됩니다)
	map.setLevel(level + 1);
				    
	// 지도 레벨을 표시합니다
	displayLevel(); 
}    
			 
function displayLevel(){
	var levelEl = document.getElementById('maplevel');
	levelEl.innerHTML = '현재 지도 레벨은 ' + map.getLevel() + ' 레벨 입니다.';
}
// 지도 레벨 바꾸기 끝 -----------------------------------------

// 지도 범위 재설정 시작 -----------------------------------------
// 버튼을 클릭하면 아래 배열의 좌표들이 모두 보이게 지도 범위를 재설정합니다 
var points = [
    new kakao.maps.LatLng(33.452278, 126.567803),
    new kakao.maps.LatLng(33.452671, 126.574792),
    new kakao.maps.LatLng(33.451744, 126.572441)
];

// 지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
var bounds = new kakao.maps.LatLngBounds();    

var i, marker;
for (i = 0; i < points.length; i++) {
    // 배열의 좌표들이 잘 보이게 마커를 지도에 추가합니다
    marker =     new kakao.maps.Marker({ position : points[i] });
    marker.setMap(map);
    
    // LatLngBounds 객체에 좌표를 추가합니다
    bounds.extend(points[i]);
}

function setBounds() {
    // LatLngBounds 객체에 추가된 좌표들을 기준으로 지도의 범위를 재설정합니다
    // 이때 지도의 중심좌표와 레벨이 변경될 수 있습니다
    map.setBounds(bounds);
}
// 지도 범위 재설정 끝 -----------------------------------------

//지도 영역 크기 동적 변경하기 시작 ----------------------------------
// 지도를 표시하는 div 크기를 변경하는 함수입니다
function resizeMap() {
    var mapContainer = document.getElementById('map');
    mapContainer.style.width = '650px';
    mapContainer.style.height = '650px'; 
}

function relayout() {    
    
    // 지도를 표시하는 div 크기를 변경한 이후 지도가 정상적으로 표출되지 않을 수도 있습니다
    // 크기를 변경한 이후에는 반드시  map.relayout 함수를 호출해야 합니다 
    // window의 resize 이벤트에 의한 크기변경은 map.relayout 함수가 자동으로 호출됩니다
    map.relayout();
}
//지도 영역 크기 동적 변경하기 끝 ----------------------------------

// 중심 좌표 변경 이벤트 
// 이동 이벤트, 지도 이동시 이동된 화면의 중심 좌표를 가져온다 ( 시작 ) --------------------------
// 마우스 드래그로 지도 이동이 완료되었을 때 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'dragend', function() {        
    
    // 지도 중심좌표를 얻어옵니다 
    var latlng = map.getCenter(); 
    
    var message = '변경된 지도 중심좌표는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('result');  
    resultDiv.innerHTML = message;
    
});
// 이동 이벤트, 지도 이동시 이동된 화면의 중심 좌표를 가져온다 ( 끝 ) --------------------------

// 마커 생성하기 시작 ---------------------------------------------
// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);
// 마커 생성하기 끝  ---------------------------------------------
*/

