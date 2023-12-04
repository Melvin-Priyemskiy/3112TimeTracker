package com.example.a3112project.data;

import java.util.ArrayList;

public class Request {
    private Employee employee;
    private String reviewed;
    private Week hoursRequested;

    public Request() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getReviewed() {
        return reviewed;
    }

    public void setReviewed(String reviewed) {
        this.reviewed = reviewed;
    }

    public Week getHoursRequested() {
        return hoursRequested;
    }

    public void setHoursRequested(Week hoursRequested) {
        this.hoursRequested = hoursRequested;
    }

    @Override
    public String toString() {
        return "Request{" +
                "employee=" + employee +
                ", reviewed='" + reviewed + '\'' +
                ", hoursRequested=" + hoursRequested.toString() +
                '}';
    }
}
