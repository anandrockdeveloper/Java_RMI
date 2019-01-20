package com.anand.rmiserver;

import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import java.rmi.server.UnicastRemoteObject;

import com.anand.rmiinterface.*;

public class BookImpl extends UnicastRemoteObject implements Book{

	protected BookImpl() throws RemoteException {
		super();
	}

	@Override
	public String getBook(String author,long sid) throws UnexpectedException{
		if(sid==627598L)
		{
		return findBook(author);
		}
		else throw new UnexpectedException("Invalid SID",new SerialVersionException("Invalid SID"));
	}

	private String findBook(String author) throws UnexpectedException
	{
		String bookName=""; 
		switch(author)
		{
		case "JKRolling":bookName="Harry Potter";
		break;
		case "ChetanBhagath":bookName="Five Point Someone";
		break;
		default:bookName="";
		}
		if(bookName.length()>1)
		return bookName;
		else
		 throw new UnexpectedException("No Books found",new NotValidAuthor("Author "+author+ " has not wrote any book"));
	}

}
