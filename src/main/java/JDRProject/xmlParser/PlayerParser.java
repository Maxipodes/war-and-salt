package JDRProject.xmlParser;

import org.dom4j.Element;

/**
 * Created by Maxime on 31-10-16.
 */
public class PlayerParser extends Parser {

    public PlayerParser(String path) {
        super(path);
    }

    public String getName(){
        Element root = rawData.getRootElement().element("Caracteristic");
        return root.attributeValue("name");
    }
}
