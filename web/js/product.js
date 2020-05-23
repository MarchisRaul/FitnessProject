$(document).ready(function()    {
	
	var $my_products = $('#my_products');
	
    $("#request_all_products_get").click(function(e)    {
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/getProducts',
			dataType: 'json',
            success: function(data){
                $.each(data, function (i, product) {
					$my_products.append('<li>id_product: ' + product.id_product + ' name: ' + product.name + ', id_shop_fk: ' + product.id_shop_fk + ', utility: ' + product.utility + ', price: ' + product.price + ', quantity: ' + product.quantity + '</li>');
                })
			},
            error: function(){
                $("#products").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id = $('#id');
	var $my_products = $('#my_products');
	
    $("#request_get_product_by_id").click(function(e)    {
		
		var productId = {
			id: parseInt($id.val(), 10),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/findProductById',
			data: productId,
			dataType: 'json',
            success: function(data){
				$my_products.append('<li>id_product: ' + data.id_product + ' name: ' + data.name + ', id_shop_fk: ' + data.id_shop_fk + ', utility: ' + data.utility + ', price: ' + data.price + ', quantity: ' + data.quantity + '</li>');
			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $name = $('#nameOfProduct');
	var $my_products = $('#my_products');
	
    $("#request_get_product_by_name").click(function(e)    {
		
		var productName = {
			name: $name.val(),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/findProductByName',
			data: productName,
			dataType: 'json',
            success: function(data){
				$my_products.append('<li>id_product: ' + data.id_product + ' name: ' + data.name + ', id_shop_fk: ' + data.id_shop_fk + ', utility: ' + data.utility + ', price: ' + data.price + ', quantity: ' + data.quantity + '</li>');
			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_product = $('#id_product');
	var $name = $('#name');
	var $id_shop_fk = $('#id_shop_fk');
	var $utility = $('#utility');
	var $price = $('#price');
	var $quantity = $('#quantity');
	
	var $my_products = $('#my_products');
	
    $("#request_insert_product").click(function(e)    {
		
		var productObject = {
			id_product: parseInt($id_product.val(), 10),
			name: $name.val(),
			id_shop_fk: parseInt($id_shop_fk.val(), 10),
			utility: $utility.val(),
			price: parseInt($price.val(), 10),
			quantity: parseInt($quantity.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/insertProduct',
			data: JSON.stringify(productObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
				$my_products.append('<li>Response: ' + data + '</li>'); 
			},
            error: function(){
                $("#products").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_product = $('#id_product');
	var $name = $('#name');
	var $id_shop_fk = $('#id_shop_fk');
	var $utility = $('#utility');
	var $price = $('#price');
	var $quantity = $('#quantity');
	
	var $my_products = $('#my_products');
	
    $("#request_delete_product").click(function(e)    {
		
		var productObject = {
			id_product: parseInt($id_product.val(), 10),
			name: $name.val(),
			id_shop_fk: parseInt($id_shop_fk.val(), 10),
			utility: $utility.val(),
			price: parseInt($price.val(), 10),
			quantity: parseInt($quantity.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/deleteProduct',
			data: JSON.stringify(productObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
                //$.each(dataa, function (i, user) {
				$my_products.append('<li>Response: ' + data + '</li>');
                //})
			},
            error: function(){
                $("#products").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_product = $('#id_product');
	var $name = $('#name');
	var $id_shop_fk = $('#id_shop_fk');
	var $utility = $('#utility');
	var $price = $('#price');
	var $quantity = $('#quantity');
	
	var $my_products = $('#my_products');
	
    $("#request_update_product").click(function(e)    {
		
		var productObject = {
			id_product: parseInt($id_product.val(), 10),
			name: $name.val(),
			id_shop_fk: parseInt($id_shop_fk.val(), 10),
			utility: $utility.val(),
			price: parseInt($price.val(), 10),
			quantity: parseInt($quantity.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/updateProduct',
			data: JSON.stringify(productObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
				$my_products.append('<li>Response: ' + data + '</li>');
			},
            error: function(){
                $("#products").html("error")
            }
		
        });
    });


});



