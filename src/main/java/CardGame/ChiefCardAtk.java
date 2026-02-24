package CardGame;

import character.Character;
import character.Chief;

public class ChiefCardAtk extends Card implements Attackable{
    private int damageCard;
    private int actualDamage;
    private final Chief chief;
    public ChiefCardAtk(int strength, int defence, Chief character){
        super(strength, defence);
        this.chief = character;
    }
    public void setDamageCard(int strength){
        damageCard = (int)(strength+0.5*chief.getStrength());
    }
    public int getDamageCard(){
        return damageCard;
    }
    @Override
    public void attack(Character Target){
        this.chief.setMp(this.chief.getMp()+1);
        actualDamage = this.getStrength() - Target.getDefence();
        Target.setHp(Target.getHp()-actualDamage);
        System.out.println("cheif deal damage = "+actualDamage);
        if(Target.getHp()<=0){
            System.out.println("Enemy is dead");

        }
    }
    public int actualDamage(){
        return actualDamage;
    }
}
