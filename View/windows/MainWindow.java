/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.windows;

import Model.Game;
import View.panels.MainPanel;
import View.panels.ModAreaPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class MainWindow extends JFrame{
    private MainPanel mainPanel = new MainPanel();
    private ModAreaPanel modAreaPanel = new ModAreaPanel(this);
    //JPanel modLoginPanel = new 
    public MainWindow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(250, 250);
        this.setLayout(new GridBagLayout());
        this.setSize(new Dimension(800,500));
        this.addComp(mainPanel,0,0,20,20,GridBagConstraints.EAST,GridBagConstraints.NONE);
        this.addComp(modAreaPanel, 20, 0, 20, 20, GridBagConstraints.EAST, GridBagConstraints.NONE);
        this.setVisible(true);
    }
    private void addComp(JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int anchor, int fill) {

        GridBagConstraints gridC = new GridBagConstraints();

        gridC.gridx = xPos;
        gridC.gridy = yPos;
        gridC.gridwidth = compWidth;
        gridC.gridheight = compHeight;
        gridC.weightx = 0;
        gridC.weighty = 0;
        gridC.insets = new Insets(0, 0, 0, 0);
        gridC.anchor = anchor;

        gridC.fill = fill;

        this.add(comp, gridC);

    }
    public JButton getSearchButton(){
        return mainPanel.getSearchButton();
               
    }
    public Game getBlankGame(){
        return mainPanel.getBlankGame();
    }

    
    
}
