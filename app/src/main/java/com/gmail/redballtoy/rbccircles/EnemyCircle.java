package com.gmail.redballtoy.rbccircles;


import android.graphics.Color;

import java.util.Random;

//Вражеские круги
public class EnemyCircle extends SimpleCircle {

    private static final int ENEMY_COLOR = Color.rgb(200, 0, 0);
    private static final int FOOD_COLOR = Color.rgb(0, 200, 0);
    private static final int RANDOM_SPEED = 10;
    private int dx;
    private int dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    //фабрика создания кругов врагов
    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int radius = 20 + random.nextInt(GameManager.getWidth()) / 8;
        //добавим что бы направление и скорость тоже были случайными
        int dx = 1 + random.nextInt(RANDOM_SPEED);
        int dy = 1 + random.nextInt(RANDOM_SPEED);
        EnemyCircle enemyCircle = new EnemyCircle(x, y, radius, dx,dy);
        enemyCircle.setColor(Color.RED);
        return enemyCircle;
    }

    //установить цвет в зависимости от радиуса
    public void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if (isSmallerThan(mainCircle)) {
            setColor(FOOD_COLOR);
        } else {
            setColor(ENEMY_COLOR);
        }

    }

    //сравненение круга с любым другим
    private boolean isSmallerThan(SimpleCircle circle) {
        if (radius < circle.radius) {
            return true;
        } else {
            return false;
        }
    }

    //автоматическое передвижение круга при касании
    public void moveOneStep() {
        //для этого нужно изменить координаты на некоторое число
        x += dx;
        y += dy;
    }
}
