
/**
 * I am coding checkers using the Java Language.
 *
 * @author (Saransh Duggal)
 * @version (January 14th, 2019)
 */
import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import java.awt.event.*;

public class TimedMode implements MouseListener,ActionListener {
//Since the only difference between the timed mode and unlimited mode is the timer,
//I have commented only the timer related things in the this class.
//Everything else is pretty much the same so please view the UnlimitedMode class for more detailed comments on the rest of the code.
//However, there are basic comments, throughout this code as well to give an idea of what is happening.
static int mn = 0;
    Timer t;
    //both of the variables above are global, which can be used in various methods.
    //This will be needed in order to incorporate a timer.
    
    public JFrame frame;
    // The frame that will serve to holds the contents of our game 
   
    public JPanel boardpanel;
     // The panel that will hold our Board 
    
    public JLabel piecesLabel;
    // The label that will keep track of remaining pieces for each side 
    
    public JMenuBar menubar;
    // Menubar containing Exit and New Game options 
    public JLabel jLabel1;
    
    
    public JMenu fileMenu;
    // File menu 
    
    public JMenuItem newGame;
    // New Game menu item 
    
    public JMenuItem exit;
    // Exit menu item 
    
    public Color currentTurn;
    // Keep track of the current turn 
   
    public final int borderWidth = 1;
     // Border width between squares in the game board 
    
    public Board board;
    // The board which will store our game's state 
    
    public int blackCheckersLeft;
    // The number of checkers remaining for Black side 
   
    public int redCheckersLeft;
    // The number of checkers remaining for Red side 
    
    public Square selectedSquare;
    // Hold a reference to the currently selected Piece 
    
    
    // Constructor takes no arguments and forms a new game 
    public TimedMode() 
    {
        t = new Timer (1000,new ActionListener()
        //1000 is delay (it 1000 nanosec or 1 sec)
        //This timer fires an ActionEvent once per second.
        //ActionListener specifies a listerner I would like to implement.
        //Thus the ActionListener recieves the timers ActionEvents.
        {
            private long time = 1800 * 1000;
            //Since I would like 30 miniutes, which is 1800 seconds.
            //1800 seconds HAS to be converted to nanoseconds (x1000).
            //Long is a data type which has a higher range because it uses 64 bits.
            //It is a non-primitive type.
            //We need the higher range here because we are working with big numbers.
            public void actionPerformed (ActionEvent e)//ActionEvent begins.
            {
               if (time>=0)
               //This will continue going until the timer hits 0.
             {
                 Long d = time;
                 time = time - 1000;
                 Long min = d/60000;
                 Long sec = d%60000;
                 sec = sec/1000;
                 String m = Long.toString(min);
                 String s = Long.toString(sec);
                 String timer = m + ":" + s;
                 frame.setTitle ("Time left to play Checkers - " + timer);
                 //Amount of time left to play checkers is displayed at the top.
                }
                else 
                //Once the timer his 0, it does the actions below.
                {
                 JOptionPane.showMessageDialog (frame,"Your game is over.");
                 //((Timer)z.getSource()).stop();
                 t.stop();
                 MainMenu m = new MainMenu ();
                 m.setVisible (true);
                 frame.setVisible (false);  
                 //This occurs when the timer hits 0.
                 //The user is led back to the Main Menu page.
                 frame.dispose();
                }
               
            }
        });
        t.setInitialDelay (0);
        //There will be no delay in the timer, which is why there is a delay of 0 seconds.
        t.start();
        //This start the timer.
    
        //display the interface
        CreateAndShowGUI();
        
        //set the initial turn
        currentTurn = Color.GREEN;
        
        //initial values for checkers
        redCheckersLeft = 12;
        blackCheckersLeft = 12;
        
        //show how many checkers are left
        updateStatus();
        

    }
    
    // Below is what is neccassary to set up the visual interface to the game 
    
