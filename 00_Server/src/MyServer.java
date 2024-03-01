import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	
	ServerSocket server;
	DataOutputStream writeToClient;
	DataInputStream readFromConsole;
	DataInputStream readFromClient;
	
	public MyServer() {
		try {
			server = new ServerSocket(5555);
			System.out.println("server up with port no 5555");
			Socket socket = server.accept();
			System.out.println("server connected with the client");
			readFromConsole = new DataInputStream(System.in);
			readFromClient = new DataInputStream(socket.getInputStream());
			writeToClient = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	public void chat() throws IOException {
		System.out.println("start chating with client");
		while(true) {
			String strFromClient = readFromClient.readUTF();
			System.out.println("Client: "+strFromClient);
			System.out.print("Server: ");
			String strFromConsole = readFromConsole.readLine();
			writeToClient.writeUTF(strFromConsole);
		}
	}
	
	public static void main(String[] args) {
		MyServer server = new MyServer();
		try {
			server.chat();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
