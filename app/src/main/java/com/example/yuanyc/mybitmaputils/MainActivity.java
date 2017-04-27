package com.example.yuanyc.mybitmaputils;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import annotation.ContentView;
import annotation.OnClick;
import annotation.ViewInject;

@ContentView(value = R.layout.activity_main)
public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @ViewInject(R.id.button1)
    private Button button1;
    @ViewInject(R.id.button2)
    private Button button2;
    @ViewInject(R.id.button3)
    private Button button3;
    @ViewInject(R.id.button4)
    private Button button4;
    @ViewInject(R.id.button5)
    private Button button5;
    @ViewInject(R.id.button6)
    private Button button6;
    @ViewInject(R.id.button7)
    private Button button7;
    @ViewInject(R.id.button8)
    private Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("MainActivity执行！");
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8})
    public void onClick(View view) {
        System.out.println("onClick执行！");
        switch (view.getId()) {
            case R.id.button1:
                Log.i(TAG,"button1被点击");
                System.out.println("button1被点击");
                Toast.makeText(MainActivity.this,"button1被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
            case R.id.button6:
                break;
            case R.id.button7:
                break;
            case R.id.button8:
                break;
        }
    }
}
