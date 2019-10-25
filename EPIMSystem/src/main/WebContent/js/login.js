window.onload=function () {
    var btn=document.getElementById("btn");
    btn.onclick=function () {
        /*使用cookie实现记住我*/
        var Remember=document.getElementById("checkbox").checked;//返回值为true或false
        if (Remember){
            $.cookie('username',$("#username").value(),{expires:2});
            $.cookie('password',$("password").value(),{expires:2});
        }else {
            $.cookie('username',"",{expires:-1});
            $.cookie('password',"",{expires:-1});//没有选中记住密码则将cookie中的password清空/销毁
        }

        /*输入规范判断*/
        var userName=document.getElementById("username").valueOf();
        var password=document.getElementById("password").valueOf();

        if (userName==""){
            alert("用户名不能为空");
            return false;
        }
        if (userName.length<3){
            alert("用户名不能为空");
            return false;
        }
        if (password==""){
            alert("密码不能为空");
            return false;
        }
        if (password.length<6){
            alert("密码长度过短");
            return false;
        }else {
            var  that=$("password");
            console.log(userName);
            /*使用Ajax获取公钥进行加密*/
            var xmlHttp;
            if (window.XMLHttpRequest){
                xmlHttp=new XMLHttpRequest();
            }else {
                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlHttp.open("GET","",true);
            xmlHttp.setRequestHeader("","");
            xmlHttp.send();
            xmlHttp.responseText;
            document.getElementById("password").innerHTML=xmlHttp.responseText;
        }
    }
}