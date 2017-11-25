/*The main server that handles  */

package server_handler;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import refugee.Refugee;

public class Handler implements Runnable {

	protected PrintWriter display;
	protected Socket client;
	protected Scanner kb;
	private ArrayList <Refugee> ref = new ArrayList<Refugee>();
	
	public Handler(Socket s){
		client = s;
		
		try {
			kb = new Scanner(client.getInputStream());
			display = new PrintWriter(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while(!client.isClosed()) {
			if (kb.hasNext()) {
				processRequest();
				}
			}
		}
	public void processRequest() {
		
	}
}
