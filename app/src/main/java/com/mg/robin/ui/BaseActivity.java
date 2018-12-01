package com.mg.robin.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Activity基类
 */
public class BaseActivity extends AppCompatActivity {
    /**
     * 作用：
     * 1、统一属性
     * 2、统一接口
     * 3、统一方法
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //显示返回键
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

        //菜单栏操作
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
