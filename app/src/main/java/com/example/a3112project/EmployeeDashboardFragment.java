package com.example.a3112project;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3112project.data.Request;
import com.example.a3112project.databinding.FragmentEmployeeDashboardBinding;
import com.example.a3112project.databinding.FragmentEmployeeLoginBinding;
import com.example.a3112project.databinding.FragmentEmployerDashboardBinding;
import com.example.a3112project.MainActivity;

import java.util.ArrayList;

public class EmployeeDashboardFragment extends Fragment {



    public EmployeeDashboardFragment() {
        // Required empty public constructor
    }

    FragmentEmployeeDashboardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEmployeeDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        binding.textViewWelcomeEmployee.setText("Welcome " + MainActivity.currentEmployee.getEmployeeName() + "!");
        binding.textView7EmployeeID.setText("Employee ID: "+MainActivity.currentEmployee.getEmployeeID());
        binding.textView8CompanyName.setText("Company Name: "+MainActivity.currentEmployee.getCompanyName());

        String wage =String.format("%.2f", MainActivity.currentEmployee.getHourlyWage());
        binding.textView9EmployeeWage.setText("Wage Per Hour: $"+wage);


        //money earned
        ArrayList<Request> allRequests = MainActivity.currentEmployee.getEmployer().getRequests();
        int x = allRequests.size();
        double moneyEarned = 0;
        for (int i = 0; i <x ; i++) {
            if(allRequests.get(i).getReviewed().compareToIgnoreCase("Accepted")==0
                    && allRequests.get(i).getEmployee()== MainActivity.currentEmployee)
            {
                moneyEarned = moneyEarned + allRequests.get(i).getHoursRequested().getTotalMoneyRequested();
            }
        }
        String money =String.format("%.2f", moneyEarned);

        binding.textViewTotalMoneyEarned.setText("Money Earned: $"+money);
        binding.buttonEmployeeRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.EmployeeReview();
            }
        });

        binding.buttonLogoutEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "Employee just logged out:  " + MainActivity.currentEmployee.toString());
                MainActivity.currentEmployee = null;
                mListener.LogoutEmployee();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (EmployeeDashboardListener) context;
    }
    EmployeeDashboardListener mListener;
    interface EmployeeDashboardListener{
        void LogoutEmployee();
        void EmployeeReview();
    }
}