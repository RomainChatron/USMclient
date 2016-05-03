package packageClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

import appTemoin1.Connexion;
import vInterface.*;
import vInterfaceDB._ArticleDB;
import vInterfaceDB._DataArticleDB;
import vInterfaceDB._DataDB;
import vInterfaceDB._GroupDB;
import vInterfaceDB._TaskDB;
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
			String urlGroupDB = "rmi://"+IPSERVER+":"+PORT+"/GroupDB";
			String urlTaskDB = "rmi://"+IPSERVER+":"+PORT+"/TaskDB";
			String urlDataDB = "rmi://"+IPSERVER+":"+PORT+"/DataDB";
			String urlArticleDB = "rmi://"+IPSERVER+":"+PORT+"/ArticleDB";
			String urlDataArticleDB = "rmi://"+IPSERVER+":"+PORT+"/DataArticleDB";
			String urlChatServer = "rmi://"+IPSERVER+":"+PORT+"/ChatServer";
			
			_ObjectBuilder ob = (_ObjectBuilder)Naming.lookup(urlObjectBuilder);
			_UserDB userDB = (_UserDB)Naming.lookup(urlUserDB);
			_UserGroupDB userGroupDB = (_UserGroupDB)Naming.lookup(urlUserGroupDB);
			_GroupDB GroupDB = (_GroupDB)Naming.lookup(urlGroupDB);
			_TaskDB TaskDB = (_TaskDB)Naming.lookup(urlTaskDB);
			_DataDB DataDB = (_DataDB)Naming.lookup(urlDataDB);
			_ArticleDB ArticleDB = (_ArticleDB)Naming.lookup(urlArticleDB);
			_DataArticleDB DataArticleDB = (_DataArticleDB)Naming.lookup(urlDataArticleDB);
			_ChatServer ChatServer = (_ChatServer)Naming.lookup(urlChatServer);
			
			rmi.put("ObjectBuilder", ob);
			rmi.put("UserDB", userDB);
			rmi.put("UserGroupDB", userGroupDB);
			rmi.put("GroupDB", GroupDB);
			rmi.put("TaskDB", TaskDB);
			rmi.put("DataDB", DataDB);
			rmi.put("ArticleDB", ArticleDB);
			rmi.put("DataArticleDB", DataArticleDB);
			rmi.put("ChatServer", ChatServer);
			
			 
			Connexion JFCon = new Connexion(rmi);
			
			
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
