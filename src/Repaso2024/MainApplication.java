package Repaso2024;

import java.util.function.Function;

public class MainApplication {

		
		//A) atrib function apunta auna imple lmbda de formato compat
		private Function<String,String> convertirMayusculas = s -> s.toUpperCase(); 

		//B) metodo q recibe como param una fdunction osea una imple en formato api function y la usa ( le hace el apply )
		public static void imprimir(Function<String,String> funcion, String valor) 	{ // Que mi Api va a recibir una 
																	// implementacion (una Funtion nn) y le voy a hacer el
			System.out.println(funcion.apply(valor)) ; 				// a algun valor o valores o ej mi fmk.execute() pero  
		}															// esta es parte del api y la + standard.
		
		//C) metodo que devuelve una function ( un esquema lamda, con variables en esta , xa ser ejecutado en otro lado con apply ,
		//permitiendo recibir y aplicar la funcion a un parametro
		
		 private Function<String,String> concatenarMensajito (String mensaje) {
				return (String x) ->  mensaje + x;				// devuelve x + una kte q es el param q recibe
			}
		
		public static void main(String[] args) {
			
			//Ejs Usos:
			MainApplication app = new MainApplication(); 
			
			//A)
				String str= app.convertirMayusculas.apply("charly");
				
				System.out.println(str);

				
			//B) 
				app.imprimir(app.convertirMayusculas, "san");
				
			//C)
				String str2 = app.concatenarMensajito("Buen dia ").apply("Carlitos");
				System.out.println(str2);
				
		}


}
