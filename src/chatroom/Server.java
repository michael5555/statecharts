package chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ServerRunnable implements Runnable {
	
	private Socket clientSocket;
	private Server server;
	
	public ServerRunnable(Socket clientSocket, Server server) {
		this.clientSocket = clientSocket;
		this.server = server;
	}

	@Override
	public void run() {
		PrintWriter out;
		BufferedReader in;
		try {
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			return;
		}
		
	    String inputLine;
		
		try {
			while ((inputLine = in.readLine()) != null) {
				System.out.println("Received " + inputLine);
			    if (inputLine.startsWith("POLL")) {
			    	out.println("ALIVE");
			    } else if (inputLine.startsWith("JOIN")) {
					int room_number = Integer.valueOf(inputLine.substring(5));
					server.addClientToRoom(clientSocket, room_number);
					out.println("ACK JOIN " + String.valueOf(room_number));
				} else if (inputLine.startsWith("LEAVE")) {
					server.removeClientFromRoom(clientSocket);
					out.println("ACK LEAVE");
				} else if (inputLine.startsWith("MSG")) {
					server.sendMessage(clientSocket, inputLine);
				}
			}
	    } catch (IOException e) {
			return;
		} finally {
	    	try {
	    		server.removeClientFromRoom(clientSocket);
		    	out.close();
				in.close();
			} catch (IOException e1) {}
		}
	}
}

public class Server {
	private Map<Integer, List<Socket>> room2clients = new HashMap<Integer, List<Socket>>();
	private Map<Socket, Integer> client2room = new HashMap<Socket, Integer>();
	
	public Server(int portnumber) {
		ServerSocket serverSocket = null;
		try {
			try {
				serverSocket = new ServerSocket(portnumber);
				System.out.println("Started server on port " + portnumber);
			} catch (NumberFormatException | IOException e) {
				return;
			}
			while (true) {
				try {
					Socket clientSocket = serverSocket.accept();
					System.out.println("Accepted client connection.");
					new Thread(new ServerRunnable(clientSocket, this)).start();
				} catch (IOException e) {}
				
			}
		} finally {
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
			} catch (IOException e) {}
		}
	}
	
	public synchronized void addClientToRoom(Socket client, int room) {
		if (!room2clients.containsKey(room)) {
			room2clients.put(room, new LinkedList<>());
		}
		room2clients.get(room).add(client);
		client2room.put(client, room);
	}
	
	public synchronized void removeClientFromRoom(Socket client) {
		if (client2room.containsKey(client)) {
			int room = client2room.get(client);
			room2clients.get(room).remove(client);
			client2room.remove(client);
		}
	}
	
	public synchronized void sendMessage(Socket sendingClient, String message) {
		if (client2room.containsKey(sendingClient)) {
			List<Socket> to_send = new LinkedList<Socket>(room2clients.get(client2room.get(sendingClient)));
			to_send.remove(sendingClient);
			for (Socket s: to_send) {
				try {
					PrintWriter out = new PrintWriter(s.getOutputStream(), true);
					out.println(message);
				} catch (IOException e) {}
			}
		}
	}
	
	public static void main(String[] args) {
		new Server(Integer.valueOf(args[0]));
	}
}
