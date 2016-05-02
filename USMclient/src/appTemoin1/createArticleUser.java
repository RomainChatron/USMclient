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
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.TextArea;
import java.awt.Button;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class createArticleUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtSaisissezVotreTitre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createArticleUser frame = new createArticleUser();
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
	public createArticleUser() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(createArticleUser.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		setTitle("Ultimate Sociey Messenger");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 772);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(createArticleUser.class.getResource("/appTemoin1/images/48px-Icon-wiki.png")));
		label.setBounds(33, 16, 73, 63);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Ajouter un nouvelle article");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel.setBounds(103, 38, 219, 20);
		contentPane.add(lblNewLabel);
		
		txtSaisissezVotreTitre = new JTextField();
		txtSaisissezVotreTitre.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		txtSaisissezVotreTitre.setText("Saisissez votre titre ici");
		txtSaisissezVotreTitre.setBounds(33, 95, 560, 26);
		contentPane.add(txtSaisissezVotreTitre);
		txtSaisissezVotreTitre.setColumns(10);
		
		JButton btnAjouterUneImage = new JButton("Ajouter une image");
		btnAjouterUneImage.setHorizontalAlignment(SwingConstants.LEFT);
		btnAjouterUneImage.setIcon(new ImageIcon(createArticleUser.class.getResource("/appTemoin1/images/image-inserer-icone-7309-48.png")));
		btnAjouterUneImage.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAjouterUneImage.setBackground(Color.BLACK);
		btnAjouterUneImage.setForeground(Color.WHITE);
		btnAjouterUneImage.setBounds(33, 136, 219, 29);
		contentPane.add(btnAjouterUneImage);
		
		JButton btnNewButton = new JButton("Publier sur mon journal");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setBounds(33, 603, 209, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Publier sur un groupe");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton_1.setBounds(257, 603, 193, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Annuler");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton_2.setBounds(33, 648, 115, 29);
		contentPane.add(btnNewButton_2);
		
		String[] exemplesGroup = { "Developpement C", "Kepp calm i'm global", "The 100 c'est pété", "Laziness"};
		JComboBox cbGroup = new JComboBox(exemplesGroup);
		cbGroup.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// ici récuperer 
				System.out.println("test : " + cbGroup.getSelectedItem());
			}
		});
		cbGroup.setBounds(465, 605, 128, 26);
		contentPane.add(cbGroup);
		
		JTextPane txtpnEcrivezUnMessage = new JTextPane();
		txtpnEcrivezUnMessage.setText("Ecrivez un message...");
		txtpnEcrivezUnMessage.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtpnEcrivezUnMessage.setBounds(33, 181, 560, 392);
		contentPane.add(txtpnEcrivezUnMessage);
	}
}
