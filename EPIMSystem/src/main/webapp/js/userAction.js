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
                localStorage.setItem("employeeNumber",employeeNumber);
                localStorage.setItem("employeeName",data.name);
                if (data.password===password){
                    if (data.power==="1"){
                        location.href="user.html";
                    }
                    if (data.power==="2") {
                        location.href = "main.html";
                    }
                }else {
                    alert("账号密码不一致!请重新输入!");
                    document.getElementById("u-password").value="";
                }
            }
        })
    }
}

function forgetPassword() {

    var id=document.getElementById("userId").value;
    var newPwd=document.getElementById("new").value;
    var confirmPwd=document.getElementById("confirm").value;
    alert(newPwd+confirmPwd);
    if (newPwd===""){
        alert("新密码不能为空！请输入密码");
    }else if (newPwd!==confirmPwd){
        alert("两次输入的密码不一致，请重新输入");
        document.getElementById("new").value="";
        document.getElementById("confirm").value="";
    }else {
        $.ajax({
            type:"GET",
            url:"http://localhost:9090/EPIMSystem/user/reset-password?id="+id+"&pwd="+newPwd,

            dataType:"JSON",
            success:function (data) {
                if (data==='1'){
                    location.href = "login.html";
                }
                else if(data==='2') {
                    alert("密码修改失败，请重试!");
                    location.href = "forgetPassword.html";
                }else {
                    location.href = "login.html";
                }
            }
        })
    }
}

function modifyPassword() {

    var id=document.getElementsByName("employeeNumber").value;
    var newPwd=document.getElementsByName("newPassword").value;
    var oldPwd=document.getElementById("oldPassword").value;

    if (oldPwd===" "){
        alert("旧密码不能为空！请输入密码");
        //return false;
    }
    if (newPwd===""){
        alert("新密码不能为空！请输入密码");
        //return false;
    }
    if (oldPwd!==newPwd){
        alert("两次密码不一致，请重新输入");
        document.getElementById("newPassword").value=" ";
        document.getElementById("oldPassword").value=" ";
        //return false;
    }
    else {
        $.ajax({
            type:"POST",
            url:"http://localhost:9090/EPIMSystem/user/modify-password?id="+id+"&oldPwd="+oldPwd+"&newPwd="+newPwd,

            dataType:"JSON",
            success:function (data) {
                if (data.object.message==="succeeded") {
                    location.href = "html/login.html";
                }
            },
            error:function () {
                alert("w");
            }
        })
    }
}

function exit() {
    localStorage.removeItem("employeeNumber");
    localStorage.removeItem("employeeName");
}

function askForLeave() {
    var id=document.getElementById("userId").value;
    var name=document.getElementById("name").value;
    var dept=document.getElementById("dept").value;
    var start=document.getElementById("start").value;
    var end=document.getElementById("end").value;
    var days=document.getElementById("days").value;
    var type=document.getElementById("type").value;
    var reason=document.getElementById("reason").value;
    var notes=document.getElementById("notes").value;

    $.ajax({
        type:"GET",
        url:"http://localhost:9090/EPIMSystem/leave/new-lea?id="+id+"&name="+name+"&dept="+dept+"&start="+start+"&end="+end
            +"&days="+days+"&type="+type+"&rea="+reason+"&notes="+notes,
        success:function (data) {
            alert("请假成功,请耐心等候批准!");
            location.href="userLeaveList.html";
        }
    })
}

function checkIn() {
    var number=localStorage.getItem("employeeNumber");
    var name=localStorage.getItem("employeeName");
    $.ajax({
        type:"GET",
        url:"http://localhost:9090/EPIMSystem/attendance/new-attendance-in?id="+number+"&name="+name,
        success:function (data) {
            if (22){
                alert("签到成功");
            }
        }
    })
}

function checkOut() {
    var number=localStorage.getItem("employeeNumber");
    var name=localStorage.getItem("employeeName");
    $.ajax({
        type:"GET",
        url:"http://localhost:9090/EPIMSystem/attendance/new-attendance-out?id="+number+"&name="+name,
        success:function (data) {
            if (data==='1'){
                alert("签退成功!");
            }else{
                alert("请先签到!")
            }
        }
    })
}

function getDeptInfo(ele) {
    var deptNumber=$(ele).attr("value");
    localStorage.setItem("deptNum",deptNumber);
}

function getEmployeeInfo(ele) {
    var employeeN=$(ele).attr("value");
    localStorage.setItem("employee",employeeN);
}

function deleteDept(ele) {
    var deptNumber=$(ele).attr("value");
    alert("确定删除该部门?");
    $.ajax({
        type:"GET",
        url:"http://localhost:9090/EPIMSystem/dept//delete-dept?deptNumber="+deptNumber,
        success:function (data) {
            alert("删除成功");
            location.href="departmentList.html";
        },
        error:function () {
            alert("删除失败，请重新操作!");
        }
    })
}

function deleteEmployee(ele) {
    var number=$(ele).attr("value");
    alert("确定删除该员工?");
    $.ajax({
        type:"GET",
        url:"http://localhost:9090/EPIMSystem/employee/delete-employee?id="+number,
        success:function (data) {
            alert("删除成功");
            location.href="employeeList.html";
        },
        error:function () {
            alert("删除失败，请重新操作!");
        }
    })
}

function modifyUserInfo() {
    var id=document.getElementById("id").value;
    var name=document.getElementById("name").value;
    var gender=document.getElementById("gender").value;
    var birth=document.getElementById("birthday").value;
    var tele=document.getElementById("phone").value;
    var email=document.getElementById("email").value;
    var native=document.getElementById("native").value;
    var edu=document.getElementById("education").value;
    var notes=document.getElementById("notes").value;
    var address=document.getElementById("address").value;

    $.ajax({
        type:"GET",
        url:"http://localhost:9090/EPIMSystem/employee/modify-user-info?id="+id+"&name="+name+"&gen="+gender+"&bir="+birth
            +"&tele="+tele+"&email="+email+"&native="+native+"&edu="+edu+"&notes="+notes+"&address="+address,
        success:function (data) {
            alert("信息修改成功!");
            location.href="personInfo.html";
        }
    })
}

function salarySet() {
    var id=document.getElementById("id").value;
    //var name=document.getElementById("name").value;
    var deduct=document.getElementById("deduct").value;
    var sub=document.getElementById("subsidy").value;

    $.ajax({
        type:"GET",
        url:"http://localhost:9090/EPIMSystem/salary/new-salary?id="+id+"&deduct="+deduct+"&sub="+sub,
        success:function (data) {
            if (data==='1'){
                alert("该员工本月奖金补贴设置成功!");
                location.href="employeeSalary.html";
            }if (data==='2'){
                alert("该员工基本薪资未设置,请先设置在进行操作!");
                location.href="employeeList.html";
            }
        },
        error:function () {
            alert("该员工本月奖金补贴设置失败,请重试!");
            location.href="employeeSalarySet.html";
        }
    })
}