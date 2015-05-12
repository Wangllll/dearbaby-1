package com.weiyan.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
    }

    public void toRegister(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    public void toMainActivity(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
