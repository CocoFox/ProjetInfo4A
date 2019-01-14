/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.criteria;

import java.util.ArrayList;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class Categories extends AbstractCriteria{
    private ArrayList<String> categoryList = new ArrayList<>();
    
    public Categories(){
        name = "Categories";
        priority = 30;

    }
    public Categories(ArrayList<String> lcategories){
        categoryList = lcategories;
    }
    public void addCategory(String category){
        categoryList.add(category);
    }
    @Override
    public String toString(){
        return categoryList.toString();// + ": " + categoryList; 
    }
    public boolean isEmpty(){
        return categoryList.isEmpty();
    }
    public ArrayList<String> getCategoryList(){
        return categoryList;
    }
}
