package appTemoin1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JList;

public class CreerChat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreerChat frame = new CreerChat();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	/**
	 * Create the frame.
	 */
	public CreerChat(HashMap<String, Object> rmi) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreerChat.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		setTitle("Ultimate Society Messenger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cbAddPers = new JComboBox();
		//cbAddPers.addItem();
		cbAddPers.setBounds(372, 137, 44, 26);
		contentPane.add(cbAddPers);
		
		JLabel lblSelectionnerUnePersonne = new JLabel("Selectionner une personne");
		lblSelectionnerUnePersonne.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblSelectionnerUnePersonne.setForeground(Color.WHITE);
		lblSelectionnerUnePersonne.setBounds(158, 139, 203, 20);
		contentPane.add(lblSelectionnerUnePersonne);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel.setBounds(158, 205, 69, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		textField.setBounds(242, 205, 174, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCrer = new JButton("Cr\u00E9er Chat");
		btnCrer.setBackground(Color.BLACK);
		btnCrer.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnCrer.setForeground(Color.WHITE);
		btnCrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//chat C = new chat();
				//C.setVisible(true);
				//contentPane.setVisible(false);
			}
		});
		btnCrer.setBounds(158, 281, 115, 29);
		contentPane.add(btnCrer);
		
		JButton btnMenu = new JButton("Annuler");
		btnMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setBackground(Color.BLACK);
		btnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenuAdmin C1 = new MainMenuAdmin(rmi);
				C1.setLocationRelativeTo(null);
				C1.setResizable(false);
				C1.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btnMenu.setBounds(301, 281, 115, 29);
		contentPane.add(btnMenu);
		
		JList list = new JList();
		list.setBackground(new Color(0, 0, 0));
		list.setBounds(344, 131, -179, -77);
		contentPane.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CreerChat.class.getResource("/appTemoin1/images/par_chat.png")));
		lblNewLabel_1.setBounds(38, 39, 90, 60);
		contentPane.add(lblNewLabel_1);
	}
}