    public void CreateAndShowGUI() {
        
        //Set up the window information
        frame = new JFrame("Checkers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        
        frame.getContentPane().setLayout(
                new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        //Give our Board a visual representation
        boardpanel = new JPanel(new GridLayout(8, 8));
        boardpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        board = new Board();
        board.placeStartingPieces();
        
        //Keep track of how many pieces are left
        piecesLabel = new JLabel(" ");
        piecesLabel.setHorizontalTextPosition(JLabel.LEFT);
        piecesLabel.setVerticalTextPosition(JLabel.BOTTOM);
        
        //Add the menubar to the window
        menubar = new JMenuBar();
        fileMenu = new JMenu("PAUSE");
        
        newGame = new JMenuItem("New Game");
        newGame.addActionListener(this);
        
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        
        fileMenu.add(newGame);
        fileMenu.add(exit);
        menubar.add(fileMenu);
        
        //Add our board to boardpanel and add everything to the window
        addBoardToPanel(board, boardpanel);
        frame.add(boardpanel);
        frame.add(piecesLabel);
        frame.setJMenuBar(menubar);
        frame.pack();
        
        //Resize the frame because for some reason it wants to cut off the last character of our JLabel
        Rectangle boundingRect = frame.getBounds();
        frame.setBounds(boundingRect.x, boundingRect.y, boundingRect.width + 5, boundingRect.height);
        
        frame.setVisible(true);


    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        

        Square sel = (Square)e.getComponent();
        
        //Ensure that the correct color Piece has been chosen
        //The Piece's color should be equal to currentTurn, unless this is the first move
        //in which case currentTurn is going to be Color.GREEN
        if(sel.isOccupied()) 
            if(sel.getOccupant().getColor() != currentTurn &&
                currentTurn != Color.GREEN) {
            JOptionPane.showMessageDialog (frame,"Not possible, please make an appropriate move.");
            return;
        }
        

        if(sel.isOccupied() && selectedSquare == null) {
            //There is currently no square selected, so highlight all possible moves
            selectedSquare = sel;
            selectedSquare.setHighlight(true);
            board.setMovesHighlighted(selectedSquare.getOccupant(), true);
            return;
            
        }
        
        
        
        
        else if(sel.isOccupied() && !sel.equals(selectedSquare)) {
            //The user has clicked on a different Piece than the one currently selected
            selectedSquare.setHighlight(false);
            board.setMovesHighlighted(selectedSquare.getOccupant(), false);
            
            //Reset selectedSquare to the one currently under the cursor
            selectedSquare = sel;
            selectedSquare.setHighlight(true);
            board.setMovesHighlighted(selectedSquare.getOccupant(), true);
            return;
            
        }
        
        
        else if(sel.equals(selectedSquare)) {
            //The user has deselected the current square
            selectedSquare.setHighlight(false);
            board.setMovesHighlighted(selectedSquare.getOccupant(), false);
            selectedSquare = null;
        }
        
        


        else if(!sel.isOccupied() && selectedSquare != null) {
            //The user is trying to make a move by moving from the selectedSquare to the one they just clicked
            //First check to see if their choice corresponds to a square in possibleMoves
            
            boolean found = false;
            boolean jumped = false;
            
            Vector<Square> oldPossibleMoves = board.getPossibleMoves(selectedSquare.getOccupant());
            
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
                    //When a piece has been killed.
                    //Computer has to identify which coloured piece has been killed.
                    if(currentTurn == Color.BLACK) {
                        redCheckersLeft--;
                    }
                    else {
                        blackCheckersLeft--;
                    }
                    
                }
                
                //Unhighlight the moves from the Piece's previous position
                selectedSquare.setHighlight(false);
                for (Square unhighlight : oldPossibleMoves)
                    unhighlight.setHighlight(false);
                selectedSquare = null;
                
                endTurn();
                //Update the number of checkers left
                updateStatus();
                
                
                //See if that move ended the game
                String winningStr = winner();
                if(winningStr != null) {
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
                //Tell the user that they cannot make the move they would like to make.
                JOptionPane.showMessageDialog (frame,"Not possible, please make an appropriate move.");
        }

    }

    //Must implement as per MouseListener
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    
    
    @Override
    /** Perform the appropriate action when a menu item is clicked */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newGame) {
            restartGame();
            //Calls the restartGame method and resets the score and pieces on the board.
        }
        else if(e.getSource() == exit) {
            frame.setVisible(false);
            frame.dispose();
            MainMenu m = new MainMenu ();
            m.setVisible (true);
            //Leads the user back to the Main Menu.
            //Calls the MainMenu class when the Exit button is pressed.
        }
        
    }
    
