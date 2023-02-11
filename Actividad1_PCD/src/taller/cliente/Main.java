package taller.cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try (Socket socket = new Socket("localhost", 5500)) {
			
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            Scanner scanner = new Scanner(System.in);
            
            String userInput;
            String response;
            String clientName = "empty";
            
            response = input.readLine();
            System.out.println(response);

            do {
                
                if (clientName.equals("empty")) {
                     userInput = scanner.nextLine();
                     clientName = userInput;  
                     output.println(userInput);
                     response = input.readLine();
                     System.out.println(response);
                } 
                else {
                     //String message = ( "(" + clientName + ")" + " message : " );
                     System.out.println("Selecciona un numero");
                     userInput = scanner.nextLine();
                     if (userInput.equals("exit") || userInput.equals("salir") || userInput.equals("5")) {
                         output.println(userInput);
                         input.close();
                         scanner.close();
     					 System.out.println("Hasta pronto");
                         break;
                     }else if (userInput.equals("1")){
                    	 System.out.println("La sede principal de la Universidad Europea se encuentra en Villaviciosa de Odon, Madrid");
                         output.println(" " + userInput);
                     }else if (userInput.equals("2")){
                    	 System.out.println("Para ponerse en contacto con la Universidad Europea, llame al: 911239923");
                         output.println(" " + userInput);
                     }else if (userInput.equals("3")){
                    	 System.out.println("Las sedes de la Universidad Europea son: Villaviciosa de Odon, Alcobendas, Valencia y Tenerife ");
                         output.println(" " + userInput);
                     }else if (userInput.equals("4")){
                    	 System.out.println("La universidad europea tiene un total de 16.000 alumnos");
                         output.println(" " + userInput);
                     }else {
                     
                    	 output.println(" " + userInput);
                     }

                 }

            } while (!userInput.equals("exit") || !userInput.equals("5") || !userInput.equals("salir"));
            
		} catch (Exception e) {
			System.out.println("No hay ningun servidor para atender la conexion");
		}
	}

}
