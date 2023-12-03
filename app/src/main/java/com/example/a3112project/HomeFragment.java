package com.example.a3112project;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3112project.databinding.FragmentEmployerLoginBinding;
import com.example.a3112project.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }


    FragmentHomeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        binding.button2EmployerCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.EmployeeCreateAccount();
            }
        });

        binding.buttonEmployeeLoginHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.EmployeeLogin();
            }
        });

        binding.buttonEmployerLoginHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.EmployerLogin();
            }
        });
    }
    HomeListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (HomeListener) context;
    }

    interface HomeListener{
        void EmployeeLogin();
        void EmployerLogin();
        void EmployeeCreateAccount();

    }}