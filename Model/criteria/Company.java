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
public class Company extends AbstractCriteria{
    protected String companyName;
    
    public Company(String companyName){
        name = "Company";
        priority = 10;
        this.companyName= companyName;

    }
    @Override
    public String toString(){
        return  companyName; 
    }
    
    
    
    
}
