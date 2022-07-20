import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JTextField;
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

import javax.swing.event.ChangeListener;

import db.DB;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Analgesics extends JFrame {
	
	private Image img_home=new ImageIcon(Analgesics.class.getResource("images/home.jpg")).getImage().getScaledInstance(45,36,Image.SCALE_SMOOTH ); 
	private Image img_enzoflam=new ImageIcon(Analgesics.class.getResource("images/enzoflam.png")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_intagesic=new ImageIcon(Analgesics.class.getResource("images/intagesic.png")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_chymoral_forte=new ImageIcon(Analgesics.class.getResource("images/chymoral_forte.jpg")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_ebility=new ImageIcon(Analgesics.class.getResource("images/ebility.png")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_flexon_mr=new ImageIcon(Analgesics.class.getResource("images/flexon_mr.png")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_10percent=new ImageIcon(Analgesics.class.getResource("images/10percent.jpg")).getImage().getScaledInstance(46,64,Image.SCALE_SMOOTH ); 
	private Image img_15percent=new ImageIcon(Analgesics.class.getResource("images/15percent.jpg")).getImage().getScaledInstance(46,64,Image.SCALE_SMOOTH ); 
	private Image img_20percent=new ImageIcon(Analgesics.class.getResource("images/20percent.jpg")).getImage().getScaledInstance(46,64,Image.SCALE_SMOOTH ); 


	private JPanel contentPane;
	private JSpinner qty_chymoral;
	private JSpinner qty_ebility;
	private JSpinner qty_enzoflam;
	private JSpinner qty_flexon;
	private JSpinner qty_intagesic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Analgesics frame = new Analgesics();
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
	
	
	
	public Analgesics() {
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
				       Analgesics.this.dispose();	
			}
		}});
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(655, 0, 45, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Showing all results for analgesigs/antipyretics");
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
				Analgesics.this.dispose();
				
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
				Analgesics.this.dispose();	
				
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
		lblNewLabel_2.setIcon(new ImageIcon(img_chymoral_forte));
		lblNewLabel_2.setBounds(10, 0, 142, 134);
		
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add to Cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int chymoral_quantity=(int) qty_chymoral.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,chymoral_quantity);
                    pst.setFloat(2,228);
                    pst.setString(3,"Chymoral Forte");
                    float chymoral_amount=(chymoral_quantity*228);
                    pst.setFloat(4, chymoral_amount);
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
		qty_chymoral=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
	/*	spinner_5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				int qty=Integer.parseInt()
			}
		});*/
        qty_chymoral.setBounds(10, 190, 164, 32);
		panel_1.add(qty_chymoral);
		
		JLabel lblNewLabel_3 = new JLabel("Chymoral Forte : Rs.228");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 135, 190, 19);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("MRP Rs.285 (20 tabs)");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(21, 164, 142, 19);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(154, 0, 46, 64);
		lblNewLabel_6.setIcon(new ImageIcon(img_20percent));
		panel_1.add(lblNewLabel_6);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(229, 110, 200, 274);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_1.setBounds(10, 0, 142, 134);
		lblNewLabel_2_1.setIcon(new ImageIcon(img_ebility));
		panel_1_1.add(lblNewLabel_2_1);
		
		JSpinner spinner2 = new JSpinner();
		SpinnerModel model1;
		model1=new SpinnerNumberModel(0,0,10,1);
		qty_ebility=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_ebility.setBounds(10, 190, 164, 32);
		panel_1_1.add(qty_ebility);
		
		JLabel lblNewLabel_4_1 = new JLabel("MRP Rs.149.98 (10 tabs)");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(21, 164, 142, 19);
		panel_1_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ebility :Rs.135");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(21, 135, 142, 19);
		panel_1_1.add(lblNewLabel_3_1);
		
		JButton btnNewButton_1 = new JButton("Add to Cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	        	int ebility_quantity=(int)  qty_ebility.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,ebility_quantity);
                    pst.setFloat(2,135);
                    pst.setString(3,"Ebility");
                    float ebility_amount=(ebility_quantity*135);
                    pst.setFloat(4, ebility_amount);
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
		lblNewLabel_6_1.setIcon(new ImageIcon(img_10percent));
		panel_1_1.add(lblNewLabel_6_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(456, 110, 200, 274);
		contentPane.add(panel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_2.setBounds(10, 0, 142, 134);
		lblNewLabel_2_2.setIcon(new ImageIcon(img_enzoflam));
		panel_1_2.add(lblNewLabel_2_2);
		
		JSpinner spinner3 = new JSpinner();
		SpinnerModel model2;
		model2=new SpinnerNumberModel(0,0,10,1);
		qty_enzoflam=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_enzoflam.setBounds(10, 190, 164, 32);
		panel_1_2.add(qty_enzoflam);
		
		JLabel lblNewLabel_4_2 = new JLabel("MRP Rs.132 (10 tabs)");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_2.setBounds(21, 164, 142, 19);
		panel_1_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Enzoflam: Rs.112.2");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(21, 135, 153, 19);
		panel_1_2.add(lblNewLabel_3_2);
		
		JButton btnNewButton_2 = new JButton("Add to Cart");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int enzoflam_quantity=(int) qty_enzoflam.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,enzoflam_quantity);
                    pst.setFloat(2,(float) 112.2);
                    pst.setString(3,"Enzoflam");
                    float enzoflam_amount=(enzoflam_quantity*(float)112.2);
                    pst.setFloat(4, enzoflam_amount);
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
		lblNewLabel_6_2.setIcon(new ImageIcon(img_15percent));
		panel_1_2.add(lblNewLabel_6_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(10, 394, 200, 274);
		contentPane.add(panel_1_3);
		
		JSpinner spinner4 = new JSpinner();
		SpinnerModel model3;
		model3=new SpinnerNumberModel(0,0,10,1);
		qty_flexon=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_flexon.setBounds(10, 190, 164, 32);
		panel_1_3.add(qty_flexon);
		
		JLabel lblNewLabel_4_3 = new JLabel("MRP Rs.21.95 (10 tabs)");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_3.setBounds(21, 164, 142, 19);
		panel_1_3.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Flexon Mr: Rs.19.75");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_3.setBounds(22, 132, 168, 19);
		panel_1_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_2_5 = new JLabel("");
		lblNewLabel_2_5.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_5.setBounds(10, 0, 142, 134);
		lblNewLabel_2_5.setIcon(new ImageIcon(img_flexon_mr));
		panel_1_3.add(lblNewLabel_2_5);
		
		JButton btnNewButton_3 = new JButton("Add to Cart");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int flexon_quantity=(int) qty_flexon.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,flexon_quantity);
                    pst.setFloat(2,(float) 19.75);
                    pst.setString(3,"Flexon MR");
                    float flexon_amount=(flexon_quantity*(float)19.75);
                    pst.setFloat(4, flexon_amount);
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
		lblNewLabel_6_3.setIcon(new ImageIcon(img_10percent));
		panel_1_3.add(lblNewLabel_6_3);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBounds(229, 394, 200, 274);
		contentPane.add(panel_1_4);
		
		JLabel lblNewLabel_2_4 = new JLabel("");
		lblNewLabel_2_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_4.setBounds(10, 0, 142, 134);
		lblNewLabel_2_4.setIcon(new ImageIcon(img_intagesic));
		panel_1_4.add(lblNewLabel_2_4);
		
		JSpinner spinner5 = new JSpinner();
		SpinnerModel model4;
		model3=new SpinnerNumberModel(0,0,10,1);
		qty_intagesic=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_intagesic.setBounds(10, 190, 164, 32);
		panel_1_4.add(qty_intagesic);
		
		JLabel lblNewLabel_4_4 = new JLabel("MRP Rs.86 (10 tabs)");
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_4.setBounds(21, 164, 142, 19);
		panel_1_4.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_3_4 = new JLabel("Intagesic Mr: Rs.77.4");
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
				
				int intagesic_quantity=(int) qty_intagesic.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,intagesic_quantity);
                    pst.setFloat(2,(float) 77.4);
                    pst.setString(3,"Intagesic MR");
                    float intagesic_amount=(intagesic_quantity*(float)77.4);
                    pst.setFloat(4, intagesic_amount);
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
		lblNewLabel_6_4.setIcon(new ImageIcon(img_10percent));
		panel_1_4.add(lblNewLabel_6_4);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		
	}

}
