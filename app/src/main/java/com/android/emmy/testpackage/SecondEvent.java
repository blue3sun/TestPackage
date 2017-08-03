package com.android.emmy.testpackage;

/**
 * Description:
 * Author: Bravowhale
 * Time: 2016/8/26 11:27
 */
public class SecondEvent extends FirstEvent{
    private int index;

    public SecondEvent(int index,String msg) {
        super(msg);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
