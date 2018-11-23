/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author giannis
 */

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author giannis
 */
public class MainFrame extends JFrame implements ActionListener 
{
       private JPanel actionPanel;
       private JPanel mainPanel,ActionPanel;
       private JMenuBar menuBar;
       private JMenu menu;
       private JMenu chooseGameVariation;
       private JMenuItem loadDeck ,singleGame,doubleGame,tripleGame,quit;
       private Round round;
       
       
       public MainFrame()
       {
           initScreen();
       }
       void initScreen()
       {
          //Create the main window
          setTitle("Memory Game");
          setSize(1000, 680);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setResizable(true);
          ActionListener l ;
          
          mainPanel = new JPanel(new BorderLayout());
          add(mainPanel);
          
          //Add the main menuBar
          menuBar = new JMenuBar();
          setJMenuBar(menuBar);
         
          
          //add the menu to the menuBar
          menu = new JMenu("Start a game");
          menuBar.add(menu);
          
          
          //add the menu Items to the menu
          chooseGameVariation = new JMenu("Choose a game variation ");
          //add the subMenou(single,double,triple) of chooseGameVariation menu item 
          menu.addSeparator();
          //make the sub menu with variation choices
          
          singleGame = new JMenuItem("Single Game");
          singleGame.setToolTipText("12 cards 2 copies 4x6 Grid ,you choose 2");
          singleGame.setActionCommand("single");
          singleGame.addActionListener(this);
       
          doubleGame = new JMenuItem("Double Game");
          doubleGame.setToolTipText("24 cards 2 copies 6x8 Grid,you choose 2");
          doubleGame.setActionCommand("double");
          doubleGame.addActionListener(this);
          
          tripleGame = new JMenuItem("Triple Game");
          tripleGame.setToolTipText("12 cards 3 copies 6x6 Grid,you choose 3");
          tripleGame.setActionCommand("triple");
          tripleGame.addActionListener(this);
         
          //add single double triple menu items;
          chooseGameVariation.add(singleGame);
          chooseGameVariation.addSeparator();
          chooseGameVariation.add(doubleGame);
          chooseGameVariation.addSeparator();
          chooseGameVariation.add(tripleGame);
          
          chooseGameVariation.addSeparator();
          menu.add(chooseGameVariation);
          
         //add quit menu item
          menu.addSeparator();
          quit = new JMenuItem("quit");
          menu.add(quit);
          quit.addActionListener(event->{
                System.exit(0);//quits the programm
          });
          
           actionPanel = new JPanel();
           mainPanel.add(actionPanel);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
         
         LayoutManager layout ;
         File imageDirectory = new File("C:\\Users\\giannis\\Desktop\\imagesForMemoryGame");
         File[] imageFiles = imageDirectory.listFiles();
         ArrayList<CardController> cards = new ArrayList<>();
         Card card , copy,copy1,copy2;
         if(e.getActionCommand() == "single")
         {
            actionPanel.removeAll();
            actionPanel.revalidate();
           // Card card,copy;
            layout = new GridLayout(4,6,5,5);
            actionPanel.setLayout(layout);
            round = new Round(24);
            for(int i = 0; i<12; ++i)
            {
                 card = new CardController(round);
                 card.setCardId(i);
                 copy = new CardController(round);
                 copy.setCardId(i);
                 card.makeImageIcon(imageFiles[i].getAbsolutePath(),200, 200);//whattt
                 copy.makeImageIcon(imageFiles[i].getAbsolutePath(),200, 200);
                 cards.add((CardController)card);//one
                 cards.add((CardController)copy);//and the copy
            }
            putCardsToGrid(cards,4,6);
            
            
        }
        else if(e.getActionCommand() == "double")
        {
            actionPanel.removeAll();
            actionPanel.revalidate();
            layout = new GridLayout(6,8,5,5);
            actionPanel.setLayout(layout);
            round = new Round(48);
            for(int i = 0; i<24; ++i)
            {
                // Card card,copy;
                 card = new CardController(round);
                 card.setCardId(i);
                 copy = new CardController(round);
                 copy.setCardId(i);
                 card.makeImageIcon(imageFiles[i].getAbsolutePath(),200, 200);//whattt
                 copy.makeImageIcon(imageFiles[i].getAbsolutePath(),200, 200);
                 cards.add((CardController)card);//one
                 cards.add((CardController)copy);//and the copy
            }
            putCardsToGrid(cards,6,8);
            
            
        }
        else if(e.getActionCommand() == "triple")
        {
            actionPanel.removeAll();
            actionPanel.revalidate();
            layout = new GridLayout(6,8,5,5);
            actionPanel.setLayout(layout);
            round = new Round(36);
            for(int i = 0; i<12; ++i)
            {
                 //Card card,copy1,copy2;
                 card = new CardController(round);
                 card.setCardId(i);
                 copy1 = new CardController(round);
                 copy1.setCardId(i);
                 copy2 = new CardController(round);
                 copy2.setCardId(i);
                 card.makeImageIcon(imageFiles[i].getAbsolutePath(),200, 200);//whattt
                 copy1.makeImageIcon(imageFiles[i].getAbsolutePath(),200, 200);
                 copy2.makeImageIcon(imageFiles[i].getAbsolutePath(),200, 200);
                 cards.add((CardController)card);//one
                 cards.add((CardController)copy1);//and the copy
                 cards.add((CardController)copy2);
            }
            putCardsToGrid(cards,6,6);
           }
        
       }
       public void putCardsToGrid(ArrayList<CardController> cards,int rows ,int columns)
       {
                Collections.shuffle(cards);
                for(CardController c:cards) 
                {
                    actionPanel.add(c);
                   // c.addActionListener(c);
                   
                   // System.out.println(c.getCardId());
                }
                mainPanel.add(actionPanel);
        }

    
       
      
}





