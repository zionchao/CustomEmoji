package com.kevin.customemoji;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.kevin.customemoji.widgets.EmoParse;
import com.kevin.customemoji.widgets.EmoView;
import com.kevin.customemoji.widgets.OnEmoClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnEmoClickListener {

    public EmoView mMainEmo;
    private ListView mMainListView;
    private EditText mMainEt;
    private Button mMainBtn;
    private ArrayList<String> messagesList=new ArrayList<>();
    private ChatAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mMainListView=(ListView)findViewById(R.id.mMainListView);
        adapter=new ChatAdapter();
        mMainListView.setAdapter(adapter);
        mMainEt=(EditText)findViewById(R.id.mMainEt);

        mMainBtn=(Button)findViewById(R.id.mMainBtn);
        mMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=mMainEt.getText().toString();
                messagesList.add(content);
                adapter.notifyDataSetChanged();
                mMainEt.setText("");
            }
        });


        mMainEmo= (EmoView) findViewById(R.id.mMainEmo);
        mMainEmo.initData(this);
    }

    @Override
    public void onCustomEmoClick() {

    }

    @Override
    public void onDeleteButtonClick() {
        mMainEt.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_DEL));
        mMainEt.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP,KeyEvent.KEYCODE_DEL));


    }

    @Override
    public void onEmoSendClick() {

    }

    @Override
    public void onNormalEmoClick(String emo,int resId) {
//        Toast.makeText(this,"haha",Toast.LENGTH_LONG).show();
        Editable editable=mMainEt.getText();
        int index=mMainEt.getSelectionEnd();
        emo="["+emo+"]";
        SpannableStringBuilder builder=new SpannableStringBuilder(emo);
        Drawable d=getResources().getDrawable(resId);
        d.setBounds(0,0,100,100);
        ImageSpan span=new ImageSpan(d);
        builder.setSpan(span,0,emo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        if(index<mMainEt.length())
        {
            editable.insert(index,builder);
        }else {
            editable.append(builder);
        }
        mMainEt.setSelection(index+emo.length());
    }

    class ChatAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return messagesList.size();
        }

        @Override
        public Object getItem(int position) {
            return messagesList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textview=new TextView(MainActivity.this);
            String content=messagesList.get(position);
            textview.setText(EmoParse.parseEmo(MainActivity.this,content));
            return textview;
        }
    }
}
