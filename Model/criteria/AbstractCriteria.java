package Model.criteria;


import Model.Article;
import java.util.ArrayList;
import java.util.HashMap;


public abstract class AbstractCriteria {
    protected int priority;
    protected String name;
    
    @Override
    abstract public String toString();
    public int getPriority(){
        return priority;
    }

}