package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.sql.StatementEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update_page extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lbltitle;
	private JLabel lblLowerTitle;
	private JTextField textUsername;
	private JTextField textPassword;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JButton btnNewButton;
	private JLabel lblINFO;
	private JButton btnAddAuthor;
	private JButton btnAddUniversity;
	private JButton btnAddInstitue;
	private JButton btnAddSuperVisor;
	private JButton btnDeleteThesis;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblDeleteMsg;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_page frame = new Update_page();
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
	public Update_page() throws SQLException {
		
		String  url="jdbc:sqlserver://DESKTOP-JTUUUED\\SQLEXPRESS;databaseName=NTDB"; // connect to server. 

		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 580, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("2020 kodek inc. ");
		textField.setFont(new Font("Arial Black", Font.PLAIN, 10));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(464, 241, 100, 20);
		contentPane.add(textField);
		
		lbltitle = new JLabel("UPDATE DATABASE ");
		lbltitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltitle.setBounds(10, 11, 354, 38);
		contentPane.add(lbltitle);
		
		lblLowerTitle = new JLabel("This page is only for Developers ");
		lblLowerTitle.setBounds(10, 60, 214, 30);
		contentPane.add(lblLowerTitle);
		
		textUsername = new JTextField();
		textUsername.setBounds(10, 116, 154, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(10, 159, 154, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		lblUserName = new JLabel("Connection username");
		lblUserName.setBounds(10, 101, 154, 14);
		contentPane.add(lblUserName);
		
		lblPassword = new JLabel("Connection Password");
		lblPassword.setBounds(10, 147, 154, 14);
		contentPane.add(lblPassword);
		
		lblINFO = new JLabel("");
		lblINFO.setBounds(10, 231, 214, 30);
		contentPane.add(lblINFO);
		
		
		btnAddAuthor = new JButton("Update Author");
		btnAddAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAuthor page= new UpdateAuthor();
				page.setVisible(true);
			}
		});
		btnAddAuthor.setEnabled(false);
		btnAddAuthor.setBounds(224, 64, 140, 23);
		contentPane.add(btnAddAuthor);
		
		btnAddUniversity = new JButton("Update University");
		btnAddUniversity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			UpdateUniversity page= new UpdateUniversity();
			page.setVisible(true);
			
			
			}
		});
		btnAddUniversity.setEnabled(false);
		btnAddUniversity.setBounds(382, 64, 140, 23);
		contentPane.add(btnAddUniversity);
		
		btnAddInstitue = new JButton("Update Institue");
		btnAddInstitue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateInstitue page = new UpdateInstitue();
				page.setVisible(true);
				
				
			}
		});
		btnAddInstitue.setEnabled(false);
		btnAddInstitue.setBounds(382, 97, 140, 23);
		contentPane.add(btnAddInstitue);
		
		btnAddSuperVisor = new JButton("Update Supervisor");
		btnAddSuperVisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			UpdateSuperVisor page= new UpdateSuperVisor();
			page.setVisible(true);
			
			}
		});
		btnAddSuperVisor.setEnabled(false);
		btnAddSuperVisor.setBounds(382, 131, 140, 23);
		contentPane.add(btnAddSuperVisor);
		
		JButton btnUpdateLanguages = new JButton("Update Languages");
		btnUpdateLanguages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateLanguages page=new UpdateLanguages();
				page.setVisible(true);
			}
		});
		btnUpdateLanguages.setEnabled(false);
		btnUpdateLanguages.setBounds(224, 131, 140, 22);
		contentPane.add(btnUpdateLanguages);
		
		JButton btnUpdateSubject = new JButton("Update Subject");
		btnUpdateSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateSubject page=new UpdateSubject();
				page.setVisible(true);
			}
		});
		btnUpdateSubject.setEnabled(false);
		btnUpdateSubject.setBounds(224, 98, 140, 21);
		contentPane.add(btnUpdateSubject);
		
		
		btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection= DriverManager.getConnection(url,textUsername.getText(),textPassword.getText());
					lblINFO.setText("Login successfull you may continue");
					btnAddAuthor.setEnabled(true);
					btnAddUniversity.setEnabled(true);
					btnAddInstitue.setEnabled(true);
					btnAddSuperVisor.setEnabled(true);
					btnUpdateLanguages.setEnabled(true);
					btnUpdateSubject.setEnabled(true); 
					btnDeleteThesis.setEnabled(true);
					textField_1.setEnabled(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					lblINFO.setText(e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 198, 89, 23);
		contentPane.add(btnNewButton);	
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(272, 200, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel = new JLabel("Thesis No");
		lblNewLabel.setBounds(272, 175, 63, 14);
		contentPane.add(lblNewLabel);
		
		lblDeleteMsg = new JLabel("");
		lblDeleteMsg.setBounds(272, 241, 144, 14);
		contentPane.add(lblDeleteMsg);
		
		btnDeleteThesis = new JButton("Delete Thesis");
		btnDeleteThesis.setEnabled(false);
		btnDeleteThesis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Query="delete from THESIS"
						   + " where T_No="+ textField_1.getText();
				
				try {
					Connection connection= DriverManager.getConnection(url,textUsername.getText(),textPassword.getText());
					Statement st=connection.createStatement();
					int rs=st.executeUpdate(Query);
					
					if(rs==1) {
						lblDeleteMsg.setText("Request has been done");
					}
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblDeleteMsg.setText(e1.getLocalizedMessage());
				}
				
				
			}
		});
		btnDeleteThesis.setBounds(368, 198, 118, 23);
		contentPane.add(btnDeleteThesis);
		
		
		
		
		
	}
}
