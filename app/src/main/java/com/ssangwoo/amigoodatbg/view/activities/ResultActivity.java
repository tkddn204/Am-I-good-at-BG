package com.ssangwoo.amigoodatbg.view.activities;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ssangwoo.amigoodatbg.BGDataBase;
import com.ssangwoo.amigoodatbg.R;

public class ResultActivity extends BaseActivity {

    private ImageView imageResultLevel;
    private TextView textResult; //, textResultLevel;
    private TextView notMyMind;
    private Button buttonThanks, buttonBackToMain, buttonShare;

    @Override
    void setView() {
        String[] resultStrings = BGDataBase.getInstance().getResultStrings();
        final String title = resultStrings[0];

        imageResultLevel.setImageResource(
                getResources().getIdentifier(resultStrings[2], "drawable", getPackageName())
        );
        textResult.setText(resultStrings[1]);

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = "나는 배그 " + title + "!\n";
                String text = "배그 실력을 테스트해봅시다!\n ▽ 테스트하러 가기\n" +
                        "https://play.google.com/store/apps/details?id=com.ssangwoo.amigoodatbg";

                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, subject + text);

                Intent chooserIntent = Intent.createChooser(sendIntent, "공유하기");
                startActivity(chooserIntent);
            }
        });
        notMyMind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "market://details?id=com.ssangwoo.amigoodatbg"));
                startActivity(intent);
            }
        });

        buttonThanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIntent = new Intent(getApplicationContext(), AppCreditActivity.class);
                startActivity(nextIntent);
            }
        });

        buttonBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });
    }

    private void backToMain() {
        Intent nextIntent = new Intent(getApplicationContext(), MainActivity.class);
        nextIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(nextIntent);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backToMain();
    }

    @Override
    void initView() {
        setContentView(R.layout.activity_result);

        imageResultLevel = findViewById(R.id.image_result_level);
        // textResultLevel = findViewById(R.id.text_result_level);
        textResult = findViewById(R.id.text_result);

        buttonShare = findViewById(R.id.button_share);
        notMyMind = findViewById(R.id.not_my_mind);

        buttonThanks = findViewById(R.id.button_thanks);
        buttonBackToMain = findViewById(R.id.button_back_to_main);
    }
}
