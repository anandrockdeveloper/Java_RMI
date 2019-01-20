package com.anand.rmiclient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.anand.rmiconfiguration.Configuration;
import com.anand.rmiinterface.Book;
import com.anand.rmiinterface.NotValidAuthor;

public class RmiClient {

	public static void main(String[] args) {
		Registry reg;
		try {
			reg= LocateRegistry.getRegistry(Configuration.REMOTE_HOST, Configuration.REMOTE_PORT);
			Book book = (Book) reg.lookup(Configuration.REMOTE_ID);
			String author= "JKRolling";
			System.out.println(author +" has written book "+book.getBookByAuthor(author));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
