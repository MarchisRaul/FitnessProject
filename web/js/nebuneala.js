$(document).ready(function()    {
	
	var $my_clients = $('#my_clients');
	
    $("#request_all_users_get").click(function(e)    {
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/getUsers',
			dataType: 'json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
                $.each(data, function (i, user) {
					$my_clients.append('<li>name: ' + user.name + ', age: ' + user.age + '</li>');
                })
			},
            error: function(){
                $("#clients").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id = $('#id');
	var $my_clients = $('#my_clients');
	
    $("#request_get_user_by_id").click(function(e)    {
		
		var userId = {
			id: parseInt($id.val(), 10),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/findUserById',
			data: userId,
			dataType: 'json',
            success: function(data){
				$my_clients.append('<li>name: ' + data.name + ', age: ' + data.age + '</li>');
			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $name = $('#nameOfUser');
	var $my_clients = $('#my_clients');
	
    $("#request_get_user_by_name").click(function(e)    {
		
		var userName = {
			name: $name.val(),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/findUserByName',
			data: userName,
			dataType: 'json',
            success: function(data){
				$my_clients.append('<li>name: ' + data.name + ', age: ' + data.age + '</li>');
			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_user = $('#id_user');
	var $name = $('#name');
	var $id_trainer_fkk = $('#id_trainer_fkk');
	var $age = $('#age');
	var $card_type = $('#card_type');
	var $free_saunas_info = $('#free_saunas_info');
	var $id_sauna_fk = $('#id_sauna_fk');
	var $money_card = $('#money_card');
	
	var $my_clients = $('#my_clients');
	
    $("#request_insert_client").click(function(e)    {
		
		var userObject = {
			id_user: parseInt($id_user.val(), 10),
			name: $name.val(),
			id_trainer_fkk: parseInt($id_trainer_fkk.val(), 10),
			age: parseInt($age.val(), 10),
			card_type: $card_type.val(),
			free_saunas_info: $free_saunas_info.val(),
			id_sauna_fk: parseInt($id_sauna_fk.val(), 10),
			money_card: parseInt($money_card.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/insertUser',
			data: JSON.stringify(userObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
				$my_clients.append('<li>Response: ' + data + '</li>'); 
			},
            error: function(){
                $("#clients").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_user = $('#id_user');
	var $name = $('#name');
	var $id_trainer_fkk = $('#id_trainer_fkk');
	var $age = $('#age');
	var $card_type = $('#card_type');
	var $free_saunas_info = $('#free_saunas_info');
	var $id_sauna_fk = $('#id_sauna_fk');
	var $money_card = $('#money_card');
	
	var $my_clients = $('#my_clients');
	
    $("#request_delete_client").click(function(e)    {
		
		var userObject = {
			id_user: parseInt($id_user.val(), 10),
			name: $name.val(),
			id_trainer_fkk: parseInt($id_trainer_fkk.val(), 10),
			age: parseInt($age.val(), 10),
			card_type: $card_type.val(),
			free_saunas_info: $free_saunas_info.val(),
			id_sauna_fk: parseInt($id_sauna_fk.val(), 10),
			money_card: parseInt($money_card.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/deleteUser',
			data: JSON.stringify(userObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
                //$.each(dataa, function (i, user) {
				$my_clients.append('<li>Response: ' + data + '</li>');
                //})
			},
            error: function(){
                $("#clients").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_user = $('#id_user');
	var $name = $('#name');
	var $id_trainer_fkk = $('#id_trainer_fkk');
	var $age = $('#age');
	var $card_type = $('#card_type');
	var $free_saunas_info = $('#free_saunas_info');
	var $id_sauna_fk = $('#id_sauna_fk');
	var $money_card = $('#money_card');
	
	var $my_clients = $('#my_clients');
	
    $("#request_update_client").click(function(e)    {
		
		var userObject = {
			id_user: parseInt($id_user.val(), 10),
			name: $name.val(),
			id_trainer_fkk: parseInt($id_trainer_fkk.val(), 10),
			age: parseInt($age.val(), 10),
			card_type: $card_type.val(),
			free_saunas_info: $free_saunas_info.val(),
			id_sauna_fk: parseInt($id_sauna_fk.val(), 10),
			money_card: parseInt($money_card.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/updateUser',
			data: JSON.stringify(userObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
				$my_clients.append('<li>Response: ' + data + '</li>');
			},
            error: function(){
                $("#clients").html("error")
            }
		
        });
    });


});



