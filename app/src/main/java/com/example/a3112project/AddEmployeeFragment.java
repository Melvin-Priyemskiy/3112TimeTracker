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
import com.example.a3112project.data.Employer;
import com.example.a3112project.databinding.FragmentAddEmployeeBinding;
import com.example.a3112project.databinding.FragmentEmployerDashboardBinding;
import com.example.a3112project.MainActivity;
import java.text.DecimalFormat;


public class AddEmployeeFragment extends Fragment {



    public AddEmployeeFragment() {
        // Required empty public constructor
    }


    FragmentAddEmployeeBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddEmployeeBinding.inflate(inflater, container, false);
        return binding.getRoot();    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonAddNewEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String employeeUsername = binding.editTextAddEmployeeUsername.getText().toString();
                String employeeID = binding.editTextAddEmployeeID.getText().toString();
                String employeePassword = binding.editTextPassword.getText().toString();
                String employeeWage = binding.editTextEmployeeWage.getText().toString();
                //employeeWage = String.format("%.2f", employeeWage);
                DecimalFormat df = new DecimalFormat("#.##");

                // Formatting the double values using DecimalFormat


                Log.d("TAG", " employee name: " + employeeUsername);
                Log.d("TAG", "login entered password: " + employeePassword);
             //   Log.d("TAG", "login entered wage: " + employeeWage);
                if(employeePassword.isBlank() || employeeUsername.isBlank() || employeeID.isBlank() || employeeWage.isBlank()){
                    Toast.makeText(getActivity(), "please fill out the fields", Toast.LENGTH_LONG).show();
                }
                else{
                    Double realWage = Double.parseDouble(employeeWage);
                    String formattedNumber1 = df.format(realWage);
                    realWage = Double.parseDouble(formattedNumber1);
                    boolean uniqueID = true;
                    //making sure there is no dupes for employeeID
                    int sizeOfEmployees = MainActivity.currentEmployer.getEmployees().size();
                    for (int i = 0; i < sizeOfEmployees; i++) {
                        String loopEmployeeID = MainActivity.currentEmployer.getEmployees().get(i).getEmployeeID();
                        if(loopEmployeeID.compareTo(employeeID)==0)
                        {
                            Toast.makeText(getActivity(), "Enter a unique employee ID", Toast.LENGTH_LONG).show();
                            uniqueID = false;
                        }
                    }
                    if(uniqueID)
                    {
                        Employee createdEmployee = new Employee();
                        createdEmployee.setEmployeeID(employeeID);
                        createdEmployee.setEmployeeName(employeeUsername);
                        createdEmployee.setPassword(employeePassword);
                        createdEmployee.setHourlyWage(realWage);
                        createdEmployee.setCompanyName(MainActivity.currentEmployer.getCompanyName());
                        createdEmployee.setEmployer(MainActivity.currentEmployer);
                        Log.d("TAG", createdEmployee.toString());
                        MainActivity.currentEmployer.getEmployees().add(createdEmployee);
                        mListener.AddNewEmployeeFinish();
                    }
                }

            }
        });
        binding.buttonGoEmployerDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.GoBackEmployerDashboard();
            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (AddEmployeeListener) context;

    }

    AddEmployeeListener mListener;
    interface AddEmployeeListener{
        void AddNewEmployeeFinish();
        void GoBackEmployerDashboard();
    }
}