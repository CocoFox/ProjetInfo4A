/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.tabs;

import Model.criteria.AbstractCriteria;
import Model.criteria.Categories;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class CriteriaButton extends JComponent{
    
    private String buttonString;
    private int componentWidth;
    
    
    
    AbstractCriteria criteria;
    public CriteriaButton(AbstractCriteria criteria){
        buttonString = criteria.toString();
        this.criteria = criteria;
        setSize(30,30);
        setVisible(true);
        
        
    }
    @Override
    public Dimension getPreferredSize(){
        FontMetrics fm = getGraphics().getFontMetrics();
        componentWidth = fm.stringWidth(buttonString);
        return new Dimension(componentWidth,20);
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.darkGray);
        if (criteria instanceof Categories){
            g2.setColor(Color.red);
        }
        g2.fillRoundRect(0, 0, componentWidth, 20, 6, 6);
        g2.setColor(Color.WHITE);
        g2.drawString(buttonString, 0,15);
        
    }
}
