package ru.geekbrains.screen;
import ru.geekbrains.StarWars;

public class ScreenController {
    private final StarWars starWars;
    private MenuScreen menuScreen;
    private GameScreen gameScreen;
    private boolean music = true, effects = true;

    public ScreenController(StarWars starWars) {
        this.starWars= starWars;
        this.menuScreen = new MenuScreen();
        this.menuScreen.setScreenController(this);
        setMenuScreen();
    }
    public void setMenuScreen(){
        starWars.setScreen(menuScreen);
    }
    public void setGameScreen(){
        if (gameScreen == null){
            gameScreen = new GameScreen();
            gameScreen.setScreenController(this);
        }
        starWars.setScreen(gameScreen);
    }

    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public boolean isEffects() {
        return effects;
    }

    public void setEffects(boolean effects) {
        this.effects = effects;
    }
}