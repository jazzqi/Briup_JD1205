package com.md09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AWTEventFrame extends JFrame
{
	JButton panicButton,okButton;
	JLabel statusLabel;
	Container contentPane;

	public AWTEventFrame(String aTitle){
		contentPane = getContentPane();
		setTitle(aTitle);
		contentPane.setLayout(new BorderLayout());
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		panicButton = new JButton("cancel");
		buttonPanel.add(panicButton);
		okButton = new JButton("ok");
		buttonPanel.add(okButton);
		contentPane.add(buttonPanel,BorderLayout.CENTER);
		statusLabel = new JLabel("Ready?");
		contentPane.add(statusLabel,BorderLayout.SOUTH);
		setSize(200,100);
		setVisible(true);
		panicButton.addActionListener(new MyActionListener());
		okButton.addActionListener(new MyActionListener());
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}

	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == panicButton){
				statusLabel.setText("Cancel");
			}
			if(e.getSource() == okButton){
				statusLabel.setText("OK");
			}
		}
	}
	public static void main(String args[])
	{
		new AWTEventFrame("AWT Example");
	}
	
}
