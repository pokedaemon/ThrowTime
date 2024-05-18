package kursksu.game.throwtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class Styles {
    private FreeTypeFontGenerator generator;
    private Label.LabelStyle label;
    private Button.ButtonStyle button;
    private TextButton.TextButtonStyle textButton;
    private ImageButton.ImageButtonStyle imageButton;
    private CheckBox.CheckBoxStyle checkBox;
    private TextField.TextFieldStyle textField;
    private List.ListStyle list;
    private Window.WindowStyle window;

    public Styles() {
        generator = new FreeTypeFontGenerator(Gdx.files.internal("yoster.ttf"));
        BitmapFont font = setFont(75, Color.WHITE);
        label = new Label.LabelStyle();
        label.font = font;
        button = new Button.ButtonStyle();
        textButton = new TextButton.TextButtonStyle();
        imageButton = new ImageButton.ImageButtonStyle();
        checkBox = new CheckBox.CheckBoxStyle();
        textField = new TextField.TextFieldStyle();
        list = new List.ListStyle();
        window = new Window.WindowStyle();
    }

    private BitmapFont setFont(int size, Color color) {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.color = color;
        return generator.generateFont(parameter);
    }

    public Label.LabelStyle getLabel() {
        return this.label;
    }

    public Button.ButtonStyle getButton() {
        return this.button;
    }

    public TextButton.TextButtonStyle getTextButton() {
        return this.textButton;
    }

    public ImageButton.ImageButtonStyle getImageButton() {
        return this.imageButton;
    }

    public CheckBox.CheckBoxStyle getCheckBox() {
        return this.checkBox;
    }

    public TextField.TextFieldStyle getTextField() {
        return this.textField;
    }

    public List.ListStyle getList() {
        return this.list;
    }

    public Window.WindowStyle getWindow() {
        return this.window;
    }
}
