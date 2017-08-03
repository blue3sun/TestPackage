package com.android.emmy.testpackage;

/**
 * Description:EventBus中函数的参数
 * Author: Bravowhale
 * Time: 2016/8/25 16:47
 */
public class FirstEvent {
    private String message;

    public FirstEvent(String messge) {
        this.message = messge;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
