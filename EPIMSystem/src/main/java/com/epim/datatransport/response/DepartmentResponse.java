package com.epim.datatransport.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

public class DepartmentResponse extends BaseResponse{
    @JSONField(name = "department")
    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Department append(){
        if (this.departments==null){
            this.departments=new ArrayList<Department>();
        }
        Department object=this.new Department();
        this.departments.add(object);
        return object;
    }
    public void remove(Department object){
        if (this.departments!=null)
            this.departments.remove(object);
    }

    public class Department{
        /*
         * 部门号
         * 主键
         * */
        @JSONField(name = "department")
        private String departmentNumber;
        /*
         *部门名称
         * */
        @JSONField(name = "name")
        private String name;
        /*
         *部门经理
         * */
        @JSONField(name = "manager")
        private String manager;
        /*
         *部门电话
         * */
        @JSONField(name = "telephone")
        private String telephone;
        /*
         *部门位置
         * */
        @JSONField(name = "address")
        private String address;
        /*
         *部门备注
         * */
        @JSONField(name = "notes")
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
}
