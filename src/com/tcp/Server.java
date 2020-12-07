package com.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	Server() throws IOException{
		ServerSocket serverSocket = new ServerSocket(2020);
		System.out.println("Port 2020 is open");
		
		Socket socket = serverSocket.accept();
		System.out.println("Client "+ socket.getInetAddress()+" has connected");
		
		// I/O buffers
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true); //make it false

		out_socket.println("Welcome to server");
		String message = in_socket.readLine();
		System.out.println("Client says"+message);
		
		serverSocket.close();
		System.out.println("Server socket closed");
		socket.close();
		System.out.println("Socket closed");
	}
	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
