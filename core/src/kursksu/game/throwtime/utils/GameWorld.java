package kursksu.game.throwtime.utils;

import static kursksu.game.throwtime.utils.Constants.PPM;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;

import kursksu.game.throwtime.actors.Ball;
import kursksu.game.throwtime.actors.Bandit;
import kursksu.game.throwtime.actors.Basket;
import kursksu.game.throwtime.actors.Borders;
import kursksu.game.throwtime.actors.Chalkin;
import kursksu.game.throwtime.actors.Chubik;
import kursksu.game.throwtime.actors.b2Object;

public class GameWorld implements Disposable {
    private World world;
    private ArrayList<b2Object> objects;

    public GameWorld() {
        world = new World(
                new Vector2(0, -9.81f), false
        );
        objects = new ArrayList<>();
        objects.add(new Bandit((Constants.WIDTH - 20) / PPM, 50 / Constants.PPM));
        objects.add(new Borders(Constants.WIDTH / 2 / PPM, -10 / PPM));
        objects.add(new Chalkin(20 / PPM, 50 / PPM));
        objects.add(new Ball(Constants.WIDTH / 2 / PPM, (float) ((Constants.HEIGHT * 1.2) / PPM)));
    }

    public void init() {
        for(b2Object obj : objects) {
            obj.setBody(world.createBody(obj.getBodyDef()));
            obj.getBody().createFixture(obj.getFixture());
        }
    }

    public void addChubikAndMove(float x, float y) {
        Chubik chubik = new Chubik(x / PPM, y / PPM);
        objects.add(chubik);
        chubik.setBody(world.createBody(chubik.getBodyDef()));
        chubik.getBody().createFixture(chubik.getFixture());
    }

    public void render(float delta) {
        world.step(1/60f, 6, 2);
    }

    public World getWorld() {
        return this.world;
    }

    public ArrayList<b2Object> getObjects() {
        return this.objects;
    }

    @Override
    public void dispose() {
        world.dispose();
    }
}