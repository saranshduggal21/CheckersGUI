
/**
 * I am coding checkers using the Java Language.
 *
 * @author (Saransh Duggal)
 * @version (January 14th, 2019)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Instructions2 extends JFrame implements ActionListener
{

    public Instructions2()//Constructor begins
    {
        JPanel jPanel1 = new JPanel();//Creating a JPanel
        JLabel jLabel2 = new JLabel();//Adding text to the panel
        //This page will have more text than the other pages because there are a lot of instructions.
        JLabel jLabel3 = new JLabel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel14 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel();
        JLabel jLabel10 = new JLabel();
        JLabel jLabel12 = new JLabel();
        JLabel jLabel13 = new JLabel();
        JButton jButton1 = new JButton();//Adding a button to the panel
        JButton jButton2 = new JButton();
        JLabel jLabel15 = new JLabel();
        JLabel jLabel16 = new JLabel();
        JLabel jLabel17 = new JLabel();
        JLabel jLabel18 = new JLabel();
        JLabel jLabel19 = new JLabel();
        JLabel jLabel20 = new JLabel();

        setBackground(new Color(0, 0, 0));
        //My frame background colour is black.
        getContentPane().setLayout(null);
        
        jPanel1.setBackground(new Color(0, 0, 0));
        jPanel1.setForeground(new Color(255, 255, 255));
        jPanel1.setLayout(null);
        //I am utilizing null layout
        jLabel2.setFont(new Font("Lucida Grande", 0, 25)); 
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("▀▄▀▄▀▄ ⒾⓃⓈⓉⓇⓊⒸⓉⒾⓄⓃⓈ ▄▀▄▀▄▀");//Title of page
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 10, 640, 70);

        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("Instructions for Checkers:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(400, 80, 180, 30);

        jLabel1.setIcon(new ImageIcon("/Users/user/Desktop/Screen Shot 2019-01-05 at 7.52.22 PM.png"));
        //Image
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 80, 380, 380);

        jLabel14.setForeground(new Color(255, 255, 255));
        jLabel14.setText("1. 2 players required to play this game.");
        //This is where the set of instructions begin.
        jPanel1.add(jLabel14);
        jLabel14.setBounds(390, 100, 250, 30);

        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setText(" is diagonally 1 box ahead. ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(400, 180, 240, 30);

        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setText("Instructions for Unlimited Mode:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(400, 350, 210, 30);

        jLabel8.setForeground(new Color(255, 255, 255));
        jLabel8.setText("2. This mode is not timed. ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(390, 400, 220, 20);

        jLabel9.setForeground(new Color(255, 255, 255));
        jLabel9.setText("1. Normal rules for Checkers apply.");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(390, 380, 250, 20);

        jLabel10.setForeground(new Color(255, 255, 255));
        jLabel10.setText("Instructions for Timed Mode:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(400, 270, 190, 20);

        jLabel12.setForeground(new Color(255, 255, 255));
        jLabel12.setText("1. There is a 30 min timer for this mode.");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(390, 300, 270, 20);

        jLabel13.setForeground(new Color(255, 255, 255));
        jLabel13.setText("2. Normal rules for Checkers apply.");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(390, 320, 250, 20);

        jButton1.setText("Play Checkers!");
        //Button #1
        jButton1.setActionCommand("play");
        jButton1.addActionListener(this);
        jPanel1.add(jButton1);
        jButton1.setBounds(520, 430, 120, 40);

        jButton2.setText("MAIN MENU");
        //Button #2
        jButton2.setActionCommand("mainmenu");
        jButton2.addActionListener(this);
        //Assigning a value to the button so when its pressed an action is performed
        jPanel1.add(jButton2);
        jButton2.setBounds(390, 430, 130, 40);

        jLabel15.setForeground(new Color(255, 255, 255));
        jLabel15.setText("2. 1 piece can be moved in one turn.");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(390, 120, 240, 30);

        jLabel16.setForeground(new Color(255, 255, 255));
        jLabel16.setText("3. Pieces can only move diagonally. ");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(390, 140, 240, 30);

        jLabel17.setForeground(new Color(255, 255, 255));
        jLabel17.setText("you still win.");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(410, 240, 300, 30);

        jLabel18.setForeground(new Color(255, 255, 255));
        jLabel18.setText("4. A piece is killed when the piece ");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(390, 160, 240, 30);

        jLabel19.setForeground(new Color(255, 255, 255));
        jLabel19.setText("5. To win, kill all of opponent's pieces.");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(390, 200, 300, 30);

        jLabel20.setForeground(new Color(255, 255, 255));
        jLabel20.setText("6. If opponent has no valid moves left, ");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(390, 220, 300, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 480);

      setSize (650,500);
      //Frame size
       setLocation (100,100);
       setVisible (true);
    }//Constructor ends
    public void actionPerformed (ActionEvent e)//ActionPerformed begins
    {
        if (e.getActionCommand().equals ("mainmenu"))
        {
         MainMenu m = new MainMenu ();
         m.setVisible (true);
         this.setVisible (false);  
         this.dispose();
         //Calls the MainMenu class when the button Main Menu is pressed.
    }
    else if (e.getActionCommand().equals ("play"))
    {
        Play p = new Play ();
        p.setVisible (true);
        this.setVisible (false); 
        this.dispose();
        //Calls the Play class when the button Play Checkers is pressed.
    }
    }//ActionPerformed ends

    protected static ImageIcon createImageIcon(String path) {
    java.net.URL url = Instructions2.class.getResource(path);
    if (url != null) {
      return new ImageIcon(url);
    } else {
      System.out.println("Could not find \"" + path + "\"");
      return null;
    }
  }
    }

