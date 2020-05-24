
$(document).ready(function()    {
	
	var $id_user = $('#id_user');
	var $passwordd = $('#password');
	var $response_info = $('#response_info');
	
	var email = {
		emailOfUser: $id_user.val(),
	};
	var passwordd = {
		passwordd: $passwordd.val(),
	};
	
    $("#login").click(function(e)    {
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/verifyLogin',
			data: {emailOfUser: $id_user.val(), passwordd: $passwordd.val()},
			dataType: 'text',
            success: function(data){
				$response_info.append('<li>Result: ' + data + '</li>');
				if (data === "You successfully logged in. Have a great training at our gym!") {
					console.log("DADA");
					if ($id_user.val() === "admin" && $passwordd.val() === "admin") {
						window.location.href = "selectActionAdmin.html";
					} else {
						window.location.href = "selectActionUser.html";
					}
				}
			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});


