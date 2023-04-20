package com.personal.juice.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import com.personal.combobox.BeverageComboboxModel;
import com.personal.combobox.BrandComboboxModel;
import com.personal.combobox.TypeComboboxModel;
import com.personal.juice.sql.SurveyController;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.ComponentOrientation;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SurveyUserInterface extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameField;
	private JTextField idField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField surveyField;
	private JComboBox cb1;
	private JComboBox cb2;
	private JComboBox cb3;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { try { SurveyUserInterface dialog =
	 * new SurveyUserInterface();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 */
	public SurveyUserInterface() {
		setTitle("평가하기");
		setResizable(false);
		setBounds(100, 100, 450, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		nameField = new JTextField();
		nameField.setBounds(92, 36, 116, 21);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
		idField = new JTextField();
		idField.setBounds(282, 36, 116, 21);
		contentPanel.add(idField);
		idField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(92, 78, 116, 21);
		contentPanel.add(phoneField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(282, 78, 116, 21);
		contentPanel.add(emailField);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(32, 39, 57, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(220, 39, 57, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이메일");
		lblNewLabel_2.setBounds(220, 81, 57, 15);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("연락처");
		lblNewLabel_3.setBounds(32, 81, 57, 15);
		contentPanel.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC74C\uB8CC \uC120\uD0DD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 125, 416, 120);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		cb1 = new JComboBox();
		cb1.setBounds(92, 18, 306, 23);
		panel.add(cb1);
		cb1.setModel(new TypeComboboxModel());
		cb1.addItemListener( new ItemListener() {
			public void itemStateChanged( ItemEvent e ) {
				if( e.getStateChange() == ItemEvent.SELECTED ) {
					//System.out.println(combo1.getSelectedItem());
					if(cb1 != null) {
						cb2.setModel(new BrandComboboxModel((String)cb1.getSelectedItem()));
						cb2.setSelectedIndex(0);
					}
				}
			}
		});
		
		cb2 = new JComboBox();
		cb2.setBounds(92, 51, 306, 23);
		panel.add(cb2);
		cb2.setModel(new BrandComboboxModel());
		cb2.addItemListener( new ItemListener() {
			public void itemStateChanged( ItemEvent e ) {
				if( e.getStateChange() == ItemEvent.SELECTED ) {
					if(cb2 != null) {
						System.out.println(cb1.getSelectedItem());
						System.out.println(cb2.getSelectedItem());
						cb3.setModel(new BeverageComboboxModel((String)cb1.getSelectedItem() ,(String)cb2.getSelectedItem()));
						cb3.setSelectedIndex(0);
					}
				}
			}
		} );
		
		cb3 = new JComboBox();
		cb3.setBounds(92, 84, 306, 23);
		panel.add(cb3);
		
		
		JLabel lblNewLabel_3_1 = new JLabel("음료 종류");
		lblNewLabel_3_1.setBounds(23, 22, 57, 15);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("브랜드 명");
		lblNewLabel_3_2.setBounds(23, 55, 57, 15);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("음료 이름");
		lblNewLabel_3_3.setBounds(23, 88, 57, 15);
		panel.add(lblNewLabel_3_3);
		
		JComboBox cb_rating = new JComboBox();
		cb_rating.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cb_rating.setBounds(306, 285, 116, 23);
		contentPanel.add(cb_rating);
		
		JLabel lblNewLabel_4 = new JLabel("나의 점수는");
		lblNewLabel_4.setBounds(237, 289, 64, 15);
		contentPanel.add(lblNewLabel_4);
		
		surveyField = new JTextField();
		surveyField.setBounds(12, 318, 410, 200);
		contentPanel.add(surveyField);
		surveyField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						SurveyController survey = new SurveyController
								((String)cb3.getSelectedItem(), nameField.getText(), phoneField.getText(), emailField.getText(),
										(String)cb1.getSelectedItem(), (String)cb_rating.getSelectedItem(), surveyField.getText());
						survey.insert();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
