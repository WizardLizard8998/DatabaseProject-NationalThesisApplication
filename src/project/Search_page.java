package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import NTA.tables.*;

import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Search_page extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textAreaInfo;
	private JTextField textQuickSearch;
	private JTextField textThesisNo;
	private JTextField textAuthor;
	private JComboBox textUniversity;
	private JTextField textYear;
	private JTextField textFieldAuthor;
	private JTextField txtEnterAUniversity;
	private JTextField txtEnterWrittenYear;
	private JTextField txtSelectType;
	private JTextField textField_1;
	private JTextField textLName;
	private JTextField txtEnterAuthorsLast;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_page frame = new Search_page();
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
	public Search_page() throws SQLException {
		
		
		String  url="jdbc:sqlserver://DESKTOP-JTUUUED\\SQLEXPRESS;databaseName=NTDB"; // connect to server. 
		String username="sa";
		String password="password123";
		
		
		Connection connection= DriverManager.getConnection(url,username,password);
		
		
		
		setTitle("National Thesis- Search");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
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
		textField.setBounds(934, 591, 100, 20);
		contentPane.add(textField);
		
		textAreaInfo = new JTextArea();
		textAreaInfo.setLineWrap(true);
		textAreaInfo.setBackground(UIManager.getColor("Button.background"));
		textAreaInfo.setForeground(new Color(0, 0, 0));
		textAreaInfo.setFont(new Font("Arial Black", Font.BOLD, 11));
		textAreaInfo.setText("This is National Thesis Search page. \r\nYou can Search for any thesis in the thesis database, \r\n");
		textAreaInfo.setEditable(false);
		textAreaInfo.setBounds(10, 11, 383, 50);
		contentPane.add(textAreaInfo);
		
		textQuickSearch = new JTextField();
		textQuickSearch.setBorder(null);
		textQuickSearch.setText("Quick search (thesis no.)");
		textQuickSearch.setEditable(false);
		textQuickSearch.setBounds(10, 64, 147, 20);
		contentPane.add(textQuickSearch);
		textQuickSearch.setColumns(10);
		
		textThesisNo = new JTextField();
		textThesisNo.setToolTipText("Enter a Thesis no. ");
		textThesisNo.setBounds(10, 95, 147, 20);
		contentPane.add(textThesisNo);
		textThesisNo.setColumns(10);
		
		textAuthor = new JTextField();
		textAuthor.setToolTipText("Enter author name");
		textAuthor.setColumns(10);
		textAuthor.setBounds(400, 44, 147, 20);
		contentPane.add(textAuthor);
		
		
		
		DefaultComboBoxModel elementsUni=new DefaultComboBoxModel();
		
		String QueryUni="select U_Name from UNIVERSITY";
		
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(QueryUni);
		
		while(rs.next()) {
			elementsUni.addElement(rs.getString("U_Name"));
		}
		
		
		
		textUniversity = new JComboBox();
		textUniversity.setToolTipText("Enter University name ");
		textUniversity.setBounds(707, 109, 154, 20);
		contentPane.add(textUniversity);
		textUniversity.setModel(elementsUni);
		
		textYear = new JTextField();
		textYear.setToolTipText("Enter a year (written)");
		textYear.setColumns(10);
		textYear.setBounds(400, 166, 147, 20);
		contentPane.add(textYear);
		
		DefaultComboBoxModel elementsType=new DefaultComboBoxModel();
		
		
		String QueryType="select Ty_ID from TYPES";
		
		Connection con2=DriverManager.getConnection(url,username,password);
		Statement st2= con2.createStatement();
		ResultSet rs2=st2.executeQuery(QueryType);
		
		while(rs2.next()) {
			elementsType.addElement(rs2.getString("Ty_ID"));
		}
		
		
		JComboBox listTypeSelect = new JComboBox();
		listTypeSelect.setBackground(Color.WHITE);
		listTypeSelect.setBorder(null);
		listTypeSelect.setBounds(707, 43, 154, 23);
		contentPane.add(listTypeSelect);
		listTypeSelect.setModel(elementsType);
		

		DefaultComboBoxModel elementsLang=new DefaultComboBoxModel();
		
		String QueryLang="select L_ID from LANGUAGES";
		
		Connection con3=DriverManager.getConnection(url,username,password);
		Statement st3= con3.createStatement();
		ResultSet rs3=st3.executeQuery(QueryLang);
		
		while(rs3.next()) {
			elementsLang.addElement(rs3.getString("L_ID"));
		}
		
		
		
		JComboBox comboBoxLang = new JComboBox();
		comboBoxLang.setBounds(707, 77, 154, 21);
		contentPane.add(comboBoxLang);
		comboBoxLang.setModel(elementsLang);
		
		textFieldAuthor = new JTextField();
		textFieldAuthor.setBorder(null);
		textFieldAuthor.setEditable(false);
		textFieldAuthor.setText("Enter a Author name");
		textFieldAuthor.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldAuthor.setBounds(557, 44, 123, 20);
		contentPane.add(textFieldAuthor);
		textFieldAuthor.setColumns(10);
		
		textLName = new JTextField();
		textLName.setToolTipText("Enter author name");
		textLName.setColumns(10);
		textLName.setBounds(400, 75, 147, 20);
		contentPane.add(textLName);
		
		txtEnterAUniversity = new JTextField();
		txtEnterAUniversity.setBorder(null);
		txtEnterAUniversity.setEditable(false);
		txtEnterAUniversity.setText("select a University ");
		txtEnterAUniversity.setHorizontalAlignment(SwingConstants.LEFT);
		txtEnterAUniversity.setColumns(10);
		txtEnterAUniversity.setBounds(871, 109, 140, 20);
		contentPane.add(txtEnterAUniversity);
		
		txtEnterWrittenYear = new JTextField();
		txtEnterWrittenYear.setBorder(null);
		txtEnterWrittenYear.setEditable(false);
		txtEnterWrittenYear.setText("Enter written year");
		txtEnterWrittenYear.setHorizontalAlignment(SwingConstants.LEFT);
		txtEnterWrittenYear.setColumns(10);
		txtEnterWrittenYear.setBounds(400, 149, 123, 20);
		contentPane.add(txtEnterWrittenYear);
		
		txtSelectType = new JTextField();
		txtSelectType.setBorder(null);
		txtSelectType.setEditable(false);
		txtSelectType.setText("Select type");
		txtSelectType.setHorizontalAlignment(SwingConstants.LEFT);
		txtSelectType.setColumns(10);
		txtSelectType.setBounds(871, 44, 123, 20);
		contentPane.add(txtSelectType);
		
		
		JEditorPane dtrpnSearchResult = new JEditorPane();
		dtrpnSearchResult.setEditable(false);
		dtrpnSearchResult.setText("");
		dtrpnSearchResult.setBounds(20, 197, 632, 383);
		contentPane.add(dtrpnSearchResult);
		
		JButton btnQuickSearch = new JButton("Search");
		btnQuickSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dtrpnSearchResult.setVisible(true);
				
   String QueryQuick="select \r\n"
			+ "	T.T_No ,T.T_Title, T.T_Abstract , T.WrittenYear,T.PageNumber, T.SubmissionDate, T.subjects,\r\n"
			+ "	A.A_FName,A.A_LName,\r\n"
			+ "	L.Languages,\r\n"
			+ "	Types,\r\n"
			+ "	Sv.Sv_FName,Sv.Sv_LName,\r\n"
			+ "	Sv2.Sv_FName as CoSv,Sv2.Sv_LName as CoSvL,\r\n"
			+ "	I_Name, U_Name\r\n"
			+ "from THESIS as T\r\n"
			+ "		inner join AUTHOR as A\r\n"
			+ "			on T.A_Code=A.A_Code\r\n"
			+ "		inner join LANGUAGES as L\r\n"
			+ "			on L.L_ID=T.L_ID\r\n"
			+ "		inner join SUBJECTS as S\r\n"
			+ "			on S.subjects=T.subjects\r\n"
			+ "		inner join TYPES as Ty\r\n"
			+ "			on Ty.Ty_ID=T.Ty_ID\r\n"
			+ "		inner join SUPERVISOR as Sv\r\n"
			+ "			on Sv.Sv_Code=T.Sv_Code\r\n"
			+ "		left outer join SUPERVISOR as Sv2\r\n"
			+ "			on Sv2.Sv_Code=T.Sv2_Code\r\n"
			+ "		inner join INSTITUE as I\r\n"
			+ "			on I.I_Code=Sv.I_Code\r\n"
			+ "		inner join UNIVERSITY as U\r\n"
			+ "			on U.U_Code=I.U_Code"
   		+ "			where T_No=" + textThesisNo.getText();
   		
   		
				try {
					Statement st1=connection.createStatement();
					ResultSet rs1=st1.executeQuery(QueryQuick);
					
					
					
					while(rs1.next()) {
					
						dtrpnSearchResult.setText("Thesis No: "+rs1.getString("T_No")+"\n\n"
								  +"Thesis Title: "+rs1.getString("T_Title") + "\n\n"
								  +"Thesis Abstract: "+rs1.getString("T_Abstract") + "\n\n"
								  +"Thesis Author: "+rs1.getString("A_FName") + " " +rs1.getString("A_LName") + "\n\n"
								  +"Thesis Supervisor: "+rs1.getString("Sv_FName")+ " "+rs1.getString("Sv_LName")+"   " +"CoSupervisor:"+rs1.getString("CoSv")+" "+rs1.getString("CoSvL") + "\n\n"
								  +"Thesis Language: "+rs1.getString("Languages") + "\t" +"Written Year: " +rs1.getString("WrittenYear") + "\n\n"
								  +"Thesis Uni : "+rs1.getString("U_Name") + "\t" +"Institue Name: " +rs1.getString("I_Name") +"\n\n"
								  + "Subject : "+ rs1.getString("subjects")+ "\t"+ "Type Of Thesis : "+rs1.getString("Types"));
					
					
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					dtrpnSearchResult.setText(e1.getLocalizedMessage());
					e1.printStackTrace();
				}
			
			}
		});
		btnQuickSearch.setBounds(167, 95, 89, 23);
		contentPane.add(btnQuickSearch);
	
		
		textField_1 = new JTextField();
		textField_1.setText("Advanced Search");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(417, 24, 147, 20);
		contentPane.add(textField_1);
	
		DefaultListModel results=new DefaultListModel();
		
		JButton btnAdvancedSearch = new JButton("Search by Author");
		btnAdvancedSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			results.removeAllElements();

				StringBuilder QueryAdvanced= new StringBuilder();
				
				QueryAdvanced.append("select \r\n"
						+ "	T.T_No ,T.T_Title, T.T_Abstract , T.WrittenYear,T.PageNumber, T.SubmissionDate, T.subjects,\r\n"
						+ "	A.A_FName,A.A_LName,\r\n"
						+ "	L.Languages,\r\n"
						+ "	Types,\r\n"
						+ "	Sv.Sv_FName,Sv.Sv_LName,\r\n"
						+ "	Sv2.Sv_FName as CoSv,Sv2.Sv_LName as CoSvL,\r\n"
						+ "	I_Name, U_Name\r\n"
						+ "from THESIS as T\r\n"
						+ "		inner join AUTHOR as A\r\n"
						+ "			on T.A_Code=A.A_Code\r\n"
						+ "		inner join LANGUAGES as L\r\n"
						+ "			on L.L_ID=T.L_ID\r\n"
						+ "		inner join SUBJECTS as S\r\n"
						+ "			on S.subjects=T.subjects\r\n"
						+ "		inner join TYPES as Ty\r\n"
						+ "			on Ty.Ty_ID=T.Ty_ID\r\n"
						+ "		inner join SUPERVISOR as Sv\r\n"
						+ "			on Sv.Sv_Code=T.Sv_Code\r\n"
						+ "		left outer join SUPERVISOR as Sv2\r\n"
						+ "			on Sv2.Sv_Code=T.Sv2_Code\r\n"
						+ "		inner join INSTITUE as I\r\n"
						+ "			on I.I_Code=Sv.I_Code\r\n"
						+ "		inner join UNIVERSITY as U\r\n"
						+ "			on U.U_Code=I.U_Code"
				   		+ "	where A_FName='" +textAuthor.getText() +"' and A_LName='"+textLName.getText()+"'");
				
						
				
				
							
				try {
					Connection connection=DriverManager.getConnection(url,username,password);
					Statement stA=connection.createStatement();
					ResultSet rsA=stA.executeQuery(QueryAdvanced.toString());
						
				
					
					
					
					while(rsA.next()) {

						
						results.addElement(rsA.getString("T_No")
									 +"      //Thesis Title: "+rsA.getString("T_Title")
									 +"  //Thesis Author: "+rsA.getString("A_FName") + " " +rsA.getString("A_LName"));
									
					
						
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					dtrpnSearchResult.setText(e1.getLocalizedMessage());
					
					e1.printStackTrace();
				}
			
				
				
			}
		});
		btnAdvancedSearch.setBounds(400, 101, 131, 23);
		contentPane.add(btnAdvancedSearch);
		
		txtEnterAuthorsLast = new JTextField();
		txtEnterAuthorsLast.setText("Enter Author's Last Name");
		txtEnterAuthorsLast.setHorizontalAlignment(SwingConstants.LEFT);
		txtEnterAuthorsLast.setEditable(false);
		txtEnterAuthorsLast.setColumns(10);
		txtEnterAuthorsLast.setBorder(null);
		txtEnterAuthorsLast.setBounds(557, 77, 140, 20);
		contentPane.add(txtEnterAuthorsLast);
	
		
		JLabel lblNewLabel = new JLabel("Select Language");
		lblNewLabel.setBounds(871, 80, 108, 14);
		contentPane.add(lblNewLabel);
		
		
		
		
		JButton btnNewButton = new JButton("Search by Year");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				results.removeAllElements();
				
				 String QueryYear="select \r\n"
							+ "	T.T_No ,T.T_Title, T.T_Abstract , T.WrittenYear,T.PageNumber, T.SubmissionDate, T.subjects,\r\n"
							+ "	A.A_FName,A.A_LName,\r\n"
							+ "	L.Languages,\r\n"
							+ "	Types,\r\n"
							+ "	Sv.Sv_FName,Sv.Sv_LName,\r\n"
							+ "	Sv2.Sv_FName as CoSv,Sv2.Sv_LName as CoSvL,\r\n"
							+ "	I_Name, U_Name\r\n"
							+ "from THESIS as T\r\n"
							+ "		inner join AUTHOR as A\r\n"
							+ "			on T.A_Code=A.A_Code\r\n"
							+ "		inner join LANGUAGES as L\r\n"
							+ "			on L.L_ID=T.L_ID\r\n"
							+ "		inner join SUBJECTS as S\r\n"
							+ "			on S.subjects=T.subjects\r\n"
							+ "		inner join TYPES as Ty\r\n"
							+ "			on Ty.Ty_ID=T.Ty_ID\r\n"
							+ "		inner join SUPERVISOR as Sv\r\n"
							+ "			on Sv.Sv_Code=T.Sv_Code\r\n"
							+ "		left outer join SUPERVISOR as Sv2\r\n"
							+ "			on Sv2.Sv_Code=T.Sv2_Code\r\n"
							+ "		inner join INSTITUE as I\r\n"
							+ "			on I.I_Code=Sv.I_Code\r\n"
							+ "		inner join UNIVERSITY as U\r\n"
							+ "			on U.U_Code=I.U_Code"
					   	+ "			where WrittenYear=" + textYear.getText();
					
				 try {
						Connection connection=DriverManager.getConnection(url,username,password);
						Statement stY=connection.createStatement();
						ResultSet rsY=stY.executeQuery(QueryYear);
							
					
						
						
						
						while(rsY.next()) {

							
							results.addElement(rsY.getString("T_No")
										 +"  Thesis Title: "+rsY.getString("T_Title")
										 +"  Thesis Author: "+rsY.getString("A_FName") + " " +rsY.getString("A_LName"));
										
						
							
						}
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						dtrpnSearchResult.setText("Something went wrong please restart page....(error)");
						
						e1.printStackTrace();
					}
				 
				 
					   		
			
			
			}
					
		});
		btnNewButton.setBounds(551, 165, 115, 23);
		contentPane.add(btnNewButton);
		
		
		
		btnNewButton_1 = new JButton("Search by selection");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				results.removeAllElements();
				
				 String QuerySelection="select \r\n"
							+ "	T.T_No ,T.T_Title, T.T_Abstract , T.WrittenYear,T.PageNumber, T.SubmissionDate, T.subjects,\r\n"
							+ "	A.A_FName,A.A_LName,\r\n"
							+ "	L.Languages,\r\n"
							+ "	Types,\r\n"
							+ "	Sv.Sv_FName,Sv.Sv_LName,\r\n"
							+ "	Sv2.Sv_FName as CoSv,Sv2.Sv_LName as CoSvL,\r\n"
							+ "	I_Name, U_Name\r\n"
							+ "from THESIS as T\r\n"
							+ "		inner join AUTHOR as A\r\n"
							+ "			on T.A_Code=A.A_Code\r\n"
							+ "		inner join LANGUAGES as L\r\n"
							+ "			on L.L_ID=T.L_ID\r\n"
							+ "		inner join SUBJECTS as S\r\n"
							+ "			on S.subjects=T.subjects\r\n"
							+ "		inner join TYPES as Ty\r\n"
							+ "			on Ty.Ty_ID=T.Ty_ID\r\n"
							+ "		inner join SUPERVISOR as Sv\r\n"
							+ "			on Sv.Sv_Code=T.Sv_Code\r\n"
							+ "		left outer join SUPERVISOR as Sv2\r\n"
							+ "			on Sv2.Sv_Code=T.Sv2_Code\r\n"
							+ "		inner join INSTITUE as I\r\n"
							+ "			on I.I_Code=Sv.I_Code\r\n"
							+ "		inner join UNIVERSITY as U\r\n"
							+ "			on U.U_Code=I.U_Code"
