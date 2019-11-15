package com.epim.entity;

public class User {
    private  int id;

    private String employeeNumber;

    private String name;

    private String password;

    private String power;

    public int getId(){return this.id;}
    public void setId(int id){this.id=id;}

    public String getEmployeeNumber(){return this.employeeNumber;}
    public void setEmployeeNumber(String employeeNumer){this.employeeNumber=employeeNumer;}

    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}

    public String getPassword(){return this.password;}
    public void setPassword(String password){this.password=password;}

    public String getPower(){return this.power;}
    public void setPower(String power){this.password=power;}
}
