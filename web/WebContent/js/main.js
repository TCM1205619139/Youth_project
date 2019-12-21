$(function () {
	let body_width = window.screen.width;
	$('body').width(body_width - 15);
	// console.log($(document).height());

	$(window).on('scroll', function () {
		if ($(document).scrollTop() >= 200) {
			$('.banner_nav').css({
				"background-color": "rgb(0,0,0,1)",
				"transition": "all .75s"
			});
		} else {
			$('.banner_nav').css({
				"background-color": "rgb(0,0,0,.1)",
				"transition": "all .75s"
			});
		}
	})

	$.ajax({
		type: "post",
		url: "url",
		data: "data",
		dataType: "json",
		success: function (response) {

		},
		error: function (response) {

		}
	});






	/*	联系我们区域	*/
	// $(".icon").on("mouseenter", function () {
	// 	$(".icon>i").css({
	// 		"color": "#3498db"
	// 	});
	// });
});