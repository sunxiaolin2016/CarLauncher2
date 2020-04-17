package com.demo.carsettings.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.demo.carsettings.R;

public class CenterSeekBar extends View {
    private final int DEFAULT_THUMB_COLOR = Color.GRAY;
    float Mindx;
    private final Paint paint;
    private Context mContext;
    private float dx;
    private float width = 800; // need <= getWidth()
    private Paint paint1;
    /**
     * progress start max
     */
    private int minProgress = 0;
    private int offset;
    /**
     * progress end max
     */
    private int maxProgress = 5;
    /**
     * 进度条的颜色 底色 背景色
     */
    @ColorInt
    private int progressBackColor = Color.BLACK;
    /**
     * 进度条的底色 高度
     */
    private float progressBackHeight = 10;
    /**
     * 进度条的颜色
     */
    @ColorInt
    private int progressColor ;
    /**
     * 进度条的 高度
     */
    private float progressHeight = 20;
    /**
     * 如果0在中间,负进度条的颜色
     */
    @ColorInt
    private int progressMinusColor = Color.WHITE;
    /**
     * current progress
     */
    private int progress = 50;
    /**
     * seekBar Thumb normal radius
     */
    private float mThumbNormalRadius = 14;
    /**
     * seekBar Thumb color
     */
    @ColorInt
    private int mThumbColor = DEFAULT_THUMB_COLOR;

    /**
     * progress 字体 背景 radius
     */
    private float mTextBackRadius = 20;
    /**
     * 判断是否是 0 在中间
     */
    private boolean mIsCenterState = true;
    private float mThumbRadius = mThumbNormalRadius;
    private float progressPosition;
    private boolean isTouchLegal = true;
    private ObjectAnimator mAnimator; //  seekBar Thumb Animator
    private RectF mTextRectF, mBackRectF, mProgressRectF, mThumbRecF;
    private int mThumbDrawColor = DEFAULT_THUMB_COLOR;
    private OnSeekBarChangeListener mOnSeekBarChangeListener;
    private OnSeekBarProgressListener mOnSeekBarProgressListener;
    private OnSeekBarFinishedListener mOnSeekBarFinishedListener;

    public CenterSeekBar(Context context) {
        this(context, null);
    }

