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

import com.example.a3112project.data.Request;
import com.example.a3112project.databinding.FragmentEmployeeDashboardBinding;
import com.example.a3112project.databinding.FragmentEmployeeViewAcceptedRequestBinding;
import com.example.a3112project.databinding.RequestemployeeRowItemBinding;

import java.util.ArrayList;


public class EmployeeViewAcceptedRequestFragment extends Fragment {


    public EmployeeViewAcceptedRequestFragment() {
        // Required empty public constructor
    }

    ArrayList<Request> mRequest = new ArrayList<>();




    FragmentEmployeeViewAcceptedRequestBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        binding = FragmentEmployeeViewAcceptedRequestBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    RequestAdapter adapter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Request> allRequests = MainActivity.currentEmployee.getEmployer().getRequests();
        int x = allRequests.size();
        for (int i = 0; i <x ; i++) {
            if(allRequests.get(i).getEmployee() == MainActivity.currentEmployee)
            {
                mRequest.add(allRequests.get(i));
            }
        }

        binding.buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.goBackEmployeeDashboard2();
            }
        });
        binding.imageViewLogHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.AddWeekHours();
            }
        });

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter =  new RequestAdapter();
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (EmployeeLogHours) context;

    }

    EmployeeLogHours mListener;
    interface EmployeeLogHours{
        void goBackEmployeeDashboard2();
        void AddWeekHours();
    }

    class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestViewHolder>{
        @NonNull
        @Override
        public RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            RequestemployeeRowItemBinding itemBinding = RequestemployeeRowItemBinding.inflate(getLayoutInflater(), parent, false);
            return new RequestViewHolder(itemBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull RequestViewHolder holder, int position) {
            Request request = mRequest.get(position);
            holder.setupUI(request);
        }

        @Override
        public int getItemCount() {
            return mRequest.size();
        }

        class RequestViewHolder extends RecyclerView.ViewHolder{
            RequestemployeeRowItemBinding mBinding;
            Request mRequest;

            public RequestViewHolder(RequestemployeeRowItemBinding itemBinding) {
                super(itemBinding.getRoot());
                mBinding = itemBinding;
            }
            public void setupUI(Request request){
                this.mRequest = request;
                mBinding.textViewHoursSubmitted.setText("Hours Submitted: "+mRequest.getHoursRequested().getTotalHours());
                mBinding.textViewStatus.setText("Status: " + mRequest.getReviewed());
                String money =String.format("%.2f", mRequest.getHoursRequested().getTotalMoneyRequested());

                mBinding.textViewAmount.setText("Amount: $"+ money);

                mBinding.imageViewDelete.setVisibility(View.INVISIBLE);
                mBinding.imageViewInfo.setVisibility(View.INVISIBLE);
            }
        }
    }

}