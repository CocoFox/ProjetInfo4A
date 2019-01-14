/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Editor.SQLGameBuilder;
import java.util.ArrayList;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class MainModel {
    private final SQLGameBuilder gameBuilder = new SQLGameBuilder();
    private ArrayList<Game> gameList = new ArrayList<>();
    public MainModel(){
        gameList = gameBuilder.loadGamesFromDataBase();
    }
    
    public ArrayList<Game> getGameList(){
        return gameList;
    }
    
}
