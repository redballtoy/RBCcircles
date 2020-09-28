package com.gmail.redballtoy.rbccircles;

//предок всех кругов что бы можно было создавать круги еды и врагов
//изменяющимися параметрами будут координаты и радиус
public class SimpleCircle {
    //координаты круга на экране
    protected int x;
    protected int y;
    protected int radius;


    public SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
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
