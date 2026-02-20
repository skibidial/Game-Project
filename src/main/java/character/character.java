package character;

public abstract class character {
    private int hp;
    private int mp;
    private int maxHp;
    private int maxMP;
    private int strength;
    private int defence;
    private boolean isGuard = false;

    public character(int hp, int mp, int maxHp, int maxMP, int strength, int defence) {
        setHp(hp);
        setMp(mp);
        setMaxHp(maxHp);
        setMaxMP(maxMP);
        setStrength(strength);
        setDefence(defence);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
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

    public boolean isGuard() {
        return isGuard;
    }

    public void setGuard(boolean guard) {
        isGuard = guard;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }


}
