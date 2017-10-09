package com.ssangwoo.amigoodatbg.controller;

import android.content.Context;
import android.content.Intent;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.ssangwoo.amigoodatbg.R;
import com.ssangwoo.amigoodatbg.view.activities.ResultActivity;
import com.ssangwoo.amigoodatbg.view.activities.SectionActivity;

import static com.ssangwoo.amigoodatbg.view.activities.SectionActivity.SECTION_DISPLAY_LENGTH;

/**
 * Created by ssangwoo on 2017-10-04.
 */

public class AdController extends AdListener {

    Context context;
    private AdRequest adRequest;
    private InterstitialAd interstitialAd;

    public void initialize() {
        adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
    }

    public AdRequest getAdRequest() {
        return adRequest;
    }

    public InterstitialAd getInterstitialAd() {
        return interstitialAd;
    }

    public boolean loadInterstitialAd(Context context) {
        this.context = context;
        interstitialAd = new InterstitialAd(context);
        interstitialAd.setAdUnitId(context.getResources().getString(R.string.ad_foreword_id));
        interstitialAd.setAdListener(this);

        if(!interstitialAd.isLoaded()) {
            interstitialAd.loadAd(adRequest);
        }
        return interstitialAd.isLoaded();
    }

    public static AdController getInstance() {
        return Singleton.INSTANCE;
    }

    private static class Singleton {
        private static final AdController INSTANCE = new AdController();
    }
    private AdController() {}

    @Override
    public void onAdClosed() {
        super.onAdClosed();
        showResultSectionActivity(context);
    }

    @Override
    public void onAdFailedToLoad(int i) {
        super.onAdFailedToLoad(i);
        showResultSectionActivity(context);
    }

    public void showResultSectionActivity(Context context) {
        Intent nextIntent = new Intent(context, SectionActivity.class);
        nextIntent.putExtra("title", context.getString(R.string.end_subject_title));
        nextIntent.putExtra("content", context.getString(R.string.end_subject_content));
        nextIntent.putExtra("button", context.getString(R.string.end_subject_button));
        nextIntent.putExtra(SECTION_DISPLAY_LENGTH, 3500);
        nextIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        nextIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(nextIntent);
    }
}
