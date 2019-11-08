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
    /*
     *
     * */
    private Date day;
    /*
     *
     * */
    private String timeType;
    /*
     *
     * */
    private Date startTime;
    /*
     *
     * */
    private String startType;
    /*
     *
     * */
    private Date endTime;
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
    public Date getDay() {
        return day;
    }
    public void setDay(Date day) {
        this.day = day;
    }
    public String getTimeType() {
        return timeType;
    }
    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
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
