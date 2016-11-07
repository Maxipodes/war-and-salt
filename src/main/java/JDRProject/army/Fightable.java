package JDRProject.army;

import JDRProject.fight.Damage;
import JDRProject.xmlParser.Parser;

import java.util.Random;

/**
 * Created by Maxime on 29-10-16.
 */
public abstract class Fightable {

    public static final int MAXIMUM_STAT_VALUE = 20;

    protected int pv;
    protected int armor;
    protected int parry;
    protected int attack;
    protected Damage damage;
    protected float number;

    protected int attackBonus;
    protected int defenseBonus;


    public Fightable(Parser parser){
        pv = parser.getPV();
        armor = parser.getArmor();
        parry = parser.getParry();
        attack = parser.getAttack();
        number = parser.getNumber();

        int[] tabDamage = parser.getDamages();
        damage = new Damage(tabDamage[0], tabDamage[1], tabDamage[2]);

        attackBonus = 0;
        defenseBonus = 0;
    }

    protected boolean isParrySucced(){
        Random rand = new Random();
        return rand.nextInt(MAXIMUM_STAT_VALUE-1)+1 <= (parry + defenseBonus );
    }

    protected boolean isAttackSucced(){
        Random rand = new Random();
        return rand.nextInt(MAXIMUM_STAT_VALUE-1)+1 <= (attack + attackBonus );
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

    public float getNumber(){
        return number;
    }

    public int getPv() {
        return pv;
    }


    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public void setDefenseBonus(int defenseBonus) {
        this.defenseBonus = defenseBonus;
    }


    public  abstract Parser getParser();
}
