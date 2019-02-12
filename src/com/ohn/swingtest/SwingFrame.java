package com.ohn.swingtest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class SwingFrame extends JFrame implements ActionListener {

	static SwingFrame sf;
	JButton btn;
	JLabel label;
	ImageIcon[] icon;
	Timer time;
	JPanel p;

	int counter = 0; //test

	public SwingFrame(String title) {
		//setVisible(true);
		setTitle(title);
		setBounds(300, 300, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// タイマーの生成
		time = new Timer(100, this);

		icon = new ImageIcon[3];

		icon[0] = new ImageIcon("res/cat0.jpg");
		icon[1] = new ImageIcon("res/cat1.jpg");
		icon[2] = new ImageIcon("res/cat2.jpg");

		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);

		btn = new JButton("Push");
		btn.addActionListener(this);

		p = new JPanel();
		p.setLayout(new BorderLayout());

		p.add(btn, BorderLayout.PAGE_START);

		getContentPane().add(p, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		new SwingFrame("Test").setVisible(true);
//		sf.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == btn) {
			time.start();
		} else if (source == time) {
			System.out.println("counter=" + counter);
			label.setIcon(icon[counter]);
			p.add(label);
			if (counter != icon.length - 1) {
				counter++;
			} else {
				time.stop();
				counter = 0;
			}
		}

	}

}
