package appTemoin1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vInterface._User;
import vInterfaceDB._UserDB;
import vInterfaceDB._UserGroupDB;
import vInterface._ObjectBuilder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class createUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtEmail;
	private JTextField textJob;
	
	

	/**
	 * Launch the application.
	
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
 */
	/**
	 * Create the frame.
	 */
	public createUser(HashMap<String, Object> rmi) {
		
		
		setBackground(new Color(0, 102, 204));
		setIconImage(Toolkit.getDefaultToolkit().getImage(createUser.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		setTitle("Ultimate Society Messenger");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 419);
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
		
		txtNom = new JTextField();
		txtNom.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		txtNom.setBounds(205, 114, 194, 26);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom ");
		lblPrnom.setForeground(Color.WHITE);
		lblPrnom.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPrnom.setBounds(121, 160, 69, 20);
		contentPane.add(lblPrnom);
		
		txtPrenom = new JTextField();
		txtPrenom.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		txtPrenom.setBounds(205, 158, 194, 26);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		txtEmail.setBounds(205, 200, 194, 26);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
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
		
		textJob = new JTextField();
		textJob.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		textJob.setBounds(205, 242, 194, 26);
		contentPane.add(textJob);
		textJob.setColumns(10);
		
		JButton btAddUser = new JButton("Cr\u00E9er Utilisateur");
		btAddUser.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btAddUser.setForeground(Color.WHITE);
		btAddUser.setBackground(Color.BLACK);
		btAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				String firstName, lastName, email, job;
				lastName = txtNom.getText();
				firstName = txtPrenom.getText();
				email = txtEmail.getText();
				job = textJob.getText();
				
				_User u =  ((_ObjectBuilder) rmi.get("ObjectBuilder")).createUser();
				
				String userName = u.userName(firstName, lastName);
				String passWord = u.password();
			
				((_UserDB) rmi.get("UserDB")).addUser(userName, passWord, firstName, lastName, email);
				
				JOptionPane.showMessageDialog(null, "L'utilisateur a bien \u00E9t\u00E9 cr\u00E9\u00E9 !");
				
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
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
				dispose();
			}
		});
		btnMenu.setBounds(298, 300, 101, 29);
		contentPane.add(btnMenu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(createUser.class.getResource("/appTemoin1/images/add-user-icon.png")));
		lblNewLabel.setBounds(29, 52, 101, 48);
		contentPane.add(lblNewLabel);
	}

}
