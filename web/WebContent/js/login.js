$(function(){
	let $pwd = $('.registered-box :password:first');
	let $confirm = $('.registered-box :password:last');
	let $registered = $(".registered-box :submit");

	$(".txtb").eq(0).focus();
	$(".show-login-btn").on("click", function(){
		$(".txtb").eq(0).focus();
		$(".registered-form")[0].reset();
		$(".login-box").toggleClass("showed");
	});
	$(".registered-btn").on("click", function(){
		$("p").remove();
		$(".login-form")[0].reset();
		$(".login-box").toggleClass("showed");
	});

	//用户名聚焦判断为空
	$('#reg-userName').on('blur', function(){
		// if($("#reg-userName").val() == ""){
		// 	$("#reg-userName").after("<p>用户名不能为空，请输入用户名!</p>");
		// }
		setTimeout(function(){
			if($("#reg-userName").val() == ""){
				$("#reg-userName").after("<p>用户名不能为空，请输入用户名!</p>");
			}
		}, 250);
	});
	$('#reg-userName').on('focus', function(){
		if(($("#reg-userName").next().html()) != ""){
			$("#reg-userName").next().remove();
		}
	});

	//密码框聚焦，判断是否为空
	$pwd.on('blur', function(){
		if($pwd.val() == ""){
			$pwd.after("<p>密码不能为空!</p>");
		}
	});
	$pwd.on('focus', function(){
		if($pwd.next().html() != ""){
			$pwd.next().remove();
		}
	});

	//验证密码
	$confirm.on('focus', function(){
		if(this.value != "" && $confirm.next().html() != ""){
			$confirm.next().remove();
		}
	});
	$confirm.on("blur", function(){
		if(this.value !== $pwd.val() && this.value != ""
			&& $confirm.next().html() == ""){
		
			$confirm.after("<p>确认两次输入的密码一致!</p>");
		}
	});
	let submit = false;
	$registered.on("mouseover", function(){
		if($pwd.val() != "" && $pwd.val() == $confirm.val()){
			submit = true;
		}
		else{
			submit = false;
		}
		console.log(submit);
	});
	$registered.on("click", function(ev){
		if(submit == false){
			// ev.preventDefault();
		}
		else{
			console.log(1);
		}
	});


	// $registered.on("click", function(){
	// 	$.ajax({
	// 		type: 'post',
	// 		url: ,
	// 		data: {},
	// 		dataType: 'json',
	// 		success: function(){

	// 		},
	// 		error: function(){
				
	// 		}
	// 	});
	// });


});
