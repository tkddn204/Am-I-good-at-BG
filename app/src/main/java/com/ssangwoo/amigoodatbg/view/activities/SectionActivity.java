package com.ssangwoo.amigoodatbg.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.NativeExpressAdView;
import com.ssangwoo.amigoodatbg.R;
import com.ssangwoo.amigoodatbg.controller.AdController;

public class SectionActivity extends BaseActivity {
    public static final String SECTION_DISPLAY_LENGTH = "section_display_length";

    Intent postedIntent;
    TextView textTitle, textContent;
    NativeExpressAdView nativeExpressAdView;
    Button buttonSectionNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                buttonSectionNext.setVisibility(View.VISIBLE);
            }
        }, postedIntent.getIntExtra(SECTION_DISPLAY_LENGTH, 1500));
    }

    @Override
    void setView() {
        postedIntent = getIntent();
        textTitle.setText(postedIntent.getStringExtra("title"));
        textContent.setText(postedIntent.getStringExtra("content"));

        nativeExpressAdView.loadAd(AdController.getInstance().getAdRequest());

        buttonSectionNext.setText(postedIntent.getStringExtra("button"));
        buttonSectionNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIntent = new Intent(
                        getApplicationContext(), ResultActivity.class);
                //nextIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(nextIntent);
            }
        });
        buttonSectionNext.setVisibility(View.INVISIBLE);
    }

    @Override
    void initView() {
        setContentView(R.layout.activity_section);
        textTitle = findViewById(R.id.text_section_title);
        textContent = findViewById(R.id.text_section_content);
        nativeExpressAdView = findViewById(R.id.ad_view_section);
        buttonSectionNext = findViewById(R.id.button_section_next);
    }
}
