package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.css.ElementCSSInlineStyle;

import NTA.tables.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class AddNew_page extends JFrame {

	private JPanel contentPane;
	private JTextField txtAddNewPage;
	private JTextField textField;
	private JTextField textPassword;
	private JTextField textNationalID;
	private JTextField textEnterTNo;
	private JComboBox textType;
	private JTextField textPageNumber;
	private JComboBox textLanguage;
	private JTextField textWrittenYear;
	private JTextField textTitle;
	private JLabel lblNewLabel;
	private JLabel lblEnterThesisTitle;
	private JLabel lblEnterThesisType;
	private JLabel lblEnterThesisPage;
	private JLabel lblEnterThesisLanguage;
	private JLabel lblEnterThesisWritten;
	private JLabel lblEnterThesisAbstract;
	private JTextField textFieldSVID;
	private JTextField textFieldCOSVID;
	private JTextArea textAbstract;
	private JButton btnNewButton;
	private JLabel lblAddResult;
	private JLabel lblLeaveNullIf;
	private JButton btnNewButton_1;
	private JLabel lblLoginMsg;
	private JComboBox comboBoxSubject;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNew_page frame = new AddNew_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddNew_page() throws SQLException {
		
		
		String  url="jdbc:sqlserver://DESKTOP-JTUUUED\\SQLEXPRESS;databaseName=NTDB"; // connect to server. 
		String username="sa";
		String password="password123";
		

	
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAddNewPage = new JTextField();
		txtAddNewPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtAddNewPage.setBorder(new EmptyBorder(5,5,5,5));
		txtAddNewPage.setEditable(false);
		txtAddNewPage.setBounds(10, 11, 218, 40);
		txtAddNewPage.setText("ADD NEW THESIS");
		contentPane.add(txtAddNewPage);
		txtAddNewPage.setColumns(10);
		
		textField = new JTextField();
		textField.setText("2020 kodek inc. ");
		textField.setFont(new Font("Arial Black", Font.PLAIN, 10));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(634, 591, 100, 20);
		contentPane.add(textField);
		
		JTextArea textProceedArea = new JTextArea();
		textProceedArea.setBackground(SystemColor.menu);
		textProceedArea.setEditable(false);
		textProceedArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textProceedArea.setText("To proceed please ;\r\nEnter your National ID\r\nEnter your password \r\n(if you have no password to set\r\nit might be in your SMS box)");
		textProceedArea.setBounds(10, 62, 195, 84);
		contentPane.add(textProceedArea);
		
		textPassword = new JTextField();
		textPassword.setBounds(10, 187, 145, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		

		
		textNationalID = new JTextField();
		textNationalID.setColumns(10);
		textNationalID.setBounds(10, 157, 145, 20);
		contentPane.add(textNationalID);
		
		
		
		textEnterTNo = new JTextField();
		textEnterTNo.setEnabled(false);
		textEnterTNo.setBounds(230, 40, 205, 20);
		contentPane.add(textEnterTNo);
		textEnterTNo.setColumns(10);
		
		textType = new JComboBox();
		textType.setModel(new DefaultComboBoxModel(new String[] {"MAS", "DOC", "PiA", "SiM"}));
		textType.setEnabled(false);
		textType.setBounds(230, 102, 368, 20);
		contentPane.add(textType);
		
		textPageNumber = new JTextField();
		textPageNumber.setEnabled(false);
		textPageNumber.setColumns(10);
		textPageNumber.setBounds(230, 133, 205, 20);
		contentPane.add(textPageNumber);
		
		DefaultComboBoxModel elementsLang= new DefaultComboBoxModel();
		
		String QueryLang="select L_ID from LANGUAGES";
		
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(QueryLang);
		
		while(rs.next()) {
			elementsLang.addElement(rs.getString("L_ID"));
			
		}
		
		
		
		
		textLanguage = new JComboBox();
		textLanguage.setBounds(230, 164, 205, 20);
		contentPane.add(textLanguage);
		textLanguage.setEnabled(false);
		textLanguage.setModel(elementsLang);
		
		textWrittenYear = new JTextField();
		textWrittenYear.setEnabled(false);
		textWrittenYear.setColumns(10);
		textWrittenYear.setBounds(230, 195, 205, 20);
		contentPane.add(textWrittenYear);
		
		textTitle = new JTextField();
		textTitle.setEnabled(false);
		textTitle.setColumns(10);
		textTitle.setBounds(230, 71, 368, 20);
		contentPane.add(textTitle);
		
		lblNewLabel = new JLabel("Enter Thesis Number");
		lblNewLabel.setBounds(459, 43, 126, 14);
		contentPane.add(lblNewLabel);
		
		lblEnterThesisTitle = new JLabel("Enter Thesis Title");
		lblEnterThesisTitle.setBounds(608, 74, 116, 14);
		contentPane.add(lblEnterThesisTitle);
		
		lblEnterThesisType = new JLabel("Enter Thesis Type");
		lblEnterThesisType.setBounds(608, 105, 116, 14);
		contentPane.add(lblEnterThesisType);
		
		lblEnterThesisPage = new JLabel("Enter Thesis Page Number");
		lblEnterThesisPage.setBounds(498, 136, 161, 14);
		contentPane.add(lblEnterThesisPage);
		
		lblEnterThesisLanguage = new JLabel("Enter Thesis Language");
		lblEnterThesisLanguage.setBounds(498, 163, 145, 14);
		contentPane.add(lblEnterThesisLanguage);
		
		lblEnterThesisWritten = new JLabel("Enter Thesis Written Year");
		lblEnterThesisWritten.setBounds(498, 198, 145, 14);
		contentPane.add(lblEnterThesisWritten);
		
		lblEnterThesisAbstract = new JLabel("Enter Thesis Abstract");
		lblEnterThesisAbstract.setBounds(10, 369, 126, 14);
		contentPane.add(lblEnterThesisAbstract);
		
		textFieldSVID = new JTextField();
		textFieldSVID.setEnabled(false);
		textFieldSVID.setColumns(10);
		textFieldSVID.setBounds(230, 257, 205, 20);
		contentPane.add(textFieldSVID);
		
		textFieldCOSVID = new JTextField();
		textFieldCOSVID.setEnabled(false);
		textFieldCOSVID.setColumns(10);
		textFieldCOSVID.setBounds(230, 288, 205, 20);
		contentPane.add(textFieldCOSVID);
		textFieldCOSVID.setText("null");
		
		JLabel lblEnterSupervisorId_1 = new JLabel("Enter SuperVisor ID");
		lblEnterSupervisorId_1.setBounds(498, 260, 126, 14);
		contentPane.add(lblEnterSupervisorId_1);
		
		JLabel lblEnterSupervisorId = new JLabel("Enter Co-SuperVisor ID");
		lblEnterSupervisorId.setBounds(498, 291, 145, 14);
		contentPane.add(lblEnterSupervisorId);
		
		textAbstract = new JTextArea();
		textAbstract.setEnabled(false);
		textAbstract.setBounds(10, 394, 714, 192);
		contentPane.add(textAbstract);
		
		lblAddResult = new JLabel("");
		lblAddResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddResult.setBounds(380, 361, 345, 32);
		contentPane.add(lblAddResult);
		
		DefaultComboBoxModel elements= new DefaultComboBoxModel();
		
		String Query="select * from SUBJECTS";
		
		Connection con2=DriverManager.getConnection(url,username,password);
		Statement st2= con2.createStatement();
		ResultSet rs2=st2.executeQuery(Query);
		
		while(rs2.next()) {
			elements.addElement(rs2.getString("subjects"));
			
		}
		
		
		comboBoxSubject = new JComboBox();
		comboBoxSubject.setEnabled(false);
		comboBoxSubject.setBounds(230, 226, 205, 20);
		contentPane.add(comboBoxSubject);
		comboBoxSubject.setModel(elements);
		
		lblNewLabel_1 = new JLabel("Select Subject");
		lblNewLabel_1.setBounds(498, 232, 133, 14);
		contentPane.add(lblNewLabel_1);
		
		
		btnNewButton = new JButton("Send Thesis");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				try {
				
		   String	Query=	  "insert into THESIS"
							+ "	(T_No,T_Title,T_Abstract,L_ID,Ty_ID,PageNumber,WrittenYear,SubmissionDate,\r\n"
							+ "	A_Code,Sv_Code,Sv2_Code,subjects)"
							+ "values"
							+ "("+ textEnterTNo.getText() + ",'" + textTitle.getText() +"','"+textAbstract.getText()+"','"+textLanguage.getSelectedItem().toString()+"',"
							+"'"+ textType.getSelectedItem() +"',"+ textPageNumber.getText() +","+ textWrittenYear.getText() +",GETDATE(),"
							+ textNationalID.getText() +","+ textFieldSVID.getText() +","+ textFieldCOSVID.getText()+",'"+ comboBoxSubject.getSelectedItem().toString() +"')";
				
			
				Connection con= DriverManager.getConnection(url,username,password);
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
		btnNewButton.setBounds(230, 329, 140, 23);
		contentPane.add(btnNewButton);
		
		lblLeaveNullIf = new JLabel("(leave null if there is none)");
		lblLeaveNullIf.setBounds(498, 316, 180, 14);
		contentPane.add(lblLeaveNullIf);
		
		lblLoginMsg = new JLabel("");
		lblLoginMsg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoginMsg.setBounds(10, 283, 195, 32);
		contentPane.add(lblLoginMsg);
		
		btnNewButton_1 = new JButton("Log In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String QueryCheck="	select count(*) as flag  from AUTHOR\r\n"
						+ "	where A_Code="+ textNationalID.getText() +" and A_Password='"+ textPassword.getText() +"'";
				
				try {
					Connection con=DriverManager.getConnection(url,username,password);
					Statement st=con.createStatement();
					ResultSet rs= st.executeQuery(QueryCheck);
					
	
					while(rs.next()) {
						rs.getInt("flag");
						
						if(rs.getInt("flag")==1) {
							textEnterTNo.setEnabled(true);	
							textTitle.setEnabled(true);
							textAbstract.setEnabled(true);
							textWrittenYear.setEnabled(true);
							textType.setEnabled(true);
							textPageNumber.setEnabled(true);
							textLanguage.setEnabled(true);
							textFieldSVID.setEnabled(true);
							textFieldCOSVID.setEnabled(true);
							textAbstract.setEnabled(true);
							btnNewButton.setEnabled(true);
							lblLoginMsg.setText("welcome");
							textNationalID.setEnabled(true);
							textPassword.setEnabled(true);
							comboBoxSubject.setEnabled(true);
						}else {
							lblLoginMsg.setText("you entered wrong id/password");
						}
					}
					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(10, 218, 89, 23);
		contentPane.add(btnNewButton_1);
		

		
		
		
	
	}
}
