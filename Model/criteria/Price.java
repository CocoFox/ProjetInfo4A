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
public class Price extends AbstractCriteria{

    /**
     * @return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Float price) {
        this.price = price;
    }
    private Float price;
    public Price(Float price){
        name = "Price";
        this.price = price;
        priority = 50;

    }
    @Override
    public String toString(){
        return name + ": " + getPrice(); 
    }
    
}
