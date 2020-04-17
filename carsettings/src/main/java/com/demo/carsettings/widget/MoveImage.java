package com.demo.carsettings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.demo.carsettings.R;


public class MoveImage extends View {

    private Paint paint;
    private float dx = 0;
    private float dy = 0;
    private int radius = 30;
    private Bitmap mBkgImg,mCircle;
    private Context mContext;
    private int value = 14;
    private float cancelX = 0;
    private float cancelY = 0;
    private boolean flag = true;
    private int moveX;
    private  int moveY;
    private boolean isUser = false;
    private float mx;
    private float my;
    private MoveListener mListener;

    public void setMoveListener(MoveListener listener) {
        mListener = listener;
    }

    public MoveImage(Context context) {
        this(context, null);
    }

    public MoveImage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MoveImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MovePage, defStyleAttr, 0);
        int count = ta.getIndexCount();
        int index;
        for (int i = 0; i < count; ++i) {
            index = ta.getIndex(i);
            switch (index) {
                case R.styleable.MovePage_radicus:
                    radius = ta.getInteger(index, 30) ;
                    break;
                case R.styleable.MovePage_movex:
                    moveX = ta.getInteger(index, 0);
                    break;
                case R.styleable.MovePage_movey:
                    moveY = ta.getInteger(index, 0);
                    break;
            }
        }
        ta.recycle();
        init();
    }

    void init() {
        mBkgImg = BitmapFactory.decodeResource(getResources(), R.drawable.sound_field_bkg);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
    }

    private void retrieveData() {
        dx = getMeasuredWidth() / 2;
        dy = getMeasuredHeight() / 2 ;

    }
/*
     Get last time or default position data
 */

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getData("dx") == 0 || getData("dy") == 0) {
            retrieveData();
        } else {
            dx = getData("dx");
            dy = getData("dy");
        }
        if(flag) {
          //  mListener.setPosition(getBalance(dx), getFade(dy),false);
            Log.d("Move","On Measure :"+ dx +" dy :" +  dy );
            flag = false;
        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        revise();
        canvas.drawBitmap(mBkgImg, moveX, moveY, null);
//        canvas.drawBitmap(mCircle,mx-radius,my-radius,null);
        canvas.drawCircle(mx, my, radius, paint);
        canvas.drawLine(mx,0,mx,getHeight(),paint);
        canvas.drawLine(0,my,getWidth(),my,paint);
    }

    /*
       make sure the position of center
     */
    private void revise() {
        if (dx <= radius) {
            mx = radius;
        } else if (dx >= (getWidth() - radius)) {
            mx = getWidth() - radius;
        } else if((dx> radius )&& (dx < (getWidth() -radius))){
            mx = dx;
        }
        if (dy <= radius) {
            my = radius;
        } else if (dy >= (getHeight() - radius)) {
            my = getHeight() - radius;
        }else if((dy> radius )&& (dy< (getHeight() -radius))){
            my = dy;
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        getParent().requestDisallowInterceptTouchEvent(true);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                dx = event.getX();
                dy = event.getY();
                cancelX = dx;
                cancelY = dy;
                Log.d("Move", "On Move :" + dx + "  :" + dy);
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                dx = event.getX();
                dy = event.getY();
                if (dx > 280 && dx < 400 && (dy < 430 && dy > 330)) {
                    dx = 340;
                } else if (dx > 400) {
                    dx = 435;
                } else if (dx < 280) {
                    dx = 230;
                } else {
                    dx = 230;
                }
                if (dy < 430 && dy > 330 && (dx == 340)) {
                    dy = 383;
                } else if (dy < 330) {
                    dy = 290;
                } else if (dy > 430) {
                    dy = 530;
                } else {
                    dy = 290;
                }
                invalidate();
                saveData("dx", dx);
                saveData("dy", dy);
                if(mListener != null){
                    mListener.setPosition(getBalance(dx), getFade(dy),true);
                    Log.d("Move", "On move up :" + getBalance(dx) + " :" + getFade(dy));
                }

                break;
            case MotionEvent.ACTION_CANCEL:

                break;

        }
        return super.onTouchEvent(event);
    }

    private void saveData(String key, float data) {
        Settings.System.putFloat(getContext().getContentResolver(), key,data);
    }

    private float getData(String key) {
        float data = Settings.System.getFloat(getContext().getContentResolver(), key,0);
        return data;
    }

    /*
        position data convert to fade/balance
     */
    private int getBalance(float x) {
        if (x < 0) {
            x = 0;
        }
        if (x > getMeasuredWidth()) {
            x = getMeasuredWidth();
        }
        int balance;
        int width = getMeasuredWidth() / 2;

        if (x < width) {
            balance = -(value - ((int) x * value / width));
        } else {
            balance = ((int) x - width) * value / width;
        }
        return balance;

    }

    private int getFade(float y) {


        if (y < 0) {
            y = 0;
        }
        if (y > getMeasuredHeight()) {
            y = getMeasuredHeight();
        }
        int fade;
        int height = getMeasuredHeight() / 2;
        if (y < height) {
            fade = -(value - ((int) y * value / height));
        } else {
            fade = ((int) y - height) * value / height;
        }
        return fade;
    }

    public interface MoveListener {
        void setPosition(int balance, int fade, boolean tag);
    }

    public void reset() {
        retrieveData();
        invalidate();
        if(mListener != null){
            mListener.setPosition(getBalance(dx), getFade(dy),true);
            Log.d("Move","On reset :"+getBalance(dx) +" :" + getFade(dy));
            Log.d("Move","On reset :"+dx +" :" + dy);
            saveData("dx", dx);
            saveData("dy", dy);
        }
    }

}
