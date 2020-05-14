package ru.geekbrains;

import com.badlogic.gdx.Game;

import ru.geekbrains.screen.MenuScreen;

public class StarWars extends Game {
	
	@Override  //иницилизация всех классов с которыми будем работать
	public void create () {
        setScreen(new MenuScreen(this));
	}
}
