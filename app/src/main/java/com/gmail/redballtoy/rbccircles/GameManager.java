package com.gmail.redballtoy.rbccircles;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public class GameManager {
    private static final int MAX_CIRCLES = 10;
    private static int width;
    private static int height;
    private ArrayList<EnemyCircle> enemyCircles;
    private CanvasView canvasView;
    private MainCircle mainCircle;


    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        //переносим всю логику в GameManager
        initMainCircle();
        initEnemyCircles();

    }

    private void initEnemyCircles() {
        //получение области занимаемой кругом
        SimpleCircle mainCircleArea = mainCircle.getCircleArea();
        //выделяем память под коллекцию
        enemyCircles = new ArrayList<EnemyCircle>();
        //создание кругов в цикле
        for (int i = 0; i < MAX_CIRCLES; i++) {
            EnemyCircle circle;
            //будем пересоздавать круг до тех пор пока он пересекается с нашим
            //основным кругом
            do {
                //создать случайный круг
                circle = EnemyCircle.getRandomCircle();
            } while (circle.isIntersect(mainCircleArea));
            enemyCircles.add(circle);
        }
        //круги меньшего чем наш размера (зеленые) можем съедать,
        //круги большего чем наш размер (красные) от них убегать
        calculateAndSetCircleColor();
    }
    //круги меньшего чем наш размера (зеленые) можем съедать,
    //круги большего чем наш размер (красные) от них убегать
    private void calculateAndSetCircleColor(){
        for (EnemyCircle circle: enemyCircles){
            circle.setEnemyOrFoodColorDependsOn(mainCircle);

        }
    }


    private void initMainCircle() {
        //переносим всю логику в GameManager
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle : enemyCircles) {
            canvasView.drawCircle(circle);
        }


    }

    public void onTouchEvent(int x, int y) {
        //при касании передвинуться в соординаты касания
        mainCircle.moveMainCircleWhenTouchAt(x, y);
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
