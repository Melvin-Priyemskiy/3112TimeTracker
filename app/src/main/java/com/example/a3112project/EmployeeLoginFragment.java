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

import com.example.a3112project.data.Employer;
import com.example.a3112project.databinding.FragmentEmployeeLoginBinding;
import com.example.a3112project.databinding.FragmentEmployerLoginBinding;

import java.time.chrono.MinguoChronology;


public class EmployeeLoginFragment extends Fragment {

    public EmployeeLoginFragment() {
        // Required empty public constructor
    }
    FragmentEmployeeLoginBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEmployeeLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonGoHomeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.GoBackHomeFragment3();
            }
        });

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String employeeID = binding.editTextEmployeeID.getText().toString();
                String password = binding.editTextPassword.getText().toString();
                String companyName = binding.editTextCompanyNameEmployee.getText().toString();
                boolean companyExists = false;
                Employer chosenEmployer = null;


                Log.d("TAG", "companyName: " + companyName);
                Log.d("TAG", "login entered company name: " + employeeID);
                Log.d("TAG", "login entered password: " + password);

                if(password.isBlank() || employeeID.isBlank() || companyName.isBlank()){
                    Toast.makeText(getActivity(), "please fill out the fields", Toast.LENGTH_LONG).show();
                }
                else{
                    //checking that the company name exists
                    int x = MainActivity.employers.size();

                    for (int i = 0; i < x; i++)
                    {
                        if(companyName.compareToIgnoreCase(MainActivity.employers.get(i).getCompanyName()) == 0){
                            companyExists = true;
                            chosenEmployer = MainActivity.employers.get(i);
                        }
                    }

                }
                if(companyExists)
                {
                    //checking if the employee is in the system
                    int x = chosenEmployer.getEmployees().size();
                    boolean loginFailed = true;
                    for (int i = 0; i < x; i++) {
                        String matchingID = chosenEmployer.getEmployees().get(i).getEmployeeID();
                        String matchPass = chosenEmployer.getEmployees().get(i).getPassword();
                        if(matchingID.compareToIgnoreCase(employeeID) == 0 && matchPass.compareTo(password) ==0){
                            MainActivity.currentEmployee = chosenEmployer.getEmployees().get(i);
                            loginFailed = false;
                            mListener.EmployeeLoginSuccessful();
                        }
                    }
                    if(loginFailed)
                    {
                        Toast.makeText(getActivity(), "credientials incorrect", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getActivity(), "company does not exist", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (EmployeeLoginListener) context;

    }

    EmployeeLoginListener mListener;
    interface EmployeeLoginListener{
        void EmployeeLoginSuccessful();
        void GoBackHomeFragment3();
    }
}