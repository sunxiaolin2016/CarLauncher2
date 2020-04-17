package com.demo.carsettings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Switch;

import com.demo.carsettings.R;


public class SwitchWithText extends Switch {
    String minText;
    String maxText;
    Paint textPaint;

    public SwitchWithText(Context context) {
        this(context, null);
    }

    public SwitchWithText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SwitchWithText);
        minText = array.getString(R.styleable.SwitchWithText_min_text);

        maxText = array.getString(R.styleable.SwitchWithText_max_text);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(28);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawText(canvas);
    }

    void drawText(Canvas canvas) {
        if (minText != null) {
            int half = (getRight() - getLeft()) / 2;
            canvas.drawText(minText, (half - textPaint.measureText(minText)) / 2, getHeight() / 2 + textPaint.getFontMetrics().descent, textPaint);
        }
        if (maxText != null) {
            int half = (getRight() - getLeft()) / 2;
            canvas.drawText(maxText, half + (half-(textPaint.measureText(minText))) / 2, getHeight() / 2 + textPaint.getFontMetrics().descent, textPaint);
        }
    }
}

