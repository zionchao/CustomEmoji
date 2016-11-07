package com.kevin.customemoji.widgets;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.kevin.customemoji.R;

/**
 * Created by zhangchao_a on 2016/11/7.
 */

public class EmoView extends LinearLayout implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private EmoGroupView mEmoGroupView;
    private EmoDotView mEmoDotView;
    private Button mEmoSendBtn;
    private ViewPager mEmoViewPager;
    private EmoPagerAdapter adapter;
    private OnEmoClickListener listener;
    private Context context;

    public EmoView(Context context) {
        super(context);
        initView(context);
    }

    public EmoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public EmoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }

    private void initView(Context context) {
        this.context=context;
        LayoutInflater.from(context).inflate(R.layout.emo_container_view,this);
        mEmoDotView=(EmoDotView)findViewById(R.id.mEmoDotView);
        mEmoGroupView=(EmoGroupView)findViewById(R.id.mEmoGroupView);
        mEmoSendBtn=(Button)findViewById(R.id.mEmoSendBtn);
        mEmoSendBtn.setOnClickListener(this);
        mEmoViewPager=(ViewPager)findViewById(R.id.mEmoViewPager);
        adapter=new EmoPagerAdapter();
        mEmoViewPager.setAdapter(adapter);
//        mEmoViewPager.setOnPageChangeListener(this);
        mEmoViewPager.addOnPageChangeListener(this);
    }

    public void initData(OnEmoClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.mEmoSendBtn:
                listener.onEmoSendClick();
                break;
        }
    }

    class EmoPagerAdapter extends PagerAdapter{
        public EmoPagerAdapter() {
            super();
        }

        @Override
        public int getCount() {
//      FIXME  test ,the count should be sum(group page)
            return 5;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            EmoNormalGrid normal= new EmoNormalGrid(context);
            normal.initData(position,listener);
            container.addView(normal);
            return normal;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int curGroupPosition=0;
        int count=0;
        mEmoDotView.notifyDataChanged(curGroupPosition,count);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
