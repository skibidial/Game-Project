package UI;

import character.Character;
import character.Chief;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ChiefCardUltUI extends Pane {
    private final ImageView imageView;
    private Character player;
    public ChiefCardUltUI(Chief chief) {

        String imagePath = "/star.jpg";
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        imageView = new ImageView(image);

        imageView.setFitWidth(140);
        imageView.setFitHeight(300);
        imageView.setPreserveRatio(true);

        getChildren().add(imageView);

        setOnMouseClicked(e -> {
            chief.Ult();
        });
    }
    public void setPosition(int x, int y) {
        imageView.setX(x);
        imageView.setY(y);
    }
}
