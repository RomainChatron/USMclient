package vInterfaceDB;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _GroupDB extends Remote {
	public void addGroup(final String name, final String desc) throws RemoteException ;
	public void updateGroup(final int idG, final String nameG, final String descG) throws RemoteException ;
	public void removeGroup(final int idG) throws RemoteException ;
	public int getMaxGroup() throws RemoteException ;
}
