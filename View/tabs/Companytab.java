/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.tabs;

/**
 *
 * @author pacomebondetdelabernardie
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.criteria.Company;
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
public class Companytab extends JPanel{
    
    private final JButton addCompany = new JButton("Add Company");
    private final JButton removeCompany = new JButton("Remove Company");
    private JComboBox companyBox;
    private final JPanel buttonsPanel = new JPanel();
    
    public Companytab(){
        this.setPreferredSize(new Dimension(400,100));
        this.setLayout(new BorderLayout());
        
        
        
        Company [] companies = {
                
            new Company("Nintendo"),
            new Company("Square Enix"),
            new Company("Valve"),
            new Company("Bethesda"),
            new Company("Blizzard"),
            new Company("Sega"),
            new Company("Rare"),
            new Company("EA Games"),
            new Company("Nintendo"),
            new Company("Capcom"),
            new Company("Activision")
           
        };
        // Rating ComboBox
        companyBox = new JComboBox(companies);
        companyBox.setSelectedIndex(3);
       
        // Buttons 
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.Y_AXIS));
        buttonsPanel.add(addCompany);
        buttonsPanel.add(removeCompany);
        
        this.add(companyBox,BorderLayout.CENTER);
        
        this.add(buttonsPanel,BorderLayout.EAST);
        
    }
    
    public JButton getAddButton(){
        return addCompany;
    }
    public JButton getRemoveButton(){
        return removeCompany;
    }
    
    public Company getSelectedCompany(){
        return (Company) companyBox.getSelectedItem();
    }
    
}

