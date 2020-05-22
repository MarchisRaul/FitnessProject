$(document).ready(function()    {
    $("#request_all_users_get").click(function(e)    {
        $.ajax({
            type: 'GET',
            //url: 'http://api.openweathermap.org/data/2.5/weather?q=Cluj-Napoca&appid=ea1863083f37f636a3d408f54bc64c79',
            url:'http://localhost:8080/getUsers',
			dataType: 'json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
                $.each(data, function (i, user) {
                    str = str + user.name + ", ";
                })
                $("#Users").attr("placeholder", str); 
			},
            error: function(){
                $("#Users").html("error")
            }

        });
    });


});

$(document).ready(function()    {
    $("#request_all_trainers_get").click(function(e)    {
        $.ajax({
            type: 'GET',
            //url: 'http://api.openweathermap.org/data/2.5/weather?q=Cluj-Napoca&appid=ea1863083f37f636a3d408f54bc64c79',
            url:'http://localhost:8080/getTrainers',
			dataType: 'json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
                $.each(data, function (i, trainer) {
                    str = str + trainer.name + ", ";
                })
                $("#Trainers").attr("placeholder", str); 
			},
            error: function(){
                $("#Trainers").html("error")
            }

        });
    });


});

$(document).ready(function()    {
    $("#request_all_sportclasses_get").click(function(e)    {
        $.ajax({
            type: 'GET',
            //url: 'http://api.openweathermap.org/data/2.5/weather?q=Cluj-Napoca&appid=ea1863083f37f636a3d408f54bc64c79',
            url:'http://localhost:8080/getSportClasses',
			dataType: 'json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
                $.each(data, function (i, sportclass) {
                    str = str + sportclass.name + ", ";
                })
                $("#SportClass").attr("placeholder", str); 
			},
            error: function(){
                $("#SportClass").html("error")
            }

        });
    });


});

// getSportClasses


