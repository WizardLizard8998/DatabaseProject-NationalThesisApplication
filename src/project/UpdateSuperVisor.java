package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateSuperVisor extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textSVCode;
	private JTextField textSVFN;
	private JTextField textSVLN;
	private JTextField textIC;
	private JTextField textFindID;
	private JTextField textUpdate;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSuperVisor frame = new UpdateSuperVisor();
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
	public UpdateSuperVisor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 420);
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
		textField.setBounds(684, 361, 100, 20);
		contentPane.add(textField);
		
		textUsername = new JTextField();
		textUsername.setBounds(10, 67, 131, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(10, 98, 131, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		textSVCode = new JTextField();
		textSVCode.setBounds(10, 184, 196, 20);
		contentPane.add(textSVCode);
		textSVCode.setColumns(10);
		
		textSVFN = new JTextField();
		textSVFN.setBounds(10, 215, 196, 20);
		contentPane.add(textSVFN);
		textSVFN.setColumns(10);
		
		textSVLN = new JTextField();
		textSVLN.setBounds(10, 246, 196, 20);
		contentPane.add(textSVLN);
		textSVLN.setColumns(10);
		
		textIC = new JTextField();
		textIC.setBounds(10, 277, 196, 20);
		contentPane.add(textIC);
		textIC.setColumns(10);
		
		JLabel lblStatusMsg = new JLabel("");
		lblStatusMsg.setBounds(10, 342, 247, 14);
		contentPane.add(lblStatusMsg);
		
		String url="jdbc:sqlserver://DESKTOP-JTUUUED\\SQLEXPRESS;databaseName=NTDB";
		
		JButton btnAddButton = new JButton("Add Supervisor");
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String Query="insert into SUPERVISOR\r\n"
						   + "(Sv_Code,Sv_FName,SV_LName,I_Code)\r\n"
						   + "values\r\n"
						   + "(" +textSVCode.getText()+ ",'" +textSVFN.getText()+ "','" +textSVLN.getText()+ "','" +textIC.getText()+ "')";
				
				
				

				try {
					
					Connection con=DriverManager.getConnection(url,textUsername.getText(),textPassword.getText());
					Statement st=con.createStatement();
					int rs=st.executeUpdate(Query);
					

					if(rs==1) {
						lblStatusMsg.setText("Your adding request has been sent...");
					}else {
						lblStatusMsg.setText(" (adding)Something wrong plase try again later..");
					}			
					
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblStatusMsg.setText(e1.getLocalizedMessage());
				}
			
			}
		});
		btnAddButton.setBounds(7, 308, 123, 23);
		contentPane.add(btnAddButton);
		
		JButton btnDeleteButton = new JButton("Delete Supervisor");
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Query="delete from SUPERVISOR \r\n"
						   + "where SV_Code='"+textSVCode.getText()+"'";
				
				try {
					
					Connection con=DriverManager.getConnection(url,textUsername.getText(),textPassword.getText());
					Statement st=con.createStatement();
					int rs=st.executeUpdate(Query);
					

					if(rs==1) {
						lblStatusMsg.setText("Your adding request has been sent...");
					}else {
						lblStatusMsg.setText(" (adding)Something wrong plase try again later..");
					}			
					
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblStatusMsg.setText(e1.getLocalizedMessage());
				}
			}
		});
		btnDeleteButton.setBounds(140, 308, 117, 23);
		contentPane.add(btnDeleteButton);
		
		JLabel lblNewLabel = new JLabel("Supervisor Page");
		lblNewLabel.setBounds(10, 42, 131, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Username");
		lblNewLabel_1.setBounds(151, 70, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Password");
		lblNewLabel_2.setBounds(151, 101, 106, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Add New Supervisor");
		lblNewLabel_3.setBounds(10, 159, 131, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Supervisor Code");
		lblNewLabel_4.setBounds(216, 187, 109, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("First Name");
		lblNewLabel_5.setBounds(216, 218, 109, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Last Name");
		lblNewLabel_6.setBounds(216, 249, 109, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Institue Code");
		lblNewLabel_7.setBounds(216, 280, 109, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton_2 = new JButton("Supervisor List");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supervisor_List page= new Supervisor_List();
				page.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(460, 38, 147, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblUpdateMsg = new JLabel("");
		lblUpdateMsg.setBounds(503, 159, 104, 14);
		contentPane.add(lblUpdateMsg);
		
		JLabel lblUpdateMsg2 = new JLabel("");
		lblUpdateMsg2.setBounds(651, 231, 109, 14);
		contentPane.add(lblUpdateMsg2);
		
		DefaultComboBoxModel elements= new DefaultComboBoxModel();
		elements.addElement("Firstname");
		elements.addElement("Lastname");
		elements.addElement("Supervisor Code");
		elements.addElement("Institue Code");
		
		JComboBox comboBox = new JComboBox();
		comboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				lblUpdateMsg.setText(comboBox.getSelectedItem().toString());
				lblUpdateMsg2.setText(comboBox.getSelectedItem().toString());
				textUpdate.setEnabled(true);
				textFindID.setEnabled(true);
				
				
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		comboBox.setBounds(460, 122, 147, 20);
		contentPane.add(comboBox);
		comboBox.setModel(elements);
		
		JLabel lblNewLabel_8 = new JLabel("Update Institue");
		lblNewLabel_8.setBounds(460, 101, 97, 14);
		contentPane.add(lblNewLabel_8);
		
		textFindID = new JTextField();
		textFindID.setEnabled(false);
		textFindID.setBounds(460, 184, 147, 20);
		contentPane.add(textFindID);
		textFindID.setColumns(10);
		
		textUpdate = new JTextField();
		textUpdate.setEnabled(false);
		textUpdate.setBounds(460, 228, 147, 20);
		contentPane.add(textUpdate);
		textUpdate.setColumns(10);
		

		JLabel lblUpdateErrMsg = new JLabel("");
		lblUpdateErrMsg.setBounds(460, 344, 203, 14);
		contentPane.add(lblUpdateErrMsg);
		
		JButton btnNewButton_3 = new JButton("Update Tuple");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Query;
				int i=-1;
				
				try {
					Connection con=DriverManager.getConnection(url,textUsername.getText(),textPassword.getText());
					Statement st=con.createStatement();
					
					if(lblUpdateMsg.getText()=="Firstname") {
						Query="update SUPERVISOR \r\n"
							+ "set Sv_FName ='" +textUpdate.getText()+ "' \r\n"
							+ "where Sv_Code=" +textFindID.getText();
						
						i=st.executeUpdate(Query);
								
						
					}
					
					if(lblUpdateMsg.getText()=="Lastname") {
						Query="update SUPERVISOR \r\n"
								+ "set Sv_LName ='" +textUpdate.getText()+ "' \r\n"
								+ "where Sv_Code = " +textFindID.getText();
						
						i=st.executeUpdate(Query);
								
						
					}
					
					if(lblUpdateMsg.getText()=="Supervisor Code") {
						Query="update SUPERVISOR \r\n"
								+ "set Sv_Code='" +textUpdate.getText()+ "'\r\n"
								+ "where Sv_Code='" +textFindID.getText()+ "'";
						
						i=st.executeUpdate(Query);			
						
					}
					
					if(lblUpdateMsg.getText()=="Institue Code") {
						Query="update SUPERVISOR \r\n"
								+ "set I_Code='" +textUpdate.getText()+ "'\r\n"
								+ "where I_Code='" +textFindID.getText()+ "'";
						
						i=st.executeUpdate(Query);
								
						
					}
					
					if(i==1) {
						lblUpdateErrMsg.setText("Your process is done ");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblUpdateErrMsg.setText(e1.getMessage());
				}
				
				
				
			}
		});
		btnNewButton_3.setBounds(460, 276, 147, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_9 = new JLabel("Enter your information again ");
		lblNewLabel_9.setBounds(10, 129, 152, 14);
		contentPane.add(lblNewLabel_9);
		
	
		
		
		JLabel lblNewLabel_12 = new JLabel("Find Tuple (enter Id)");
		lblNewLabel_12.setBounds(617, 187, 135, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New ");
		lblNewLabel_13.setBounds(617, 231, 46, 14);
		contentPane.add(lblNewLabel_13);
		
		
		
		JLabel lblNewLabel_15 = new JLabel("Update");
		lblNewLabel_15.setBounds(460, 159, 46, 14);
		contentPane.add(lblNewLabel_15);
		
		
	}
}
