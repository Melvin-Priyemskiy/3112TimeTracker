package com.example.a3112project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a3112project.data.Employee;
import com.example.a3112project.data.Employer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HomeFragment.HomeListener,
        EmployerLoginFragment.EmployerLoginListener, EmployerCreateAccountFragment.EmployerCreateAccount,
        EmployeeLoginFragment.EmployeeLoginListener, EmployerDashboardFragment.EmployerDashboardListener,
        AddEmployeeFragment.AddEmployeeListener
{
    public static ArrayList<Employer> employers = new ArrayList<>();
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static Employer currentEmployer = new Employer();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new HomeFragment())
                .addToBackStack(null)
                .commit();

    }


    @Override
    public void EmployeeLogin() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployeeLoginFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void EmployerLogin() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployerLoginFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void EmployeeCreateAccount() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployerCreateAccountFragment())
                .addToBackStack(null)
                .commit();
    }
////////////////////////////////////////////////////////////////////
    @Override
    public void EmployerLoginSuccessful() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployerDashboardFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void GoBackHomeFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new HomeFragment())
                .addToBackStack(null)
                .commit();    }

    @Override
    public void AuthSuccessfulCreateAccount() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployerLoginFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void GoBackHomeFragment2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new HomeFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void EmployeeLoginSuccessful() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployeeDashboardFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void GoBackHomeFragment3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new HomeFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void AddNewEmployee() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new AddEmployeeFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void GoBackHomeFragment4() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new HomeFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void AddNewEmployeeFinish() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployerDashboardFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void GoBackEmployerDashboard() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployerDashboardFragment())
                .addToBackStack(null)
                .commit();
    }
}