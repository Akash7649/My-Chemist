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

public class Diabetes extends JFrame {
	
	private Image img_home=new ImageIcon(Diabetes.class.getResource("images/home.jpg")).getImage().getScaledInstance(45,36,Image.SCALE_SMOOTH ); 
	private Image img_gemer=new ImageIcon(Diabetes.class.getResource("images/gemer.jpg")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_glynase=new ImageIcon(Diabetes.class.getResource("images/glynase.jpg")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_glyciphage=new ImageIcon(Diabetes.class.getResource("images/glyciphage.jpg")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_okamet=new ImageIcon(Diabetes.class.getResource("images/okamet.png")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_reclide=new ImageIcon(Diabetes.class.getResource("images/reclide.png")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_10percent=new ImageIcon(Diabetes.class.getResource("images/10percent.jpg")).getImage().getScaledInstance(46,64,Image.SCALE_SMOOTH ); 
	private Image img_15percent=new ImageIcon(Diabetes.class.getResource("images/15percent.jpg")).getImage().getScaledInstance(46,64,Image.SCALE_SMOOTH ); 
	private Image img_20percent=new ImageIcon(Diabetes.class.getResource("images/20percent.jpg")).getImage().getScaledInstance(46,64,Image.SCALE_SMOOTH ); 

	private JPanel contentPane;
	private JSpinner qty_gemer;
	private JSpinner qty_glynase;
	private JSpinner qty_glyciphage;
	private JSpinner qty_okamet;
    private JSpinner qty_reclide;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diabetes frame = new Diabetes();
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
	
	public Diabetes() {
		
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
				       Diabetes.this.dispose();	
			}
		}});
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(655, 0, 45, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Showing all results for diabetes");
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
				Diabetes.this.dispose();
				
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
				Diabetes.this.dispose();	
				
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
		lblNewLabel_2.setIcon(new ImageIcon(img_gemer));
		lblNewLabel_2.setBounds(10, 0, 142, 134);
		
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add to Cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int gemer_quantity=(int) qty_gemer.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,gemer_quantity);
                    pst.setFloat(2,(float) 109);
                    pst.setString(3,"Gemer 1");
                    float gemer_amount=(float) (gemer_quantity*109);
                    pst.setFloat(4, gemer_amount);
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
		qty_gemer=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_gemer.setBounds(10, 190, 164, 32);
		panel_1.add(qty_gemer);
		
		JLabel lblNewLabel_3 = new JLabel("Gemer 1: Rs.109");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 135, 190, 19);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("MRP Rs.121 (10 tabs)");
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
		lblNewLabel_2_1.setIcon(new ImageIcon(img_glynase));
		panel_1_1.add(lblNewLabel_2_1);
		
		JSpinner spinner2 = new JSpinner();
		SpinnerModel model2;
		model2=new SpinnerNumberModel(0,0,10,1);
		qty_glynase=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_glynase.setBounds(10, 190, 164, 32);
		panel_1_1.add(qty_glynase);
		
		JLabel lblNewLabel_4_1 = new JLabel("MRP Rs.18.52 (10 tabs)");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(21, 164, 142, 19);
		panel_1_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Glynase MF :Rs.16.6");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(21, 135, 169, 19);
		panel_1_1.add(lblNewLabel_3_1);
		
		JButton btnNewButton_1 = new JButton("Add to Cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int glynase_quantity=(int) qty_glynase.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,glynase_quantity);
                    pst.setFloat(2,(float) 16.6);
                    pst.setString(3,"Glynase MF");
                    float glynase_amount=(float) (glynase_quantity*16.6);
                    pst.setFloat(4, glynase_amount);
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
		lblNewLabel_2_2.setIcon(new ImageIcon(img_glyciphage));
		panel_1_2.add(lblNewLabel_2_2);
		
		JSpinner spinner3 = new JSpinner();
		SpinnerModel model3;
		model3=new SpinnerNumberModel(0,0,10,1);
		qty_glyciphage=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_glyciphage.setBounds(10, 190, 164, 32);
		panel_1_2.add(qty_glyciphage);
		
		JLabel lblNewLabel_4_2 = new JLabel("MRP Rs.33.55 (20 tabs)");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_2.setBounds(21, 164, 142, 19);
		panel_1_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Glyciphage 500: Rs.30");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(10, 135, 180, 19);
		panel_1_2.add(lblNewLabel_3_2);
		
		JButton btnNewButton_2 = new JButton("Add to Cart");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int glyciphage_quantity=(int) qty_glyciphage.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,glyciphage_quantity);
                    pst.setFloat(2,(float) 30);
                    pst.setString(3," Glyciphage 500");
                    float glyciphage_amount=(float) (glyciphage_quantity*30);
                    pst.setFloat(4, glyciphage_amount);
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
		qty_okamet=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_okamet.setBounds(10, 190, 164, 32);
		panel_1_3.add(qty_okamet);
		
		JLabel lblNewLabel_4_3 = new JLabel("MRP Rs.22.23 (10 tabs)");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_3.setBounds(21, 164, 142, 19);
		panel_1_3.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Okamet 500: Rs.18.9");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_3.setBounds(22, 132, 168, 19);
		panel_1_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_2_5 = new JLabel("");
		lblNewLabel_2_5.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_5.setBounds(10, 0, 142, 134);
		lblNewLabel_2_5.setIcon(new ImageIcon(img_okamet));
		panel_1_3.add(lblNewLabel_2_5);
		
		JButton btnNewButton_3 = new JButton("Add to Cart");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int okamet_quantity=(int) qty_okamet.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,okamet_quantity);
                    pst.setFloat(2,(float) 18.9);
                    pst.setString(3," Okamet 500");
                    float okamet_amount=(float) (okamet_quantity*18.9);
                    pst.setFloat(4, okamet_amount);
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
		lblNewLabel_6_3.setIcon(new ImageIcon(img_15percent));
		panel_1_3.add(lblNewLabel_6_3);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBounds(229, 394, 200, 274);
		contentPane.add(panel_1_4);
		
		JLabel lblNewLabel_2_4 = new JLabel("");
		lblNewLabel_2_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_4.setBounds(10, 0, 142, 134);
		lblNewLabel_2_4.setIcon(new ImageIcon(img_reclide));
		panel_1_4.add(lblNewLabel_2_4);
		
		JSpinner spinner5 = new JSpinner();
		SpinnerModel model5;
		model5=new SpinnerNumberModel(0,0,10,1);
		qty_reclide=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_reclide.setBounds(10, 190, 164, 32);
		panel_1_4.add(qty_reclide);
		
		JLabel lblNewLabel_4_4 = new JLabel("MRP Rs.197 (15 tabs)");
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_4.setBounds(21, 164, 142, 19);
		panel_1_4.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_3_4 = new JLabel("Reclide XR 60: Rs.157");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_4.setBounds(0, 132, 190, 19);
		panel_1_4.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_2_6 = new JLabel("");
		lblNewLabel_2_6.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_6.setBounds(27, 0, 142, 134);
		panel_1_4.add(lblNewLabel_2_6);
		
		JButton btnNewButton_4 = new JButton("Add to Cart");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int reclide_quantity=(int) qty_reclide.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,reclide_quantity);
                    pst.setFloat(2,(float) 157);
                    pst.setString(3," Reclide XR 60 ");
                    float reclide_amount=(float) (reclide_quantity*157);
                    pst.setFloat(4, reclide_amount);
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
		lblNewLabel_6_4.setIcon(new ImageIcon(img_15percent));
		panel_1_4.add(lblNewLabel_6_4);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		
		
	}

}
