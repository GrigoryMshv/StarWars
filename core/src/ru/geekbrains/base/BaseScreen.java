package ru.geekbrains.base;  //частично-общая логика для экранов

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BaseScreen implements Screen, InputProcessor {

    protected SpriteBatch batch; //передаёт в процессор текстуры


    //инициализация всего, что происходит на экране
    @Override
    public void show() {
        System.out.println("show");
        Gdx.input.setInputProcessor(this);
        batch = new SpriteBatch();
    }

    //работает 60fps
    @Override
    public void render(float delta) {
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("resize width = " + width + " height " + height);
    }

    //срабатывает когда свернули приложение
    @Override
    public void pause() {
        System.out.println("pause");
    }

    //срабатывает когда развернули приложение
    @Override
    public void resume() {
        System.out.println("resume");
    }

    @Override
    public void hide() {
        System.out.println("hide");
        dispose();
    }

    //сами решаем когда срабатывает метод, в даном случае вызываем в методе hide
    @Override
    public void dispose() {
        System.out.println("dispose");
        batch.dispose(); //выгружает всё лишнее из памяти
    }

    //срабатывает на нажатие клавиши
    @Override
    public boolean keyDown(int keycode) {
        System.out.println("keyDown " + keycode);
        return false;
    }

    //срабатывает на отжатие клавиши
    @Override
    public boolean keyUp(int keycode) {
        System.out.println("keyUp " + keycode);
        return false;
    }

    //срабатывает на определенную клавишу
    @Override
    public boolean keyTyped(char character) {
        System.out.println("keyTyped " + character);
        return false;
    }

    //тап пальцем или клик по экрану мышью (pointer - номер пальца, button - номер кнопки мыши)
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchDown " + screenX + " " + screenY);
        return false;
    }

    //убрали палец с экрана или отпустили мышь
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchUp " + screenX + " " + screenY);
        return false;
    }

    //протащили палец по экрану или мышь
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("touchDragged " + screenX + " " + screenY);
        return false;
    }

    //срабатывает при любом движении мыши
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    //срабатывает при скроле мыши
    @Override
    public boolean scrolled(int amount) {
        System.out.println("scrolled " + amount);
        return false;
    }
}
