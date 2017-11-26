package servers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import refugee.Refugee;

public class MainHandler implements Runnable {
	protected PrintWriter writeToClient;
	protected Socket client;
	protected Scanner kb;
	private ArrayList <Refugee> ref = new ArrayList<Refugee>();
	
	
	public MainHandler(Socket s){
		client = s;
		System.out.println("client connected to handler");
		
		try {
			kb = new Scanner(client.getInputStream());
			Thread.sleep(1000);
			writeToClient = new PrintWriter(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread thread = new Thread(this);
		thread.start();
	}
    public void run() {
		System.out.println("thread is running");
				processRequest();
				}
	public void processRequest() {
		{
		if(kb.next().equalsIgnoreCase("SendingRefugeeto:")) {
			sendInformation();
		}
		else if(kb.next().equalsIgnoreCase("StoreMIARefugee:"))
			storeInformation();
		else if(kb.next().equalsIgnoreCase("SearchforRefugee:"))
		{
			long fingerPrint=kb.nextLong();
			Refugee tempRef = findRefugee(fingerPrint);
			if(tempRef==null)
				writeToClient.println("Cannotfindfingerprint:");
			else
				writeToClient.println(tempRef);
		}
			
	}
	}
	public void sendInformation() {   	
		try {
		   	String ipAddress = kb.next();
		   	int port=kb.nextInt();
			Socket s = new Socket(ipAddress,port);
			writeToClient=new PrintWriter(s.getOutputStream());
			while(kb.hasNext()) {
			writeToClient.println("CreatenewRefugee: ");
			writeToClient.println(kb.next());
			}
			writeToClient.flush();
			//deleteRefugee()
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		}
	public Refugee  findRefugee(long fingerPrint) {
		for(int i=0;i<ref.size();i++)
		{
			if(ref.get(i).getFingerprint() == fingerPrint)
				writeToClient.println("RefugeeFound: "+ref.get(i));
		}
		return null;
	}
	public void storeInformation() {
		ref.add(new Refugee(kb));
		System.out.println(ref.get(0));
	}
	public void deleteRefugee(Refugee refugee) {
		for(int i=0;i<ref.size();i++) {
			if(ref.get(i).getFingerprint()==refugee.getFingerprint())
				ref.remove(i);
		}
		
	}

}
