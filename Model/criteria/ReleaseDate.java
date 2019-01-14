/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.criteria;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class ReleaseDate extends AbstractCriteria{
    private java.util.Date releaseDate;
    public ReleaseDate(java.util.Date date){
        name = "Release Date";
        releaseDate = date;
        priority = 5;

    }

    public ReleaseDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
        return name + ": " + releaseDate; 
    }
    
    
}
