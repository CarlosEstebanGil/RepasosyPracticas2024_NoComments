package Repaso2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResources {

	public static void main(String[] args) {
		
		try (Scanner scanner2 = new Scanner(new File("test.txt"))) {
		    
		    while (scanner2.hasNext()) {
		        System.out.println(scanner2.nextLine());
		    }
		    
		} catch (FileNotFoundException | ArithmeticException excepcionesparticulares) { //2 en una x lo gral xq se tratan igual   
																							//		o una parte igual
			// trat simple:
			System.out.println(excepcionesparticulares instanceof FileNotFoundException? "FileNotFoundException":"ArithmeticException"); 
																											 
			// ó un switch case si quiero tratar partes diferente con varias acciones 
			
			/* 
				switch (excepcionesparticulares.getClass().getName()) {
					case "FileNotFoundException" :
						throw new RuntimeException(excepcionesparticulares);
						break;
					case "ArithmeticException": 
						throw new RuntimeException(excepcionesparticulares);
						break;	
					
					default:
						throw new IllegalArgumentException("Unexpected value: " + key);
				}*/
				
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
