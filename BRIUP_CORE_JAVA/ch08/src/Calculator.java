package com.briup.ch08;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame{
	private JButton numBtn[]=new JButton[10];
	private JButton subBtn;
	private JButton divBtn;
	private JButton mulBtn;
	private JButton addBtn;
	private JButton clrBtn;
	private JButton eqlBtn;
	private JTextField screen;
	private JPanel centerPanel;
	public Calculator(){
		setTitle("My Calculator");
		setLayout(new BorderLayout());
		setSize(640,480);
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void init(){
		for(int i=0;i<10;i++){
			numBtn[i]=new JButton(i+"");
			numBtn[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					screen.setText(screen.getText()+((JButton)e.getSource()).getText());
				}
			});
		}
		addBtn=new JButton("+");
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		subBtn=new JButton("-");
		subBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		mulBtn=new JButton("*");
		mulBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		divBtn=new JButton("/");
		divBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		eqlBtn=new JButton("=");
		eqlBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		clrBtn=new JButton("clr");
		clrBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				screen.setText("");
			}
		});
		screen=new JTextField(10);
		screen.setHorizontalAlignment(JTextField.RIGHT);
		screen.setFont(new Font("Arial",Font.BOLD,20));
		add(screen,BorderLayout.NORTH);
		centerPanel=new JPanel();
		centerPanel.setLayout(new GridLayout(4,4,5,5));
		centerPanel.add(numBtn[1]);
		centerPanel.add(numBtn[2]);
		centerPanel.add(numBtn[3]);
		centerPanel.add(addBtn);
		centerPanel.add(numBtn[4]);
		centerPanel.add(numBtn[5]);
		centerPanel.add(numBtn[6]);
		centerPanel.add(subBtn);
		centerPanel.add(numBtn[7]);
		centerPanel.add(numBtn[8]);
		centerPanel.add(numBtn[9]);
		centerPanel.add(mulBtn);
		centerPanel.add(numBtn[0]);
		centerPanel.add(clrBtn);
		centerPanel.add(eqlBtn);
		centerPanel.add(divBtn);
		add(centerPanel,BorderLayout.CENTER);
	}
	public static void main(String args[]){
		new Calculator().setVisible(true);
	}
}
