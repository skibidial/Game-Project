package CardGame;

import character.Chief;

public class ChiefCardDf extends Card implements Guardalbe{
    private final Chief chief;
    public ChiefCardDf(int strength, int defence, Chief character){
        super(strength, defence);
        this.chief = character;
    }

    @Override
    public void guard() {
        this.chief.setDefence(this.chief.getDefence()+this.getDefence());
    }
}
