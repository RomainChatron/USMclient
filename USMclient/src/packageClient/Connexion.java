package packageClient;


import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vInterface._User;
import vInterfaceDB._UserDB;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Connexion extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfPassword;
	HashMap<String, Object> rmi ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion(new HashMap<String, Object>());//ArrayList<Object>
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
	public Connexion(HashMap<String, Object> rmi) { //ArrayList<Object> liste
		this.rmi = rmi;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (((_UserDB) rmi.get("UserDB")).connect(tfUsername.getText(), tfPassword.getText())) {
						//_User moi = ((_ObjectBuilder) rmi.get("ObjectBuilder")).createUser();
						_User moi = ((_UserDB)rmi.get("UserDB")).getUsers(tfUsername.getText());
						/*HashMap<String, String> paramUser = ((_UserDB)rmi.get("UserDB")).getUsers(tfUsername.getText());
						moi.setUserName(tfUsername.getText());
						moi.setFirstName(paramUser.get("firstName"));
						moi.setLastName(paramUser.get("lastName"));
						moi.setEmail(paramUser.get("email"));
						moi.setJob(paramUser.get("job"));
						*/
						//System.out.println(paramUser.get("job"));
						Accueil acc = new Accueil(rmi, moi);
						acc.setVisible(true);
						
					} else {
						JOptionPane.showMessageDialog(contentPane, "Erreur");
					}
				} catch (HeadlessException | RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnConnexion.setBounds(136, 180, 89, 23);
		contentPane.add(btnConnexion);
		
		JLabel lbUsername = new JLabel("username");
		lbUsername.setBounds(45, 76, 62, 14);
		contentPane.add(lbUsername);
		
		JLabel lbPassword = new JLabel("password");
		lbPassword.setBounds(45, 119, 46, 14);
		contentPane.add(lbPassword);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(139, 73, 86, 20);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setBounds(139, 116, 86, 20);
		contentPane.add(tfPassword);
		tfPassword.setColumns(10);
	}
}
