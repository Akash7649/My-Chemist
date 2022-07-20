import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection; 

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import db.DB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private Image img_register=new ImageIcon(Sign_up.class.getResource("images/register_now.jpg")).getImage().getScaledInstance(360,235,Image.SCALE_SMOOTH ); 
	
	private JPanel contentPane;
	private JTextField text_first_name;
	private JTextField text_last_name;
	private JTextField text_username;
	private JTextField text_email_address;
	private JTextField text_mobile_number;
	private JLabel label = new JLabel("");
	private JTextField text_password;

	/**
	 * Launch the application.
	 * @return 
	 */
public static void main(String[] args) {

		

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
					frame.setResizable(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			
		});
	}

	/**
	 * Create the frame.
	 */
Connection con=null;

	protected String Last_Name;

	protected String First_Name;

	protected String Username;

	protected String Mobile_Number;

	protected String Email_id;

	protected String Password;
	public Registration() {
  
		con=(Connection)DB.dbconnect();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(250, 128, 114)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(82, 255, 439, 26);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBackground(new Color(102, 205, 170));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 89, 23);
		panel.add(lblNewLabel_1);
		
		text_first_name = new JTextField();
		text_first_name.setBounds(86, 0, 353, 26);
		panel.add(text_first_name);
		text_first_name.setHorizontalAlignment(SwingConstants.LEFT);
		text_first_name.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 205, 170));
		panel_1.setBounds(82, 304, 439, 26);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBackground(new Color(102, 205, 170));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 89, 23);
		panel_1.add(lblNewLabel_2);
		
		text_last_name = new JTextField();
		text_last_name.setBounds(86, 0, 353, 26);
		panel_1.add(text_last_name);
		text_last_name.setHorizontalAlignment(SwingConstants.LEFT);
		text_last_name.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 205, 170));
		panel_2.setBounds(82, 352, 439, 26);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 2, 89, 23);
		panel_2.add(lblNewLabel_3);
		
		text_username = new JTextField();
		text_username.setBounds(86, 0, 353, 26);
		panel_2.add(text_username);
		text_username.setHorizontalAlignment(SwingConstants.LEFT);
		text_username.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 205, 170));
		panel_3.setBounds(82, 411, 439, 26);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Email Address");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBackground(new Color(255, 69, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 89, 23);
		panel_3.add(lblNewLabel_4);
		
		text_email_address = new JTextField();
		text_email_address.setBounds(86, 0, 353, 26);
		panel_3.add(text_email_address);
		text_email_address.setFont(new Font("Arial", Font.BOLD, 12));
		text_email_address.setForeground(new Color(128, 128, 128));
		text_email_address.setHorizontalAlignment(SwingConstants.LEFT);
		text_email_address.setText("eg: abc@gmail.com");
		text_email_address.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(text_email_address.getText().equals("eg: abc@gmail.com")) {
				
				text_email_address.setText("");
					}
					else
					{
						text_email_address.selectAll();
					}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(text_email_address.getText().equals(""))
				{
					text_email_address.setText("eg: abc@gmail.com");				}
			}
			
			
		});
		text_email_address.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 205, 170));
		panel_4.setBounds(82, 473, 439, 26);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile Number");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setBackground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 0, 89, 23);
		panel_4.add(lblNewLabel_5);
		
		text_mobile_number = new JTextField();
		text_mobile_number.setBounds(86, 0, 353, 26);
		panel_4.add(text_mobile_number);
		text_mobile_number.setHorizontalAlignment(SwingConstants.LEFT);
		text_mobile_number.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(65, 105, 225));
		panel_5.setBounds(226, 603, 150, 26);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(0, 0, 150, 26);
		panel_5.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String first=text_first_name.getText();
				String last=text_last_name.getText();
				String username=text_username.getText();
				String email=text_email_address.getText();
				String mobile=text_mobile_number.getText();
				String password=text_password.getText();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into registration(First_Name,Last_Name,Username,Email_Id,Mobile_number,Password)values(?,?,?,?,?,?)");
					pst.setString(1, first);
					pst.setString(2,last);
					pst.setString(3,username);
					pst.setString(4,email);
					pst.setString(5,mobile);
					pst.setString(6,password);
                    pst.executeUpdate();


				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("sucessful");
				}
	
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(text_first_name.getText().equals("") || text_last_name.getText().equals("") || text_username.getText().equals("") || text_email_address.getText().equals("") || text_mobile_number.getText().equals("")) {
					
				label.setText("Please input all the requirements");	
				}
				else {
                	JOptionPane.showMessageDialog(null,"Registered Sucessfully ");
	                Sign_up a=new Sign_up();
	                a.setVisible(true);
	                Registration.this.dispose();
	
				}
			
				}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(65, 105, 225));
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this page?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
				       Registration.this.dispose();
			}}
		});
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(670, 0, 30, 26);
		contentPane.add(lblNewLabel);
		
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setBounds(82, 567, 439, 26);
		contentPane.add(label);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(102, 205, 170));
		panel_7.setBounds(82, 531, 439, 26);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("password");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(0, 0, 89, 23);
		panel_7.add(lblNewLabel_7);
		
		text_password = new JTextField();
		text_password.setHorizontalAlignment(SwingConstants.LEFT);
		text_password.setBounds(86, 0, 353, 26);
		panel_7.add(text_password);
		text_password.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Register Here");
		lblNewLabel_6.setFont(new Font("Wide Latin", Font.BOLD, 35));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(82, 112, 439, 137);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Clear Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			text_first_name.setText("");	
			text_last_name.setText("");	
			text_username.setText("");	
			text_email_address.setText("");	
			text_mobile_number.setText("");	
			text_password.setText("");	

				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 182, 193));
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Arial", Font.ITALIC, 12));
		btnNewButton_1.setBounds(502, 636, 150, 26);
		contentPane.add(btnNewButton_1);
		
		
		
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
