package com.example.a3112project;

import android.annotation.SuppressLint;
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
import com.example.a3112project.databinding.FragmentEmployerDashboardBinding;
import com.example.a3112project.databinding.FragmentEmployerRequestBinding;
import com.example.a3112project.MainActivity;
import com.example.a3112project.databinding.RequestemployeeRowItemBinding;
import com.example.a3112project.databinding.RequestemployerRowItemBinding;

import java.util.ArrayList;


public class EmployerRequestFragment extends Fragment {



    public EmployerRequestFragment() {
        // Required empty public constructor
    }

    ArrayList<Request> mRequests = new ArrayList<>();
    FragmentEmployerRequestBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentEmployerRequestBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    EmployerRequestAdapter adapter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Request> allRequests = MainActivity.currentEmployer.getRequests();
        int x = allRequests.size();
        for (int i = 0; i <x ; i++) {
            if(allRequests.get(i).getReviewed().compareToIgnoreCase("Not Reviewed")==0)
            {
                mRequests.add(allRequests.get(i));
            }
        }



        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new EmployerRequestAdapter();
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        binding.buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.GoBackEmployerDashboard4();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (EmployerRequestListener) context;

    }

    EmployerRequestListener mListener;
    interface EmployerRequestListener{
        void GoBackEmployerDashboard4();
    }

    class EmployerRequestAdapter extends RecyclerView.Adapter<EmployerRequestAdapter.EmployerRequestViewHolder>{

        @NonNull
        @Override
        public EmployerRequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            RequestemployerRowItemBinding itemBinding = RequestemployerRowItemBinding.inflate(getLayoutInflater(), parent, false);
            return new EmployerRequestViewHolder(itemBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull EmployerRequestViewHolder holder, int position) {
            Request request = mRequests.get(position);
            holder.setupUI(request);
        }

        @Override
        public int getItemCount() {
            return mRequests.size();
        }

        class EmployerRequestViewHolder extends RecyclerView.ViewHolder{
            RequestemployerRowItemBinding mBinding;
            Request mRequest;
            public EmployerRequestViewHolder(RequestemployerRowItemBinding itemBinding) {
                super(itemBinding.getRoot());
                mBinding = itemBinding;
            }

            @SuppressLint("SetTextI18n")
            public void setupUI(Request request){
                this.mRequest = request;
                mBinding.textViewNameID.setText("Employee Name: "+mRequest.getEmployee().getEmployeeName() + "  Employee ID: " + mRequest.getEmployee().getEmployeeID());
                mBinding.textViewHoursWorked.setText("Hours Worked: " + mRequest.getHoursRequested().getTotalHours());


                String money =String.format("%.2f", mRequest.getHoursRequested().getTotalMoneyRequested());
                mBinding.textViewAmountdue.setText("Amount Due: $"+money);


                mBinding.imageViewDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mRequest.setReviewed("Rejected");
                        mRequests.remove(mRequest);
                        adapter.notifyDataSetChanged();
                    }
                });

                mBinding.imageViewInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mRequest.setReviewed("Accepted");
                        mRequests.remove(mRequest);
                        adapter.notifyDataSetChanged();
                    }
                });


            }

        }
    }


}