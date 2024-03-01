import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class MyClient {
	
	Socket clientSocket;
	DataInputStream readFromConsole;
	DataOutputStream writeToServer;
	DataInputStream readFromServer;
	
	public MyClient() {
		try {
			clientSocket = new Socket(InetAddress.getLocalHost(), 5555);
			System.out.println("connected with the server!!!");
			readFromConsole = new DataInputStream(System.in);
			writeToServer = new DataOutputStream(clientSocket.getOutputStream());
			readFromServer = new DataInputStream(clientSocket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void chat() throws IOException {
		System.out.println("start chating with server");
		while(true) {
			System.out.print("Client: ");
			String strFromConsole = readFromConsole.readLine();
			writeToServer.writeUTF(strFromConsole);
			String strFromServer = readFromServer.readUTF();
			System.out.println("Server: "+strFromServer);
		}
	}
	
	public static void main(String[] args) {
		MyClient client = new MyClient();
		try {
			client.chat();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
