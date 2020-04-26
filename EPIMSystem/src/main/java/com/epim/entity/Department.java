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
    public void setDepartmentNumber(String department_number){
        this.departmentNumber=department_number;
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

    public String getTelephone(){
        return telephone;
    }
    public void setTelephone(String telephone){
        this.telephone=telephone;
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
