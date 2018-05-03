import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.applet.*;
import java.io.*;
/*
<Applet Code="HandCricket" WIDTH=500 HEIGHT=300>
</Applet>
*/

public class HandCricket extends JApplet{
  int scr=0,wck=0,trgt=0,bls=0,rn=0,rn2=0,rnd=0,f1=0,f2=0;
  JLabel sc,wk,bl,ji1,ji2,tgt,st;
  JPasswordField tf1,tf2;
  JButton op,tp,newg,hit;
  Image i1,i2;
  boolean s1=true,set1=false,set2=false,set3=false;
  AudioClip sound1,sound2;

  public void init(){
  try {
              SwingUtilities.invokeAndWait(new Runnable(){
                public void run(){
                    GUI();
                }
              });
              }
              catch(Exception E){}
  }
  private void GUI(){
    setLayout(null);
    newg=new JButton("New game");
    op=new JButton("One Player");
    tp=new JButton("Two Player");

    op.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        op.setVisible(false);
                tp.setVisible(false);repaint();
                GUI1();


      } 
          });
    tp.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        GUI2();
        f1=1;
        op.setVisible(false);
                tp.setVisible(false);repaint();
      } 
          });
    newg.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        remove(tf1);repaint();remove(ji1);repaint();
        remove(sc);repaint();remove(ji2);repaint();
        remove(wk);repaint();remove(tgt);repaint();
        remove(bl);repaint();remove(st);repaint();
        remove(hit);repaint();
        if(f1==1){
          remove(tf2);repaint();
        }
        f1=0;
        GUI();
        repaint();
      }
    });

       op.setBounds(10,50,150,25);
       tp.setBounds(10,80,150,25);
       
       newg.setBounds(10,200,150,25);
       add(op);
       add(tp);
       add(newg);


  }
    
  private void GUI2(){
      setLayout(null);
      scr=rn=rn2=wck=bls=0;
     tf1=new JPasswordField("",10);
     tf2=new JPasswordField("",10);
     st=new JLabel("Player1 Batting ");
     tf1.setEchoChar('*');
     tf2.setEchoChar('*');     
     i1=getImage(getCodeBase(),"3.jpg");
       ImageIcon icon1=new ImageIcon(i1);
       ji1=new JLabel(icon1);
       i2=getImage(getCodeBase(),"4.jpg");
       ImageIcon icon2=new ImageIcon(i2);
       ji2=new JLabel(icon2);
     Random r=new Random();
     hit=new JButton("Hit");
     sc=new JLabel("Score :"+scr);
     tgt=new JLabel("Target : "+trgt);
     sound1=getAudioClip(getCodeBase(),"2.wav");
     sound2=getAudioClip(getCodeBase(),"3.wav");


       wk=new JLabel("Wickets :"+wck);

       bl=new JLabel("Ball :"+bls);
       ji1.setBounds(600,20,300,300);
       ji2.setBounds(600,20,300,300);

     
     
       hit.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                
            
             label: {
              if(wck<10){
                 rn=Integer.parseInt(new String(tf1.getPassword()));
                 rn2=Integer.parseInt(new String(tf2.getPassword()));
                 if(rn>6||rn2>6){
                  tf1.setText("Invalid entry");
                  tf2.setText("invalid entry");
                  break label;
                 }
                 tf1.setText("");
                 tf2.setText("");
                 if(f2==0){
                 if(rn!=rn2)
                 {
                       scr+=rn;
                       bls++;
                       set2=false;
                 }
                 else{
                      wck++;
                      bls++;
                      scr=scr;
                      set2=true;
                      sound2.play();
                                           }
                 if(scr!=0&&scr%50==0){
                    
                    set1=true;
                    sound1.play();                 }
                 else
                  {
                    set1=false;
                    }
                  }
                  else{
                    if(rn!=rn2)
                 {
                       scr+=rn2;
                       bls++;
                       set2=false;
                 }
                 else{
                      wck++;
                      bls++;
                      scr=scr;
                      set2=true;
                      sound2.play();
                                           }
                 if(scr!=0&&scr%50==0){
                    
                    set1=true;
                    sound1.play();                 }
                 else
                  {
                    set1=false;
                    }
                  }
                 }
              if(wck==10){
                  wck=0;
                  bls=0;
                  if(trgt==0){
                    trgt=scr;
                    scr=0;
                    f2=1;
                    st.setText("Player 2 Batting");
                    set3=true;
                  }
                  else{
                    if(scr>trgt)
                      st.setText("Player 2 wins");
                    else
                      st.setText("Player 2 wins");
                    set1=true;

                  }

                }
                if(f2==1&&scr>trgt){
                st.setText("Player2 Wins");
                set1=true;
               }

             
                 tgt.setText("Target "+trgt);
                 sc.setText("Score: "+scr);
                 wk.setText("Wickets :"+wck);
                 bl.setText("Balls :"+bls);
                 ji1.setVisible(set1);
                 ji2.setVisible(set2);
                 tgt.setVisible(set3);
                 repaint();
               }
             }
       });
       
       
       tf1.setBounds(10,20,150,25);
       tf2.setBounds(200,20,150,25);
       sc.setBounds(10,50,80,25);
       wk.setBounds(10,80,80,25);
       bl.setBounds(10,110,80,25);
       hit.setBounds(10,140,80,25);
       st.setBounds(10,250,150,100);
       tgt.setBounds(400,20,80,25);
       add(tgt);
       add(tf1);
       add(sc);
       add(wk);
       add(bl);
       add(hit);
       add(ji1);
       add(ji2);
       add(tf2);
       add(st);
       tgt.setVisible(set3);
       ji1.setVisible(false);
       ji2.setVisible(false);
       repaint();
       
       
  }
  private void GUI1(){
      setLayout(null);
      scr=rn=rn2=wck=bls=0;
     tf1=new JPasswordField("Enter your run here",10);
     st=new JLabel("You're batting");
     tf1.setEchoChar((char)0);
     i1=getImage(getCodeBase(),"3.jpg");
       ImageIcon icon1=new ImageIcon(i1);
       ji1=new JLabel(icon1);
       i2=getImage(getCodeBase(),"4.jpg");
       ImageIcon icon2=new ImageIcon(i2);
       ji2=new JLabel(icon2);
     Random r=new Random();
     hit=new JButton("Hit");
     sc=new JLabel("Score :"+scr);
     sound1=getAudioClip(getCodeBase(),"2.wav");
     sound2=getAudioClip(getCodeBase(),"3.wav");
     tgt=new JLabel("Target : "+trgt);       
       wk=new JLabel("Wickets : "+wck);
       bl=new JLabel("Ball :"+bls);
       ji1.setBounds(600,20,300,300);
       ji2.setBounds(600,20,300,300);

       tf1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          tf1.setText("");
        }
       });
     
       hit.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
            label:{    if(wck!=10){
                 rn=Integer.parseInt(new String(tf1.getPassword()));
                 tf1.setText("");
                 if(rn>6){
                  tf1.setText("Invalid entry");
                  break label;
                 }
                 
                 if(f2==0){
                  rnd=r.nextInt(7);
                  
                 if(rn!=rnd)
                 {
                       scr+=rn;
                       bls++;
                       set2=false;
                 }
                 else{
                      wck++;
                      bls++;
                      scr=scr;
                      set2=true;
                      sound2.play();
                                           }
                 if(scr!=0&&scr%50==0){
                    
                    set1=true;
                    sound1.play();                 }
                 else
                  {
                    set1=false;
                    }
                }
                else{
                  rnd=r.nextInt(7);
                  
                  if(rn!=rnd)
                 {
                       scr+=rnd;
                       bls++;
                       set2=false;
                 }
                 else{
                      wck++;
                      bls++;
                      scr=scr;
                      set2=true;
                      sound2.play();
                                           }
                 if(scr!=0&&scr%50==0){
                    
                    set1=true;
                    sound1.play();                 }
                 else
                  {
                    set1=false;
                    }
                }
            }
                if(wck==10){
                  wck=0;
                  bls=0;
                  if(trgt==0){
                    trgt=scr;
                    scr=0;
                    f2=1;
                    st.setText("You're Bowling");
                    set3=true;
                  }
                  else{
                    if(scr>trgt)
                      st.setText("You have lost");
                    else
                      st.setText("You have won");

                  }

                }
               if(f2==1&&scr>trgt){
                st.setText("You have lost");
                set1=true;
                sound1.play();
           }
                tgt.setText("Target "+trgt);
                sc.setText("Score: "+scr);
                 wk.setText("Wickets :"+wck);
                 bl.setText("Balls :"+bls);
                 ji1.setVisible(set1);
                 ji2.setVisible(set2);
                 tgt.setVisible(set3);
                 repaint();
           }
       }
       });
       
       
       tf1.setBounds(10,20,150,25);
       sc.setBounds(10,50,80,25);
       wk.setBounds(10,80,80,25);
       bl.setBounds(10,110,80,25);
       hit.setBounds(10,140,80,25);
       st.setBounds(10,250,150,100);
       tgt.setBounds(400,20,80,25);
       add(st);
       add(tf1);
       add(sc);
       add(wk);
       add(bl);
       add(hit);
       add(ji1);
       add(ji2);
       add(tgt);
       tgt.setVisible(set3);
       ji1.setVisible(false);
       ji2.setVisible(false);
       repaint();
       
       
  }
  
}
