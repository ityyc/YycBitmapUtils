package com.example.yuanyc.mybitmaputils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import annotation.ViewInjectUtils;

/**
 * Author ：yuanyc
 * Time ：2017/4/27
 * Description ：基类
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("BaseActivity执行！");
        //初始化注解处理器
        ViewInjectUtils.inject(this);
    }
}
