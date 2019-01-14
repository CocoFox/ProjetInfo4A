/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class GameScore implements Comparable<GameScore>{
    private int gameIndex;
    private int score;
    
    public GameScore(int gameIndex, int score){
        this.gameIndex = gameIndex;
        this.score = score;
    }

    /**
     * @return the gameIndex
     */
    public int getGameIndex() {
        return gameIndex;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(GameScore o) {
    
        
    return (o.score-this.score);  
        
    }
    
    
    
}
