import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Question4 extends JFrame 
{
	JLabel label ;
	JPanel panel;
	JTextField field ;
	JButton button;
	JButton next;
	JLabel warn;
	float input;
	//int output = 0;
	ArrayList<Float> list = new ArrayList<Float>();	
	
	int chance = 0;
	
	Question4(){
		
		this.setSize(500 ,100);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEADING));
		panel.setPreferredSize(new Dimension(450, 50));
		label = new JLabel("Enter a set of numbers : ");
		
		SaveListener save = new SaveListener();
		CheckListener check = new CheckListener();
		button = new JButton("Submit");
		next = new JButton("Next");
		next.addActionListener(save);
		button.addActionListener(check);
	
		field = new JTextField();
		field.setPreferredSize(new Dimension(100, 50));
		
		warn = new JLabel();
		
		panel.add(label);
		panel.add(field);
		panel.add(next);
		panel.add(button);
		this.add(panel, BorderLayout.CENTER);
		this.add(warn, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	/*
	class FalseException extends NumberFormatException{
		
		FalseException(){
			super("Not a floating number");
		}
		
		FalseException(String str){
			super(str);
		}
		
	}
	*/
	public boolean check() {
		
		boolean status;
		try {
			input = Float.parseFloat(field.getText());
			System.out.println(input);
			status = true;
		}
		catch(NumberFormatException f) {
			System.out.println("got");
			status = false;
		}
		
		return status;
	}
	
	class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(check()) {
				list.add(input);
				field.setText("");
				warn.setText("");
			}
			else {
				chance ++; // use other method or put in the constructor
				System.out.println("haha");
				warn.setText("Invalid input. Please try again.");
				warn.setForeground(Color.red);
			}
			
			if(chance > 2) {
				warn.setText("Out of chances !");
				warn.setForeground(Color.red);
				field.setEditable(false);
				QuitListener quit = new QuitListener();
				Timer time = new Timer(1000, quit);
				time.start();
			}
			
		}
		
	}
	
	class CheckListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
				float result = 0;
				for(int i = 0 ; i < list.size() ; i ++) {
					
					result += list.get(i);
					
				}
				
				label.setText("Total: ");
				field.setText("" + result);
				field.setEditable(false);
				button.setEnabled(false);
				next.setEnabled(false);
		}
		
	}
	
	class QuitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
	
	
	public static void main(String[] args) {
		new Question4();
		
	}
    
}
