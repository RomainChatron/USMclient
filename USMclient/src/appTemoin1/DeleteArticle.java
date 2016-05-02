package appTemoin1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DeleteArticle extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteArticle frame = new DeleteArticle();
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
	public DeleteArticle(HashMap<String, Object> rmi) {
		setTitle("Ultimate Society Messenger");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteGroupe.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectionnerUnArticle = new JLabel("Selectionner un article");
		lblSelectionnerUnArticle.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblSelectionnerUnArticle.setForeground(Color.WHITE);
		lblSelectionnerUnArticle.setBounds(81, 105, 172, 20);
		contentPane.add(lblSelectionnerUnArticle);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DeleteGroupe.class.getResource("/appTemoin1/images/delete-user-group-icon-2897.png")));
		label.setBounds(29, 29, 103, 48);
		contentPane.add(label);
		
		JComboBox cbArticle = new JComboBox();
		cbArticle.setBounds(268, 103, 36, 26);
		contentPane.add(cbArticle);
		
		JButton btnNewButton = new JButton("Supprimer");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(59, 170, 115, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenuAdmin mma = new MainMenuAdmin(rmi);
				mma.setLocationRelativeTo(null);
				mma.setResizable(false);
				mma.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(189, 170, 115, 29);
		contentPane.add(btnNewButton_1);	
	}

}
