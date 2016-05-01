package appTémoin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/appT\u00E9moin/images/fleches-echange.gif")));
		setTitle("Ultimate Society Messenger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrerChat = new JButton("Cr\u00E9er chat");
		btnCrerChat.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnCrerChat.setBackground(Color.BLACK);
		btnCrerChat.setForeground(Color.WHITE);
		btnCrerChat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CreerChat c1 = new CreerChat();
				c1.setVisible(true);
				contentPane.setVisible(false);
				
			}
		});
		btnCrerChat.setBounds(79, 207, 115, 29);
		contentPane.add(btnCrerChat);
		
		JButton btnVoirMesTches = new JButton("Voir mes t\u00E2ches");
		btnVoirMesTches.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnVoirMesTches.setBackground(Color.BLACK);
		btnVoirMesTches.setForeground(Color.WHITE);
		btnVoirMesTches.setBounds(79, 272, 145, 29);
		contentPane.add(btnVoirMesTches);
		
		JButton btnVoirLeGroupe = new JButton("Voir le groupe");
		btnVoirLeGroupe.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnVoirLeGroupe.setBackground(Color.BLACK);
		btnVoirLeGroupe.setForeground(Color.WHITE);
		btnVoirLeGroupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVoirLeGroupe.setBounds(79, 337, 145, 29);
		contentPane.add(btnVoirLeGroupe);
		
		JButton btnCrerUnArticle = new JButton("Cr\u00E9er un article");
		btnCrerUnArticle.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnCrerUnArticle.setBackground(Color.BLACK);
		btnCrerUnArticle.setForeground(Color.WHITE);
		btnCrerUnArticle.setBounds(79, 143, 156, 29);
		contentPane.add(btnCrerUnArticle);
		
		JButton btnCrerUnGroupe = new JButton("Cr\u00E9er un groupe");
		btnCrerUnGroupe.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnCrerUnGroupe.setBackground(Color.BLACK);
		btnCrerUnGroupe.setForeground(Color.WHITE);
		btnCrerUnGroupe.setBounds(79, 78, 156, 29);
		contentPane.add(btnCrerUnGroupe);
		
		JButton btnQuitterUnGroupe = new JButton("Quitter un groupe");
		btnQuitterUnGroupe.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnQuitterUnGroupe.setBackground(Color.BLACK);
		btnQuitterUnGroupe.setForeground(Color.WHITE);
		btnQuitterUnGroupe.setBounds(79, 399, 165, 29);
		contentPane.add(btnQuitterUnGroupe);
	}
}
