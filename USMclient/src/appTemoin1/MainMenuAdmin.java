package appTemoin1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
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
 */
	/**
	 * Create the frame.
	 */
	public MainMenuAdmin(HashMap<String, Object> rmi) {
		setTitle("Ultimate Society Messenger");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenuAdmin.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btDeleteGroup = new JButton("Supprimer Groupe");
		btDeleteGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteGroupe dg = new DeleteGroupe(rmi);
				dg.setLocationRelativeTo(null);
				dg.setResizable(false);
				dg.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btDeleteGroup.setHorizontalAlignment(SwingConstants.LEFT);
		btDeleteGroup.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btDeleteGroup.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appTemoin1/images/delete-user-group-icon-2897.png")));
		btDeleteGroup.setBounds(242, 245, 200, 50);
		contentPane.add(btDeleteGroup);
		
		JButton btDeleteUser = new JButton("Supprimer Utilisateur");
		btDeleteUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteUser dl = new DeleteUser(rmi);
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
		btDeleteUser.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appTemoin1/images/delete-user-icon.png")));
		btDeleteUser.setBounds(15, 245, 200, 50);
		contentPane.add(btDeleteUser);
		
		JButton btDeleteTask = new JButton("Supprimer T\u00E2che");
		btDeleteTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btDeleteTask.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreerChat cc = new CreerChat(rmi);
				cc.setLocationRelativeTo(null);
				cc.setResizable(false);
				cc.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btDeleteTask.setHorizontalAlignment(SwingConstants.LEFT);
		btDeleteTask.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btDeleteTask.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appTemoin1/images/DelArticle.png")));
		btDeleteTask.setBounds(242, 332, 200, 50);
		contentPane.add(btDeleteTask);
		
		JButton btDeleteArticle = new JButton("Supprimer Article\r\n");
		btDeleteArticle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteArticle da = new DeleteArticle(rmi);
				da.setLocationRelativeTo(null);
				da.setResizable(false);
				da.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btDeleteArticle.setHorizontalAlignment(SwingConstants.LEFT);
		btDeleteArticle.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btDeleteArticle.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appTemoin1/images/delTache.png")));
		btDeleteArticle.setBounds(452, 245, 200, 50);
		contentPane.add(btDeleteArticle);
		
		JButton btAddTask = new JButton("Affecter T\u00E2che");
		btAddTask.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddTask at = new AddTask(rmi);
				at.setLocationRelativeTo(null);
				at.setResizable(false);
				at.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btAddTask.setHorizontalAlignment(SwingConstants.LEFT);
		btAddTask.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btAddTask.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appTemoin1/images/005.png")));
		btAddTask.setBounds(15, 332, 200, 50);
		contentPane.add(btAddTask);
		
		JButton btAddArticle = new JButton("Creer un Article");
		btAddArticle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createArticle ca = new createArticle(rmi);
				ca.setLocationRelativeTo(null);
				ca.setResizable(false);
				ca.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btAddArticle.setHorizontalAlignment(SwingConstants.LEFT);
		btAddArticle.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btAddArticle.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appTemoin1/images/48px-Icon-wiki.png")));
		btAddArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btAddArticle.setBounds(452, 167, 200, 50);
		contentPane.add(btAddArticle);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appTemoin1/images/21819-bob4-ParametreDock.png")));
		lblNewLabel.setBounds(478, 27, 128, 98);
		contentPane.add(lblNewLabel);
		
		JButton btAddUser = new JButton("Cr\u00E9er Utilisateur");
		btAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createUser cu = new createUser(rmi);
				cu.setLocationRelativeTo(null);
				cu.setResizable(false);
				cu.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btAddUser.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btAddUser.setHorizontalAlignment(SwingConstants.LEFT);
		btAddUser.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appTemoin1/images/add-user-icon.png")));
		btAddUser.setBounds(15, 167, 200, 50);
		contentPane.add(btAddUser);
		
		JButton btAddGroup = new JButton("Cr\u00E9er Groupe");
		btAddGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreerGroupe cg = new CreerGroupe(rmi);
				cg.setLocationRelativeTo(null);
				cg.setResizable(false);
				cg.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btAddGroup.setHorizontalAlignment(SwingConstants.LEFT);
		btAddGroup.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btAddGroup.setIcon(new ImageIcon(MainMenuAdmin.class.getResource("/appTemoin1/images/OMGFDP.png")));
		btAddGroup.setBounds(237, 167, 200, 50);
		contentPane.add(btAddGroup);
		
		JLabel lblPanneauDadministration = new JLabel("Panneau d'administration");
		lblPanneauDadministration.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		lblPanneauDadministration.setBounds(81, 50, 372, 75);
		contentPane.add(lblPanneauDadministration);
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Connexion window = new Connexion(); // TODO
				contentPane.setVisible(false);
			}
		});
		btnDeconnexion.setBackground(Color.BLACK);
		btnDeconnexion.setForeground(Color.WHITE);
		btnDeconnexion.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnDeconnexion.setBounds(519, 353, 133, 29);
		contentPane.add(btnDeconnexion);
	}
}
