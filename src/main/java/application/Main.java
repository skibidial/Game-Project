package application;

import UI.CardSkill;
import UI.CharacterModel;
import UI.EnemyModel;
import UI.MergeCard;
import character.Enemy;
import character.chief;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) {

        StackPane root = new StackPane();

        // โหลดรูปภาพ (เอารูปไปไว้ใน resources หรือโฟลเดอร์เดียวกับไฟล์)
        Image bgImage = new Image(getClass().getResource("/background.png").toExternalForm());

        ImageView background = new ImageView(bgImage);
        background.setFitWidth(1280);
        background.setFitHeight(720);

        Enemy enemy = new Enemy(1,1,1,1,1,1);
        chief chief = new chief(1,1,1,1,3,1);
        CardSkill cardSkill = new CardSkill(chief,enemy);
        CharacterModel c = new CharacterModel(chief);
        MergeCard m = new MergeCard();
        Pane GameLayer = new Pane();

        EnemyModel e = new EnemyModel(enemy);

        cardSkill.setPosition(1000,480);

        GameLayer.getChildren().add(cardSkill);
        GameLayer.getChildren().add(c);
        GameLayer.getChildren().add(e);
        GameLayer.getChildren().add(m);
        root.getChildren().addAll(background,GameLayer);


        Scene scene = new Scene(root, 1280, 720);

        stage.setTitle("My Card Turn-Based Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
