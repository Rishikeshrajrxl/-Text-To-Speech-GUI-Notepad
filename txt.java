
        //BASIC NOTEPAD WITH FEATURES TO CONVERT TEXT-TO-SPEECH

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sun.speech.freetts.*;
import java.io.*;


public class txt 
{
     static JFrame f=new JFrame();
     static JMenuItem copy=new JMenuItem("Copy");
     static JMenuItem cut=new JMenuItem("Cut");
     static JMenuItem selectall=new JMenuItem("SelectAll");
     static JMenuItem option=new JMenuItem("Option"); 
     static JMenuItem paste=new JMenuItem("Paste");
     static JMenuItem save=new JMenuItem("Save");
     static JMenuItem saveAll=new JMenuItem("SaveAll");
     static JTextArea txt=new JTextArea();
     static JMenuBar mb=new JMenuBar();
     static JScrollBar sb=new JScrollBar();
     static JMenu File=new JMenu("File");
     static JMenu Edit=new JMenu("Edit");
     static JMenu Help=new JMenu("Help");
     static Container c=f.getContentPane();
     static Cursor cur=new Cursor(Cursor.HAND_CURSOR);
     
     txt()  //CONSTRUCTOR
     {
     
     }
    public static void main(String arg[])
    {
               
     //CREATING OBJECT 
   
     f.setTitle("Notepad");
     
   
     JButton exit=new JButton("Exit");
     JButton speak=new JButton("Speak");
   
     //ADDING TO MENU 
     f.setJMenuBar(mb);
     mb.add(File);
     mb.add(Edit);
     mb.add(Help);
     File.add(save);
     File.add(saveAll);
     File.add(option);
     Edit.add(selectall);
     Edit.add(cut);
     Edit.add(copy);
     Edit.add(paste);
     mb.setCursor(cur);
     speak.setCursor(cur);
     exit.setCursor(cur);
      
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     c.setLayout(null);
     f.setResizable(false);   
     
     //SETTING BOUNDS
     f.setBounds(350,50,700,600);
     txt.setBounds(0,34,675,514);
     speak.setBounds(520,2,70,30);
     exit.setBounds(600,2,70,30);
     sb.setBounds(674,34,20,514);
     f.add(sb);
     f.add(exit);
     f.add(speak);
     c.add(txt);
     
     //SETTING COLORS
     c.setBackground(new Color(70,130,180));
     exit.setBackground(new Color(255,0,0));
     speak.setBackground(Color.red);
     exit.setForeground(Color.white);
     speak.setForeground(Color.white);
     
    //SPEAK BUTTON
     speak.addActionListener( new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent e){
                     
                      Voice voice;
                      VoiceManager vm=VoiceManager.getInstance();
                      voice = vm.getVoice("kevin16");
                      voice.allocate();
                      voice.speak(txt.getText());   
                 }
     });
     //EXIT BUTTON
      exit.addActionListener( new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent e){
                     
                     System.exit(0);
                 }
     });
      //SELECTALL MENU
       selectall.addActionListener( new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent e){
                     
                     txt.selectAll();
                 }
     });
       //CUT MENU
       cut.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent e2)
           {
               txt.cut();
           }
       });  
       //COPY MENU
       copy.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed( ActionEvent e3)
           {
               txt.copy();
           }
       });
       //PASTE MENU
       paste.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent e4)
           {
               txt.paste();
           }
       });
   
  
     f.setVisible(true);
     c.revalidate();
    } 
}
