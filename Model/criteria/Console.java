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
public class Console extends AbstractCriteria{
    private String console;
    public Console(String console){
        name = "Console";
        this.console = console;
        priority = 50;

    }
    @Override
    public String toString(){
        return console; 
    }
}
