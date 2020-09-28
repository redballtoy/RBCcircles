package com.gmail.redballtoy.rbccircles;

import android.graphics.Canvas;
import android.graphics.Paint;

public class GameManager {
    //переносим всю логику в GameManager
    private MainCircle mainCircle;
    private Paint paint;

    public GameManager() {
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
        mainCircle = new MainCircle(200, 500);
    }

    public void onDraw(Canvas canvas) {
        //перенесено из CanvasView
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }
}
