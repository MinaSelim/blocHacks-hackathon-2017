import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable
{
	private ServerSocket server;
	private ArrayList<Socket> sockets = new ArrayList<Socket>();
	public Server()
	{
		try {
			server = new ServerSocket(9999);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		listenToNewConnections();
	}

	public  void listenToNewConnections()
	{
		while(true)
		{
			try {
				Socket x = server.accept();
				new Client(x);
				//
				
				sockets.add(x);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		

	}


}
