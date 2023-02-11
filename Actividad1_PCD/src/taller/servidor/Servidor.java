package taller.servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Servidor extends Thread {

	private Socket socket;
	private PrintWriter output;

	public Servidor(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			
			boolean exit = false;
			String outputString;
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(), true);
			output.println("Bienvenido al chatbot de la universidad europea. ¿Cual es su nombre?");
			outputString = input.readLine();
			output.println("Para hablar con el chatbot, indicanos el número de la petición que deseas solicitar: (1)Ubicacion (2)Contacto (3)Sedes (4)Numero de alumnos (5)Salir");
			
			 
					//" - Bienvenido " + outputString +" este servidor  publica todo lo que escribas, si quieres finalizar escribe <<exit>>");
			
		//	while (!exit) {
		//		outputString = input.readLine();
		//		if (outputString.equals("exit")) {
		//			exit = true;
		//			System.out.println("Exit - Se cerro la conexiÃ³n con uno de los clientes: " + socket.getPort());
		//		}else
		//			System.out.println("El cliente envio a publicar esto: " + outputString);

		//	}
			
			while (!exit) {
				outputString = input.readLine();
				if (outputString.equals("5") || outputString.equals("exit") || outputString.equals("salir")) {
					exit = true;
					System.out.println("El cliente " + socket.getPort() + " se ha desconectado");
				}else
					System.out.println("El cliente respondio " + socket.getPort() + outputString);

			}

		} catch (Exception e) {
			System.out.println("Error occured " + e.getStackTrace());
		}
	}

}
