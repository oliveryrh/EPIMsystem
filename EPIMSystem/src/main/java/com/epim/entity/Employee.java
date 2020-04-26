package com.epim.entity;


public class Employee {
    private String employeeNumber;

    private String name;

    private String position;

    private String gender;

    private String birthday;

    private String telephone;

    private String email;

    private String address;

    private String nativeLand;

    private String education;

    private String departmentNumber;

    private String inTime;

    private String password;

    private String notes;

    private String power;

    private String basicSalary;

    public String getEmployeeNumber(){return employeeNumber;}
    public void setEmployeeNumber(String employeeNumber){this.employeeNumber=employeeNumber;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public String getPosition(){return position;}
    public void setPosition(String position){this.position=position;}

    public String getGender(){return gender;}
    public void setGender(String gender){this.gender=gender;}

    public String getBirthday(){return birthday;}
    public void setBirthday(String birthday){this.birthday=birthday;}

    public String getTelephone(){return telephone;}
    public void setTelephone(String telephone){this.telephone=telephone;}

    public String getEmail(){return email;}
    public void setEmail(String employee_number){this.email=email;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address=address;}

    public String getEducation(){return education;}
    public void setEducation(String education){this.education=education;}

    public String getDepartmentNumber(){return departmentNumber;}
    public void setDepartmentNumber(String department_number){this.departmentNumber=department_number;}

    public String getInTime(){return inTime;}
    public void setInTime(String inTime){this.inTime=inTime;}

    public String getPassword(){return this.password;}
    public void setPassword(String password){this.password=password;}

    public String getNotes(){return notes;}
    public void setNotes(String notes){this.notes=notes;}

    public String getNativeLand(){return nativeLand;}
    public void setNativeLand(String nativeLand){this.nativeLand=nativeLand;}

    public String getPower(){return this.power;}
    public void setPower(String position){this.power=power;}

    public String getBasicSalary(){return basicSalary;}
    public void setBasicSalary(String basicSalary){this.basicSalary=basicSalary;}
}
