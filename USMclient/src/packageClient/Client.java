package packageClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import appTémoin.app1;
import vInterface.*;

public class Client {

	public static void main(String[] args) {
		
		HashMap<String, Object> rmi = new HashMap<>();

		System.out.println("Lancement du client");
		try {
			String IPSERVER = "localhost";
			int PORT = 54321;
			String urlObjectBuilder = "rmi://"+IPSERVER+":"+PORT+"/ObjectBuilder";
			String urlUserDB = "rmi://"+IPSERVER+":"+PORT+"/UserDB";
			
			_ObjectBuilder ob = (_ObjectBuilder)Naming.lookup(urlObjectBuilder);
			_UserDB userdb = (_UserDB)Naming.lookup(urlUserDB);
			
			rmi.put("ObjectBuilder", ob);
			rmi.put("UserDB", userdb);
			
			//test
			app1 JFCon = new app1(rmi);
			JFCon.frmUltimateSocietyMessenger.setVisible(true);			
			
			
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
