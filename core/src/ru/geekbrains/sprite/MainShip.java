package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class MainShip extends Sprite {

    public MainShip(TextureAtlas mainAtlas) {
        super(mainAtlas.findRegion("main_ship").split(mainAtlas.findRegion("main_ship").getRegionWidth()/2,
                mainAtlas.findRegion("main_ship").getRegionHeight())[0]);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.3f);
    }
}
