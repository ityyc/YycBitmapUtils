package com.example.yuanyc.mybitmaputils;

/**
 * Author ：yuanyc
 * Time ：2017/5/25
 * Description ：
 */

public class GlobalUtils {
    private MainActivity mainActivity;
    private GlobalUtils() {

    }

    private static class InstanceHolder {
        private static final GlobalUtils instance = new GlobalUtils();
    }

    public static GlobalUtils getInstance() {
        return InstanceHolder.instance;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
}
