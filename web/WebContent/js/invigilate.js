$(function () {

    //黑色导航栏点击
    $(".nav_box").each(function (index) { //每个子盒子添加事件
        $(this).on("click", function () {
            console.log()
            $(window).attr('location', $(this).attr('value') + '.html');
        })
    })

    $(".task_box_one").on("click", function () { //创建新的任务
        $('#myModal').modal();
    });


    $(".subnav>div").hover(function () { //鼠标移入div，设置字体图标变色
            $(this).find("i").addClass("i_hover");
        },
        function () {
            $(this).find("i").removeClass("i_hover");
        }
    );

    $.ajax({ //页面加载成功，获取当前模块的所有数据
        type: "get",
        url: "selinvigilatebyid",
        dataType: "json",
        success: function (response) {


            $(".head>span").html($(".content>,task_box").length);
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        }
    });

    $(".subnav_1").on("click", function () { //我创建的项目
        window.location.reload(); // 刷新当前页面
        $.ajax({
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: "url",
            data: "data",
            success: function (response) {

                //生成页码(第一页active)
                //生成task_box
                //生成head任务总数量徽章
            },
            error: function (xhr) {
                console.log(xhr.responseText);
            },
            complete: function () {
                // do something
            }
        });
    });


    $(".subnav_2").on("click", function () { //进行中的项目
        $.ajax({
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: "seldoinginvigilatebyid",
            data: "data",
            success: function (response) {

            },
            error: function (xhr) {
                console.log(xhr.responseText);
            },
            complete: function () {

            }
        });
    });

    $(".subnav_3").on("click", function () { //已完成的项目
        $.ajax({
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: "seldoneinvigilatebyid",
            data: "data",
            success: function (response) {

            },
            error: function (xhr) {
                console.log(xhr.responseText);
            },
            complete: function () {

            }
        });
    });


    $("#btn_submit").on("click", function(){

        $.ajax({
            type: "POST",
            dataType: "json",
            url: "invigilate",
            data: {
                "subject": $("#txt_exam_subject").val(),
                "place": $("#txt_exam_place").val(),
                "class": $("#txt_exam_class").val(),
                "time": $("#txt_meeting_content").val(),
                "duration_time": $("#txt_exam_duration_time").val(),
                "invigilator": $("#txt_exam_invigilator").val(),
                "describe": $("#txt_exam_desc").val()
            },
            success: function (response) {
                
            },
            error: function(xhr){
                console.log(xhr.responseText);
            },
            complete: function(){

            }
        });
    });

});