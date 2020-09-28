package com.gmail.redballtoy.rbccircles;


import android.graphics.Color;

import java.util.Random;

//Вражеские круги
public class EnemyCircle extends SimpleCircle {

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
}
