
/**
 * I am coding checkers using the Java Language.
 *
 * @author (Saransh Duggal)
 * @version (January 14th, 2019)
 */
import java.awt.*;

public class Square extends Canvas {
    //Canvas is needed because it represents a blank rectangular area of the frame.
    //This is onto which applications can be created upon and get input events from the user.
    //This allows the Square class to inherit the Canvas class.    
    
    public enum BackgroundColor { LIGHT, DARK };
    // The background color that a square should be 
    
    
    private BackgroundColor bgColor;
    //This allows to set the background color of this Square 
    
    
    private boolean occupied;
    //This decides whether or not this Square is occupied 
    
    
    private Piece occupant;
    // The Piece that occupies this Square, may be null.
   
    private int row;
    // The row of the game board that this square represents 
    
    private int col;
    // The column of the game board that this square represents 
    
    
    // Make a new Square at the given position with the specified BackgroundColor
     //@parameter c - The background color of this Square.
    public Square(BackgroundColor c, int myrow, int mycol) {
        
        this.setSize(64, 64);

        if(c == BackgroundColor.DARK)
            this.setBackground(Color.DARK_GRAY);
        else
            this.setBackground(Color.LIGHT_GRAY);
    
    
        bgColor = c;
        occupied = false;
        occupant = null;
        
        this.row = myrow;
        this.col = mycol;
        
    }

    
    

    //This returns whether or not the perticular Square is occupied or not.
    public boolean isOccupied() {
        return this.occupied;
        //Whether or not this Square is selected
    }
    
    
    // This method gets the row of the game board that this square represents.
    public int getRow() {
        return this.row;
        //The row on the game board represented by this Square
    }
    
    //This method gets the column of the game board that this square represents
    public int getCol() {
        return this.col;
        //The column on the game board represented by this Square
    }
    //The previous 2 methods are similar to calculating x and y coordinates of a point.
    //Except instead of a point, it is a square.
    
    /** Get the background color of this Square */
    public Square.BackgroundColor getBackgroundColor() {
        return this.bgColor;
    }
    
    //This method will help get the piece that occupies a Square.
    public Piece getOccupant() {
        if(this.isOccupied())
            return this.occupant;
        //This will return the piece that occupies the Square (if there is any piece).
        return null;
    }
    
    
    
    //This method will set whether or not this Square is highlighted.
    //@parameter doHighlight - Whether or not this square should be highlighted.

    public void setHighlight(boolean doHighlight) {

        Graphics g = this.getGraphics();
        
        if(doHighlight) {

            if(!this.isOccupied()) {
                
                g.setColor(Color.BLACK);
            
                //Draw a dotted oval where this piece may land
                for(int i = 0; i < 360; i+= 30)
                    g.drawArc(5, 5, 54, 54, i, 15);
            }
            
            else {
                //Draw a yellow rect around the border of this Square 
                g.setColor(Color.YELLOW);
                g.draw3DRect(0, 0, 63, 63, false);
                
            }
        }
        else
            //If this square has a highlight in it, erase it by redrawing the Square
            super.update(this.getGraphics());
        //Super calls the update method of the parent class, and passes the argument.
        //This is the returning value of the getGraphics method.
    }


    // Set the occupant of this Square
    //@parameter visitor - The Piece that should now reside here
    public void setOccupant(Piece visitor) {
        if(visitor != null) {
            
            this.occupant = visitor;
            this.occupied = true;
            
        }
        
        else {
            
            this.occupant = null;
            this.occupied = false;
            
        }
    }
    
    
    
    
    
    @Override
    // Have this square redraw itself, removing potential highlighting and adding/removing an occupant Piece as necessary.
    //@param g - The Graphics object belonging to this Square
    //G is an object of the Graphics class.
    //Paint is a method.
    public void paint(Graphics g) {
        
        //Set the Canvas' background color equal to the Square's bgcolor
        if(this.getBackgroundColor() == Square.BackgroundColor.DARK)
            this.setBackground(Color.DARK_GRAY);
        
        else
            this.setBackground(Color.LIGHT_GRAY);
        
        //Either draw a square or clear the rectangle
        if(this.isOccupied()) {
            
            g.setColor(occupant.getColor());
            g.fillOval(5, 5, 54, 54);
            

        }
        
        else
            g.clearRect(0, 0, 64, 64);
        //Clears rectangle.    
    }
    

    
}
