package com.ismailhakkiaydin.visualinterface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measureHeight = measureHeight(heightMeasureSpec);
        int measureWitdh = measureWitdh(widthMeasureSpec);

        setMeasuredDimension(measureHeight, measureWitdh);
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private int measureHeight(int measureSpec){
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        int result = 500;

        if (specMode == MeasureSpec.AT_MOST){
            result = specSize;
        }else if (specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }

        return result;

    }

    private int measureWitdh(int measureSpec){
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        int result = 500;

        if (specMode == MeasureSpec.AT_MOST){

            result = specSize;
        }else if (specMode == MeasureSpec.EXACTLY){

            result = specSize;
        }

        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int height = getMeasuredHeight();
        int witdh = getMeasuredWidth();

        int px =witdh/2;
        int py = height/2;

        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.MAGENTA);

        String displayText = "Hello IHA...";

        float textWidh = textPaint.measureText(displayText);

        canvas.drawText(displayText, px-textWidh/2, py,textPaint);

    }
}
