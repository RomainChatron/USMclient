package packageClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import appT�moin.app1;
import vInterface.*;
import vInterfaceDB._UserDB;
import vInterfaceDB._UserGroupDB;

public class Client {

	public static void main(String[] args) {
		
		HashMap<String, Object> rmi = new HashMap<>();

		System.out.println("Lancement du client");
		try {
			String IPSERVER = "localhost";
			int PORT = 54321;
			String urlObjectBuilder = "rmi://"+IPSERVER+":"+PORT+"/ObjectBuilder";
			String urlUserDB = "rmi://"+IPSERVER+":"+PORT+"/UserDB";
			String urlUserGroupDB = "rmi://"+IPSERVER+":"+PORT+"/UserGroupDB";
			
			_ObjectBuilder ob = (_ObjectBuilder)Naming.lookup(urlObjectBuilder);
			_UserDB userDB = (_UserDB)Naming.lookup(urlUserDB);
			_UserGroupDB userGroupDB = (_UserGroupDB)Naming.lookup(urlUserGroupDB);
			
			rmi.put("ObjectBuilder", ob);
			rmi.put("UserDB", userDB);
			rmi.put("UserGroupDB", userGroupDB);
			
			 
			app1 JFCon = new app1(rmi);
			JFCon.frmUltimateSocietyMessenger.setVisible(true);			
			
			
			/* Test Perso */
			//Connexion JFCon = new Connexion(rmi);
			//JFCon.setVisible(true);
			
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
