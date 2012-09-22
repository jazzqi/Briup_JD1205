package com.briup.ch08;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrameTest extends JFrame{
	private Container contentPane;
	private JButton addBtn;
	private JButton subBtn;
	private JButton mulBtn;
	private JButton divBtn;
	private JButton exitBtn;
	private JLabel symLbl;
	private JTextField firstText;
	private JTextField secondText;
	private JTextField resText;
	
	public MyFrameTest(String title){
		setTitle(title);
		setSize(800,600);
		contentPane=getContentPane();
		contentPane.setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
	}
	public void init(){
		setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		firstText=new JTextField(5);
		secondText=new JTextField(5);
		add(firstText);add(secondText);
		symLbl=new JLabel("=");
		add(symLbl);
		resText=new JTextField(10);
		add(resText);
		addBtn=new JButton("+");
		addBtn.setSize(10,10);
		subBtn=new JButton("-");
		mulBtn=new JButton("*");
		divBtn=new JButton("/");
		exitBtn=new JButton("exit");
		add(addBtn);add(subBtn);add(mulBtn);add(divBtn);add(exitBtn);
		exitBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(1);
			}
		});
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int a=Integer.parseInt(firstText.getText());
				int b=Integer.parseInt(secondText.getText());
				int res=a+b;
				resText.setText(""+res);
			}
		});
		subBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int a=Integer.parseInt(firstText.getText());
				int b=Integer.parseInt(secondText.getText());
				int res=a-b;
				resText.setText(""+res);
			}
		});
		subBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int a=Integer.parseInt(firstText.getText());
				int b=Integer.parseInt(secondText.getText());
				int res=a-b;
				resText.setText(""+res);
			}
		});
		mulBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int a=Integer.parseInt(firstText.getText());
				int b=Integer.parseInt(secondText.getText());
				int res=a*b;
				resText.setText(""+res);
			}
		});
		divBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int a=Integer.parseInt(firstText.getText());
				double b=Integer.parseInt(secondText.getText());
				double res=a/b;
				resText.setText(""+res);
			}
		});
	}
	public static void main(String args[]){
		new MyFrameTest("my first frame cal in briup").show();

	}
}
