package servers;
import refugee.Refugee;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import refugee.Refugee;

public class Handler extends MainHandler {
	
	protected PrintWriter writeToClient;
	protected PrintWriter writeToHub;
	protected Socket client;
	protected Scanner kb;
	private ArrayList <Refugee> ref = new ArrayList<Refugee>();
	
	public Handler(Socket s){
		super(s);
	}
	public void processRequest() {
		if(kb.next().equalsIgnoreCase("SendingRefugeeto:")) {
			long fingerPrint=kb.nextLong();
			String ipAddress=kb.next();
			int port = kb.nextInt();
			Refugee tempRef=findRefugee(fingerPrint);
		    sendInformation(tempRef,ipAddress,port);
		}
		else if(kb.next().equalsIgnoreCase("CreatenewRefugee: "))
			storeInformation();
		else if(kb.next().equalsIgnoreCase("SearchforRefugee:"))
		{
			long fingerPrint=kb.nextLong();
			Refugee tempRef = findRefugee(fingerPrint);
			if(tempRef==null)
				writeToClient.println("Cannotfindfingerprint");
			else
				writeToClient.println(tempRef);
		}
		else if(kb.next().equalsIgnoreCase("StoreMIARRefugee: "))
				{
				long fingerPrint=kb.nextLong();
				storeMIARefugee(fingerPrint);
				}
		
				
	 }
	public void sendInformation(Refugee tempRef,String ipAddress,int port) {
	   
		try {
			Socket s = new Socket("127.0.0.1",4242);
			writeToHub=new PrintWriter(s.getOutputStream());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		writeToHub.println("SendingRefugeeto: "+ipAddress+" "+port+" "+tempRef);
		}
	public Refugee findRefugeeMIA(long fingerPrint ) {
		PrintWriter write=null;
		Scanner readFromHub=null;
		String str="";
		try {
			Socket socket = new Socket("127.0.0.1",4242);
			readFromHub = new Scanner(socket.getInputStream());
			write = new PrintWriter(socket.getOutputStream());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		write.println("SearchforRefugee: "+fingerPrint);
		write.flush();
		 if(readFromHub.hasNext())
		 {
	     ref.add(new Refugee(readFromHub));
	     return(ref.get(ref.size()-1));
		 }
		 return null;
		 
		
		
		
		
	}
	public void storeMIARefugee(long fingerPrint) {
		Refugee tempRef=findRefugee(fingerPrint);
		if(tempRef!=null)
			sendInformation(tempRef);
	}
	public void sendInformation(Refugee tempRef)
	{
		try {
		Socket s = new Socket("127.0.0.1",4242);
		
		}
		catch(IOException e) {
		e.printStackTrace();
		}
		writeToHub.println("StoreMIARefugee: "+tempRef);
		writeToHub.flush();
	}
}
			
		
