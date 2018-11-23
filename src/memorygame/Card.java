/*
    Card is an abstract class that defines the basic functions of 
    a card object:
    1)set card's images (image for card back and fron)
    2)rescale function for fitting image to the actual button in grid
    3)setting unique identifier for this card
    4)functions to reveal and hide cards
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
        isRevealed = false;
    }
    public void setCardId(int id) //used to set unique ids to main cards
    {
        this.id = id;
    }
    public int getCardId()
    {
        return this.id;
    }
    
    //makes the front image icon
    public void makeImageIcon(String imagePath,int width,int height)
    {
        path = imagePath;
        ImageIcon icon= new ImageIcon(imagePath);
        Image image = icon.getImage(); 
        Image newImg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);//rescale to fit in buttons dimensions
        icon = new ImageIcon(newImg);
        cardFront = icon;
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
