package appTemoin1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class GroupChat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupChat frame = new GroupChat();
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
	public GroupChat() {
		setTitle("Ultimate Society Messenger");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GroupChat.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 979, 722);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setForeground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtChat = new JTextArea();
		txtChat.setText("  <ProOF> : test mic 1 2 1 2, allo la terre ici grenoble\r\n  <Vivian> : okok\r\n  <Dakaya> : omg");
		txtChat.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtChat.setBounds(242, 68, 671, 407);
		contentPane.add(txtChat);
		
		JTextArea txtSend = new JTextArea();
		txtSend.setText(" <User> : \u00E9crire ici...");
		txtSend.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtSend.setBounds(427, 491, 487, 114);
		contentPane.add(txtSend);
		
		JButton btSend = new JButton("Envoyer");
		btSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtChat.setText(txtChat.getText() + "\r\n" + txtSend.getText());
			}
		});
		btSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btSend.setIcon(new ImageIcon(GroupChat.class.getResource("/appTemoin1/images/mail-veuillez-envoyer-icone-6810-48.png")));
		btSend.setBackground(Color.BLACK);
		btSend.setForeground(Color.WHITE);
		btSend.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btSend.setBounds(242, 491, 170, 49);
		contentPane.add(btSend);
		
		JButton btnAjouterUnFichier = new JButton("Ajouter un fichier");
		btnAjouterUnFichier.setHorizontalAlignment(SwingConstants.LEFT);
		btnAjouterUnFichier.setIcon(new ImageIcon(GroupChat.class.getResource("/appTemoin1/images/oYPS__email_mail_attachement_paperclip_trombone-48.png")));
		btnAjouterUnFichier.setBackground(Color.BLACK);
		btnAjouterUnFichier.setForeground(Color.WHITE);
		btnAjouterUnFichier.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAjouterUnFichier.setBounds(242, 556, 170, 49);
		contentPane.add(btnAjouterUnFichier);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnRetour.setBackground(Color.BLACK);
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnRetour.setBounds(799, 621, 115, 29);
		contentPane.add(btnRetour);
		
		JLabel lblNewLabel = new JLabel("Membres");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblNewLabel.setIcon(new ImageIcon(GroupChat.class.getResource("/appTemoin1/images/OMGFDP.png")));
		lblNewLabel.setBounds(27, 79, 126, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(GroupChat.class.getResource("/appTemoin1/images/barre.jpg")));
		lblNewLabel_1.setBounds(-14, 110, 983, 8);
		contentPane.add(lblNewLabel_1);
		
		JTextArea txtrDakaya = new JTextArea();
		txtrDakaya.setText("\r\n  - Dakaya\r\n  - ProOF\r\n  - Laziness\r\n  - L\u00E9aH\r\n  - Fanny\r\n  - Anass");
		txtrDakaya.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtrDakaya.setBackground(SystemColor.inactiveCaption);
		txtrDakaya.setBounds(15, 144, 187, 254);
		contentPane.add(txtrDakaya);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(GroupChat.class.getResource("/appTemoin1/images/4cbMMa6Xi.png")));
		lblNewLabel_2.setBounds(10, 503, 192, 147);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblTchatDeGroupe = new JLabel("Tchat de groupe");
		lblTchatDeGroupe.setFont(new Font("Snap ITC", Font.BOLD, 24));
		lblTchatDeGroupe.setForeground(Color.WHITE);
		lblTchatDeGroupe.setBounds(68, 16, 271, 29);
		contentPane.add(lblTchatDeGroupe);
	}
}
