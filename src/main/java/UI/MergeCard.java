package UI;

import character.Enemy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class MergeCard extends Pane {
    private ImageView image;
    private final String ImagePath = "/merge.png";
    ImageView charImageView;
    public MergeCard() {

        Image charImage = new Image(getClass().getResource(ImagePath).toExternalForm());
        charImageView = new ImageView(charImage);
        charImageView.setFitHeight(500);
        charImageView.setFitWidth(240);
        getChildren().add(charImageView);
        setPosition(100,400);
    }
    public void setPosition(double x, double y) {
        charImageView.setX(x);
        charImageView.setY(y);
    }
}
