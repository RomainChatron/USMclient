package appTemoin1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteUser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
	}

	/**
	 * Create the frame.
	 */
	public DeleteUser() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(209, 122, 36, 26);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Supprimer");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(63, 174, 115, 29);
		contentPane.add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenuAdmin mma = new MainMenuAdmin();
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
