package com.managehelper.old;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {
	private static Dimension screenSize;
	private static int NumberOfGroups;
	private static int NumberOfContenders;
	private static ArrayList<Team> groups = new ArrayList();

	public static void Entering() {
		initialize();
	}

	private static void creation() {
		for (int i = 0; i < NumberOfGroups; i++) {
			groups.add(new Team(NumberOfContenders));
			System.out.println("hello");

		}
	}

	public static void anothermethod() { // �� �����
		for (Team team : groups) {
			team.method();
		}
	}

	public int getNumberOfGroups() {
		return NumberOfGroups;
	}

	public int getNumberOfContenders() {
		return NumberOfContenders;
	}

	private static void initialize() {
		final JFrame frame = new JFrame("Manager Helper");
		JLabel groupNumberLabel = new JLabel("������� ���������� �����");
		JLabel label2 = new JLabel("������� ���������� ������������");
		final JTextField field1 = new JTextField();
		final JTextField field2 = new JTextField();
		JButton button = new JButton("����������");
		frame.setResizable(false);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((screenSize.width - 300) / 2,
				(screenSize.height - 300) / 2, 350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		groupNumberLabel.setBounds(30, 40, 200, 40);
		label2.setBounds(30, 60, 300, 40);
		field1.setBounds(200, 53, 20, 17);
		field2.setBounds(245, 73, 30, 17);
		button.setBounds(210, 130, 110, 40);
		frame.setVisible(true);
		frame.add(groupNumberLabel);
		frame.add(label2);
		frame.add(field1);
		frame.add(field2);
		frame.add(button);

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				NumberOfGroups = Integer.parseInt(field1.getText());
				NumberOfContenders = Integer.parseInt(field2.getText());
				System.out.println(NumberOfGroups + "\n" + NumberOfContenders);
				creation();
				anothermethod(); // �� �����
				frame.setVisible(false);
				TableFrame.FirstCount();
			}

		});
	}

	public static void main(String[] args) {
		Entering();

		System.out.println("start");
	}

}
