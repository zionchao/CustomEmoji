package com.kevin.customemoji;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.kevin.customemoji.widgets.EmoView;
import com.kevin.customemoji.widgets.OnEmoClickListener;

public class MainActivity extends AppCompatActivity implements OnEmoClickListener {

    public EmoView mMainEmo;
    private ListView mMainListView;
    private EditText mMainEt;
    private Button mMainBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mMainListView=(ListView)findViewById(R.id.mMainListView);
        mMainEt=(EditText)findViewById(R.id.mMainEt);
        mMainEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mMainBtn=(Button)findViewById(R.id.mMainBtn);
        mMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    }

    @Override
    public void onEmoSendClick() {

    }

    @Override
    public void onNormalEmoClick() {
        Toast.makeText(this,"haha",Toast.LENGTH_LONG).show();
    }

    class ChatAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}
