package com.example.a3112project.data;

import java.util.ArrayList;

public class Request {
    private Employee employee;
    private boolean reviewed;
    private int hoursRequested;

    public Request() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }

    public int getHoursRequested() {
        return hoursRequested;
    }

    public void setHoursRequested(int hoursRequested) {
        this.hoursRequested = hoursRequested;
    }
}
