$(function () {

    /* JSON.parse(newstr); json字符串转json对象 */
    /* JSON.stringify();    将json对象转换成json字符串 */
    /* eval('('+response+')'); 与JSON.parse()作用相似 */

    $('#user_birth').datepicker({
        format: 'yyyy-mm-dd',
        language:'zh-CN',//添加中文的js后可以写这个
    });

    /** 加载成功调用ajax获取数据填充页面 */
     $.ajax({
        type: "post",
        url: "users",
        data: "data",
        dataType: "json",
        success: function (response) {
            // console.log(response);
            $("#user_nickname").val(response.nikename);
            $("#user_email").val(response.email);
            $("#user_name").val(response.name);
            $("#user_birth").val(response.birth);
            $("#user_tel").val(response.tel);
            $("#user_addr").val(response.addr);
            if(response.gender == "男"){
                $("input[name='gender']").eq(0).attr("checked", true);
            } else if(response.gender == "女") {
                $("input[name='gender']").eq(1).attr("checked", true);
            }
            // gender: $("input[name='gender']:checked").val()
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        },
        complete: function(){
            
        }
    });


    /* 测试函数 */
    // $(window).on("resize", function(){
    //     console.log($(document).width());
    //     alert(1)
    // });

    /* 头像 */
    $(".head_portrait").on("change", "input[type=file]", function () {
        // $(this).prev().css("background","red");
        // console.log($(this));


        var filePath = $(this).val(); //读取图片路径

        var fr = new FileReader(); //创建new FileReader()对象
        var imgObj = this.files[0]; //获取图片

        fr.readAsDataURL(imgObj); //将图片读取为DataURL
        var obj = $(this).parent().prev()[0]; //

        if (filePath.indexOf("jpg") != -1 || filePath.indexOf("JPG") != -1 || filePath.indexOf("PNG") != -1 || filePath.indexOf("png") != -1) {
            var arr = filePath.split('\\');
            var fileName = arr[arr.length - 1];

            $(this).parent().next().show();
            fr.onload = function () {
                obj.src = this.result;
            };
        } else {
            $(this).parent().next().show();
            $(this).parent().next().children("i").html("您未上传文件，或者您上传文件类型有误！").css("color", "red");
            //$(this).parent().next().html("您未上传文件，或者您上传文件类型有误！").css("color","red");
            return false
        }
    });

    /** 邮箱模块 */
    $(".content_email>button").on("click", function (ev) {
        if ($(".content_email>input").attr("disabled") == "disabled") {
            $(".content_email>input").removeAttr("disabled");
            $(this).html("确定");
        } else {
            $(".content_email>input").attr("disabled", "disabled");
            $(this).html("修改邮箱");
        }
    })

    /** 真实姓名 */
    $(".content_name>button").on("click", function (ev) {
        if ($(this).prev().attr("disabled") == "disabled") {
            $(this).prev().removeAttr("disabled");
            $(this).html("确定");
        } else {
            $(this).prev().attr("disabled", "disabled");
            $(this).html("修改真实姓名");
        }
        // console.log($(this).prev().val());
    });

    /** 出生日期 */
    $(".content_birth>button").on("click", function (ev) {
        // $(this).prev().attr("value","2013-09-05");
        if ($(this).prev().attr("disabled") == "disabled") {
            $(this).prev().removeAttr("disabled");
            $(this).html("确定");
        } else {
            $(this).prev().attr("disabled", "disabled");
            $(this).html("修改出生日期");
        }
    });

    /** 手机号码 */
    $(".content_tel>button").on("click", function (ev) {
        if ($(this).prev().attr("disabled") == "disabled") {
            $(this).prev().removeAttr("disabled");
            $(this).html("确定");
        } else {
            $(this).prev().attr("disabled", "disabled");
            $(this).html("修改电话号码");
        }
    });


    /** 地址 */
    $(".content_addr>button").on("click", function (ev) {
        if ($(this).prev().attr("disabled") == "disabled") {
            $(this).prev().removeAttr("disabled");
            $(this).html("确定");
        } else {
            $(this).prev().attr("disabled", "disabled");
            $(this).html("修改地址");
        }
    });

    /* 保存按钮 */
    $("#save").on("click", function (ev) {
        let sendData = {
            nikename: $("#user_nickname").val(), //昵称
            email: $("#user_email").val(), //邮箱
            name: $("#user_name").val(), //真实姓名
            birth: $("#user_birth").val(), //出生日期
            tel: $("#user_tel").val(), //电话号码
            gender: $("input[name='gender']:checked").val(), //性别
            addr: $("#user_addr").val() //地址
        };
        console.log(sendData);
        $.ajax({
            type: "post",
            url: "user",
            data: sendData,
            dataType: "json",
            beforeSend: function (xhr) {
                // console.log(xhr);
            },
            success: function (response) {
                
            },
            error: function (err) {

            },
            complete: function () {
               
            }
        });
    });


});