
/**
/**
 * I am coding checkers using the Java Language.
 *
 * @author (Saransh Duggal)
 * @version (January 14th, 2019)
 */
import java.awt.*;
import java.util.Vector;//This is to make a growable array of objects (my checker pieces).
import javax.swing.*;
import java.awt.event.*;

public class UnlimitedMode implements MouseListener,ActionListener 
{
    public JFrame frame;
    // The frame that will serve to holds the contents of our game 
    //Public makes this accessible outside of this class.
    private JPanel boardpanel;
    //The panel that will hold our Board 
    //Private only makes it accessible within this class.
    private JLabel piecesLabel;
    // The label that will keep track of remaining pieces for each side 
    
    private JMenuBar menubar;
    // Menubar containing the Exit and New Game options 
    
    private JMenu fileMenu;
    // File menu 
    
    private JMenuItem newGame;
    // New Game menu item 
    
    private JMenuItem exit;
    // Exit menu item 
    
    private Color currentTurn;
    // Keep track of the current turn 
    
    private final int borderWidth = 1;
    // Border width between squares in the game board 
    
    private Board board;
    // The board which will store our game's state 
    
    private int blackCheckersLeft;
    // The number of checkers remaining for Black side 
    
    private int redCheckersLeft;
    // The number of checkers remaining for Red side 
    
