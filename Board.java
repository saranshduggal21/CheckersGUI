
/**
 * I am coding checkers using the Java Language.
 *
 * @author (Saransh Duggal)
 * @version (January 14th, 2019)
 */
import java.util.Vector;
import java.awt.*;

public class Board {
    public static final int rows = 8;
    // Number of rows in the board.
    
    public static final int cols = 8;
    // Number of columns in the board.
    
    private Square[][] gameBoard;
    //This is an array of Squares that represents the entire game board (8x8).
    // Constructor takes no argumentss and produces a Board 
    //This will be of size, rows and cols, with alternating background colors
    public Board() //Constructor of the class, Board.
    {
        
        gameBoard = new Square[rows][cols];
        
        boolean lastcolor = false;
        //Set up the game board with alternating colors, which is an essential part of a Checker board.
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                
                if(lastcolor)
                    gameBoard[i][j] = new Square(Square.BackgroundColor.DARK, i, j);
                else
                    gameBoard[i][j] = new Square(Square.BackgroundColor.LIGHT, i, j);
                
                //Toggle lastcolor
                lastcolor = !lastcolor;
            }
            
            //Switch starting color for next row
            lastcolor = !lastcolor;
        }
        
        
    }

    

    
    

    
    // This method will check to see if a position in this Board is in bounds
    //@param row - The row to be checked
    //@param col - The column to be checked
    
    public static boolean inBounds(int row, int col) {
        if(row >= 0 && row < rows &&
            col >= 0 && col < cols)
            
            return true;
        
        
        return false;
        //True if in bounds, false if not.
    }
    
    
    // Get a particular Square contained in this Board
    // @parameter row - The row at which the square should be
    //@parameter col - The column at which the square should be
     
    public Square getSquare(int row, int col) {
        if(inBounds(row, col))
            return gameBoard[row][col];
        //The square at (row, col), or null if (row, col) is out-of-bounds.
        
        return null;
    }
    
    //We need to fill this Board with Red pieces on top, and Black pieces on bottom 
    public void placeStartingPieces() {
        
        //Have the Red side on top, Black side on bottom
        //This will wstablish the Red side first
        for(int row = 0; row < 3; row++)
            for(int col = 0; col < 8; col++)
                if(getSquare(row, col).getBackgroundColor() == Square.BackgroundColor.DARK)
                    getSquare(row,col).setOccupant(new Piece(Color.RED, row, col));
        
        //NThis will establish the Black side
        for(int row = 5; row < 8; row++)
            for(int col = 0; col < 8; col++)
                if(getSquare(row, col).getBackgroundColor() == Square.BackgroundColor.DARK)
                    getSquare(row,col).setOccupant(new Piece(Color.BLACK, row, col));
    }
    
    
    // Find all possible Squares to which this piece can move
    // @parameter p - Piece for which moves should be found
    public Vector<Square> getPossibleMoves(Piece p) {
        /*Possible moves include up-left, up-right, down-left, down-right
         * This corresponds to (row-- col--), (row-- col++),
         *                      (row++ col--), (row++ col++) respectively
         */
        
        Vector<Square> possibleMoves = new Vector<Square>();
        Color pColor = p.getColor();
        
        int row = p.getRow();
        int col = p.getCol();
        
        //Begin checking which moves are possible, keeping in mind that only black checkers may move up
        //and only red checkers may move downwards
        
        //Check moves to the top-left of this piece
        if(Board.inBounds(row-1, col-1) && pColor == Color.BLACK) {
            
            if(!this.getSquare(row-1, col-1).isOccupied())
                possibleMoves.add(this.getSquare(row-1, col-1));
        
            //if square is occupied, and the color of the Piece in square is
            //not equal to the piece whose moves we are checking, then
            //check to see if we can make the jump by checking
            //the next square in the same direction
            else
                if(Board.inBounds(row-2, col-2))
                    
                    if(!this.getSquare(row-2, col-2).isOccupied() &&
                        (this.getSquare(row-1, col-1).getOccupant().getColor() != pColor))
                        
                        possibleMoves.add(this.getSquare(row-2, col-2));
            
        }
        
        //Check moves to the top-right of this piece
        if(Board.inBounds(row-1, col+1) && pColor == Color.BLACK) {
            
            if(!this.getSquare(row-1, col+1).isOccupied())
                possibleMoves.add(this.getSquare(row-1, col+1));
        
            else
                if(Board.inBounds(row-2, col+2))
                    
                    if(!this.getSquare(row-2, col+2).isOccupied() && 
                        (this.getSquare(row-1, col+1).getOccupant().getColor() != pColor))
                            
                        possibleMoves.add(this.getSquare(row-2, col+2));
        }
        
        //check moves to the bottom-left of this piece
        if(Board.inBounds(row+1, col-1) && pColor == Color.RED) {
            
            if(!this.getSquare(row+1, col-1).isOccupied())
                possibleMoves.add(this.getSquare(row+1, col-1));
            
            
            
            else
                if(Board.inBounds(row+2, col-2))
                    
                    if(!this.getSquare(row+2, col-2).isOccupied() && 
                        (this.getSquare(row+1, col-1).getOccupant().getColor() != pColor))
                            
                        possibleMoves.add(this.getSquare(row+2, col-2));
        }
        
        //check moves to the bottom-right of this piece
        if(Board.inBounds(row+1, col+1) && pColor == Color.RED) {
            
            if(!this.getSquare(row+1, col+1).isOccupied())
                possibleMoves.add(this.getSquare(row+1, col+1));
        
            else
                if(Board.inBounds(row+2, col+2))
                    
                    if(!this.getSquare(row+2, col+2).isOccupied() && 
                        (this.getSquare(row+1, col+1).getOccupant().getColor() != pColor))
                            
                        possibleMoves.add(this.getSquare(row+2, col+2));
        }
        
        
        return possibleMoves;
        //By utilizing a Vector of Squares, it will return the moves this piece can take.
    
    }
    
    
    //This method is needed in order to highlight all the possible moves that can be made.
    //@parameter p - The Piece whose possible moves we are highlighting.
    //@parameter doHighlight - Whether or not these possible moves should be highlighted.

    public void setMovesHighlighted(Piece p, boolean doHighlight) {
        
        Vector<Square> possibleMoves = getPossibleMoves(p);
        
        if(doHighlight) {
            for(Square highlight : possibleMoves)
                highlight.setHighlight(true);
        }
        
        else {
            for(Square highlight : possibleMoves)
                highlight.setHighlight(false);
        }
    }
    
    
    // This method is needed in order to perform a move on the board. 
    //This function does not perform input checking, as it is only called,
    //once a move has been validated by getPossibleMoves
    //@parameter from - The square from which we are moving (old square).
    //@param to - The square to which we are moving (new square).
    public boolean move(Square from, Square to) {
        boolean jumpPerformed = false;
        
        Piece beingMoved = from.getOccupant();
        
        int oldRow = from.getRow(), newRow = to.getRow();
        int oldCol = from.getCol(), newCol = to.getCol();
        
        from.setOccupant(null);
        beingMoved.setLoc(to.getRow(), to.getCol());
        to.setOccupant(beingMoved);
        
        if(Math.abs(oldRow - newRow) > 1 || Math.abs(oldCol - newCol) > 1) {
            //A jump has been performed, so get the Square that lies between from and to
            int takeRow = (oldRow + newRow) / 2;
            int takeCol = (oldCol + newCol) / 2;
            
            Square takeSquare = getSquare(takeRow, takeCol);
            takeSquare.setOccupant(null);
            takeSquare.update(takeSquare.getGraphics());
            
            jumpPerformed = true;
            
        }
        
        from.update(from.getGraphics());
        to.update(to.getGraphics());
        
        return jumpPerformed;
        //It will return True if a jump has been performed. 
        //It will only return false if it's just a normal move.
        
    }



    
    
}
