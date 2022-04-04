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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

public class Language_List extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Language_List frame = new Language_List();
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
	public Language_List() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel listValue=new DefaultListModel();
		listValue.addElement("Lang_ID--------Language ");
		listValue.addElement("----------------------");
		
		try {
			String Print="select * from LANGUAGES";
			String  url="jdbc:sqlserver://DESKTOP-JTUUUED\\SQLEXPRESS;databaseName=NTDB";
			Connection con = DriverManager.getConnection(url,"sa","password123");
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(Print);
			
			while(rs.next()) {
				
				String shown= rs.getString("L_ID")+"-----"+rs.getString("Languages");
			
				listValue.addElement(shown);
				
			}
		
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		JList list = new JList();
		list.setBounds(10, 11, 414, 339);
		contentPane.add(list);
		list.setModel(listValue);
	}

}
