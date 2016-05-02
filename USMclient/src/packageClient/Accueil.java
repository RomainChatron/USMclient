package packageClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vInterface._User;
import vInterfaceDB._UserGroupDB;

import javax.swing.JLabel;

public class Accueil extends JFrame {

	private JPanel contentPane;
	private HashMap<String, Object> rmi ;
	_User moi ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Accueil frame = new Accueil();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Accueil(HashMap<String, Object> rmi, _User moi) {
		this.rmi = rmi ;
		this.moi = moi ;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername;
		try {
			lblUsername = new JLabel(moi.getFirstName());
			lblUsername.setBounds(179, 11, 62, 14);
			contentPane.add(lblUsername);
			
			ArrayList<Integer> listID = ((_UserGroupDB)rmi.get("UserGroupDB")).getGroups(moi.getUserName());
			JLabel lbGroup = new JLabel("" + listID.get(0) + " " + listID.get(1));
			lbGroup.setBounds(10, 90, 46, 14);
			contentPane.add(lbGroup);
			
			JLabel lbllastName = new JLabel(moi.getLastName());
			lbllastName.setBounds(274, 11, 46, 14);
			contentPane.add(lbllastName);
			
			JLabel lblJob = new JLabel(moi.getJob());
			lblJob.setBounds(179, 53, 46, 14);
			contentPane.add(lblJob);
			
			JLabel lblEmail = new JLabel(moi.getEmail());
			lblEmail.setBounds(274, 53, 46, 14);
			contentPane.add(lblEmail);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
