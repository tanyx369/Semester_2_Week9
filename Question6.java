import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Question6 extends JFrame{

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
	
	double balan;
	
	Question6(){
		
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
		
		BalanceException(String str){
			super(str);
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
			String str1 = "", str2 = "" ,str3 = "";
			id = ID.getText();
			bnum = num.getText();
			bal = balance.getText();
			try {
				checkID(id);
			}
			catch (IDException i ) {
				correct1 = false;
				str1 = i.getMessage();
			}
			
			try {
				checkNum(bnum);
			}
			catch (NumException n) {
				correct2 = false;
				str2 = n.getMessage();
			}
			
			try {
				checkBalance(bal);
			}
			catch (BalanceException b) {
				correct3 = false;
				str3 = b.getMessage();
			}
			
			dispose();
			new newFrame(correct1, correct2, correct3, str1 , str2 , str3);
		}
		
	}
	
	
	class newFrame extends JFrame{
		
		JButton re = new JButton("Return");
		JButton exit = new JButton("Exit");
		JButton next = new JButton("Next");
		
		ImageIcon tick = new ImageIcon("tick.png");
		ImageIcon cross = new ImageIcon("cross.png");
		
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		
		JPanel buttons = new JPanel();
		
		double amount;
		
		newFrame(boolean status, boolean status2, boolean status3 , String str1 , String str2 , String str3){
			
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
				label1.setText(str1);
				label1.setIcon(cross);
			}
			
			if(status2) {
				label2.setText("Account number is confirmed.");
				label2.setIcon(tick);
				check2 = true;
			}
			else {
				label2.setText(str2);
				label2.setIcon(cross);
			}
			
			if(status3) {
				label3.setText("Initial balance has reached the minimum amount.");
				label3.setIcon(tick);
				check3 = true;
			}
			else {
				label3.setText(str3);
				label3.setIcon(cross);
			}
			
			buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
			re.addActionListener(new ReenterListener());
			exit.addActionListener(new ExitListener());
			next.addActionListener(new NextListener());
			buttons.add(re);
			buttons.add(exit);
			buttons.add(next);
			
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
				new Question6();
				
			}
			
		}
		
		class ExitListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		}
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel label1a = new JLabel("Deposit amount: ");
		JLabel label2a = new JLabel("Withdrawl amount: ");
		JButton deposit = new JButton("Deposit");
		JButton withdrawl = new JButton("Withdrawl");
		JTextField field = new JTextField();
		JTextField field2 = new JTextField(); 
		
		String amounts;
		
		class NextListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				label1.setVisible(false);
				label2.setVisible(false);
				label3.setVisible(false);
				re.setVisible(false);
				next.setVisible(false);
				
			
				panel1.setLayout(new FlowLayout());
				panel2.setLayout(new FlowLayout());

				
				field.setPreferredSize(new Dimension(200, 30));
				field2.setPreferredSize(new Dimension(200, 30));
				
				deposit.addActionListener(new ChangeListener(true));
				withdrawl.addActionListener(new ChangeListener(false));
				
				panel1.add(label1a);
				panel1.add(field);
				panel1.add(deposit);
				panel2.add(label2a);
				panel2.add(field2);
				panel2.add(withdrawl);
			
				
				add(panel1);
				add(panel2);
				
				
				
			}
			
		}
		
		class ChangeListener implements ActionListener{

			boolean status;
			
			
			ChangeListener(boolean get){
				status = get;
				
			}
			JLabel result = new JLabel();
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(false);
				checkWord(status);
				try {
					checkNewBalance(status, amounts );
					 result.setText("Total balance: $" + balan );
					add(result);
					result.setVisible(true);
				} catch (BalanceException e1) {
					JLabel warn = new JLabel(e1.getMessage());
					add(warn);
					setVisible(true);
				}
				
			}
			
		}
		
		public void checkWord(boolean b) {
			
			if(b == true) {
				amounts = field.getText();
			}
			else {
				amounts = field2.getText();
			}
		}
		
	}

	public void checkNewBalance(boolean choice, String input) throws BalanceException {
		
		boolean status = true;
		double amount = 0;
		balan = Double.parseDouble(bal);
	
		try {
			amount = Double.parseDouble(input);
		}
		catch(NumberFormatException n) {
			status = false;
		}
		
	
		if(choice == true && status == true ) {
			balan = balan + amount;
			if(balan > 5000) {
				throw new BalanceException("Your saving amount has reached the maximum.");
			}
		}
		
		if(choice == false && status == true) {
			balan = balan - amount;
			if(balan<1000) {
				throw new BalanceException("Your saving amount has lower than the minimum required amount.");
			}
		}
	}
	

	public static void main(String[] args) {
		
		new Question6();

	}

}
