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
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.a3112project.data.Employee;
import com.example.a3112project.data.Request;
import com.example.a3112project.data.Week;
import com.example.a3112project.databinding.FragmentEmployeeRequestBinding;
import com.example.a3112project.databinding.FragmentEmployerCreateAccountBinding;
import com.example.a3112project.MainActivity;
public class EmployeeRequestFragment extends Fragment {

    Employee mEmployee = MainActivity.currentEmployee;

    public EmployeeRequestFragment() {
        // Required empty public constructor
    }

    FragmentEmployeeRequestBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEmployeeRequestBinding.inflate(inflater, container, false);
        return binding.getRoot();    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textViewProgress.setText(""+i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {  }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {   }
        });
        binding.seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textViewProgress2.setText(""+i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {  }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {   }
        });
        binding.seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textViewProgress3.setText(""+i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {  }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {   }
        });
        binding.seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textViewProgress4.setText(""+i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {  }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {   }
        });
        binding.seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textViewProgress5.setText(""+i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {  }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {   }
        });


        binding.buttonGoEmployeeDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.GoBackAllRequests();
            }
        });

        binding.buttonNewEmployeeRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int monHours = Integer.parseInt(binding.textViewProgress.getText().toString());
                int tuesHours = Integer.parseInt(binding.textViewProgress2.getText().toString());
                int wednesHours = Integer.parseInt(binding.textViewProgress3.getText().toString());
                int thursHours = Integer.parseInt(binding.textViewProgress4.getText().toString());
                int friHours = Integer.parseInt(binding.textViewProgress5.getText().toString());
                int[] myArray = {monHours, tuesHours, wednesHours, thursHours, friHours};
                Week week = new Week(myArray);
                int hours = monHours+ tuesHours+ wednesHours+ thursHours+ friHours;
                week.setTotalHours(hours);
                week.setTotalMoneyRequested(hours*MainActivity.currentEmployee.getHourlyWage());
                Log.d("TAG", "Inside the week array: " + week.toString());
                Request request = new Request();
                request.setEmployee(mEmployee);
                request.setHoursRequested(week);
                request.setReviewed("Not Reviewed");
                Log.d("TAG", "Inside Request: " + request.toString());
                mEmployee.getEmployer().getRequests().add(request);
                mListener.SubmitRequest();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (EmployeeRequestListener) context;

    }
    EmployeeRequestListener mListener;
    interface EmployeeRequestListener{
        void SubmitRequest();
        void GoBackAllRequests();
    }
}