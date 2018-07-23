package com.company.xpertech.xpertech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EnterCodeActivity extends AppCompatActivity {

    Button btn_proceed, btn_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entercode);

        btn_proceed = (Button) findViewById(R.id.btn_enter_accNum);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });
    }
}
