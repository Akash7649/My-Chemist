import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.SpinnerModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YourCart extends JFrame {

	private Image img_home=new ImageIcon(SearchMedicines.class.getResource("images/home.jpg")).getImage().getScaledInstance(45,36,Image.SCALE_SMOOTH ); 

	
	private JPanel contentPane;
	public JLabel lblNewLabel_2;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YourCart frame = new YourCart();
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
	public YourCart() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
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
		
		JLabel lblNewLabel = new JLabel("Cart Items");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(211, 71, 307, 54);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this page?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
				       YourCart.this.dispose();	
			}
		}});
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(655, 0, 45, 36);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home h=new Home();
				h.setVisible(true);
				 YourCart.this.dispose();
				
			}
		});
		lblNewLabel_4.setBounds(0, 0, 45, 36);
		lblNewLabel_4.setIcon(new ImageIcon(img_home));
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 245, 238));
		panel_1.setBounds(0, 124, 700, 566);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 680, 303);
		panel_1.add(scrollPane);
		
		table_2 = new JTable();
		table_2.setCellSelectionEnabled(true);
		table_2.setColumnSelectionAllowed(true);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table_2.setBounds(10, 71, 680, 303);
		panel_1.add(table_2);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 45, 170, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(181, 45, 170, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(352, 45, 170, 26);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Amount");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(520, 45, 170, 26);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel label_total = new JLabel("");
		label_total.setBackground(new Color(255, 255, 255));
		label_total.setBorder(null);
		label_total.setHorizontalAlignment(SwingConstants.CENTER);
		label_total.setFont(new Font("Arial", Font.BOLD, 20));
		label_total.setBounds(334, 424, 170, 35);
		panel_1.add(label_total);
		
	

        
        JButton btnNewButton = new JButton("Total :");
        btnNewButton.setBackground(new Color(72, 209, 204));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		double sum=0;
        		int numrow=table_2.getRowCount();
        		for(int i=0;i<numrow;i++)
        		{
        	double value=Double.valueOf(table_2.getValueAt(i,3).toString());
        	sum +=value;
        			
        		}
                label_total.setText(Double.toString(sum));	
        		
        	}
        });
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
        btnNewButton.setBounds(106, 424, 170, 35);
        panel_1.add(btnNewButton);
        
        JButton btnMakePayment = new JButton("Make Payment");
        btnMakePayment.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null,"Due to technical issues we are currently taking payements by offline methods\nPay the total amount by cash on delivery");

            	Home a=new Home();
            	a.setVisible(true);
            	YourCart.this.dispose();
        	}
        });
        btnMakePayment.setFont(new Font("Arial", Font.BOLD, 20));
        btnMakePayment.setBackground(new Color(72, 209, 204));
        btnMakePayment.setBounds(497, 521, 193, 35);
        panel_1.add(btnMakePayment);
		

	    setUndecorated(true);
		setLocationRelativeTo(null);
	
		
	}



private void ShowData() {
	

	DefaultTableModel model=new DefaultTableModel();
	model.addColumn("PRODUCT NAME");
	model.addColumn("QUANTITY");
	model.addColumn("PRICE");
	model.addColumn("AMOUNT");

	
	try {
		
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mychemist","root","Akash@2846");
		String query="Select * from cart";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while (rs.next()) {
			model.addRow(new Object[] {
					rs.getString("Medicine_Name"),
					rs.getInt("Quantity"),
					rs.getFloat("Price"),
					rs.getFloat("Amount"),

					
					
			});
		}
		
		rs.close();
		st.close();
		con.close();
		
		table_2.setModel(model);
		table_2.setAutoResizeMode(0);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(60);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(60);

	}catch(Exception e) {
		System.out.println("error:"+e);
	}
}
}
