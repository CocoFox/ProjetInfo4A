/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.tabs;

import Model.criteria.Company;
import Model.criteria.Console;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class Consoletab extends JPanel{
    private final JButton addConsole = new JButton("Add Console");
    private final JButton removeConsole = new JButton("Remove Console");
    private JComboBox consoleBox;
    private final JPanel buttonsPanel = new JPanel();
    
    public Consoletab(){
        this.setPreferredSize(new Dimension(400,100));
        this.setLayout(new BorderLayout());
        
        
        
        Console [] consoles = {
                
            new Console("Nintendo 64"),
            new Console("Nintendo Switch"),
            new Console("Nintendo DS"),
            new Console("Nintendo Wii"),
            new Console("PlayStation 2"),
            new Console("PlayStation 3"),
            new Console("XBOX"),
            new Console("XBOX 360"),
            new Console("XBOX One"),
            new Console("NES"),
            new Console("SNES"),
            new Console("PC")
           
        };
        // Rating ComboBox
        consoleBox = new JComboBox(consoles);
        consoleBox.setSelectedIndex(3);
       
        // Buttons 
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.Y_AXIS));
        buttonsPanel.add(addConsole);
        buttonsPanel.add(removeConsole);
        
        this.add(consoleBox,BorderLayout.CENTER);
        
        this.add(buttonsPanel,BorderLayout.EAST);
        
    }
    
    public JButton getAddButton(){
        return addConsole;
    }
    public JButton getRemoveButton(){
        return removeConsole;
    }
    
    public Console getSelectedConsole(){
        return (Console) consoleBox.getSelectedItem();
    }
}
