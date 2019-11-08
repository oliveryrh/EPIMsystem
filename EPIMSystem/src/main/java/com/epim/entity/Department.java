package com.epim.entity;

public class Department {
    /*
    * 部门号
    * 主键
    * */
    private String departmentNumber;
    /*
     *部门名称
     * */
    private String name;
    /*
     *部门经理
     * */
    private String manager;
    /*
     *部门电话
     * */
    private String telephone;
    /*
     *部门位置
     * */
    private String address;
    /*
     *部门备注
     * */
    private String notes;

    public String getDepartmentNumber(){
        return departmentNumber;
    }
    public void setDepartmentNumber(String departmentNumber){
        this.departmentNumber=departmentNumber;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getManager(){
        return manager;
    }
    public void setManager(String manager){
        this.manager=manager;
    }

    public String getPhone_number(){
        return telephone;
    }
    public void setPhone_number(String phone_number){
        this.telephone=phone_number;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }

    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes){
        this.notes=notes;
    }
}
