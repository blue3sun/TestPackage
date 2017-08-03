package com.android.emmy.testpackage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

/**
 * Description:发送事件
 * Author: lanjing
 * Time: 2016/8/25 16:43
 */
public class SecondActivity extends BaseActivity{
    private Button mBtnSendMsg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        mBtnSendMsg = (Button)findViewById(R.id.btn_send_message);
        mBtnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EventBus.getDefault().post(new FirstEvent("I am a message"));
                EventBus.getDefault().post(new SecondEvent(2,"2"));
            }
        });
    }
}
