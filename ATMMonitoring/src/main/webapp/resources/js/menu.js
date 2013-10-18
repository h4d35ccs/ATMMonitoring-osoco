
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
	$('table .detail').hide();
	$('table .showdetail').removeClass('open');
	$('table .showdetail').click(function() {
		if($(this).hasClass('open')){
			$(this).removeClass('open');
			$(this).next('.detail').hide();
		}else{
			$('.showdetail').removeClass('open');
			$('.detail').hide();
			$(this).addClass('open');
			$(this).next('.detail').show();
		}
	});
// SCroll ancla
     $('a[href*=#]').click(function() {

     if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'')
         && location.hostname == this.hostname) {

             var $target = $(this.hash);

             $target = $target.length && $target || $('[name=' + this.hash.slice(1) +']');

             if ($target.length) {

                 var targetOffset = $target.offset().top;

                 $('html,body').animate({scrollTop: targetOffset}, 1000);

                 return false;

            }

       }

   });

});