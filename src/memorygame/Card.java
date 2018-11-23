/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author giannis
 */
public abstract class Card extends JButton //implements ActionListener 
{
    private String path;
    private int id;
    private ImageIcon cardBack , cardFront;
    private boolean isRevealed ;
    
    
    
    
    public Card()
    {
        cardBack = new ImageIcon("C:\\Users\\giannis\\Documents\\NetBeansProjects\\MemoryGame\\src\\Images\\cardBack.jpg");
        this.setIcon(cardBack);
        //cardControl = new CardController();
        isRevealed = false;
        
          
    }
    public void setCardId(int id)
    {
        this.id = id;
    }
    public int getCardId()
    {
        return this.id;
    }
    
    public void makeImageIcon(String imagePath,int width,int height)
    {
        path = imagePath;
        ImageIcon icon= new ImageIcon(imagePath);
        Image image = icon.getImage();
        Image newImg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        cardFront = icon;
        //this.setIcon(icon);
    }
    
    public void revealCard()
    {
        this.setIcon(cardFront);
        this.isRevealed = true;
    }
    
    public void cardHide()
    {
        this.setIcon(cardBack);
        this.isRevealed = false;
    }

  
    public String getImgPath() {return path;}
    public void setIsRevealed(boolean b){this.isRevealed = b;}
    public boolean isRevealed(){return this.isRevealed;}

    
    
}
