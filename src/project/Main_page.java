package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Main_page extends JFrame {

	private JPanel contentPane;
	private JTextField txtKodekInc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_page frame = new Main_page();
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
	public Main_page() {
		setTitle("NATIONAL THESIS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 256, 160, 14);
		contentPane.add(lblNewLabel);
		
	JButton btnSearch = new JButton("Search thesis");
		btnSearch.addActionListener(new ActionListener() { // opens the search tab 
			public void actionPerformed(ActionEvent e) {
				Search_page page1;
				try {
					page1 = new Search_page();
					page1.setVisible(true);
					
					System.out.println("Connection successfull...");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblNewLabel.setText("Connection error...");
				}
		
				
				
			}
		}							);
		
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setToolTipText("Opens new frame");
		btnSearch.setBounds(40, 95, 130, 90);
		contentPane.add(btnSearch);
		
		
		
	JButton btnUpdate = new JButton("Update thesis");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // opens the Update tab 
				try {
					Update_page page2=new Update_page();
					page2.setVisible(true);
					System.out.println("Connection successfull...");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblNewLabel.setText("Connection error...");
				}
			}
		}							);
	
		btnUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdate.setToolTipText("Opens new frame");
		btnUpdate.setBounds(235, 95, 130, 90);
		contentPane.add(btnUpdate);
		
	
		
	JButton btnAdd_New = new JButton("Add  new thesis");
		btnAdd_New.addActionListener(new ActionListener() { // opens the AddNew tab 
			public void actionPerformed(ActionEvent e) {
				try {
					AddNew_page page3=new AddNew_page();
					page3.setVisible(true);
					System.out.println("Connection successfull...");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblNewLabel.setText("Connection error...");
				}
			
			}
		}							);
		btnAdd_New.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd_New.setToolTipText("Opens new frame");
		btnAdd_New.setBounds(440, 95, 130, 90);
		contentPane.add(btnAdd_New);

		
		
	JTextArea textWelcome = new JTextArea();
		textWelcome.setText("WELCOME TO NATIONAL THESIS APPLICATION");
		textWelcome.setFont(new Font("Monospaced", Font.BOLD, 20));
		textWelcome.setEditable(false);
		textWelcome.setBounds(72, 30, 466, 31);
		contentPane.add(textWelcome);
		
		txtKodekInc = new JTextField();
		txtKodekInc.setFont(new Font("Arial Black", Font.PLAIN, 10));
		txtKodekInc.setText("2020 kodek inc. ");
		txtKodekInc.setEnabled(false);
		txtKodekInc.setEditable(false);
		txtKodekInc.setBounds(534, 286, 100, 20);
		contentPane.add(txtKodekInc);
		txtKodekInc.setColumns(10);
		
	
		
		
		
	}
}
