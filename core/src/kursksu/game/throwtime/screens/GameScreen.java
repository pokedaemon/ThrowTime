package kursksu.game.throwtime.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.scenes.scene2d.Stage;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.actors.b2Object;
import kursksu.game.throwtime.ui.AnimatedTable;
import kursksu.game.throwtime.ui.GameUIPanel;
import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.GameWorld;
import kursksu.game.throwtime.utils.Manager;

import static kursksu.game.throwtime.utils.Constants.PPM;

import java.util.ArrayList;

public class GameScreen extends State {
    private GameWorld world;
    private Box2DDebugRenderer renderer;
    private RandomXS128 randomGenerator;
    private Stage stage;
    private GameUIPanel uiPanel;
    private ShapeRenderer shape;
    private GestureDetector detector;

    private float delta;
    private float linearImpulseStrength;

    private ArrayList<Vector2> points;

    public GameScreen(ThrowTime parent, SpriteBatch batch) {
        super(parent, batch);
    }

    @Override
    public void update(float delta) {
        world.render(delta);
        cameraUpdate(delta);
    }

    @Override
    public void create() {
        delta = 0f;
        linearImpulseStrength = 2.4f;

        world = new GameWorld();
        world.init();

        stage = new Stage(this.getViewport());
        shape = new ShapeRenderer();
        shape.setAutoShapeType(true);

        Manager.getMusic(Constants.playMusic).play();
        Manager.getMusic(Constants.playMusic).setLooping(true);

        batch.setProjectionMatrix(getViewport().getCamera().combined);
        shape.setProjectionMatrix(getViewport().getCamera().combined.scl(PPM));
        shape.updateMatrices();
        shape.flush();

        inputCreate();

        renderer = new Box2DDebugRenderer();
        background = new Sprite(Manager.getTexture(Constants.background));

        uiPanel = new GameUIPanel(parent);
        uiPanel.setX(Constants.WIDTH / 2);
        uiPanel.setY(Constants.HEIGHT / 1.15f);
        uiPanel.setOrientation(AnimatedTable.OrientationFrom.Top);
        uiPanel.setMaxTime(.0f);
        uiPanel.hide();

        uiPanel.setMaxTime(0.6f);
        uiPanel.show();

        stage.addActor(uiPanel);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        world.dispose();
        renderer.dispose();
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        this.delta += delta;

        if(this.delta >= 1f) {
            uiPanel.takeTime();
            this.delta = 0f;
        }

        batch.begin();

        for(b2Object p : world.getObjects()) {
            if(p.isChain()) continue;
            p.getSprite().setPosition(
                    p.getBody().getPosition().x * PPM - p.getSprite().getWidth() / 2,
                    p.getBody().getPosition().y * PPM - p.getSprite().getHeight() / 2
            );
        }

        background.draw(batch);

        for(b2Object p : world.getObjects()) {
            if(p.isChain()) continue;
            p.getSprite().draw(batch);
        }

        batch.end();

        stage.act();
        stage.draw();
        // renderer.render(world.getWorld(), camera.combined.scl(PPM));

        if(detector.isPanning()) {
            shape.begin();
            for(Vector2 v : points) {
                shape.set(ShapeRenderer.ShapeType.Point);
                shape.circle(v.x, v.y, 16f / PPM);
            }
            shape.end();
        }

        if(uiPanel.getTime() == -1) {
            parent.changeScreen(ThrowTime.OVER);
        }
    }

    public void cameraUpdate(float delta) {
        camera.update();
    }

    public void inputCreate() {
        detector = new GestureDetector(
                new GestureDetector.GestureListener() {
                    @Override
                    public boolean touchDown(float x, float y, int pointer, int button) {
                        Gdx.app.log("GameScreen", "touchDown detected!");
                        return false;
                    }

                    @Override
                    public boolean tap(float x, float y, int count, int button) {
                        Gdx.app.log("GameScreen", "tap detected!");
                        return false;
                    }

                    @Override
                    public boolean longPress(float x, float y) {
                        Gdx.app.log("GameScreen", "longPress detected!");
                        return false;
                    }

                    @Override
                    public boolean fling(float velocityX, float velocityY, int button) {
                        Gdx.app.log("GameScreen", "fling detected!");
                        return false;
                    }

                    @Override
                    public boolean pan(float x, float y, float deltaX, float deltaY) {
                        Gdx.app.log("GameScreen", "pan detected!");
                        b2Object ball = world.getObjects().get(world.getObjects().size() - 1);
                        float x_ball = ball.getBody().getPosition().x,
                                y_ball = ball.getBody().getPosition().y;
                        Vector2 start = new Vector2(x_ball, y_ball);
                        Vector2 initVelocity = new Vector2(
                                x + deltaX, y + deltaY
                        );

                        points = trajectory(initVelocity, start, 1, 1f/60f);

                        return true;
                    }

                    @Override
                    public boolean panStop(float x, float y, int pointer, int button) {
                        Gdx.app.log("GameScreen", "panStop detected!");
                        return false;
                    }

                    @Override
                    public boolean zoom(float initialDistance, float distance) {
                        Gdx.app.log("GameScreen", "zoom detected!");
                        return false;
                    }

                    @Override
                    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
                        Gdx.app.log("GameScreen", "pinch detected!");
                        return false;
                    }

                    @Override
                    public void pinchStop() {
                        Gdx.app.log("GameScreen", "pinchStop detected!");
                    }
                }
        );
        Gdx.input.setInputProcessor(detector);
    }

    private ArrayList<Vector2> trajectory(Vector2 initVelocity, Vector2 startPos, int steps, float delta) {
        ArrayList<Vector2> points = new ArrayList<>(steps);

        for(int i = 0; i <= steps; ++i) {
            float t = i * delta;

            Vector2 stepVel = initVelocity.scl(t);
            Vector2 stepGrav = new Vector2(.0f, .5f * -9.81f * t * t);

            float x = startPos.x + stepVel.x;
            float y = startPos.y + stepVel.y + stepGrav.y;

            Vector2 pos = new Vector2(x, y);
            points.add(pos);
        }

        return points;
    }
}
