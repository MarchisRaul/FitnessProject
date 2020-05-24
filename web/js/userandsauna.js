
$(document).ready(function()    {
	
	var $nameOfUser = $('#nameOfUser');
	var $saunaId = $('#saunaId');
	var $response_info = $('#response_info');
	
    $("#join_sauna_post_request").click(function(e)    {
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/addUserToSauna',
			data: {nameOfUser: $nameOfUser.val(), saunaId: parseInt($saunaId.val(), 10)},
			dataType: 'text',
            success: function(data){
				$response_info.append('<li>Result: ' + data + '</li>');
			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});


