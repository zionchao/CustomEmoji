package com.kevin.customemoji.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kevin.customemoji.R;

/**
 * Created by zhangchao_a on 2016/11/7.
 */

public class EmoGroupView extends HorizontalScrollView implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup mRadioGroup;
    private Context context;
    private OnEmoGroupChangeListener listener;

    public EmoGroupView(Context context) {
        super(context);
        initView(context);
    }

    public EmoGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public EmoGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }

    private void initView(Context context) {
        this.context=context;
        mRadioGroup=new RadioGroup(context);
        mRadioGroup.setOnCheckedChangeListener(this);
        addView(mRadioGroup);
    }

    public void initData(OnEmoGroupChangeListener listener)
    {
        this.listener=listener;
        RadioButton button1=new RadioButton(context);
        RadioButton button2=new RadioButton(context);
//        button1.setBackgroundDrawable(null);
        button1.setBackground(null);
        button2.setBackground(null);
        button1.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.smiley_00, 0,0);
        button2.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_emo, 0,0);
        button1.setChecked(true);
        button1.setText("Emoji");
        button2.setText("Custom");
//        button1.setId(1);
//        button2.setId(2);
        mRadioGroup.addView(button1);
        mRadioGroup.addView(button2);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
         listener.onGroupChanged(checkedId);
    }

    interface OnEmoGroupChangeListener{
        void onGroupChanged(int position);
    }
}
