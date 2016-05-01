package appTémoin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class chat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chat frame = new chat();
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
	public chat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("<User> :");
		textArea.setBounds(94, 88, 382, 202);
		contentPane.add(textArea);
		
		JTextArea txtrMoi = new JTextArea();
		txtrMoi.setText("Moi : ");
		txtrMoi.setBounds(213, 312, 263, 65);
		contentPane.add(txtrMoi);
		
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.setBounds(83, 306, 115, 29);
		contentPane.add(btnEnvoyer);
		
		JButton btnJoindre = new JButton("Joindre");
		btnJoindre.setBounds(83, 351, 115, 29);
		contentPane.add(btnJoindre);
		
		JLabel txtInfoChat = new JLabel("");
		txtInfoChat.setBounds(95, 35, 69, 20);
		contentPane.add(txtInfoChat);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu C1 = new MainMenu();
				C1.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btnMenu.setBounds(538, 403, 115, 29);
		contentPane.add(btnMenu);
	}
}
