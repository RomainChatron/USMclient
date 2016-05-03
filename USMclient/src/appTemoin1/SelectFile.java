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
public class SelectFile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectFile frame = new SelectFile();
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
	public SelectFile(HashMap<String, Object> rmi) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setBounds(0, 0, 869, 401);
		contentPane.add(fileChooser);
		int result = fileChooser.showSaveDialog(this);
		if (result == fileChooser.APPROVE_OPTION) {
			System.out.println("je passe la");
			try {
				((_DataDB)rmi.get("DataDB")).addData(fileChooser.getSelectedFile().getAbsolutePath());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (result == fileChooser.CANCEL_OPTION){
			System.out.println("annuler");
			dispose();
			//fileChooser.setVisible(false);
		}
	}

}
