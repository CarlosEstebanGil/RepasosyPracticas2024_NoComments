package Repaso2024;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * WILDCARDS AND LIMITS -> BOUNDED -> UPPER BOUNDED (EXTENDS)  OR LOWER BOUNDED (SUPER)
 * 		-->  extends =  de ahi xa abajo simil herencia x eso es limite superior
 * 		-->  super	 =  de ahi xa arriba ej (T super Integer) es integer, Number, Object,pero solo en la misma rama -->  
 * 							 --> x eso No Double! osea No otro tipo que ya divergió x otra rama (no compat) !!
 *Obs: los limites son siempre inclusivos.
 *
 * 		Mnemo: super xa adds o removes a estructuras. pero para recorrerlas ordenarlas imprimirlas etc extends gralmente 
 * 		Mnemo: xa un carro de compras se puede usar super xq se usan muchos adds y removes 
 * 
 *  	En resumen, si necesitas flexibilidad para añadir nuevos elementos de cualquier subtipo de T, puedes utilizar lower bounded 
 *  	wildcards (<? super T>). Si solo necesitas leer elementos de la colección y no necesitas añadir nuevos elementos, puedes utilizar 
 *  	upper bounded wildcards (<? extends T>). Sin embargo, si necesitas tanto leer como añadir elementos, es posible que necesites 
 *  	reconsiderar el diseño de tu aplicación para determinar qué enfoque es el más adecuado en cada caso.
 */
public class Generics2_old {

