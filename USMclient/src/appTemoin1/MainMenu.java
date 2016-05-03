package appTemoin1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vInterface._Task;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {

	private JPanel contentPane;
	HashMap<String, Object> rmi ;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu(HashMap<String, Object> rmi, ArrayList<_Task> listTask) {
		this.rmi = rmi ;
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		setTitle("Ultimate Society Messenger");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 384);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrerUnArticle = new JButton("Cr\u00E9er un article");
		btnCrerUnArticle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createArticleUser cau = new createArticleUser(rmi);
				cau.setLocationRelativeTo(null);
				cau.setResizable(false);
				cau.setVisible(true);
				contentPane.setVisible(false);
				
			}
		});
		btnCrerUnArticle.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrerUnArticle.setIcon(new ImageIcon(MainMenu.class.getResource("/appTemoin1/images/48px-Icon-wiki.png")));
		btnCrerUnArticle.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnCrerUnArticle.setBackground(Color.BLACK);
		btnCrerUnArticle.setForeground(Color.WHITE);
		btnCrerUnArticle.setBounds(334, 215, 208, 52);
		contentPane.add(btnCrerUnArticle);
		
		JButton btnCrerUnGroupe = new JButton("Cr\u00E9er un groupe");
		btnCrerUnGroupe.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrerUnGroupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				CreerGroupe cg = new CreerGroupe(rmi);
				cg.setLocationRelativeTo(null);
				cg.setResizable(false);
				cg.setVisible(true);
			}
		});
		btnCrerUnGroupe.setIcon(new ImageIcon(MainMenu.class.getResource("/appTemoin1/images/OMGFDP.png")));
		btnCrerUnGroupe.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnCrerUnGroupe.setBackground(Color.BLACK);
		btnCrerUnGroupe.setForeground(Color.WHITE);
		btnCrerUnGroupe.setBounds(15, 215, 208, 52);
		contentPane.add(btnCrerUnGroupe);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnRetour.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnRetour.setBackground(Color.BLACK);
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setBounds(223, 283, 115, 29);
		contentPane.add(btnRetour);
		
		JButton btnGrerSesTches = new JButton("G\u00E9rer ses t\u00E2ches");
		btnGrerSesTches.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Task t = new Task(rmi, listTask);
					t.setLocationRelativeTo(null);
					t.setResizable(false);
					t.setVisible(true);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGrerSesTches.setIcon(new ImageIcon(MainMenu.class.getResource("/appTemoin1/images/005.png")));
		btnGrerSesTches.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnGrerSesTches.setBackground(Color.BLACK);
		btnGrerSesTches.setForeground(Color.WHITE);
		btnGrerSesTches.setBounds(163, 98, 208, 52);
		contentPane.add(btnGrerSesTches);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/appTemoin1/images/reseau_sociaux_entreprises.jpg")));
		lblNewLabel.setBounds(0, -13, 577, 360);
		contentPane.add(lblNewLabel);
	}
}
