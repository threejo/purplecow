function restest() {
    $.ajax({
        url:'registration'
        , method : 'GET'
        , success :  function(resp){
            if(resp){
                $('#name').text("전송받은 데이터 : " + resp)
            }
        }
    })	
}