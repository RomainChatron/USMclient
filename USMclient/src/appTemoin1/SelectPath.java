package appTemoin1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vInterfaceDB._DataDB;

import javax.swing.JFileChooser;

@SuppressWarnings("serial")
public class SelectPath extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//SelectPath frame = new SelectPath();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public SelectPath(HashMap<String, Object> rmi, int idDa) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setBounds(0, 16, 828, 401);
		contentPane.add(fileChooser);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = fileChooser.showSaveDialog(this);
		if (result == fileChooser.APPROVE_OPTION) {
			try {
				((_DataDB) rmi.get("ArticleDB")).saveData(idDa, fileChooser.getCurrentDirectory().getAbsolutePath());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		} else if (result == fileChooser.CANCEL_OPTION) {
			dispose(); // qui marche pas... ?
		}
	}

}
