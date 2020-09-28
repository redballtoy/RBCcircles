package com.gmail.redballtoy.rbccircles;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;

import androidx.annotation.Nullable;

public class CanvasView extends View {
    /*переносим всю логику в GameManager
    private MainCircle mainCircle;
    private Paint paint;*/
    private GameManager gameManager;
    //Определение ширины и высоты экран
    private static int width;
    private static int height;
    private static String myLog = "myLog";


    //Этот класс оставляем только для отображения, логику игры переносим в
    //отдельный класс GameManager
    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //другой вариант инициализации размеров
    @SuppressLint("DrawAllocation")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = getMeasuredWidth();
        height = getMeasuredHeight();
        Log.d(myLog,"Мы добрались в onMeasure\n getMeasuredWidth="
                +width+"\ngetMeasuredHeight = " +height );
        gameManager = new GameManager(this, width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //при рисовании будем вызывать метод onDraw в классе отвечающем за логику игры
        gameManager.onDraw(canvas);
    }
}
