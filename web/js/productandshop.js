$(document).ready(function()    {
	
	var $id = $('#id');
	var $my_products_from_shop = $('#my_products_from_shop');
	
    $("#request_all_products_from_shop_get").click(function(e)    {
		
		var shopId = {
			id: parseInt($id.val(), 10),
		};
		
        $.ajax({
            type: 'GET',
            url:'http://localhost:8080/findProductsFromShop',
			data: shopId,
			dataType: 'json',
            success: function(data){
				$.each(data, function (i, product) {
					$my_products_from_shop.append('<li>id_product: ' + product.id_product + ' name: ' + product.name + ', id_shop_fk: ' + product.id_shop_fk + ', utility: ' + product.utility + ', price: ' + product.price + ', quantity: ' + product.quantity + '</li>');
                })			},
            error: function(){
                $("#id").html("error")
            }
		
        });
    });


});





