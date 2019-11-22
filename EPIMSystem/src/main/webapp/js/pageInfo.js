function getDeptList() {
    $.ajax({
        type:"GET",
        url:"http://localhost:9090/EPIMSystem/dept/get-dept-list",
        dataType:JSON,
        success:function (data) {

        }
    })
}

function getDeptInfo() {

}