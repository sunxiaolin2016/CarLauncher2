package com.demo.carsettings.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class WindowOpenRankSeekBar extends AppCompatSeekBar {

    static String TAG = "WindowRankSeekBar";
    private int mTrackColor;
    private Paint mPaint;
    private int rank = 9;
    private Paint textPaint;

    private ActiveListener activeListener;

    private boolean isShowThumb = false;

    public WindowOpenRankSeekBar(Context context) {
        super(context, null);
        init();
    }

    public WindowOpenRankSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WindowOpenRankSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(getParent() != null){
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(event);
    }

    private void init() {
        mTrackColor = Color.parseColor("#0F0F1A");
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(28);
        //取消控件的padding方便计算坐标
        setPadding(0,0,0,0);
    }

    void drawTrack(Canvas canvas) {
        float thumbWith = getThumb().getIntrinsicWidth();
        float thumbOffsetAbs = Math.abs(getThumbOffset());
        float rankY = getHeight() / 2;
        float rankCirclR = 12;

        float rankSpan = (getWidth() - rankCirclR  - thumbOffsetAbs * 2 - thumbWith) / (rank - 1);
        float rankX;

        float trackStartX = rankCirclR / 2 +   thumbOffsetAbs + thumbWith / 2f;
        float trackEndX = getWidth() -  thumbOffsetAbs - thumbWith / 2f;

//        Log.d(TAG,String.format("thumbWith %.1f thumboffset %.1f",thumbWith,thumbOffsetAbs));
//        Log.d(TAG,String.format("trackStartX %.1f trackEndX %.1f",trackStartX,trackEndX));

        mPaint.setStrokeWidth(2);
        mPaint.setColor(mTrackColor);
        canvas.drawLine(trackStartX, rankY, trackEndX, rankY, mPaint);

        mPaint.setStrokeWidth(1);
        mPaint.setStyle(Paint.Style.FILL);

        rankX = trackStartX;

        for (int i = 0; i < rank; i++) {
            canvas.drawCircle(rankX, rankY, rankCirclR / 2, mPaint);
            rankX += rankSpan;
        }
    }

    public boolean isThumbShow()
    {
        return isShowThumb;
    }

    public void setShowThumb(boolean value)
    {
        this.isShowThumb = value;
        invalidate();
        if (isShowThumb && !firstFlag) {
            if (activeListener != null)
                activeListener.onActive();
            firstFlag = true;
        }
        if (!isShowThumb)
            firstFlag = false;
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        drawTrack(canvas);
        if (isShowThumb) {
            super.onDraw(canvas);
            drawText(canvas);
        }
    }

    boolean firstFlag;

    void drawText(Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft() - getThumbOffset(), getPaddingTop());
        String scaleTxt = String.format("%d档", (int) (getProgress() + 1));
        Rect thumbRect = getThumb().getBounds();
        canvas.drawText(scaleTxt, thumbRect.left + (thumbRect.width() - textPaint.measureText(scaleTxt)) / 2f, getHeight() / 2 + textPaint.getFontMetrics().descent, textPaint);
        canvas.restore();
    }

    public void addAciveListener(ActiveListener activeListener) {
        this.activeListener = activeListener;
    }

    public interface ActiveListener {
        void onActive();
    }
}
