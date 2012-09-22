package com.md09;

import java.awt.*;
import javax.swing.*;

public class AWTFrame extends JFrame{
	JButton panicButton, okButton;
    JLabel statusLabel;
	Container contentPane;

	public AWTFrame(String aTitle) {
		contentPane = getContentPane();
		setTitle(aTitle);
		contentPane.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		panicButton = new JButton("cancel");
		buttonPanel.add(panicButton);
		okButton = new JButton("ok");
		buttonPanel.add(okButton);
		contentPane.add(buttonPanel, BorderLayout.CENTER);
		statusLabel = new JLabel("Ready?");
		contentPane.add(statusLabel, BorderLayout.SOUTH);
		setSize(200, 100);
		setVisible(true);
	}

	public static void main(String args[]) {
		new AWTFrame("AWT Example");
	}
}
