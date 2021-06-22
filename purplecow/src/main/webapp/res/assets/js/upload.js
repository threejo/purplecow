$("#btnUpload").bind("click", function(event) {
    event.preventDefault();
    
	var form = $("#uploadForm")[0];   
    var data = new FormData(form);
   
    $("#btnUpload").prop('disabled', true);
	
    $.ajax({
        type: "Post",
        enctype: 'multipart/form-data',
        url: "/test", //"/extractText",
        data: data,
        processData: false,
        contentType: 'application/json',
        cache: false,
        timeout: 600000,
        success: function (response) {
        	$("#btnUpload").prop('disabled', false);
        	alert('success')
        },
        error: function (e) {
            $("#btnUpload").prop('disabled', false);
            alert('fail');
        }
    });
})