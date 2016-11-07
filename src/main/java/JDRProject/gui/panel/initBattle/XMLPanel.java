package JDRProject.gui.panel.initBattle;

import JDRProject.army.Player;
import JDRProject.army.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

/**
 * Created by Maxime on 05-11-16.
 */
public abstract class XMLPanel extends JPanel implements ItemListener{

    private JTextField wordusValue;
    File xmlFile;
    String selectedFileType;

    public XMLPanel(String header) {
        super(new BorderLayout());

        JLabel text = new JLabel(header);
        add(text, BorderLayout.NORTH);

        JPanel midPanel = new JPanel(new BorderLayout());

        JLabel fileName = new JLabel("???");
        fileName.setBackground(Color.DARK_GRAY);
        midPanel.add(fileName, BorderLayout.WEST);

        JButton chooseFile = new JButton("...");
        //chooseFile.setPreferredSize(new Dimension(30, 20));
        chooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xmlFile = getXMLFile();
                if(xmlFile != null)
                    fileName.setText(xmlFile.getName());
            }
        });

        midPanel.add(chooseFile, BorderLayout.EAST);

        JPanel fileType = new JPanel();
        ButtonGroup radioButtons = new ButtonGroup();
        JRadioButton unit = new JRadioButton(Unit.fightableType, true);
        selectedFileType = unit.getText();
        JRadioButton player = new JRadioButton(Player.fightableType);

        radioButtons.add(unit);
        radioButtons.add(player);
        unit.addItemListener(this);
        player.addItemListener(this);
        fileType.add(unit);
        fileType.add(player);

        midPanel.add(fileType, BorderLayout.SOUTH);


        add(midPanel, BorderLayout.CENTER);

        JLabel wordus = new JLabel("Bonus/Malus: ");
        wordusValue = new JTextField("0");
        wordusValue.setPreferredSize(new Dimension(40, 20));

        JPanel wordusPanel = new JPanel(new BorderLayout());
        wordusPanel. add(wordus, BorderLayout.WEST);
        wordusPanel.add(wordusValue, BorderLayout.EAST);

        add(wordusPanel, BorderLayout.SOUTH);


    }


    private File getXMLFile(){
        JFileChooser fileChooser = new JFileChooser("res/");
        int result = fileChooser.showOpenDialog(getParent());
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile;

        }
        return null;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        int sel = e.getStateChange();

        if (sel == ItemEvent.SELECTED) {

            JRadioButton button = (JRadioButton) e.getSource();
            selectedFileType = button.getText();

        }
    }

    public String getXMLFilePath(){
        return xmlFile.getPath();
    }

    public int getWordus(){
        return Integer.parseInt(wordusValue.getText());
    }

    public String getSelectedFileType() {
        return selectedFileType;
    }
}
