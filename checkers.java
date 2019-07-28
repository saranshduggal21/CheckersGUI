/**
 * I am coding checkers using the Java Language.
 *
 * @author (Saransh Duggal)
 * @version (January 14th, 2019)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;//This is a library that is an abstract representation of a file and directory pathnames.
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;//Used for the processing and playback of samples audio data.
public class checkers extends JFrame implements ActionListener 
{
    JTextField jTextField1;//These are 2 global variables in order to be used in more than 1 method.
     JPasswordField jPasswordField1;
    public static void main (String args [])//Main method.
    {
         File f = new File ("Music.wav");//Declaring a new object for the music file.
        sound (f);//Method for the music to play.
        checkers content = new checkers ();//Declaring an object of the class.
        content.setSize(650,500);//Size of the page.
        content.setLocation (100,100);//Location of the page
        content.setVisible (true);//The page is now visible on the screen.
        
}//Main ends.
    public static void sound (File f)//My sound/music method for the music to play.
    {
        try {
            Clip C = AudioSystem.getClip();//Declaring object for the music file to store in.
            C.open (AudioSystem.getAudioInputStream(f));
            C.start();//The background music will begin here.
            C.loop(Clip.LOOP_CONTINUOUSLY);//This will loop the background music.
            Options content = new Options ();//This is to link my music to my options page.
            //This is in order to toggle music settings (mute, play, etc.).
            content.close(C);
            content.setVisible (false);
            //content.dispose ();
}
catch (Exception error) {
    System.out.println ("File not found.");
    //This is only when the music file is not found. 
    //However, the only reason a catch is included is because of the try.
}
}//Sound method ends.
public checkers()//My constructor where the elements of the GUI take place. 
{

        JPanel jPanel1 = new JPanel();//A new panel within my frame.
        JLabel jLabel1 = new JLabel();//Adding a JLabel (text) to my panel.
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel5 = new JLabel();
        jTextField1 = new JTextField();//This TextField is for the user to enter the username.
        JLabel jLabel4 = new JLabel();
        jPasswordField1 = new JPasswordField();//A passwordfield is idealy used for a password.
        //This gives the game a more professional look.
        JButton jButton1 = new JButton();//My login button in order to procede in the game.
        JLabel jLabel6 = new JLabel();
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel();

        getContentPane().setLayout(null);

        jPanel1.setBackground(new Color(102, 54, 27));
        //The background colour of the page is brown.
        jPanel1.setLayout(null);
        //I am using null layout within my pages.
        jLabel1.setFont(new Font("Luminari", 0, 72)); //Setting a font and size to my text. 
        jLabel1.setText("CHECKERS");//My frame title is Checkers.
        jPanel1.add(jLabel1);//Adding my title to the panel.
        jLabel1.setBounds(130, 80, 392, 97);
        //This setBounds was used in my project to set size and position of GUI text.

        jLabel2.setFont(new Font("Lucida Sans Typewriter", 0, 16)); 
        jLabel2.setText("Please start by creating a username and password!");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 210, 580, 20);

        jLabel3.setFont(new Font("Lucida Sans Typewriter", 0, 14)); 
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(310, 320, 80, 20);

        jLabel5.setFont(new Font("Lucida Sans Typewriter", 0, 16)); 
        jLabel5.setText("Welcome to Castle of Checkers! ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(180, 180, 310, 20);

        
        jPanel1.add(jTextField1);
        jTextField1.setBounds(410, 280, 130, 26);

        jLabel4.setFont(new Font("Lucida Sans Typewriter", 0, 14)); 
        jLabel4.setText("Username:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(310, 280, 80, 20);
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(410, 320, 130, 26);

        jButton1.setText("LOGIN");//My login button text.
        jButton1.setActionCommand ("login");//Assigning a value to my button.
        jButton1.addActionListener (this);
        jPanel1.add(jButton1);
        jButton1.setBounds(350, 400, 160, 50);

        jLabel6.setIcon(new ImageIcon("xxcastle.png")); 
        //This is the image number 1, that I am using on this page.
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 240, 290, 250);

        jLabel8.setIcon(new ImageIcon("Rook 2.png")); 
        //This is the image number 2, that I am using on this page.
        jPanel1.add(jLabel8);
        jLabel8.setBounds(60, 60, 80, 120);

        jLabel9.setIcon(new ImageIcon("Rook 2.png")); 
        jPanel1.add(jLabel9);
        jLabel9.setBounds(520, 60, 70, 120);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 520);
        //I am also setting bounds on my panel to match it with my frame (650,520).
    }//Constructor ends

    public void actionPerformed (ActionEvent e)
    //This method is called when a button is clicked.
    {
        if (e.getActionCommand().equals ("login"))
        {
            String s = jTextField1.getText();//Storing the values of the username TextField
            String p = jPasswordField1.getText();//Storing the values of the password TextField.
            if (s.equals("CSClass") && p.equals ("CookitCS"))
            //Only if the username and password enters matches the ones I provided, the game will proceed.
            {
                MainMenu m = new MainMenu ();//Calls the main menu class.
                m.setVisible (true);//Allows the main menu page to show itself on the screen.
                this.setVisible (false);//Sets the login page false (disappears).
            }
            else
            {
                JOptionPane.showMessageDialog (this,"Please enter the correct login information.");
                //If the login information is incorrect, a pop-up shows with the following text.
            }
            
    }
    }//actionPerformed ends
 protected static ImageIcon createImageIcon(String path)
 //This is the method that allow for the image to run and show in the page.
 {
    java.net.URL url = checkers.class.getResource(path);
    if (url != null) {
      return new ImageIcon(url);
    } else {
      System.out.println("Could not find \"" + path + "\"");
      return null;
    }
  }
}//Class ends


     
