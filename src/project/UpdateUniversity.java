package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TexturePaint;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class UpdateUniversity extends JFrame {

	private JPanel contentPane;
	private JTextField textUserLogin;
	private JTextField textPasswordLogin;
	private JTextField textUniCode;
	private JTextField textUniName;
	private JTextField textFindTuple;
	private JTextField textUpdateTuple;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUniversity frame = new UpdateUniversity();
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
	public UpdateUniversity() {
		setTitle("Update University");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 760, 420);
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
		textField.setBounds(644, 361, 100, 20);
		contentPane.add(textField);
		
		textUserLogin = new JTextField();
		textUserLogin.setBounds(10, 73, 137, 20);
		contentPane.add(textUserLogin);
		textUserLogin.setColumns(10);
		
		textPasswordLogin = new JTextField();
		textPasswordLogin.setBounds(10, 104, 137, 20);
		contentPane.add(textPasswordLogin);
		textPasswordLogin.setColumns(10);
		
		textUniCode = new JTextField();
		textUniCode.setBounds(10, 216, 190, 20);
		contentPane.add(textUniCode);
		textUniCode.setColumns(10);
		
		textUniName = new JTextField();
		textUniName.setBounds(10, 267, 190, 20);
		contentPane.add(textUniName);
		textUniName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("University Page");
		lblNewLabel.setBounds(10, 47, 137, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Username");
		lblNewLabel_1.setBounds(158, 76, 104, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Password");
		lblNewLabel_2.setBounds(157, 107, 105, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter University Code");
		lblNewLabel_3.setBounds(10, 191, 137, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Enter University Name");
		lblNewLabel_4.setBounds(10, 247, 137, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblMsg = new JLabel("");
		lblMsg.setBounds(10, 343, 320, 14);
		contentPane.add(lblMsg);
		
		JLabel lblNewLabel_6 = new JLabel("New ");
		lblNewLabel_6.setBounds(492, 247, 46, 14);
		contentPane.add(lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		
		
		String url="jdbc:sqlserver://DESKTOP-JTUUUED\\SQLEXPRESS;databaseName=NTDB";
		
		
		JButton btnDeleteUni = new JButton("Delete University");
		btnDeleteUni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String Query="		delete from UNIVERSITY\r\n"
					   + "		where U_Code='" +textUniCode.getText()+ "'  and U_Name='" +textUniName.getText()+ "'";
			
			try {
				Connection con=DriverManager.getConnection(url,textUserLogin.getText(),textPasswordLogin.getText());
				Statement st= con.createStatement();
				int rs=st.executeUpdate(Query);
				
				if(rs==1) {
					lblMsg.setText("Deletion has been sent...");
				}else {
					lblMsg.setText("(deletion) Something wrong plase try again later..");
				}				
			
				
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				lblMsg.setText(e1.getMessage());
			}
		
			
			
			
			}
			
		});
		btnDeleteUni.setBounds(10, 298, 124, 23);
		contentPane.add(btnDeleteUni);
		
		JButton btnAddUni = new JButton("Add University");
		btnAddUni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String Query="insert into UNIVERSITY"
					+ "(U_Code,U_Name)"
					+ "values"
					+ "('"+ textUniCode.getText() +"','"+ textUniName.getText() +"')";
			
			
			
			
			try {
				Connection con=DriverManager.getConnection(url,textUserLogin.getText(),textPasswordLogin.getText());
				Statement st= con.createStatement();
				int rs=st.executeUpdate(Query);
				
				if(rs==1) {
					lblMsg.setText("Your adding request has been sent...");
				}else {
					lblMsg.setText(" (adding)Something wrong plase try again later..");
				}				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				lblMsg.setText(e1.getMessage());
			}		
			}
		});
		btnAddUni.setBounds(144, 298, 118, 23);
		contentPane.add(btnAddUni);
		
		
		textFindTuple = new JTextField();
		textFindTuple.setEnabled(false);
		textFindTuple.setBounds(347, 216, 135, 20);
		contentPane.add(textFindTuple);
		textFindTuple.setColumns(10);
		
		textUpdateTuple = new JTextField();
		textUpdateTuple.setEnabled(false);
		textUpdateTuple.setBounds(347, 244, 135, 20);
		contentPane.add(textUpdateTuple);
		textUpdateTuple.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Update University");
		lblNewLabel_5.setBounds(347, 133, 124, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblUpdate = new JLabel("");
		lblUpdate.setBounds(390, 191, 81, 14);
		contentPane.add(lblUpdate);
		
		JLabel lblNewLabel_7 = new JLabel("Enter Id to find ");
		lblNewLabel_7.setBounds(492, 219, 114, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblTuple = new JLabel("");
		lblTuple.setBounds(521, 247, 115, 14);
		contentPane.add(lblTuple);
		
		JLabel lblUpdateMsg = new JLabel("");
		lblUpdateMsg.setBounds(347, 343, 259, 14);
		contentPane.add(lblUpdateMsg);
		
		
		DefaultComboBoxModel elements= new DefaultComboBoxModel();
		elements.addElement("University Name");
		elements.addElement("University Id");
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			
			lblUpdate.setText(comboBox.getSelectedItem().toString());
			textUpdateTuple.setEnabled(true);
			textFindTuple.setEnabled(true);
			lblTuple.setText(comboBox.getSelectedItem().toString());
			lblNewLabel_6.setVisible(true);
				
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		comboBox.setBounds(347, 158, 124, 22);
		contentPane.add(comboBox);
		comboBox.setModel(elements);
		
		
		JButton btnNewButton = new JButton("Update University");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Query;
				int i=-1;
				
				try {
					Connection con=DriverManager.getConnection(url,textUserLogin.getText(),textPasswordLogin.getText());
					Statement st=con.createStatement();
					
					if(lblUpdate.getText()=="University Name") {
						Query="update UNIVERSITY\r\n"
							+ "set U_Name='" +textUpdateTuple.getText()+ "'\r\n"
							+ "where U_Code='" +textFindTuple.getText()+ "'";
						
						i=st.executeUpdate(Query);
								
						
					}
					
					if(lblUpdate.getText()=="University Id") {
						Query="update UNIVERSITY\r\n"
							+ "set U_Code='" +textUpdateTuple.getText()+ "'\r\n"
							+ "where U_Code='" +textFindTuple.getText()+ "'";
						
						i=st.executeUpdate(Query);			
						
					}
					
					if(i==1) {
						lblUpdateMsg.setText("Your process is done ");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblUpdateMsg.setText(e1.getMessage());
				}
				
				
				
			}
		});
		btnNewButton.setBounds(347, 298, 124, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_10 = new JLabel("Update");
		lblNewLabel_10.setBounds(347, 191, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_8 = new JLabel("Add New University");
		lblNewLabel_8.setBounds(10, 166, 124, 14);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_1 = new JButton("Uni List");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				University_List list= new University_List();
				list.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(347, 47, 191, 46);
		contentPane.add(btnNewButton_1);
		
		
		

	
		
		
		
		
	}
}