+ "			where Ty.Ty_ID='"+listTypeSelect.getSelectedItem().toString()+"' and T.L_ID='"+comboBoxLang.getSelectedItem().toString()+"' and U_Name='"+textUniversity.getSelectedItem().toString()+"'";
				
				 
				 try {
						Connection connection=DriverManager.getConnection(url,username,password);
						Statement stS=connection.createStatement();
						ResultSet rsS=stS.executeQuery(QuerySelection);
							
					
						
						
						
						while(rsS.next()) {

							
							results.addElement(rsS.getString("T_No")
										 +"        // Title: "+rsS.getString("T_Title")
										 +" // Author: "+rsS.getString("A_FName") + " " +rsS.getString("A_LName"));
										
						
							
						}
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						dtrpnSearchResult.setText(e1.getLocalizedMessage());
						
						e1.printStackTrace();
					}
				 
				 
				 
			}
		});
		btnNewButton_1.setBounds(707, 146, 154, 23);
		contentPane.add(btnNewButton_1);
			
		scrollPane = new JScrollPane();
		scrollPane.setBounds(662, 197, 362, 383);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				String QueryQuick="select \r\n"
						+ "	T.T_No ,T.T_Title, T.T_Abstract , T.WrittenYear,T.PageNumber, T.SubmissionDate, T.subjects,\r\n"
						+ "	A.A_FName,A.A_LName,\r\n"
						+ "	L.Languages,\r\n"
						+ "	Types,\r\n"
						+ "	Sv.Sv_FName,Sv.Sv_LName,\r\n"
						+ "	Sv2.Sv_FName as CoSv,Sv2.Sv_LName as CoSvL,\r\n"
						+ "	I_Name, U_Name\r\n"
						+ "from THESIS as T\r\n"
						+ "		inner join AUTHOR as A\r\n"
						+ "			on T.A_Code=A.A_Code\r\n"
						+ "		inner join LANGUAGES as L\r\n"
						+ "			on L.L_ID=T.L_ID\r\n"
						+ "		inner join SUBJECTS as S\r\n"
						+ "			on S.subjects=T.subjects\r\n"
						+ "		inner join TYPES as Ty\r\n"
						+ "			on Ty.Ty_ID=T.Ty_ID\r\n"
						+ "		inner join SUPERVISOR as Sv\r\n"
						+ "			on Sv.Sv_Code=T.Sv_Code\r\n"
						+ "		left outer join SUPERVISOR as Sv2\r\n"
						+ "			on Sv2.Sv_Code=T.Sv2_Code\r\n"
						+ "		inner join INSTITUE as I\r\n"
						+ "			on I.I_Code=Sv.I_Code\r\n"
						+ "		inner join UNIVERSITY as U\r\n"
						+ "			on U.U_Code=I.U_Code"
				   		+ "			where T_No=" +list.getSelectedValue().toString().substring(0, 7);
				   		
				   		
								try {
									Statement st1=connection.createStatement();
									ResultSet rs1=st1.executeQuery(QueryQuick);
									
									
									
									while(rs1.next()) {
									
										dtrpnSearchResult.setText("Thesis No: "+rs1.getString("T_No")+"\n\n"
												  +"Thesis Title: "+rs1.getString("T_Title") + "\n\n"
												  +"Thesis Abstract: "+rs1.getString("T_Abstract") + "\n\n"
												  +"Thesis Author: "+rs1.getString("A_FName") + " " +rs1.getString("A_LName") + "\n\n"
												  +"Thesis Supervisor: "+rs1.getString("Sv_FName")+ " "+rs1.getString("Sv_LName")+"   " +"CoSupervisor:"+rs1.getString("CoSv")+" "+rs1.getString("CoSvL") + "\n\n"
												  +"Thesis Language: "+rs1.getString("Languages") + "\t" +"Written Year: " +rs1.getString("WrittenYear") + "\n\n"
												  +"Thesis Uni : "+rs1.getString("U_Name") + "\t" +"Institue Name: " +rs1.getString("I_Name") +"\n\n"
												  + "Subject : "+ rs1.getString("subjects")+ "\t"+ "Type Of Thesis : "+rs1.getString("Types"));
									
									
										
									}
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									dtrpnSearchResult.setText("Something went wrong please try again....(error)");
									e1.printStackTrace();
								}
				
			
				
			}
		});
		scrollPane.setViewportView(list);
		list.setModel(results);
		
		
	
		
				
		
	}
}
