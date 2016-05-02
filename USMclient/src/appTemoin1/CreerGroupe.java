package appTemoin1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import vInterface._Group;
import vInterface._ObjectBuilder;
import vInterface._User;
import vInterfaceDB._GroupDB;
import vInterfaceDB._UserDB;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.HashMap;
import javax.swing.JTextPane;

public class CreerGroupe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreerGroupe frame = new CreerGroupe();
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
	public CreerGroupe(HashMap<String, Object> rmi) {
		setTitle("Ultimate Society Messenger");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreerGroupe.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CreerGroupe.class.getResource("/appTemoin1/images/OMGFDP.png")));
		lblNewLabel.setBounds(75, 46, 124, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(51, 154, 54, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(33, 207, 94, 20);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		textField.setBounds(137, 151, 299, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		textArea.setBounds(137, 202, 299, 78);
		contentPane.add(textArea);
		textArea.setLineWrap(true);
		
		JButton btnNewButton = new JButton("Créer Groupe");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String Name, Desc;
					Name = textField.getText();
					Desc = textArea.getText();

					((_GroupDB) rmi.get("GroupDB")).addGroup(Name, Desc);
					
					JOptionPane.showMessageDialog(null, "Le groupe a bien été crée !");
					
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setBounds(137, 308, 142, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(321, 308, 115, 29);
		contentPane.add(btnNewButton_1);
		
	}
}
