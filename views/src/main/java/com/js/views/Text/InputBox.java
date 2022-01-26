package com.js.views.Text;

// Created by JS on 2022/1/26.

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.js.views.R;

public class InputBox extends FrameLayout {

    private TextView tvLabel;
    private LinearLayout llContent;
    private EditText etContent;
    private RelativeLayout rlClear;
    private ImageView ivClear;

    private int colorBlack = Color.parseColor("#000000");
    private float dp14 = dip2px(getContext(), 14);
    private float labelTextSize = 14;
    private int labelTextColor = colorBlack;
    private String labelText = "";
    private float textSize = 14;
    private int textColor = colorBlack;
    private String text = "";
    private String hint = "请输入内容";
    private int inputBackgroundId = R.drawable.rect_ffffffff_r4;

    public InputBox(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null) {
            TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.InputBox);
            labelTextSize = attributes.getDimension(R.styleable.InputBox_label_text_size, 14);
            labelTextColor = attributes.getColor(R.styleable.InputBox_label_text_color, colorBlack);
            labelText = attributes.getString(R.styleable.InputBox_label_text);
            textSize = attributes.getDimension(R.styleable.InputBox_text_size, 14);
            textColor = attributes.getColor(R.styleable.InputBox_text_color, colorBlack);
            text = attributes.getString(R.styleable.InputBox_text);
            hint = attributes.getString(R.styleable.InputBox_hint);
            inputBackgroundId = attributes.getResourceId(R.styleable.InputBox_input_background, R.drawable.rect_ffffffff_r4);
            attributes.recycle();
        }
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_input, this);
        tvLabel = findViewById(R.id.tvLabel);
        llContent = findViewById(R.id.llContent);
        etContent = findViewById(R.id.etContent);
        rlClear = findViewById(R.id.rlClear);
        ivClear = findViewById(R.id.ivClear);

        tvLabel.setTextSize(labelTextSize);
        tvLabel.setTextColor(labelTextColor);
        tvLabel.setText(labelText);

        etContent.setTextSize(textSize);
        etContent.setTextColor(textColor);
        etContent.setText(text);
        etContent.setHint(hint);

        llContent.setBackgroundResource(inputBackgroundId);


        etContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    rlClear.setVisibility(INVISIBLE);
                } else {
                    rlClear.setVisibility(VISIBLE);
                }
            }
        });

        rlClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                etContent.setText("");
            }
        });
    }

    public void setLabel(@NonNull String label) {
        tvLabel.setText(label);
    }

    public void setLabelColor(int resourceId) {
        tvLabel.setTextColor(getResources().getColor(resourceId));
    }

    public void setLabelColor(String color) {
        tvLabel.setTextColor(Color.parseColor(color));
    }

    public void setText(@NonNull String text) {
        etContent.setText(text);
    }

    public String getText() {
        return etContent.getText().toString();
    }

    public void setTextColor(int resourceId) {
        etContent.setTextColor(getResources().getColor(resourceId));
    }

    public void setTextColor(String color) {
        etContent.setTextColor(Color.parseColor(color));
    }

    private int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
