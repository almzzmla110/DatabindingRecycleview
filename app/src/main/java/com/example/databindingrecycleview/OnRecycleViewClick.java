package com.example.databindingrecycleview;


import android.view.View;

import com.example.databindingrecycleview.bean.Employee;

public interface OnRecycleViewClick {
    void onItemClicked(View view, Employee mEmployee);
    void onImgClicked(View view, Employee mEmployee);
}