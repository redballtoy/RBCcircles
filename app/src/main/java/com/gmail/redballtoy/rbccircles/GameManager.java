package com.gmail.redballtoy.rbccircles;

import android.graphics.Canvas;
import android.graphics.Paint;

public class GameManager {
    //переносим всю логику в GameManager
    private MainCircle mainCircle;
    private Paint paint;
    private CanvasView canvasView;
    private static int width;
    private static int height;


    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        //переносим всю логику в GameManager
        initMainCircle();
        initPaint();
    }

    //переносим всю логику в GameManager
    private void initPaint() {
        paint = new Paint();
        //устававливаем что бы было сглаживание
        paint.setAntiAlias(true);
        //устанавливаем что бы кружки заполнялись цветом
        paint.setStyle(Paint.Style.FILL);
    }


    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    public void onDraw(Canvas canvas) {
        //перенесено из CanvasView
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }
}
