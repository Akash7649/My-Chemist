import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;


import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Sign_up extends JFrame {
	private Image img_mychemist=new ImageIcon(Sign_up.class.getResource("images/mychemist.jpeg")).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH ); 
	private Image img_login=new ImageIcon(Sign_up.class.getResource("images/key.png")).getImage().getScaledInstance(45,40,Image.SCALE_SMOOTH ); 
	private Image img_password=new ImageIcon(Sign_up.class.getResource("images/lock.png")).getImage().getScaledInstance(45,40,Image.SCALE_SMOOTH ); 
	private Image img_medicine=new ImageIcon(Sign_up.class.getResource("images/medicine_image.jpg")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH );
	private Image img_username=new ImageIcon(Sign_up.class.getResource("images/username.png")).getImage().getScaledInstance(45,40,Image.SCALE_SMOOTH );
	
	
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JLabel lblNewLabel_1 = new JLabel("");
	protected Window frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_up frame = new Sign_up();
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
	public Sign_up() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new LineBorder(new Color(216, 191, 216), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(206, 360, 227, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		username = new JTextField();
		username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(username.getText().equals("username")) {
					username.setText("");
				}
				else
				{
					username.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(username.getText().equals(""))
				{
					username.setText("username");				}
			}
		});
		username.setBorder(null);
		username.setText("username");
		username.setBounds(10, 10, 170, 20);
		panel.add(username);
		username.setColumns(10);
		
		JLabel username_icon = new JLabel("");
		username_icon.setHorizontalAlignment(SwingConstants.CENTER);
		username_icon.setBounds(182, 0, 45, 40);
		username_icon.setIcon(new ImageIcon(img_username));
		panel.add(username_icon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(206, 450, 227, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		password = new JPasswordField();
		password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(password.getText().equals("password")) {
				password.setEchoChar('●');
				password.setText("");
				}
				else
				{
					password.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(password.getText().equals(""))
				{
					password.setText("password");
					password.setEchoChar((char)0); 
				}
			}
		});
		password.setBorder(null);
		password.setEchoChar((char)0);
		password.setText("password");
		password.setBounds(10, 10, 170, 20);
		panel_1.add(password);
		
		JLabel password_icon = new JLabel("");
		password_icon.setHorizontalAlignment(SwingConstants.CENTER);
		password_icon.setBounds(182, 0, 45, 40);
		password_icon.setIcon(new ImageIcon(img_password));
		panel_1.add(password_icon);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(176, 196, 222));
		panel_2.setBounds(206, 581, 227, 40);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(182, 0, 45, 40);
		lblNewLabel.setIcon(new ImageIcon(img_login));
		panel_2.add(lblNewLabel);
		
		JButton btnNewButton =  new JButton("Login");
		btnNewButton.setBounds(0, 0, 182, 40);
		panel_2.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(username.getText().equals("username")||username.getText().equals("")||password.getText().equals("")||password.getText().equals("password")) {
					lblNewLabel_1.setText("Please input all the requirements");	
				}
				else
				{
					Home a=new Home();
					a.setVisible(true);
					Sign_up.this.dispose();
				}
			}
		});
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
	                Class.forName("com.mysql.jdbc.Driver");
	                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mychemist","root","Akash@2846");
	                Statement stmt=con.createStatement();
	                String sql="Select * from registration where Username='"+username.getText()+"'and Password='"+password.getText().toString()+"'";
	                ResultSet rs=stmt.executeQuery(sql);
	                
	                if(rs.next()) {
	                	JOptionPane.showMessageDialog(null,"Login Sucessful");
	                	Home h=new Home();
	                	h.setVisible(true);
	                	Sign_up.this.dispose();
	                }
	                else
	                	JOptionPane.showMessageDialog(null,"Incorrect Username or Password");

	                con.close();
				}catch(Exception e1)
				{
					System.out.println((e1));
				}
			}
		});
		
		JLabel login = new JLabel("");
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setBounds(219, 125, 200, 200);
		login.setIcon(new ImageIcon(img_mychemist));
		contentPane.add(login);
		
		JLabel lblX = 
				new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this page?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
		       Sign_up.this.dispose();
			}}
		
	});
		lblX.setFont(new Font("Arial", Font.BOLD, 12));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(664, 10, 26, 30);
		contentPane.add(lblX);
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(206, 514, 227, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Havent registered yet?");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(206, 646, 141, 21);
		contentPane.add(lblNewLabel_2);
		
	JButton btnNewButton_1=new JButton();
	btnNewButton_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Registration r=new Registration();
			r.setVisible(true);
			Sign_up.this.dispose();
		}
	});
	btnNewButton_1.setText("Click Here");
	
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(348, 646, 98, 21);
		contentPane.add(btnNewButton_1);
		
		
		JButton button = new JButton("Clear Data");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              
				username.setText("");
				password.setText("");

				
			}
		});
		button.setBackground(new Color(255, 182, 193));
		button.setForeground(new Color(255, 0, 0));
		button.setFont(new Font("Arial", Font.ITALIC, 12));
		button.setBounds(502, 636, 150, 26);
		contentPane.add(button);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}

