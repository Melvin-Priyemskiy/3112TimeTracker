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
                String employerName = binding.editTextEmployeeUsername.getText().toString();
                String password = binding.editTextPassword.getText().toString();
                //String p = MainActivity.employers.get(0).getCompanyName();
                Log.d("TAG", "testing    " + MainActivity.employers.size());
             //   Log.d("TAG", "this is company name:  " + p);
//                if(password.isEmpty() || employerName.isEmpty()){
//                    Toast.makeText(getActivity(), "please fill out the fields", Toast.LENGTH_LONG);
//                }
//                else{
//                    int x = MainActivity.employers.size();
//                    for (int i = 0; i < x; i++) {
//                        String matchingName = MainActivity.employers.get(i).getCompanyName();
//                        String matchPass = MainActivity.employers.get(i).getPassword();
//                        if(matchPass.compareTo(employerName) ==)
//                    }
//                    mListener.EmployeeLoginSuccessful();
//                }

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