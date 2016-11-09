package JDRProject.gui.panel.resultBattle;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Maxime on 05-11-16.
 */
public class ResultAttack extends JPanel {

    private JLabel damage;

    public ResultAttack(){
        super(new BorderLayout());

        damage = new JLabel();

        add(damage, BorderLayout.NORTH);
    }

    public void setDamageDealed(int damagesDealed) {
        damage.setText(" Degats causes: " + damagesDealed);
    }
}
