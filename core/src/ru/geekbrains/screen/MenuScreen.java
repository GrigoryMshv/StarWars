package ru.geekbrains.screen;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.Badlogic;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class MenuScreen extends BaseScreen {

    private Texture img; //отвечает за работу с текстурами
    private Texture bg;
    private Background background;
    private Badlogic badlogic;

    //иницилизация всех классов с которыми будем работать
    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        bg = new Texture("textures/fonstarwars.jpg");
        background = new Background(bg);
        badlogic = new Badlogic(img);
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        badlogic.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        img.dispose(); //выгружает из памяти текстуры
        bg.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        badlogic.touchDown(touch, pointer, button);
        return false;
    }

    private void update(float delta) {
        badlogic.update(delta);
    };

    private void draw() {
        batch.begin(); //начало отрисовки
        background.draw(batch);
        badlogic.draw(batch);
        batch.end(); //конец отрисовки
    };
}
