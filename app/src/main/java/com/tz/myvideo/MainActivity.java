package com.tz.myvideo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    Button mButton;
    WebView mWebView;

    String mUrl;

    final int A= 0;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case A:

                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUrl = mEditText.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message= new Message();
                        message.what = A;
                        mHandler.sendMessage(message);
                    }
                }).start();
            }
        });
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.wv);
        mButton = (Button) findViewById(R.id.bt);
        mEditText = (EditText) findViewById(R.id.et);
    }
}
