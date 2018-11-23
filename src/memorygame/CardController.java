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
          //timer = new Timer(2000,this);
          //timer.setRepeats(false);
           this.round = round;
           initButtonController(round);
      }
      public void initButtonController(Round round)
      {
         addActionListener(this);
        // timer = new Timer(2000,this.getActionListeners()[0]);
        // timer.setRepeats(false);
      }
     
       public void addCardToVector(Card card)
       {
          cardVector.add(card);
       }
      
       @Override
       public void actionPerformed(ActionEvent e) {
         
          if(this.isRevealed() == false)//Dont fill the vector with the same card or else do nothing if someone clicks the same card many times
          {
               revealCard(); 
               cardVector.add(this);//add this card to a list for comparing with previously added card
          }
          
          if((round.getGameVariation() == 1)||(round.getGameVariation()==2))
          {
           if(((cardVector.size()) == 2))//when the list contains only 2 cards enter here
           {
                 
                 if(cardVector.get(0).getCardId()==cardVector.get(1).getCardId())//compares based on previously set ids
                 {
                     System.out.println("we had a match");//
                     round.updateMatches();//updates round INFO
                     cardVector.removeAll(cardVector);
                 }
                 else
                 {
                     
                     int delay = 400; //milliseconds
                     ActionListener cardHider = new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent evt) 
                     {
                         
                         cardVector.get(0).cardHide();
                         cardVector.get(1).cardHide();
                         cardVector.removeAll(cardVector);
                     
                     }
                 };
                Timer t= new Timer(delay, cardHider);
                t.setRepeats(false);
                t.start();
                System.out.println("no match we hide cards");//if there is no match hide both opened cards
                     //cardVector.get(0).cardHide();
                    // cardVector.get(1).cardHide();
                     
                 }
                //cardVector.removeAll(cardVector);//reinitilize list to expect 2 cards
                round.updateMovesNum();//whether matched or not update the moves number
                System.out.println(round.getMovesNum());
           }
         }
         else
         {
            if(cardVector.size()==3){
                if((cardVector.get(0).getCardId()==cardVector.get(1).getCardId())&(cardVector.get(1).getCardId()==cardVector.get(2).getCardId()))
                {
                     System.out.println("we had a match");//
                     round.updateMatches();//updates round INFO
                     cardVector.removeAll(cardVector);
                }
                else
                {
                     System.out.println("no match we hide cards");//if there is no match hide both opened cards
                     int delay = 400; //milliseconds
                     ActionListener cardHider = new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent evt) 
                     {
                         
                         cardVector.get(0).cardHide();
                         cardVector.get(1).cardHide();
                         cardVector.get(2).cardHide();
                         cardVector.removeAll(cardVector);
                     
                     }
                 };
                Timer t= new Timer(delay, cardHider);
                t.setRepeats(false);
                t.start();
                     //cardVector.get(0).cardHide();
                    // cardVector.get(1).cardHide();
                     //cardVector.get(2).cardHide();
                }
               // cardVector.removeAll(cardVector);//reinitilize list to expect 2 cards
                round.updateMovesNum();//whether matched or not update the moves number
                System.out.println(round.getMovesNum());
            }
           
         }
           
          if(round.getMatches() == round.getGoal()) //if you match all the cards you get this messaage 
           {
               System.out.println("Congrats!!!!!!!");    
               JOptionPane.showMessageDialog(new JFrame(), "Well Done!!!! You finished matching cards after "+round.getMovesNum()+" moves");
           }
           
    }
         
  

    
}
