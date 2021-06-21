$('#btnUpload').on('click', function(event) {
    event.preventDefault();
    
    var form = $('#uploadForm')[0]
    var data = new FormData(form);
    
    $('#btnUpload').prop('disabled', true);
	
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/extractText",
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	$('#btnUpload').prop('disabled', false);
        	alert('success')
        },
        error: function (e) {
            $('#btnUpload').prop('disabled', false);
            alert('fail');
        }
    });
})