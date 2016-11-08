package com.kevin.customemoji.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by zhangchao_a on 2016/11/7.
 */

public class EmoCustomGrid extends GridView {

    public EmoCustomGrid(Context context) {
        super(context);
    }

    public EmoCustomGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmoCustomGrid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initData(int position, OnEmoClickListener listener) {
    }
}
