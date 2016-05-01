package appTémoin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainMenuAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuAdmin frame = new MainMenuAdmin();
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
	public MainMenuAdmin() {
		setTitle("Ultimate Society Messenger");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenuAdmin.class.getResource("/appT\u00E9moin/images/fleches-echange.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btDeleteGroup = new JButton("Supprimer Groupe");
		btDeleteGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteGroupe dg = new DeleteGroupe();
				dg.setLocationRelativeTo(null);
				dg.setResizable(false);
				dg.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btDeleteGroup.setHorizontalAlignment(SwingConstants.LEFT);
		btDeleteGroup.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btDeleteGroup.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appT\u00E9moin/images/delete-user-group-icon-2897.png")));
		btDeleteGroup.setBounds(237, 245, 200, 50);
		contentPane.add(btDeleteGroup);
		
		JButton btDeleteUser = new JButton("Supprimer Utilisateur");
		btDeleteUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteUser dl = new DeleteUser();
				dl.setLocationRelativeTo(null);
				dl.setResizable(false);
				dl.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btDeleteUser.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btDeleteUser.setHorizontalAlignment(SwingConstants.LEFT);
		btDeleteUser.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appT\u00E9moin/images/delete-user-icon.png")));
		btDeleteUser.setBounds(15, 245, 200, 50);
		contentPane.add(btDeleteUser);
		
		JButton btAddChat = new JButton("Creer Chat");
		btAddChat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreerChat cc = new CreerChat();
				cc.setLocationRelativeTo(null);
				cc.setResizable(false);
				cc.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btAddChat.setHorizontalAlignment(SwingConstants.LEFT);
		btAddChat.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btAddChat.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appT\u00E9moin/images/par_chat.png")));
		btAddChat.setBounds(452, 167, 200, 50);
		contentPane.add(btAddChat);
		
		JButton btDeleteChat = new JButton("Supprimer Chat");
		btDeleteChat.setHorizontalAlignment(SwingConstants.LEFT);
		btDeleteChat.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btDeleteChat.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appT\u00E9moin/images/Comment-delete.png")));
		btDeleteChat.setBounds(452, 245, 200, 50);
		contentPane.add(btDeleteChat);
		
		JButton btAddTask = new JButton("Affecter T\u00E2che");
		btAddTask.setHorizontalAlignment(SwingConstants.LEFT);
		btAddTask.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btAddTask.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appT\u00E9moin/images/005.png")));
		btAddTask.setBounds(15, 332, 200, 50);
		contentPane.add(btAddTask);
		
		JButton btAddDiary = new JButton("Cr\u00E9er un journal");
		btAddDiary.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btAddDiary.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appT\u00E9moin/images/windows-journal-viewer-icon.png")));
		btAddDiary.setHorizontalAlignment(SwingConstants.LEFT);
		btAddDiary.setBounds(237, 332, 200, 50);
		contentPane.add(btAddDiary);
		
		JButton btAddArticle = new JButton("Creer un article");
		btAddArticle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createArticle ca = new createArticle();
				ca.setLocationRelativeTo(null);
				ca.setResizable(false);
				ca.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btAddArticle.setHorizontalAlignment(SwingConstants.LEFT);
		btAddArticle.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btAddArticle.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appT\u00E9moin/images/48px-Icon-wiki.png")));
		btAddArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btAddArticle.setBounds(452, 332, 200, 50);
		contentPane.add(btAddArticle);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appT\u00E9moin/images/21819-bob4-ParametreDock.png")));
		lblNewLabel.setBounds(478, 27, 128, 98);
		contentPane.add(lblNewLabel);
		
		JButton btAddUser = new JButton("Cr\u00E9er Utilisateur");
		btAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createUser cu = new createUser();
				cu.setLocationRelativeTo(null);
				cu.setResizable(false);
				cu.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btAddUser.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btAddUser.setHorizontalAlignment(SwingConstants.LEFT);
		btAddUser.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appT\u00E9moin/images/add-user-icon.png")));
		btAddUser.setBounds(15, 167, 200, 50);
		contentPane.add(btAddUser);
		
		JButton btAddGroup = new JButton("Cr\u00E9er Groupe");
		btAddGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreerGroupe cg = new CreerGroupe();
				cg.setLocationRelativeTo(null);
				cg.setResizable(false);
				cg.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btAddGroup.setHorizontalAlignment(SwingConstants.LEFT);
		btAddGroup.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btAddGroup.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appT\u00E9moin/images/OMGFDP.png")));
		btAddGroup.setBounds(237, 167, 200, 50);
		contentPane.add(btAddGroup);
		
		JLabel lblPanneauDadministration = new JLabel("Panneau d'administration");
		lblPanneauDadministration.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		lblPanneauDadministration.setBounds(81, 50, 372, 75);
		contentPane.add(lblPanneauDadministration);
	}
}
