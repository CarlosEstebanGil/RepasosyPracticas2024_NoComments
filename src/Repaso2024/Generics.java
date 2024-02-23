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
		
		class carritoDeCompras<T> {
		//atribs:	
			List<T> lCarro= new LinkedList();
		//constructor:
			public carritoDeCompras(T elem) {
			} 
		//methods:
			public void addElemTOCarro(T elem) {
				lCarro.add(elem);
			}
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
