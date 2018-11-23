/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame;

/**
 *
 * @author giannis
 */
public  class Round 
{
    private  static int matches,moves;
    private int numOfCards;
    private int gameVariation;
    private int ultimateGoal;//matches to complete each game variation
    
    public Round(int numOfCards,int gameVariation)
    {
        matches = 0;
        moves= 0;
        this.numOfCards =numOfCards;
        this.gameVariation = gameVariation;
        if(gameVariation == 1 || gameVariation == 3) this.ultimateGoal = 12;
        else this.ultimateGoal = 24;
       
    }
    public int getGoal(){return this.ultimateGoal;}
    public int getCardsNumber()//how many cards are in the grid
    {
        return numOfCards;
    }
    public int getGameVariation()
    {
        return gameVariation;
    }
    public void updateMatches()
    {
        this.matches++;
    }
    public int getMatches()
    {
        return matches;
    }
    
    public void updateMovesNum()
    {
        this.moves++;
    }
    public int getMovesNum()
    {
        return moves;
    }
    
    
    
 }
