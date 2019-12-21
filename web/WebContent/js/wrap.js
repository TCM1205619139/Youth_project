$(function(){
	
	let index = 0;
	let max_list = $('.list').children('li').length;
	$("#goPro").on("click", function(){
		if(index == 0){
			index = max_list;
		}
		else{
			index--;
		}
		// console.log($('.list li').eq(index).siblings());
		$('.list li').eq(index).siblings().removeClass('active');
		$('.list li').eq(index).addClass('active');
		$('.point_list li').eq(index).siblings().removeClass('active');
		$('.point_list li').eq(index).addClass('active')
	})
	$('#goNext').on('click', function(){
		if(index == max_list){
			index = 0;
		}
		else{
			index++;
		}
		$('.list li').eq(index).siblings().removeClass('active');
		$('.list li').eq(index).addClass('active');
		$('.point_list li').eq(index).siblings().removeClass('active');
		$('.point_list li').eq(index).addClass('active');
	})

	$('.point_list li').each(function(index){
		$(this).on('click', function(){
			index = $(this).attr('value');
			$('.list li').eq(index).siblings().removeClass('active');
			$('.list li').eq(index).addClass('active');
			$('.point_list li').eq(index).siblings().removeClass('active');
			$('.point_list li').eq(index).addClass('active');
		})
	});

	let wraper = setInterval(function(){
		if(index == max_list){
			index=0;
		}
		else{
			index++;
		}
		$('.list li').eq(index).siblings().removeClass('active');
		$('.list li').eq(index).addClass('active');
		$('.point_list li').eq(index).siblings().removeClass('active');
		$('.point_list li').eq(index).addClass('active');
	}, 3500);
	$('.wrap').mouseenter(function(){
		clearInterval(wraper);
	})
	$(".wrap").mouseleave(function(){
		clearInterval(wraper);
		wraper = setInterval(function(){
			if(index == 4){
				index=0;
			}
			else{
				index++;
			}
			$('.list li').eq(index).siblings().removeClass('active');
			$('.list li').eq(index).addClass('active');
			$('.point_list li').eq(index).siblings().removeClass('active');
			$('.point_list li').eq(index).addClass('active');
		}, 3500);

	})
	
});