import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Information extends JFrame {
	
	private Image img_home=new ImageIcon(SearchMedicines.class.getResource("images/home.jpg")).getImage().getScaledInstance(45,36,Image.SCALE_SMOOTH ); 


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Information frame = new Information();
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
	public Information() {
		setFont(new Font("Arial", Font.BOLD, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(0, 0, 700, 125);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Basic Medicine Information");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 75, 461, 50);
		panel.add(lblNewLabel);
		
		
		JLabel close_label = new JLabel("X");
		close_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this page?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
				       Information.this.dispose();	
			}
		}});
		close_label.setFont(new Font("Arial", Font.BOLD, 20));
		close_label.setHorizontalAlignment(SwingConstants.CENTER);
		close_label.setBounds(655, 0, 45, 36);
		panel.add(close_label);
		
		JLabel home_label = new JLabel("");
		home_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home h=new Home();
				h.setVisible(true);
				Information.this.dispose();
				
			}
		});
		home_label.setBounds(0, 0, 45, 36);
		home_label.setIcon(new ImageIcon(img_home));
		panel.add(home_label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 680, 480);
		contentPane.add(scrollPane);
		
		JTextArea txtranalgesicsanalgesicsAlsoCalled = new JTextArea();
		txtranalgesicsanalgesicsAlsoCalled.setText("1)Analgesics-Analgesics, also called painkillers, are medications that relieve different types of pain \u2014 from headaches to injuries to arthritis.\n Anti-inflammatory analgesics reduce inflammation, and opioid analgesics change the way the brain perceives pain.\n\u00A0Analgesics are medications that relieve pain. Unlike medications used for\u00A0anesthesia\u00A0during surgery, analgesics don\u2019t turn off nerves, \nchange the ability to sense your surroundings or alter consciousness.\n\n\n2) Antibiotics-An\u00A0antibiotic\u00A0is a type of\u00A0antimicrobial\u00A0substance active against\u00A0bacteria.\n It is the most important type of\u00A0antibacterial agent\u00A0for fighting\u00A0bacterial infections, and antibiotic\u00A0medications\u00A0are widely used in the\u00A0treatment\u00A0and\u00A0prevention\u00A0of such infections.\n\n\n3) Antacids-An\u00A0antacid\u00A0is a substance which\u00A0neutralizes\u00A0stomach acidity\u00A0and is used to relieve\u00A0heartburn,\u00A0indigestion\u00A0or an upset stomach.\n\u00A0Some antacids have been used in the treatmentof\u00A0constipation\u00A0and\u00A0diarrhea.\n\u00A0Currently marketed antacids contain\u00A0salts\u00A0of\u00A0aluminum,\u00A0calcium,\u00A0magnesium, or\u00A0sodium.\n\n\n4) Antiallergic-An antiallergic substance prevents or relieves allergies.\nAn antiallergic drug can be used to relieve high fever and other allergic reactions.\nAntiallergic drugs temporarily relieve the symptoms of allergic reactions.\nAn antiallergic substance prevents or relieves allergies.\n\n\n 5) Diabetes-Diabetes is a disease that occurs when your blood glucose, also called blood sugar, is too high. \nBlood glucose is your main source of energy and comes from the food you eat.\n\u00A0Insulin, a\u00A0hormone\u00A0made by the\u00A0pancreas, helps glucose from food get into your cells to be used for energy.\n Sometimes your body doesn\u2019t make enough\u2014or any\u2014insulin or doesn\u2019t use insulin well.\n Glucose then stays in your blood and doesn\u2019t reach your cells.\n\n\n6) Blood pressure-Blood pressure\u00A0(BP) is the\u00A0pressure\u00A0of circulating\u00A0blood\u00A0against the walls of\u00A0blood vessels. \nMost of this pressure results from the heart pumping blood through the\u00A0circulatory system.\n When used without qualification, the term \"blood pressure\" refers to the pressure in the large\u00A0arteries.\n Blood pressure is usually expressed in terms of the\u00A0systolic pressure\u00A0(maximum pressure during one heartbeat) over\u00A0diastolic pressure\u00A0(minimum pressure between two heartbeats) in the\u00A0cardiac cycle.\n It is measured in millimeters of\u00A0mercury\u00A0(mmHg) above the surrounding\u00A0atmospheric pressure.\n\n\n7) Vitamins-A vitamin is an organic molecule (or a set of molecules closely related chemically, i.e. vitamers) that is an essential micronutrient which an organism needs in small quantities for the proper functioning of its metabolism. \nEssential nutrients cannot be synthesized in the organism, either at all or not in sufficient quantities, and therefore must be obtained through the diet.\n Vitamin C can be synthesized by some species but not by others; it is not a vitamin in the first instance but is in the second. \nThe term vitamin does not include the three other groups of essential nutrients: minerals, essential fatty acids, and essential amino acids.[2] Most vitamins are not single molecules, but groups of related molecules called vitamers.\n\n\n8) Immunity Booster-Immunostimulants, also known as immunostimulators, are substances (drugs and nutrients) that stimulate the immune system by inducing activation or increasing activity of any of its components.\n One notable example is the granulocyte macrophage colony-stimulating factor.");
		txtranalgesicsanalgesicsAlsoCalled.setFont(new Font("Tahoma", Font.BOLD, 18));
		scrollPane.setViewportView(txtranalgesicsanalgesicsAlsoCalled);
		
		
		setUndecorated(true);
		setResizable(true);
		setLocationRelativeTo(null);
	}
}
