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
import com.example.a3112project.databinding.FragmentEmployerLoginBinding;
import com.example.a3112project.MainActivity;

import java.util.ArrayList;

public class EmployerLoginFragment extends Fragment {



    public EmployerLoginFragment() {
        // Required empty public constructor
    }


    FragmentEmployerLoginBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        binding = FragmentEmployerLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonGoToHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.GoBackHomeFragment();
            }
        });

        binding.buttonEmployerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the login is successful then go to the employerdashboard

                String employerName = binding.editTextCompanyName.getText().toString();
                String password = binding.editTextPassword.getText().toString();
                String p = MainActivity.employers.get(0).getCompanyName();
                Log.d("TAG", "Index 0 employer company name: " + p);
                Log.d("TAG", "login entered company name: " + employerName);
                Log.d("TAG", "login entered password: " + password);

                if(password.isBlank() || employerName.isBlank()){
                    Toast.makeText(getActivity(), "please fill out the fields", Toast.LENGTH_LONG).show();
                }
                else{
                    int x = MainActivity.employers.size();
                    for (int i = 0; i < x; i++) {
                        String matchingName = MainActivity.employers.get(i).getCompanyName();
                        String matchPass = MainActivity.employers.get(i).getPassword();
                        if(matchingName.compareToIgnoreCase(employerName) == 0 && matchPass.compareTo(password) ==0){
                            MainActivity.currentEmployer = MainActivity.employers.get(i);
                            mListener.EmployerLoginSuccessful();
                        }
                    }
                }

            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (EmployerLoginListener) context;

    }

    EmployerLoginListener mListener;
    interface EmployerLoginListener{
        void EmployerLoginSuccessful();
        void GoBackHomeFragment();
    }
}