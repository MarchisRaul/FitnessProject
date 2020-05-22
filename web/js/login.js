
$(document).ready(function()    {
	
	var $id_user = $('#id');
	var $password = $('#password');
	var $response_info = $('#response_info');
	
    $("#login").click(function(e)    {
		
		var email = {
			emailOfUser: $id_user.val(),
		};
		var passwordd = {
			passwordd: $password.val(),
		};
		
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/verifyLogin',
			data: JSON.stringify({emailOfUser:email, passwordd:password}),
			dataType: 'json',
            success: function(data){
				$response_info.append('<li>Result: ' + data + '</li>');
				if (data === "You successfully logged in. Have a great training at our gym!") {
					console.log("DADA");
					window.location.href = "C:\Users\Maerchis\Desktop\demo (1)\demo\web\nebuneala.html";
				}
			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});


