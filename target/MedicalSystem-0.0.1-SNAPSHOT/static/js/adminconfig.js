/*总配置文件*/

/* 声明全局注销方法 */
function userLogout(){
    $.ajax({
        url: "../logintosystem/adminlogout",
        success: function(data){
            if(data.code==0){
                //移除cookie.前面传入的cookie
                $.cookie("adminName",null,{path:"/MedicalSystem",expires:-1});
                $.cookie("adminNum",null,{path:"/MedicalSystem",expires:-1});

                // $.cookie("adminName",null,{path:"/BookMSv3",expires:-1});
                // $.cookie("adminId",null,{path:"/BookMSv3",expires:-1});
                // $.cookie("adminImg",null,{path:"/BookMSv3",expires:-1});
                //$.removeCookie("adminName");
                //$.removeCookie("adminId");
                //$.removeCookie("adminImg");
                console.log("cookie移除成功");
            }else{
                alert("退出失败，请重试");
            }
        },
        error: function(data){
            alert("服务器内部错误");
        }
    });
}

//-------------------------------------------------------------------------------------------

/* 页面加载 */
$(document).ready(function() {
    //页面不进行刷新跳转
    $("#index").click(function() {
        window.location.hash="index-page"; //改变地址栏 hash地址，页面不刷新
        window.location.reload();  //刷新页面回到首页
    });


    //页面跳转操作
    $("#infoA").click(function() {
        $("#main_content").load("Ztest.html");  //在主体页面 (main_content) 加载页面
        window.location.hash='/#/Ztest.html'; //改变地址 index.html#book-manage
    });

    //页面跳转操作
    $("#medical_manage").click(function() {
        $("#main_content").load("medical_manage.html");  //在主体页面 (main_content) 加载页面
        window.location.hash='/#/medical_manage.html'; //改变地址 index.html#book-manage
    });




});






