package Repaso2024;


public class ConversionesBasicasDeTiposDeDatos {

	public static void main(String[] args) {

		ConversionesBasicasDeTiposDeDatos app = new ConversionesBasicasDeTiposDeDatos();
		app.conversionesTipos();
	}

	/**
	 * @author Carlos Esteban Gil @date Feb 20, 2024 @version 1.0
	 * @description: Implementacion de <>s Conversiones sobre <>s tipos de datos
	 * @param
	 * @return
	 * @throws ExcepcionTipo Descripción de la exception 
	 * 		
	 * 		Observaciones / things to improve:
	 */
	public void conversionesTipos() {
		
		int i=147; Integer iNum = Integer.valueOf(2000); String strName = "Charly"; char[] cArrName= {'c','a','r'}; char caracter;
		
		
			String stri= String.valueOf(i);
			
		
			Integer IntStr = Integer.parseInt("123");
			
		
			Integer inti= Integer.valueOf(1);
			
		
			int iInt = inti.intValue();
			
		
			String strCharArr = String.valueOf(cArrName); 
			
		
			char[] cArrStr = strCharArr.toCharArray(); 
		
			
			caracter= (char)(999);
			
			
			caracter = 999; 
							
			int icaracter = (int)caracter;  
							
			char caracterNoNumerico = 999; 
			
		System.out.println 	("stri:" + stri + " " + "intStr:" + IntStr + " " + "inti:" + inti + " \n"  
								 + "strCharArr:" + strCharArr + " \n" 
								 + "cArrStr:" + String.valueOf(cArrStr) + " \n" 
								 + "caracter:" + caracter + " \n"	  
								 									 		   
								 + "icaracter:" + icaracter + " \n"  
								 + "valor de un caracter no numerico:" + caracterNoNumerico 
								 );   

				char caracternumerico2 = 2; 
 
				int iNumer=1; 
				char caracternumerico3 = (char)iNumer; 
		System.out.println("\n " + "caracternumerico2:" +(int)caracternumerico2 + " \n caracterNumerico3:" + (int)caracternumerico3 );
		
	}
	
}
