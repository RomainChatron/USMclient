package appTemoin1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packageClient.ChatC;
import vInterface._ChatC;
import vInterface._Group;
import vInterface._User;
import vInterface._ChatServer;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GroupChat extends JFrame {

	private JPanel contentPane;
	HashMap<String, Object> rmi ;
	String nomChat ;
	int idC ;
	_User moi ;
	_ChatC leChat ;
	JTextArea txtrTest ;
	JTextArea txtrcrireIci ;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public GroupChat(HashMap<String, Object> rmi, _Group group, _User moi) {
		try {
			this.rmi = rmi ;
			nomChat = group.getName() ;
			this.moi = moi ;
			leChat = new ChatC(this, nomChat);
			
			String membres = "\r\n";
			for(int i = 0 ; i < group.getListMember().size() ; i++) {
				membres += "- " + group.getListMember().get(i).getUserName() + "\r\n";
			}
			
			((_ChatServer)rmi.get("ChatServer")).register(this.nomChat, leChat);
			
			setTitle("Ultimate Society Messenger");
			setIconImage(Toolkit.getDefaultToolkit().getImage(GroupChat.class.getResource("/appTemoin1/images/fleches-echange.gif")));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 979, 722);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 102, 204));
			contentPane.setForeground(new Color(0, 102, 204));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			txtrTest = new JTextArea();
			txtrTest.setText("");
			txtrTest.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			txtrTest.setBounds(242, 68, 671, 407);
			txtrTest.setEditable(false);
			contentPane.add(txtrTest);
			
			txtrcrireIci = new JTextArea();
			txtrcrireIci.setText("Ecrire ici");
			txtrcrireIci.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			txtrcrireIci.setBounds(427, 491, 487, 114);
			contentPane.add(txtrcrireIci);
			
			JButton btnNewButton = new JButton("Envoyer");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						((_ChatServer)rmi.get("ChatServer")).postMessage(nomChat, moi.getUserName() + " : " + txtrcrireIci.getText());
						txtrcrireIci.setText("");
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			});
			btnNewButton.setIcon(new ImageIcon(GroupChat.class.getResource("/appTemoin1/images/mail-veuillez-envoyer-icone-6810-48.png")));
			btnNewButton.setBackground(Color.BLACK);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			btnNewButton.setBounds(242, 491, 170, 49);
			contentPane.add(btnNewButton);
			
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
			txtrDakaya.setText(membres);
			txtrDakaya.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			txtrDakaya.setBackground(new Color(0, 153, 204));
			txtrDakaya.setBounds(15, 144, 187, 254);
			txtrDakaya.setEditable(false);
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
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

	public void displayMessage(String message) throws RemoteException {
		txtrTest.setText(txtrTest.getText() + "\n" + message);
	}
}
