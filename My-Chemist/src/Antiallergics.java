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

public class Antiallergics extends JFrame {
	
	private Image img_home=new ImageIcon(Antiallergics.class.getResource("images/home.jpg")).getImage().getScaledInstance(45,36,Image.SCALE_SMOOTH ); 
	private Image img_allegra=new ImageIcon(Antiallergics.class.getResource("images/allegra.jpg")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_alerid=new ImageIcon(Antiallergics.class.getResource("images/alerid.jpg")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_montek_lc=new ImageIcon(Antiallergics.class.getResource("images/montek_lc.jpg")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_okacet=new ImageIcon(Antiallergics.class.getResource("images/okacet.jpg")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_okacet_l=new ImageIcon(Antiallergics.class.getResource("images/okacet_l.jpg")).getImage().getScaledInstance(142,134,Image.SCALE_SMOOTH ); 
	private Image img_10percent=new ImageIcon(Antiallergics.class.getResource("images/10percent.jpg")).getImage().getScaledInstance(46,64,Image.SCALE_SMOOTH ); 
	private Image img_15percent=new ImageIcon(Antiallergics.class.getResource("images/15percent.jpg")).getImage().getScaledInstance(46,64,Image.SCALE_SMOOTH ); 
	private Image img_20percent=new ImageIcon(Antiallergics.class.getResource("images/20percent.jpg")).getImage().getScaledInstance(46,64,Image.SCALE_SMOOTH ); 
	

	private JPanel contentPane;
	private JSpinner qty_allegra;
	private JSpinner qty_alerid;
	private JSpinner qty_montek;
	private JSpinner qty_okacet;
	private JSpinner qty_okacet_l;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Antiallergics frame = new Antiallergics();
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
	
	public Antiallergics() {
		
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
				       Antiallergics.this.dispose();	
			}
		}});
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(655, 0, 45, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Showing all results for antiallergics");
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
				Antiallergics.this.dispose();
				
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
				Antiallergics.this.dispose();	
				
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
		lblNewLabel_2.setIcon(new ImageIcon(img_allegra));
		lblNewLabel_2.setBounds(10, 0, 142, 134);
		
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add to Cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int allegra_quantity=(int) qty_allegra.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,allegra_quantity);
                    pst.setFloat(2,159);
                    pst.setString(3,"Allegra 120");
                    float allegra_amount=(allegra_quantity*159);
                    pst.setFloat(4, allegra_amount);
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
		qty_allegra=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_allegra.setBounds(10, 190, 164, 32);
		panel_1.add(qty_allegra);
		
		JLabel lblNewLabel_3 = new JLabel("Allegra 120 : Rs.159");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 135, 190, 19);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("MRP Rs.198.9 (10 tabs)");
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
		lblNewLabel_2_1.setIcon(new ImageIcon(img_alerid));
		panel_1_1.add(lblNewLabel_2_1);
		
		JSpinner spinner2 = new JSpinner();
		SpinnerModel model2;
		model2=new SpinnerNumberModel(0,0,10,1);
		qty_alerid=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_alerid.setBounds(10, 190, 164, 32);
		panel_1_1.add(qty_alerid);
		
		JLabel lblNewLabel_4_1 = new JLabel("MRP Rs.39 (60 ml)");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(21, 164, 142, 19);
		panel_1_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Alerid Syrup :Rs.31.2");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(21, 135, 169, 19);
		panel_1_1.add(lblNewLabel_3_1);
		
		JButton btnNewButton_1 = new JButton("Add to Cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int alerid_quantity=(int) qty_alerid.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,alerid_quantity);
                    pst.setFloat(2,(float) 31.2);
                    pst.setString(3,"Alerid Syrup");
                    float alerid_amount=(float) (alerid_quantity*31.2);
                    pst.setFloat(4, alerid_amount);
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
		lblNewLabel_6_1.setIcon(new ImageIcon(img_20percent));
		panel_1_1.add(lblNewLabel_6_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(456, 110, 200, 274);
		contentPane.add(panel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_2.setBounds(10, 0, 142, 134);
		lblNewLabel_2_2.setIcon(new ImageIcon(img_montek_lc));
		panel_1_2.add(lblNewLabel_2_2);
		
		JSpinner spinner3 = new JSpinner();
		SpinnerModel model3;
		model3=new SpinnerNumberModel(0,0,10,1);
		qty_montek=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_montek.setBounds(10, 190, 164, 32);
		panel_1_2.add(qty_montek);
		
		JLabel lblNewLabel_4_2 = new JLabel("MRP Rs.197 (10 tabs)");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_2.setBounds(21, 164, 142, 19);
		panel_1_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Montek LC: Rs. 167.45");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(10, 135, 180, 19);
		panel_1_2.add(lblNewLabel_3_2);
		
		JButton btnNewButton_2 = new JButton("Add to Cart");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int montek_quantity=(int) qty_montek.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,montek_quantity);
                    pst.setFloat(2,(float) 167.45);
                    pst.setString(3,"Montek LC");
                    float montek_amount=(float) (montek_quantity*167.45);
                    pst.setFloat(4, montek_amount);
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
		SpinnerModel model4;
		model4=new SpinnerNumberModel(0,0,10,1);
		qty_okacet=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_okacet.setBounds(10, 190, 164, 32);
		panel_1_3.add(qty_okacet);
		
		JLabel lblNewLabel_4_3 = new JLabel("MRP Rs.18.5 (10 tabs)");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_3.setBounds(21, 164, 142, 19);
		panel_1_3.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Okacet : Rs.14.8");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_3.setBounds(22, 132, 168, 19);
		panel_1_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_2_5 = new JLabel("");
		lblNewLabel_2_5.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_5.setBounds(10, 0, 142, 134);
		lblNewLabel_2_5.setIcon(new ImageIcon(img_okacet));
		panel_1_3.add(lblNewLabel_2_5);
		
		JButton btnNewButton_3 = new JButton("Add to Cart");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int okacet_quantity=(int) qty_okacet.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,okacet_quantity);
                    pst.setFloat(2,(float) 14.8);
                    pst.setString(3,"Okacet");
                    float okacet_amount=(float) (okacet_quantity*14.8);
                    pst.setFloat(4, okacet_amount);
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
		lblNewLabel_2_4.setIcon(new ImageIcon(img_okacet_l));
		panel_1_4.add(lblNewLabel_2_4);
		
		JSpinner spinner5 = new JSpinner();
		SpinnerModel model5;
		model5=new SpinnerNumberModel(0,0,10,1);
		qty_okacet_l=new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		qty_okacet_l.setBounds(10, 190, 164, 32);
		panel_1_4.add(qty_okacet_l);
		
		JLabel lblNewLabel_4_4 = new JLabel("MRP Rs.57 (10 tabs)");
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_4.setBounds(21, 164, 142, 19);
		panel_1_4.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_3_4 = new JLabel("Okacet L : Rs.51.3");
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
				
				int okacet_l_quantity=(int) qty_okacet_l.getValue();

				try {
					PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into cart(Quantity,Price,Medicine_Name,Amount)values(?,?,?,?)");
                    pst.setInt(1,okacet_l_quantity);
                    pst.setFloat(2,(float) 51.3);
                    pst.setString(3,"Okacet");
                    float okacet_l_amount=(float) (okacet_l_quantity*51.3);
                    pst.setFloat(4, okacet_l_amount);
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
