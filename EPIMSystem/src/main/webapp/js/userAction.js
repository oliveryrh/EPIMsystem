function createXmlHttpRequest() {
    var xmlHttp;
    if (window.XMLHttpRequest){
        xmlHttp=new XMLHttpRequest();
    }else {
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlHttp;
}
function login() {
    /*输入规范判断*/
    var userId=document.getElementById("userId").value;
    var password=document.getElementById("u-password").value;

    if (userId===""){
        alert("用户账号不能为空!请输入账号");
        return false;
    }
    if (password===""){
        alert("密码不能为空！请输入密码");
        return false;
    }
    else {
        var xmlHttp=createXmlHttpRequest();
        var result;
        xmlHttp.onreadystatechange=function(){
            //等待服务器响应 当请求状态为4时，说明请求完成
            if (xmlHttp.readyState===4){
                //判断服务器响应状态码是否正常
                if (xmlHttp.status===200){
                    result=xmlHttp.responseText;
                    if (result==="wrong-id"||result==="wrong-password"){
                        alert("账号或密码错误！请重新输入");
                        document.getElementById("userId").setAttribute("value",userId);
                        document.getElementById("u-password").setAttribute("value","");
                    }else {
                        location.href="main.html";
                        localStorage.setItem("userId",userId);
                    }
                }
            }
        }
        xmlHttp.open("POST","/user/check-login",false);
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlHttp.send("userId="+userId+"&password="+password);

        // $.ajax({
        //     type:"POST",
        //     url:"/user/check-login",
        //     data:{
        //         userId:userId,
        //         password:password
        //     },
        //     dataType:"JSON",
        //     success:function (res) {
        //         alert("worng");
        //         if (res==="success"){
        //             location.href="main.html";
        //             if ($("#remember").isChecked()){
        //                 localStorage.setItem("userId",userId);
        //             }
        //         }else {
        //             alert("账号或密码错误！请重新输入");
        //         }
        //     }
        // })
    }
}

function forgetPassword() {

    var userId=document.getElementsByName("employeeNumber").value;
    var newPassword=document.getElementsByName("newPassword").value;

    if (userId===""){
        alert("用户账号不能为空!请输入账号");
        return false;
    }
    if (newPassword===""){
        alert("密码不能为空！请输入密码");
        return false;
    }
    else {
        $.ajax({
            type:"POST",
            url:"/user/reset-password",
            data:{
                userId:userId,
                password:newPassword
            },
            dataType:"JSON",
            success:function (res) {
                if (res==="success") {
                    location.href = "login.html";
                    localStorage.setItem("userId", userId);
                    document.getElementsByName("employeeNumber").innerText=userId;
                }
            }
        })
    }
}

function modifyPassword() {

}

function exit() {
    //localStorage.removeItem("userId");
    location.href="login.html";
}

function askForLeave() {
    var employeeNumber=document.getElementById("userID").value;
    var name=document.getElementById("name").value;

    $.ajax({
        type:"POST",
        url:"",
        data:$("form").serialize(),
        dataType:JSON,
        success:function (data) {

        }
    })
}
