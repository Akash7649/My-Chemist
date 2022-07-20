import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.DB;

import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BloodPressure extends JFrame {
	
	private Image img_home=new ImageIcon(BloodPressure.class.getResource("images/home.jpg")).getImage().getScaledInstance(45,36,Image.SCALE_SMOOTH ); 
	private Image img_amlokind_5=new ImageIcon(BloodPressure.class.getResource("images/amlokind_5.jpg")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_amlopin_5=new ImageIcon(BloodPressure.class.getResource("images/amlopin_5.jpg")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_telvas_40=new ImageIcon(BloodPressure.class.getResource("images/telvas_40.jpg")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_telma_40=new ImageIcon(BloodPressure.class.getResource("images/telma_40.png")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_telismart_40=new ImageIcon(BloodPressure.class.getResource("images/telismart_40.jpg")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_10percent=new ImageIcon(BloodPressure.class.getResource("images/10percent.jpg")).getImage().getScaledInstance(46,64,Image.SCALE_SMOOTH ); 
	private Image img_15percent=new ImageIcon(BloodPressure.class.getResource("images/15percent.jpg")).getImage().getScaledInstance(46,64,Image.SCALE_SMOOTH ); 
	private Image img_20percent=new ImageIcon(BloodPressure.class.getResource("images/20percent.jpg")).getImage().getScaledInstance(46,64,Image.SCALE_SMOOTH ); 
	

	private JPanel contentPane;
	private JSpinner qty_amlokind;
	private JSpinner qty_amlopin;
	private JSpinner qty_telvas_40;
	private JSpinner qty_telma_40;
    private JSpinner qty_telismart_40;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodPressure frame = new BloodPressure();
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
	Connection con=null;

	protected float Price;

	protected String Medicine_Name;
	
	public BloodPressure() {
		con=(Connection)DB.dbconnect();

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 700, 111);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this page?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					BloodPressure.this.dispose();	
			}
		}});
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(655, 0, 45, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Showing all results for blood pressure");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(96, 35, 524, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home home=new Home();
				home.setVisible(true);
				BloodPressure.this.dispose();
				
			}
		});
		lblNewLabel_5.setBounds(0, 0, 45, 36);
		lblNewLabel_5.setIcon(new ImageIcon(img_home));
        panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("<-");
		lblNewLabel_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchMedicines meds=new SearchMedicines();
				meds.setVisible(true);
				BloodPressure.this.dispose();	
				
			}
		});
		lblNewLabel_5_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setBounds(0, 35, 45, 36);
		panel.add(lblNewLabel_5_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 110, 200, 274);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setIcon(new ImageIcon(img_amlokind_5));
		lblNewLabel_2.setBounds(10, 0, 142, 134);
		
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add to Cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int amlokind_quantity=(int) qty_amlokind.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,amlokind_quantity);
                    pst.setFloat(2,(float) 11.9);
                    pst.setString(3,"Amlokind 5");
                    float amlokind_amount=(float) (amlokind_quantity*11.9);
                    pst.setFloat(4, amlokind_amount);
                    pst.executeUpdate();
                	JOptionPane.showMessageDialog(null,"Added Sucessfully");


				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("sucessful");
				}	
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setBounds(10, 232, 180, 32);
		panel_1.add(btnNewButton);
		
		JSpinner spinner = new JSpinner();
		SpinnerModel model;
		model=new SpinnerNumberModel(0,0,10,1);
		qty_amlokind=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_amlokind.setBounds(10, 190, 164, 32);
		panel_1.add(qty_amlokind);
		
		JLabel lblNewLabel_3 = new JLabel("Amlokind 5: Rs.11.9");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 135, 190, 19);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("MRP Rs.13.27 (10 tabs)");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(21, 164, 142, 19);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(154, 0, 46, 64);
		lblNewLabel_6.setIcon(new ImageIcon(img_10percent));
		panel_1.add(lblNewLabel_6);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(229, 110, 200, 274);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_1.setBounds(10, 0, 142, 134);
		lblNewLabel_2_1.setIcon(new ImageIcon(img_amlopin_5));
		panel_1_1.add(lblNewLabel_2_1);
		
		JSpinner spinner2 = new JSpinner();	
		SpinnerModel model2;
		model2=new SpinnerNumberModel(0,0,10,1);
		qty_amlopin=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_amlopin.setBounds(10, 190, 164, 32);
		panel_1_1.add(qty_amlopin);
		
		JLabel lblNewLabel_4_1 = new JLabel("MRP Rs.29 (10 tabs)");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(21, 164, 142, 19);
		panel_1_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Amlopin 5 :Rs.24.65");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(21, 135, 169, 19);
		panel_1_1.add(lblNewLabel_3_1);
		
		JButton btnNewButton_1 = new JButton("Add to Cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int amlopin_quantity=(int) qty_amlopin.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,amlopin_quantity);
                    pst.setFloat(2,(float) 24.65);
                    pst.setString(3,"Amlopin 5");
                    float amlopin_amount=(float) (amlopin_quantity*24.65);
                    pst.setFloat(4, amlopin_amount);
                    pst.executeUpdate();
                	JOptionPane.showMessageDialog(null,"Added Sucessfully");


				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("sucessful");
				}	
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(0, 139, 139));
		btnNewButton_1.setBounds(10, 232, 180, 32);
		panel_1_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setBounds(154, 0, 46, 64);
		lblNewLabel_6_1.setIcon(new ImageIcon(img_15percent));
		panel_1_1.add(lblNewLabel_6_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(456, 110, 200, 274);
		contentPane.add(panel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_2.setBounds(10, 0, 142, 134);
		lblNewLabel_2_2.setIcon(new ImageIcon(img_telvas_40));
		panel_1_2.add(lblNewLabel_2_2);
		
		JSpinner spinner3 = new JSpinner();
		SpinnerModel model3;
		model3=new SpinnerNumberModel(0,0,10,1);
		qty_telvas_40=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_telvas_40.setBounds(10, 190, 164, 32);
		panel_1_2.add(qty_telvas_40);
		
		JLabel lblNewLabel_4_2 = new JLabel("MRP Rs.80 (15 tabs)");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_2.setBounds(21, 164, 142, 19);
		panel_1_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Telvas 40: Rs.72");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(10, 135, 180, 19);
		panel_1_2.add(lblNewLabel_3_2);
		
		JButton btnNewButton_2 = new JButton("Add to Cart");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int telvas_40_quantity=(int) qty_telvas_40.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,telvas_40_quantity);
                    pst.setFloat(2,(float) 72);
                    pst.setString(3,"Telvas 40");
                    float telvas_40_amount=(float) (telvas_40_quantity*72);
                    pst.setFloat(4, telvas_40_amount);
                    pst.executeUpdate();
                	JOptionPane.showMessageDialog(null,"Added Sucessfully");


				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("sucessful");
				}	
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_2.setBackground(new Color(0, 139, 139));
		btnNewButton_2.setBounds(10, 232, 180, 32);
		panel_1_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_6_2 = new JLabel("");
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_2.setBounds(154, 0, 46, 64);
		lblNewLabel_6_2.setIcon(new ImageIcon(img_10percent));
		panel_1_2.add(lblNewLabel_6_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(10, 394, 200, 274);
		contentPane.add(panel_1_3);
		
		JSpinner spinner4 = new JSpinner();
		SpinnerModel model4;
		model4=new SpinnerNumberModel(0,0,10,1);
		qty_telma_40=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_telma_40.setBounds(10, 190, 164, 32);
		panel_1_3.add(qty_telma_40);
		
		JLabel lblNewLabel_4_3 = new JLabel("MRP Rs.222 (30 tabs)");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_3.setBounds(21, 164, 142, 19);
		panel_1_3.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Telma 40: Rs.177.6");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_3.setBounds(22, 132, 168, 19);
		panel_1_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_2_5 = new JLabel("");
		lblNewLabel_2_5.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_5.setBounds(10, 0, 142, 134);
		lblNewLabel_2_5.setIcon(new ImageIcon(img_telma_40));
		panel_1_3.add(lblNewLabel_2_5);
		
		JButton btnNewButton_3 = new JButton("Add to Cart");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int telma_40_quantity=(int) qty_telma_40.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,telma_40_quantity);
                    pst.setFloat(2,(float) 117.6);
                    pst.setString(3,"Telma 40");
                    float telma_40_amount=(float) (telma_40_quantity*117.6);
                    pst.setFloat(4, telma_40_amount);
                    pst.executeUpdate();
                	JOptionPane.showMessageDialog(null,"Added Sucessfully");


				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("sucessful");
				}	
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_3.setBackground(new Color(0, 139, 139));
		btnNewButton_3.setBounds(10, 232, 180, 32);
		panel_1_3.add(btnNewButton_3);
		
		JLabel lblNewLabel_6_3 = new JLabel("");
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_3.setBounds(154, 0, 46, 64);
		lblNewLabel_6_3.setIcon(new ImageIcon(img_20percent));
		panel_1_3.add(lblNewLabel_6_3);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBounds(229, 394, 200, 274);
		contentPane.add(panel_1_4);
		
		JLabel lblNewLabel_2_4 = new JLabel("");
		lblNewLabel_2_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_4.setBounds(10, 0, 142, 134);
		lblNewLabel_2_4.setIcon(new ImageIcon(img_telismart_40));
		panel_1_4.add(lblNewLabel_2_4);
		
		JSpinner spinner5 = new JSpinner();
		SpinnerModel model5;
		model5=new SpinnerNumberModel(0,0,10,1);
		qty_telismart_40=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_telismart_40.setBounds(10, 190, 164, 32);
		panel_1_4.add(qty_telismart_40);
		
		JLabel lblNewLabel_4_4 = new JLabel("MRP Rs.74 (10 tabs)");
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_4.setBounds(21, 164, 142, 19);
		panel_1_4.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_3_4 = new JLabel("Telismart 40: Rs59.2");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_4.setBounds(27, 132, 163, 19);
		panel_1_4.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_2_6 = new JLabel("");
		lblNewLabel_2_6.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_6.setBounds(27, 0, 142, 134);
		panel_1_4.add(lblNewLabel_2_6);
		
		JButton btnNewButton_4 = new JButton("Add to Cart");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int telismart_40_quantity=(int) qty_telismart_40.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,telismart_40_quantity);
                    pst.setFloat(2,(float) 59.2);
                    pst.setString(3,"Telismart 40");
                    float telismart_40_amount=(float) (telismart_40_quantity*59.2);
                    pst.setFloat(4, telismart_40_amount);
                    pst.executeUpdate();
                	JOptionPane.showMessageDialog(null,"Added Sucessfully");


				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("sucessful");
				}	
			}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_4.setBackground(new Color(0, 139, 139));
		btnNewButton_4.setBounds(10, 232, 180, 32);
		panel_1_4.add(btnNewButton_4);
		
		JLabel lblNewLabel_6_4 = new JLabel("");
		lblNewLabel_6_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4.setBounds(154, 0, 46, 64);
		lblNewLabel_6_4.setIcon(new ImageIcon(img_20percent));
		panel_1_4.add(lblNewLabel_6_4);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		
			
		
	}

}
