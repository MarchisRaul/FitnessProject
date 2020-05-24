$(document).ready(function()    {
	
	var $nameOfUser = $('#nameOfUser');
	
	var $response_info = $('#response_info');
	
    $("#request_all_sportclasses_for_user_get").click(function(e)    {
		
		var userName = {
			nameOfUser: $nameOfUser.val(),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/getSportClassesForUser',
			data: userName,
			contentType: 'application/json',
            success: function(data){
				$response_info.append('<li>' + data + '</li>');		
			},
            error: function(){
                $("#name").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $nameOfSportClass = $('#nameOfSportClass');
	
	var $response_info = $('#response_info');
	
    $("#request_all_users_for_sportclass_get").click(function(e)    {
		
		var sportClassName = {
			nameOfSportClass: $nameOfSportClass.val(),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/getUsersForSportClass',
			data: sportClassName,
			contentType: 'application/json',
            success: function(data){
				$response_info.append('<li>' + data + '</li>');		
			},
            error: function(){
                $("#name").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $nameOfUserSecond = $('#nameOfUserSecond');
	var $nameOfSportClasses = $('#nameOfSportClasses');
	
	var $response_info = $('#response_info');
	
    $("#request_join_sportclass_by_user").click(function(e)    {
		
		var nameOfSportClasses = new Array();
		var index = 0;
		var allSportClasses = $nameOfSportClasses.val().split(" ");
		for (var i = 0; i < allSportClasses.length; i++) {
			nameOfSportClasses[index] = String(allSportClasses[i]);
			index++;
		}
		
		var postData = {
			"nameOfUserSecond": $nameOfUserSecond.val(),
			"nameOfSportClasses": JSON.stringify(nameOfSportClasses),
		};

        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/joinSportClassForUser',
			data: postData,
			dataType: "text",
            success: function(data){
				$response_info.append('<li>' + data + '</li>');
			},
            error: function(){
                $("#name").html("error")
            }
		
        });
    });


});




