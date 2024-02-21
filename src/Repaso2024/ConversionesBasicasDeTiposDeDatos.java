package Repaso2024;

/*//---------------------------------------------BLOCK COMMENTED----------------------------------------------------------------------

//obs quitarle el block comment a todo esto junto de una y luego ahi me queda para copiar al crear x 1era vez los templates, luego 
//		volverle a poner un block comment a todo esto ( xq sino los public method q no son comemnts , aislados, fuera del main y  
//		no siendo static, tiran error . por eso un add block comment a todo junto ( los comments qdan recomentados pero no pasa nada )

// Obs recordar: menu window -> preferences -> java -> editor -> templates -> new -> ABC -> pegar esto

*/	/**
	 * @author Carlos Esteban Gil @date Feb 20, 2024 @version 1.0
	 * @description: Implementacion de <>s Conversiones sobre <>s tipos de datos
	 * @param
	 * @return
	 * @throws ExcepcionTipo Descripción de la exception 
	 * 		
	 * 		Observaciones / things to improve:
	 */
/*
  
  public void methodNameHere() {
  
  TDD ( - to + . by main goal. first common-case then <>s input )
 
  Analisis / Objetivo -->
 
  Curso normal eventos (Caso Standard)
  
  Entrada: in: Salida: out: Proceso / PseudoCode: alg:
  
  
  //a) in:
  
  //b) alg:
  
  //c) out:
  
  Curso alternativo ( casos adicionales a contemplar) -----------------
  Entrada2: in: Salida2: out: EntradaN: in: SalidaN: out:
  
  }
 

// y luego idem pero para la version mas corta llamandola abc ( y recordar, en mi codigo escribo abc + ctrl space y me lo pega

// seria pegar esto:

*//**
	 * @author Carlos Esteban Gil @date Feb 20, 2024 @version 1.0
	 * @description: Implementacion de <>s Conversiones sobre <>s tipos de datos
	 * @param
	 * @return
	 * @throws ExcepcionTipo Descripción de la exception Observaciones / things to
	 *                       improve:
	 *//*
		 * 
		 * public void methodNameHere() {
		 * 
		 * } //
		 * -----------------------------------------------------------------------------
		 * ------------------------------------------------
		 */

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
		
		// int a string
		
			String stri= String.valueOf(i);
			
		// string a int
		
			Integer IntStr = Integer.parseInt("123");
			
		// int a integer
		
			Integer inti= Integer.valueOf(1);
			
		// integer a int
		
			int iInt = inti.intValue();
			
		// char array to String 
		
			String strCharArr = String.valueOf(cArrName); // cArrName.toString(); ERROR -> me da el obj !!
			
		// String to char Array
		
			char[] cArrStr = strCharArr.toCharArray(); //ERROR -> me da el obj !! strName.toCharArray();
		
		// int a char:	//xa obtener el valor int de un char q contiene el ascii de un entero ent alcanza c/solo cast a int el char  
			
			caracter= (char)(999);
			
			//ó directamente mas facil:
			
			caracter = 999; //que es lo mismo  // saber: 1 car guarda el ascii q es la representacion del nro , admite hasta 65k aprox 
												// x lo que al excederme con 999 ya q solo esos 65k representan 
		// char a int : (*)
			 
			int icaracter = (int)caracter;  
										    // Todos los ejemplos comentados son ejs de que podria o no podria asinarle: 65534; = ok  
			char caracterNoNumerico = 999; // 65535 = err ,1200000 = err ; estos 2 ults exceden el rango de 0 a 65535 xa un char 
			
		System.out.println 	("stri:" + stri + " " + "intStr:" + IntStr + " " + "inti:" + inti + " \n"  
								 + "strCharArr:" + strCharArr + " \n" 
								 + "cArrStr:" + String.valueOf(cArrStr) + " \n" 
								 + "caracter:" + caracter + " \n"	 // ->	Explicaciones en **  
								 									 //		   
								 + "icaracter:" + icaracter + " \n"  //
								 + "valor de un caracter no numerico:" + caracterNoNumerico // explicacion: en: (**)
								 );   
			// Saber: 
				char caracternumerico2 = 2; //funciona, 
			//pero:
				int iNumer=1; 
				char caracternumerico3 = (char)iNumer; // no funciona xq necesita un numero q a lo sumo guarda su representacion unicode auto    	
												 // pero si le paso un int definido como int ent no hace esa conversion auto,  
												 // x eso debo castear a (char) iNum
		System.out.println("\n " + "caracternumerico2:" +(int)caracternumerico2 + " \n caracterNumerico3:" + (int)caracternumerico3 );
		// |__> MNEMO: ( la explicacion del xq se encuentra mas abajo )
		//		
		//	|_> COMO NMENO SABER QUE SI IMPRIMO UN CHAR NUMERICO ME IMPRIME EL UNICODE X ESO DEBO CAST A INT PERO SI
		//		EL CHAR ES ALFANUMERICO (NO NUMERICO) ENTONCES NO HACE FALTA CAR XQ AUTO ME IMPRIME LA REPRESENTACION Y NO SU UNICODE			
			
		// Saber tmb: el syso requiere explicitamente convertir un carr a str xapoder imprimirlo. NO imprime char arrays de una.  
		
			// chars en java: 
			//	____________
		
			//	si tengo un caracter conteniendo el caracter 'b' que me guarda, el codigo ascii del mismo? 
		
			//		Sí, en Java, cuando se almacena un carácter en una variable de tipo char, en realidad se está almacenando su 
			//		valor Unicode, que es un valor entero que representa el código del carácter según el estándar Unicode. El código 
			//		ASCII es un subconjunto del estándar Unicode para los primeros 128 caracteres.

			//		Por lo tanto, si tienes un carácter 'b' en una variable de tipo char, puedes obtener su valor numérico (el código 
			//		Unicode) usando la conversión de tipo o simplemente leyendo el valor de la variable. 

			// 		Es importante recordar que aunque se use el término "código ASCII", en realidad se está haciendo referencia al 
			//		valor Unicode del carácter en este caso.
		
		
			//	Si quiero imprimir la letra b osea su valor no ascii sino lo que quiero que muestre ya convertido ese ascii a 
			//			caracter y asi imprimir el valor 'b' en pantalla?
			
			//	Si quieres imprimir el carácter 'b' en lugar de su valor ASCII, simplemente puedes imprimir la variable caracter directamente. 
			//		char caracter = 'b';	
			//		System.out.println("El carácter es: " + caracter);

			//	Yo pensé que char permitia guardar 1 solo caracter, no sabia que podia guardar la representacion de mas digitos 
			//		por ejemplo 999 que contiene 3 digitos
		
			//		Entiendo tu confusión. En Java, el tipo de datos char se utiliza para representar caracteres individuales Unicode. Aunque comúnmente se asocia con la representación de un solo carácter, técnicamente, el tipo char es un tipo de dato de 16 bits sin signo que puede contener valores numéricos del rango de 0 a 65535, lo que equivale al rango de los valores Unicode de 16 bits.

			//		Por lo tanto, cuando asignas un valor numérico a una variable de tipo char, Java lo interpretará como el valor 
			//		Unicode correspondiente al carácter almacenado en ese valor. Por ejemplo, asignar el valor 999 a una variable de 
			//		tipo char no significa que estés almacenando el valor numérico 999, sino que Java interpretará este valor como el 
			//		carácter Unicode correspondiente al código 999.

			//		Es importante tener en cuenta esta interpretación al trabajar con variables de tipo char en Java. Aunque pueden 
			//		contener valores numéricos, la interpretación de esos valores depende del contexto y del sistema de codificación 
			//		de caracteres utilizado.

			// **EXPLICACION TEORICA:
			//	 ___________________
		
			// 	  En Java, se imprime una var de tipo char, el sistema auto convierte el valor del char al equivalente en su 
			//    representación textual. No es una conversión de tipo en el sentido tradicional (como la conversión explícita que 
			//	  se realiza al hacer (int)), sino más bien una presentación de los datos en un formato legible.

			//    En Java, cuando asignas un valor numérico fuera del rango permitido para un tipo de datos determinado, se produce 
			//	  una pérdida de precisión y puede ocurrir truncamiento de los bits más significativos. 
		
			//	  En mi caso: 999 es de hecho menor que 65535 y debería estar dentro del rango de un char en Java
			//		el tema es que al asignar a una var  char = 999 ; a secas, estoy asignando el valor unicode xa 999 , q es el simbolo ϧ
			//		en muchos sistemas de codificación de caracteres, el código Unicode 999 está asociado con el carácter griego "ϧ" 
		
			//		Lo que sucede entonces es que cuando asignas un valor numérico a una variable de tipo char en Java, Java 
			//		interpreta ese valor numérico como el código Unicode correspondiente al carácter almacenado en ese valor. 
			//		Por lo tanto, si asignas el valor 999 a una variable de tipo char, Java interpreta este valor como el carácter 
			//		Unicode correspondiente al código 999.

			//		Sin embargo, cuando realizas una conversión explícita de tipo (int) en esa variable char, estás convirtiendo el 
			//		valor Unicode del carácter almacenado de nuevo a su valor numérico original. Por eso obtienes el valor 999 
			//		cuando imprimes el resultado después de la conversión explícita.
		
			//		
			//    Osea Cuando imprimes cnum por consola, se imprime el valor Unicode correspondiente al char q tiene el cod ASCII 
			//	  igual al valor almacenado en cnum. Dado que el valor almacenado en cnum es negativo, el carácter correspondiente 
			//	  podría no ser imprimible o podría representar algún carácter especial o no imprimible según la codificación de 
			//	  caracteres utilizada.

			//	  Por otro lado, cuando realizas una conversión explícita de char a int, obtienes el valor original que asignaste, 
			//	  que es 999. Esto se debe a que estás convirtiendo el valor Unicode del carácter almacenado en cnum al tipo int, 
			//	  conservando así la precisión completa del valor original.
			
			
			// 		y si quisiera imprimir por consola el codigo ascii osea el valor ascii que es 65 para el caracter 'A' como 
			//		deberia hacer? 
		
			//			Para imprimir el valor ASCII de un carácter en Java, puedes realizar una conversión explícita del tipo char 
			//			al tipo int. Esto te permitirá obtener el valor numérico del carácter, que corresponde al código ASCII en el 
			//			caso de los caracteres ASCII estándar. ej:
		
			//			char c = 'A';
			//			int asciiValue = (int) c;
			//			System.out.println("El código ASCII de '" + c + "' es: " + asciiValue);

			// 		
		
	}
	
}
