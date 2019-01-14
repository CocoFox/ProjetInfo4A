/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.tabs;

import Model.criteria.ESRB_Rating;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class ESRBtab extends JPanel{
    
    private final JButton addRating = new JButton("Add Rating Limit");
    private final JButton removeRating = new JButton("Remove Rating Limit");
    private final JComboBox ratingBox;
    private final JPanel buttonsPanel = new JPanel();
    
    public ESRBtab(){
        this.setPreferredSize(new Dimension(400,100));
        this.setLayout(new BorderLayout());
        
        
        
        ESRB_Rating [] ratings = {
                new ESRB_Rating("eC") // Early Childhood
                ,new ESRB_Rating("E") // Everyone
                ,new ESRB_Rating("E10+") // Everyone 10 and up
                ,new ESRB_Rating("T")  // Teen
                ,new ESRB_Rating("M") // Mature
                ,new ESRB_Rating("AO") // Adults Only
        };
        // Rating ComboBox
        ratingBox = new JComboBox(ratings);
        ratingBox.setSelectedIndex(3);
       
        // Buttons 
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.Y_AXIS));
        buttonsPanel.add(addRating);
        buttonsPanel.add(removeRating);
        
        this.add(ratingBox,BorderLayout.CENTER);
        
        this.add(buttonsPanel,BorderLayout.EAST);
        
    }
    
    public JButton getAddButton(){
        return addRating;
    }
    public JButton getRemoveButton(){
        return removeRating;
    }
    
    public ESRB_Rating getSelectedRating(){
        return (ESRB_Rating) ratingBox.getSelectedItem();
    }
    
}
