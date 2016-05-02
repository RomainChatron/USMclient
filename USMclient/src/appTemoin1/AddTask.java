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
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AddTask extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtDescr;
	private JTextField txtDeadLine;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTask frame = new AddTask();
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
	public AddTask(HashMap<String, Object> rmi) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddTask.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		setTitle("Ultimate Society Messenger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddTask.class.getResource("/appTemoin1/images/005.png")));
		lblNewLabel.setBounds(37, 16, 74, 73);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(146, 95, 106, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(146, 131, 96, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DeadLine ");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(146, 167, 96, 20);
		contentPane.add(lblNewLabel_3);
		
		String[] exemplesGroup = { "Developpement C", "Kepp calm i'm global", "The 100 c'est p�t�", "Laziness"};
		JComboBox cbGroup = new JComboBox(exemplesGroup);
		cbGroup.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// ici r�cuperer 
				System.out.println("test : " + cbGroup.getSelectedItem());
			}
		});
		cbGroup.setBounds(256, 207, 147, 26);
		contentPane.add(cbGroup);
		
		String[] exemplesUser = { "R�mi", "Anass", "Romain", "L�aH"};
		JComboBox cbUser = new JComboBox(exemplesUser);
		cbUser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println(cbUser.getSelectedItem().toString());
			}
		});
		cbUser.setBounds(256, 249, 147, 26);
		contentPane.add(cbUser);
		
		String[] exemplesTask = { "Faible", "Moyen", "Elev�", "Tr�s important"};
		JComboBox cbTypeTask = new JComboBox(exemplesTask);
		cbTypeTask.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println(cbTypeTask.getSelectedItem().toString());
			}
		});
		cbTypeTask.setBounds(256, 291, 147, 26);
		contentPane.add(cbTypeTask);
		
		JButton btnNewButton = new JButton("Cr\u00E9er");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(146, 342, 115, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainMenuAdmin mma = new MainMenuAdmin(rmi);
				mma.setLocationRelativeTo(null);
				mma.setResizable(false);
				mma.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton_1.setBounds(288, 342, 115, 29);
		contentPane.add(btnNewButton_1);
		
		txtNom = new JTextField();
		txtNom.setBounds(257, 93, 146, 26);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtDescr = new JTextField();
		txtDescr.setBounds(257, 129, 146, 26);
		contentPane.add(txtDescr);
		txtDescr.setColumns(10);
		
		txtDeadLine = new JTextField();
		txtDeadLine.setBounds(257, 165, 146, 26);
		contentPane.add(txtDeadLine);
		txtDeadLine.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Groupe");
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(146, 203, 69, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Utilisateur");
		lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(146, 251, 96, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Type t\u00E2che");
		lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(146, 293, 96, 20);
		contentPane.add(lblNewLabel_6);
	}
}
