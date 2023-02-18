import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question5 extends JFrame
{
	
	JLabel label;
	JTextField ID;
	JTextField num;
	JTextField balance;
	JButton sumbit;
	
	JPanel panel1 ;
	JPanel panel2;
	JPanel panel3;
	
	JLabel label1 = new JLabel("Account ID: ");
	JLabel label2 = new JLabel("Account number: ");
	JLabel label3 = new JLabel("Initial balance: ");
	
	String id;
	String bnum;
	String bal;
	
	
	Question5(){
		
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		label = new JLabel("Bank account detail: ");
		
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		
		
		ID = new JTextField();
		ID.setPreferredSize(new Dimension(200, 30));
		panel1.add(label1);
		panel1.add(ID);
		num = new JTextField();
		num.setPreferredSize(new Dimension(200, 30));
		panel2.add(label2);
		panel2.add(num);
		balance = new JTextField();
		balance.setPreferredSize(new Dimension(200, 30));
		panel3.add(label3);
		panel3.add(balance);
		
		CheckListener ch = new CheckListener();
		sumbit = new JButton("Submit");
		sumbit.addActionListener(ch);
		
		this.add(label);
		this.add(panel1);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(panel2);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(panel3);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(sumbit);

		this.setVisible(true);
	}
    
	class IDException extends Exception{
		
		IDException(){
			super("ID format is invalid, please enter again !");
		}
		
	}
	
	class NumException extends Exception{
		NumException(){
			super("Account number format is invalid. please enter again !");
		}
	}
	
	class BalanceException extends Exception{
		
		BalanceException(){
			super("Your balance is less than $1000.");
		}
		
	}
	
	public void checkID(String id) throws IDException {
		
		boolean status = true;
		try {
			for(int i = 0 ; i < id.length() ; i++) {
				if(Character.isDigit(id.charAt(i))) {
					status = false;
				}
			}
		}
		catch (StringIndexOutOfBoundsException s) {
			status = true;
		}
		
		if (id.length() > 4 || id.length() < 4) {
			throw new IDException();
		}
		else if(! Character.isLetter(id.charAt(0))) {
			throw new IDException();
		}
		else if(status) {
			throw new IDException();
		}
	
		
	}
	
	public void checkNum(String num) throws NumException {
		
		boolean status = true;
		try {
			for(int i = 0 ; i < num.length() ; i++) {
				if(Character.isDigit(num.charAt(i))) {
					status = false;
				}
			}
		}
		catch (StringIndexOutOfBoundsException s) {
			status = true;
		}
		
		if (num.length() > 5 || num.length() < 5) {
			throw new NumException();
		}
		else if(status) {
			throw new NumException();
		}
	
		
	}
	
	public void checkBalance(String b) throws BalanceException {
		

		boolean status = true;
		try {
			for(int i = 0 ; i < b.length() ; i++) {
				if(Character.isDigit(b.charAt(i))) {
					status = false;
				}
			}
		}
		catch (StringIndexOutOfBoundsException s) {
			status = true;
		}
		
		if (Integer.parseInt(b) < 1000) {
			throw new BalanceException();
		}
		else if(status) {
			throw new BalanceException();
		}
		
		
	}
	
	class CheckListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			boolean correct1 = true; 
			boolean correct2 = true; 
			boolean correct3 = true; 
			id = ID.getText();
			bnum = num.getText();
			bal = balance.getText();
			try {
				checkID(id);
			}
			catch (IDException i ) {
				correct1 = false;
			}
			
			try {
				checkNum(bnum);
			}
			catch (NumException n) {
				correct2 = false;
			}
			
			try {
				checkBalance(bal);
			}
			catch (BalanceException b) {
				correct3 = false;
			}
			
			dispose();
			new newFrame(correct1, correct2, correct3);
		}
		
	}
	
	
	class newFrame extends JFrame{
		
		JButton re = new JButton("Return");
		JButton exit = new JButton("Exit");
		
		ImageIcon tick = new ImageIcon("tick.png");
		ImageIcon cross = new ImageIcon("cross.png");
		
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		
		JPanel buttons = new JPanel();
		
		newFrame(boolean status, boolean status2, boolean status3){
			
			boolean check1 = false;
			boolean check2 = false;
			boolean check3 = false;
			this.setSize(500, 300);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS ));
			
			if(status) {
				label1.setText("ID is confirmed.");
				label1.setIcon(tick);
				check1 = true;
			}
			else {
				label1.setText("ID is not acceptable.");
				label1.setIcon(cross);
			}
			
			if(status2) {
				label2.setText("Account number is confirmed.");
				label2.setIcon(tick);
				check2 = true;
			}
			else {
				label2.setText("Account number is not acceptable.");
				label2.setIcon(cross);
			}
			
			if(status3) {
				label3.setText("Initial balance has reached the minimum amount.");
				label3.setIcon(tick);
				check3 = true;
			}
			else {
				label3.setText("Initial balance does not reach minimum requirement.");
				label3.setIcon(cross);
			}
			
			buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
			re.addActionListener(new ReenterListener());
			exit.addActionListener(new ExitListener());
			buttons.add(re);
			buttons.add(exit);
			
			if((check1 && check2) && (check2 && check3)) {
				re.setVisible(false);
			}
			
			this.add(label1);
			this.add(label2);
			this.add(label3);
			this.add(buttons);
			this.setVisible(true);
		}
		
		class ReenterListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new Question5();
				
			}
			
		}
		
		class ExitListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		}
		
	}
	

	
	public static void main(String[] args) {
		new Question5();
		
		
	}
	
	
}
