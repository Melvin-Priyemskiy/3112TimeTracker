package com.example.a3112project;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3112project.data.Employee;
import com.example.a3112project.databinding.EmployeeRowItemBinding;
import com.example.a3112project.databinding.FragmentEmployerDashboardBinding;
import com.example.a3112project.databinding.FragmentEmployerLoginBinding;
import com.example.a3112project.MainActivity;

import java.util.ArrayList;

public class EmployerDashboardFragment extends Fragment {

    ArrayList<Employee> mEmployees = MainActivity.currentEmployer.getEmployees();

    public EmployerDashboardFragment() {
        // Required empty public constructor
    }

    FragmentEmployerDashboardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEmployerDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    EmployeeAdapter adapter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Welcome " +MainActivity.currentEmployer.getCompanyName() +"!");
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new EmployeeAdapter();
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //amount total amount paid

        String money =String.format("%.2f", MainActivity.currentEmployer.getTotalAmountPaid());
        binding.textView4.setText("Total Amount Paid: $"+ money);


        binding.buttonEmployerReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.GoToReq();
            }
        });

        binding.buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.currentEmployer = null;
                mListener.GoBackHomeFragment4();
            }
        });

        binding.imageViewAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.AddNewEmployee();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (EmployerDashboardListener) context;

    }

    EmployerDashboardListener mListener;
    interface EmployerDashboardListener{
        void AddNewEmployee();
        void GoBackHomeFragment4();
        void GoToReq();
        void GoToUpdateEmployee();
    }

    class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>
    {
        @NonNull
        @Override
        public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            EmployeeRowItemBinding itemBinding = EmployeeRowItemBinding.inflate(getLayoutInflater(), parent, false);
            return new EmployeeViewHolder(itemBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
            Employee employee = mEmployees.get(position);
            holder.setupUI(employee);
        }

        @Override
        public int getItemCount() {
            return mEmployees.size();
        }

        class EmployeeViewHolder extends RecyclerView.ViewHolder
        {
            EmployeeRowItemBinding mBinding;
            Employee mEmployee;
            public EmployeeViewHolder(EmployeeRowItemBinding itemBinding) {
                super(itemBinding.getRoot());
                mBinding = itemBinding;
            }
            public void setupUI(Employee employee){
                this.mEmployee = employee;
                mBinding.textViewEmployeeName.setText("Employee Name: "+mEmployee.getEmployeeName());
                mBinding.textViewEmployeeID.setText("Employee ID: "+mEmployee.getEmployeeID());
                String money =String.format("%.2f", mEmployee.getHourlyWage());

                mBinding.textViewWage.setText("Wage Per Hour: $"+money);

                mBinding.imageViewDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mEmployees.remove(employee);
                        notifyDataSetChanged();
                    }
                });
                mBinding.cardViewEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MainActivity.employeeUpdating = employee;
                        mListener.GoToUpdateEmployee();
                    }
                });

            }
        }
    }
}