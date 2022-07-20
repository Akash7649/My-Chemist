import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class SearchMedicines extends JFrame {
	
	private Image img_analgesics=new ImageIcon(SearchMedicines.class.getResource("images/analgesics.jpg")).getImage().getScaledInstance(216,138,Image.SCALE_SMOOTH ); 
	private Image img_antibiotics=new ImageIcon(SearchMedicines.class.getResource("images/antibiotics.png")).getImage().getScaledInstance(216,138,Image.SCALE_SMOOTH ); 
	private Image img_antacids=new ImageIcon(SearchMedicines.class.getResource("images/antacids.jpg")).getImage().getScaledInstance(216,138,Image.SCALE_SMOOTH ); 
	private Image img_antiallergics=new ImageIcon(SearchMedicines.class.getResource("images/antiallergics.jpg")).getImage().getScaledInstance(216,138,Image.SCALE_SMOOTH ); 
	private Image img_diabetes=new ImageIcon(SearchMedicines.class.getResource("images/diabetes.jpg")).getImage().getScaledInstance(216,138,Image.SCALE_SMOOTH ); 
	private Image img_blood_pressure=new ImageIcon(SearchMedicines.class.getResource("images/blood_pressure.jpg")).getImage().getScaledInstance(216,138,Image.SCALE_SMOOTH ); 
	private Image img_vitamins=new ImageIcon(SearchMedicines.class.getResource("images/vitamins.jpg")).getImage().getScaledInstance(216,138,Image.SCALE_SMOOTH ); 
	private Image img_skin_care=new ImageIcon(SearchMedicines.class.getResource("images/skin_care.jpg")).getImage().getScaledInstance(216,138,Image.SCALE_SMOOTH ); 
	private Image img_immunity_boosters=new ImageIcon(SearchMedicines.class.getResource("images/immunity_boosters.jpg")).getImage().getScaledInstance(216,138,Image.SCALE_SMOOTH ); 
	private Image img_home=new ImageIcon(SearchMedicines.class.getResource("images/home.jpg")).getImage().getScaledInstance(45,36,Image.SCALE_SMOOTH ); 

	private JPanel contentPane;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMedicines frame = new SearchMedicines();
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
	public SearchMedicines() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new LineBorder(new Color(255, 20, 147), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(0, 0, 700, 172);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search by category");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(107, 0, 459, 93);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this page?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
				       SearchMedicines.this.dispose();	
			}
		}});
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(655, 0, 45, 36);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home home=new Home();
				home.setVisible(true);
				SearchMedicines.this.dispose();
				
			}
		});
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_4.setBounds(0, 0, 45, 36);
		lblNewLabel_4.setIcon(new ImageIcon(img_home));
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(248, 248, 255));
		panel_1.setBounds(10, 182, 216, 162);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Analgesics/Antipyretics");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Analgesics a=new Analgesics();
				a.setVisible(true);
				SearchMedicines.this.dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setBounds(0, 0, 216, 162);

		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 216, 138);
		lblNewLabel_2.setIcon(new ImageIcon(img_analgesics));
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 192, 203));
		panel_2.setBounds(236, 182, 216, 162);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Anitbiotics");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Antibiotics a=new Antibiotics();
				a.setVisible(true);
				SearchMedicines.this.dispose();
			}
		});
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(0, 0, 216, 162);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(0, 0, 216, 138);
		lblNewLabel_2_1.setIcon(new ImageIcon(img_antibiotics));
		panel_2.add(lblNewLabel_2_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 192, 203));
		panel_3.setBounds(462, 182, 216, 162);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Antacids");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Antacids a=new Antacids();
				a.setVisible(true);
				SearchMedicines.this.dispose();
			}
		});
		lblNewLabel_1_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(0, 0, 216, 162);
		panel_3.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setBounds(0, 0, 216, 138);
		lblNewLabel_2_2.setIcon(new ImageIcon(img_antacids));
		panel_3.add(lblNewLabel_2_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 192, 203));
		panel_4.setBounds(10, 353, 216, 162);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Antiallergics");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Antiallergics a=new Antiallergics();
				a.setVisible(true);
				SearchMedicines.this.dispose();
			}
		});
		lblNewLabel_1_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(0, 0, 216, 162);
		panel_4.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setBounds(0, 0, 216, 138);
		lblNewLabel_2_3.setIcon(new ImageIcon(img_antiallergics));
		panel_4.add(lblNewLabel_2_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 192, 203));
		panel_5.setBounds(236, 353, 216, 162);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("Diabetes");
		lblNewLabel_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Diabetes a=new Diabetes();
				a.setVisible(true);
				SearchMedicines.this.dispose();
			}
		});
		lblNewLabel_1_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(0, 0, 216, 162);
		panel_5.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_2_4 = new JLabel("");
		lblNewLabel_2_4.setBounds(0, 0, 216, 138);
		lblNewLabel_2_4.setIcon(new ImageIcon(img_diabetes));
		panel_5.add(lblNewLabel_2_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 192, 203));
		panel_6.setBounds(462, 354, 216, 162);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_1_5 = new JLabel("Blood Pressure");
		lblNewLabel_1_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BloodPressure a=new BloodPressure();
				a.setVisible(true);
				SearchMedicines.this.dispose();
			}
		});
		lblNewLabel_1_5.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(0, 0, 216, 162);
		panel_6.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_2_5 = new JLabel("");
		lblNewLabel_2_5.setBounds(0, 0, 216, 138);
		lblNewLabel_2_5.setIcon(new ImageIcon(img_blood_pressure));
		panel_6.add(lblNewLabel_2_5);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 192, 203));
		panel_7.setBounds(10, 525, 216, 162);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_1_6 = new JLabel("Vitamins");
		lblNewLabel_1_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vitamins a=new Vitamins();
				a.setVisible(true);
				SearchMedicines.this.dispose();
			}
		});
		lblNewLabel_1_6.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_6.setBounds(0, 0, 216, 162);
		panel_7.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_2_6 = new JLabel("");
		lblNewLabel_2_6.setBounds(0, 0, 216, 138);
		lblNewLabel_2_6.setIcon(new ImageIcon(img_vitamins));
     	panel_7.add(lblNewLabel_2_6);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 192, 203));
		panel_8.setBounds(236, 525, 216, 162);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_1_7 = new JLabel("Immunity Boosters");
		lblNewLabel_1_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImmunityBoosters a=new ImmunityBoosters();
				a.setVisible(true);
				SearchMedicines.this.dispose();
			}
		});
        lblNewLabel_1_7.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_7.setBounds(0, 0, 216, 162);
		panel_8.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_2_7 = new JLabel("");
		lblNewLabel_2_7.setBounds(0, 0, 216, 138);
		lblNewLabel_2_7.setIcon(new ImageIcon(img_immunity_boosters));
		panel_8.add(lblNewLabel_2_7);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 192, 203));
		panel_9.setBounds(462, 526, 216, 162);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_1_8 = new JLabel("Skin Care Products");
		lblNewLabel_1_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SkinCare a=new SkinCare();
				a.setVisible(true);
				SearchMedicines.this.dispose();
			}
		});
		lblNewLabel_1_8.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_8.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_8.setBounds(0, 0, 216, 162);
		panel_9.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_2_8 = new JLabel("");
		lblNewLabel_2_8.setBounds(0, 0, 216, 138);
		lblNewLabel_2_8.setIcon(new ImageIcon(img_skin_care));
		panel_9.add(lblNewLabel_2_8);

		
        setUndecorated(true);
		setLocationRelativeTo(null);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
