$(document).ready(function()    {
	
	var $my_saunas = $('#my_saunas');
	
    $("#request_all_saunas_get").click(function(e)    {
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/getSaunas',
			dataType: 'json',
            success: function(data){
				console.log(data);
                var str="";
                $.each(data, function (i, sauna) {
					var isOccupied = "";
					if (sauna.occupied === 1)
						isOccupied = "Sauna is full";
					else
						isOccupied = "Sauna is not full";
					$my_saunas.append('<li>id_sauna ' + sauna.id_sauna + ', state: ' + isOccupied + ', session_time: ' + sauna.session_time + ', size_number: ' + sauna.size_number  + '</li>');
                })
			},
            error: function(){
                $("#saunas").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id = $('#id');
	var $my_saunas = $('#my_saunas');
	
    $("#request_get_sauna_by_id").click(function(e)    {
		
		var saunaId = {
			id: parseInt($id.val(), 10),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/findSaunaById',
			data: saunaId,
			dataType: 'json',
            success: function(data){
				var isOccupied = "";
				if (data.occupied === 1)
					isOccupied = "Sauna is full";
				else
					isOccupied = "Sauna is not full";
				$my_saunas.append('<li>id_sauna ' + data.id_sauna + ', state: ' + isOccupied + ', session_time: ' + data.session_time + ', size_number: ' + data.size_number  + '</li>');
			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_sauna = $('#id_sauna');
	var $occupied = $('#occupied');
	var $session_time = $('#session_time');
	var $size_number = $('#size_number');
	
	var $my_saunas = $('#my_saunas');
	
    $("#request_insert_sauna").click(function(e)    {
		
		var saunaObject = {
			id_sauna: parseInt($id_sauna.val(), 10),
			occupied: parseInt($occupied.val(), 10),
			session_time: $session_time.val(),
			size_number: parseInt($size_number.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/insertSauna',
			data: JSON.stringify(saunaObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
				$my_saunas.append('<li>Response: ' + data + '</li>'); 
			},
            error: function(){
                $("#saunas").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_sauna = $('#id_sauna');
	var $occupied = $('#occupied');
	var $session_time = $('#session_time');
	var $size_number = $('#size_number');
	
	var $my_saunas = $('#my_saunas');
	
    $("#request_delete_sauna").click(function(e)    {
		
		var saunaObject = {
			id_sauna: parseInt($id_sauna.val(), 10),
			occupied: parseInt($occupied.val(), 10),
			session_time: $session_time.val(),
			size_number: parseInt($size_number.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/deleteSauna',
			data: JSON.stringify(saunaObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
                //$.each(dataa, function (i, user) {
				$my_saunas.append('<li>Response: ' + data + '</li>');
                //})
			},
            error: function(){
                $("#saunas").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_sauna = $('#id_sauna');
	var $occupied = $('#occupied');
	var $session_time = $('#session_time');
	var $size_number = $('#size_number');
	
	var $my_saunas = $('#my_saunas');
	
    $("#request_update_sauna").click(function(e)    {
		
		var saunaObject = {
			id_sauna: parseInt($id_sauna.val(), 10),
			occupied: parseInt($occupied.val(), 10),
			session_time: $session_time.val(),
			size_number: parseInt($size_number.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/updateSauna',
			data: JSON.stringify(saunaObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
				$my_saunas.append('<li>Response: ' + data + '</li>');
			},
            error: function(){
                $("#saunas").html("error")
            }
		
        });
    });


});



