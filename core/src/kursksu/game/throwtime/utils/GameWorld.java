package kursksu.game.throwtime.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

import kursksu.game.throwtime.actors.Ball;
import kursksu.game.throwtime.actors.Bandit;
import kursksu.game.throwtime.actors.Basket;
import kursksu.game.throwtime.actors.Borders;
import kursksu.game.throwtime.actors.Chalkin;
import kursksu.game.throwtime.actors.b2Object;

public class GameWorld {
    private World world;
    private ArrayList<b2Object> objects;

    public GameWorld() {
        world = new World(
                new Vector2(0, -9.81f), false
        );
        objects = new ArrayList<>(10);

        // fill objects list
        objects.add(new Chalkin());
        objects.add(new Bandit());
        objects.add(new Borders());
        objects.add(new Ball());
        objects.add(new Basket());
    }

    public void init() {
        for(b2Object obj : objects) {
            world.createBody(obj.getBody()).createFixture(obj.getFixture());
        }
    }

    public void render(float delta) {
        world.step(delta, 6, 2);
    }
}