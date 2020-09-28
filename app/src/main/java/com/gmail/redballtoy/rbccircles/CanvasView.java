package com.gmail.redballtoy.rbccircles;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;

import androidx.annotation.Nullable;

public class CanvasView extends View implements ICanvasView {
    private static int width;
    private static int height;
    private GameManager gameManager;
    private Paint paint;
    private Canvas canvas;


    //Этот класс оставляем только для отображения, логику игры переносим в
    //отдельный класс GameManager
    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    //другой вариант инициализации размеров
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //Определение ширины и высоты экран
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        String myLog = "myLog";
        Log.d(myLog, "Мы добрались в onMeasure\n getMeasuredWidth="
                + width + "\ngetMeasuredHeight = " + height);
        initPaint();
        gameManager = new GameManager(this, width, height);
    }

    //переносим всю логику в GameManager
    private void initPaint() {
        paint = new Paint();
        //устававливаем что бы было сглаживание
        paint.setAntiAlias(true);
        //устанавливаем что бы кружки заполнялись цветом
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;//сохраняем ссылку на canvas
        gameManager.onDraw();

    }

    @Override
    public void drawCircle(SimpleCircle circle) {
        canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(), paint);
    }

    //метод который будет вызван при прикосновении к экрану
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //получаем координаты касания
        int x = (int) event.getX();
        int y = (int) event.getY();
        //определить что за событие произошло
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            gameManager.onTouchEvent(x, y);
        }
        //асинхронная перерисовка вьюшки когда не требуется изменение размеров
        invalidate();
        return true;
    }
}
