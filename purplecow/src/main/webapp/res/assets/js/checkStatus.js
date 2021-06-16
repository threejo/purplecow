const browseBtn = document.querySelector('.browse-btn');
const realInput = document.querySelector('#real-input');
const imagePreview = document.querySelector('#imagePreview');

//browseBtn이 클릭되면 realInput이 클릭됨.
browseBtn.addEventListener('click', () => {
	realInput.click();
});

function readInputFile(e) {
	var sel_files = [];

	
	//$('#imagePreview').empty();

	//input 태그에 있는 이미지 목록,fileList안에 배열형태로 파일에 대한 정보
	var files = e.target.files;
	//files를 Array(배열)로 변환
	var fileArr = Array.prototype.slice.call(files);

	var index = 0;

	fileArr.forEach(function(f) {
		//들어온 파일의 타입확인
		if (!f.type.match("image/.*")) {
			alert("이미지 확장자만 업로드 가능합니다.");
			return;
		};
		//fileList 길이가 11이 넣지 않으면(선택한 파일 수가 10개 이하이면)
		if (files.length < 11) {
			//처음에 만들어 놓은 배열에 값 넣기
			sel_files.push(f);

			//이미지를 그려줄 reader 생성
			var reader = new FileReader();

			reader.onload = function(e) {

				
				var $img = $(`<img src="${e.target.result}" data-file="${f.name}" class="preview" style="padding: 20px"/>`);
				
				
				$('#imagePreview').append($img);
				
				index++;
			};
			reader.readAsDataURL(f);
		}

	})
	if (files.length > 11) {
		alert("최대 10장까지 업로드 할 수 있습니다.");
	}
}

//input태그에 변화가 생기면 readInputFile함수가 실행됨.
$('#real-input').on('change', readInputFile);