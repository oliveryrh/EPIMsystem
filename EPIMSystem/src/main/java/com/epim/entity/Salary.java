package com.epim.entity;

import java.math.BigDecimal;

public class Salary {
    private int id;

    private String employeeNumber;

    private String name;

    private String position;

    private String month;

    private String attendanceDays;

    private String basicSalary;

    private String deduct;

    private String subsidy;

    private String finalSalary;

    private String tax;

    private String insurance;

    public int getId(){return this.id;}
    public void setId(int id){this.id=id;}

    public String getEmployeeNumber(){return this.employeeNumber;}
    public void setEmployeeNumber(String employeeNumber){this.employeeNumber=employeeNumber;}

    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}

    public String getPosition(){return this.position;}
    public void setPosition(String position){this.position=position;}

    public String getMonth(){return this.month;}
    public void setMonth(String month){this.month=month;}

    public String getAttendanceDays(){return this.attendanceDays;}
    public void setAttendanceDays(String attendanceDays){this.attendanceDays=attendanceDays;}

    public String getBasicSalary(){return this.basicSalary;}
    public void setBasicSalary(String basicSalary){this.basicSalary=basicSalary;}

    public String getDeduct(){return this.deduct;}
    public void setDeduct(String deduct){this.deduct=deduct;}

    public String getSubsidy(){return this.subsidy;}
    public void setSubsidy(String subsidy){this.subsidy=subsidy;}

    public String getTax(){return tax;}
    public void setTax(String tax){this.tax=tax;}

    public String getInsurance(){return insurance;}
    public void setInsurance(String insurance){this.insurance=insurance;}

    public String getFinalSalary(){return this.finalSalary;}
    public void setFinalSalary(String finalSalary){this.finalSalary=finalSalary;}
}
