package CardGame;

public class ChiefCardAtk extends Card implements Attackable{
    private int damageCard;

    ChiefCardAtk(int strength, int defence, Character character){
        super(strength, defence, character);

    }
    public void setDamageCard(int damageCard){
        this.damageCard = damageCard;
    }
    public int getDamageCard(){
        return damageCard;
    }
    @Override
    public void attack(){
    }
}
