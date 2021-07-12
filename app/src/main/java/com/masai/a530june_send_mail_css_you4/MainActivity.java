package com.masai.a530june_send_mail_css_you4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtEmail;
    private EditText mEtCC;
    private EditText mEtMessage;
    private Button mBtnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] str = mEtCC.getText().toString().split(",");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, mEtMessage.getText().toString());
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{mEtEmail.getText().toString()});
                intent.putExtra(Intent.EXTRA_CC, str);
                intent.setType("message/rfc822");

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    private void initView() {
        mEtEmail = findViewById(R.id.EtEmail);
        mEtCC = findViewById(R.id.EtCC);
        mEtMessage = findViewById(R.id.EtMessage);
        mBtnSend = findViewById(R.id.btnSend);
    }
}