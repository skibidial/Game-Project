package UI;

import character.Chief;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class CharacterModel extends Pane {
    private ImageView image;
    private final String ImagePath = "/yoo.png";
    ImageView charImageView;
    public CharacterModel(Chief chief) {

        Image charImage = new Image(getClass().getResource(ImagePath).toExternalForm());
        charImageView = new ImageView(charImage);
        charImageView.setFitHeight(240);
        charImageView.setFitWidth(140);
        getChildren().add(charImageView);
        setPosition(840,280);
    }
    public void setPosition(double x, double y) {
        charImageView.setX(x);
        charImageView.setY(y);
    }
}
