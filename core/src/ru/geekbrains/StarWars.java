package ru.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StarWars extends ApplicationAdapter {
	SpriteBatch batch; //передаёт в процессор текстуры
	Texture img; //отвечает за работу с текстурами
	static Texture background;
	
	@Override  //иницилизация всех классов с которыми будем работать
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
        background = new Texture("fonstarwars.jpg");
	}

	@Override
	public void render () {   //метод срабатывает 60fps
		batch.begin(); //начало отрисовки
        batch.draw(background, 0f, 0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(img, 0f, 0f);
		batch.end(); //конец отрисовки
	}
	
	@Override
	public void dispose () {
		batch.dispose(); //выгружает всё лишнее из памяти
		img.dispose(); //выгружает из памяти текстуры?
        background.dispose();
	}
}
