package Repaso2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// ESTE FILE 2024 CONTIENE LA POSTA DE LA BASE DE WILDCARDS. LUEGO EN WILDCARDS SE VE MAS EN DETALLE TEORICO Y MAS EJEMPLOS.(FEB 2024)

// LA POSTA DE GENERICS ES X EJ EL API COLLECTION DE JAVA , LIST<T> ETC . DEFINEN ASI XA Q SIRVA XA CUALQUIER COSA OSEA COMO 
// 		CONTENEDOR! DE CUALQUIER TIPO! PERO CONCRETO . Q LO DEFINAS Y ESA INSTANCIA SERá DE ESE TIPO CONCRETO. SIN HERENCIA SIN NADA
//		SINO CONCRETO. EN ESTE TIPO DE APIS ES MEJOR USAR T Q WILDCARDS CON RANGO YA QUE JUSTAMENTE QUIEREN Y APUNTAN A QUE VOS 
//		TENGAS Q ESPECIFICAR 1 TIPO CONCRETO CUALQUIERA PERO 1 ESPECIFICO POR INSTANCIA (X CONTENEDOR CONCRETO QUE USES)
//		TOTAL ADENTRO ESTAS CLASES ITERAN ELEMS SIN IMPORTAR EL TIPO OSEA OBJECTS OSEA SON TODAS OPS DE CONTENEDOR/COLECCION/BOLSA
//		Y NO APUNTAN AL NEGOCIO U OTRA COSA SINO A SOLO DARTE ESA FUNCIONALIDAD Y Q DEFINAS CONCRETO C/ CONTENEDOR Q USES , ONDA
//		"YO TE SIRVO XA TODO" PERO 1 TIPO SIEMPRE X INSTANCIA CONTENEDOR OBJETO CONCRETO ASI VOS USAS DE ESA MANERA Q ES LO MAS COMUN
//		EJ LISTA DE STRINGS, LISTA DE INTEGERS ETC. ( luego si tu negocio ej un carro contenedor de productos quiere usar wildcards
//		tipo carro<T> LISTAiNTERNA de elems SUPER T , y q ganes lo q necesites en el propio api del entorno (reuso, polimorfo,flex,etc)
//		eso ya es otra cosa. ( asi q por eso se usan los generics normales concretos <T> (k,v,u x etc) y ademas por lo siguiente 
//		si yo quiero un contenedor de cosas generico xa operar sobre estas sin importarme el tipo, entonces que mejor que hacer  1
//		generic, q sirve xa todo tipo, pero q te obligue a definir un tipo concreto x uso ( x instancia) x obj contenedor_x concreto 
//		si lo hicieran con ? ya aceptaria de todo siempre xa cada instancia y en estos apis de java (colls etc) no se busca eso sino  
//      qsean generic indep del tipo su func gen y ent qsirvan xa todo sin restriccion (T) pero x /c/inst definas 1tipo especifico !!

			// ^__ ESTA ES LA POSTA DE TODO !!! ver generics1.java ejemplos ytube "mito" y ej motos ytube "hello world java" etc !!!!  
/**
 * EN ESTA CLASE POR FIN VOY A EXPLICAR POSTA GENERICS Y WILDCARDS 
 * 	( q son 2 cosas <>s pero ligadas , osea wildcards es una extension de generics que permite otras cosas ) 
 */
public class Generics2_new {

		// LA CLAVE ES PENSAR QUE GENERICS O WILDCARDS , estan pensados para desarrollar api generico , reusable,
		//	generics me permite un poco eso y a su vez me obliga a definir un tipo concreto al usarlo como usuario del api 
		//	esto obliga a definir el tipo concreto del generic class al usarlo y luego ya no es necesario siempre un 
		//	cast a object como se hacia en las viejas epocas. ademas ofrece un control de que nadie pueda ingresar otra cosa 
		//	mas que ese tipo concreto osea usar esa imple del api definida xa ese tipo concreto en el resto del code usar esa 
		//	instancia concreta del api ya con un tipo generico pero con otro tipo.
	
