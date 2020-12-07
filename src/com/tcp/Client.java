package com.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	Client() throws  Exception{
		Socket socket = new Socket("localhost", 2020);
		System.out.println("Successful connection to the server");
		
		// IO Streams
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true); //try making it false
		
		String message = in_socket.readLine();
		System.out.println("server says"+ message);
		out_socket.println("Thanks!");
		
		socket.close();
	}
	
	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
