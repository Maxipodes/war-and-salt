package JDRProject.army;

import JDRProject.fight.Damage;
import JDRProject.xmlParser.Parser;

import java.util.Random;

/**
 * Created by Maxime on 29-10-16.
 */
public abstract class Fightable {

    protected static final int MAXIMUM_STAT_VALUE = 20;

    protected int pv;
    protected int armor;
    protected int parry;
    protected int attack;
    protected Damage damage;


    public Fightable(Parser parser){
        pv = parser.getPV();
        armor = parser.getArmor();
        parry = parser.getParry();
        attack = parser.getAttack();

        int[] tabDamage = parser.getDamages();
        damage = new Damage(tabDamage[0], tabDamage[1], tabDamage[2]);

    }

    public boolean isParrySucced(){
        Random rand = new Random();
        return rand.nextInt(MAXIMUM_STAT_VALUE-1)+1 <= parry;
    }

    public boolean isAttackSucced(){
        Random rand = new Random();
        return rand.nextInt(MAXIMUM_STAT_VALUE-1)+1 <= attack;
    }

    public int attack(Fightable defender){
        //On pourra gérer ici des augmentations de moral si on réussit une attaque
        if(isAttackSucced() && !defender.defend())
            return Math.max(damage.rollDices() - defender.getArmor(), 0);
        else
            return 0;
    }

    public boolean defend(){
        //On pourra gérer ici des augmentations de moral si on réussit une parade
        return isParrySucced();
    }

    public int getArmor() {
        return armor;
    }

    public abstract float getNumber();

    public int getPv() {
        return pv;
    }
}
