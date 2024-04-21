package Repaso2024;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/** Este 1er ejemplo mio de Generics es el que plantea ahora las posteriores mejoras 
 * 			-> mediante upper or lower bounded en Generics2.java
*/
public class Generics {     

	public static void main(String[] args) {
		
		// inner class solo xa probarlo aca mismo en este file como ejemplo nomas
		
		class carritoDeCompras<T> {				//2024: BY CHARLY SAN 		
		//atribs:								//		|__> ESTA ES LA POSTA DE TODO el xq de generics, wildcards (?,extends y super )
			List<T> lCarro= new LinkedList();	// T funciona pero si hay un procesador generico en otro lado q espera object y 
		//constructor:							//		el T no es un object exacto concreto Object (no hijo) ent no soy compar  reuso
			public carritoDeCompras(T elem) {	//		con esos apis mas genericos. ademas solo puedo agregar elems T y no mas
			} 									//		osea q si me quieren agregar una pera o un martillo no pueden si no son en 
		//methods:								//		si productos ( siendo t = a producto) xq este carro seria SOLO de PRODUCTO
			public void addElemTOCarro(T elem) {//		( y no hijos ni herencia) tendria q usar otro carro para otro t y asi 
				lCarro.add(elem);				//		xa cada producto. y como un carro no es el api collections de java y sirve
			}									//		q en estos casos admita flexibilidad mas productos ent wildcard pero 
												//		como un carro es casi todo de adds y removes ent ? super xa adds y removes
												//		sino api java compi no me deja adds y removes a T de otra cosa ni a ? unbounded
												//		ni a ? extend ( upperbounded ) , solo super permite adds (lectoescritura)
												//		( pero ojo, es de T xa arriba misma rama, hasta object x eso limita tmpoco q 
												//		admite cualquier cosa. por eso xa lectura solamente es preferible extends ya 
												//		q permite todos (herederos cualquier subrama) x ej xa mostrar /acceder /actuar
												//		pero ojo, ese no es hasta object, extends me asegura q es un T si o si o un 
												//		descendiente, pero siempre compat, ent extends puede leer y aplicar .execute()
												//		o cosas asi sin necesidad de que T sea object ,osea aprovechar no tan generico 
												//		como object pero lo mas gral comun posible xa usar polimorfismo x ej una lista
												//		de comando podria ejecutar cualquier tipo de subramas paraleas ya divergentes
												//		(descendientes hermanos, primos, tios, etc) con ref elem T.execute() x/c/u
												//		luego el unbounded es xa q acepte cualquier cosa pero es solo lectura, ese 
												//		sirve xa cuando quiero realmente cualquier cosa no importa el arbol o tematica
												//		sino q me puedan pasar de cualquier clase, pero obvio ahi no hay seguridad de 
												//		nada ya q acepta todo y solo puede usarse en el codigo como Object q es lo 
												//		unico que seguro se que es compar con lo que me pasen sea la clase q sea es 
												//		un object ( aca si contempla herencia o flex . Y por ultimo tenemos generics 
												//		solos ejemplo <T> que eso es xa q acepte cualquier cosa, si q sirve xa cualquier 
												//		cosa, pero cada instancia es xa una sola cosa ( un solo tipo concreto) esto apunta
												//		a usos como collections (ver api java collectios) etc q son indep del tipo 
												//		osea lo laburan como object pero q a su vez yo puedo definir T como quiera 
												//		y x c/instancia concreta q debo definirle el tipo me manejo siempre con ese tipo,
												//		eso da ctrl, seguridad y es muy usado tmb x ej List<String>, List<Integer>, 
												//		List<Persona> etc pero obvio cada lista concreta debe definir un tipo y laburar
												//		siempre con ese y si no coincide el compi en t.de.desarrollo me lo avisa, esto
												//		es tpe safety y x eso es bueno ademas de empezar a darme lo de poder crear un 
												//		api generico y no tener q hacer x ej un contenedorXXX x cada tipo de cosa a contener
												//		sino que puedo hacer un CONTENEDOR DE TODO TIPO (T) y listo. total mi contenedor 
												//		xa cualquier tipo (1 x inst) lo atiende bien sea cual sea el tipo def en c/inst
												//		xq tiene code generico de object o code especializado ifs getclass xa ciertas clases
												//		si se quisiera. 
		//+ algunos delegated methods: autogenerados. (solo los que quiera re-usar xa brindar tmb al user a traves de mi wrapper y 
		//												  mi obj atrib wrappeado auto contra el atrib list de mi wrapper class 
		//													xq no es mas q eso un wrapper(extension/ especializacion) de una list. )
			public void forEach(Consumer<? super T> action) {
				lCarro.forEach(action);
			}

			public int size() {
				return lCarro.size();
			}

			public boolean isEmpty() {
				return lCarro.isEmpty();
			}

			public boolean remove(Object o) {
				return lCarro.remove(o);
			}

			public void clear() {
				lCarro.clear();
			}

			public T remove(int index) {
				return lCarro.remove(index);
			}


			public Stream<T> stream() {
				return lCarro.stream();
			}
			// .. etc
		}

	}

}
