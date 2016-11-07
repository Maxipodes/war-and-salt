package JDRProject.army;

/**
 * Created by Maxime on 07-11-16.
 */
public class FightableFactory {

    public static Fightable createFightable(String type, String xmlPath){
        if(type.equals(Unit.fightableType))
            return new Unit(xmlPath);
        else if(type.equals(Player.fightableType))
            return new Player(xmlPath);
        else
            return null;
    }
}
