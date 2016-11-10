package com.kevin.customemoji.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by zhangchao_a on 2016/11/7.
 */

public class EmoDotView extends LinearLayout {

    private int width;
    private float density;
    private float radius;
    private float padding;
    private int position;
    private int count;
    private float mStartX;
    private Paint paint;

    public EmoDotView(Context context) {
        super(context);
        initView(context);
    }

    public EmoDotView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public EmoDotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }


    public void notifyDataChanged(int position, int count) {
        this.position=position;
        this.count=count;
        this.mStartX=(width-((count-1)*padding+count*radius*2))/2;
        paint=new Paint();
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i=0;i<count;i++)
        {
            if (position==i)
                paint.setColor(Color.RED);
            else
                paint.setColor(Color.GRAY);
             canvas.drawCircle(mStartX+i*padding+i*radius*2,0,radius,paint);
        }
    }

    private void initView(Context context) {
        width=getResources().getDisplayMetrics().widthPixels;
        density=getResources().getDisplayMetrics().density;
        radius=2*density;
        padding=10*density;

    }

}
