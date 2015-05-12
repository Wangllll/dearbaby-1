package com.weiyan.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;


/**
 * Created by Administrator on 2015/4/18.
 */
public class RegisterActivity extends Activity {

    public final int getGetAutoCodeMessageTime = 30;        //用一个全局变量来进行一次性控制，修改时间时不用改太多代码

    private Button registerButton_1;
    private int getAutoCodeMessage = getGetAutoCodeMessageTime;
    private Handler handler;
    private Message message;
    private String defaultMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);

        registerButton_1 = (Button) findViewById(R.id.register_button_1);        //获得短信获得验证码的按钮

        defaultMessage = registerButton_1.getText().toString();                    //获得短信验证码的初始值


        registerButton_1.setOnClickListener(new View.OnClickListener() {                    //register_getMessage
            @Override
            public void onClick(View v) {
                if (getAutoCodeMessage == getGetAutoCodeMessageTime)
                    new MyThread().start();                                      //如果数数没到0的时候 不可以另外再开启线程造成冲突

            }
        });

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        registerButton_1.setText("验证码已经发送，" + getAutoCodeMessage + "秒后重新发送");
                        break;
                    case 2:
                        Thread.currentThread().interrupt();
                        registerButton_1.setText(defaultMessage);
                        getAutoCodeMessage = getGetAutoCodeMessageTime;
                        break;
                }
            }
        };

    }

    public class MyThread extends Thread {
        @Override
        public void run() {
            while (getAutoCodeMessage != 0) {
                getAutoCodeMessage--;
                message = new Message();
                message.what = 1;
                handler.sendMessage(message);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message1 = new Message();
            message1.what = 2;
            handler.sendMessage(message1);
        }

    }

    public void toLogin(View view){                 //点击现在登录 跳转回注册页面
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
