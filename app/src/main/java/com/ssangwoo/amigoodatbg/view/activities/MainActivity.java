package com.ssangwoo.amigoodatbg.view.activities;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.View;

import com.bluelinelabs.logansquare.LoganSquare;
import com.ssangwoo.amigoodatbg.BGDataBase;
import com.ssangwoo.amigoodatbg.R;
import com.ssangwoo.amigoodatbg.model.PollModel;
import com.ssangwoo.amigoodatbg.model.ResultModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends BaseActivity {

    ConstraintLayout mainLayout;

    private void initJson() {
        InputStream pollInput = getResources().openRawResource(R.raw.poll);
        InputStream resultInput = getResources().openRawResource(R.raw.result);
        try {
            List<PollModel> pollModels = LoganSquare.parseList(pollInput, PollModel.class);
            List<ResultModel> resultModels = LoganSquare.parseList(resultInput, ResultModel.class);

            BGDataBase.getInstance().initPolls(pollModels);
            BGDataBase.getInstance().initResults(resultModels);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    @Override
    void setView() {
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initJson();

                Intent nextIntent = new Intent(getApplicationContext(), PollActivity.class);
//                Intent nextIntent = new Intent(getApplicationContext(), SectionActivity.class);
//                nextIntent.putExtra("title", getString(R.string.first_subject_title));
//                nextIntent.putExtra("content", getString(R.string.first_subject_content));
//                nextIntent.putExtra("next_activity", PollActivity.class);

                startActivity(nextIntent);
            }
        });
    }

    @Override
    void initView() {
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.main_layout);
    }
}
