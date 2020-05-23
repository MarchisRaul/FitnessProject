$(document).ready(function()    {
	
	var $nameOfTrainer = $('#nameOfTrainer');
	
	var $my_users = $('#my_users');
	
    $("#request_all_users_for_trainer_get").click(function(e)    {
		
		var trainerName = {
			nameOfTrainer: $nameOfTrainer.val(),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/getUsersForTrainer',
			data: trainerName,
			contentType: 'application/json',
            success: function(data){
				$my_users.append('<li>' + data + '</li>');		
			},
            error: function(){
                $("#name").html("error")
            }
		
        });
    });


});





