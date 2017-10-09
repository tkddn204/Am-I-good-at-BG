package com.ssangwoo.amigoodatbg;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;
import com.ssangwoo.amigoodatbg.controller.AdController;

/**
 * Created by ssangwoo on 2017-09-20.
 */

public class BGApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, getString(R.string.app_id));
        AdController.getInstance().initialize();
    }
}
