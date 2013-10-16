
$(document).ready(function() {
	$('ul.ocultable').hide(); // Cierro todos los menun de las cajas
	$('.desplegable .txt').click(function() {
		if($(this).hasClass('hide')){ // si pulso en uno que está cerrado...
			$(this).removeClass('hide');
			$(this).next('.ocultable').show();
		}else{
			$(this).next('.ocultable').hide();
			$(this).addClass('hide');
		}
	});
	$('.desplegable ul').click(function() {
			$(this).hide();
			$(this).prev('div').addClass('hide');
	});
	$('.close').click(function() {
		$(this).parent().parent().parent().hide('slow');
	});
});
