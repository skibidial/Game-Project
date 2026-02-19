package character;

import javax.swing.text.html.ImageView;

public class chief extends character{

    public chief( int hp, int mp, int maxHp, int maxMP, int strength, int defence) {
        super(hp,mp,maxHp,maxMP,strength,defence);
    }
    public void Attack(Enemy target) {
        System.out.println("attack");
        int actualDamage = this.getStrength() - target.getDefence();
        target.setHp(target.getHp()-actualDamage);
        System.out.println(actualDamage);
        if(target.getHp()<=0){
            System.out.println("Enemy is dead");
        }
    };
}
