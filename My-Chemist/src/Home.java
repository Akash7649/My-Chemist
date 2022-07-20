import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;



import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;


import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Home extends JFrame {

	public static final String Panel_Search = null;
	private Image img_search=new ImageIcon(Sign_up.class.getResource("images/search.png")).getImage().getScaledInstance(45,48,Image.SCALE_SMOOTH ); 
	private Image img_sign_out=new ImageIcon(Sign_up.class.getResource("images/sign_out.jpg")).getImage().getScaledInstance(45,48,Image.SCALE_SMOOTH ); 
	private Image img_receipt=new ImageIcon(Sign_up.class.getResource("images/receipt.jpg")).getImage().getScaledInstance(227,204,Image.SCALE_SMOOTH ); 
	private Image img_bill=new ImageIcon(Sign_up.class.getResource("images/bill.jpg")).getImage().getScaledInstance(45,48,Image.SCALE_SMOOTH ); 
	private Image img_cart=new ImageIcon(Sign_up.class.getResource("images/cart.png")).getImage().getScaledInstance(45,48,Image.SCALE_SMOOTH ); 
	private Image img_home=new ImageIcon(Sign_up.class.getResource("images/home.jpg")).getImage().getScaledInstance(268,270,Image.SCALE_SMOOTH ); 
	private Image img_information=new ImageIcon(Sign_up.class.getResource("images/information.jpg")).getImage().getScaledInstance(45,48,Image.SCALE_SMOOTH ); 
	private Image img_mychemist=new ImageIcon(Sign_up.class.getResource("images/mychemist.jpeg")).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH ); 


	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,700,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new LineBorder(new Color(139, 0, 139), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 160, 122), 2));
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(0, 0, 288, 700);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, 268, 270);
		lblNewLabel.setIcon(new ImageIcon(img_home));
		panel.add(lblNewLabel);
		
		JPanel Panel_Search = new JPanel();
		Panel_Search.addMouseListener(new PanelButtonMouseAadapter(Panel_Search));
		Panel_Search.setBackground(new Color(250, 235, 215));
		Panel_Search.setBounds(0, 332, 288, 68);
		panel.add(Panel_Search);
		Panel_Search.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Search Medicines");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(64, 12, 214,46);
		Panel_Search.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(9, 10, 45, 48);
		lblNewLabel_6.setIcon(new ImageIcon(img_search));
		Panel_Search.add(lblNewLabel_6);
		
		JPanel Panel_Substitutes = new JPanel();
		Panel_Substitutes.addMouseListener(new PanelButtonMouseAadapter(Panel_Substitutes));
		Panel_Substitutes.setForeground(Color.BLACK);
		Panel_Substitutes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Panel_Substitutes.setBackground(new Color(255, 160, 122));
			}
		});
		Panel_Substitutes.setBackground(new Color(250, 235, 215));
		Panel_Substitutes.setBounds(0, 398, 288, 68);
		panel.add(Panel_Substitutes);
		Panel_Substitutes.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Your Cart");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				YourCart a=new YourCart();
				a.setVisible(true);
				Home.this.dispose();
			}
		});
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(64, 10, 214, 48);
		Panel_Substitutes.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				YourCart a=new YourCart();
				a.setVisible(true);
				Home.this.dispose();
			}
		});
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(9, 10, 45, 48);
		lblNewLabel_7.setIcon(new ImageIcon(img_cart));
		Panel_Substitutes.add(lblNewLabel_7);
		
		JPanel Panel_information = new JPanel();
		Panel_information.addMouseListener(new PanelButtonMouseAadapter(Panel_information));
		Panel_information.setBackground(new Color(250, 235, 215));
		Panel_information.setBounds(0, 465, 288, 68);
		panel.add(Panel_information);
		Panel_information.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Basic Medicine Information");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Information i=new Information();
				i.setVisible(true);
				Home.this.dispose();
			}
		});
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(64, 10, 214, 48);
		Panel_information.add(lblNewLabel_3);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Information i=new Information();
				i.setVisible(true);
				Home.this.dispose();
			}
		});
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(9, 10, 45, 48);
		lblNewLabel_8.setIcon(new ImageIcon(img_information));
		Panel_information.add(lblNewLabel_8);
		
		JPanel Panel_Bill = new JPanel();
		Panel_Bill.addMouseListener(new PanelButtonMouseAadapter(Panel_Bill));
		Panel_Bill.setBackground(new Color(250, 235, 215));
		Panel_Bill.setBounds(0, 533, 288, 68);
		panel.add(Panel_Bill);
		Panel_Bill.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sign Out");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to sign out?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
				Sign_up a=new Sign_up();
				a.setVisible(true);
				Home.this.dispose();
				}
				
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(64, 5, 214, 53);
		Panel_Bill.add(lblNewLabel_1);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to sign out?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
				Sign_up a=new Sign_up();
				a.setVisible(true);
				Home.this.dispose();
				}
			}
		});
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(9, 10, 45, 48);
		lblNewLabel_10.setIcon(new ImageIcon(img_sign_out));
        Panel_Bill.add(lblNewLabel_10);
        
        JLabel lblNewLabel_11 = new JLabel("X");
        lblNewLabel_11.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this page?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
				       Home.this.dispose();
        	}
        }});
        lblNewLabel_11.setForeground(Color.BLACK);
        lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 14));
        lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_11.setBounds(655, 0, 45, 36);
        contentPane.add(lblNewLabel_11);
        
        JLabel lblNewLabel_12 = new JLabel("Welcome!");
        lblNewLabel_12.setFont(new Font("Colonna MT", Font.BOLD, 80));
        lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_12.setBounds(312, 289, 362, 157);
        contentPane.add(lblNewLabel_12);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(378, 79, 200, 200);
        lblNewLabel_2.setIcon(new ImageIcon(img_mychemist));
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_9 = new JLabel("Get all the medicines you require");
        lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setBounds(298, 505, 392, 36);
        contentPane.add(lblNewLabel_9);
        
        JLabel lblNewLabel_9_1 = new JLabel("for upto 20% off");
        lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_9_1.setBounds(298, 542, 392, 36);
        contentPane.add(lblNewLabel_9_1);
        

        
        setUndecorated(true);
		setLocationRelativeTo(null);
	}
	
	private class PanelButtonMouseAadapter extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAadapter(JPanel panel) {
			this.panel=panel;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(255, 192, 203));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(250, 235, 215));
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(255, 192, 203));

		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(255, 192, 203));

		}
		@Override
		public void mouseClicked(MouseEvent e) {
    	  SearchMedicines meds=new SearchMedicines();
        meds.setVisible(true);
       Home.this.dispose();
       
			
			
}

}
}
