package com.epim.datatransport.request;

import com.alibaba.fastjson.annotation.JSONField;

public class UserRequest {
    @JSONField(name = "id")
    private  int id;

    @JSONField(name = "employeeNumber")
    private String employeeNumber;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "password")
    private String password;

    @JSONField(name = "salt")
    private String salt;

    @JSONField(name = "power")
    private String power;

    public int getId(){return this.id;}
    public void setId(int id){this.id=id;}

    public String getEmployeeNumber(){return this.employeeNumber;}
    public void setEmployeeNumber(String employeeNumber){this.employeeNumber=employeeNumber;}

    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}

    public String getPassword(){return this.password;}
    public void setPassword(String password){this.password=password;}

    public String getSalt(){return this.salt;}
    public void setSalt(String salt){this.salt=salt;}

    public String getPower(){return this.power;}
    public void setPower(String power){this.power=power;}
}