		//	( hasta ahi 3 ventajas de generics. elima cast , ofrece ctrl tipo al usarlo. carencias: el api generico si por 
		//		ejemplo dentro tiene que contemplar cada tipo de objecto si le va a ejecutar un api especifico a cada tipo, salvo 
		//		que ese api generico simplemente sea para tratar lo que guarda como un object. osea me limita al api generico 
		//		en cuanto a ejecutarle mas cosas genericas xq desconozco que tipo T definiran porque no tiene limites y puede 
		//		ser cualquier cosa, entonces lo unico que se es que object es seguro y eso lo compartiran y eso puedo ejecutar,
		//		luego si dentro quiero tratar en forma especial otros tipos tengo que hacer un if x t.getclass y si es x ej int 
		//		puedo por ejemplo en ese bloque if tratarlo distinto porque a los ints los quyiero tratar asi ) y asi xa cada trat 
		//		especial. pero sin if t.class osea asi sin hacer nada solo puedo tratarlos como object y apuntarlos con una ref 
		//		a object y hacerles cosas de object. y si quisiera hacer 3 o4 tratamientos especiales entonces 3 o 4 if y code especial
		//		POR ESTO ES QUE INVENTAN LOS WILDCARDS! me dan mas flexibilidad, por ejemplo yo limito T a ? extends Humano
		//		o ? super Animal. o incluso solo <?> que no es lo mismo que <T> . Bueno estas 3 clases de wildcards, unbound, upper, y 
		//		lower, seran explicadas en la clase wildcards.java. En esta clase generics 2 voy a mostrar el uso mas limitado 
		//		de generics, que igual se usa mucho ej apis con defs <T> o defs <k,v> sin wildcards y ahi no necesitan wildcrds osea
		//		que no siempre se usan wildcards xq a veces no se necesitan pero muchas veces si y ofrecen muchas mas posibilidades
		//		En esta clase dejo un ejemplo de generics, explico bien generics y dejo un ejemplo de donde con generics solo no 
		//		me alcanzaria y ya necesitaria wildcards ( y ahi wildcards, ?, extends (upper), y super (lower) , el uso de c/u, 
		//		como funciona java xa c/u ( fundamental) y recien luego el porque funciona asi como un plus xa saber mas nomas, 
		//		y finalmente ejemplos reales x ej carritos de compras y apis procesadores genericos de colecciones y como se inter-
		//		relacionarian y x eso que convendria si wildcards y que tipo! ( ademas pensarlos siempre como args (refs) (params)
		//		que un API (siempre generico y API cuando hablo de generics o wildcards) osea q va a ser usado como api gen xa el 
		//		code de desarrollo en los sistemas, que sean lo mas reusables posibles, que pueda usar polimorfismo, guardar varias 
		//		coas y no solo un tipo concreto pero teniendo un ctrl de jerarquia (xa abajo o xa arriba) adds/removes c/super y 
		//		listar/acceder con extends, pensar que la clase ppal generic ej carrito puede ser <T> pero luego su lista interna 
		//		puede ser <? super T> y luego voy a explicar q se gana en ese caso , y q sus agregarproducto(T) y quitarproducto(T) 
		//		agreguen solo T pero q le puedo meter polimorfismo porque la lista admite por la flex del wildcard ? super 
		//		etc etc .. todo eso será explicado y con mas ejemplos como el de frutas etc xa ver las motivaciones, funcionamiento,
		//		de los wildcards , la eleccion del tipo de wildcard conveniente en cada caso o si conviene no usarlos o si solo 
		//		conviene unbounded <?> ( que se explica tmb en wILDCARDS.java su diferencia con <T> y tmb cuando no usarlos y solo 
		//		usar generics T,V,K,U , lo que sea sin rangos ( sin wildcards) osea xa tipos concretos definidos x/c/instancia q use
		//		el api generico y q eso alcance. 
		// 		Volviendo a tan solo generics, sin wildcards, arranco con el proposito de este file:
	
		
				/** LA KLA-VE ES SABER ESTO!!
				*	En el sig ejemplo mi proceesador generico de imprimir por pantalla elementos si lo defino como (list<Object> como 
				*	lista es un api implementado con generics<T> ya usa generics y si le digo que mi instancia concreta de lista es de
				*	tipo concreto object entonces generics solo puede recibir object y si le quiero pasar cualquier otra subclase 
				*	o cualquier otra cosa ni me deja el compi porque generics te obliga a un tipo no admite rango osea si es object 
				*	ent espero de tipo object unicamente nada de herencia ahi !! 
				*/

			//ej: main
	
