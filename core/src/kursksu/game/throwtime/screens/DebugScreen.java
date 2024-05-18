package kursksu.game.throwtime.screens;

import static com.badlogic.gdx.utils.compression.CRC.Table;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import kursksu.game.throwtime.Styles;
import kursksu.game.throwtime.ThrowTime;

public class DebugScreen implements Screen {

    private ThrowTime parent;
    private Stage stage;

    public DebugScreen(ThrowTime parent) {
        this.parent = parent;
        stage = new Stage(new ScreenViewport());
    }

    /**
     *
     */
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Styles styles = new Styles();

        Table root = new Table();
        root.setDebug(true);
        root.setFillParent(true);

        Label label = new Label("Test", styles.getLabel());
//        Button button = new Button(styles.getButton());
//        TextButton textButton = new TextButton("Test", styles.getTextButton());
//        ImageButton imageButton = new ImageButton(styles.getImageButton());
//        CheckBox checkBox = new CheckBox("Test", styles.getCheckBox());
//        TextField textField = new TextField("Test", styles.getTextField());
//        Window window = new Window("Test", styles.getWindow());
//        List<Label> list = new List<>(styles.getList());

        root.add(label);
        root.row();
//        root.add(button);
//        root.row();
//        root.add(textButton);
//        root.row();
//        root.add(imageButton);
//        root.row();
//        root.add(checkBox);
//        root.row();
//        root.add(textField);
//        root.row();

        stage.addActor(root);
    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(delta);
        stage.draw();
    }

    /**
     * @param width
     * @param height
     *
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     *
     */
    @Override
    public void pause() {

    }

    /**
     *
     */
    @Override
    public void resume() {

    }

    /**
     *
     */
    @Override
    public void hide() {

    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {

    }
}