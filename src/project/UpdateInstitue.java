package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateInstitue extends JFrame {

	private JPanel contentPane;
	private JTextField textLoginUser;
	private JTextField textLoginPass;
	private JTextField textIName;
	private JTextField textICode;
	private JTextField textUCode;
	private JTextField textUpdateSearchIC;
	private JTextField textUpdateValue;
	private JButton btnUpdate;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateInstitue frame = new UpdateInstitue();
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
	public UpdateInstitue() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
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
		textField.setBounds(684, 341, 100, 20);
		contentPane.add(textField);
		
		textLoginUser = new JTextField();
		textLoginUser.setBounds(10, 63, 123, 20);
		contentPane.add(textLoginUser);
		textLoginUser.setColumns(10);
		
		textLoginPass = new JTextField();
		textLoginPass.setBounds(10, 94, 123, 20);
		contentPane.add(textLoginPass);
		textLoginPass.setColumns(10);
		
		textIName = new JTextField();
		textIName.setText("");
		textIName.setBounds(10, 166, 245, 20);
		contentPane.add(textIName);
		textIName.setColumns(10);
		
		textICode = new JTextField();
		textICode.setBounds(10, 261, 245, 20);
		contentPane.add(textICode);
		textICode.setColumns(10);
		
		textUCode = new JTextField();
		textUCode.setBounds(10, 197, 245, 20);
		contentPane.add(textUCode);
		textUCode.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter University Code");
		lblNewLabel.setBounds(265, 200, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Inst\u0131tue Code");
		lblNewLabel_1.setBounds(265, 264, 124, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Inst\u0131tue Name");
		lblNewLabel_2.setBounds(265, 169, 124, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(143, 97, 112, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setBounds(143, 66, 98, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblLeftMsg = new JLabel("");
		lblLeftMsg.setBounds(10, 336, 245, 14);
		contentPane.add(lblLeftMsg);
		
		
		String url="jdbc:sqlserver://DESKTOP-JTUUUED\\SQLEXPRESS;databaseName=NTDB";
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Query="insert into INSTITUE\r\n"
							+ "(I_Code,I_Name,U_Code)\r\n"
							+ "values\r\n"
							+ "('"+textICode.getText() +"','"+ textIName.getText() +"','"+ textUCode.getText() +"')";
				
				try {
					Connection con=DriverManager.getConnection(url,textLoginUser.getText(),textLoginPass.getText());
					Statement st= con.createStatement();
					int i=st.executeUpdate(Query);
					
					if(i==1)
					{
					lblLeftMsg.setText("your request has been sent");
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblLeftMsg.setText(e1.getLocalizedMessage());
				}
				
			}
		});
		btnAdd.setBounds(10, 302, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String Query="delete from INSTITUE\r\n"
					+ "where I_Code='"+textICode.getText() +"'";
			
			try {
				Connection con=DriverManager.getConnection(url,textLoginUser.getText(),textLoginPass.getText());
				Statement st= con.createStatement();
				int i=st.executeUpdate(Query);
				
				if(i==1)
				{
				lblLeftMsg.setText("your request has been sent");
				}
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				lblLeftMsg.setText(e1.getLocalizedMessage());
			}
				
			}
		});
		btnDelete.setBounds(166, 302, 89, 23);
		contentPane.add(btnDelete);
		
		
		JLabel lblUpdateValue = new JLabel("");
		lblUpdateValue.setBounds(510, 205, 91, 14);
		contentPane.add(lblUpdateValue);
		
		
		textUpdateSearchIC = new JTextField();
		textUpdateSearchIC.setEnabled(false);
		textUpdateSearchIC.setBounds(447, 151, 147, 20);
		contentPane.add(textUpdateSearchIC);
		textUpdateSearchIC.setColumns(10);
		
		textUpdateValue = new JTextField();
		textUpdateValue.setEnabled(false);
		textUpdateValue.setBounds(447, 218, 245, 20);
		contentPane.add(textUpdateValue);
		textUpdateValue.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Enter new");
		lblNewLabel_6.setBounds(447, 205, 72, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblUpdate = new JLabel("");
		lblUpdate.setBounds(508, 108, 147, 14);
		contentPane.add(lblUpdate);
		
		JLabel lblNewLabel_8 = new JLabel("Select what you want to update");
		lblNewLabel_8.setBounds(447, 51, 188, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Updating");
		lblNewLabel_9.setVisible(false);
		lblNewLabel_9.setBounds(457, 108, 86, 14);
		contentPane.add(lblNewLabel_9);
		
		DefaultComboBoxModel elements= new DefaultComboBoxModel();
		elements.addElement("Institue Name");
		elements.addElement("Institue Code");
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				
				textUpdateSearchIC.setEnabled(true);
				textUpdateValue.setEnabled(true);
				btnUpdate.setEnabled(true);
				lblNewLabel_9.setVisible(true);
				
				
				lblUpdate.setText(comboBox.getSelectedItem().toString());
				lblUpdateValue.setText(comboBox.getSelectedItem().toString());
			
				
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		comboBox.setBounds(447, 76, 147, 22);
		contentPane.add(comboBox);
		comboBox.setModel(elements);
		
		JLabel lblMsg = new JLabel("");
		lblMsg.setBounds(447, 315, 245, 14);
		contentPane.add(lblMsg);
		
		btnUpdate = new JButton("Update tuple");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String Query;
				    int i=-1;
				 try {
					Connection con=DriverManager.getConnection(url,textLoginUser.getText(),textLoginPass.getText());
					Statement st=con.createStatement();
				
					if(lblUpdate.getText()=="Institue Name") {
						
						
						Query="update INSTITUE\r\n"
								+ "set I_Name='" +textUpdateValue.getText()  +"' \r\n"
								+ "where I_Code='"+textUpdateSearchIC.getText()+"'";;
						
				        i=st.executeUpdate(Query);
							
						
					}if( lblUpdate.getText()=="Institue Code") {
						
						
						Query="update INSTITUE\r\n"
							+ "set I_Code='" +textUpdateValue.getText() +"' \r\n"
							+ "where I_Code='"+textUpdateSearchIC.getText() +"'";
							
								i=st.executeUpdate(Query);

					}
					
					if(i==1) {
						lblMsg.setText("Your update has been done");
					}else {
						lblMsg.setText(" Something wrong plase try again later..");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					lblMsg.setText(e1.getLocalizedMessage());
					e1.printStackTrace();
				}
				
				
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(447, 260, 188, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel_7 = new JLabel("Enter updating tuple's Code");
		lblNewLabel_7.setBounds(447, 136, 188, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_10 = new JLabel("Enter your information again please");
		lblNewLabel_10.setBounds(10, 125, 179, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Update Institue");
		lblNewLabel_11.setBounds(10, 28, 137, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_5 = new JLabel("If you're going to use deletion please leave empty Name and UniCode");
		lblNewLabel_5.setBounds(20, 228, 411, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Institue List");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Institue_List page=new Institue_List();
				page.setVisible(true);
			}
		});
		btnNewButton.setBounds(616, 76, 137, 23);
		contentPane.add(btnNewButton);		
	}
}
