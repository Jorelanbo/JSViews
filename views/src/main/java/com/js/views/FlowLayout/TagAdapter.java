package com.js.views.FlowLayout;

// Created by JS on 2021/7/21.

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class TagAdapter<T> {

    private List<T> mTagDatas;
    private OnDataChancedListener mOnDataChancedListener;
    private HashSet<Integer> mCheckedPosList = new HashSet<>();

    public TagAdapter(List<T> tagDatas) {
        mTagDatas = tagDatas;
    }

    public TagAdapter(T[] tagDatas) {
        mTagDatas = new ArrayList<>(Arrays.asList(tagDatas));
    }

    public interface OnDataChancedListener {
        void onChanged();
    }

    void setOnDataChancedListener(OnDataChancedListener listener) {
        mOnDataChancedListener = listener;
    }

    /**
     * 设置选中的位置
     * @param poses
     */
    public void setSelectedList(int... poses) {
        HashSet<Integer> set = new HashSet<>();
        for (int pos : poses) {
            set.add(pos);
        }
        setSelectedList(set);
    }

    /**
     * 设置选中的位置
     * @param set
     */
    public void setSelectedList(Set<Integer> set) {
        mCheckedPosList.clear();
        if (set != null) {
            mCheckedPosList.addAll(set);
        }
        notifyDataChanged();
    }

    /**
     * 获取被选中的位置
     * @return
     */
    public HashSet<Integer> getPreCheckedList() {
        return mCheckedPosList;
    }

    public int getCount() {
        return mTagDatas == null ? 0 : mTagDatas.size();
    }

    public void notifyDataChanged() {
        if (mOnDataChancedListener != null) {
            mOnDataChancedListener.onChanged();
        }
    }

    public T getItem(int position) {
        return mTagDatas.get(position);
    }

    public abstract View getView(FlowLayout parent, int position, T t);

    public void onSelected(int position, View view) {
        Log.d("JS", "onSelected" + position);
    }

    public void unSelected(int position, View view) {
        Log.d("JS", "unSelected" + position);
    }

    public boolean setSelected(int position, T t) {
        return false;
    }
}
