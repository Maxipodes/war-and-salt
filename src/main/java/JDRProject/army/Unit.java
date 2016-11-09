package JDRProject.army;

import JDRProject.army.environments.Environment;
import JDRProject.xmlParser.UnitParser;

/**
 * Created by Maxime on 29-10-16.
 */
public class Unit extends Fightable {

    public static final String fightableType = "unitee";

    private UnitParser parser;
    private String type;
    private int value ;
    private float number;
    private Environment preferredEnvironment;
    private Environment hatedEnvironnement;
    private float moral;
    private float stamina;
    private int supplying;

    public Unit(String xmlPath) {
        super(new UnitParser(xmlPath));

        parser = new UnitParser(xmlPath);

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
        for(int i=0; i<Math.ceil(number); i++){
             totalDamages += super.attack(defender);
        }
        return totalDamages;
    }

    public String toString(){
        return number+" "+type+" de valeur "+value;
    }

    @Override
    public UnitParser getParser() {
        return parser;
    }
}
