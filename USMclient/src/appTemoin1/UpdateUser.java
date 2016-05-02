package appTemoin1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUser frame = new UpdateUser();
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
	public UpdateUser() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateUser.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		setTitle("Ultimate Society Messenger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UpdateUser.class.getResource("/appTemoin1/images/update_pencil_edit_user_person_customer_face.png")));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel.setBounds(15, 16, 76, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNom.setBounds(116, 93, 69, 20);
		contentPane.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setForeground(Color.WHITE);
		lblPrnom.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPrnom.setBounds(116, 140, 69, 20);
		contentPane.add(lblPrnom);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblEmail.setBounds(116, 187, 69, 20);
		contentPane.add(lblEmail);
		
		JLabel lblJob = new JLabel("Job");
		lblJob.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblJob.setForeground(Color.WHITE);
		lblJob.setBounds(116, 238, 69, 20);
		contentPane.add(lblJob);
		
		textField = new JTextField();
		textField.setBounds(194, 91, 186, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 138, 186, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 185, 186, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(194, 236, 186, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBackground(Color.BLACK);
		btnModifier.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBounds(116, 291, 115, 29);
		contentPane.add(btnModifier);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*UserMainPage ump = new UserMainPage();
				ump.setLocationRelativeTo(null);
				ump.setResizable(false);
				ump.setVisible(true);*/
				contentPane.setVisible(false);
			}
		});
		btnAnnuler.setBackground(Color.BLACK);
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAnnuler.setBounds(265, 291, 115, 29);
		contentPane.add(btnAnnuler);
	}

}
