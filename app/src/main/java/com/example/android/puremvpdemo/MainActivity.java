package com.example.android.puremvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements WelcomeContract.View {

    private TextView tvWelcomeMessage;
    private EditText etFirstName;
    private EditText etLastName;
    private Button btnSubmit;


    private WelcomeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcomeMessage = findViewById(R.id.welcomeMessage);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        btnSubmit = findViewById(R.id.btnSubmit);

        presenter = new WelcomePresenter(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etFirstName.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Please enter first name", Toast.LENGTH_SHORT).show();
                } else {
                    presenter.submitName(etFirstName.getText().toString(), etLastName.getText().toString());
                    presenter.loadWelcomeMessage();
                }
            }
        });

    }

    @Override
    public void showWelcomeMessage(String welcomeMessage) {
        tvWelcomeMessage.setText(welcomeMessage);
    }
}
