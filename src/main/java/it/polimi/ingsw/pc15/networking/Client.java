package it.polimi.ingsw.pc15.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private static PrintStream out;
	private static Scanner in;

	
	
	static String hostName;
	
	
	public Client() throws IOException{
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			Socket clientSocket = new Socket(hostName, 12879);
			out = new PrintStream(clientSocket.getOutputStream());
			in = new Scanner(clientSocket.getInputStream());
			String read = in.nextLine();
			System.out.println(read);
			
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String write = input.readLine();
			out.println(write);
			out.flush();
			
			
			System.out.println(in.nextLine());

			String write2 = input.readLine();
			out.println(write2);
			out.flush();
			
			System.out.println(in.nextLine());
			System.out.println(in.nextLine());
		}
		catch (IOException e) {e.printStackTrace();}
	}
	public static void main(String[] args) throws IOException {
			Client client;
			client = new Client();
			
			client.run();
			
	}


}
