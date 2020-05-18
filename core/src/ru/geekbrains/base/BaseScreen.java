package ru.geekbrains.base;  //частично-общая логика для экранов

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.MatrixUtils;
import ru.geekbrains.math.Rect;

public class BaseScreen implements Screen, InputProcessor {

    private Rect screenBounds;  //координаты экрана
    private Rect worldBounds;   //мировые координаты
    private Rect glBounds;      //координаты openGL

    private Matrix4 worldToGl;      //преобразование из мировых координат в координаты openGL
    private Matrix3 screenToWorld; //преобразование из screen в мировые координаты

    private Vector2 touch;

    protected SpriteBatch batch; //передаёт в процессор текстуры


    //инициализация всего, что происходит на экране
    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        batch = new SpriteBatch();
        screenBounds = new Rect();
        worldBounds = new Rect();
        glBounds = new Rect(0, 0, 1f, 1f);
        worldToGl = new Matrix4();
        screenToWorld = new Matrix3();
        touch = new Vector2();
    }

    //работает 60fps
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0,0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {
        screenBounds.setSize(width, height);
        screenBounds.setLeft(0);
        screenBounds.setBottom(0);

        float aspect = width / (float) height;
        worldBounds.setHeight(1f);
        worldBounds.setWidth(1f * aspect);
        MatrixUtils.calcTransitionMatrix(worldToGl, worldBounds, glBounds);
        MatrixUtils.calcTransitionMatrix(screenToWorld, screenBounds, worldBounds);
        batch.setProjectionMatrix(worldToGl);
        resize(worldBounds);
    }

    public void resize(Rect worldBounds) {
    }

    //срабатывает когда свернули приложение
    @Override
    public void pause() {
    }

    //срабатывает когда развернули приложение
    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        dispose();
    }

    //сами решаем когда срабатывает метод, в даном случае вызываем в методе hide
    @Override
    public void dispose() {
        batch.dispose(); //выгружает всё лишнее из памяти
    }

    //срабатывает на нажатие клавиши
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    //срабатывает на отжатие клавиши
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    //срабатывает на определенную клавишу
    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    //тап пальцем или клик по экрану мышью (pointer - номер пальца, button - номер кнопки мыши)
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchDown(touch, pointer, button);
        return false;
    }

    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return false;
    }

    //убрали палец с экрана или отпустили мышь
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchUp(touch, pointer, button);
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return false;
    }

    //протащили палец по экрану или мышь
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchDragged(touch, pointer);
        return false;
    }

    public boolean touchDragged(Vector2 touch, int pointer) {
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
        return false;
    }
}
