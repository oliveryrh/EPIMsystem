package com.epim.entity;

import java.math.BigDecimal;

public class Salary {
    private int id;

    private String employeeNumber;

    private String name;

    private String month;

    private BigDecimal basicSalary;

    private BigDecimal deduct;

    private BigDecimal finalSalary;

    public int getId(){return this.id;}
    public void setId(int id){this.id=id;}

    public String getEmployeeNumber(){return this.employeeNumber;}
    public void setEmployeeNumber(String employeeNumer){this.employeeNumber=employeeNumer;}

    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}

    public String getMonth(){return this.month;}
    public void setMonth(String month){this.month=month;}

    public BigDecimal getBasicSalary(){return this.basicSalary;}
    public void setBasicSalary(BigDecimal basicSalary){this.basicSalary=basicSalary;}

    public BigDecimal getDeduct(){return this.deduct;}
    public void setDeduct(BigDecimal deduct){this.deduct=deduct;}

    public BigDecimal getFinalSalary(){return this.finalSalary;}
    public void setFinalSalary(BigDecimal finalSalary){this.finalSalary=finalSalary;}
}
