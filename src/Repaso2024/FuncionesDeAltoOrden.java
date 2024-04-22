package Repaso2024;

import java.util.function.Function;

public class FuncionesDeAltoOrden {

		
		private Function<String,String> convertirMayusculas = s -> s.toUpperCase(); 

		public static void imprimir(Function<String,String> funcion, String valor) 	{ 
																	
			System.out.println(funcion.apply(valor)) ; 				
		}															
		
		
		 private Function<String,String> concatenarMensajito (String mensaje) {
				return (String x) ->  mensaje + x;				
			}
		
		public static void main(String[] args) {
			
			
			FuncionesDeAltoOrden app = new FuncionesDeAltoOrden(); 
			

				String str= app.convertirMayusculas.apply("charly");
				
				System.out.println(str);


				app.imprimir(app.convertirMayusculas, "san");
				

				String str2 = app.concatenarMensajito("Buen dia ").apply("Carlitos");
				System.out.println(str2);
				
		}


}
