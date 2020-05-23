$(document).ready(function()    {
	
	var $my_shops = $('#my_shops');
	
    $("#request_all_shops_get").click(function(e)    {
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/getShops',
			dataType: 'json',
            success: function(data){
				console.log(data);
                var str="";
                $.each(data, function (i, shop) {
					var hasDiscount = "";
					if (shop.discount_mode === 1)
						hasDiscount = "Discount mode is on!";
					else
						hasDiscount = "Discount mode is off!";
					$my_shops.append('<li>id_shop: ' + shop.id_shop + ', discount: ' + hasDiscount + '</li>');
                })
			},
            error: function(){
                $("#shops").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id = $('#id');
	var $my_shops = $('#my_shops');
	
    $("#request_get_shop_by_id").click(function(e)    {
		
		var shopId = {
			id: parseInt($id.val(), 10),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/findShopById',
			data: shopId,
			dataType: 'json',
            success: function(data){
				var hasDiscount = "";
				if (data.discount_mode === 1)
					hasDiscount = "Discount mode is on!";
				else
					hasDiscount = "Discount mode is off!";
					$my_shops.append('<li>id_shop: ' + data.id_shop + ', discount: ' + hasDiscount + '</li>');
			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_shop = $('#id_shop');
	var $discount_mode = $('#discount_mode');
	
	var $my_shops = $('#my_shops');
	
    $("#request_insert_shop").click(function(e)    {
		
		var shopObject = {
			id_shop: parseInt($id_shop.val(), 10),
			discount_mode: parseInt($discount_mode.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/insertShop',
			data: JSON.stringify(shopObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
				$my_shops.append('<li>Response: ' + data + '</li>'); 
			},
            error: function(){
                $("#shops").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_shop = $('#id_shop');
	var $discount_mode = $('#discount_mode');
	
	var $my_shops = $('#my_shops');
	
    $("#request_delete_shop").click(function(e)    {
		
		var shopObject = {
			id_shop: parseInt($id_shop.val(), 10),
			discount_mode: parseInt($discount_mode.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/deleteShop',
			data: JSON.stringify(shopObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
                //$.each(dataa, function (i, user) {
				$my_shops.append('<li>Response: ' + data + '</li>');
                //})
			},
            error: function(){
                $("#shops").html("error")
            }
		
        });
    });


});

$(document).ready(function()    {
	
	var $id_shop = $('#id_shop');
	var $discount_mode = $('#discount_mode');
	
	var $my_shops = $('#my_shops');
	
    $("#request_update_shop").click(function(e)    {
		
		var shopObject = {
			id_shop: parseInt($id_shop.val(), 10),
			discount_mode: parseInt($discount_mode.val(), 10),
		};
		
        $.ajax({
            type: 'POST',
            url:'http://localhost:8080/updateShop',
			data: JSON.stringify(shopObject),
			contentType: 'application/json',
            success: function(data){
				console.log("Am intrat pana aici :D");
				console.log(data);
              
                var str="";
				$my_shops.append('<li>Response: ' + data + '</li>');
			},
            error: function(){
                $("#shops").html("error")
            }
		
        });
    });


});



