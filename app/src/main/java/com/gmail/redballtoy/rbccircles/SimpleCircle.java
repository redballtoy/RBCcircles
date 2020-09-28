package com.gmail.redballtoy.rbccircles;

//предок всех кругов что бы можно было создавать круги еды и врагов
//изменяющимися параметрами будут координаты и радиус
public class SimpleCircle {
    //координаты круга на экране
    protected int x;
    protected int y;
    protected int radius;
    private int color;


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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public SimpleCircle getCircleArea() {
        return new SimpleCircle(x, y, radius * 3);
    }

    public boolean isIntersect(SimpleCircle circle) {
        //сравниваем разницу радиусов с расстояниес между ними выраженное через
        //координаты как гипотенузу треегольника
        return radius + circle.radius >= Math.sqrt(Math.pow(x - circle.x, 2)
                + Math.pow(y - circle.y, 2));

    }
}
