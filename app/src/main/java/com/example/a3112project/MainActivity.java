package com.example.a3112project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a3112project.data.Employee;
import com.example.a3112project.data.Employer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HomeFragment.HomeListener,
        EmployerLoginFragment.EmployerLoginListener, EmployerCreateAccountFragment.EmployerCreateAccount,
        EmployeeLoginFragment.EmployeeLoginListener, EmployerDashboardFragment.EmployerDashboardListener,
        AddEmployeeFragment.AddEmployeeListener, EmployeeDashboardFragment.EmployeeDashboardListener,
        EmployeeViewAcceptedRequestFragment.EmployeeLogHours, EmployeeRequestFragment.EmployeeRequestListener,
        EmployerRequestFragment.EmployerRequestListener, UpdateEmployeeProfileFragment.UpdateEmployeeListener
{
    public static ArrayList<Employer> employers = new ArrayList<>();
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static Employer currentEmployer = new Employer();
    public static Employee currentEmployee = new Employee();

    public static Employee employeeUpdating = new Employee();


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
    public void GoToReq() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployerRequestFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void GoToUpdateEmployee() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UpdateEmployeeProfileFragment())
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

    @Override
    public void LogoutEmployee() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new HomeFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void EmployeeReview() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployeeViewAcceptedRequestFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goBackEmployeeDashboard2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployeeDashboardFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void AddWeekHours() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployeeRequestFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void SubmitRequest() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployeeViewAcceptedRequestFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void GoBackAllRequests() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployeeViewAcceptedRequestFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void GoBackEmployerDashboard4() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployerDashboardFragment())
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void GoBackEmployerDashboard20() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployerDashboardFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void UpdateEmployee() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new EmployerDashboardFragment())
                .addToBackStack(null)
                .commit();
    }
}