/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class Criteria {
    protected ArrayList<String> criterias;
    public Criteria(){
        criterias = new ArrayList<>();
    }
    
    public Criteria(String c){
        criterias = new ArrayList<>();
        criterias.add(c);
    }
    public ArrayList<String> getCriterias(){
        return criterias;
    }
    public void addCriteria(String c){
        criterias.add(c);
    }
    
    public int calculateScore(){
        //*todo
        return 420;
    }
        
    
    
    
    
    
}
