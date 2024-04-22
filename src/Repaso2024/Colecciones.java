package Repaso2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Colecciones {

	public static void main(String[] args) {
		
		
		char[] carr = new char[50];
		for (int i = 0; i < 50; i++) carr[i] = (char)i;  ascii de i 
		for (int i = 0; i  < carr.length ; i++) System.out.print((int) carr[i] ); 
																				  
		
		
			List<String> listNombres = Arrays.asList("car","noe","lali","chiqui"); 
			
			System.out.println("\n " + listNombres.getClass()); 
			
			listNombres.forEach(System.out::println);
		
			
			List<String> listProfesiones = new LinkedList();
			listProfesiones.add("Ingeniero en Sistemas");
			listProfesiones.add("Carpintero");
			listProfesiones.add("Electricista");
			listProfesiones.add("Medico");
			listProfesiones.removeIf( s -> s.equalsIgnoreCase("Electricista") );
			
			System.out.println();
			
			listProfesiones.forEach(System.out::println);
			
			Set<Integer> setNumerosOrden = new HashSet<>();
			setNumerosOrden.add(1);
			setNumerosOrden.add(2);
			System.out.println();
			try {
				setNumerosOrden.add(2);
				setNumerosOrden.forEach(System.out::println); 

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		

			 	Set<Integer> mySet = new HashSet<>(); 
			 	MySetWrapper<Integer> wrappedSet = new MySetWrapper<>(mySet);
			 	
			 	wrappedSet.add(1);
			 	wrappedSet.add(2);
				        
				        try {
				        	wrappedSet.addOrThrow(2);
				        } catch (ElementoDuplicadoException e) {
				            System.out.println("Error: El elemento ya existe en el conjunto.");
				        }
				        
				        System.out.println("Conunto:" + mySet);
				        
				        
				} 

			} 
			
			class ElementoDuplicadoException extends RuntimeException {
				    public ElementoDuplicadoException(String mensaje) {
				        super(mensaje);
				    }
				}
	
				interface SetExtension<T> extends Set<T> {
				    default boolean addOrThrow(T elem) {
				        if (contains(elem)) {
				            throw new ElementoDuplicadoException("El elemento ya existe en el conjunto: " + elem);
				        }
				        return add(elem);
				    }
				}
				
				class MySetWrapper<T> implements SetExtension<T> {
				    private Set<T> set;

				    public MySetWrapper(Set<T> set) {
				        this.set = set;
				    }

				    @Override
				    public boolean add(T elem) {
				        return set.add(elem);
				    }


				    @Override
				    public boolean addOrThrow(T elem) {
				        if (set.contains(elem)) {
				            throw new ElementoDuplicadoException("El elemento ya existe en el conjunto: " + elem);
				        }
				        return set.add(elem);
				    }

				    
					public void forEach(Consumer<? super T> action) {
						set.forEach(action);
					}

					public int size() {
						return set.size();
					}

					public boolean isEmpty() {
						return set.isEmpty();
					}

					public Iterator<T> iterator() {
						return set.iterator();
					}

					public Object[] toArray() {
						return set.toArray();
					}

					public <T> T[] toArray(T[] a) {
						return set.toArray(a);
					}

					public boolean remove(Object o) {
						return set.remove(o);
					}

					public boolean containsAll(Collection<?> c) {
						return set.containsAll(c);
					}

					public boolean addAll(Collection<? extends T> c) {
						return set.addAll(c);
					}

					public boolean retainAll(Collection<?> c) {
						return set.retainAll(c);
					}

					public boolean removeAll(Collection<?> c) {
						return set.removeAll(c);
					}

					public void clear() {
						set.clear();
					}

					public boolean equals(Object o) {
						return set.equals(o);
					}

					public int hashCode() {
						return set.hashCode();
					}

					public Spliterator<T> spliterator() {
						return set.spliterator();
					}

					public <T> T[] toArray(IntFunction<T[]> generator) {
						return set.toArray(generator);
					}

					public boolean removeIf(Predicate<? super T> filter) {
						return set.removeIf(filter);
					}

					public Stream<T> stream() {
						return set.stream();
					}

					public Stream<T> parallelStream() {
						return set.parallelStream();
					}

					@Override
					public boolean contains(Object o) {
						// TODO Auto-generated method stub
						return false;
					}
				    
				}
				
