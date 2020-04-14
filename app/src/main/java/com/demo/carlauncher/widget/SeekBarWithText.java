package com.demo.carlauncher.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import com.demo.carlauncher.R;

public class SeekBarWithText extends AppCompatSeekBar {

    Drawable minIcon;
    Drawable maxIcon;
    Paint textPaint;
    boolean showText;

    public SeekBarWithText(Context context) {
        super(context,null);
    }

    public SeekBarWithText(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SeekBarWithText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array=context.obtainStyledAttributes(attrs, R.styleable.SeekBarWithText);
        minIcon = array.getDrawable(R.styleable.SeekBarWithText_icon_min);
        maxIcon = array.getDrawable(R.styleable.SeekBarWithText_icon_max);
        showText = array.getBoolean(R.styleable.SeekBarWithText_show_text,true);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(28);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        drawMinMaxIcon(canvas);
        super.onDraw(canvas);
        if(showText)
            drawText(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(getParent() != null){
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(event);
    }

    void drawMinMaxIcon(Canvas canvas)
    {
        if(minIcon!=null)
        {
            minIcon.setBounds(new Rect(20,(getHeight()-minIcon.getIntrinsicHeight())/2,20+minIcon.getIntrinsicHeight(),(getHeight()-minIcon.getIntrinsicHeight())/2+minIcon.getIntrinsicHeight()));
            minIcon.draw(canvas);
        }

        if(maxIcon!=null)
        {
            maxIcon.setBounds(new Rect(getWidth()-20-maxIcon.getIntrinsicWidth(),(getHeight()-maxIcon.getIntrinsicHeight())/2,getWidth()-20,(getHeight()-maxIcon.getIntrinsicHeight())/2+maxIcon.getIntrinsicHeight()));
            maxIcon.draw(canvas);
        }
    }

    void drawText(Canvas canvas)
    {
        canvas.save();
        canvas.translate(getPaddingLeft()-getThumbOffset(),getPaddingTop());
        String scaleTxt = String.format("%d%%",(int)(getScale()*100));
        Rect thumbRect = getThumb().getBounds();
        canvas.drawText(scaleTxt,thumbRect.left+(thumbRect.width()-textPaint.measureText(scaleTxt))/2f,getHeight()/2+textPaint.getFontMetrics().descent,textPaint);
        canvas.restore();
    }



    private float getScale() {
        int min = getMin();
        int max = getMax();
        int range = max - min;
        return range > 0 ? (getProgress() - min) / (float) range : 0;
    }

}
