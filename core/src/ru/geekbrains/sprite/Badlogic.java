package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
/* не смог перенести логику в этот спрайт, т.к. не смог привести координаты мнтода touchDown
   к координатам в которых существует логотип Badlogic
*/

public class Badlogic extends Sprite {

    public Badlogic(Texture texture) {
        super(new TextureRegion(texture));
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
        System.out.println("touch "+ touch.x + " " + touch.y);
        return false;
    }
}
