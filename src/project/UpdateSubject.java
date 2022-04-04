package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateSubject extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textField;
	private JButton btnAddSubject;
	private JButton btnDeleteSubject;
	private JLabel lblMsg;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnList;
	private JTextField textFieldkodek;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSubject frame = new UpdateSubject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateSubject() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		textFieldkodek = new JTextField();
		textFieldkodek.setText("2020 kodek inc. ");
		textFieldkodek.setFont(new Font("Arial Black", Font.PLAIN, 10));
		textFieldkodek.setEnabled(false);
		textFieldkodek.setEditable(false);
		textFieldkodek.setColumns(10);
		textFieldkodek.setBounds(464, 241, 100, 20);
		contentPane.add(textFieldkodek);
		
		textUsername = new JTextField();
		textUsername.setBounds(10, 67, 100, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(10, 98, 100, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(10, 193, 224, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(10, 268, 224, 14);
		contentPane.add(lblMsg);
		
		
		String url="jdbc:sqlserver://DESKTOP-JTUUUED\\SQLEXPRESS;databaseName=NTDB";
		
		btnAddSubject = new JButton("Add Subject");
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Query="insert into SUBJECTS\r\n"
						   + "(subjects)\r\n"
						   + "values \r\n"
						   + "('"+textField.getText()+"')";
				
				try {
					Connection connection=DriverManager.getConnection(url,textUsername.getText(),textPassword.getText());
					Statement st=connection.createStatement();
					int rs=st.executeUpdate(Query);
					
					if(rs==1) {
						lblMsg.setText("Your request has been sent...");
					}
				
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
						lblMsg.setText(e1.getLocalizedMessage());
					
				}
				
				
			}
		});
		btnAddSubject.setBounds(10, 224, 110, 23);
		contentPane.add(btnAddSubject);
		
		btnDeleteSubject = new JButton("Delete subject");
		btnDeleteSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Query="delete from SUBJECTS\r\n"
						   + "where subjects='"+textField.getText()+"'";
				
				try {
					Connection connection=DriverManager.getConnection(url,"sa","keremberkkan89");
					Statement st=connection.createStatement();
					int rs=st.executeUpdate(Query);
					
					if(rs==1) {
						lblMsg.setText("Your request has been sent...");
					}
				
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
						lblMsg.setText(e1.getLocalizedMessage());
					
				}
				
				
			}
		});
		btnDeleteSubject.setBounds(122, 224, 112, 23);
		contentPane.add(btnDeleteSubject);
		
	
		lblNewLabel_1 = new JLabel("Enter Subject Name");
		lblNewLabel_1.setBounds(10, 172, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Enter Username");
		lblNewLabel_2.setBounds(121, 70, 123, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Enter Password");
		lblNewLabel_3.setBounds(120, 101, 124, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Update Subject");
		lblNewLabel_4.setBounds(10, 42, 123, 14);
		contentPane.add(lblNewLabel_4);
		
		btnList = new JButton("List");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Subject_List page= new Subject_List();
				page.setVisible(true);
			}
		});
		btnList.setBounds(264, 192, 89, 23);
		contentPane.add(btnList);
		
	
	
	
	}

}
