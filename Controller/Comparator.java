/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Game;
import Model.MainModel;
import View.windows.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class Comparator extends AbstractComparator{
    private MainWindow view;
    private MainModel model;
    private ArrayList<Game> gameList = new ArrayList<>();
    private ArrayList<GameScore> gameScoreList = new ArrayList<>();
    
    public Comparator(MainWindow view, MainModel model){
        this.view = view;
        this.model = model;
        
        view.getSearchButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                Game blankGame = view.getBlankGame();
                gameList = model.getGameList();
               
                
                for (Game g : gameList){
                    int score = 0;
                    
                    if(blankGame.getName() != null)
                        if(g.getName().toLowerCase().contains(blankGame.getName().toLowerCase()))
                          score += 200;
                    
                    if(blankGame.getCompany() != null)
                        if(g.getCompany().toString().equals(blankGame.getCompany().toString()))
                            score += g.getCompany().getPriority();
                    
                    if(blankGame.getPrice() != null)
                        if(g.getPrice().getPrice() <= blankGame.getPrice().getPrice())
                            score += g.getPrice().getPriority();
                        
                    if(blankGame.getRating() != null){
                        switch(blankGame.getRating().getRating()){
                            case "AO": if(g.getRating().getRating().equals("AO")){
                                score += g.getRating().getPriority();
                                break;
                            }
                            case "M": if(g.getRating().getRating().equals("M")){
                                score += g.getRating().getPriority();
                                break;
                            }
                            case "T": if(g.getRating().getRating().equals("T")){
                                score += g.getRating().getPriority();
                                break;
                            }
                            case "E10": if(g.getRating().getRating().equals("E10")){
                                score += g.getRating().getPriority();
                                break;
                            }
                            case "E" : if(g.getRating().getRating().equals("E")){
                                score += g.getRating().getPriority();
                                break;
                            }
                            case "eC": if(g.getRating().getRating().equals("eC")){
                                score += g.getRating().getPriority();
                                break;
                            }
                               
                        }
                    }
                    
                    if(g.isAvailable()){
                        score += 100;
                    }
                    
                    if(blankGame.getConsole()!= null)
                        if(g.getConsole().toString().equals(blankGame.getConsole().toString()))
                            score += g.getConsole().getPriority();
                    if(blankGame.getCategories() != null){
                        for (String userCategory : blankGame.getCategories().getCategoryList())
                            for (String category : g.getCategories().getCategoryList())
                                if(userCategory.equals(category))
                                    score += g.getCategories().getPriority();
                                
                    }
                    
                    gameScoreList.add(new GameScore(id,score));
                    id++;
                    
                    
                    
                }
                Collections.sort(gameScoreList);
                System.out.println(getSortedGameList());
            }
            
        });
    }
    
    public ArrayList<Game> getSortedGameList(){
        
        ArrayList<Game> sortedGameList = new ArrayList<>();
        for(int i = 0 ; i<10; i++){
            int gameId = gameScoreList.get(i).getGameIndex();
            sortedGameList.add(gameList.get(gameId));
        }
        return sortedGameList;
        
            
    }
    
    
}
