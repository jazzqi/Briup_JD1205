package com.md09;

import java.awt.*;
import javax.swing.*;

public class ResumeFrame extends JFrame {
	private Container contentPane;
	private Choice choice2;
    private JPanel panel1;
    private JPanel panel2;
    private JTextArea textArea2;
    private JPanel panel3;
    private JTextArea textArea1;
    private JPanel panel4;
    private JTextArea textArea3;
    private JPanel panel5;
    private JTextArea textArea4;
    private JPanel panel6;
    private JTextArea textArea5;
    private JPanel panel7;
    private JTextArea textArea6;

    public static void main (String[] args) {
        ResumeFrame res = new ResumeFrame();
        res.setLayoutManager();
        res.initComponents ();
        res.pack();
        res.setVisible(true);
    }

    public void setLayoutManager() {
        getContentPane().setLayout(new FlowLayout());
    }

    private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
        choice2 = new Choice();
        choice2.add("Objective");
        choice2.add("Qualification");
        choice2.add("Experience");
        choice2.add("Skillset");
        choice2.add("Education");
        choice2.add("Training");
        choice2.select(0);
        panel1 = new JPanel();
        panel2 = new JPanel();
        textArea2 = new JTextArea();
        panel3 = new JPanel();
        textArea1 = new JTextArea();
        panel4 = new JPanel();
        textArea3 = new JTextArea();
        panel5 = new JPanel();
        textArea4 = new JTextArea();
        panel6 = new JPanel();
        textArea5 = new JTextArea();
        panel7 = new JPanel();
        textArea6 = new JTextArea();

        choice2.setFont(new Font ("Dialog", 0, 11));
        choice2.setName("choice2");
        choice2.setBackground(Color.white);
        choice2.setForeground(Color.black);

        contentPane.add(choice2);


        panel1.setLayout(new CardLayout());
        panel1.setFont(new Font ("Dialog", 0, 11));
        panel1.setName("panel20");
        panel1.setBackground(new Color (204, 204, 204));
        panel1.setForeground(Color.black);

        panel2.setFont(new Font ("Dialog", 0, 11));
		panel2.setName("panel21");
        panel2.setBackground(new Color (153, 153, 153));
        panel2.setForeground(Color.black);

		textArea2.setBackground(new Color (216, 208, 200));
        textArea2.setName("text4");
        textArea2.setEditable(false);
        textArea2.setFont(new Font ("Courier New", 0, 12));
        textArea2.setColumns(80);
        textArea2.setForeground(new Color (0, 0, 204));
        textArea2.setText("Seeking a challenging position as a Solaris Administrator, \nC/C++/JAVA Programmer or Technical Support in the UNIX \nenvironment, which will allow me to make contribution and \nutilize my technical skills.\n");
        textArea2.setRows(20);
        panel2.add(textArea2);

        panel1.add(panel2, "Objective");

        panel3.setFont(new Font ("Dialog", 0, 11));
        panel3.setName("panel22");
        panel3.setBackground(new Color (153, 153, 153));
        panel3.setForeground(Color.black);

        textArea1.setBackground(new Color (216, 208, 200));
        textArea1.setName("text3");
        textArea1.setEditable(false);
        textArea1.setFont(new Font ("Courier New", 1, 12));
        textArea1.setColumns(80);
        textArea1.setForeground(Color.black);
        textArea1.setText("* 7 years C/C++ experience, including 5 years commercial application programming experience in C/C++ on UNIX/Windows\n* 6 years UNIX experience, including 4 years on Solaris, especially nearly 3 years career at Sun Microsystems\n* 7 years experience in RDBMS, including Oracle, Informix and Sybase\n* 3 years programming experience in JAVA on UNIX/WINDOWS\n* 2 years experience in designing and developing in J2EE\n* 2 years experience in developing TCP/IP daemon\n");
        textArea1.setRows(20);
        panel3.add(textArea1);

        panel1.add(panel3, "Qualification");

	    panel4.setFont(new Font ("Dialog", 0, 11));
        panel4.setName("panel23");
        panel4.setBackground(new Color (153, 153, 153));
        panel4.setForeground(Color.black);

