package CardGame;

public abstract class Card {
    private int strength;
    private int defence;


    public Card(int strength, int defence) {
        setStrength(strength);
        setDefence(defence);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}
