// $(function () {



//     $("input[id = pw1]").blur(function () {
//         alert($(this).val())
//     });

//     $("#chk").click(function () {
//             //点就显示密码
//             var pwd1 = document.getElementById("pwd1").value;
//             var pwd2 = document.getElementById("pwd2").value;
//             if(pwd1 == pwd2){

//             }
//             else{
//                 document.getElementById("tishi").innerHTML="<br><font color='red'>两次密码输入不一致</font>";
//                 document.getElementById("save").disabled = true;
//             }

//         });


//     /**勾选框 */
//     $(function () {
//         $("#chk").bind({
//             click:function () {
//                 if($(this).attr("checked")){
//                     $("#pw2").val($("#pw1").val());
//                     $("#pw1").show();
//                     $("#pw2").show();

//                 }else{
//                     $("#pw1").val($("#pw2").val());
//                     $("#pw2").hide();
//                     $("#pw1").hide();
//                 }

//             }
//         });
//     });

//     /* 保存 */
//     $("#save").on("click",function (ev) {

//     });

// });


