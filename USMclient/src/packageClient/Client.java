package packageClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import vInterface.*;

public class Client {

	public static void main(String[] args) {
		
		HashMap<String, Object> rmi = new HashMap<>();

		System.out.println("Lancement du client");
		try {
			String IPSERVER = "localhost";
			int PORT = 54321;
			String urlObjectBuilder = "rmi://"+IPSERVER+":"+PORT+"/ObjectBuilder";
			
			_ObjectBuilder ob = (_ObjectBuilder)Naming.lookup(urlObjectBuilder);
			
			rmi.put("ObjectBuilder", ob);
			
			//test
			Connexion JFCon = new Connexion(rmi);
			JFCon.setVisible(true);
			
			
			
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
