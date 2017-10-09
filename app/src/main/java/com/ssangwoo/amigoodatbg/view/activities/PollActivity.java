package com.ssangwoo.amigoodatbg.view.activities;

import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import com.google.android.gms.ads.AdView;
import com.ssangwoo.amigoodatbg.BGDataBase;
import com.ssangwoo.amigoodatbg.R;
import com.ssangwoo.amigoodatbg.controller.AdController;
import com.ssangwoo.amigoodatbg.view.fragments.OnFragmentInteractionListener;
import com.ssangwoo.amigoodatbg.view.fragments.PollChoiceFragment;

/**
 * Created by ssangwoo on 2017-09-15.
 */

public class PollActivity extends BaseActivity
    implements View.OnClickListener, OnFragmentInteractionListener {
    private static final String PAGE_FORMAT = "%d / %d";

    private AdView adView;
    private Button buttonBack, buttonNext;
    private TextView textPage;

    private int page;
    private int maxPage;

    @Override
    void setView() {
        maxPage = BGDataBase.getInstance().getMaxPage();

        adView.loadAd(AdController.getInstance().getAdRequest());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.poll_container, PollChoiceFragment.newInstance(page))
                .commit();

        textPage.setText(String.format(Locale.KOREA, PAGE_FORMAT, page+1, maxPage+1));

        buttonBack.setVisibility(View.INVISIBLE);
        buttonBack.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
    }

    @Override
    void initView() {
        setContentView(R.layout.activity_poll);
        adView = findViewById(R.id.ad_view_banner);

        buttonBack = findViewById(R.id.button_back);
        buttonNext = findViewById(R.id.button_next);
        textPage = findViewById(R.id.text_page);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_next:
                if(BGDataBase.getInstance().getUserChoice(page) < 0) {
                    Toast toast = Toast.makeText(this, getText(R.string.not_selected),
                            Toast.LENGTH_LONG);
                    ViewGroup group = (ViewGroup) toast.getView();
                    TextView toastTextView = (TextView) group.getChildAt(0);
                    toastTextView.setTextSize(24);
                    toast.setGravity(Gravity.BOTTOM, 0, 24);
                    toast.getView().setBackgroundColor(
                            getResources().getColor(android.R.color.transparent));
                    toast.show();

                    return;
                }
                if(page == maxPage) {
                    // 끝났을 때
                    if (AdController.getInstance().loadInterstitialAd(this)) {
                        AdController.getInstance().getInterstitialAd().show();
                    } else {
                        AdController.getInstance().showResultSectionActivity(this);
                    }
                    return;
                }
                setOperatingButton(++page);
                break;
            case R.id.button_back:
                setOperatingButton(--page);
                break;
            default:
                break;
        }

        if(page <= 0) {
            buttonBack.setVisibility(View.INVISIBLE);
        } else {
            buttonBack.setVisibility(View.VISIBLE);
        }

        if(page == maxPage) {
            buttonNext.setBackground(null);
            buttonNext.setText(getText(R.string.text_submit));
        } else {
            buttonNext.setBackgroundResource(R.drawable.page_forward);
            buttonNext.setText("");
        }
    }

    private void setOperatingButton(int page) {
        textPage.setText(String.format(Locale.KOREA, PAGE_FORMAT, page+1, maxPage+1));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.poll_container, PollChoiceFragment.newInstance(page))
                .commit();
    }

    @Override
    public void onBackPressed() {
        if(page > 0) {
            onClick(buttonBack);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }
}
