import JDRProject.army.Player;
import JDRProject.army.Unit;
import JDRProject.fight.FightHandler;
import JDRProject.gui.FightWindow;

public class Main {

    public static void main(String[] args){
        Unit testUnit = new Unit("res/units/fantassin.xml");
        Player testPlayer = new Player("res/players/stronheim.xml");

        testUnit.setAttackBonus(20);
        testPlayer.setDefenseBonus(-20);

        new FightWindow();

        FightHandler fight = new FightHandler(testPlayer, testUnit );
        fight.saveInXML();
        System.out.println(fight);
    }
}
