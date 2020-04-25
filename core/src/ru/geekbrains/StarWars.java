package ru.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StarWars extends ApplicationAdapter {
	SpriteBatch batch; //передаёт в процессор текстуры
	Texture img; //отвечает за работу с текстурами
	
	@Override  //иницилизация всех классов с которыми будем работать
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {   //метод срабатывает 60fps
		Gdx.gl.glClearColor(1, 0, 0, 1); //цвет фона
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //что это?
		batch.begin(); //начало отрисовки
		batch.draw(img, 0, 0);
		batch.end(); //конец отрисовки
	}
	
	@Override
	public void dispose () {
		batch.dispose(); //выгружает всё лишнее из памяти
		img.dispose(); //выгружает из памяти текстуры?
	}
}
