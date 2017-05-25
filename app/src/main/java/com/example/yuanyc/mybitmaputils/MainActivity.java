package com.example.yuanyc.mybitmaputils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import annotation.ContentView;
import annotation.OnClick;
import annotation.ViewInject;
import bitmapUtils.MyBitmapUtils;

@ContentView(value = R.layout.activity_main)
public class MainActivity extends BaseActivity {
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

    @ViewInject(R.id.image1)
    private ImageView imageView1;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalUtils.getInstance().setMainActivity(this);
        resources = getResources();
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Toast.makeText(MainActivity.this,"button1被点击",Toast.LENGTH_SHORT).show();
                Bitmap bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_pay_bank);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                Bitmap bitmap1 = MyBitmapUtils.compressBitmapByHeight(baos.toByteArray(), imageView1.getHeight());
                imageView1.setImageBitmap(bitmap1);
                break;
            case R.id.button2:
                Toast.makeText(MainActivity.this,"button2被点击",Toast.LENGTH_SHORT).show();
                Bitmap bitmap2 = MyBitmapUtils.compressBitmap(R.mipmap.test_01);
                imageView1.setImageBitmap(bitmap2);
                break;
            case R.id.button3:
                Toast.makeText(MainActivity.this,"button3被点击",Toast.LENGTH_SHORT).show();
                Bitmap bitmap3 = MyBitmapUtils.compressLossBitmap(BitmapFactory.decodeResource(resources, R.mipmap.test_01), 30);
                imageView1.setImageBitmap(bitmap3);
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
