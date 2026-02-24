package UI;

import character.Enemy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class EnemyModel extends Pane {
    private ImageView image;
    private final String ImagePath = "/e.png";
    ImageView charImageView;
    public EnemyModel(Enemy enemy) {

        Image charImage = new Image(getClass().getResource(ImagePath).toExternalForm());
        charImageView = new ImageView(charImage);
        charImageView.setFitHeight(240);
        charImageView.setFitWidth(140);
        getChildren().add(charImageView);
        setPosition(100,280);
    }
    public void setPosition(double x, double y) {
        charImageView.setX(x);
        charImageView.setY(y);
    }
}
