package appTémoin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class createUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createUser frame = new createUser();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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
	public createUser() {
		setBackground(new Color(0, 102, 204));
		setIconImage(Toolkit.getDefaultToolkit().getImage(createUser.class.getResource("/appT\u00E9moin/images/fleches-echange.gif")));
		setTitle("Ultimate Society Messenger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNom.setBounds(121, 116, 52, 20);
		contentPane.add(lblNom);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		textField.setBounds(205, 114, 194, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom ");
		lblPrnom.setForeground(Color.WHITE);
		lblPrnom.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPrnom.setBounds(121, 160, 69, 20);
		contentPane.add(lblPrnom);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		textField_1.setBounds(205, 158, 194, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		textField_2.setBounds(205, 200, 194, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email ");
		lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(121, 202, 69, 20);
		contentPane.add(lblEmail);
		
		JLabel lblJob = new JLabel("Job");
		lblJob.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblJob.setForeground(Color.WHITE);
		lblJob.setBounds(121, 244, 52, 20);
		contentPane.add(lblJob);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		textField_3.setBounds(205, 242, 194, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btAddUser = new JButton("Cr\u00E9er Utilisateur");
		btAddUser.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btAddUser.setForeground(Color.WHITE);
		btAddUser.setBackground(Color.BLACK);
		btAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ajouter user en base et créer objet
				JOptionPane.showMessageDialog(null, "L'utilisateur a bien été créé !");
			}
		});
		btAddUser.setBounds(121, 300, 162, 29);
		contentPane.add(btAddUser);
		
		JButton btnMenu = new JButton("Annuler");
		btnMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setBackground(Color.BLACK);
		btnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenuAdmin mma = new MainMenuAdmin();
				mma.setLocationRelativeTo(null);
				mma.setResizable(false);
				mma.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btnMenu.setBounds(298, 300, 101, 29);
		contentPane.add(btnMenu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(createUser.class.getResource("/appT\u00E9moin/images/add-user-icon.png")));
		lblNewLabel.setBounds(29, 52, 101, 48);
		contentPane.add(lblNewLabel);
	}

}
