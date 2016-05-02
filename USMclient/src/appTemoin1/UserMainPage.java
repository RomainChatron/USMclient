package appTemoin1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vInterface._Group;
import vInterface._User;
import vInterfaceDB._UserGroupDB;
import vInterfaceDB._GroupDB;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserMainPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainPage frame = new UserMainPage();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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
	public UserMainPage(HashMap<String, Object> rmi, _User moi) {
		try {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserMainPage.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		setTitle("Ultimate Society Messenger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 776);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBonjour = new JLabel("Bonjour, " + moi.getFirstName() +" !");
		lblBonjour.setFont(new Font("Snap ITC", Font.BOLD, 24));
		lblBonjour.setForeground(Color.WHITE);
		lblBonjour.setBounds(60, 16, 297, 59);
		contentPane.add(lblBonjour);
		
		JEditorPane dtrpnFaireLe = new JEditorPane();
		dtrpnFaireLe.setBackground(SystemColor.inactiveCaption);
		dtrpnFaireLe.setText("\r\n  - Faire le caf\u00E9\r\n  - Faire un csGo\r\n  - Mettre des hs\r\n  - buy awp next round");
		dtrpnFaireLe.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		dtrpnFaireLe.setBounds(654, 149, 208, 229);
		contentPane.add(dtrpnFaireLe);
		
		JLabel lblNewLabel = new JLabel("Mes groupes");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(UserMainPage.class.getResource("/appTemoin1/images/OMGFDP.png")));
		lblNewLabel.setBounds(15, 91, 152, 48);
		contentPane.add(lblNewLabel);
		
		JTextArea txtArticle1 = new JTextArea();
		txtArticle1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtArticle1.setText("Vos articles ici...");
		txtArticle1.setBounds(207, 149, 432, 327);
		contentPane.add(txtArticle1);
		
		JLabel lblNewLabel_2 = new JLabel("Mes t\u00E2ches");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon(UserMainPage.class.getResource("/appTemoin1/images/005.png")));
		lblNewLabel_2.setBounds(654, 91, 152, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Mon journal");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon(UserMainPage.class.getResource("/appTemoin1/images/windows-journal-viewer-icon.png")));
		lblNewLabel_1.setBounds(291, 87, 189, 57);
		contentPane.add(lblNewLabel_1);
		
		ArrayList<Integer> idGs = ((_UserGroupDB)rmi.get("UserGroupDB")).getGroups(moi.getUserName());
		ArrayList<_Group> listGrp = new ArrayList<_Group>();
		String groups = "\r\n";
		String[] jCBgrp ;
		for(int i = 0 ; i < idGs.size(); i++) {
			listGrp.add(((_GroupDB)rmi.get("GroupDB")).getGroup(idGs.get(i)));
			groups += "- " + listGrp.get(i).getName();
			groups += "\r\n";
		}
		jCBgrp = new String[listGrp.size()+1];
		jCBgrp[0] = "Choisir un groupe";
		for (int i = 1 ; i < jCBgrp.length ; i++) {
			jCBgrp[i] = listGrp.get(i-1).getName();
		}
		
		JTextArea txtrDeveloppementC = new JTextArea();
		txtrDeveloppementC.setBackground(SystemColor.inactiveCaption);
		txtrDeveloppementC.setText(groups);
		txtrDeveloppementC.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtrDeveloppementC.setBounds(15, 155, 177, 229);
		contentPane.add(txtrDeveloppementC);
		
		JButton btnNewButton = new JButton("Param\u00E8tres");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainMenu C1 = new MainMenu();
				C1.setLocationRelativeTo(null);
				C1.setResizable(false);
				C1.setVisible(true);
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(UserMainPage.class.getResource("/appTemoin1/images/settings.png")));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(654, 413, 208, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Profil");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateUser uu = new UpdateUser();
				uu.setLocationRelativeTo(null);
				uu.setResizable(false);
				uu.setVisible(true);
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon(UserMainPage.class.getResource("/appTemoin1/images/profil-icone-9817-48.png")));
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(654, 477, 208, 48);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(UserMainPage.class.getResource("/appTemoin1/images/barre.jpg")));
		lblNewLabel_3.setBounds(-23, 127, 921, 5);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("Mes chats");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton_2.setIcon(new ImageIcon(UserMainPage.class.getResource("/appTemoin1/images/par_chat.png")));
		btnNewButton_2.setBounds(15, 439, 164, 51);
		contentPane.add(btnNewButton_2);
		
		JComboBox cbGroup = new JComboBox(jCBgrp);
		cbGroup.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Vue_Groupe vG = new Vue_Groupe(rmi, listGrp.get(cbGroup.getSelectedIndex()-1));
				vG.setLocationRelativeTo(null);
				vG.setResizable(false);
				vG.setVisible(true);
			}
		});
		cbGroup.setBounds(15, 397, 177, 26);
		contentPane.add(cbGroup);
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Connexion window = new Connexion(); // TODO
				contentPane.setVisible(false);
			}
		});
		btnDeconnexion.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnDeconnexion.setBackground(Color.BLACK);
		btnDeconnexion.setForeground(Color.WHITE);
		btnDeconnexion.setBounds(654, 572, 134, 29);
		contentPane.add(btnDeconnexion);
		
		JTextPane txtpnArticle = new JTextPane();
		txtpnArticle.setText(" Article 2...");
		txtpnArticle.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtpnArticle.setBounds(207, 499, 432, 198);
		contentPane.add(txtpnArticle);
		/*cbGroup.setSelectedIndex(4);
		cbGroup.addActionListener(this);
		cbGroup.addActionListener(this) {
			    . . .
			    public void actionPerformed(ActionEvent e) {
			        JComboBox cb = (JComboBox)e.getSource();
			        String petName = (String)cb.getSelectedItem();
			        updateLabel(petName);
			    }
	}*/
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
}
}
