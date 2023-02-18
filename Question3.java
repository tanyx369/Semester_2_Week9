import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question3 extends JFrame 
{
	
	JTextField field = new JTextField();
	JComboBox fonts;
	JTextField size = new JTextField();
	JComboBox style ;
	JButton show = new JButton("Show");
	String input;
	int wsize;
	
	String font_ch = "";
	String style_ch="";
	
	
	
	Question3(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(500 ,300);
		//this.setLayout(null);
		
		JLabel label = new JLabel("Enter your text");
		label.setBounds(0, 0, 200, 10);
		
		size.setPreferredSize(new Dimension(100, 30 ));
		field.setPreferredSize(new Dimension(500, 50));
		String[] fonttypes = {"SansSerif", "Arial", "Serif"};
		fonts = new JComboBox(fonttypes);
		fonts.setPreferredSize(new Dimension(100, 30));
		fonts.addActionListener(new FontListener());
		String[] styles = {"Bold" , "Italic"};
		style = new JComboBox(styles);
		style.setPreferredSize(new Dimension(100, 30));
		
		JPanel buttongrp = new JPanel();
		buttongrp.setLayout(new FlowLayout(FlowLayout.LEADING));
		//buttongrp.setPreferredSize(new Dimension(500, 60));
		//buttongrp.setBounds(0, 200, 500, 60);
		JLabel label2 = new JLabel("Font: ");
		JLabel label3 = new JLabel("Size: ");
		JLabel label4 = new JLabel("Style: ");
		buttongrp.add(label2);
		buttongrp.add(fonts);
		buttongrp.add(label3);
		buttongrp.add(size);
		buttongrp.add(label4);
		buttongrp.add(style);
		buttongrp.add(show);
		

	
		FontListener f = new FontListener();
		StyleListener s = new StyleListener();
		ShowListener sh = new ShowListener();
		fonts.addActionListener(f);
		style.addActionListener(s);
		show.addActionListener(sh);
		
		

		this.add(label, BorderLayout.NORTH);
		this.add(field, BorderLayout.CENTER);
		this.add(buttongrp, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	}
	
	class FontListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == fonts) {
				if(fonts.getSelectedItem().equals("SansSerif")) {
					System.out.println("hello");
					font_ch = "SansSerif";
				}
				else if(fonts.getSelectedItem().equals("Arial")) {
					font_ch = "Arial";
				}
				else if(fonts.getSelectedItem().equals("Serif")) {
					font_ch = "Serif";
				}
			}
			
		}
		
	}
	
	class StyleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
		
				if(style.getSelectedItem().equals("Bold")) {
					System.out.println("asd");
					style_ch = "Bold";
				}
				else if(style.getSelectedItem().equals("Italic")) {
					style_ch = "Italic";
				}
			
			}
		
		
	}
	
	public void renew(int style) {
		
		
		if(font_ch.equals("SansSerif")) {
			field.setFont(new Font("SansSerif", style , wsize ));
			field.setText(input);
			System.out.print("ahsd");
		}
		else if (font_ch.equals("Arial")) {
			field.setFont(new Font("Arial" , style, wsize));
			field.setText(input);
			System.out.println("qweq");
		}
		else if (font_ch.equals("Serif")) {
			field.setFont(new Font("Serif" , style, wsize));
			field.setText(input);
		}
		
	}
	
	class ShowListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(! field.getText().isEmpty()) {
				input = field.getText();
			}
			
			if(! size.getText().isEmpty()) {
				wsize = Integer.parseInt(size.getText()); 
			}
			
			if(style_ch.equals("Bold")) {
				renew(Font.BOLD);
				System.out.println("2dd");
			}
			else if (style_ch.equals("Italic")) {
				renew(Font.ITALIC);
				System.out.println("2de");
			}


			
		}
		
	}
    
	public static void main(String[] args) {
		new Question3();
	}
}
