package com.epim.entity;

import java.util.Date;

public class Attendance {
    /*
    *
    * */
    private  int id;
    /*
     *
     * */
    private String employeeNumber;

    private String name;
    /*
     *
     * */
    private String day;
    /*
     *
     * */
    private String timeType;
    /*
     *
     * */
    private String startTime;
    /*
     *
     * */
    private String startType;
    /*
     *
     * */
    private String endTime;
    /*
     *
     * */
    private String endType;
    /*
     *
     * */
    private String workType;
    /*
     *
     * */
    private String notes;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}

    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }

    public String getTimeType() {
        return timeType;
    }
    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartType() {
        return startType;
    }
    public void setStartType(String startType) {
        this.startType = startType;
    }

    public String getEndType() {
        return endType;
    }
    public void setEndType(String endType) {
        this.endType = endType;
    }

    public String getWorkType() {
        return workType;
    }
    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