        textArea3.setBackground(new Color (216, 208, 200));
        textArea3.setName("text5");
        textArea3.setEditable(false);
        textArea3.setFont(new Font ("Courier New", 0, 12));
        textArea3.setColumns(80);
        textArea3.setForeground(Color.blue);
        textArea3.setText("Technical Support / Systems Engineer\nSun Microsystems Inc. China Ltd.  PRC\t\t10/1998 --04/2001\nFinance, Securities and Insurance industries  \n* Technically supported \"PingAn Insurance Company\" (PAIC) and\n  built an EC portal (www.pa18.com) based on J2EE and CORBA \n  (Inprise Application Server/iPlanet Web Server) architecture \n* Helped pa18 on J2EE developing, solved jsp/servlet session and \n  Chinese character display problems\n* Migrated PAIC Oracle data from HP/ALPHA to Sun E5500/A5000 and \n  E10000/T3, tuned system and Oracle for batch application \n  benchmark testing\n* Technically supported \"Industrial and Commercial Bank of China\"\n  (ICBC) Guangzhou Regional and Shenzhen branch, built E-Banking,\n  Mid-Business and Mainframe-Gateway system on 5 Sun E10000 and \n  tape library, Oracle, websphere\n* Provided sample codes in C/C++ based on n-tier architecture to \n  ICBC, debugged and tuned test codes in C/C++ from the customers   \n* Guided \"China Merchants Bank\" (Shenzhen) to optimize RSA \n  algorithm program in C\n* Technically supported securities companies and built \n  online-trading portal based on Sun E10000/Sun Server, Oracle, \n  Weblogic\n* Provided J2EE training to securities companies\n\nGovernment and Education industries and others  \n* Technically supported universities in south China, usually \n  provided C/C++/JAVA programming in Solaris training to them \n* Technically supported all government OA and online projects \n  in south China, helped and guided web applications development \n  in C/C++/JAVA\n* Designed mobile Home Location Register (HLR) C multi-thread \n  authentication architecture, guided TCP/IP daemon programming \n  in C/C++ to Huawei Company\n \nSun Microsystems Platform Lead Programmer/Project Manager \nAsiainfo Computer Network (Beijing) Co., Ltd     08/1997-07/1998\nAIOBS-----Asiainfo Internet Online Billing System\n* Led a team of 10 to design, develop, test and support AIOBS on \n  Sun Microsystems Enterprise Server/Solaris, Cisco/3Com/Bay \n  access servers and routers, Radius, Oracle, Java and C/C++\n* Developed Radius user manager daemon ndbms in C\n* Developed AIOBS customer billing query session management \n  library, web page template interpreter library in C/C++\n* Developed AIOBS Oracle user management JAVA applets, master \n  user management applets, dial-up (PPP/SLIP) user management \n  JAVA applets, leased-line user management JAVA applets\n* Developed a utility to convert PPP user to mail user ppp2mail\n  in ProC\n* Developed file transfer from breakpoint application in C\n* Led installing, maintaining AIOBS systems in 6 provinces' \n  telecommunication companies for China Multi-Media Information \n  Network (169)\n\nMiscellaneous\n* Developed Asiainfo Nexus System (AINEXUS) user manager daemon\n  in C\n* Developed Asiainfo license management library in C/C++\n\nLead Programmer/Project Manager\nFinancial & Electric Company (Guangzhou, PRC) 01/1996---07/1997  \n* Led a team of 8 to design, develop bank saving and accounting \n  system based on Informix and SCO Unix and security application\n  in C/Delphi on Windows\n* Developed saving interest calculation module in Informix 4GL\n* Developed saving System TCP/IP communication daemon in C\n* Led installing and maintaining saving and accounting system in\n  16 branches of City Commercial Bank \n* Developed security protocol application program interface for \n  financial business in C\n\nSoftware Engineer\nBeijing Guangdong Computer Centre (BGC)\t\t 07/1994-12/1995  \n* Developed tax application demo system in C/Novell\n* Developed terminated system resident declaring subsystem for \n  stocks trading in Assembler/C/Foxpro/Novell\n* Developed part of stocks exchanging application in \n  C/Sybase/Novell\n\n");
        textArea3.setRows(20);
        panel4.add(textArea3);

        panel1.add(panel4, "Experience");

        panel5.setFont(new Font ("Dialog", 0, 11));
        panel5.setName("panel24");
        panel5.setBackground(new Color (153, 153, 153));
        panel5.setForeground(Color.black);

		textArea4.setBackground(new Color (216, 208, 200));
        textArea4.setName("text6");
        textArea4.setEditable(false);
        textArea4.setFont(new Font ("Courier New", 0, 12));
        textArea4.setColumns(80);
        textArea4.setForeground(Color.blue);
        textArea4.setText("Programming:       C, C++, ASSEMBLER, JAVA, HTML, XML, FORTRAN, DELPHI, FORTE, SUN WORKSHOP, FOXPRO\nDatabase:               ORACLE, INFORMIX, SYBASE\nOperation system: SOLARIS, SCO UNIX, AT&T UNIX, OSF/1, WINDOWS, NETWARE \nNetwork tools:       TCP/IP, SNA, NFS, NIS, NIS+, SNMP\nOther tools:            Inprise and Weblogic application server, iPlanet and Sun Microsystems Software\n");
        textArea4.setRows(20);
        panel5.add(textArea4);

        panel1.add(panel5, "Skillset");

        panel6.setFont(new Font ("Dialog", 0, 11));
        panel6.setName("panel25");
        panel6.setBackground(new Color (153, 153, 153));
        panel6.setForeground(Color.black);

        textArea5.setBackground(new Color (216, 208, 200));
        textArea5.setName("text7");
        textArea5.setEditable(false);
        textArea5.setFont(new Font ("Courier New", 0, 12));
        textArea5.setColumns(80);
        textArea5.setForeground(Color.blue);
        textArea5.setText("University of Science and Technology of China    1986 - 1994 \nB.E. in Engineering                      1986--1991\nM.E. in Engineering                      1991--1994  \n");
        textArea5.setRows(20);
        panel6.add(textArea5);

		panel1.add(panel6, "Education");

        panel7.setFont(new Font ("Dialog", 0, 11));
        panel7.setName("panel26");
        panel7.setBackground(new Color (153, 153, 153));
        panel7.setForeground(Color.black);

        textArea6.setBackground(new Color (216, 208, 200));
        textArea6.setName("text8");
        textArea6.setEditable(false);
        textArea6.setFont(new Font ("Courier New", 0, 12));
        textArea6.setColumns(80);
        textArea6.setForeground(Color.blue);
        textArea6.setText("Sun Microsystems Inc.   1998-2001\nAttended training course on \"Are you .com ready? \", \n\"Consulting Skills Development\", \"What Matters Most \nProgram\", \"Professional Presentation Program for \nCollege Hires\", \"Holden Power Base Selling Program\",\n certificates issued\n\n");
        textArea6.setRows(20);
        panel7.add(textArea6);

        panel1.add(panel7, "Training");

        contentPane.add(panel1);
	}
}