    // Add the Board to a Panel to create the appearance of a checkerboard.
    public void addBoardToPanel(Board b, JPanel p) {
        for(int i = 0; i < 8; i++) {
            //8 squares in a row.
            for(int j = 0; j < 8; j++) {
                //8 squares in a column.
                Square sq = b.getSquare(i, j);
                sq.addMouseListener(this);
                
                JPanel ContainerPanel = new JPanel(new FlowLayout());
                ContainerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,
                                                                                              borderWidth));
                ContainerPanel.add(sq);
                if(sq.getBackgroundColor() == Square.BackgroundColor.DARK)
                    ContainerPanel.setBackground(Color.DARK_GRAY);
                else
                    ContainerPanel.setBackground(Color.LIGHT_GRAY);
                p.add(ContainerPanel);
            }
        }
    }
    
    
    
    // Update the text of piecesLeft to a string representation of the number of pieces left for both sides 
    public void updateStatus() {
        piecesLabel.setText("Red pieces left: " + redCheckersLeft + "             Black pieces left: " + blackCheckersLeft);
    }
    
    
    /** Find out, if the game is over, who won and how that side won
     * 
     * @return              A String containing the side which won, as well as how they won (took other side's pieces, other side could make no more moves)
     */
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
                        //Find out what the color of the piece that can make the move
                        
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
        }
        else {
            currentTurn = Color.BLACK;
        }
    }
    
    // End the game and start anew by resetting everything 
    //This method is called when the User clicks New Game in the menubar.
    public void restartGame() {
        t.stop();
        //This will stop the previous timer running.
        //Now we have to re-initialize the timer when the user wants to restart the game.
        t = new Timer (1000,new ActionListener()
        //1000 is delay (it 1000 nanosec or 1 sec)
        //This timer fires an ActionEvent once per second.
        //ActionListener specifies a listerner I would like to implement.
        //Thus the ActionListener recieves the timers ActionEvents.
        {
            private long time = 1800 * 1000;
            //Since I would like 30 miniutes, which is 1800 seconds.
            //1800 seconds HAS to be converted to nanoseconds (x1000).
            //Long is a data type which has a higher range because it uses 64 bits.
            //It is a non-primitive type.
            //We need the higher range here because we are working with big numbers.
            public void actionPerformed (ActionEvent e)//ActionEvent begins.
            {
               if (time>=0)
               //This will continue going until the timer hits 0.
             {
                 Long d = time;
                 time = time - 1000;
                 Long min = d/60000;
                 Long sec = d%60000;
                 sec = sec/1000;
                 String m = Long.toString(min);
                 String s = Long.toString(sec);
                 String timer = m + ":" + s;
                 frame.setTitle ("Time left to play Checkers - " + timer);
                 //Amount of time left to play checkers is displayed at the top.
                }
                else 
                //Once the timer his 0, it does the actions below.
                {
                 JOptionPane.showMessageDialog (frame,"Your game is over.");
                 //((Timer)z.getSource()).stop();
                 t.stop();
                 MainMenu m = new MainMenu ();
                 m.setVisible (true);
                 frame.setVisible (false);  
                 //This occurs when the timer hits 0.
                 //The user is led back to the Main Menu page.
                 frame.dispose();
                }
               
            }
        });
        t.setInitialDelay (0);
        //There will be no delay in the timer, which is why there is a delay of 0 seconds.
        t.start();
        //This start the timer.
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
    
    
    // Starts the game.
    public static void main(String[] args) {
        new TimedMode();
    }

    

}

