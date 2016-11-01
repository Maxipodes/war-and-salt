import JDRProject.army.Player;
import JDRProject.army.Unit;
import JDRProject.fight.FightHandler;

public class Main {

    public static void main(String[] args){
        Unit testUnit = new Unit("res/units/fantassin.xml");
        Player testPlayer = new Player("res/players/stronheim.xml");

        FightHandler fight = new FightHandler(testUnit, testUnit);
        System.out.println(fight);
    }
}
