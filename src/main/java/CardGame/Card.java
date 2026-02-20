package CardGame;

public class Card {
    private int strength;
    private int defence;
    Character character;


    public Card(int strength, int defence, Character character) {
        setStrength(strength);
        setDefence(defence);
        this.character = character;
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