			public static void main(String[] args) {
				
				Generics2_new app = new Generics2_new();
			
				
				List<String> listaString= Arrays.asList("Car","noe","lali","chiqui");
				List<Circulo> listaCirculo= new ArrayList<>();//ArrayList<Generics2_new.Circulo>()
							  //listaCirculo.add(app.new Circulo(2.0));//new Circulo(2.0));
								listaCirculo.add(new Circulo(2.0));
				List<Cuadrado> listaCuadrado=new ArrayList<>();
							   //listaCuadrado.add(app.new Cuadrado(3.0)); listaCuadrado.add(app.new Cuadrado(5.0));
								listaCuadrado.add(new Cuadrado(3.0)); 
				List<Triangulo> listaTriangulo =new ArrayList<>();
								//listaTriangulo.add(app.new Triangulo(10.0)); listaTriangulo.add(app.new Triangulo(20.0));
								listaTriangulo.add(new Triangulo(10.0)); 
				
				//demo pruebas y teoria practica generics wildcards
								
			     //imprimirObjetos(listaString); // no me deja xq espera si o si object xq es lista concreta T Object 				
				 //imprimirObjetos(listaCirculo); // lo mismo.. con c/u.. solo object puro
								
				//...pero... si cambio la def de imprimirobjectos en vez de recibir (apuntar) ref lista<Object> pongo lista<?> :
								//imprimirObjetos(listaString);  //  etc.. me los toma ahora xq espera 
								//imprimirObjetos(listaCirculo); //     lista ? = de cualquier cosa no solo T concreto !!! 
									// comento el de pasarle string xq imprimirObjectos lo modif a ref param lista ? Figura 		
				//con WILDCARDS: 				
				//    ---------
								
				// unbounded
				// ---------				
								// ese ? es el unbounded , acepta de todo no solo object concreto cualquier tipo 
								//	ese wildcard ? unbounded xa java es de solo lectura ( no se puede hacer add a containerss ej 
										//  arraylists, linkedlist etc no se los puede modificar, ni adds ni removes si estan 
										//		definidos (apuntados) recibidos y referenciados asi con unbounded.  
										//			(eso esxq el compi no puede garantizar q si defino una ref asi ent otra con ? 
										//				similar sea de lo mismo osea contenga cosas compatibles osea seria un 
										//				adivinar que es, mal programado conceptualmente, x eso java lo limita de una.
								
				//BOUNDED ( extends y super ) ( se veran con mas detalle teorico , practico y ejemplos en la clase Wildcards.java ) 
				//-------	-------   -----		
								
					// EXTENDS ( upper bounded. de ahi xa abajo todas ramas todo )
					// -------			
								//... que pasa si la lista la recibo como list ? extends

								// pruebo con recibir --> ( imprimirObjetos(List<? extends Figura> lista) )			
								
							/** hecha la prueba ahora los dejo comentados xq voy a hacer la prueba con super )  	
								imprimirObjetos(listaTriangulo); //funca
								imprimirObjetos(listaCuadrado); //funca
								imprimirObjetos(listaCirculo); //funca
								//imprimirObjetos(listaString); // No funciona xq espera de Figura xa abajo y String no corresponde
							*/	
								
					// PERO VEAMOS OTRA COSA DE EXTENDS -> Si en un api gen q apunta con extends figura quiero agregar un new circulo
					// 		ent java NO ME DEJA ADDS NI REMOVES! 
					//			C/ extends NO ME DEJA ADDS Y REMOVES DE OTRA Cosa q no sea el tipo concreto 
						
					// VENTAJA: ME PERMITE RECORRER USANDO POLIMORFISMO EN EL API GENERICO XQ SABE Q ESPERA DE AHI XA ABAJO 
					//				Y Q NO VA A SER XA ARRIBA. ENT COMPARTEN UNA INTERFACE EN COMUN. en este ejemplo el api gen 
					//				imprimir objectosd no usaba polimorfismo pero podria hacerce generico pero no tanto de objects 
					//				sino por ejemplo de productos x ej un api gen q no solo los imprima sino ahi mejor object pero 
					//				x ej un procesador de productos q le ejecuta apu comun a todo producto. ent ahi sirve extends!!
					//				xq permite apuntarlo con extends y ent poder usar polimorfismo tranquilo sin posibilidad de error
								
					// SUPER ( lower bounded. de ahi xa arriba MISMA RAMA todas .) ( MENO: SUPER SOLO SI HARé ADDS O REMOVES EN LA 
					//			COLL Y QUIERO Q OTROS MAS GENERICOS TENGAN COMPATIBILIDAD. X EJ UNA BOLSA DE FRUTAS PUEDE TENER SU 
					//			LISTA DEF COMO SUPER FRUTA XA Q UN CARRO GENERICO PUEDA AGREGARLA pero ojo no podrá saber lo que 
					//			tiene xq super permitia hasta objects asi q para USARLA (accederla, hacerle algo al elem etc solo 
					//			podrá tratarlo como object o hacer if getclass y tratar caso x caso indep a mano  
					// -----			
					// 		( super  parece contraintuitivo pero permite reuso x otros apis y polimorf en el code )
								
								//... que pasa si la lista la recibo como list super ?  
								// pruebo con recibir --> (List<? super Figura> lista) 

								// imprimirObjetos(listaTriangulo); // NO FUNCIONA
								// imprimirObjetos(listaCuadrado); // NO FUNCIONA
								// imprimirObjetos(listaCirculo); //NO FUNCIONA
								// imprimirObjetos(listaString); // NO FUNCIONA
								// SOLO FUGURAS
								
								/** -- Lo comento solo por que volví a probar cosas con extends , 
								 *  	x ej un add new circulo en imprimir objs extends 
								 *  ------- */
								// lo descomento de nuevo XA usar de nuevo la def de super en imprimirObjs y ent: 
								List<Figura> listaFiguras = new ArrayList();
								listaFiguras.add(new Circulo(2.0));
								listaFiguras.add(new Cuadrado(2.0)); listaFiguras.add(new Triangulo(0));
								
								List<Object> listaAncestraFigura; //misma rama xa arriba no hermanos no primos solo ancestros lineales 
								listaAncestraFigura = new ArrayList();//new ArrayList<Object>()
								listaAncestraFigura.add(new String("String"));
								listaAncestraFigura.add(new Object());
								listaAncestraFigura.add(new Circulo(3.0));
								
								imprimirObjetos(listaFiguras);  // FUNCA 
								imprimirObjetos(listaAncestraFigura); // FUNCA 
								
								//Vemos que dejando los adds o removes en super y tmb el listar como object funca 
								
								//CONCLUSION SUPER: 
								//super permite add y remove de cualquier cosa y puedo tmb usar polimorfismo
								// el api generico que la usa (recibe) imprimirObjectos le sirve xq es generico xa object xq no 
								//	necesita nada especifico de los objetos + q imprimirlos, contar los elems, sacar estadisticas, 
								//	almacenarlos asi como estan etc. 
								// ventajas:
								// > compat con otros apis genericos del sistema
								// puedo usar polimorfismo y meter cualquier figura tratandolas a todas igual x su clase padre o 
								//		interfaz ( recordar q wildcards permiten tanto clases como interfaces en su def xa limites!
								// es de lectura y escritura xa las colecciones def (refs) ta sean atribs, args, params etc , ya q 
								//		permite add y removes xq es coherente con super si le pasé polimorfico pero recordar 
								//		q para lecturas ( acceder) no es tan sencillo debo castear a lo q necesito creo o directa-
								//		mente no se puede ( para colls q solo voy a leer mejor extends o unbounded o sin wildcards (T)
								//		SI ES XA adds y removes ent xa xa q me lo permita y xa ganar polimorf y >  reuso c/otros comps
								//		genericos , ent usar super
								
			} //end main	
		
