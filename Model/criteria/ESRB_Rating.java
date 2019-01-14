/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.criteria;

import Model.*;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class ESRB_Rating extends AbstractCriteria{

    private String rating;
    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    
    public ESRB_Rating(String rating){
        name = "Rating";
        priority = 20;
        this.rating = rating;
    }
    
    @Override
    public String toString(){
        return name + ": " + getRating(); 
    }
}
