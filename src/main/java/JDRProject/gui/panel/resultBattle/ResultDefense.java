package JDRProject.gui.panel.resultBattle;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Maxime on 05-11-16.
 */
public class ResultDefense extends JPanel{

    private JLabel dead;

    public ResultDefense(){
        super(new BorderLayout());

        dead = new JLabel();

        add(dead, BorderLayout.NORTH);
    }

    public void setDeadNumber(float deadNumber) {
        dead.setText(" Pertes subies: "+deadNumber);
    }
}
