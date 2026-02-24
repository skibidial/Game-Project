package UI;

import character.Character;
import character.Chief;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ChiefCardGuardUI extends Pane {
    private final ImageView imageView;
    private Character player;

    public ChiefCardGuardUI(Chief chief) {

        String imagePath = "/moon.jpg";
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        imageView = new ImageView(image);

        imageView.setFitWidth(140);
        imageView.setFitHeight(300);
        imageView.setPreserveRatio(true);

        getChildren().add(imageView);

        setOnMouseClicked(e -> {
            chief.Guard();
        });
    }
    public void setPosition(int x, int y) {
        imageView.setX(x);
        imageView.setY(y);
    }
}
