package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Institue_List extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Institue_List frame = new Institue_List();
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
	public Institue_List() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 550, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	
		DefaultListModel listValue=new DefaultListModel();
		listValue.addElement("Institue Code                                	  Institue Name                                 University Code ");
		listValue.addElement("--------------------------------------------------------------------------");
		
		try {
			String Print="select * from INSTITUE";
			String  url="jdbc:sqlserver://DESKTOP-JTUUUED\\SQLEXPRESS;databaseName=NTDB";
			Connection con = DriverManager.getConnection(url,"sa","password123");
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(Print);
			
			while(rs.next()) {
				
				String shown= rs.getString("I_Code")+"-------------"+rs.getString("I_Name")+"----------------"+rs.getString("U_Code");
			
				listValue.addElement(shown);
				
			}
		
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		JList list = new JList();
		list.setBounds(10, 36, 414, 334);
		contentPane.add(list);
		list.setModel(listValue);
		
	}

}
