/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Editor;

import Controller.Comparator;
import View.windows.MainWindow;
import View.windows.AuthenticationWindow;
import Model.*;
import Model.criteria.Company;
import Model.criteria.ESRB_Rating;
import View.panels.MainPanel;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       //Editor ed = new Editor();
       //
       
       MainWindow mw = new MainWindow();
       MainModel mm = new MainModel();
       Comparator comp = new Comparator(mw,mm);
       //MainPanel mp = new MainPanel();
       //mw.add(mp);
       //Editor e = new Editor();
       
       //SQLGameBuilder builder = new SQLGameBuilder();
       //AuthenticationWindow aw = new AuthenticationWindow(mw);
       //mw.setVisible(true);
       //builder.loadGamesFromDataBase();
       
       
       
        
    }
    
    
    
}
