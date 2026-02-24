package character;

import CardGame.Card;
import CardGame.ChiefCardAtk;
import CardGame.ChiefCardDf;
import CardGame.ChiefCardUlt;

public class Chief extends Character {
    private ChiefCardAtk AtkCard;
    private ChiefCardDf DfCard;
    private ChiefCardUlt Ult;
    private Enemy Target;
    public Chief(int hp, int mp, int maxHp, int maxMP, int strength, int defence) {
        super(hp,mp,maxHp,maxMP,strength,defence);
    }
    public void Attack() {
        this.AtkCard.attack(this.Target);
    };

    public void Guard(){
        this.DfCard.guard();
    }

    public void Ult(){
        this.Ult.Ult();
    }

    public void setTarget(Enemy enemy) {
        this.Target = enemy;
    }

    public void setAll(Card AtkCard, Card DfCard, Card Ult){
        this.AtkCard = (ChiefCardAtk) AtkCard;
        this.DfCard = (ChiefCardDf) DfCard;
        this.Ult = (ChiefCardUlt) Ult;
    }

    public Card getAtkCard() {
        return AtkCard;
    }

    public Card getDfCard() {
        return DfCard;
    }

    public Card getUlt() {
        return Ult;
    }
}
