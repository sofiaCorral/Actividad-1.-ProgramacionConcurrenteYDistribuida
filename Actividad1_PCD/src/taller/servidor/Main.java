package taller.servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {

		try (ServerSocket serversocket = new ServerSocket(5500)){
			
            System.out.println("Servidor encendido");

            while(true) {
            	
            	Socket socket = serversocket.accept();
            	
                System.out.println("Nueva conexion con cliente iniciada: " + socket.getPort());
                Servidor serverThread = new Servidor(socket);
                serverThread.start();
            
            }
            
        } catch (Exception e) {
        	
            System.out.println("Error iniciando el servidor");
            
        }

	}

}
