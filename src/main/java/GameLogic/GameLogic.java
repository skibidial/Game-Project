package GameLogic;

import CardGame.ChiefCardAtk;
import CardGame.ChiefCardDf;
import CardGame.ChiefCardUlt;
import UI.CharacterHpBar;
import UI.ChiefCardAtkUI;
import UI.ChiefCardGuardUI;
import UI.ChiefCardUltUI;
import character.Enemy;
import character.Chief;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameLogic {

//    private static Label lbChief;
//    private static Label lbEnemy;
    private static ChiefCardAtkUI chiefCardAtkUI;
    private static ChiefCardGuardUI chiefCardGuardUI;
    private static ChiefCardUltUI chiefCardUltUI;
    private static Chief chief;
    private static Enemy enemy;
    private static  int num;
    private static  CharacterHpBar characterHpBar1;
    private static  CharacterHpBar characterHpBar2;
    public static void init(Chief chief,Enemy enemy,
                            ChiefCardUltUI chiefCardUltUI,
                            ChiefCardAtkUI chiefCardAtkUI,
                            ChiefCardGuardUI chiefCardGuardUI,
                            CharacterHpBar HpBar1,
                            CharacterHpBar HpBar2) {
        GameLogic.chiefCardAtkUI =new  ChiefCardAtkUI(chief);
        GameLogic.chiefCardGuardUI =new  ChiefCardGuardUI(chief);
        GameLogic.chiefCardUltUI =new  ChiefCardUltUI(chief);

        GameLogic.characterHpBar1=HpBar1;
        GameLogic.characterHpBar2=HpBar2;

        GameLogic.chiefCardAtkUI = chiefCardAtkUI;
        GameLogic.chiefCardGuardUI = chiefCardGuardUI;
        GameLogic.chiefCardUltUI = chiefCardUltUI;

        GameLogic.chief = chief;
        GameLogic.enemy = enemy;
        GameLogic.num =0;

        GameLogic.chiefCardAtkUI.setOnMouseClicked(e->{
            GameLogic.chief.Attack();
            characterHpBar2.takeDamage(((ChiefCardAtk) chief.getAtkCard()).actualDamage());
            //lbEnemy.setText(GameLogic.enemy.getHp()+"/"+GameLogic.enemy.getMaxHp());
            GameLogic.num++;
            if(num%2 == 0){
                endTurns(0);
            }

        });
        GameLogic.chiefCardGuardUI.setOnMouseClicked(e->{
            //GameLogic.chief.setHp(GameLogic.chief.getHp() + 3);
            GameLogic.chief.Guard();
            //lbChief.setText(GameLogic.chief.getHp()+"/"+GameLogic.chief.getMaxHp());
            GameLogic.num++;
            if(num%2 == 0){
                endTurns(0);
            }
        });
        GameLogic.chiefCardUltUI.setOnMouseClicked(e->{
            GameLogic.chief.Ult();
            GameLogic.num++;
            if(num%2 == 0){
                endTurns(0);
            }
        });
    }

    public static void beginTurns(int p) {
        if(p==0) {
            chiefCardAtkUI.setDisable(false);
            chiefCardGuardUI.setDisable(false);
            chiefCardUltUI.setDisable(false);
        }
        else {
            chiefCardAtkUI.setDisable(true);
            chiefCardGuardUI.setDisable(true);
            chiefCardUltUI.setDisable(true);
            //GameLogic.enemy.Attack(GameLogic.chief);
//            if(chief.getHp()>0) {
//                chief.setHp(GameLogic.chief.getHp() - enemy.getStrength());
//            }

            //*
            Thread t = new Thread(()-> {
                try {
                    Thread.sleep(3000);
//                    GameLogic.enemy.Attack(GameLogic.chief);
                    if(chief.getHp()>0) {
                        chief.setHp(GameLogic.chief.getHp() - enemy.getStrength());
                        characterHpBar1.takeDamage(enemy.getStrength());
                    }
//                    Platform.runLater(()->{
//                        lbChief.setText(GameLogic.chief.getHp()+"/"+GameLogic.chief.getMaxHp());
//                    });

                    Thread.sleep(4000);
                    endTurns(1);

                }
                catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            });
            t.start();
            //*/

			/*
			lbChief.setText(GameLogic.chief.getHp()+"/"+GameLogic.chief.getMaxHp());
			endTurns(1);
			//*/
        }
    }

    public static void endTurns(int p) {
        if(p==0) {
            beginTurns(1);
            chief.setDefence(50);
            System.out.println(chief.getHp());
        }
        else {
            beginTurns(0);
        }
    }

//    public static Button getButtonRecovery() {
//        return buttonHeal;
//    }
//
//    public static void setButtonRecovery(Button buttonHeal) {
//        GameLogic.buttonHeal = buttonHeal;
//    }
//
//
//
//    public static Button getButtonAtk() {
//        return buttonAtk;
//    }
//
//
//    public static void setButtonAtk(Button buttonAtk) {
//        GameLogic.buttonAtk = buttonAtk;
//    }
//
//
//    public static Label getLbEnemy() {
//        return lbEnemy;
//    }
//
//
//    public static void setLbEnemy(Label lbEnemy) {
//        GameLogic.lbEnemy = lbEnemy;
//    }
//
//
//    public static Label getLbChief() {
//        return lbChief;
//    }
//
//    public static void setLbChief(Label lbChief) {
//        GameLogic.lbChief = lbChief;
//    }
}
