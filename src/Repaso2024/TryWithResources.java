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
		    
		} catch (FileNotFoundException | ArithmeticException excepcionesparticulares) { 
																						

			System.out.println(excepcionesparticulares instanceof FileNotFoundException? "FileNotFoundException":"ArithmeticException"); 
																											 
				
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