	public static void main(String[] args) {
		
		// UPPER BOUNDED ( EXTENDS )  " de ahi xa abajo " xa lecturas, recorridos (acceder) "ESE O CUALQUIERA XA ABAJO cualquier RAMA"
		// -------------
		
		// Permite que la clase genérica acepte cualquier tipo que sea una subclase de T (incluida)
		// Esto restringe la capacidad de añadir elementos a la colección, ya que el compilador no puede garantizar la coherencia de 
		//		los tipos. Sin embargo, permite mayor flexibilidad en el uso de la clase.
		// Extends entonces  es útil cuando solo necesitas leer elementos de la colección y no necesitas añadir nuevos elementos.  
		
		// La clave: Por ejemplo, si tienes una lista de objetos Number y solo necesitas leer los elementos para realizar operaciones 
		//aritméticas, puedes utilizar <? extends Number> para permitir que la lista contenga cualquier subtipo de Number ( x ej 
		//  Integer, Double, etc.). 
		// Sin embargo, no puedes añadir elementos a una colección con un tipo <? extends T> porque no puedes garantizar el tipo 
		// específico que se espera. 
		
		// OSEA EXTENDS NUMBER TODO BIEN PERO EXTENDS T ( GENERIC) YA NO ME GARANTIZA NADA PARA ADDS PORQUE NO SE QUE TIPO ES T
		
		// EJEMPLIFICADO: SI APUNTO CON UNA LIST EXTENDS T QUE DECLARO COMO EXTENDS NUMBER Y APUNTO A OSEA LE ASIGNO LA IMPLEMENTACION
		//		CONCRETA DE LINKEDLIST X E EJ PERO DEFINIDA COMO NEW LIST<INTEGER> CONCRETA OSEA UNA LISTA DE ENTEROS
		//		ENTONCES SI QUIERO AGREGAR UN ENTERO A LA LISTA ME DICE EEROR YA EL IDE (ERR DE COMPI) Y EL MOTIVO ES:
		//  		Cuando intentamos añadir un elemento (10) a la lista utilizando el método add, obtenemos un error de compilación. 
		//			Esto se debe a que, aunque la lista es una lista de enteros, la referencia de tipo List<? extends Number> no 
		//			especifica el tipo exacto que se espera. Puede ser una lista de cualquier subtipo de Number, como Integer, Double,
		//			Float, etc. Osea: ejemplo:
		
		//			List<? extends Number> lista = new ArrayList<Integer>(); // Lista de enteros
        //			lista.add(10); // Error de compilación
		
		//			ENTONCES se produce una incertidumbre: el compilador no puede garantizar que añadir un entero (Integer) a la lista 
		//			sea seguro en todos los casos.

		//			ANALISIS POSTA BY ME ( aca entendí todo ) :
		
		//			Pensar la sentencia List<? extends Number> como un argumento en un metodo mio q quiero hacer generico upperbounded
		//			entonces imagino que se refiere a que si yo le paso una imple de lista o una ref de lista que cumpla con esa 
		//			definicion por ejemplo una lista concreta de doubles. luego dentro del metodo cuando quiere hacerle un add de 
		//			un entero a una lista de doubles) me daria error (en t. de ejecucion) xq en tiempo de compi pasaria. ent directa-
		//			mente diseñaron al compilador java para que del vamos ni me lo permita desde ya el tiempo de compi osea de desarrollo
		//			xa q no se de en runtime. me dice es xa cagadas, no es consistente, no puedo saber si cumple en realidad lo de t.compi
		//			en t.ejecucion y eso no es consistente x eso directamente no te lo permito ( te aviso con error en t.de diseño)
		
		//			 Por lo tanto, el compilador evita que añadamos elementos a una lista con un tipo <? extends T> para garantizar 
		//					la seguridad del tipo.
		
		// LOWER BOUNDED ( SUPER )  " de ahi xa ARRIBA " xa adds, y removes (modifs) "ESE O CUALQUIERA XA ARRIBA SOLO X ESA RAMA !!!!"
		// -------------
		// Permite añadir elementos a la colección de manera segura, ya que cualquier tipo que sea un supertipo de T puede ser añadido.
		// Sin embargo, la flexibilidad en el uso de la clase puede ser limitada o compleja. 

		// Ejemplo sencillo q ilustra por qué la lectura de elementos de una colección con un tipo <? super T> puede ser más compleja:
		
		//--
		 	List<? super Integer> lista = new ArrayList<Number>(); // Lista de numbers ( que apunto con lista de algo q puede 
         	lista.add(10); // Añadimos un entero a la lista			//	admitir (as argument) una imple lista de enteros , o  					
         															//	tambien piede admintir una lista de numeros o de objects
         															//	osea de ahi xa arriba (x eso super es lower bounded)
		// 	PERO PARA LA Lectura de elementos de la lista        
			Object obj = lista.get(0); // Solo podemos garantizar que el elemento es de tipo Object (xq como bien digo arriba 
        	System.out.println(obj);  // 	Imprime: 10  												de antemano no puedo saber 
        //-------																						el tipo concreto sino solo 
        							 //																	q si o si es un object
        	// --> ENTONCES --> PUDE AGREGAR BIEN Y LEERLO TMB PERO XA LEERLO TUVE QUE REFERENCIAR CON OBJECT Y ESO ME LIMITA XA 
        	//				AL LEERLO PODER APUNTARLO CON UNA REF + ESPECIFICA Y PODER HACER + COSAS PUNTUALES Q CON UN OBJECT
        	//				( en este caso el syso.println para object pasandole un obj y este tiene toString y el valor es un 
        	//				int ent todo auto y me lo muestra , hasta ahi xa este basico puedo pero xq pertenece a object xq es re 
        	//				basico xa mostrar pero xa hacerle (ejecutarle) cosas especificas ya no puedo , x ej si quisiera obtener 
        	//				de mi obj lista que por ejemplo lo declaro compat con esa definicion x lo que le paso una lista concreta 
        	//				de numbers ( como en este caso) pero pensarlo como argumento de un metodo, entonces luego en mi programa
        	//				quiero leer toda esa lista y cada elem de esa lista (q yo creo q va a ser un integer o un numero xa arriba 
        	//				y quiero ejecutarle por ejemplo algun metodo en comun a todos esos, yo que se, sumar() no puedo xq esa lista 
        	//				en tiempo de compi de diseño funca pero admite siempre super es PARA ARRIBA! HASTA OBJECT!! OSEA Q PUEDE CONTENER
        	//				OBJECTS y esos no son numeros ni tienen el metodo suma. osea, en un momento del "para arriba" ya ni funciones o 
        	//				conceptos en comun hay sino solo los mas grales como que son un object y yo permito hasta eso q ya me limita 
        	//				cualquier funcionalidad especial. a menos que lo castee xa apuntarlo con algo mas especifico y que 
        	//				le ejecute el sumar, pero ahi ya obtengo error en t. de compi / diseño porque el compi me avisa que 
        	//				ese cast no es consistente xq esa def lowerbound con super admite hasta objects q nada q ver con castear a
        	//				otra cosa que yo intente, osea con super solo object! por eso me limita xa usarlo!! PEEEEEEEEEEEROOOOO 
        	//				PARA ADD Y REMOVES al contrario, me da mas flexibilidad , aqui un ejemplo y luego la explicacion

        	//		CARRITO DE COMPRAS
        	//		__________________

        	//		En el caso de un carrito de compras, donde comúnmente se necesitan añadir y eliminar elementos, un bounded 
        	//		wildcard con super sería más adecuado.
        	
        	class CarritoDeCompras<T> {//public class CarritoDeCompras<T> {  //CARRITO DE COMPRAS DE LO QUE SEA! (<T>)
        	    								// LA POSTA BY ME!!!!!!!!!!!!!!! 
        		private List<? super T> items; 	//   pero la lista posta de mis elems la permito de tipo compat con T xa arriba  
        										//  (misma rama) (hasta object) .SABER! -> si super integer ent obj ok pero double NO!
        										//	 eso ya me permite establecer un control sobre lo que quiero agregar o quitar (contener) 
        										//	 OSEA,AL CTRL DE LO Q VA A TENER es lo rel con adds y removes q son los 
        										//	 responsables del contenido!!!
        	    public CarritoDeCompras() {
        	        this.items = new ArrayList<>();
        	    }

        	    public void addItem(T item) { 	// los add y remove todo bien xq me añaden un tipo cualquiera t (el ppal de la clase)
        	        items.add(item);			// y mi def de lista siempre incluye a ese t
        	    }

        	    public void removeItem(T item) {  //PARA ENTENDERLO PENSARLO COMO UN CASO CONCRETO EJ UN CARRITO DE MANZANAS verdes
        	        items.remove(item);			  //ent admito q se guarden manzanas verdes xa arriba , manzanas, frutas, .. objects  	
        	    }								  // mis add solo agregan T  osea manzanas verdes xq el carrito es de manzanas verdes
        	    								  // luego otro usuario de mi api carrito puede usar el api xa hacerse un carrito de 
        	    								  // remeras , etc . de ahi que el carrito es <T> osea de cualquier cosa!
        	    								  // PERO LA COSA ESTA EN LOS LIMITES (BOUNDS) EN MI atrib lista xa los elems xq yo  
        	    								  // ahi a su vez lo defino generico pero limitado a la misma rama xa arriba (hasta object)
        	    								  // x ej: remera, ropa,  .. object pero no pantalon xq es <T> carrito de remeras x ejemplo
        	    								  // que pasa con mis adds y removes? q agregan solo remeras osea el tipo ppal del carro
        	    								  // xq mi lista interna no la escribo como lista de <T> solamente osea sin limites ??
        	    								  // Esto se debe a que mi ppal es T mis adds agregan T pero mi lista es T compat xa arriba 
        	    								  // ent permitir que un carrito de frutas almacene tipos que son superclases de Fruta, como 
        	    								  // Object, puede parecer contraintuitivo a primera vista, explicacion : 
        	    								  /**
        	    								   * Flexibilidad en la composición: Al permitir que el carrito de frutas almacene 
        	    								   * tipos que son superclases de Fruta, como Object, estás proporcionando flexibilidad en 
        	    								   * la composición de tu sistema. Esto significa que puedes diseñar componentes genéricos 
        	    								   * que trabajen con cualquier tipo de objeto y aún así puedan interactuar con el carrito 
        	    								   * de frutas. Por ejemplo, podrías tener un método genérico que procese todos los elementos 
        	    								   * de un carrito, independientemente de su tipo.

													 Reutilización de código: Al permitir que el carrito de frutas almacene tipos más 
													 generales, como Object, estás reutilizando código existente que puede trabajar 
													 con cualquier tipo de objeto. Esto puede ser útil si tienes componentes genéricos 
													 que ya están diseñados para trabajar con tipos más generales y quieres reutilizarlos 
													 en el contexto de tu carrito de frutas.

													 Interoperabilidad con otros componentes: Al permitir que el carrito de frutas 
													 almacene tipos más generales, como Object, estás facilitando la interoperabilidad 
													 con otros componentes que pueden trabajar con tipos más generales. Por ejemplo, 
													 podrías tener un componente de almacenamiento de datos que puede manejar cualquier 
													 tipo de objeto y aún así pueda interactuar con el carrito de frutas.

													 En resumen, permitir que un carrito de frutas almacene tipos que son superclases de 
													 Fruta puede proporcionar flexibilidad, reutilización de código y interoperabilidad 
													 con otros componentes. Si bien puede parecer poco intuitivo al principio, esta 
													 flexibilidad puede ser beneficiosa en ciertos escenarios de diseño de software donde 
													 se requiere una mayor generalización y reutilización de código. Sin embargo, es 
													 importante evaluar cuidadosamente si esta flexibilidad es necesaria en el contexto 
													 específico de tu aplicación antes de implementarla.
													 
													  LA POSTA: CON ESTE EJEMPLO SE ENTIENDE TODO! :
													  Supongamos que tienes un componente genérico llamado ProcesadorElementos que 
													  tiene la capacidad de procesar una lista de elementos de cualquier tipo. 
													  Este componente podría ser útil para realizar diversas operaciones, como 
													  imprimir los elementos, calcular estadísticas sobre ellos, o realizar cualquier 
													  otra acción que no dependa del tipo específico de los elementos.
													  
													  Ahora, supongamos que deseas utilizar este ProcesadorElementos para imprimir 
													  los elementos contenidos en un carrito de frutas. Como el carrito de frutas 
													  acepta cualquier tipo que sea una superclase de Fruta, puedes utilizar el 
													  ProcesadorElementos sin problemas, ya que este método puede manejar cualquier 
													  tipo de objeto:
													  
													  En este ejemplo, el método procesarElementos del ProcesadorElementos recibe una 
													  lista de elementos de tipo ?, lo que significa que puede manejar cualquier tipo 
													  de objeto. Por lo tanto, puedes pasarle la lista del carrito de frutas sin problemas, 
													  ya que esta lista puede contener cualquier tipo que sea una superclase de Fruta.

													  Así, utilizando componentes genéricos como el ProcesadorElementos, puedes 
													  diseñar funcionalidades que no dependen del tipo específico de los elementos y 
													  aún así puedan interactuar con el carrito de frutas u otras estructuras que 
													  permitan tipos más generales. Esto proporciona una mayor flexibilidad y 
													  reutilización de código en tu aplicación.
													  
													  CharlySan:
													  
													  pero y si la lista del carrito de frutas estuviera definida solo como lista<T> 
													  explicame porque no podria pasarsela al procesador de frutas generico ? no es 
													  que dicho procesador procesa de todo independientemente del tipo de datos en la 
													  lista? 

													  ChatGPT35:
													  
													  Tienes razón en que el ProcesadorElementos procesa de todo independientemente 
													  del tipo de datos en la lista. Sin embargo, hay una diferencia clave en cómo se 
													  declaran las listas en el contexto de la genérica y cómo se espera que funcione 
													  la generificación en Java.

													  Cuando declaras una lista como List<T>, estás especificando que esa lista puede 
													  contener solo elementos del tipo T o de sus subtipos. Por lo tanto, si intentas 
													  pasar una lista de tipo List<Fruta> a un método que espera List<?>, podría 
													  generar un error de compilación.

													  Esto se debe a que la lista List<Fruta> es más específica que List<?>. La lista 
													  List<Fruta> solo puede contener frutas y subtipos de frutas, mientras que 
													  List<?> puede contener cualquier tipo de objeto. Java no permite pasar una lista 
													  más específica (List<Fruta>) a un método que espera una lista menos específica 
													  (List<?>) debido a problemas de seguridad de tipos. Esto garantiza la seguridad 
													  de tipos en tiempo de compilación.

													  Sin embargo, puedes hacer que el ProcesadorElementos sea más flexible para 
													  aceptar cualquier tipo de lista, incluida List<Fruta>, utilizando un 
													  upper bounded wildcard List<? extends Object> en lugar de List<?>. Así, el método 
													  procesarElementos aún puede manejar cualquier tipo de objeto, pero también puede 
													  aceptar listas más específicas sin generar un error de compilación.
													  
													  Con esta modificación, podrías pasarle una lista de tipo List<Fruta> al método 
													  procesarElementos sin problemas. La modificación permite que el método maneje 
													  tanto listas más generales como listas más específicas, proporcionando mayor 
													  flexibilidad en el diseño y uso de componentes genéricos en Java.
													  
													  LA CLAVE ESTA EN PENSAR EN LOS METODOS 
													  (ARGS Y PÀRAMS , refs a clases/contenedores/wrappers/etc) !!!!!!!!!!!!!!!!!!!!
													  
													  ahi es donde algo generico de algun api puede seguir trabajando con mi coleccion wrappeada carro
													  osea un api procesador de cualquier tipo de colecciones o bolsas, q recibe en sus args todo 
													  generico ej object xq es indep del tipo de obj, ej para estadisticas , imprimirlos, etc 
													  ahi si le paso un api que ... 
													  
													  |__>... LO CORTO ACá rehago todo en Generics2_new-LaPosta.java xq ahi !!!!!!!!!!!!!!!!!!!!!!!!! 
													  es donde recien se entiende como trabaja java con generics y wildcards (+ alla del porque) 
													  	
        	    								   */
        	    
        	    public void recorrerCarrito() {  // pero xa leer ya no si pusieron el t o uno superior al t osea si me pasan una li
        	        Iterator<? super T> iterator = items.iterator();
        	        while (iterator.hasNext()) {
        	            T item = (T) iterator.next(); // Se requiere un cast
        	            System.out.println(item);
        	        }
        	    }

        	    // Otros métodos que puedas necesitar...
        	}
        	
        	/**	En este ejemplo, List<? super T> indica que la lista puede contener elementos de cualquier tipo que sea un supertipo 
        	 *  de T, lo que permite añadir elementos de tipo T o cualquier subtipo de T de manera segura. Los métodos addItem y 
        	 *  removeItem utilizan el tipo T directamente, mientras que recorrerCarrito utiliza un tipo wildcard para iterar sobre 
        	 *  los elementos de la lista de forma segura.
 			 *
			 *  Es importante tener en cuenta que, al utilizar un bounded wildcard con super, se requiere un casting al recuperar 
			 *	elementos de la lista, ya que la lista puede contener tipos superiores a T. Esto puede introducir un riesgo de 
			 *	ClassCastException si la lista no está gestionada adecuadamente, por lo que se debe tener cuidado al utilizar este 
			 *	enfoque.
        	 */
        	
        	//
        	
    	//		ANALISIS POSTA BY ME ( aca entendí todo ) :
        	
		//		Pensar la sentencia List<? super Integer> como un argumento de un metodo mio q quiero hacer lowerbounded (super)
        //		ent si yo le paso una imple concreta lista de Number , el add me lo deja porque el compi ya sabe que mi declaracion
        //		List<? super Integer> sea lo que sea ? va a ser de la rama de los enteros osea va a ser un entero sin desviaciones
        	
		// UNBOUNDED ( ? )  " EL TIPO EXACTO QUE TU QUIERAS , EL QUE QUIERAS " 
		// -------------
		// Permite que la clase genérica acepte cualquier tipo. Esto proporciona la máxima flexibilidad, pero también puede conducir a 
		// problemas de tipo si no se tiene cuidado.
		
		
		
	}

}
