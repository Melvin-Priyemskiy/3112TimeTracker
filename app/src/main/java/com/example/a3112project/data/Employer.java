package com.example.a3112project.data;

import java.util.ArrayList;

public class Employer
{
    private String password;
    private String companyName;
    private ArrayList<Employee> employees;
    private ArrayList<Request> requests;

    public Employer() {
    }


    public Employer(String password, String companyName, ArrayList<Employee> employees, ArrayList<Request> requests) {
        this.password = password;
        this.companyName = companyName;
        this.employees = employees;
        this.requests = requests;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
