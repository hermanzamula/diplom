package com.managehelper.old;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TableFrame extends Main {
	private static Dimension screenSize;
	private static ArrayList<JPanel> panels = new ArrayList();

	private static void initialize() {
		JFrame frame2 = new JFrame("Manage Helper �������");
		frame2.setResizable(false);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame2.setBounds((screenSize.width - 300) / 2,
				(screenSize.height - 300) / 2, 600, 500);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.setBounds(20, 20, 400, 400);
		
		
		JPanel firstpanel = new JPanel();
        tabbedPane.add("������", firstpanel);

        
		frame2.add(tabbedPane);
		frame2.setVisible(true);

	}
	
	
	public void DinamicPanels() {
		for (int i = 0; i < getNumberOfGroups(); i++) {
			panels.add(new JPanel());
		}
	}

	public static void FirstCount() {
		initialize();

	}
}
