package com.gmail.redballtoy.rbccircles;

//основной круг которым будем упоравлять во время игры
public class MainCircle {
    public static final int INIT_RADIUS=50;
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
}
