package com.gmail.redballtoy.rbccircles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CanvasView extends View {
    private MainCircle mainCircle;
    private Paint paint;




    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initMainCurcle();
        //для рисования на канвасе необходимо определить кисть
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        //устававливаем что бы было сглаживание
        paint.setAntiAlias(true);
        //устанавливаем что бы кружки заполнялись цветом
        paint.setStyle(Paint.Style.FILL);

        /*Добавляем инициализацию канвы в шаблон
            <com.gmail.redballtoy.rbccircles.CanvasView
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
        */


    }

    private void initMainCurcle() {
        mainCircle = new MainCircle(200, 500);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //рисуем кружки
        canvas.drawCircle(mainCircle.getX(),mainCircle.getY(),mainCircle.getRadius(),paint);
    }
}
