package com.ssangwoo.amigoodatbg.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ssangwoo on 2017-09-30.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        setView();
    }

    abstract void setView();
    abstract void initView();
}
