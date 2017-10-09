package com.ssangwoo.amigoodatbg.view.activities;

import android.util.Log;

import com.ssangwoo.amigoodatbg.R;
import com.ssangwoo.amigoodatbg.controller.AdController;

public class ReactionRateActivity extends BaseActivity {
    @Override
    void setView() {
        // 끝났을 때
        if (AdController.getInstance().loadInterstitialAd(this)) {
            AdController.getInstance().getInterstitialAd().show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }

    @Override
    void initView() {
        setContentView(R.layout.activity_reaction_rate);
    }
}
