package com.epim.entity;

import java.util.Date;

public class Employee {
    private String employeeNumber;

    private String name;

    private String gender;

    private Date birthday;

    private String telephone;

    private String email;

    private String address;

    private String photo;

    private String education;

    private String departmentNumber;

    private Date inTime;

    private String password;

    private String notes;

    public String getEmployeeNumber(){return employeeNumber;}
    public void setEmployeeNumber(String employeeNumber){this.employeeNumber=employeeNumber;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public String getGender(){return gender;}
    public void setGender(){this.gender=gender;}

    public Date getBirthday(){return birthday;}
    public void setBirthday(Date birthday){this.birthday=birthday;}

    public String getTelephone(){return telephone;}
    public void setTelephone(String telephone){this.telephone=telephone;}

    public String getEmail(){return email;}
    public void setEmail(String employee_number){this.email=email;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address=address;}

    public String getPhoto(){return photo;}
    public void setPhoto(String photo){this.photo=photo;}

    public String getEducation(){return education;}
    public void setEducation(String education){this.education=education;}

    public String getDepartmentNumber(){return departmentNumber;}
    public void setDepartmentNumber(String department_number){this.departmentNumber=department_number;}

    public Date getInTime(){return inTime;}
    public void setInTime(Date in_time){this.inTime=in_time;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}

    public String getNotes(){return notes;}
    public void setNotes(String notes){this.notes=notes;}
}
