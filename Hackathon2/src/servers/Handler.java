package servers;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import refugees.Refugee;

public class Handler extends MainHandler {
	
	protected PrintWriter writeToHub;
	private static ArrayList <Refugee> refugees_list = new ArrayList<Refugee>();
	
	public void addToArrayList(Refugee o)
	{
		//System.out.println(o);
		refugees_list.add(o);
		System.out.println("size: " + refugees_list.size());
	}
	
	public Handler(Socket s){
		super(s);
	}
	public void processRequest() {
		while(true)
		{
			if(kb.hasNext())
			{
				String request = kb.next();
				System.out.println(request);
				if(request.equalsIgnoreCase("SendingRefugeeto:")) {
					long fingerPrint=kb.nextLong();
					String ipAddress=kb.next();
					int port = kb.nextInt();
					Refugee tempRef=findRefugee(fingerPrint);
				    sendInformation(tempRef,ipAddress,port);
				}
				else if(request.equalsIgnoreCase("CreatenewRefugee:"))
					storeInformation();
				else if(request.equalsIgnoreCase("SearchforRefugee:"))
				{
					long fingerPrint=kb.nextLong();
					Refugee tempRef = findRefugee(fingerPrint);
					if(tempRef==null)
						writeToClient.println("Cannotfindfingerprint");
					else
						writeToClient.println(tempRef);
				}
				else if(request.equalsIgnoreCase("StoreMIARRefugee: "))
				{
					long fingerPrint=kb.nextLong();
					storeMIARefugee(fingerPrint);
				}
				
			}
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
		refugees_list.add(new Refugee(readFromHub));
	     return(refugees_list.get(refugees_list.size()-1));
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
			
		