    public CenterSeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CenterSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        paint = new Paint();
        paint1 = new Paint();
        paint.setAntiAlias(true);
        if (attrs != null) {
            TypedArray styledAttrs = getContext().obtainStyledAttributes(attrs,
                    R.styleable.CenterSeekBar, 0, 0);
            maxProgress = styledAttrs.getInteger(R.styleable.CenterSeekBar_maxProgress, 5);
            minProgress = styledAttrs.getInteger(R.styleable.CenterSeekBar_minProgress, 0);
            width = styledAttrs.getDimension(R.styleable.CenterSeekBar_width, 800);
            mIsCenterState = styledAttrs.getBoolean(R.styleable.CenterSeekBar_centerState, true);
            progressBackColor = styledAttrs.getColor(R.styleable.CenterSeekBar_backColor, Color.BLACK);
            progressBackHeight = styledAttrs.getDimension(R.styleable.CenterSeekBar_backHeight, 12);
            progressColor = styledAttrs.getColor(R.styleable.CenterSeekBar_progressColor, Color.GREEN);
            progressHeight = styledAttrs.getDimension(R.styleable.CenterSeekBar_progressHeight, progressBackHeight);
            progressMinusColor = styledAttrs.getColor(R.styleable.CenterSeekBar_progressMinusColor, Color.WHITE);
            progress = styledAttrs.getInteger(R.styleable.CenterSeekBar_progress, 0);
            mThumbNormalRadius = styledAttrs.getDimension(R.styleable.CenterSeekBar_thumbNormalRadius, 26);
            mThumbColor = styledAttrs.getColor(R.styleable.CenterSeekBar_thumbColor, Color.RED);
            mTextBackRadius = styledAttrs.getDimension(R.styleable.CenterSeekBar_textBackRadius, 10);
            offset = styledAttrs.getInteger(R.styleable.CenterSeekBar_thumbOffset, 36);
            mThumbRadius = mThumbNormalRadius;
            mThumbDrawColor = mThumbColor;
            styledAttrs.recycle();
        }
        mTextRectF = new RectF();
        mBackRectF = new RectF();
        mProgressRectF = new RectF();
        mThumbRecF = new RectF();
        Mindx = (width - 72) / (maxProgress * 2);
    }

    public void setProgress(int progress) {
        if (progress <= maxProgress && progress >= minProgress - maxProgress) {
            this.progress = progress;
        } else {
            this.progress = minProgress;
        }
        dx = width / 2 - (Mindx * progress);
        invalidate();
    }


    public int getProgress() {
        return progress;
    }

    public CenterSeekBar setOnSeekBarChangeListener(OnSeekBarChangeListener l) {
        mOnSeekBarChangeListener = l;
        return this;
    }

    public CenterSeekBar setOnSeekBarProgressListener(OnSeekBarProgressListener l) {
        mOnSeekBarProgressListener = l;
        return this;
    }

    public CenterSeekBar setOnSeekBarFinishedListener(OnSeekBarFinishedListener l) {
        mOnSeekBarFinishedListener = l;
        return this;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centerX = getWidth() / 2; // x 是center
        int centerY = getHeight() / 2; // y 是 2/3 高度
        Log.d("dy", "onDraw: "+centerY);
        float startX = centerX - width / 2;

        // draw background line
        paint.setColor(progressBackColor);
        paint.setStyle(Paint.Style.FILL); // 实心
        mBackRectF.left = startX;
        mBackRectF.top = centerY - progressBackHeight/2;
        mBackRectF.right = startX + width;
        mBackRectF.bottom = centerY+progressBackHeight/2;
        canvas.drawRoundRect(mBackRectF, mTextBackRadius, mTextBackRadius, paint);

        paint.setStyle(Paint.Style.FILL);
        progressColor = Color.parseColor("#EEE0CC");
        paint.setColor(progressColor);

        // draw progress
        paint.setStrokeWidth(progressHeight);
        paint.setColor(progressColor);
        if (mIsCenterState) {

            startX = centerX;
            if (dx < offset) {
                dx = offset;
            }
            if (dx > (width - offset)) {
                dx = (width - offset);
            }
            progressPosition = dx - offset;
        }
        mProgressRectF.top = centerY - progressBackHeight/2;
        mProgressRectF.bottom =  centerY + progressBackHeight / 2;
        if (progress > 0) {
            mProgressRectF.left = startX;
            mProgressRectF.right = progressPosition;
        } else {
            mProgressRectF.left = progressPosition;
            mProgressRectF.right = startX;
        }
        canvas.drawRoundRect(mProgressRectF, mTextBackRadius, mTextBackRadius, paint);

        paint.setColor(Color.parseColor("#656575"));
        mThumbRecF.left = progressPosition;
        mThumbRecF.right = progressPosition + 2 * offset;
        mThumbRecF.top = centerY-20;
        mThumbRecF.bottom = centerY +20;
        // draw point
        canvas.drawRoundRect(mThumbRecF, mThumbRadius, mThumbRadius, paint);
        paint1.setColor(Color.WHITE);


        canvas.drawLine(width / 2, getTop(), width / 2, getTop() + 10, paint1);
        canvas.drawLine(width / 2, getBottom(), width / 2, getBottom()-10, paint1);
    }

    //    private int mLastProgress;
    private long mLastTime;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(getParent() != null){
            getParent().requestDisallowInterceptTouchEvent(true);
        }

        progress = (int) clamp((int) event.getX());
        dx = event.getX();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                invalidate();
            case MotionEvent.ACTION_MOVE:
                Log.d("slack", "progress: " + progress);
                long currentTime = System.currentTimeMillis();
                if (currentTime - mLastTime < 50) {
                    // 刷新 FPS 不超过 20 fps
                    break;
                }
                mLastTime = currentTime;
                invalidate(); // 在UI线程中使用 刷新View
                break;
            case MotionEvent.ACTION_UP:
                if (mOnSeekBarChangeListener != null) {
                    mOnSeekBarChangeListener.onProgress(-progress);
                } else if (mOnSeekBarProgressListener != null) {
                    mOnSeekBarProgressListener.onProgress(-progress);
                }
                break;
        }
        return true;
    }

    private float clamp(int value) {
        int centerX = getWidth() / 2;
        float min = centerX - width / 2 + offset;// the start point
        Log.d("min", "clamp: " + min);
        float max = centerX + width / 2 - offset;// the end point

        if (value > centerX) {
            if (value >= max) {
                return maxProgress;
            } else {
                return (int) (value / Mindx) - maxProgress;
            }
        } else if (value < centerX) {
            if (value <= min) {
                return -maxProgress;
            } else {
                return (int) (value / Mindx) - maxProgress;
            }
        } else {
            return 0;
        }
    }

    public interface OnSeekBarProgressListener {
        void onProgress(int progress);
    }

    public interface OnSeekBarFinishedListener {
        void onFinished(int progress);
    }

    public interface OnSeekBarChangeListener extends OnSeekBarProgressListener, OnSeekBarFinishedListener {
    }
}
