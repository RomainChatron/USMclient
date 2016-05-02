package appTemoin1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vInterface._ObjectBuilder;
import vInterface._User;
import vInterfaceDB._UserDB;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class DeleteUser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser frame = new DeleteUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public DeleteUser(HashMap<String, Object> rmi) {
		setTitle("Ultimate Society Messenger");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteUser.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 275);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setForeground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DeleteUser.class.getResource("/appTemoin1/images/delete-user-icon.png")));
		label.setBounds(32, 28, 98, 62);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Selectionner l'utilisateur");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel.setBounds(15, 124, 192, 20);
		contentPane.add(lblNewLabel);
		
		try {
			ArrayList<_User> u =  ((_UserDB) rmi.get("UserDB")).allUser();
			String[] allUsers = new String[u.size()+1];
			allUsers[0] = "Choisissez l'utilisateur..";
			for (int i=1; i<u.size()+1;i++){
				allUsers[i] = u.get(i).getUserName()+" : "+u.get(i).getFirstName()+" "+u.get(i).getLastName();
			}
			
			
			JComboBox cbUsers = new JComboBox(allUsers);
			cbUsers.setBounds(209, 122, 36, 26);
			contentPane.add(cbUsers);
			
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					((_UserDB) rmi.get("UserDB")).removeUser(u.get(cbUsers.getSelectedIndex()-1).getUserName());
					JOptionPane.showMessageDialog(null, "L'utilisateur a bien \u00E9t\u00E9 supprim\u00E9 !");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSupprimer.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnSupprimer.setBackground(Color.BLACK);
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setBounds(63, 174, 115, 29);
		contentPane.add(btnSupprimer);
		
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenuAdmin mma = new MainMenuAdmin(rmi);
				mma.setLocationRelativeTo(null);
				mma.setResizable(false);
				mma.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btnAnnuler.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAnnuler.setBackground(Color.BLACK);
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBounds(195, 174, 115, 29);
		contentPane.add(btnAnnuler);
	}
}
