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

public class Author_List extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Author_List frame = new Author_List();
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
	public Author_List() {
		setTitle("Author List");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		DefaultListModel listValue=new DefaultListModel();
		listValue.addElement("Author Code 	  Author Name /Surname        Author Password");
		listValue.addElement("------------------------------------------------");
		
		try {
			String Print="select * from AUTHOR";
			String  url="jdbc:sqlserver://DESKTOP-JTUUUED\\SQLEXPRESS;databaseName=NTDB";
			Connection con = DriverManager.getConnection(url,"sa","password123");
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(Print);
			
			while(rs.next()) {
				
				String shown= rs.getString("A_Code")+"------- "+rs.getString("A_FName")+" "+rs.getString("A_LName")+"--------"+rs.getString("A_Password");
			
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
