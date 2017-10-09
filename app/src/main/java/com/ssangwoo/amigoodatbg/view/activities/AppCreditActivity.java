package com.ssangwoo.amigoodatbg.view.activities;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ssangwoo.amigoodatbg.R;

public class AppCreditActivity extends BaseActivity {

    TextView license, myEmail;
    Button buttonBackToResult;
    @Override
    void setView() {
        buttonBackToResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        license.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "http://www.apache.org/licenses/LICENSE-2.0.html"));
                startActivity(intent);
            }
        });
        myEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(
                        "mailto:tkddn204@gmail.com"));
                startActivity(intent);
            }
        });
    }

    @Override
    void initView() {
        setContentView(R.layout.activity_app_credit);
        buttonBackToResult = findViewById(R.id.button_back_to_result);
        license = findViewById(R.id.license);
        myEmail = findViewById(R.id.my_email);
    }
}
