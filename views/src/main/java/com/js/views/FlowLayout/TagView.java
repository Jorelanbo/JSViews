package com.js.views.FlowLayout;

// Created by JS on 2021/7/21.

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

public class TagView extends FrameLayout implements Checkable {

    private boolean isChecked;
    private static final int[] CHECK_STATE = new int[]{android.R.attr.state_checked};

    public TagView(@NonNull Context context) {
        super(context);
    }

    public View getTagView() {
        return getChildAt(0);
    }

    /**
     * 然后我们要把状态给加进去。我们需要重写protected int[] onCreateDrawableState(int extraSpace)方法
     *
     * 先调用父类的onCreateDrawableState方法得到状态数组对象states，但是参数extraSpace要加上1，
     * 因为我们要往里面增加一个状态。然后判断在代码逻辑中，是否为选中状态，
     * 如果是的话，调用mergeDrawableStates(states, CHECKED_STATE_SET)方法把我们的状态值给加进去，最终返回states。
     * @param extraSpace
     * @return
     */
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] states = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(states, CHECK_STATE);
        }
        return states;
    }

    @Override
    public void setChecked(boolean checked) {
        if (isChecked != checked) {
            isChecked = checked;
            refreshDrawableState();
        }
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked);
    }
}
