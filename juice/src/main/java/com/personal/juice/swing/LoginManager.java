package com.personal.juice.swing;

import com.personal.juice.sql.LoginController;
import com.personal.juice.swing.DrinkListManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;

import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;

public class LoginManager extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField passwordField;
	
	public LoginManager() {
		setTitle("로그인");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JPanel slayout = new JPanel();
		contentPane.add(slayout, BorderLayout.SOUTH);
		slayout.setLayout(null);
		
		JPanel clayout = new JPanel();
		clayout.setBackground(new Color(255, 255, 255));
		contentPane.add(clayout, BorderLayout.CENTER);
		clayout.setLayout(null);
		
		idField = new JTextField();
		idField.setToolTipText("아이디를 입력해주세요");
		idField.setBounds(192, 69, 342, 40);
		clayout.add(idField);
		idField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(192, 119, 342, 40);
		clayout.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setBounds(106, 78, 86, 28);
		clayout.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(89, 129, 86, 28);
		clayout.add(lblNewLabel_1);
		
		JButton xbtn = new JButton("종료");
		xbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		xbtn.setForeground(Color.BLACK);
		xbtn.setBackground(Color.WHITE);
		xbtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		xbtn.setBounds(437, 187, 97, 36);
		clayout.add(xbtn);
		
		JButton checkbtn = new JButton("로그인");
		checkbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = idField.getText();
				String password = new String(passwordField.getPassword());
		        LoginController.verifyLogin(LoginManager.this, id, password);
			}
		});
		checkbtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		checkbtn.setForeground(Color.BLACK);
		checkbtn.setBackground(Color.WHITE);
		checkbtn.setBounds(328, 187, 97, 36);
		clayout.add(checkbtn);
		
		JButton addbtn = new JButton("회원가입");
		addbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterManager registerManager = new RegisterManager();
			    registerManager.setVisible(true);
			}
		});
		addbtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		addbtn.setForeground(Color.BLACK);
		addbtn.setBackground(Color.WHITE);
		addbtn.setBounds(219, 187, 97, 36);
		clayout.add(addbtn);
	}
}
