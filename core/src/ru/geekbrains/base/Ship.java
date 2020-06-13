package ru.geekbrains.base;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.pool.ExplosionPool;
import ru.geekbrains.sprite.Bullet;
import ru.geekbrains.sprite.Explosion;

public class Ship extends Sprite {

    private static final float DAMAGE_ANIMATE_INTERVAL = 0.1f;

    protected Vector2 vel, velStart;

    protected Rect worldBounds;

    protected ExplosionPool explosionPool;
    protected BulletPool bulletPool;
    protected TextureRegion bulletRegion;
    protected Vector2 bulletVelocity;
    protected Vector2 bulletPos;
    protected float bulletHeight;
    protected int bulletDamage;

    protected int healthPoints;
    protected int damage;

    protected float reloadInterval;
    protected float reloadTimer;

    protected Sound shootSound;
    private float damageAnimateTimer;
    protected boolean giveBonus;
    protected int hp;

    public Ship(TextureRegion region, int rows, int cols, int frames) {
        super(region, rows, cols, frames);
        this.velStart = new Vector2();
        this.vel = new Vector2();
        this.giveBonus = false;
        this.bulletPos = new Vector2();
        this.damageAnimateTimer = DAMAGE_ANIMATE_INTERVAL;
    }

    public Ship(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds, Sound shootSound) {
        this.worldBounds = worldBounds;
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.velStart = new Vector2();
        this.vel = new Vector2();
        this.shootSound = shootSound;
        this.bulletVelocity = new Vector2();
        this.bulletPos = new Vector2();
        this.damageAnimateTimer = DAMAGE_ANIMATE_INTERVAL;
        this.giveBonus = false;
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(vel, delta);
        damageAnimateTimer += delta;
        if(damageAnimateTimer >= DAMAGE_ANIMATE_INTERVAL){
            frame = 0;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        boom();
    }

    public void damage(int damage){
        damageAnimateTimer = 0f;
        frame = 1;
        healthPoints -= damage;
        if(healthPoints <= 0){
            healthPoints = 0;
            destroy();
        }
    }

    public int getDamage(){
        return damage;
    }

    public void autoShoot(float delta){
        reloadTimer += delta;
        if (reloadTimer >= reloadInterval){
            reloadTimer = 0f;
            shoot();
        }
    }

    protected void shoot(){
        Bullet bullet = bulletPool.obtain();
        bullet.set(this,
                bulletRegion,
                bulletPos,
                bulletVelocity,
                bulletHeight,
                worldBounds,
                bulletDamage
        );
        if(getScreenController().isEffects()) {
            shootSound.play();
        }
    }

    private void boom(){
        Explosion explosion = explosionPool.obtain();
        explosion.set(getHeight(), pos);
    }

    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public boolean isGiveBonus() {
        return giveBonus;
    }
}
