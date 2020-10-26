package com.example.databindingrecycleview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databindingrecycleview.OnRecycleViewClick;
import com.example.databindingrecycleview.R;
import com.example.databindingrecycleview.bean.Employee;
import com.example.databindingrecycleview.databinding.EmployeeRowLayoutBinding;

import java.util.ArrayList;

public class EmployeeDataAdapter extends RecyclerView.Adapter<EmployeeDataAdapter.EmployeeViewHolder> {

    private ArrayList<Employee> employees;

    private OnRecycleViewClick itemClick;

    public EmployeeDataAdapter() {
    }

    public EmployeeDataAdapter(OnRecycleViewClick itemClick) {
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EmployeeRowLayoutBinding employeeRowLayoutBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.employee_row_layout, parent, false);
        return new EmployeeViewHolder(employeeRowLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee currentEmp = employees.get(position);
        holder.bind(currentEmp,itemClick);
    }

    @Override
    public int getItemCount() {
        if (employees != null) {
            return employees.size();
        } else {
            return 0;
        }
    }

    public void setEmployeeList(ArrayList<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private EmployeeRowLayoutBinding mBinding;

        public EmployeeViewHolder(@NonNull EmployeeRowLayoutBinding employeeRowLayoutBinding) {
            super(employeeRowLayoutBinding.getRoot());
            this.mBinding = employeeRowLayoutBinding;
        }

        public void bind(@NonNull Employee mEmployee, OnRecycleViewClick itemClick) {
            mBinding.setEmployee(mEmployee);
            mBinding.executePendingBindings();
            mBinding.setItemclick(itemClick);
        }
    }
}
