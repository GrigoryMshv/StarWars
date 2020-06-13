package ru.geekbrains.pool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Enemy;
import ru.geekbrains.screen.ScreenController;

public class EnemyPool extends SpritesPool <Enemy> {

    private ExplosionPool explosionPool;
    private Sound shootSound;

    public EnemyPool(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds, ScreenController screenController) {
        super(screenController);
        this.worldBounds = worldBounds;
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;

        @Override
        protected Enemy newObject () {
            Enemy newEnemy = new Enemy(bulletPool, explosionPool, worldBounds, shootSound);
            newEnemy.setScreenController(screenController);
            return newEnemy;
        }

        @Override
        public void dispose () {
            super.dispose();
            shootSound.dispose();
        }
    }
}
