package com.gmail.redballtoy.rbccircles;


import android.graphics.Color;

import java.util.Random;

//Вражеские круги
public class EnemyCircle extends SimpleCircle {

    private static final int ENEMY_COLOR = Color.rgb(200, 0, 0);
    private static final int FOOD_COLOR = Color.rgb(0, 200, 0);

    public EnemyCircle(int x, int y, int radius) {
        super(x, y, radius);
    }

    //фабрика создания кругов врагов
    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int radius = 20 + random.nextInt(GameManager.getWidth()) / 8;
        EnemyCircle enemyCircle = new EnemyCircle(x, y, radius);
        enemyCircle.setColor(Color.RED);
        return enemyCircle;
    }

    public void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if (isSmallerThan(mainCircle)) {
            setColor(FOOD_COLOR);
        } else {
            setColor(ENEMY_COLOR);
        }

    }

    private boolean isSmallerThan(SimpleCircle circle) {
        if (radius < circle.radius) {
            return true;
        } else {
            return false;
        }
    }
}
