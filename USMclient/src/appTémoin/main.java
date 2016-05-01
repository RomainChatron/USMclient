package appTémoin;

import java.awt.EventQueue;

//import interfaceFw.TaskListCheck;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				MyTable form = new MyTable();
				form.setVisible(true);;
			}
		});
	}

}
