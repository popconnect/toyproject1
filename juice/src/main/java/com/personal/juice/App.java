package com.personal.juice;

import java.awt.EventQueue;

import com.personal.juice.swing.LoginManager;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginManager frame = new LoginManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
