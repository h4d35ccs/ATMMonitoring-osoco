$(document).ready(function() {
	$('.desplegable ul').hide(); // Cierro todos los menun de las cajas
	$('.desplegable .txt').click(function() {
		if($(this).hasClass('hide')){ // si pulso en uno que está cerrado...
			$(this).removeClass('hide');
			$(this).next('ul').show();
		}else{
			$(this).next('ul').hide();
			$(this).addClass('hide');
		}
	});
	$('.desplegable ul').click(function() {
			$(this).hide();
			$(this).prev('div').addClass('hide');
	});
	$('.close').click(function() {
		$(this).parent().parent().hide('slow');
	});
});