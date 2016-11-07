package JDRProject.xmlParser;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Maxime on 31-10-16.
 */
public abstract class Parser {

    private String xmlPath;
    protected Document rawData;

    public Parser(String path) {
        xmlPath = path;
        SAXReader reader = new SAXReader();
        try {
            rawData = reader.read(path);
        } catch (DocumentException e) {
            System.err.println("XMLReader: error reading " + path);
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public int getAttack(){
        Element root = rawData.getRootElement().element("Battle");
        return Integer.parseInt( root.attributeValue("attack"));
    }

    public int getParry(){
        Element root = rawData.getRootElement().element("Battle");
        return Integer.parseInt( root.attributeValue("parry"));
    }

    public int getPV(){
        Element root = rawData.getRootElement().element("Battle");
        return Integer.parseInt( root.attributeValue("pv"));
    }

    public int getArmor(){
        Element root = rawData.getRootElement().element("Battle");
        return Integer.parseInt( root.attributeValue("armor"));
    }

    public int[] getDamages(){
        Element root = rawData.getRootElement().element("Damage");
        int numberDice = Integer.parseInt( root.attributeValue("numberDice"));
        int diceType = Integer.parseInt( root.attributeValue("diceType"));
        int offset = Integer.parseInt( root.attributeValue("offset"));
        int[] damage = {numberDice, diceType, offset};
        return damage;
    }

    public float getNumber(){
        Element root = rawData.getRootElement().element("Caracteristic");
        return Float.parseFloat( root.attributeValue("number"));
    }

    public void setNumber(float number){
        Attribute n= rawData.getRootElement().element("Caracteristic").attribute("number");
        n.setValue(Float.toString(number));
    }

    public void flush(){
        XMLWriter writer = null;
        try {
            OutputFormat format = OutputFormat.createPrettyPrint();
            writer = new XMLWriter( new FileWriter( xmlPath ), format );
            writer.write( rawData );
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing to xml document: "+ rawData.getName());
            System.exit(-1);
        }
    }
}
