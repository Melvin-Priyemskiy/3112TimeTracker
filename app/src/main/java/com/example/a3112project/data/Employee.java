package com.example.a3112project.data;

import java.util.ArrayList;

public class Employee {
    private ArrayList<Week> weeksWorked;
    private String companyName;
    private String password;
    private double hourlyWage;

    private String username;
    private String employeeName;
    private String employeeID;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Employee() {
    }

    public ArrayList<Week> getWeeksWorked() {
        return weeksWorked;
    }

    public void setWeeksWorked(ArrayList<Week> weeksWorked) {
        this.weeksWorked = weeksWorked;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "weeksWorked=" + weeksWorked +
                ", companyName='" + companyName + '\'' +
                ", password='" + password + '\'' +
                ", hourlyWage=" + hourlyWage +
                ", username='" + username + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeID='" + employeeID + '\'' +
                '}';
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
