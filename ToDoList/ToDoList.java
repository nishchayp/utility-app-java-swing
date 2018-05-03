import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

/*
<applet code="ToDoList" WIDTH=550 HEIGHT=520>
</applet>
*/

public class ToDoList extends JApplet{
	JButton add;
	JButton del;
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4=new JTextField("Enter Serial no. to delete");
	JTable jt;
	String[][] data=new String[15][4];
	String[] titles={"Sl.no","Title","Description","Date"};
	int i=-1;


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
	       setLayout(new FlowLayout());

	       add=new JButton("Add a task");
	       del=new JButton("Delete a task");
	       tf1=new JTextField("Enter Title",10);
	       tf2=new JTextField("Enter Description",10);
	       tf3=new JTextField("Enter Date",10);
	       


	       add.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	            i++;
	            data[i][0]=String.format("%d",i);
	            data[i][1]=tf1.getText();
	            data[i][2]=tf2.getText();
	            data[i][3]=tf3.getText();
	            repaint();
	         }
	       });
	       del.addActionListener(new ActionListener(){
	       	  public void actionPerformed(ActionEvent e){
	       	  	
	       	  	
	       	  	int j=Integer.parseInt(tf4.getText());
	       	  	data[j][0]="";
	       	  	data[j][1]="";
	       	  	data[j][2]="";
	       	  	data[j][3]="";
	       	  	i--;
	       	  	repaint();
	       	  }
	       });
	       jt=new JTable(data,titles);
	       JScrollPane jsp=new JScrollPane(jt);
	       add(add);
	       add(tf1);
	       add(tf2);
	       add(tf3);
	       add(jsp);
	       add(del);
	       add(tf4);
	   }

	   }