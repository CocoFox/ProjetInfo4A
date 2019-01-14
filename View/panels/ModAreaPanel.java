/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.panels;

import Model.Editor.Editor;
import View.windows.AuthenticationWindow;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class ModAreaPanel extends JPanel{
    
    private JLabel label = new JLabel("Moderator Area:");
    private JButton loginButton = new JButton("Login");
    private JFrame editor = new Editor();
    private AuthenticationWindow authenticationWindow;
    public ModAreaPanel(JFrame parent){
        this.setLayout(new FlowLayout());
        
        loginButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticationWindow = new AuthenticationWindow(parent);
                authenticationWindow.setVisible(true);
                if (authenticationWindow.isSucceeded()){
                    editor.setVisible(true);
                }
                    
            }
            
        });
        
        this.add(label);
        this.add(loginButton);
        
    }
}
