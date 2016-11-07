package com.kevin.customemoji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.kevin.customemoji.widgets.EmoView;
import com.kevin.customemoji.widgets.OnEmoClickListener;

public class MainActivity extends AppCompatActivity implements OnEmoClickListener {

    public EmoView mMainEmo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainEmo= (EmoView) findViewById(R.id.mMainEmo);
        mMainEmo.initData(this);
    }

    @Override
    public void onCustomEmoClick() {

    }

    @Override
    public void onDeleteButtonClick() {

    }

    @Override
    public void onEmoSendClick() {

    }

    @Override
    public void onNormalEmoClick() {
        Toast.makeText(this,"haha",Toast.LENGTH_LONG).show();
    }
}
