
$(function() {
	$('ul.collapsible').hide(); // Cierro todos los menun de las cajas
	$(document).on("click", ".desplegable .txt", function() {
		if($(this).hasClass('content_hide')){ // si pulso en uno que está cerrado...
			$(this).removeClass('content_hide');
			$(this).next('.collapsible').show('slow');
		}else{
			$(this).next('.collapsible').hide('slow');
			$(this).addClass('content_hide');
		}
	});

// Mostrar detalle de un TR
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

// Check all
	$("input.all_check").change(function(){
		$('.check input[type=checkbox]').each( function() {
			if($("input.all_check:checked").length == 1){
				this.checked = true;
			} else {
				this.checked = false;
			}
		});
	});
// Colorbox
	$(".iframe").colorbox({iframe:true, width:"90%", height:"90%"}); // Iframes
	$(".iframe_s").colorbox({iframe:true, width:"640", height:"480px", maxWidth:"100%", maxHeight:"100%"}); // Iframes
	$(".colorbox").colorbox({rel:'group1', maxWidth:"100%", maxHeight:"100%"}); // Photo
	$(".inline").colorbox({inline:true,  width:"640", height:"480px"}); // pop-ups en la misma pagina

// Instalacion ATM checkbox
	$('#isAgeSelected').click(function() {
	    $("#txtAge").toggle(this.checked);
	});

// Responsive menu
	$('#rButton').click(function() {
		if($(this).hasClass("btn_close")){
			$("#main").removeClass("btn_close")
			$("#main_nav").removeClass("btn_close")
			$(this).removeClass("btn_close");
		}else{
			$("#main").addClass("btn_close")
			$("#main_nav").addClass("btn_close")
			$(this).addClass("btn_close");
		}
	});
});
