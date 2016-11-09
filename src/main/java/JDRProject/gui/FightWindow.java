package JDRProject.gui;

import JDRProject.army.Fightable;
import JDRProject.army.FightableFactory;
import JDRProject.fight.FightHandler;
import JDRProject.gui.panel.initBattle.AttackerPanel;
import JDRProject.gui.panel.initBattle.DefenderPanel;
import JDRProject.gui.panel.resultBattle.ResultAttack;
import JDRProject.gui.panel.resultBattle.ResultDefense;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Maxime on 05-11-16.
 */
public class FightWindow extends JFrame implements ActionListener{

    private ResultDefense resultDefense;
    private ResultAttack resultAttack;
    private AttackerPanel attackerPanel;
    private DefenderPanel defenderPanel;
    private boolean isReady = false;

    public FightWindow(){
        super();

        setTitle("War and Salt !");
        setSize(600, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);

        JPanel masterPanel = new JPanel(new BorderLayout());
        JPanel battlePanel = new JPanel(new BorderLayout());
        JPanel resultPanel = new JPanel(new BorderLayout());

        JButton fightButton = new JButton("FIGHT !");
        fightButton.setPreferredSize(new Dimension(getWidth(), getHeight()/5));
        fightButton.setBackground(Color.RED);
        fightButton.addActionListener(this);


        attackerPanel = new AttackerPanel();
        battlePanel.add(attackerPanel, BorderLayout.WEST);

        defenderPanel = new DefenderPanel();
        battlePanel.add(defenderPanel, BorderLayout.EAST);

        resultAttack = new ResultAttack();
        resultPanel.add(resultAttack, BorderLayout.WEST);

        resultDefense = new ResultDefense();
        resultPanel.add(resultDefense, BorderLayout.EAST);

        isReady = true;

        masterPanel.add(resultPanel, BorderLayout.SOUTH);
        masterPanel.add(battlePanel, BorderLayout.NORTH);
        masterPanel.add(fightButton, BorderLayout.CENTER);

        attackerPanel.setPreferredSize(new Dimension(getWidth() / 2 - 10, getHeight() * 2 / 5));
        defenderPanel.setPreferredSize(new Dimension(getWidth() / 2 - 10, getHeight() * 2 / 5));
        resultAttack.setPreferredSize(new Dimension(getWidth() / 2 - 10, getHeight() * 2 / 5));
        resultDefense.setPreferredSize(new Dimension(getWidth() / 2 - 10, getHeight() * 2 / 5));

        add(masterPanel);

        revalidate();
    }

    public void validate(){
        super.validate();
        if(isReady) {
            attackerPanel.setPreferredSize(new Dimension(getWidth() / 2 - 10, getHeight() * 2 / 5));
            defenderPanel.setPreferredSize(new Dimension(getWidth() / 2 - 10, getHeight() * 2 / 5));
            resultAttack.setPreferredSize(new Dimension(getWidth() / 2 - 10, getHeight() * 2 / 5));
            resultDefense.setPreferredSize(new Dimension(getWidth() / 2 - 10, getHeight() * 2 / 5));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fight();
    }

    public void fight(){
        Fightable attacker = FightableFactory.createFightable( attackerPanel.getSelectedFileType()
                , attackerPanel.getXMLFilePath());
        Fightable defender = FightableFactory.createFightable(defenderPanel.getSelectedFileType()
                , defenderPanel.getXMLFilePath());

        attacker.setAttackBonus(attackerPanel.getWordus());
        defender.setDefenseBonus(defenderPanel.getWordus());

        FightHandler fightHandler = new FightHandler(attacker, defender);

        resultAttack.setDamageDealed(fightHandler.getDamagesDealed());
        resultDefense.setDeadNumber(fightHandler.getDeadNumber());
    }
}
