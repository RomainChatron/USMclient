package appTemoin1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Task extends JFrame {

	String nameTask="";
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				Task form = new Task();
				form.setVisible(true);
			}
		});
	}

		public Task(){
			getContentPane().setBackground(new Color(0, 102, 204));
			setIconImage(Toolkit.getDefaultToolkit().getImage(Task.class.getResource("/appTemoin1/images/fleches-echange.gif")));
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100,0,1257,536);
			setTitle("Ultimate Society Messenger");
			getContentPane().setLayout(null);
			JScrollPane scroll = new JScrollPane();
			final JTable table = new JTable();
			scroll.setViewportView(table);
			DefaultTableModel model = new DefaultTableModel(){
				public Class<?> getColumnClass(int column){
					switch (column) {
					case 0:
						return Boolean.class;
					case 1:
						return String.class;
					case 2:
						return String.class;
					case 3:
						return String.class;
					case 4:
						return String.class;

					default:
						return String.class;
					}
				}
			};
			table.setModel(model);
			table.setRowHeight(20);
			model.addColumn("Tâche effectué");
			model.addColumn("Nom");
			model.addColumn("Description");
			model.addColumn("DeadLine");
			model.addColumn("Groupe");
			model.addColumn("Priorité");
						
			//the Row
			int i = 0;
			while(i <= 5){
				model.addRow(new Object[0]);
				model.setValueAt(false, i, 0);
				model.setValueAt("Our row"+(i+1), i, 1);
				model.setValueAt("Our Column 2", i, 2);
				model.setValueAt("Our Column 3", i, 3);
				model.setValueAt("Our Column 4", i, 4);
				i++;
			}
			
			scroll.setBounds(70, 126, 1000, 20*(i+2));
			getContentPane().add(scroll);
			
			
			//The SubTask
			int j = 0;
			int y = scroll.getY()+20;
			JButton[] jButton = new JButton[i];
			while(j < jButton.length){
				jButton[j] = new JButton("SubTask");
				
				//Get the Name of our Task
				nameTask = model.getValueAt(j, 1).toString();
				
				jButton[j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						//JFrame
						JFrame jf = new JFrame();

						jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						jf.setTitle("SubTask de "+ nameTask);
						jf.setBounds(200, 0, scroll.getWidth()+200, scroll.getHeight()+200);
						jf.setLocationRelativeTo(null);
						jf.setResizable(false);
						jf.setVisible(true);
						
						//JScrollePane
						JScrollPane scrollST = new JScrollPane();
						//scrollST.setBounds(200, 0, 500, 500);
						JPanel panel = new JPanel();
						panel.add (scrollST);
						jf.getContentPane().add(panel);
						panel.setBounds(70, 80, 500, 800);
						//jf.getContentPane().add(scrollST);
						
						//Table
						final JTable tableST = new JTable();
						scrollST.setViewportView(tableST);
						
						//Model of table
						DefaultTableModel modelST = new DefaultTableModel(){
							public Class<?> getColumnClass(int column){
								switch (column) {
								case 0:
									return Boolean.class;
								case 1:
									return String.class;
								case 2:
									return String.class;
								case 3:
									return String.class;
								case 4:
									return String.class;

								default:
									return String.class;
								}
							}
						};
						
						//Assign the model to table
						tableST.setModel(modelST);
						tableST.setRowHeight(20);
						modelST.addColumn("isDone");
						modelST.addColumn("Name");
						modelST.addColumn("Description");
						modelST.addColumn("DeadLine");
						modelST.addColumn("Priority");
						
						//the Row
						int a = 0;
						while(a <= 5){
							modelST.addRow(new Object[0]);
							modelST.setValueAt(false, a, 0);
							modelST.setValueAt("Our row"+(a+1), a, 1);
							modelST.setValueAt("Our Column 2", a, 2);
							modelST.setValueAt("Our Column 3", a, 3);
							modelST.setValueAt("Our Column 4", a, 4);
							a++;
						}
						
						//Obtain Selected row
						JButton btnST = new JButton("Validate Task");
						JButton btnAnnuler = new JButton("Annuler");
						btnAnnuler.setBackground(Color.BLACK);
						btnAnnuler.setForeground(Color.WHITE);
						btnAnnuler.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
						btnST.setBackground(Color.BLACK);
						btnST.setForeground(Color.WHITE);
						btnST.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
						
						btnST.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
								//Get Selected row
								for(int i = 0; i < tableST.getRowCount(); i++){
									Boolean checkedST = Boolean.valueOf(tableST.getValueAt(i, 0).toString());
									String colST = tableST.getValueAt(i, 1).toString();
									
									//Display
									if(checkedST){
										JOptionPane.showMessageDialog(null, colST);
									}
								}
							}
						});

						//btnST.setBounds(100, 800, 50, 30);
						JPanel panel2 = new JPanel();
						panel2.add (btnST);
						panel2.add(btnAnnuler);
						panel2.setBounds(20, 30, 130, 30);
						jf.getContentPane().add(panel2);
						btnAnnuler.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								/*Task2 task = new Task2();
								task.setLocationRelativeTo(null);
								task.setResizable(false);
								task.setVisible(true);*/
								jf.setVisible(false);
								
							}
						});
					}
				});
				jButton[j].setBounds(scroll.getX()+1010, y, 100, 20);
				getContentPane().add(jButton[j]);
				j++;
				y += 20;
			}
			
			
			
			//Obtain Selected row
			JButton btn = new JButton("T\u00E2che(s) termin\u00E9es");
			btn.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			btn.setBackground(Color.BLACK);
			btn.setForeground(Color.WHITE);
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i < table.getRowCount(); i++){
						Boolean checked = Boolean.valueOf(table.getValueAt(i, 0).toString());
						String col = table.getValueAt(i, 1).toString();
						if(checked){
							JOptionPane.showMessageDialog(null, col);
						}
					}
				}
			});
			
			//add button to form
			btn.setBounds(70, 301, 184, 30);
			getContentPane().add(btn);
			
			JLabel lblGestionDeSes = new JLabel("Gestion de ses t\u00E2ches et cr\u00E9ation de sous-t\u00E2ches");
			lblGestionDeSes.setForeground(Color.WHITE);
			lblGestionDeSes.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			lblGestionDeSes.setIcon(new ImageIcon(Task.class.getResource("/appTemoin1/images/005.png")));
			lblGestionDeSes.setBounds(70, 44, 474, 48);
			getContentPane().add(lblGestionDeSes);
			
			JButton btnAnnuler = new JButton("Annuler");
			btnAnnuler.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			btnAnnuler.setBackground(Color.BLACK);
			btnAnnuler.setForeground(Color.WHITE);
			btnAnnuler.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			btnAnnuler.setBounds(290, 302, 115, 29);
			getContentPane().add(btnAnnuler);
		}
}
