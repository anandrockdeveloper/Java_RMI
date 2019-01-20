package com.anand.rmiserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.anand.rmiconfiguration.Configuration;

public class RmiServer {
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		
		BookImpl book= new BookImpl();
		Registry registry = LocateRegistry.createRegistry(Configuration.REMOTE_PORT);
		registry.bind(Configuration.REMOTE_ID, book);
		System.out.println("Remote Server Started");
		
		
	}

}
