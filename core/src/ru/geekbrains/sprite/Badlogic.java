package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
/* не смог перенести логику в этот спрайт, т.к. в классе BaseScreen была ошибка
*/

public class Badlogic extends Sprite {

    final static float V_LEN = 0.01f;

    private Vector2 newPos, vel, touch;

    public Badlogic(Texture texture) {
        super(new TextureRegion(texture));
        touch = new Vector2();
        newPos = new Vector2();
        vel = new Vector2();
    }

    @Override
    public void update(float delta) {
        newPos.set(touch);
        if((newPos.sub(pos)).len() > V_LEN) {
            pos.add(vel);
        } else {
            pos.set(touch);
            vel.setZero();
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.3f);
        this.pos.set(worldBounds.getLeft() + halfWidth, worldBounds.getBottom() + halfHeight);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        vel.set(touch.sub(pos)).nor().scl(V_LEN);
        return false;
    }
}
