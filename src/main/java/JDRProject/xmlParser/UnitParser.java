package JDRProject.xmlParser;

import org.dom4j.Element;

/**
 * Created by Maxime on 30-10-16.
 */
public class UnitParser extends Parser{

    public UnitParser(String path) {
        super(path);
    }

    public int getValue(){
        Element root = rawData.getRootElement().element("Caracteristic");
        return Integer.parseInt( root.attributeValue("value"));
    }

    public String getType(){
        Element root = rawData.getRootElement().element("Caracteristic");
        return root.attributeValue("type");
    }


    public float getMoral(){
        Element root = rawData.getRootElement().element("Specifics");
        return Float.parseFloat( root.attributeValue("moral"));
    }

    public float getStamina(){
        Element root = rawData.getRootElement().element("Specifics");
        return Float.parseFloat( root.attributeValue("stamina"));
    }

    public int getSupplying(){
        Element root = rawData.getRootElement().element("Specifics");
        return Integer.parseInt( root.attributeValue("supplying"));
    }




}
