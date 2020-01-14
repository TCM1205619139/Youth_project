$(function () {
    let task_num = $(".content").children().length - 1; //任务数量
    $(".head>span").html(task_num);

    $(".subnav>div").hover(function () { //鼠标移入div，设置字体图标变色
            $(this).find("i").addClass("i_hover");
        },
        function () {
            $(this).find("i").removeClass("i_hover");
        }
    );

    $.ajax({ //页面加载成功，获取当前模块的所有数据
        type: "get",
        url: "selmeetingbyid",
        dataType: "json",
        success: function (response) {

            for (let i in response) {
                $(".nav_content>.content").append(`<div class="task_box" task_id=${response[i].meetingid}></div>`);
                $(".task_box").eq(i).append(`<div class="prompt">
                 <span></span>
                 <button type="button" class="btn btn-default delete">删除任务</button>
                 <button type="button" class="btn btn-default detail">查看详情</button>
             </div>
             <i class="iconfont" title="查看更多">&#xe64c;</i>
             <p class="task_title">${response[i].theme}</p>
             <p class="task_box_des">${response[i].time}</p>
             <p class="task_box_des">地点：${response[i].place}</p>`);
            }
            $(".head>span").html(task_num);

            $(".task_box i").on("click", function (ev) { //点击更多按钮显示prompt框
                let $box = $(this).parent();
                let $box_i = $(this);
                let x = $box_i.offset().left;
                let y = $box_i.offset().top;
                let $prompt_status = $box.children(".prompt").css("display");
                // console.log($(".prompt").children("button"))

                if ($prompt_status == "none") { //设置prompt位置
                    $box.children(".prompt").css({
                        "display": "block"
                    });
                }

                $(".task_box>i").mouseleave(function () { //鼠标移出prompt框500ms后隐藏
                    timer = setTimeout(function () {
                        $(".prompt").css("display", "none");
                    }, 300);
                    $(".prompt").mouseenter(function () {
                        clearTimeout(timer);
                    })
                    $(".prompt").mouseleave(function () {
                        clearTimeout(timer);
                        timer = setTimeout(function () {
                            $(".prompt").css("display", "none");
                        }, 300);
                    });
                    clearTimeout(timer)
                });
            });

            $(".prompt").children(".delete").on("click", function () { // 删除任务按钮
                // $(this).unbind("click");
                let confm = confirm("您确定删除这个任务吗？");

                if (confm == true) {
                    let delete_task_id = $(this).parents(".task_box").attr("task_id");
                    let $box = $(this).parents(".task_box");

                    $.ajax({
                        type: "post",
                        url: "delmeeting",
                        data: {
                            "task_id": delete_task_id
                        },
                        dataType: "json",
                        success: function (response) {
                            $box.remove();
                            window.reload();
                        },
                        error: function (xhr) {
                            console.log(xhr.responseText);
                        }
                    });
                } else {

                    return;
                }

            });
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        },
        complete: function (xhr) {
            // let task_box = `<div class="task_box"></div>`

        }
    });


    //黑色导航栏点击
    $(".nav_box").each(function (index) { //每个子盒子添加事件
        $(this).on("click", function () {
            $(window).attr('location', $(this).attr('value') + '.html'); //页面跳转
        });
    });


    $(".task_box_one").on("click", function () { //创建新的任务
        $('#myModal').modal();
    });

    $(".subnav_1").on("click", function () { //我创建的项目
        window.location.reload(); // 刷新当前页面
        $.ajax({
            type: "GET",
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
            dataType: "json",
            url: "seldoingmeetingbyid",
            data: "data",
            success: function (response) {
                $(".nav_content>.content").empty();
                console.log(response);
                for (let i = 0; i < response.length; i++) {
                    $(".nav_content>.content").append(`<div class="task_box" task_id=${response[i].meetingid}></div>`);
                    $(".task_box").eq(i).append(`<div class="prompt">
                    <span></span>
                    <button type="button" class="btn btn-default delete">删除任务</button>
                    <button type="button" class="btn btn-default detail">查看详情</button>
                </div>
                <i class="iconfont" title="查看更多">&#xe64c;</i>
                <p class="task_title">${response[i].theme}</p>
                <p class="task_box_des">${response[i].time}</p>
                <p class="task_box_des">地点：${response[i].place}</p>`);
                }
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
            dataType: "json",
            url: "seldonemeetingbyid",
            data: "data",
            success: function (response) {
                $(".nav_content>.content").empty();
                console.log(response);
                for (let i = 0; i < response.length; i++) {
                    $(".nav_content>.content").append(`<div class="task_box" task_id=${response[i].meetingid}></div>`);
                    $(".task_box").eq(i).append(`<div class="prompt">
                    <span></span>
                    <button type="button" class="btn btn-default delete">删除任务</button>
                    <button type="button" class="btn btn-default detail">查看详情</button>
                </div>
                <i class="iconfont" title="查看更多">&#xe64c;</i>
                <p class="task_title">${response[i].theme}</p>
                <p class="task_box_des">${response[i].time}</p>
                <p class="task_box_des">地点：${response[i].place}</p>`);
                }
            },
            error: function (xhr) {
                console.log(xhr.responseText);
            },
            complete: function () {

            }
        });
    });


    $("#btn_submit").on("click", function () { //提交保存

        $.ajax({
            type: "POST",
            dataType: "json",
            url: "insmeeting",
            data: {
                "theme": $("#txt_meeting_theme").val(),
                "place": $("#txt_meeting_place").val(),
                "people": $("#txt_meeting_participants").val(),
                "content": $("#txt_meeting_content").val(),
                "other": $("#txt_meeting_desc").val(),
                "time": $("#txt_meeting_time").val()
            },
            success: function (response) {
                window.location.reload();
            },
            error: function (xhr) {
                console.log(xhr.responseText);
            },
            complete: function () {

            }
        });
    });

    $(".task_box i").on("click", function (ev) { //点击更多按钮显示prompt框
        let $box = $(this).parent();
        let $box_i = $(this);
        let x = $box_i.offset().left;
        let y = $box_i.offset().top;
        let $prompt_status = $box.children(".prompt").css("display");
        // console.log($(".prompt").children("button"))

        if ($prompt_status == "none") { //设置prompt位置
            $box.children(".prompt").css({
                "display": "block"
            });
        }

        $(".task_box>i").mouseleave(function () { //鼠标移出prompt框500ms后隐藏
            timer = setTimeout(function () {
                $(".prompt").css("display", "none");
            }, 300);
            $(".prompt").mouseenter(function () {
                clearTimeout(timer);
            })
            $(".prompt").mouseleave(function () {
                clearTimeout(timer);
                timer = setTimeout(function () {
                    $(".prompt").css("display", "none");
                }, 300);
            });
            clearTimeout(timer)
        });
    });

    $(".prompt").children(".delete").on("click", function () { // 删除任务按钮
        // $(this).unbind("click");
        let confm = confirm("您确定删除这个任务吗？");

        if (confm == true) {
            let delete_task_id = $(this).parents(".task_box").attr("task_id");
            let $box = $(this).parents(".task_box");

            $.ajax({
                type: "post",
                url: "delmeeting",
                data: {
                    "task_id": delete_task_id
                },
                dataType: "json",
                success: function (response) {
                    $box.remove();
                    $(".head>span").html($(".content").children().length - 1);
                },
                error: function (xhr) {
                    console.log(xhr.responseText);
                }
            });
        } else {

            return;
        }

    });

    $(".prompt").children(".detail").on("click", function () { //查看任务详情按钮

    });


})