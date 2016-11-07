package JDRProject.army;

import JDRProject.xmlParser.Parser;
import JDRProject.xmlParser.PlayerParser;


/**
 * Created by Maxime on 29-10-16.
 */
public class Player extends Fightable {

    public final static String fightableType = "joueur";

    private PlayerParser parser;
    private String name;

    public Player(String xmlPath) {
        super(new PlayerParser(xmlPath));

        this.parser = new PlayerParser(xmlPath);

        name = parser.getName();
    }

    public String toString(){
        return name;
    }

    @Override
    public Parser getParser() {
        return parser;
    }
}
