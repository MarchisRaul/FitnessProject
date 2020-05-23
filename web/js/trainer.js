$(document).ready(function()    {
	
	var $my_trainers = $('#my_trainers');
	
    $("#request_all_trainers_get").click(function(e)    {
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/getTrainers',
			dataType: 'json',
            success: function(data){
				console.log(data);
                var str="";
                $.each(data, function (i, trainer) {
					var hasDiploma = "";
					if (trainer.university_diploma === 1)
						hasDiploma = "Finished sport university";
					else
						hasDiploma = "Did not finish any university";
					$my_trainers.append('<li>name: ' + trainer.name + ', diploma: ' + hasDiploma + ', price: ' + trainer.training_price + '</li>');
                })
			},
            error: function(){
                $("#trainers").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id = $('#id');
	var $my_trainers = $('#my_trainers');
	
    $("#request_get_trainer_by_id").click(function(e)    {
		
		var trainerId = {
			id: parseInt($id.val(), 10),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/findTrainerById',
			data: trainerId,
			dataType: 'json',
            success: function(data){
				var hasDiploma = "";
					if (data.university_diploma === 1)
						hasDiploma = "Finished sport university";
					else
						hasDiploma = "Did not finish any university";
				$my_trainers.append('<li>name: ' + data.name + ', diploma: ' + hasDiploma + ', price: ' + data.training_price + '</li>');
			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $name = $('#nameOfTrainer');
	var $my_trainers = $('#my_trainers');
	
    $("#request_get_trainer_by_name").click(function(e)    {
		
		var userName = {
			name: $name.val(),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/findTrainerByName',
			data: userName,
			dataType: 'json',
            success: function(data){
				var hasDiploma = "";
					if (data.university_diploma === 1)
						hasDiploma = "Finished sport university";
					else
						hasDiploma = "Did not finish any university";
				$my_trainers.append('<li>name: ' + data.name + ', diploma: ' + hasDiploma + ', price: ' + data.training_price + '</li>');
			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_trainer_pk = $('#id_trainer_pk');
	var $name = $('#name');
	var $university_diploma = $('#university_diploma');
	var $training_price = $('#training_price');
	
	var $my_trainers = $('#my_trainers');
	
    $("#request_insert_trainer").click(function(e)    {
		
		var trainerObject = {
			id_trainer_pk: parseInt($id_trainer_pk.val(), 10),
			name: $name.val(),
			university_diploma: parseInt($university_diploma.val(), 10),
			training_price: parseInt($training_price.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/insertTrainer',
			data: JSON.stringify(trainerObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
				$my_trainers.append('<li>Response: ' + data + '</li>'); 
			},
            error: function(){
                $("#trainers").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_trainer_pk = $('#id_trainer_pk');
	var $name = $('#name');
	var $university_diploma = $('#university_diploma');
	var $training_price = $('#training_price');
	
	var $my_trainers = $('#my_trainers');
	
    $("#request_delete_trainer").click(function(e)    {
		
		var trainerObject = {
			id_trainer_pk: parseInt($id_trainer_pk.val(), 10),
			name: $name.val(),
			university_diploma: parseInt($university_diploma.val(), 10),
			training_price: parseInt($training_price.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/deleteTrainer',
			data: JSON.stringify(trainerObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
                //$.each(dataa, function (i, user) {
				$my_trainers.append('<li>Response: ' + data + '</li>');
                //})
			},
            error: function(){
                $("#trainers").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_trainer_pk = $('#id_trainer_pk');
	var $name = $('#name');
	var $university_diploma = $('#university_diploma');
	var $training_price = $('#training_price');
	
	var $my_trainers = $('#my_trainers');
	
    $("#request_update_trainer").click(function(e)    {
		
		var trainerObject = {
			id_trainer_pk: parseInt($id_trainer_pk.val(), 10),
			name: $name.val(),
			university_diploma: parseInt($university_diploma.val(), 10),
			training_price: parseInt($training_price.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/updateTrainer',
			data: JSON.stringify(trainerObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
				$my_trainers.append('<li>Response: ' + data + '</li>');
			},
            error: function(){
                $("#trainers").html("error")
            }
		
        });
    });


});



