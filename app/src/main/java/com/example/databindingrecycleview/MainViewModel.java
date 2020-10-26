package com.example.databindingrecycleview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.databindingrecycleview.bean.Employee;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private EmployeeRepository employeeRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        employeeRepository = new EmployeeRepository();
    }

    public LiveData<List<Employee>> getAllEmployee() {
        return employeeRepository.getMutableLiveData();
    }
}
