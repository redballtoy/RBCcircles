package com.gmail.redballtoy.rbccircles;


//рефакторинг замены на интерфейс для повышения гибкости
public interface ICanvasView {
    //метод для рисования
    void drawCircle(SimpleCircle circle);

    //перерисовка вью
    void redraw();

    void showMessage(String msg);
}
