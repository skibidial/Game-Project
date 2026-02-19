package UI;


import character.character;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import character.chief;
import character.Enemy;
public class CardSkill extends Pane {
    private final String imagePath = "/cardTest.png";
    private ImageView imageView;
    private character player;

    public CardSkill(chief ch, Enemy en) {

        Image image = new Image(getClass().getResourceAsStream(imagePath));
        imageView = new ImageView(image);

        imageView.setFitWidth(240);
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(true);

        getChildren().add(imageView);

        setOnMouseClicked(e -> {
            ch.Attack(en);
        });
    }
    public void setPosition(int x, int y) {
        imageView.setX(x);
        imageView.setY(y);
    }
}
