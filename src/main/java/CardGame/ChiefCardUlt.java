package CardGame;

import character.Chief;

public class ChiefCardUlt extends Card implements Ultable {
    private final Chief chief;
    public ChiefCardUlt(int strength, int defence, Chief chief) {
        super(strength, defence);
        this.chief = chief;
    }
    @Override
    public void Ult() {
        chief.setStrength(chief.getStrength()+this.getStrength());
    }

}
