package com.gmail.redballtoy.rbccircles;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;

public class GameManager {
    private static final int MAX_CIRCLES = 5;
    private static final int ENEMY_COLOR = Color.rgb(200, 0, 0);
    private static final int FOOD_COLOR = Color.rgb(0, 200, 0);
    private static int width;
    private static int height;
    private ArrayList<EnemyCircle> enemyCircles = new ArrayList<EnemyCircle>();
    private CanvasView canvasView;
    private MainCircle mainCircle;
    private String myLog="myLog";


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
    private void calculateAndSetCircleColor() {
        for (EnemyCircle circle : enemyCircles) {
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
        //При прикосновению к любому кругу игра останавливается
        checkCollision();
        //остальные круги тоже двигаются
        moveCircles();

    }

    private void checkCollision() {
        //проверяем пересечение c любым из существующих кругов
        for (EnemyCircle circle : enemyCircles) {
            //при прикосновению к красному кругу игра заканчивается, при
            //прикосновению к зеленому он исчезает а главный круг увеличивается
            //на размер зеленого
            if (mainCircle.isIntersect(circle)) {
                if (circle.getColor() == ENEMY_COLOR) {
                    Log.d(myLog, "circle.getColor() ENEMY_COLOR = " + ENEMY_COLOR);
                    gameEnd();
                    return;
                }else {
                    Log.d(myLog, "circle.getColor() FOOD_COLOR = " + FOOD_COLOR);
                    mainCircle.growRadius(circle);
                    enemyCircles.remove(circle);
                    calculateAndSetCircleColor();
                    break;
                }

            }
        }
    }

    //для окончания игры реализуем сброс
    private void gameEnd() {
        //восстанавливаем радиус у главного круга
        mainCircle.initRadius();
        //переинициализируем вражеские круги
        initEnemyCircles();
        //перерисуем холст
        canvasView.redraw();
    }

    //другие круги будут двигаться при только при прикосновению к экрану
    private void moveCircles() {
        //пробежались по всем кругам
        for (EnemyCircle circle : enemyCircles) {
            //подвинули груг на шаг
            circle.moveOneStep();
        }
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
