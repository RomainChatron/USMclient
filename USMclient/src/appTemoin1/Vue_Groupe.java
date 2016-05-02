package appTemoin1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vInterface._Group;
import vInterface._Task;
import vInterfaceDB._TaskDB;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class Vue_Groupe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vue_Groupe frame = new Vue_Groupe();
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
	public Vue_Groupe(HashMap<String, Object> rmi, _Group group) {
		try {
			ArrayList<_Task> listTask = ((_TaskDB)rmi.get("TaskDB")).getTasks(group.getIdG());
			String tasks = "\r\n" ;
			for(int i = 0 ; i < listTask.size(); i++) {
				tasks += " - " + listTask.get(i).getName() + " \r\n" ;
			}
			setIconImage(Toolkit.getDefaultToolkit().getImage(Vue_Groupe.class.getResource("/appTemoin1/images/fleches-echange.gif")));
			setTitle("Ultimate Society Messenger");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 935, 770);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 102, 204));
			contentPane.setForeground(new Color(0, 102, 204));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			/* Label bienvenue */
			JLabel lblNewLabel = new JLabel("Bienvenue sur le groupe " + group.getName());
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD, 24));
			lblNewLabel.setIcon(null);
			lblNewLabel.setBounds(15, 16, 488, 54);
			contentPane.add(lblNewLabel);
			
			
			String membres = "\r\n";
			for(int i = 0 ; i < group.getListMember().size() ; i++) {
				membres += "- " + group.getListMember().get(i).getUserName() + "\r\n";
			}
			
			/* TextArea des users du groupe */
			JTextArea txtrDakaya = new JTextArea();
			txtrDakaya.setBackground(SystemColor.inactiveCaption);
			txtrDakaya.setText(membres);
			txtrDakaya.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			txtrDakaya.setBounds(15, 201, 202, 240);
			txtrDakaya.setEditable(false);
			contentPane.add(txtrDakaya);
			
			/* Label liste des membres */
			JLabel lblNewLabel_1 = new JLabel("Liste des membres");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setIcon(new ImageIcon(Vue_Groupe.class.getResource("/appTemoin1/images/OMGFDP.png")));
			lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(15, 137, 192, 48);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblJournal = new JLabel("Journal");
			lblJournal.setHorizontalAlignment(SwingConstants.LEFT);
			lblJournal.setForeground(Color.WHITE);
			lblJournal.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblJournal.setIcon(new ImageIcon(Vue_Groupe.class.getResource("/appTemoin1/images/windows-journal-viewer-icon.png")));
			lblJournal.setBounds(373, 134, 140, 54);
			contentPane.add(lblJournal);
			
			/* Label mes taches */
			JLabel lblNewLabel_3 = new JLabel("Mes t\u00E2ches");
			lblNewLabel_3.setIcon(new ImageIcon(Vue_Groupe.class.getResource("/appTemoin1/images/005.png")));
			lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setBounds(715, 137, 171, 48);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblDescriptionGroupe = new JLabel(group.getDescription() + "\r\n");
			lblDescriptionGroupe.setForeground(Color.WHITE);
			lblDescriptionGroupe.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblDescriptionGroupe.setBounds(196, 86, 445, 29);
			contentPane.add(lblDescriptionGroupe);
			
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon(Vue_Groupe.class.getResource("/appTemoin1/images/barre.jpg")));
			lblNewLabel_2.setBounds(-25, 179, 966, 5);
			contentPane.add(lblNewLabel_2);
			
			JTextArea txtArticle1 = new JTextArea();
			txtArticle1.setText("Le premier article ici");
			txtArticle1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			txtArticle1.setBounds(241, 201, 445, 417);
			contentPane.add(txtArticle1);
			
			JTextArea textArea_2 = new JTextArea();
			textArea_2.setBackground(SystemColor.inactiveCaption);
			textArea_2.setText(tasks);
			textArea_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			textArea_2.setBounds(706, 201, 192, 240);
			textArea_2.setEditable(false);
			contentPane.add(textArea_2);
			
			
			/* Bouton quitter groupe */
			JButton btnQuitterGroupe = new JButton("Quitter groupe");
			btnQuitterGroupe.setBackground(Color.BLACK);
			btnQuitterGroupe.setForeground(Color.WHITE);
			btnQuitterGroupe.setHorizontalAlignment(SwingConstants.LEFT);
			btnQuitterGroupe.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			btnQuitterGroupe.setIcon(new ImageIcon(Vue_Groupe.class.getResource("/appTemoin1/images/delete-user-group-icon-2897.png")));
			btnQuitterGroupe.setBounds(15, 528, 202, 48);
			contentPane.add(btnQuitterGroupe);
			
			JButton btRetour = new JButton("Retour");
			btRetour.setBackground(Color.BLACK);
			btRetour.setForeground(Color.WHITE);
			btRetour.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			btRetour.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			btRetour.setBounds(706, 492, 125, 38);
			contentPane.add(btRetour);
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Vue_Groupe.class.getResource("/appTemoin1/images/Groupe-travail-th\u00E9matique2.png")));
			lblNewLabel_4.setBounds(726, 570, 145, 128);
			contentPane.add(lblNewLabel_4);
			
			/* Bouton du chat */
			JButton btnChatDuGroupe = new JButton("Chat du groupe");
			btnChatDuGroupe.setBackground(Color.BLACK);
			btnChatDuGroupe.setForeground(Color.WHITE);
			btnChatDuGroupe.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GroupChat gC = new GroupChat(rmi, group);
					gC.setLocationRelativeTo(null);
					gC.setResizable(false);
					gC.setVisible(true);
				}
			});
			btnChatDuGroupe.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			btnChatDuGroupe.setIcon(new ImageIcon(Vue_Groupe.class.getResource("/appTemoin1/images/par_chat.png")));
			btnChatDuGroupe.setBounds(15, 455, 202, 48);
			contentPane.add(btnChatDuGroupe);
			
			JTextArea txtrLeDeuxime = new JTextArea();
			txtrLeDeuxime.setText("Le deuxi\u00E8me...");
			txtrLeDeuxime.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			txtrLeDeuxime.setBounds(245, 634, 441, 80);
			contentPane.add(txtrLeDeuxime);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}
}
