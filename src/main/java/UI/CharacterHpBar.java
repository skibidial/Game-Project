package UI;

import character.Chief;
import character.Character;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CharacterHpBar extends Pane {
    private Character character;
    private double currentHP;
    private double maxHP;
    private Rectangle hpBar;
    private double barWidth = 200;

    public CharacterHpBar(Character character) {
        this.character = character;
        maxHP = character.getMaxHp();
        currentHP = character.getHp();
        Rectangle background = new Rectangle(200, 20);
        background.setFill(Color.DARKGRAY);

        hpBar = new Rectangle(200, 20);
        hpBar.setFill(Color.LIMEGREEN);

        getChildren().addAll(background, hpBar);
    }
    public void takeDamage(double damage) {
        currentHP -= damage;
        if (currentHP < 0) currentHP = 0;
        updateBar();
    }
    private void updateBar() {
        double percentage = currentHP / maxHP;
        hpBar.setWidth(barWidth * percentage);
    }
    public void setPosition(double x, double y) {
        this.setLayoutX(x);
        this.setLayoutY(y);
    }
}
