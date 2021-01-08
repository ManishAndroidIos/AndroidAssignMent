package com.app.smsipltest.app_ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.smsipltest.R;
import com.app.smsipltest.app_constants.AppAlert;
import com.app.smsipltest.app_network_call.NetworkCall;
import com.app.smsipltest.app_network_call.RequestNotifier;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String TAG = MainActivity.class.getSimpleName();
    private TextInputEditText mEtPassword;
    private MaterialButton mBtnEnter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        mEtPassword = findViewById(R.id.et_password);
        mBtnEnter = findViewById(R.id.btnEnter);

        mBtnEnter.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnEnter:
                isAllValid(mEtPassword.getText().toString().trim());
                break;

        }
    }

    private void isAllValid(String password) {
        if (TextUtils.isEmpty(password)){
            mEtPassword.setError("Please Enter Password");
            AppAlert.callAlert(this,"Please Enter Password");
        }else if (!password.equals("1234")){
            mEtPassword.setError("Please Enter Valid Password");
            Toast.makeText(this, "Password: 1234", Toast.LENGTH_SHORT).show();
        }else {
            startActivity(new Intent(this, SeatBook_Activity.class)
            .putExtra("password", password));
            finish();
        }
    }





}