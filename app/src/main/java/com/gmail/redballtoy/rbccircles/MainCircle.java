package com.gmail.redballtoy.rbccircles;

//основной круг которым будем упоравлять во время игры
public class MainCircle {
    public static final int INIT_RADIUS = 50;
    public static final int MAIN_SPEED = 30;
    //координаты круга на экране
    private int x;
    private int y;
    private int radius;


    //вместо сеттеров будет конструктор который будет инициализировать круг
    public MainCircle(int x, int y) {
        this.x = x;
        this.y = y;
        this.radius = INIT_RADIUS;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void moveMainCircleWhenTouchAt(int x1, int y1) {
        //условная скорость перемещения?
        int dx = (x1 - x) * MAIN_SPEED / GameManager.getWidth();
        int dy = (y1 - y) * MAIN_SPEED / GameManager.getHeight();
        //в зависимости от расположения на экране скорость перемещения будет меняться
        //чем дальше касание от кружка тем быстрее скорость перемещения
        x += dx;
        y += dy;

    }
}
