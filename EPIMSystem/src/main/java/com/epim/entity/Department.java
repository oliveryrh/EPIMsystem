package com.epim.entity;

public class Department {
    /*
    * 部门号
    * 主键
    * */
    private String depart_number;
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
    private String phone_number;
    /*
     *部门位置
     * */
    private String address;
    /*
     *部门备注
     * */
    private String notes;

    public String getDepart_number(){
        return depart_number;
    }
    public void setDepart_number(String depart_number){
        this.depart_number=depart_number;
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
        return phone_number;
    }
    public void setPhone_number(String phone_number){
        this.phone_number=phone_number;
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
