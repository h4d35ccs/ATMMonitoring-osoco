$(function() {
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
	$('.close').click(function() {
		$(this).parent().parent().parent().hide('slow');
	});
	// TABS para detalle de terminal
	$('.tabs .content_tab').hide(); // cierro todas las capas
	$('.tabs .content_tab:first').show(); // muestro la primera
	$('.sub_nav li').removeClass();
	$('.sub_nav li:first').addClass('current'); // activo el primer tab
	$('.sub_nav li').click(function() {
		$('.sub_nav li').removeClass(); // borro estilo current de todos los li
		$(this).addClass('current'); 
		var tab_click =  $('.sub_nav li').index(this);
		$('.tabs .content_tab').hide();
		$('.tabs').find( ".content_tab" ).eq( tab_click ).show();
	});
});