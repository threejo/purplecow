const browseBtn = document.querySelector('.browse-btn');
const realInput = document.querySelector('#real-input');
const imagePreview = document.querySelector('#imagePreview');
const img_num = 4;
//browseBtn이 클릭되면 realInput이 클릭됨.
browseBtn.addEventListener('click', () => {
	realInput.click();
});
//input태그에 변화가 생기면 readInputFile함수가 실행됨.
$('#real-input').on('change', readInputFile);
//파일 읽어와서 그려주는 함수
function readInputFile(e) {
	var sel_files = [];
	//input 태그에 있는 이미지 목록,fileList안에 배열형태로 파일에 대한 정보
	var files = e.target.files;
	//files를 Array(배열)로 변환
	var fileArr = Array.prototype.slice.call(files);
	//위에서 만들 배열을 순회
	fileArr.forEach(function(f) {
		//들어온 파일의 타입확인
		if (!f.type.match("image/.*")) {
			alert("이미지 확장자만 업로드 가능합니다.");
			return;
		};
		//fileList 길이가 4이 넣지 않으면(선택한 파일 수가 3개 이하이면)
		if (files.length < img_num) {
			//처음에 만들어 놓은 배열에 값 넣기
			sel_files.push(f);
			//이미지를 그려줄 reader 생성
			var reader = new FileReader();
			reader.onload = function(e) {
				//해당 이미지를 img태그에 넣기
				const div = document.createElement('div');
				div.setAttribute('id','preview_div');
				div.setAttribute('class','preview');
				div.setAttribute('style','border:4px solid #F067FF;border-radius:30%;overflow: hidden;display: inline-block;margin: 0px 10px;');
				var img = document.createElement('img');
				img.setAttribute('class','preview_img');
				img.setAttribute('src',e.target.result);
				img.setAttribute('data-file',f.name);
				img.setAttribute('style','object-fit:cover;width:100%;height:100%;');
				div.appendChild(img);
				//겉을 감싸고 있는 태그에 img태그 붙이기
				$('#imagePreview').append(div);
			};
			reader.readAsDataURL(f);
		}
		//정해진 길이보다 길 경우
		if (files.length > img_num) {
			alert("최대 3장까지 업로드 할 수 있습니다.");
		}
	})
}

//ajax 요청하는 함수

$("#ajax_btn").on("click", function() {
	var data1 = {
                "park_fixed": $('input[name="park_fixed"]:checked').val()
        }
	$.ajax({
		url: "/reservations/1",
		type: "put",
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function(data) {
			alert("성공이다 이놈아");
		},
		error: function() {
			alert("에러다 이놈아");
		}
	});
});
