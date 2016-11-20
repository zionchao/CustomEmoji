package com.kevin.customemoji.widgets;

/**
 * Created by zhangchao_a on 2016/11/7.
 */

public interface OnEmoClickListener {
    void onCustomEmoClick();
    void onDeleteButtonClick();
    void onEmoSendClick();

    void onNormalEmoClick(String s, int i);
}
