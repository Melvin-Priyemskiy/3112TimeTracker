package com.example.a3112project.data;

import java.util.Arrays;

public class Week {
    private int[] hoursWorked;
    double totalMoneyRequested;
    int totalHours;

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public Week(int[] hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int[] getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int[] hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getTotalMoneyRequested() {
        return totalMoneyRequested;
    }

    public void setTotalMoneyRequested(double totalMoneyRequested) {
        this.totalMoneyRequested = totalMoneyRequested;
    }

    @Override
    public String toString() {
        return "Week{" +
                "hoursWorked=" + Arrays.toString(hoursWorked) +
                '}';
    }
}
