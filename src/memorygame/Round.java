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
    private static int matches,moves;
    private int numOfCards;
    
    public Round(int numOfCards)
    {
        matches = 0;
        moves= 0;
        this.numOfCards =numOfCards;
    }
    public int getCardsNumber()
    {
        return numOfCards;
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
