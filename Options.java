
/**
 * I am coding checkers using the Java Language.
 *
 * @author (Saransh Duggal)
 * @version (January 14th, 2019)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;//The following 3 libraries are music libraries
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Options extends JFrame implements ActionListener
//Class begins
{
        static Clip D;
        public static void main (String args [])
        {
            Options content = new Options ();
        }
    public static void close (Clip C)//This is being used in order to control music features
    //This includes, muting, playing music, etc.
    {
        D=C;
    }
    public Options()//Constructor begins
    {
        JPanel jPanel1 = new JPanel();//Creating a new JPanel
        JLabel jLabel1 = new JLabel();//Adding text to my screen
        JLabel jLabel2 = new JLabel();
        JRadioButton jRadioButton1 = new JRadioButton();
        //This is a radio buttonn that will allow the user to choose if they want to mute or unmute the music.
        JRadioButton jRadioButton2 = new JRadioButton();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JButton jButton1 = new JButton();

        getContentPane().setLayout(null);

        jPanel1.setBackground(new Color(0, 0, 0));
        //The background colour of my panel is black.
        jPanel1.setForeground(new Color(255, 255, 255));
        //All my text colour is white.
        jPanel1.setLayout(null);
        //I am using null layout.
        jLabel1.setIcon(new ImageIcon("Checkers piece.png")); 
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 60, 440, 410);

        jLabel2.setFont(new Font("Lucida Grande", 0, 29)); 
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("▀▄▀▄▀▄ OPTIONS ▄▀▄▀▄▀");//My title
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 20, 650, 41);

        jRadioButton1.setFont(new Font("Lucida Grande", 0, 16)); 
        jRadioButton1.setForeground(new Color(255, 255, 255));
        jRadioButton1.setText("MUTE");//RadioButton #1
        jRadioButton1.setActionCommand("mute");
        jRadioButton1.addActionListener(this);
        jRadioButton1.setMnemonic(KeyEvent.VK_S);
        //This line allows the user to only choose one of the 2 radio buttons at a time.
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(460, 260, 90, 25);

        jRadioButton2.setFont(new Font("Lucida Grande", 0, 16)); 
        jRadioButton2.setForeground(new Color(255, 255, 255));
        jRadioButton2.setText("UNMUTE");//RadioButton #2
        jRadioButton2.setActionCommand("play");
        jRadioButton2.addActionListener(this);
        jRadioButton2.setMnemonic(KeyEvent.VK_S);
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(460, 220, 110, 25);

        jLabel3.setFont(new Font("Lucida Grande", 0, 12)); 
        jLabel3.setForeground(new Color(255, 255, 255));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 160, 0, 0);

        jLabel5.setFont(new Font("Lucida Grande", 0, 28)); 
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setText("MUSIC SETTINGS");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(390, 170, 240, 30);

        jButton1.setFont(new Font("Lucida Grande", 0, 16)); 
        jButton1.setText("MAIN MENU");
        jButton1.setActionCommand("main");
        jButton1.addActionListener(this);
        jPanel1.add(jButton1);
        jButton1.setBounds(410, 340, 170, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 682, 502);
        
        ButtonGroup B = new ButtonGroup();
        B.add(jRadioButton1);
        B.add(jRadioButton2);
        //A button group will carry my instances of the radio buttons.
        setSize (650,500);
        //My panel size is 650,500.
        setLocation (100,100);
        setVisible (true);
    }//Constructor ends
            public void actionPerformed (ActionEvent e)//ActionPerformed begins
    {
         if (e.getActionCommand().equals ("main"))
        {
         MainMenu m = new MainMenu ();
         m.setVisible (true);
         this.setVisible (false);  
         //The MainMenu class is called when the main menu button is pressed.
    }
    else if (e.getActionCommand().equals ("mute"))
    {
            D.stop();          
            //This will stop playing the music.
}


else if (e.getActionCommand().equals ("play"))
{
    D.start();
    D.loop(Clip.LOOP_CONTINUOUSLY);
    //This will start playing the music (where it left off) and loop it as well.
}
}//ActionPerformed ends

    protected static ImageIcon createImageIcon(String path) {
    java.net.URL url = Options.class.getResource(path);
    if (url != null) {
      return new ImageIcon(url);
    } else {
      System.out.println("Could not find \"" + path + "\"");
      return null;
    }
  }
    }

