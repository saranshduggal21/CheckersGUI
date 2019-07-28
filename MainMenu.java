
/**
 * I am coding checkers using the Java Language.
 *
 * @author (Saransh Duggal)
 * @version (January 14th, 2019)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainMenu extends JFrame implements ActionListener
//Class begins
{
  
    public MainMenu()//Constructor begins
    {
     JPanel jPanel1 = new JPanel();//Making a new panel.
        JLabel jLabel1 = new JLabel();//Adding a JLabel to the panel.
        JPanel jPanel2 = new JPanel();
        JLabel jLabel2 = new JLabel();
        JButton jButton1 = new JButton();//Adding a JButton to the panel.
        JPanel jPanel3 = new JPanel();
        JLabel jLabel4 = new JLabel();
        JButton jButton5 = new JButton();
        JButton jButton7 = new JButton();
        JButton jButton8 = new JButton();

        setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new Color(0, 0, 0));
        //The background colour of the panel is black.
        jPanel1.setLayout(null);
        //I am using null layout for this page;

        jLabel1.setBackground(new Color(0, 0, 0));
        jLabel1.setFont(new Font("Lucida Grande", 0, 48)); 
        jLabel1.setForeground(new Color(255, 255, 255));
        //My title colour is white.
        jLabel1.setText("♔♔ CHECKERS MAIN MENU ♔♔");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(148, 6, 1000, 66);
         //This is the title of my page.
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 78);

        jPanel2.setBackground(new Color(0, 0, 0));
        jPanel2.setLayout(null);

        jLabel2.setIcon(new ImageIcon("Checkers Main 4.png")); 
        //My image
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 36, 492, 294);

        jButton1.setText("QUIT");
        //My first button
        jButton1.setActionCommand ("quit");
        //Assigning a value to the button so that when its pressed, it triggers an action
        jButton1.addActionListener (this);
        jPanel2.add(jButton1);
        jButton1.setBounds(194, 357, 122, 47);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 84, 504, 423);

        jPanel3.setBackground(new Color(0, 0, 0));
        jPanel3.setLayout(new GridLayout(5, 1, 0, 21));
        //My panel #3 is utilizing grid layout in order to place the buttons
        jLabel4.setFont(new Font("Lucida Grande", 0, 16)); 
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("Please choose one of the following options:");
        jPanel3.add(jLabel4);

        jButton5.setText("PLAY CHECKERS");
        //Button number 2
        jButton5.setActionCommand ("play");
        jButton5.addActionListener (this);
        jPanel3.add(jButton5);
       
        jButton7.setText("OPTIONS");
        //Button number 3
        jButton7.setActionCommand ("options");
        jButton7.addActionListener (this);
        jPanel3.add(jButton7);

        jButton8.setText("INSTRUCTIONS");
        //Button number 4
        jButton8.setActionCommand ("instructions");
        jButton8.addActionListener (this);
        jPanel3.add(jButton8);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(510, 84, 490, 423);
        
       setSize (1000,525);
       //My frame size is 1000,525.
       setLocation (100,100);
       setVisible (true);
        
    }//Constructor ends.
   
    public void actionPerformed (ActionEvent e)
    //actionPerformed begins
    {
        if (e.getActionCommand().equals ("instructions"))
        //This is what happens when the Instructions button is pressed.
        {
            Instructions2 i = new Instructions2 ();
            //My instructions class is called and leads the user to the instructions page.
            i.setVisible (true);
            this.setVisible (false);
            this.dispose();
    }
    else if (e.getActionCommand().equals ("play"))
    //This is what happens when the Play Checkers button is pressed.
    {
        Play p = new Play ();
        //My play class is called and leads the user to the play page.
        p.setVisible (true);
        this.setVisible (false); 
        this.dispose();
    }
    else if (e.getActionCommand().equals ("options"))
    //This is what happens when the Options button is pressed.
    {
        Options o = new Options ();
        //My options class is called and leads the user to the options page.
        o.setVisible (true);
        this.setVisible (false);
        this.dispose();
    }
    else if (e.getActionCommand().equals ("quit"))
    //This is what happens when the Quit button is pressed.
    {
        System.exit(0);
        //The program quits.
    }
}//actionPerformed ends
  protected static ImageIcon createImageIcon(String path) {
    java.net.URL url = MainMenu.class.getResource(path);
    if (url != null) {
      return new ImageIcon(url);
    } else {
      System.out.println("Could not find \"" + path + "\"");
      return null;
    }
  }
}//Class ends
