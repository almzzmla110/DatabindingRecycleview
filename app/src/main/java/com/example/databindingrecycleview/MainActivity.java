package com.example.databindingrecycleview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databindingrecycleview.adapter.EmployeeDataAdapter;
import com.example.databindingrecycleview.bean.Employee;
import com.example.databindingrecycleview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private EmployeeDataAdapter employeeDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        // bind RecyclerView
        RecyclerView recyclerView = activityMainBinding.viewEmployees;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
//        employeeDataAdapter = new EmployeeDataAdapter();
        employeeDataAdapter = new EmployeeDataAdapter(new OnRecycleViewClick() {
            @Override
            public void onItemClicked(View view, Employee mEmployee) {
                Toast.makeText(MainActivity.this,"点击了整个item",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onImgClicked(View view, Employee mEmployee) {
                Toast.makeText(MainActivity.this,"点击了img",Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(employeeDataAdapter);
        getAllEmployee();
    }
    private void getAllEmployee() {
        mainViewModel.getAllEmployee().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable List<Employee> employees) {
                employeeDataAdapter.setEmployeeList((ArrayList<Employee>) employees);
            }
        });
    }
}
