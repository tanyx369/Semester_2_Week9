import javax.swing.*;
import java.awt.*;

public class Question2 extends JComponent
{
    public void paintComponent(Graphics g) {
    
    	Graphics2D g2 = (Graphics2D) g;
    	g2.drawLine(15, 0, 15 , 500);
    	g2.drawLine(0, 450, 500 , 450);
    	
    	for(int i = 10 ; i < 450 ; i+= 10) {
    		g2.drawLine(5, i, 25, i);
    	}
    	
    	g2.setColor(Color.red);
    	g2.fillRect(50, 219, 20, 231);
    	g2.setColor(Color.black);
    	g2.setFont(new Font("Dialog" , Font.BOLD, 12 ));
    	g2.drawString("January", 35, 470);
    	
    	g2.setColor(Color.BLUE);
    	g2.fillRect(110, 229, 20, 221 );
    	g2.setColor(Color.black);
    	g2.drawString("Febraury", 95, 470);
    	
    	g2.setColor(Color.green);
    	g2.fillRect(170, 339 , 20, 111);
    	g2.setColor(Color.black);
    	g2.drawString("March", 165, 470);
    	
    	g2.setColor(Color.cyan);
    	g2.fillRect(230, 69, 20, 381);
    	g2.setColor(Color.black);
    	g2.drawString("April", 225 , 470);
    	
    	g2.setColor(Color.orange);
    	g2.fillRect(290, 240, 20, 210);
    	g2.setColor(Color.black);
    	g2.drawString("May", 288, 470);
    	
    	g2.drawString("Month", 505, 450);
    	
    
    }
    
    public static void main(String[] args) {
    
    	JFrame frame = new JFrame();
    	frame.setSize(600, 600);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	JLabel label = new JLabel("Billing Amount");
    	Question2 line = new Question2();

    	
    	frame.add(label, BorderLayout.NORTH);
    	frame.add(line);
    	frame.setVisible(true);
    	
    	
    }
}
