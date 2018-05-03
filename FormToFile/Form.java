import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class MakeGUI implements ActionListener {
	JLabel status;
	JButton submit;
	JButton print;

	String[] tableHeadings = {"Name", "Reg. No.", "Comp. No.", "Date & Time"};
	String[][] data = new String[15][4];

	int i = 0; 

	MakeGUI() {
		
		JFrame jfrm = new JFrame("Google Form Mock Up");
		jfrm.setSize(250, 350);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setLayout(new FlowLayout());

		status = new JLabel("");

		JLabel nameJL = new JLabel("Name");
		JTextField nameJTF = new JTextField("Enter Name", 15);

		JLabel regNoJL = new JLabel("RegNo");
		JTextField regNoJTF = new JTextField("Enter Reg. No", 15);

		JLabel cpNoJL = new JLabel("CPNo");
		JTextField cpNoJTF = new JTextField("Enter Comp. No.", 15);


		submit = new JButton("submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent me) {
				data[i][0] = nameJTF.getText();
				data[i][1] = regNoJTF.getText();
				data[i][2] = cpNoJTF.getText();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				String datetime  = dateFormat.format(new Date());
				data[i][3] = datetime;

				if(data[i][0].equals("") ||
					data[i][1].equals("") ||
					data[i][2].equals("")) {
					
					status.setText("Invalid Data, blank fields");

				} else {

					i++;
					nameJTF.setText("Enter Name");
					regNoJTF.setText("Enter Reg. No.");
					cpNoJTF.setText("Enter Comp. No.");
					status.setText("Form Submited!");
					
				}
			}
		});

		print = new JButton("print");
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent me) {
				try {
					PrintWriter writer = new PrintWriter(new FileWriter("./output.txt"));

					for(int i = 0; i < tableHeadings.length; i++) {
						writer.print(String.format("%-15s", tableHeadings[i]) + "\t");
					}
						writer.println();
						writer.println();

					for(int i = 0; (i < data.length)&&(data[i][0] != null); i++) {
						for(int j = 0; j < data[i].length; j++) {	
							writer.print(String.format("%-15s", data[i][j]) + "\t");
						}
						writer.println();
					}
					writer.flush();
					writer.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		});

		
		jfrm.add(nameJL);
		jfrm.add(nameJTF);
		
		jfrm.add(regNoJL);
		jfrm.add(regNoJTF);
		
		jfrm.add(cpNoJL);
		jfrm.add(cpNoJTF);
		
		jfrm.add(submit);
		jfrm.add(print);
		jfrm.add(status);

		jfrm.setVisible(true);
	}
	public void actionPerformed(ActionEvent me) {
		// intentially left blank
	}
}

class Form {
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MakeGUI();
			}
		});
	}
}