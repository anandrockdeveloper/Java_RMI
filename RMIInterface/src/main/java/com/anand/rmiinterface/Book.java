package com.anand.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;

public interface Book extends Remote{
	
	/**
	 * Find book by authorName. Serial Version is mandatory.
	 * The SID is not shared for end clients.This Method is strictly for server implementation.
	 */
	String getBook(String author,long id) throws RemoteException;

	/**
	 * Default Method to Find book by authorName.
	 * @throws  
	 */
	default String getBookByAuthor(String author) throws RemoteException
	{
		if (author.matches("\\D*")) {
			long serialVersionUid=627598L;
				return getBook(author,serialVersionUid);
		}
		else
			throw new UnexpectedException("Invalid Author",new NotValidAuthor("Name Cannot contain number or digits"));
	}

}
