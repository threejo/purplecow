 window.onload = function() {
 
    function onClick() {
        document.querySelector('.modal_wrap').style.display ='block';
        document.querySelector('.black_bg').style.display ='block';
       
    }   
    function offClick() {
        document.querySelector('.modal_wrap').style.display ='none';
        document.querySelector('.black_bg').style.display ='none';
    }
 
    document.getElementById('modal_btn').addEventListener('click', onClick);
    document.querySelector('.modal_close').addEventListener('click', offClick);
 
};

$("#radioButton").bind("click", function() {
   var data = {
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


