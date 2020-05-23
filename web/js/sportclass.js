$(document).ready(function()    {
	
	var $my_sportclasses = $('#my_sportclasses');
	
    $("#request_all_sportclasses_get").click(function(e)    {
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/getSportClasses',
			dataType: 'json',
            success: function(data){
				console.log(data);
                var str="";
                $.each(data, function (i, sportclass) {
					$my_sportclasses.append('<li>id: ' + sportclass.id_class + ', name: ' + sportclass.name + ', trainer: ' + sportclass.id_trainer_fk + ', month price: ' + sportclass.month_price + ', size: ' + sportclass.size_number + '</li>');
                })
			},
            error: function(){
                $("#my_sportclasses").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id = $('#id');
	var $my_sportclasses = $('#my_sportclasses');
	
    $("#request_get_sportclass_by_id").click(function(e)    {
		
		var sportClassId = {
			id: parseInt($id.val(), 10),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/findSportClassById',
			data: sportClassId,
			dataType: 'json',
            success: function(data){
				$my_sportclasses.append('<li>id: ' + data.id_class + ', name: ' + data.name + ', trainer: ' + data.id_trainer_fk + ', month price: ' + data.month_price + ', size: ' + data.size_number + '</li>');
			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $name = $('#nameOfSportclass');
	var $my_sportclasses = $('#my_sportclasses');
	
    $("#request_get_sportclass_by_name").click(function(e)    {
		
		var sportClassName = {
			name: $name.val(),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/findSportClassByName',
			data: sportClassName,
			dataType: 'json',
            success: function(data){
				$my_sportclasses.append('<li>id: ' + data.id_class + ', name: ' + data.name + ', trainer: ' + data.id_trainer_fk + ', month price: ' + data.month_price + ', size: ' + data.size_number + '</li>');
			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_class = $('#id_class');
	var $name = $('#name');
	var $id_trainer_fk = $('#id_trainer_fk');
	var $month_price = $('#month_price');
	var $size_number = $('#size_number');
	
	var $my_sportclasses = $('#my_sportclasses');
	
    $("#request_insert_sportclass").click(function(e)    {
		
		var sportClassObject = {
			id_class: parseInt($id_class.val(), 10),
			name: $name.val(),
			id_trainer_fk: parseInt($id_trainer_fk.val(), 10),
			month_price: parseInt($month_price.val(), 10),
			size_number: parseInt($size_number.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/insertSportClass',
			data: JSON.stringify(sportClassObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
				$my_sportclasses.append('<li>Response: ' + data + '</li>'); 
			},
            error: function(){
                $("#my_sportclasses").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_class = $('#id_class');
	var $name = $('#name');
	var $id_trainer_fk = $('#id_trainer_fk');
	var $month_price = $('#month_price');
	var $size_number = $('#size_number');
	
	var $my_sportclasses = $('#my_sportclasses');
	
    $("#request_delete_sportclass").click(function(e)    {
		
		var sportClassObject = {
			id_class: parseInt($id_class.val(), 10),
			name: $name.val(),
			id_trainer_fk: parseInt($id_trainer_fk.val(), 10),
			month_price: parseInt($month_price.val(), 10),
			size_number: parseInt($size_number.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/deleteSportClass',
			data: JSON.stringify(sportClassObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
                //$.each(dataa, function (i, user) {
				$my_sportclasses.append('<li>Response: ' + data + '</li>');
                //})
			},
            error: function(){
                $("#sportclasses").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_class = $('#id_class');
	var $name = $('#name');
	var $id_trainer_fk = $('#id_trainer_fk');
	var $month_price = $('#month_price');
	var $size_number = $('#size_number');
	
	var $my_sportclasses = $('#my_sportclasses');
	
    $("#request_update_sportclass").click(function(e)    {
		
		var sportClassObject = {
			id_class: parseInt($id_class.val(), 10),
			name: $name.val(),
			id_trainer_fk: parseInt($id_trainer_fk.val(), 10),
			month_price: parseInt($month_price.val(), 10),
			size_number: parseInt($size_number.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/updateSportClass',
			data: JSON.stringify(sportClassObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
				$my_sportclasses.append('<li>Response: ' + data + '</li>');
			},
            error: function(){
                $("#sportclasses").html("error")
            }
		
        });
    });


});



