package appTemoin1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vInterface._Article;
import vInterface._Group;
import vInterface._Task;
import vInterfaceDB._ArticleDB;
import vInterfaceDB._DataArticleDB;
import vInterfaceDB._DataDB;
import vInterfaceDB._TaskDB;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class Vue_Groupe extends JFrame {

	private JPanel contentPane;
	private String affTxtArea = "";
	private int idData;

	public void setIdData(int idDa) {
		this.idData = idDa;
	}
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
			setBounds(100, 100, 965, 791);
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
			
			// Modification article :
			ArrayList<_Article> info = ((_ArticleDB) rmi.get("ArticleDB")).getArticles(2);
			String[] idArticles = new String[info.size()];
			for (int y = 0 ; y < info.size() ; y++) {
				idArticles[y] = ""+info.get(y).getIdA();
			}
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
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(246, 236, 414, 448);
			contentPane.add(scrollPane);
			
			JTextArea txtArticle = new JTextArea();
			scrollPane.setViewportView(txtArticle);
			txtArticle.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			
			// Modification article 2 :
			JButton btFile = new JButton("Pas de pi\u00E8ce jointe");

			btFile.setBackground(Color.BLACK);
			btFile.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			btFile.setForeground(Color.WHITE);
			btFile.setBounds(246, 690, 257, 29);
			contentPane.add(btFile);
			
			JComboBox cbArticles = new JComboBox(idArticles);
			cbArticles.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					try {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							ArrayList<Integer> getIdData;
								getIdData = ((_DataArticleDB) rmi.get("DataArticleDB")).getDatas(Integer.parseInt(cbArticles.getItemAt(cbArticles.getSelectedIndex()).toString()));
							
							ArrayList<String>	getName = ((_DataArticleDB) rmi.get("DataArticleDB")).getDatasName(Integer.parseInt(cbArticles.getItemAt(cbArticles.getSelectedIndex()).toString()));
							for (int i = 0 ; i < getIdData.size() ; i++) {
								if (((_DataDB) rmi.get("DataDB")).isDataTxt(getIdData.get(i))) {
									affTxtArea = ((_DataDB) rmi.get("DataDB")).getDataTxt(getIdData.get(i));
									btFile.setText("Pas de pièce jointe");
								} else {
									setIdData(getIdData.get(i));
									btFile.setText("Télécharger : " + getName.get(i));
								}
							}
					    }
					} catch (NumberFormatException | RemoteException e1) {
						e1.printStackTrace();
					}
				}
					
			});
			cbArticles.setBounds(246, 202, 140, 26);
			contentPane.add(cbArticles);
			
			JButton btAff = new JButton("Afficher article");
			btAff.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txtArticle.setText("");
					txtArticle.setText(affTxtArea);
				}
			});
			btAff.setBackground(Color.BLACK);
			btAff.setForeground(Color.WHITE);
			btAff.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			btAff.setBounds(487, 201, 173, 29);
			contentPane.add(btAff);
			
			btFile.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (btFile.getText().equals("Pas de pièce jointe")) {
						JOptionPane.showMessageDialog(null, "Cette article n'a pas de pièce jointe !");
					} else {
						SelectPath sp = new SelectPath(rmi, idData);
					}
				}
			});

		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}
}
