package JDRProject.fight;

import JDRProject.army.Fightable;
import JDRProject.xmlParser.Parser;

/**
 * Created by Maxime on 29-10-16.
 */
public class FightHandler {

    private Fightable attacker;
    private Fightable defender;
    private int damageDealed;
    private float deadNumber;

    public FightHandler(Fightable attacker, Fightable defender){
        this.attacker = attacker;
        this.defender = defender;
        damageDealed = attacker.attack(defender);
        deadNumber =  damageDealed/((float)defender.getPv());
    }

    public int getDamagesDealed(){
        return damageDealed;
    }

    public float getDeadNumber(){
        return deadNumber;
    }

    public String toString(){
        return "Bataille: \n "
                +attacker +" contre " + defender + "\n"+
                getDamagesDealed() + "\t\t" + getDeadNumber();
    }

    public void saveInXML(){
        Parser parser = defender.getParser();
        parser.setNumber(defender.getNumber() - deadNumber);

        parser.flush();

    }


}
