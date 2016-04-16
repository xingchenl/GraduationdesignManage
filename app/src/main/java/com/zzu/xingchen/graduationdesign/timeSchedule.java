package com.zzu.xingchen.graduationdesign;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xingchen on 2016/3/21.
 */
public class timeSchedule extends View{

       private Integer xunlie;
    //序列号


    public void setXunlie(Integer xunlie) {
        this.xunlie = xunlie;
    }

    private String shijian="00-00-00"; //批改时间

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    private String shuoming="未知";  //模块说明

    public void setShuoming(String shuoming) {
        this.shuoming = shuoming;
    }

    private int back_ground; //颜色背景

    public void setBack_ground(int back_ground) {
        this.back_ground = back_ground;
    }

    private    Paint paint;  //画笔


    public timeSchedule(Context context) {
        super(context);
    }

    public timeSchedule(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public timeSchedule(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


            int i=0;


//
//        int  xunlieId=attrs.getAttributeResourceValue(R.styleable.timeSchedule_NumberX, 0);
//        xunlie=context.getResources().getInteger(xunlieId);
//       int  shijianId=attrs.getAttributeResourceValue(R.styleable.timeSchedule_TimeL,0);
//        shijian=context.getResources().getText(shijianId).toString();
//
//       int  shuomingID=attrs.getAttributeResourceValue(R.styleable.timeSchedule_StateL,0);
//            shuoming=context.getResources().getText(shuomingID).toString();
//       int  back_groundid=attrs.getAttributeResourceValue(R.styleable.timeSchedule_BackgroundL ,Color.DKGRAY);
//            back_ground=context.getResources().getColor(back_groundid);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
            paint=new Paint();
        paint.setColor(Color.argb(188,178,169,182));

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (float) (getWidth() / 2.2), paint);

        paint.setColor(back_ground);


        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (float) (getWidth() / 2.4), paint);
        paint.setTextSize(getWidth()/10);
        paint.setColor(Color.BLACK);
        canvas.drawText(String.valueOf(xunlie),getWidth()/2-getWidth()/20,getHeight()/4,paint);
        canvas.drawText(shuoming, getWidth() / 2-getWidth()/5, getHeight() / 2, paint);
        canvas.drawText(shijian,getWidth()/2-getWidth()/4,getHeight()-getHeight()/5,paint);

    }
}
