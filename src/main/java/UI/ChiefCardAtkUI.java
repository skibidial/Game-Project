package UI;

import character.Character;
import character.Chief;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ChiefCardAtkUI extends Pane {
    private final String imagePath = "/sun.jpg";
    private ImageView imageView;
    private Character player;

    public ChiefCardAtkUI(Character chief) {

        Image image = new Image(getClass().getResourceAsStream(imagePath));
        imageView = new ImageView(image);

        imageView.setFitWidth(140);
        imageView.setFitHeight(300);
        imageView.setPreserveRatio(true);

        getChildren().add(imageView);
        Chief ch = (Chief)chief;
        setOnMouseClicked(e -> {
            ch.Attack();
        });
    }
    public void setPosition(int x, int y) {
        imageView.setX(x);
        imageView.setY(y);
    }
}
