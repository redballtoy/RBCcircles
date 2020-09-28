package com.gmail.redballtoy.rbccircles;

import android.graphics.Canvas;
import android.graphics.Paint;

public class GameManager {
    private static int width;
    private static int height;
    private CanvasView canvasView;
    private MainCircle mainCircle;



    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        //переносим всю логику в GameManager
        initMainCircle();

    }

    private void initMainCircle() {
        //переносим всю логику в GameManager
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);


    }
}
