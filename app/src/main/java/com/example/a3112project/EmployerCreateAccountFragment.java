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
import com.example.a3112project.data.Request;
import com.example.a3112project.databinding.FragmentEmployerCreateAccountBinding;
import com.example.a3112project.databinding.FragmentEmployerLoginBinding;
import com.example.a3112project.MainActivity;

import java.util.ArrayList;


public class EmployerCreateAccountFragment extends Fragment {



    public EmployerCreateAccountFragment() {
        // Required empty public constructor
    }

    FragmentEmployerCreateAccountBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEmployerCreateAccountBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //getting the text

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.GoBackHomeFragment2();
            }
        });

        binding.buttonEmployerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String employerName = binding.editTextCompanyName.getText().toString();
                String password = binding.editTextPassword.getText().toString();
                ArrayList<Employee> employees = new ArrayList<>();
                ArrayList<Request> requests = new ArrayList<>();
                Log.d("TAG", "onClick: this is the password " + password);
                if(password.isBlank() || employerName.isBlank()){
                    Toast.makeText(getActivity(), "please fill out the fields", Toast.LENGTH_LONG).show();
                }
                else{
                    //Make sure employername is unique
                    int x = MainActivity.employers.size();
                    boolean uniqueEmployer = true;
                    for (int i = 0; i < x; i++) {
                        if(employerName.compareToIgnoreCase(MainActivity.employers.get(i).getCompanyName()) == 0){
                            uniqueEmployer = false;

                        }
                    }
                    if(uniqueEmployer)
                    {
                        Employer addingEmployer = new Employer(password,employerName, employees, requests);
                        addingEmployer.setTotalAmountPaid(0);
                        MainActivity.employers.add(addingEmployer);
                        //when the employer information is correct then go to the dashboard
                        mListener.AuthSuccessfulCreateAccount();
                    }
                    else{
                        Toast.makeText(getActivity(), "Company name is not unique", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (EmployerCreateAccount) context;

    }
    EmployerCreateAccount mListener;
    interface EmployerCreateAccount{
        void AuthSuccessfulCreateAccount();
        void GoBackHomeFragment2();
    }
}