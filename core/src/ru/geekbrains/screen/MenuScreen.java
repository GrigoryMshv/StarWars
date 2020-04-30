package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img; //отвечает за работу с текстурами
    private Texture background;


    private Vector2 pos, newPos, vel, deltaPos, touch;

    //иницилизация всех классов с которыми будем работать
    @Override
    public void show() {
        super.show();
        background = new Texture("fonstarwars.jpg");
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        newPos = new Vector2(pos);
        vel = new Vector2();
        deltaPos = new Vector2();
        touch = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin(); //начало отрисовки
        batch.draw(background, 0f, 0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        if(!move())
            pos.add(vel);
        batch.draw(img, pos.x, pos.y);
        batch.end(); //конец отрисовки
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchDown touch = " +  touch.x + " " + touch.y);
        newPos.set(screenX, Gdx.graphics.getHeight() - screenY);
        newVel();
        return false;
    }

    private boolean move() {
        deltaPos.set(newPos.x - pos.x, newPos.y - pos.y);

        if(vel.len() > 0 && vel.len() >= deltaPos.len()) {
            pos.set(newPos);
            vel.set(0, 0);
            deltaPos.set(0, 0);
            return true;
        }
        if(deltaPos.len() > 0)
            vel.scl(1.1f);
        return false;
    }

    private void newVel() {
        vel.set(newPos.x - pos.x, newPos.y - pos.y).nor();
    }

    @Override
    public void dispose() {
        img.dispose(); //выгружает из памяти текстуры?
        background.dispose();
        super.dispose();
    }
}
