
$(document).ready(function()    {
	
	var $nameOfUser = $('#nameOfUser');
	var $my_products = $('#my_products');
	
    $("#request_get_products_for_user").click(function(e)    {
		
		var nameOfUser = {
			nameOfUser: $nameOfUser.val(),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/getProductsForUser',
			data: nameOfUser,
			//dataType: 'json',
			contentType: 'application/json',
            success: function(data){
				$my_products.append('<li>' + data + '</li>');
			},
            error: function(){
                $("#name").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $nameOfProduct = $('#nameOfProduct');
	var $my_products = $('#my_products');
	
    $("#request_get_users_for_products").click(function(e)    {
		
		var nameOfProduct = {
			nameOfProduct: $nameOfProduct.val(),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/getUsersForProduct',
			data: nameOfProduct,
			contentType: 'application/json',
            success: function(data){
				$my_products.append('<li>' + data + '</li>');
			},
            error: function(){
                $("#name").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $nameOfUserBuy = $('#nameOfUserBuy');
	var $nameOfProducts = $('#nameOfProducts');
	
	var $my_products = $('#my_products');
	
    $("#request_post_buy_products").click(function(e)    {
		
		var nameOfProducts = new Array();
		var index = 0;
		var allProducts = $nameOfProducts.val().split(" ");
		for (var i = 0; i < allProducts.length; i++) {
			nameOfProducts[index] = String(allProducts[i]);
			index++;
		}
		
		var postData = {
			"nameOfUserBuy": $nameOfUserBuy.val(),
			"nameOfProducts": JSON.stringify(nameOfProducts),
		};

        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/buyProductsForUser',
			data: postData,
			dataType: 'text',
            success: function(data){
				$my_products.append('<li>' + data + '</li>');
			},
            error: function(){
                $("#name").html("error")
            }
		
        });
    });


});


