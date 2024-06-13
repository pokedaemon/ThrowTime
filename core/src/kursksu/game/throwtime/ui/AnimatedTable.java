package kursksu.game.throwtime.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import kursksu.game.throwtime.utils.Constants;

public abstract class AnimatedTable extends Actor {
    protected Table table;
    private Status status;
    private OrientationFrom orientationFrom;
    private boolean isAnimate;
    private float time;
    private float maxTime;

    public enum OrientationFrom {
        Left,
        Right,
        Top,
        Bottom
    }

    public enum Status {
        Hided,
        Enabled,
        AnimToEnable,
        AnimToHided
    }

    public Status getStatus() {
        return status;
    }

    public void setOrientation(OrientationFrom orientationFrom) {
        this.orientationFrom = orientationFrom;
    }

    public OrientationFrom getOrientation() {
        return orientationFrom;
    }

    public float getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(float maxTime) {
        this.maxTime = maxTime;
    }

    public AnimatedTable() {
        table = prepareTable();
        table.setTouchable(Touchable.enabled);
        status = Status.Enabled;
        orientationFrom = OrientationFrom.Left;
        isAnimate = false;
        time = 0;
        maxTime = 1;
    }

    @Override
    public void setWidth(float width) {
        super.setWidth(width);
        table.setWidth(width);
    }

    @Override
    public void setHeight(float height) {
        super.setHeight(height);
        table.setHeight(height);
    }

    @Override
    public void setX(float x) {
        super.setX(x);
        table.setX(x);
    }

    @Override
    public void setY(float y) {
        super.setY(y);
        table.setY(y);
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        if(status == Status.Enabled)
            return table.hit(x, y, touchable);
        else
            return null;
    }

    @Override
    public Actor debug() {
        return table.debug();
    }

    @Override
    public void act(float delta) {
        if (status == Status.Enabled)
            table.act(delta);
        else {
            if (status == Status.AnimToEnable) {
                time += delta;
                if (time > maxTime * 1.65) {
                    status = Status.Enabled;
                    isAnimate = false;
                    time = 0;
                }
            }
            if (status == Status.AnimToHided) {
                time += delta;
                if (time > maxTime * 1.65) {
                    status = Status.Hided;
                    isAnimate = false;
                    time = 0;
                }
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        float x = getX();
        float y = getY();

        // x(t) = (x1 - x0) * (t / maxT) + x0
        // y(t) = (y1 - y0) * (t / maxT) + y0
        if(isAnimate) {
            float ax = 0, ay = 0, bx = getX(), by = getY();
            if(orientationFrom == OrientationFrom.Left) {
                ax = (x + getWidth()) / maxTime;
                bx = -getWidth();
            }
            if(orientationFrom == OrientationFrom.Right) {
                ax = (x - Constants.SCREEN_WIDTH) / maxTime;
                bx = Constants.SCREEN_WIDTH;
            }
            if(orientationFrom == OrientationFrom.Top) {
                ay = (y + getHeight()) / maxTime;
                by = -getWidth();
            }
            if(orientationFrom == OrientationFrom.Bottom) {
                ay = (y - getHeight()) / maxTime;
                by = Constants.SCREEN_HEIGHT;
            }

            if(status == Status.AnimToEnable) {
                x = ax * time + bx;
                y = ay * time + by;
            }
            if(status == Status.AnimToHided) {
                x = ax * (maxTime - time) + bx;
                y = ay * (maxTime - time) + by;
            }
        }

        table.setX(x);
        table.setY(y);

        if(status != Status.Hided)
            table.draw(batch, parentAlpha);
    }

    public void show() {
        if(status == Status.Hided) {
            status = Status.AnimToEnable;
            time = 0;
            isAnimate = true;
        }
    }

    public void hide() {
        if(status == Status.Enabled) {
            status = Status.AnimToHided;
            time = 0;
            isAnimate = true;
        }
    }

    protected abstract Table prepareTable();
}