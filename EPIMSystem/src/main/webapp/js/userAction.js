function login() {
    /*输入规范判断*/
    var employeeNumber=document.getElementById("userId").value;
    var password=document.getElementById("u-password").value;


    if (employeeNumber===""){
        alert("用户账号不能为空!请输入账号");
        return false;
    }
    if (password===""){
        alert("密码不能为空！请输入密码");
        return false;
    }
    if (employeeNumber!=""&&password!="") {

        $.ajax({
            type:"GET",
            url:"http://localhost:9090/EPIMSystem/user/check-login?employeeNumber="+employeeNumber+"&password="+password,
            // data:{
            //     employeeNumber:employeeNumber,
            //     password:password
            // },
            dataType:"JSON",
            success:function (data) {
                if (data.message=="succeeded"){
                    alert(data.object.name);
                    location.href="main.html";
                    localStorage.setItem("employeeNumber",employeeNumber);
                    localStorage.setItem("employeeName",data.object.name);
                }else {
                    alert("账号或密码错误！请重新输入");
                    document.getElementById("userId").innerText=employeeNumber;
                    document.getElementById("u-password").innerText="";
                }
            }
        })
    }
}

function forgetPassword() {

    var userId=document.getElementsByName("employeeNumber").value;
    var newPassword=document.getElementsByName("newPassword").value;
    var confirmPassword=document.getElementsByName("confirmPassword").value;
    var flag=true;

    if (userId===""){
        alert("用户账号不能为空!请输入账号");
        flag=false;
        return false;
    }
    if (newPassword===""){
        alert("密码不能为空！请输入密码");
        flag=false;
        return false;
    }
    if (newPassword!=confirmPassword){
        alert("两次输入的密码不一致，请重新输入");
        flag=false;
        return false;
    }
    if (flag==true){
        $.ajax({
            type:"POST",
            url:"http://localhost:9090/EPIMSystem/user/reset-password?employeeNumber="+userId+"&password="+newPassword,
            // data:{
            //     userId:userId,
            //     password:newPassword
            // },
            dataType:"JSON",
            success:function (data) {
                if (data.message=="succeeded") {
                    alert(data.message);
                    location.href = "login.html";
                    document.getElementsByName("employeeNumber").innerText=userId;
                }
                if (data.message=="failed"){
                    alert(data.message);
                    alert("工号不存在，请重新输入");
                }
            },
            error:function (req,status,thrown) {
                alert(333);
            }
        })
    }
}

function modifyPassword() {

    var employeeNumber=document.getElementsByName("employeeNumber").value;
    var newPassword=document.getElementsByName("newPassword").value;
    var oldPassword=document.getElementById("oldPassword").value;

    if (oldPassword==""){
        alert("旧密码不能为空！请输入密码");
        return false;
    }
    if (newPassword==""){
        alert("新密码不能为空！请输入密码");
        return false;
    }
    else {
        $.ajax({
            type:"POST",
            url:"/user/modify-password",
            data:{
                userId:employeeNumber,
                newPassword:newPassword,
                oldPassword:oldPassword
            },
            dataType:"JSON",
            success:function (data) {
                if (data.message==="succeeded") {
                    location.href = "html/login.html";
                    localStorage.setItem("userId", employeeNumber);
                }
            }
        })
    }
}

function exit() {
    localStorage.removeItem("userId");
    //top.location.href="http://localhost:9090/EPIMSystem/html/login.html";
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

function checkIn() {
    $.ajax({
        type:"POST",
        url:"http://localhost:9090/EPIMSystem/attendance/new-attendance",
        dataType:JSON,
        success:function (data) {
            if (data.message=='succeeded'){
                alert(data.message);
            }
        }
    })
}

function checkOut() {

}

function getPersonalInfo() {
    var employeeNumber=localStorage.getItem("userId");
    $.ajax({
        type:"GET",
        url:"http://localhost:9090/EPIMSystem/employee/get-employee-info",
        data:{
            employeeNumber:employeeNumber
        },
        dataType:"JSON",
        success:function (data) {
            if (data.message=='succeeded'){
                alert(data.message);
            }
        }
    })
}

function getDeptInfo(ele) {
    var deptNumber=$(ele).attr("value");
    $.ajax({
        type:"GET",
        url:"http://localhost:9090/EPIMSystem/dept/get-dept-info?deptNumber="+deptNumber,
        //dataType:JSON,
        success:function (data) {
            // var deptNum=document.getElementById("deptNumber");
            // deptNum.setAttribute("value",data.departmentNumber);
            // var name=document.getElementById("name");
            // name.setAttribute("value",data.name);
            // var manager=document.getElementById("manager");
            // manager.setAttribute("value",data.manager);
            // var tele=document.getElementById("telephone");
            // tele.setAttribute("value",data.telephone);
            // var address=document.getElementById("address");
            // address.setAttribute("value",data.address);
            // var notes=document.getElementById("notes");
            // if (data.notes!=null){
            //     notes.setAttribute("value",data.notes);
            // }
            localStorage.setItem("dataInfo",data);
            localStorage.setItem("deptN",data.departmentNumber);
            localStorage.setItem("na",data.name);
            localStorage.setItem("m",data.manager);
            localStorage.setItem("t",data.telephone);
            localStorage.setItem("a",data.address);
            localStorage.setItem("no",data.notes);
        },
        error:function () {
            alert("w2");
        }
    })
}
function deleteDept(ele) {
    var deptNumber=$(ele).attr("value");
    $.ajax({
        type:"POST",
        url:"http://localhost:9090/EPIMSystem/dept//delete-dept?deptNumber="+deptNumber,
        success:function (data) {
            location.href="departmentList.html";
            alert("删除成功");
        },
        error:function () {
            alert("删除失败，请重新操作!");
        }
    })
}
