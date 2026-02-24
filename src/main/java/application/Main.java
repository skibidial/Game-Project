package application;

import CardGame.ChiefCardAtk;
import CardGame.ChiefCardDf;
import CardGame.ChiefCardUlt;
import GameLogic.GameLogic;
import UI.*;
import character.Enemy;
import character.Chief;
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



        //character init
        Enemy enemy = new Enemy(10000,1,100000,1,10,1);
        Chief chief = new Chief(1000,1,1000000,1,3,1);

        ChiefCardAtk cca = new ChiefCardAtk(10,0,chief);
        ChiefCardDf ccd = new ChiefCardDf(0,10,chief);
        ChiefCardUlt ccu = new ChiefCardUlt(100,0,chief);
        chief.setAll(cca, ccd, ccu);
        chief.setTarget(enemy);
        //UI init
        ChiefCardAtkUI ccaUI = new ChiefCardAtkUI(chief);
        ChiefCardUltUI ccuUI = new ChiefCardUltUI(chief);
        ChiefCardGuardUI ccgUI = new ChiefCardGuardUI(chief);


        //CardSkill cardSkill = new CardSkill(chief,enemy);
        CharacterModel c = new CharacterModel(chief);
        CharacterHpBar hpBar1 = new CharacterHpBar(chief);
        hpBar1.setPosition(840,200);

        //MergeCard m = new MergeCard();

        EnemyModel e = new EnemyModel(enemy);
        CharacterHpBar hpBar2 = new CharacterHpBar(enemy);
        hpBar2.setPosition(100,200);

        //turn logic

        GameLogic.init(chief,enemy,ccuUI,ccaUI,ccgUI,hpBar1,hpBar2);
        Pane GameLayer = new Pane();
        //cardSkill.setPosition(1000,480);
        ccaUI.setPosition(1000,480);
        ccuUI.setPosition(900,480);
        ccgUI.setPosition(800,480);
        //GameLayer.getChildren().add(cardSkill);
        GameLayer.getChildren().add(c);
        GameLayer.getChildren().add(e);

        GameLayer.getChildren().add(ccaUI);
        GameLayer.getChildren().add(ccuUI);
        GameLayer.getChildren().add(ccgUI);
        GameLayer.getChildren().add(hpBar1);
        GameLayer.getChildren().add(hpBar2);
        //GameLayer.getChildren().add(m);
        root.getChildren().addAll(background,GameLayer);


        Scene scene = new Scene(root, 1280, 720);

        stage.setTitle("My Card Turn-Based Game");
        stage.setScene(scene);
        stage.show();
        GameLogic.beginTurns(0);

    }

    public static void main(String[] args) {
        launch();
    }
}
