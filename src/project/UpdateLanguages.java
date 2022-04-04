package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateLanguages extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textLangName;
	private JTextField textLangID;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateLanguages frame = new UpdateLanguages();
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
	public UpdateLanguages() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 470, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String url="jdbc:sqlserver://DESKTOP-JTUUUED\\SQLEXPRESS;databaseName=NTDB";
		
		textField = new JTextField();
		textField.setText("2020 kodek inc. ");
		textField.setFont(new Font("Arial Black", Font.PLAIN, 10));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(344, 358, 110, 23 );
		contentPane.add(textField);
		
		textUsername = new JTextField();
		textUsername.setBounds(10, 67, 100, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(10, 98, 100, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		lblNewLabel = new JLabel("Update Lang");
		lblNewLabel.setBounds(10, 39, 85, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Enter Username");
		lblNewLabel_1.setBounds(128, 70, 85, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Enter Password");
		lblNewLabel_2.setBounds(128, 101, 85, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("enter your information again");
		lblNewLabel_3.setBounds(10, 129, 177, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("for Adding fill all blanks // for Deleting fill just ID");
		lblNewLabel_4.setBounds(10, 208, 237, 14);
		contentPane.add(lblNewLabel_4);
		
		textLangName = new JTextField();
		textLangName.setBounds(10, 243, 118, 20);
		contentPane.add(textLangName);
		textLangName.setColumns(10);
		
		textLangID = new JTextField();
		textLangID.setBounds(188, 243, 110, 20);
		contentPane.add(textLangID);
		textLangID.setColumns(10);
		
		JLabel lblErrMsg = new JLabel("");
		lblErrMsg.setBounds(10, 356, 153, 14);
		contentPane.add(lblErrMsg);
		
		
		JButton btnAdd = new JButton("Add Language");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String Query="insert into LANGUAGES"
							+ "(L_ID,Languages) "
							+ "values\r\n"
							+ "('"+ textLangID.getText() +"','"+ textLangName.getText() +"')";	
					
					
					try {
						Connection con=DriverManager.getConnection(url,textUsername.getText(),textPassword.getText());
						Statement st=con.createStatement();
						int rs= st.executeUpdate(Query);
						
						if(rs==1) {
							lblErrMsg.setText("Your request has beent sent...");
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						lblErrMsg.setText(e1.getLocalizedMessage());
					}
			
			
			
			}
		});
		btnAdd.setBounds(10, 319, 118, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete Language");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Query="delete from  LANGUAGES \r\n"
						   + "where L_ID='"+ textLangID.getText() +"'";	
					
					
					try {
						Connection con=DriverManager.getConnection(url,textUsername.getText(),textPassword.getText());
						Statement st=con.createStatement();
						int rs= st.executeUpdate(Query);
						
						if(rs==1) {
							lblErrMsg.setText("Your request has beent sent...");
						}

						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						lblErrMsg.setText(e1.getLocalizedMessage());
					}
			
			}
		});
		btnDelete.setBounds(156, 319, 118, 23);
		contentPane.add(btnDelete);
		

		JLabel lblNewLabel_6 = new JLabel("Enter Lang name");
		lblNewLabel_6.setBounds(10, 271, 118, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Enter Lang ID");
		lblNewLabel_7.setBounds(188, 271, 110, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnList = new JButton("List");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Language_List page=new Language_List();
			page.setVisible(true);
			
			}
		});
		btnList.setBounds(334, 319, 89, 23);
		contentPane.add(btnList);
		
		
		
		
		
		
		
	}
}
