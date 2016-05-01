package appTémoin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class MyTable extends JFrame {

	String nameTask="";
	private static final long serialVersionUID = 1L;

		public MyTable(){
			//Form
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100,0,1200,1200);
			setTitle("Todo List");
			getContentPane().setLayout(null);
			
			//ScrollPane
			JScrollPane scroll = new JScrollPane();
			scroll.setBounds(70, 80, 1000, 500);
			getContentPane().add(scroll);
			
			//Table
			final JTable table = new JTable();
			scroll.setViewportView(table);
			
			//Model of table
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
			
			//Assign the model to table
			table.setModel(model);
			table.setRowHeight(20);
			model.addColumn("isDone");
			model.addColumn("Name");
			model.addColumn("Description");
			model.addColumn("DeadLine");
			model.addColumn("Priority");
						
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
						jf.setBounds(200, 0, scroll.getWidth()+100, scroll.getHeight()+100);
						jf.setVisible(true);
						
						//JScrollePane
						JScrollPane scrollST = new JScrollPane();
						//scrollST.setBounds(200, 0, 500, 500);
						JPanel panel = new JPanel();
						panel.add (scrollST);
						jf.add(panel);
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
						panel2.setBounds(20, 30, 130, 30);
						jf.add(panel2);
						
						//jf.getContentPane().add(btnST);
					}
				});
				jButton[j].setBounds(scroll.getX()+1000, y, 100, 20);
				getContentPane().add(jButton[j]);
				j++;
				y += 20;
			}
			
			
			
			//Obtain Selected row
			JButton btn = new JButton("Validate Task");
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					//Get Selected row
					for(int i = 0; i < table.getRowCount(); i++){
						Boolean checked = Boolean.valueOf(table.getValueAt(i, 0).toString());
						String col = table.getValueAt(i, 1).toString();
						
						//Display
						if(checked){
							JOptionPane.showMessageDialog(null, col);
						}
					}
				}
			});
			
			//add button to form
			btn.setBounds(20, 30, 130, 30);
			getContentPane().add(btn);
		}
}
