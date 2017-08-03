package com.android.emmy.testpackage;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Description:
 * Author: Bravowhale
 * Time: 2016/8/24 11:51
 */
public class BaseActivity extends AppCompatActivity {
    public final String TAG = getClass().getSimpleName();

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, TAG+"执行了onStop()....");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, TAG+"执行了onDestroy()....");
    }
}
