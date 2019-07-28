
/**
 * I am coding checkers using the Java Language.
 *
 * @author (Saransh Duggal)
 * @version (January 14th, 2019)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Play extends JFrame implements ActionListener
//Class starts
{
  
public Play()//Constructor begins

{
    JPanel jPanel1 = new JPanel();//creating a panel
        JLabel jLabel1 = new JLabel();//Adding text to my panel.
        JLabel jLabel3 = new JLabel();
        JButton jButton4 = new JButton();//Adding a button to my panel.
        JButton jButton5 = new JButton();
        JLabel jLabel2 = new JLabel();
        JButton jButton1 = new JButton();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JButton jButton6 = new JButton();

        setBackground(new Color(0, 0, 0));
        //My frame background colour is black.
        jPanel1.setBackground(new Color(0, 0, 0));
        //My panel background colour is black.
        jPanel1.setLayout(null);
        //I am using null layout.
        jLabel1.setBackground(new Color(0, 0, 0));
        jLabel1.setFont(new Font("Lucida Grande", 0, 48)); 
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("♔♔【﻿ＰＬＡＹ】♔♔");//Title
        jPanel1.add(jLabel1);
        jLabel1.setBounds(90, 10, 490, 40);

        jLabel3.setIcon(new ImageIcon("Checkers piece.png")); 
        //Image
        jPanel1.add(jLabel3);
        jLabel3.setBounds(140, 120, 360, 320);

        jButton4.setText("Unlimited Mode");
        //Game mode number 1
        jButton4.setActionCommand ("unlimitedMode");
        jButton4.addActionListener (this);
        jPanel1.add(jButton4);
        jButton4.setBounds(10, 200, 120, 60);

        jButton5.setText("Timed Mode");
        //Game mode number 2
        jButton5.setActionCommand ("timedMode");
        jButton5.addActionListener (this);
        jPanel1.add(jButton5);
        jButton5.setBounds(510, 200, 130, 60);

        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Please choose one of the following Game Modes to begin playing!");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 70, 430, 16);

        jButton1.setText("Main Menu");
        jButton1.setActionCommand ("mainM");
        jButton1.addActionListener (this);
        jPanel1.add(jButton1);
        jButton1.setBounds(90, 450, 140, 40);

        jLabel4.setIcon(new ImageIcon("Checkers Small.png")); 
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 10, 60, 50);

        jLabel5.setIcon(new ImageIcon("Checkers Small.png")); 
        jPanel1.add(jLabel5);
        jLabel5.setBounds(580, 10, 60, 50);

        jButton6.setText("Instructions");
        jButton6.setActionCommand ("instructions");
        jButton6.addActionListener (this);
        jPanel1.add(jButton6);
        jButton6.setBounds(420, 450, 140, 40);

        
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 500);

        
        setSize (650,515);
        //Frame size
        setLocation (100,100);
        setVisible (true);
    }//Constructor ends.

        public void actionPerformed (ActionEvent e)//Action Performed begins.
    {
        if (e.getActionCommand().equals ("mainM"))
        {
         MainMenu m = new MainMenu ();
         m.setVisible (true);
         this.setVisible (false);   
         this.dispose();
         //Calls the MainMenu class when the button Main Menu is pressed.
    }
       else if (e.getActionCommand().equals ("instructions"))
        {
            Instructions2 i = new Instructions2 ();
            i.setVisible (true);
            this.setVisible (false);
            this.dispose();
            //Calls the Instructions2 class when the Instructions button is pressed.
    }
    else if (e.getActionCommand().equals ("unlimitedMode"))
    {
        UnlimitedMode u = new UnlimitedMode ();
        this.setVisible (false);
        this.dispose();
        //Calls the UnlimitedMode class when the Unlimited Mode button is pressed.
    }
    else if (e.getActionCommand().equals ("timedMode"))
    {
       TimedMode t = new TimedMode ();
       this.setVisible (false);
       this.dispose();
       //Calls the TimedMode class when the Timed Mode button is pressed.
}
}//ActionPerformed ends.
    protected static ImageIcon createImageIcon(String path) {
    java.net.URL url = Play.class.getResource(path);
    if (url != null) {
      return new ImageIcon(url);
    } else {
      System.out.println("Could not find \"" + path + "\"");
      return null;
    }
  }
}

