package packageClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import appTemoin1.GroupChat;
import vInterface._ChatC;

@SuppressWarnings("serial")
public class ChatC extends UnicastRemoteObject implements _ChatC {

	GroupChat fenetre ;
	String nomChat ;
	int idC ;
	
	public ChatC() throws RemoteException {
		super();
	}
	
	public ChatC(GroupChat papa, String nomChat) throws RemoteException {
		super();
		this.fenetre = papa ;
		this.nomChat = nomChat ;
	}

	@Override
	public void postMessage(String message) throws RemoteException {
		System.out.println("On est sur ChatC : " + message);
		fenetre.displayMessage(message);
	}

}
