
/**
/**
 * I am coding checkers using the Java Language.
 *
 * @author (Saransh Duggal)
 * @version (January 14th, 2019)
 */
import java.awt.*;

public class Piece {
	
	private int row;
	//The current row of the game board that this Piece resides on 
	//Private makes it only available to this class.
	
	private int col;
	//The current column of the game board that this Piece resides on 
	
	public Color color;
	//The Color of this Piece 
	
	//The constructor below is to initialize a new Piece with the given color and at the given position
	  
	// @parameter c - The color of the new Piece
	// @parameter row - The row of the game board this piece stays until game ends.
	// @parameter col - The column of the game board this piece stays until game ends.
	 
	public Piece(Color c, int row, int col) {

		color = c;
		this.row = row;
		this.col = col;
		
	}
	
	// The method below is to get the row of the game board that the Piece resides on.
	public int getRow() {
		return row;
		//It will return the row of the game board this Piece resides on
	}
	
	// We will also need a constructor to get the color of this piece.
	public Color getColor() {
		return color;
		//It will return the current color of the piece.
	}
	
	//Get the column of the game board that the piece resides on.
	public int getCol() {
	return col;
	//It will return the column of the game board that the piece resides on.
	}
	
	// Give this Piece a new location to live on in the game board.
	 
	//@parameter row - The new row for this piece to stay on
	//@parameter col - The new column for this piece to stay on
	 
	public void setLoc(int row, int col) {
		this.row = row;
		this.col = col;
	}

	
	
	//The method below is required to get the String representation of the piece.
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		
		if(this.color == Color.BLACK)
			s.append("Black ");
		
		else
			s.append("Red ");
		
		s.append("piece at row " + Integer.toString(this.getRow()) + 
				 ", col " + Integer.toString(this.getCol()));
		
		return s.toString();
		//The String representation of this Piece.
	 
	}

}
