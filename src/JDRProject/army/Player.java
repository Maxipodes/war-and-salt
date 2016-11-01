package JDRProject.army;

import JDRProject.xmlParser.PlayerParser;


/**
 * Created by Maxime on 29-10-16.
 */
public class Player extends Fightable {

    private String name;

    public Player(String xmlPath) {
        super(new PlayerParser(xmlPath));
        PlayerParser parser = new PlayerParser(xmlPath);

        name = parser.getName();
    }

    @Override
    public float getNumber() {
        return 1f;
    }

    public String toString(){
        return name;
    }
}
