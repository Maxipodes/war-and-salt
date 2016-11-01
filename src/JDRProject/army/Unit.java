package JDRProject.army;

import JDRProject.army.environments.Environment;
import JDRProject.xmlParser.UnitParser;

/**
 * Created by Maxime on 29-10-16.
 */
public class Unit extends Fightable {

    private String type;
    private int value ;
    private int number;
    private Environment preferredEnvironment;
    private Environment hatedEnvironnement;
    private float moral;
    private float stamina;
    private int supplying;

    public Unit(String xmlPath) {
        super( new UnitParser(xmlPath));

        UnitParser parser = new UnitParser(xmlPath);

        type = parser.getType();
        value = parser.getValue();
        number = parser.getNumber();

        moral = parser.getMoral();
        stamina = parser.getStamina();
        supplying = parser.getSupplying();

    }

    @Override
    public int attack(Fightable defender) {
        int totalDamages = 0;
        for(int i=0; i<number; i++){
             totalDamages += super.attack(defender);
        }
        return totalDamages;
    }

    @Override
    public float getNumber() {
        return number;
    }

    public String toString(){
        return number+" "+type+" de valeur "+value;
    }



}
