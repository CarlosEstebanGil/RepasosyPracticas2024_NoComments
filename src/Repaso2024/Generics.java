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

public class Generics {     

	public static void main(String[] args) {
		
		
		class carritoDeCompras<T> {				
			List<T> lCarro= new LinkedList();	
			public carritoDeCompras(T elem) {	
			} 									

			public void addElemTOCarro(T elem) {
				lCarro.add(elem);				
			}									
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

		}

	}

}
