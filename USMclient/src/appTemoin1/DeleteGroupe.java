package appTemoin1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vInterface._Group;
import vInterface._User;
import vInterfaceDB._UserDB;
import vInterfaceDB._GroupDB;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class DeleteGroupe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteGroupe frame = new DeleteGroupe();
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
	public DeleteGroupe(HashMap<String, Object> rmi) {
		setTitle("Ultimate Society Messenger");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteGroupe.class.getResource("/appTemoin1/images/fleches-echange.gif")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectionnerUnGroupe = new JLabel("Selectionner un groupe");
		lblSelectionnerUnGroupe.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblSelectionnerUnGroupe.setForeground(Color.WHITE);
		lblSelectionnerUnGroupe.setBounds(116, 86, 172, 20);
		contentPane.add(lblSelectionnerUnGroupe);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DeleteGroupe.class.getResource("/appTemoin1/images/delete-user-group-icon-2897.png")));
		label.setBounds(29, 29, 103, 48);
		contentPane.add(label);
		
		try {
			ArrayList<_Group> g =  ((_GroupDB) rmi.get("GroupDB")).getAllGroups();
			String[] allGroups = new String[g.size()+1];
			allGroups[0] = "Choisissez le groupe..";
			for (int i=1; i<g.size()+1;i++){
				allGroups[i] = g.get(i-1).getName();
			}
			
			JComboBox cbGroups = new JComboBox(allGroups);
			cbGroups.setBounds(29, 118, 336, 26);
			contentPane.add(cbGroups);
			
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					((_GroupDB) rmi.get("GroupDB")).removeGroup(g.get(cbGroups.getSelectedIndex()-1).getIdG());
					JOptionPane.showMessageDialog(null, "Le groupe a bien \u00E9t\u00E9 supprim\u00E9 !");
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		btnSupprimer.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnSupprimer.setBackground(Color.BLACK);
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setBounds(59, 170, 115, 29);
		contentPane.add(btnSupprimer);
		
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		
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
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(189, 170, 115, 29);
		contentPane.add(btnNewButton_1);
	}

}
