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
import android.widget.Toast;

import com.example.a3112project.data.Employee;
import com.example.a3112project.data.Request;
import com.example.a3112project.databinding.FragmentEmployerRequestBinding;
import com.example.a3112project.databinding.FragmentUpdateEmployeeProfileBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class UpdateEmployeeProfileFragment extends Fragment {



    public UpdateEmployeeProfileFragment() {
        // Required empty public constructor
    }

    FragmentUpdateEmployeeProfileBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUpdateEmployeeProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();           }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonGoEmployeeDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.GoBackEmployerDashboard20();
            }
        });

        binding.buttonUpdateEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String employeeUsername = binding.editTextUpdateEmployeeUsername.getText().toString();
                String employeePassword = binding.editTextUpdatePassword.getText().toString();
                String employeeWage = binding.editTextUpdateEmployeeWage.getText().toString();
                //employeeWage = String.format("%.2f", employeeWage);
                DecimalFormat df = new DecimalFormat("#.##");

                // Formatting the double values using DecimalFormat
                Log.d("TAG", " employee name: " + employeeUsername);
                Log.d("TAG", "login entered password: " + employeePassword);
                //   Log.d("TAG", "login entered wage: " + employeeWage);
                if(employeePassword.isBlank() || employeeUsername.isBlank()  || employeeWage.isBlank()){
                    Toast.makeText(getActivity(), "please fill out the fields", Toast.LENGTH_LONG).show();
                }
                else{
                    Double realWage = Double.parseDouble(employeeWage);
                    String formattedNumber1 = df.format(realWage);
                    realWage = Double.parseDouble(formattedNumber1);

                    MainActivity.employeeUpdating.setEmployeeName(employeeUsername);
                    MainActivity.employeeUpdating.setPassword(employeePassword);
                    MainActivity.employeeUpdating.setHourlyWage(realWage);
                    MainActivity.employeeUpdating = null;
                    mListener.UpdateEmployee();
                }

            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (UpdateEmployeeListener) context;

    }

    UpdateEmployeeListener mListener;
    interface UpdateEmployeeListener{
        void GoBackEmployerDashboard20();
        void UpdateEmployee();
    }
}