    private Square selectedSquare;
    // Hold a reference to the currently selected Piece 
    
    
    // Constructor takes no arguments and forms a new game 
    public UnlimitedMode() {
        
        
        CreateAndShowGUI();
        //This is to display the interface on the user screen.
        
        currentTurn = Color.GREEN;
        //This helps set the initial turn for the players.
        
        redCheckersLeft = 12;
        blackCheckersLeft = 12;
        //These are the initial values for checker pieces on the board.
        
        updateStatus();
        //This method shows how many checkers are left on the board.

    }
    
    
    public void CreateAndShowGUI() {
        // This constructor is to set up the visual interface to the game.
        
        frame = new JFrame("Checkers");
        //My frame title is Checkers
        frame.setLayout(new FlowLayout());
        
        frame.getContentPane().setLayout(
                new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        
       
        boardpanel = new JPanel(new GridLayout(8, 8));
        boardpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //Give our Board a visual representation
        board = new Board();
        board.placeStartingPieces();
        
        
        piecesLabel = new JLabel(" ");
        piecesLabel.setHorizontalTextPosition(JLabel.LEFT);
        piecesLabel.setVerticalTextPosition(JLabel.BOTTOM);
        //This will help us keep track of how many pieces are left
        
        menubar = new JMenuBar();
        fileMenu = new JMenu("PAUSE");
        //This is what will be needed in order to add the menubar to the window
        newGame = new JMenuItem("New Game");
        newGame.addActionListener(this);
        //This is option/button number 1 in the file menubar.
        //This will reset the board to the orginal state.
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        //This is option/button number 2 in the file menubar.
        //This exits the game and leads the user back to the Main Menu.
        fileMenu.add(newGame);
        fileMenu.add(exit);
        menubar.add(fileMenu);
        //This adds my exit and new game options to the menubar.
        
        addBoardToPanel(board,boardpanel);
        //board and boardpanel are arguments of the method, addBoardToPanel.
        //board is an object of the board class
        //boardpanel is my JPanel
        frame.add(boardpanel);
        frame.add(piecesLabel);
        frame.setJMenuBar(menubar);
        frame.pack();
        //Add our board to boardpanel and add everything to the window
        
        //The following is to resize the frame 
        Rectangle boundingRect = frame.getBounds();
        //This will fetch the bounds of the frame.
        frame.setBounds(boundingRect.x, boundingRect.y, boundingRect.width + 5, boundingRect.height);
        //These are the (x value, y value, width and height) of the frame.
        frame.setVisible(true);


    }
    
    //mouseClicked method is also in the parent class so @Override would allow us
    //us to override the mouseClicked method for a new implementation of the mousClicked method.
    @Override
    public void mouseClicked(MouseEvent e) {
        

        Square sel = (Square)e.getComponent();
        //When we click using the mouse, an action is performed, and that event is stored in a Square object(sel).
        //Ensure that the correct color piece has been chosen by the user.
        //The Piece's color should be equal to currentTurn, unless it is the first move
        //in which case currentTurn is going to be Color.GREEN
        if(sel.isOccupied()) 
            if(sel.getOccupant().getColor() != currentTurn &&
                currentTurn != Color.GREEN) {
            JOptionPane.showMessageDialog (frame,"Not possible, please make an appropriate move.");
        
            return;
        }
        
        
        
        // Since we are now sure that the user has clicked on a piece of their own color, 
        //we have to code the rest of the 4 possible scenarios that can take place.
        //Scenario 1: The user has nothing highlighted and wishes to click on a new Square
        //Scenario 2: The user wishes to change the square that is selected, to a different sqaure.
        //Scenario 3: The user wishes to deselect the current square selected.
        //Scenario 4: The user wishes to perform a jump in order to kill an oponent piece.
         
        
        //There is currently no square selected, where the user wants to move so,
        //the program will highlight all possible moves for the user.
        if(sel.isOccupied() && selectedSquare == null) {
            selectedSquare = sel;
            selectedSquare.setHighlight(true);
            board.setMovesHighlighted(selectedSquare.getOccupant(), true);
            //setMovesHighlighted is a method of the board class.
            //We call the method getOccupant from the square class
            //This gets the piece that is occupied within the square.
            return;
            
        }
        
        
        
        //This occurs when the user has clicked on a different square
        //than the one currently selected
        else if(sel.isOccupied() && !sel.equals(selectedSquare)) {
            
            selectedSquare.setHighlight(false);
            board.setMovesHighlighted(selectedSquare.getOccupant(), false);
            //This will reset the selectedSquare to the one currently under the cursor.
            //Calls the setMouseHighlighted method of the Board class.
            //This does not highlight the possible moves that can be made.
            selectedSquare = sel;
            selectedSquare.setHighlight(true);
            board.setMovesHighlighted(selectedSquare.getOccupant(), true);
            //This once again calls the setMouseHighlighted method of the Board class.
            //This now highlights the moves that can be made.
            return;
            
        }
        
        //This will happen when the user has deselected the current square
        else if(sel.equals(selectedSquare)) {
            
            selectedSquare.setHighlight(false);
            board.setMovesHighlighted(selectedSquare.getOccupant(), false);
            //This falsifies the selected square and diselects it.
            selectedSquare = null;
        }
        
        

        //Move-checking code
        else if(!sel.isOccupied() && selectedSquare != null) {
            //The user is trying to make a move by moving from the selectedSquare to the one they just clicked
            //First check to see if their choice corresponds to a square in possibleMoves
            
            boolean found = false;
            boolean jumped = false;
            
            Vector<Square> oldPossibleMoves = board.getPossibleMoves(selectedSquare.getOccupant());
            //oldPossibleMoves in an object of the Square class 
            //Square class is in the form of the array, which is why it is Canvas class
            for(Square choice : oldPossibleMoves) {
                if(choice.equals(sel)) {
                    
                    //Move found in the Vector of possible moves, so perform it
                    
                    //First, check to see if this was the first move being performed
                    if(currentTurn == Color.GREEN)
                        currentTurn = selectedSquare.getOccupant().getColor();
                    
                    //Next, store in a variable whether or not a jump was performed
                    jumped = board.move(selectedSquare, sel);
                    
                    //Finally, indicate internally that a move has been found and performed
                    found = true;
                    

                }
            }
            

            
            if(found) {
                if(jumped) {
                    //if the opponents piece is killed
                    if(currentTurn == Color.BLACK) {
                        redCheckersLeft--;
                        //If it is the black piece that has killed the red piece,
                        //the red piece count deducts by 1.
                    }
                    else {
                        blackCheckersLeft--;
                        //If it is the red piece that has killed the black piece,
                        //the black piece count deducts by 1.
                    }
                    
                }
                
                //For the next move, it then unhighlights the moves from the piece's previous position.
                //It does so by setting the values false.
                selectedSquare.setHighlight(false);
                for (Square unhighlight : oldPossibleMoves)
                    unhighlight.setHighlight(false);
                selectedSquare = null;
                
                //This calls the endTurn method and ends the turn of the user.
                //This allows the game to progress and the next player to play the turn.
                endTurn();
                //This calls the updateStatus method and updates the number of checkers left on the board.
                updateStatus();
                
                
                //This will then check to see if the move played, ended the game.
                String winningStr = winner();
                if(winningStr != null) {
                    //This only occurs when a player has won the game.
                    int restart = JOptionPane.showConfirmDialog(null, winningStr + " Do you want to start a new game?", "New Game?", JOptionPane.YES_NO_OPTION);
                    
                    if(restart == JOptionPane.YES_OPTION)
                        restartGame();
                    else {
                        frame.setVisible(false);
                        frame.dispose();
                    }
                        
                }
            }
            
            else if(!found) 
                //if the player makes a move that is not possible.
                //For example, clicks to move to a square that is already occupied.
                JOptionPane.showMessageDialog (frame,"Not possible, please make an appropriate move.");
        }
        
    }

    //Must implement as per MouseListener
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    
    
    @Override
    // Perform the appropriate action when a menu item is clicked 
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals ("New Game")) {
            restartGame();
            //This occurs when the user has clicked on the File button in the menubar,
            //and chosen the New Game button.
            //This resets the score and pieces on the board.
        }
        else if(e.getActionCommand().equals ("Exit")) {
            frame.setVisible(false);
            frame.dispose();
            MainMenu m = new MainMenu ();
            m.setVisible (true);
            //This occurs when the user has clicked on the File button in the menubar,
            //and chosen the Exit button.
            //This exits the game and takes them to the Main menu page.
        }
        
    }
    
    //Add the Board to a Panel to create the appearance of a checkerboard
     
     //@parameter b - The Board to be add to a JPanel 
     // @parameter p - This is the JPanel where we want to add the board.
    
    public void addBoardToPanel(Board b, JPanel p) {
        for(int i = 0; i < 8; i++) {
            //This to generate the 8 squares in one row in a checkerboard.
            for(int j = 0; j < 8; j++) {
                //This to generate the 8 squares in one column in a checkerboard.
                Square sq = b.getSquare(i, j);
                sq.addMouseListener(this);
                
                JPanel ContainerPanel = new JPanel(new FlowLayout());
                ContainerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,
                                                                                    borderWidth));
                ContainerPanel.add(sq);
                if(sq.getBackgroundColor() == Square.BackgroundColor.DARK)
                    ContainerPanel.setBackground(Color.DARK_GRAY);
                    //It first fetches the colour of the square.
                    //If it is dark then it becomes, Dark Gray
               
                else
                    ContainerPanel.setBackground(Color.LIGHT_GRAY);
                p.add(ContainerPanel);
                //Else the square colour becomes Light Gray.
            }
        }
    }
    
    
    
    // Update the text of piecesLeft to a string representation of the number of pieces left for both sides 
    public void updateStatus() {
        piecesLabel.setText("Red pieces left: " + redCheckersLeft + "             Black pieces left: " + blackCheckersLeft);
    }
    
    
    // This is to find out, if the game is over, who won and how that side won.
     
    //@return - A String containing the side which won, as well as how they won (took other side's pieces, other side could make no more moves)
     
    public String winner() {
        
        //Check first ending condition: one side loses all pieces
        if(blackCheckersLeft == 0)
            return "Red has won by taking Black's pieces!";
            
        if(redCheckersLeft == 0)
            return "Black has won by taking Red's pieces!";
        
        
        //Check second ending condition: one side cannot move its remaining pieces
        boolean redCanMove = false;
        boolean blackCanMove = false;
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                
                //Get all possible moves for all pieces currently on the board
                if(board.getSquare(i, j).isOccupied()) {
                    Vector<Square> potentialMoves = board.getPossibleMoves(board.getSquare(i, j).getOccupant());
                    
                    if(! potentialMoves.isEmpty()) {
                        //The potentialMoves Vector contains at least one square, so that side is capable of making a move
                        //Find out what the color of the piece that can make the move is, then set its <color>CanMove var to true
                        
                        if(board.getSquare(i, j).getOccupant().getColor() == Color.black)
                            blackCanMove = true;
                        else
                            redCanMove = true;
                        
                    }
                }
            }
        }
        
        if(redCanMove && !blackCanMove) {
            return "Red wins since Black can make no more moves!";
        }
        else if(blackCanMove && !redCanMove) {
            return "Black wins since Red can make no more moves!";
        }
        else if(!redCanMove && !blackCanMove) {
            return "Neither side can make a move!";
        }
        
        //None of the above cases hold true, so the game is not over yet
        return null;
    }
    
    
    // Switch turns at the end of the current player's turn 
    public void endTurn() {
        if(currentTurn == Color.BLACK) {
            currentTurn = Color.RED;
            //If the turn was last black then it becomes red's turn.
        }
        else {
            currentTurn = Color.BLACK;
            //Vice versa.
        }
    }
    
    // End the game and start anew by resetting everything on the board.
    public void restartGame() {
        
        frame.setVisible(false);
        selectedSquare = null;
        
        frame.remove(boardpanel);
        boardpanel = new JPanel(new GridLayout(8, 8));
        boardpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        board = new Board();
        board.placeStartingPieces();
        
        addBoardToPanel(board, boardpanel);
        frame.add(boardpanel, 0);
        
        redCheckersLeft = 12;
        blackCheckersLeft = 12;
        
        currentTurn = Color.BLACK;
        
        updateStatus();
        frame.pack();
        frame.setVisible(true);
        
    }
    
    
    //This allows the entire class to run.
    public static void main(String[] args) {
        new UnlimitedMode();
    }

    

}

