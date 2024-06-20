package kursksu.game.throwtime.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.utils.Constants;

public abstract class AnimatedTable extends Actor {

    protected ThrowTime parent;
    protected Table table;
    private OrientationFrom orientation;
    private Status status;
    private float maxTime;

    public AnimatedTable(ThrowTime parent) {
        this.parent = parent;
        table = prepareTable();
        table.setTouchable(Touchable.enabled);
        maxTime = 1f;
        orientation = OrientationFrom.Bottom;
    }

    public enum OrientationFrom {
        Left,
        Right,
        Top,
        Bottom
    }

    // TODO: include using status in code and etc.
    public enum Status {
        Hided,
        Enable
    }

    // setters
    public void setOrientation(OrientationFrom orientationFrom) {
        this.orientation = orientationFrom;
    }

    public void setMaxTime(float maxTime) {
        this.maxTime = maxTime;
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

    // getters

    public OrientationFrom getOrientation() {
        return orientation;
    }

    public float getMaxTime() {
        return maxTime;
    }

    public Status getStatus() {
        return status;
    }

    // TODO: other override stuff

    public boolean isAnimate() {
        return table.getActions().size > 0;
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        if(!isAnimate())
            return table.hit(x, y, touchable);
        return null;
    }

    @Override
    public Actor debug() {
        return table.debug();
    }

    @Override
    public void act(float delta) {
        table.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        table.draw(batch, parentAlpha);
    }

    public void show() {
        Vector2 start = getVectorFrom();

        Action actionTop = new SequenceAction(
                Actions.moveBy(0, -start.len() * 3, maxTime, Interpolation.exp10Out)
        );

        Action actionBottom = new SequenceAction(
                Actions.moveBy(0, start.len() * 3, maxTime, Interpolation.exp10Out)
        );

        Action actionRight = new SequenceAction(
                Actions.moveBy(-start.len() * 3, 0, maxTime, Interpolation.exp10Out)
        );

        Action actionLeft = new SequenceAction(
                Actions.moveBy(start.len() * 3, 0, maxTime, Interpolation.exp10Out)
        );

        switch(orientation) {
            case Top:
                table.addAction(actionTop);
                break;
            case Bottom:
                table.addAction(actionBottom);
                break;
            case Left:
                table.addAction(actionLeft);
                break;
            case Right:
                table.addAction(actionRight);
                break;
        }
    }

    public void hide() {
        Vector2 start = getVectorFrom();

        Action actionTop = new SequenceAction(
                Actions.moveBy(0, start.len() * 3, maxTime, Interpolation.circle)
        );

        Action actionBottom = new SequenceAction(
                Actions.moveBy(0, -start.len() * 3, maxTime, Interpolation.circle)
        );

        Action actionRight = new SequenceAction(
                Actions.moveBy(start.len() * 3, 0, maxTime, Interpolation.circle)
        );

        Action actionLeft = new SequenceAction(
                Actions.moveBy(-start.len() * 3, 0, maxTime, Interpolation.circle)
        );

        switch(orientation) {
            case Top:
                table.addAction(actionTop);
                break;
            case Bottom:
                table.addAction(actionBottom);
                break;
            case Left:
                table.addAction(actionLeft);
                break;
            case Right:
                table.addAction(actionRight);
                break;
        }
    }

    public void setFillParent(boolean value) {
        table.setFillParent(value);
    }

    private Vector2 getVectorFrom() {
        Vector2 start = Vector2.Zero;
        switch (this.orientation) {
            case Left:
                start = new Vector2(-getWidth(), getY());
                break;
            case Right:
                start = new Vector2(0, getY());
                break;
            case Top:
                start = new Vector2(getX(), 0);
                break;
            case Bottom:
                start = new Vector2(getX(), -getHeight());
                break;
            default:
                break;
        }
        return start;
    }

    private void moveToHide(OrientationFrom orientation) {
        Vector2 start = getVectorFrom();
        table.setX(start.x);
        table.setY(start.y);
    }

    // to override
    protected abstract Table prepareTable();
}