			//static void imprimirObjetos(List<Object> lista) {
			//static void imprimirObjetos(List<?> lista) {
			//static void imprimirObjetos(List<? extends Figura> lista) { // Todas las figuras xa abajo incluye toda rama:circ,cuad.. 
			static void imprimirObjetos(List<? super Figura> lista) { // Todas las figuras xa abajo incluye toda rama:circ,cuad..
			
			// lista.add(new Figura(2.0));   SABER: Con Extends no me deja hacer adds ni removes ni nada xq el java no podria garantizar 
			// lista.add(new Circulo(2.0));			de antemano la coherencia de tipos y runtime errors o de concepto ya. 
															// ( x eso extends es solo lectura y super es lectura escritura )
			// ahora las vuelvo a poner xq vuelvo a cambiar a la definicion a super :
				//seccion de uso api generico : escritura ( modif) elems de una coll generic wildcard:
				lista.add(new Figura(2.0));   // SABER: Con Super me permite todo , adds , removes (modifs) y lectura.   
				lista.add(new Circulo(2.0));	 
			// seccion de uso api generico: solo lectura de una coll 	
				for (Object object : lista) {
					System.out.println(object);
				}
			}
			
//			class Figura {	//saber: Estaba mal definir las demas classes xq estaban dentro de la clase ppal y ent eran nested!!! 
} 
class Figura {	//saber: puede tener varias clases en 1 mismo file, no son nested estas, pero solo la ppal puede ser public				
	
	private double area;
	
	public Figura(double area) {
		this.area = area;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[area=" + area + "]";
	}
	
} // end class Figura	

//Especializaciones de figura 			Clases extends figuras ( son figuras, [y mas.. ] )
//										Herencia: Una figura no es un circulo pero un circulo es una figura 

class Circulo extends Figura{			//Circulo
	public Circulo(double area) {
		super(area);
	}
}

class Cuadrado extends Figura{			//Cuadrado
	public Cuadrado(double area) {
		super(area);
	}
}

class Triangulo extends Figura{
	public Triangulo(double area) {		//Triangulo
		super(area);
	}
}
