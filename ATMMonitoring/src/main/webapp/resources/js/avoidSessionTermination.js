$(function() {
	var oneMinute = 1000 * 60;
	var imAliveUrl = 'imAlive';
	
	setInterval(doCall, oneMinute);
	
	function doCall() {
		$.ajax(imAliveUrl)
	}
})