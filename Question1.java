import java.awt.*;
import javax.swing.*;


public class Question1 extends JFrame 
{
	
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	
	JRadioButton button1;
	JRadioButton button2;
	JRadioButton button3;
	
	JCheckBox box1;
	JCheckBox box2;
	JCheckBox box3;
	
	Question1(){
		//this.setSize(400 ,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Printer");
		this.setResizable(true);
		this.setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel();
		label1.setText("Printer: My Printer");
		label1.setForeground(Color.MAGENTA);
		
		JLabel label2 = new JLabel();
		label2.setText("Print Quality: ");
		
		
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JPanel panel1a = new JPanel();
		panel1a.setBackground(Color.white);
		panel1a.setPreferredSize(new Dimension(50, 100));
		JPanel panel1b = new JPanel();
		panel1b.setBackground(Color.white);
		panel1b.setPreferredSize(new Dimension(50, 100));
		JPanel panel1c = new JPanel();
		panel1c.setBackground(Color.white);
		panel1c.setPreferredSize(new Dimension(50, 100));
	
		
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2 , BoxLayout.PAGE_AXIS));
		
		button1 = new JRadioButton("Selection");
		button2 = new JRadioButton("All");
		button3 = new JRadioButton("Applet");
		ButtonGroup group = new ButtonGroup();
		group.add(button1);
		group.add(button2);
		group.add(button3);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		
		
		panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3 , BoxLayout.PAGE_AXIS));
		box1 = new JCheckBox("Image");
		box2 = new JCheckBox("Text");
		box3 = new JCheckBox("Code");
		panel3.add(box1);
		panel3.add(box2);
		panel3.add(box3);
		
		
		panel1.add(panel1a);
		panel1.add(panel3);
		panel1.add(panel1b);
		panel1.add(panel2);
		panel1.add(panel1c);
		panel1.setPreferredSize(new Dimension(300, 100));
	
		String[] type = {"High" , "Medium" , "Low"};
		panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		panel4.add(label2);
		JComboBox combo = new JComboBox(type);
		JCheckBox check = new JCheckBox("Print to File");
		panel4.add(combo);
		panel4.add(check);
		
		panel5 = new JPanel();
		panel5.setLayout(new GridLayout(4,1, 10 , 10));
		JButton jbut1 = new JButton("OK");
		JButton jbut2 = new JButton("Cancel");
		JButton jbut3 = new JButton("Setup...");
		JButton jbut4 = new JButton("Help");
		panel5.add(jbut1);
		panel5.add(jbut2);
		panel5.add(jbut3);
		panel5.add(jbut4);
		
		
		this.add(label1, BorderLayout.NORTH);
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel4, BorderLayout.SOUTH);
		this.add(panel5, BorderLayout.EAST);
		this.pack();
		this.setVisible(true);
		
		
	}
    
	public static void main(String[] args) {
		new Question1();
	}
	
}
