/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author giannis
 */
public class CardController extends Card implements ActionListener 
{
      private int clicks;
      private Timer timer;
      private ActionListener listener ;
      private static int numOfMatches,numOfMoves;
      private static ArrayList<Card> cardVector;
      private Round round;
     
      public CardController(Round round)
      {
          cardVector = new ArrayList<>();
          timer = new Timer(2000,this);
          timer.setRepeats(false);
          this.round = round;
          initButtonController(round);
      }
      public void initButtonController(Round round)
      {
         // cardVector = new ArrayList<>();
          addActionListener(this);
      }
     
       public void addCardToVector(Card card)
       {
          cardVector.add(card);
       }
     @Override
     public void actionPerformed(ActionEvent e) {
           //System.out.println("mpikame");
          
          if(this.isRevealed() == false)
          {
               revealCard(); 
               
               cardVector.add(this);
          }
          
           if(((cardVector.size()) == 2))
           {
                 System.out.println("mpikame");
                 //aMove(cardVector.get(0),cardVector.get(1));
                 if(cardVector.get(0).getCardId()==cardVector.get(1).getCardId())
                 {
                     System.out.println("we had a match");
                     round.updateMatches();
                     
                 }
                 else
                 {
                     System.out.println("no match we hide cards");
                     cardVector.get(0).cardHide();
                     cardVector.get(1).cardHide();
                     
                 }
                cardVector.removeAll(cardVector);
                System.out.println(round.getMatches());
                round.updateMovesNum();
                System.out.println(round.getMovesNum());
           }
           if(round.getMatches()==(round.getCardsNumber()/2)) System.out.println("congrats");
           
           
    }

    
      

    
}
