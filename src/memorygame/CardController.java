/*
   The card controller is responsible for setting action listeners to card buttons
   and defines what happens when two clicked Button cards are the same or not updating
   as a result the players matched cards score and the number of moves
 */
package memorygame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
          
          if(this.isRevealed() == false)//when the same card is clicked twice nothing happens
          {
               revealCard(); 
               
               cardVector.add(this);//add this card to a list for comparing with previously added card
          }
          
           if(((cardVector.size()) == 2))//when the list contains only 2 cards enter here
           {
                 System.out.println("mpikame");
                 if(cardVector.get(0).getCardId()==cardVector.get(1).getCardId())//compares based on previously set ids
                 {
                     System.out.println("we had a match");//
                     round.updateMatches();//updates round INFO
                     
                 }
                 else
                 {
                     System.out.println("no match we hide cards");//if there is no match hide both opened cards
                     cardVector.get(0).cardHide();
                     cardVector.get(1).cardHide();
                     
                 }
                cardVector.removeAll(cardVector);//reinitilize list to expect 2 cards
                System.out.println(round.getMatches());
                round.updateMovesNum();//whether matched or not update the moves number
                System.out.println(round.getMovesNum());
           }
           if(round.getMatches()==(round.getCardsNumber()/2)) //if you match all the cards you get this messaage 
           {
               System.out.println("Congrats!!!!!!!");    
               JOptionPane.showMessageDialog(new JFrame(), "Well Done!!!! You finished matching cards after "+round.getMovesNum()+" moves");
           }
           
    }

    
      

    
}
