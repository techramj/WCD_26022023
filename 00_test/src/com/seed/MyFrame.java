package com.seed;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	JLabel lbId, lbName, lbSalary;
	JTextField txId, txName, txSalary;
	JButton button;
	
	public MyFrame() {
		this.setLayout(null);
		lbId = new JLabel("ID");
		lbId.setBounds(20, 20, 100, 20);
		
		lbName = new JLabel("Name");
		lbName.setBounds(20, 50, 100, 20);
		
		lbSalary = new JLabel("Salary");
		lbSalary.setBounds(20, 80, 100, 20);
		
		
		txId = new JTextField(20);
		txId.setBounds(130, 20, 100, 20);
		
		txName = new JTextField(20);
		txName.setBounds(130, 50, 100, 20);
		
		txSalary = new JTextField(20);
		txSalary.setBounds(130, 80, 100, 20);
		
		button = new JButton("Add Employee");
		button.setBounds(60, 110,150,20);
		
		Container container = this.getContentPane();
		container.add(lbId);
		container.add(lbName);
		container.add(lbSalary);
		
		container.add(txId);
		container.add(txName);
		container.add(txSalary);
		
		container.add(button);
		
		button.addActionListener(new MyActionListener());
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,200);
		
	}
	
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new MyFrame();
	}

}
