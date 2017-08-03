package com.android.emmy.testpackage;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends BaseActivity {
    private Button mBtnStartSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        initView();
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                mBtnStartSecondActivity.setText("测试");
                Toast.makeText(MainActivity.this,"子线程执行Toast",Toast.LENGTH_LONG).show();
                if(Looper.myLooper()==null){
                    Log.i(TAG, "Looper.myLooper()是null");
                }else{
                    Log.i(TAG, "Looper.myLooper()不是null");
                }
                Handler handler = new Handler(Looper.myLooper());
            }
        }).start();*/
    }

    private void initView() {
        mBtnStartSecondActivity = (Button)findViewById(R.id.btn_start_second_activity);
        mBtnStartSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }


    private void testPackage() {
        try {
            Log.i(TAG, "第一次打印：" + getPackageName());
            PackageInfo packgeInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            Log.i(TAG, "第二次打印：" + packgeInfo.packageName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void onEventMainThread(FirstEvent event){
        Toast.makeText(MainActivity.this,event.getMessage(),Toast.LENGTH_LONG).show();
        Log.i(TAG, "onEventMainThread: "+event.getMessage());
    }

    @Subscribe
    public void onEventBackgroundThread(FirstEvent event){
        Toast.makeText(MainActivity.this,event.getMessage(),Toast.LENGTH_LONG).show();
        Log.i(TAG, "onEventBackgroundThread: "+event.getMessage());
        mBtnStartSecondActivity.setText(event.getMessage());
        /*if(Looper.myLooper()==null){
            Log.i(TAG, "onEventBackgroundThread：Looper.myLooper()是null");
        }else{
            Log.i(TAG, "onEventBackgroundThread：Looper.myLooper()不是null");
        }
        Handler handler = new Handler(Looper.myLooper());*/
    }

    @Subscribe
    public void onEventMainThread(SecondEvent event){
        Toast.makeText(MainActivity.this,event.getIndex()+"",Toast.LENGTH_LONG).show();
        Log.i(TAG, "onEventMainThread: "+event.getIndex()+"");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
