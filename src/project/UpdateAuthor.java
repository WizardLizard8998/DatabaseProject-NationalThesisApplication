 package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.List;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Panel;

public class UpdateAuthor extends JFrame {

	private JPanel contentPane;
	private JTextField textA_ID;
	private JTextField textA_FN;
	private JTextField textA_LN;
	private JTextField textA_P;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textFindID;
	private JTextField textNewValue;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAuthor frame = new UpdateAuthor();
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
	public UpdateAuthor() {
		setTitle("Update Author");
		setBounds(100, 100, 760, 424);
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
		textField.setBounds(644, 365, 100, 20);
		contentPane.add(textField);
		
		textUsername = new JTextField();
		textUsername.setBounds(10, 67, 100, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(10, 98, 100, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter username");
		lblNewLabel_2.setBounds(120, 70, 105, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter password");
		lblNewLabel_2_1.setBounds(120, 101, 119, 14);
		contentPane.add(lblNewLabel_2_1);
		
		String url="jdbc:sqlserver://DESKTOP-JTUUUED\\SQLEXPRESS;databaseName=NTDB";
		
		JLabel lblNewLabel = new JLabel("Update Author ");
		lblNewLabel.setBounds(10, 11, 350, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddNew = new JLabel("Add New Author");
		lblAddNew.setBounds(10, 170, 100, 14);
		contentPane.add(lblAddNew);
		
		textA_ID = new JTextField();
		textA_ID.setBounds(10, 195, 130, 20);
		contentPane.add(textA_ID);
		textA_ID.setColumns(10);
		
		textA_FN = new JTextField();
		textA_FN.setColumns(10);
		textA_FN.setBounds(10, 226, 130, 20);
		contentPane.add(textA_FN);
		
		textA_LN = new JTextField();
		textA_LN.setColumns(10);
		textA_LN.setBounds(10, 257, 130, 20);
		contentPane.add(textA_LN);
		
		textA_P = new JTextField();
		textA_P.setColumns(10);
		textA_P.setBounds(10, 288, 130, 20);
		contentPane.add(textA_P);
		
		JLabel lblAddResult = new JLabel("");
		lblAddResult.setBounds(20, 360, 230, 14);
		contentPane.add(lblAddResult);
		
		JButton btnAddNew = new JButton("Add Author");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			String Query="insert into AUTHOR"
					+ "(A_Code,A_FName,A_LName,A_Password)"
					+ "values"
					+ "("+ textA_ID.getText() +",'"+ textA_FN.getText() +"','"+ textA_LN.getText() +"','"+ textA_P.getText() +"')";	
				
				
				try {
					Connection con=DriverManager.getConnection(url,textUsername.getText(),textPassword.getText());
					Statement st=con.createStatement();
					int rs= st.executeUpdate(Query);
					
					if(rs==1) {
						lblAddResult.setText("Your request has beent sent...");
					}else {
						lblAddResult.setText("something wrong.Please check your statement.");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblAddResult.setText("something wrong.Please check your statement.");
				}
				
				
			}
		});
		btnAddNew.setBounds(10, 319, 119, 23);
		contentPane.add(btnAddNew);
		
		JLabel lblEnterAuthorId = new JLabel("Enter Author ID");
		lblEnterAuthorId.setBounds(150, 198, 100, 14);
		contentPane.add(lblEnterAuthorId);
		
		JLabel lblEnterAuthorsFirst = new JLabel("Enter Author's first name");
		lblEnterAuthorsFirst.setBounds(150, 229, 158, 14);
		contentPane.add(lblEnterAuthorsFirst);
		
		JLabel lblEnterAuthorsLast = new JLabel("Enter Author's last name");
		lblEnterAuthorsLast.setBounds(150, 260, 140, 14);
		contentPane.add(lblEnterAuthorsLast);
		
		JLabel lblSetPasswordauthors = new JLabel("Set Password (Author's first name)");
		lblSetPasswordauthors.setBounds(150, 291, 222, 14);
		contentPane.add(lblSetPasswordauthors);
		
		JLabel lblSelectcombo = new JLabel("");
		lblSelectcombo.setBounds(461, 158, 137, 14);
		contentPane.add(lblSelectcombo);
		
		JLabel lblSearch = new JLabel("Enter ID");
		lblSearch.setBounds(579, 189, 100, 14);
		contentPane.add(lblSearch);
		
		JLabel lblSelectcombo_1 = new JLabel("");
		lblSelectcombo_1.setBounds(607, 214, 137, 14);
		contentPane.add(lblSelectcombo_1);
		
		JLabel lblNew = new JLabel("new");
		lblNew.setBounds(579, 214, 30, 14);
		contentPane.add(lblNew);
		lblNew.setVisible(false);
		
		DefaultComboBoxModel elements= new DefaultComboBoxModel();
		elements.addElement("Id");
		elements.addElement("First Name");
		elements.addElement("Last Name");
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				
				textFindID.setEditable(true);
				
				textNewValue.setEditable(true);
				
				lblSelectcombo.setText(comboBox.getSelectedItem().toString());
				lblNew.setVisible(true);
				lblSelectcombo_1.setText(comboBox.getSelectedItem().toString());
				
			
				
			}

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		comboBox.setModel(elements);
		comboBox.setBounds(418, 122, 137, 25);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Select what you want to update");
		lblNewLabel_1.setBounds(418, 98, 210, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("enter your information again");
		lblNewLabel_3.setBounds(10, 129, 189, 14);
		contentPane.add(lblNewLabel_3);
		
		textFindID = new JTextField();
		textFindID.setEditable(false);
		textFindID.setBounds(419, 183, 150, 20);
		contentPane.add(textFindID);
		textFindID.setColumns(10);
		
		textNewValue = new JTextField();
		textNewValue.setEditable(false);
		textNewValue.setColumns(10);
		textNewValue.setBounds(419, 214, 150, 20);
		contentPane.add(textNewValue);
		
		JLabel lblQuery = new JLabel("");
		lblQuery.setBounds(419, 291, 287, 23);
		contentPane.add(lblQuery);
		
		
		JButton btnSearch = new JButton("Update tuple");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String Query;
				    int i=-1;
				 try {
					Connection con=DriverManager.getConnection(url,textUsername.getText(),textPassword.getText());
					Statement st=con.createStatement();
				
					if(lblSelectcombo.getText()=="Id") {
						
						
						Query="update AUTHOR\r\n"
						 + "		set A_Code=" + textNewValue.getText() +"\r\n"
						 + "		where A_Code='"+ textFindID.getText() +"'";
					
						        i=st.executeUpdate(Query);
							
						
					}if( lblSelectcombo.getText()=="First Name") {
						
						
						Query="update AUTHOR\r\n"
								 + "		set A_FName='" + textNewValue.getText() +"'\r\n"
								 + "		where A_Code='"+ textFindID.getText() +"'";
							
								i=st.executeUpdate(Query);

					}if(lblSelectcombo.getText()=="Last Name") {
						
						
						Query="update AUTHOR\r\n"
								 + "		set A_LName='" + textNewValue.getText() +"'\r\n"
								 + "		where A_Code='"+ textFindID.getText() +"'";
							
								
								i=st.executeUpdate(Query);

					}
					
					if(i==1) {
						lblQuery.setText("Your request has been sent");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					lblQuery.setText(e1.getMessage());
					e1.printStackTrace();
				}
				 
				
				
			}
		});
		btnSearch.setBounds(419, 239, 123, 23);
		contentPane.add(btnSearch);
		
		JButton btnNewButton = new JButton("Delete Author");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Query="delete from AUTHOR\r\n"
						   + "where A_Code="+textA_ID.getText();

				try {
					Connection con= DriverManager.getConnection(url,textUsername.getText(),textPassword.getText());
					Statement st=con.createStatement();
					
					int rs=st.executeUpdate(Query);
					
					if(rs==1) {
						lblAddResult.setText("Your request has beent sent...");
					}else {
						lblAddResult.setText("something wrong.Please check your statement.");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblAddResult.setText(e1.getLocalizedMessage());
				}
				
				
			}
		});
		btnNewButton.setBounds(139, 319, 119, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Author List");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Author_List page= new Author_List();
				page.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(419, 339, 179, 35);
		contentPane.add(btnNewButton_1);	
		
		JLabel lblNewLabel_4 = new JLabel("New");
		lblNewLabel_4.setBounds(428, 158, 46, 14);
		contentPane.add(lblNewLabel_4);
	
	}
}
