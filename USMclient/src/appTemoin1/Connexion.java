package appTemoin1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import vInterface._User;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Toolkit;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.HeadlessException;

import vInterfaceDB.*;

public class Connexion {

	private JFrame frmUltimateSocietyMessenger;
	private JTextField txtUser;
	private JPasswordField txtPw;
	HashMap<String, Object> rmi = new HashMap<String, Object>() ;
	//public String userName;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion window = new Connexion(new HashMap<String, Object>());
					window.frmUltimateSocietyMessenger.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
				//WebLookAndFeel.install(true);
				//WebLookAndFeel.setDecorateAllWindows(true);
			}
		});
	}*/
	/**
	 * Create the application.
	 */
	public Connexion(HashMap<String, Object> rmi) {
		this.rmi = rmi ;
		initialize(rmi);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(HashMap<String, Object> rmi) {
		frmUltimateSocietyMessenger = new JFrame();
		frmUltimateSocietyMessenger.getContentPane().setBackground(new Color(0, 102, 204));
		frmUltimateSocietyMessenger.setTitle("Connexion \u00E0 Ultimate Society Messenger");
		frmUltimateSocietyMessenger.setIconImage(Toolkit.getDefaultToolkit().getImage(Connexion.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		frmUltimateSocietyMessenger.setLocationRelativeTo(null);
		frmUltimateSocietyMessenger.setBounds(100, 100, 610, 360);
		frmUltimateSocietyMessenger.setLocationRelativeTo(null);
		frmUltimateSocietyMessenger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUltimateSocietyMessenger.getContentPane().setLayout(null);
		frmUltimateSocietyMessenger.setResizable(false);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblUsername.setForeground(SystemColor.text);
		lblUsername.setBounds(141, 118, 76, 20);
		frmUltimateSocietyMessenger.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPassword.setForeground(SystemColor.text);
		lblPassword.setBounds(141, 159, 76, 20);
		frmUltimateSocietyMessenger.getContentPane().add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		txtUser.setBounds(228, 115, 146, 26);
		frmUltimateSocietyMessenger.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtPw = new JPasswordField();
		txtPw.setBounds(228, 157, 146, 26);
		frmUltimateSocietyMessenger.getContentPane().add(txtPw);
		
		JButton btOk = new JButton("Connexion");
		btOk.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btOk.setForeground(Color.WHITE);
		btOk.setBackground(Color.BLACK);
		btOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				char[] pw = txtPw.getPassword();
				String user = txtUser.getText();
				/*String pw = "coucou";
				String user = "Dakaya";*/
				_User moi ;
				try {
					if (((_UserDB)rmi.get("UserDB")).connect(user, new String(pw))){
						if (user.equalsIgnoreCase("Admin")) {
							MainMenuAdmin mma = new MainMenuAdmin(rmi);
							mma.setLocationRelativeTo(null);
							mma.setResizable(false);
							mma.setVisible(true);
							frmUltimateSocietyMessenger.dispose();
						} else {
							moi = ((_UserDB)rmi.get("UserDB")).getUsers(user);
							UserMainPage ump = new UserMainPage(rmi, moi);
							ump.setLocationRelativeTo(null);
							ump.setResizable(false);
							ump.setVisible(true);
							frmUltimateSocietyMessenger.dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Erreur d'authentification r�essayer !");
					}
				} catch (HeadlessException | RemoteException e) {
					e.printStackTrace();
				}
			}
		});
		btOk.setBounds(131, 214, 112, 29);
		frmUltimateSocietyMessenger.getContentPane().add(btOk);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(Color.BLACK);
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmUltimateSocietyMessenger.dispose();
			}
		});
		btnAnnuler.setBounds(258, 214, 115, 29);
		frmUltimateSocietyMessenger.getContentPane().add(btnAnnuler);
		
		JLabel lblNewLabel = new JLabel("Mot de passe oubli\u00E9 ?");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(30, 286, 177, 20);
		frmUltimateSocietyMessenger.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Je ne peux pas me connecter...");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showInputDialog("Entrez votre Username pour recevoir votre mot de passe par Email");
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(210, 283, 258, 29);
		frmUltimateSocietyMessenger.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Ultimate Society Messenger");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 24));
		lblNewLabel_2.setIcon(new ImageIcon(Connexion.class.getResource("/appTemoin1/images/messenger-para-telegram-13718-0.jpg")));
		lblNewLabel_2.setBounds(60, 24, 485, 64);
		frmUltimateSocietyMessenger.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Connexion.class.getResource("/appTemoin1/images/barre.jpg")));
		lblNewLabel_1.setBounds(-15, 259, 621, 6);
		frmUltimateSocietyMessenger.getContentPane().add(lblNewLabel_1);
		frmUltimateSocietyMessenger.setVisible(true);
	}
}
