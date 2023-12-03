package com.example.a3112project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3112project.databinding.FragmentEmployeeDashboardBinding;
import com.example.a3112project.databinding.FragmentEmployeeLoginBinding;
import com.example.a3112project.databinding.FragmentEmployerDashboardBinding;


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
        return binding.getRoot();    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}