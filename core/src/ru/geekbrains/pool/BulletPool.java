package ru.geekbrains.pool;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.sprite.Bullet;
import ru.geekbrains.screen.ScreenController;

public class BulletPool extends SpritesPool <Bullet>{

    public BulletPool(ScreenController screenController) {
        super(screenController);
    }

    @Override
    protected Bullet newObject() {
        Bullet newBullet = new Bullet();
        newBullet.setScreenController(screenController);
        return newBullet;
    }
}
