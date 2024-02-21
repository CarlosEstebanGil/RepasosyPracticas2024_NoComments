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
		
		//array
		
		char[] carr = new char[50];
		for (int i = 0; i < 50; i++) carr[i] = (char)i; //charVar=iNum; no funca  no es compatible//(char)i; me guarda el codigo ascii de i 
		for (int i = 0; i  < carr.length ; i++) System.out.print((int) carr[i] ); //como imprimo un char numerico ent casteo a int 
																				  //	xa imprimirlo.
		
		//API COLLECTIONS:		( ejs de los mas basicos / mas comunmente usados )
		//--- ----------- 		______________________________________________________________________

		//ARRAY
		//_____
		
			List<String> listNombres = Arrays.asList("car","noe","lali","chiqui"); //new ArrayList();
			
			System.out.println("\n " + listNombres.getClass()); // Arrys.asList me devuelve un arrayList 
			
			listNombres.forEach(System.out::println);//(s-> System.out.print("\n" + s )); 
		
		//LISTA
		//_____
			
			List<String> listProfesiones = new LinkedList();
			listProfesiones.add("Ingeniero en Sistemas");
			listProfesiones.add("Carpintero");
			listProfesiones.add("Electricista");
			listProfesiones.add("Medico");
			listProfesiones.removeIf( s -> s.equalsIgnoreCase("Electricista") );
			
			System.out.println();
			
			listProfesiones.forEach(System.out::println);
			
		//SET
		//___
			//List<Integer> listNumeroOrden = new LinkedList<>();
			Set<Integer> setNumerosOrden = new HashSet<>();
			setNumerosOrden.add(1);
			setNumerosOrden.add(2);
			System.out.println();
			try {
				setNumerosOrden.add(2);
				setNumerosOrden.forEach(System.out::println); // Saber: si ya existia no arroja exception sino que simplemente no hace nada

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
			//Entonces: 
			// Para controlar si un dato aparece repetido al llenar un HashMap y actuar en consecuencia, puedes seguir estos pasos:

				// Antes de agregar un valor al HashMap, verifica si ya existe en el mapa.
				// puedes manejar la situación de la manera que desees: ya sea reemplazando el valor existente 
				// con el nuevo valor, lanzando una excepción, mostrando un mensaje de advertencia, o realizando cualquier otra acción.
			
				/* Ejemplo:

				 * agregarElemento(mapa, "uno", 1); agregarElemento(mapa, "dos", 2);
				 * agregarElemento(mapa, "tres", 3); agregarElemento(mapa, "uno", 1); //Intentar agregar una clave repetida
				 * 
				 * public static void agregarElemento(HashMap<String, Integer> mapa, String clave, int valor) { 
				 * 	if (mapa.containsKey(clave)) { // La clave ya existe, puedes manejar la situación de la manera que desees
				 * 		System.out.println("La clave '" + clave + ya existe en el HashMap. clave dupli: '" + valor + "'.");
				 * 		// Aquí puedes lanzar una excepción, mostrar un mensaje de advertencia, etc.
				 *   } else { // La clave no existe, se agrega el nuevo par clave-valor al HashMap
				 * 		mapa.put(clave, valor); 
				 *  } 
				 * }
				 */
			
				//Saber: 
				
				// CharlySan: no puedo lanzar una excepcion si el valor q intento add ya existe pero con alguna especie de metodo 
				// propio de la clase set x ej una especie de mySet.addOrThrow(elem) o algo asi, no existe eso en el api de java ???
			
				// ChatGPT35:

				// En la API estándar de Java, no existe un método directo addOrThrow() en la interfaz Set que te permita agregar un 
				// elemento y lanzar una excepción si ya existe. Sin embargo, puedes implementar tu propio método de extensión o 
				// utilizar una clase envoltorio personalizada para lograr este comportamiento.

				//	ej implementacion un método de extensión para Set que agregue un elemento y lance una excepción si ya existe:
				
				//Set<Integer> mySet = new HashSet<>();
				//SetExtension<Integer> mySet = new HashSet();
			 	Set<Integer> mySet = new HashSet<>(); 
			 	MySetWrapper<Integer> wrappedSet = new MySetWrapper<>(mySet);
			 	
			 	//mySet.add(1);
				//mySet.add(2);
			 	wrappedSet.add(1);
			 	wrappedSet.add(2);
				        
				        try {
				        	wrappedSet.addOrThrow(2);//( (SetExtension<Integer>) mySet).addOrThrow(1); //mySet.addOrThrow(1);
				        } catch (ElementoDuplicadoException e) {
				            System.out.println("Error: El elemento ya existe en el conjunto.");
				        }
				        
				        System.out.println("Conunto:" + mySet);
				        
				//MAP
				//___ : new j8+: antes usabamos el entryset xa recorrer , y tmb habia q hacer todo a mano lo q j8 me da con mehtods
				
				// j7 (old)
				        // for ( Entry(Integer,Strin> e: map.entrySet() ) syso(e.getKey()+e.getValue();				        
				//j8+ ( new methods) 
				        
				        //1. map.forEach( (k,v) -> syso.print(k+v) ó sino tmb map.entrySet.stream().forEach(syso::println);
				        //2- putIfAbsent(Integer key, String value) el put comun si existia lo sobreescribe, este lo deja como estaba)
				        //3- map.computeIfPresent(3, (k,v) -> k + v ) 
				        //4- map.getOrDefault(5,"valor por defecto"); si no existe (no si es null eh)! ent me da el default (simil a optional)!
				        //5- Collectors.toMap, ej:
				        //						Map<Integer,String> mapaRecolectado = map.entrySet().stream()
						//							.filter(e->strPalabraACoincidir) // o .contains"h" o.startswith o .. etc etc.
						//							.collect(Collectors.toMap( p -> p.getKey(), p.getValue() );

				        
				} //end-main

			} //end class
			
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

				    /* @Override
				    public boolean contains(T elem) {
				        return set.contains(elem);
				    } */

				    @Override
				    public boolean addOrThrow(T elem) {
				        if (set.contains(elem)) {
				            throw new ElementoDuplicadoException("El elemento ya existe en el conjunto: " + elem);
				        }
				        return set.add(elem);
				    }

				    // luego Implementa el resto de métodos de SetExtension delegando a los métodos correspondientes de Set
				    // ( esto lo hice con btn der -> souce -> generate delegate methods ) !!!!!!!!! todo auto
				    
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
				
			// Otra implementacion podria ser usando herencia normal , extendiendo el hashset con una subclase mia especializada,ej:
			/*	class MySet<T> extends HashSet<T> {
				    public boolean addOrThrow(T elem) {
				        if (contains(elem)) {
				            throw new ElementoDuplicadoException("El elemento ya existe en el conjunto: " + elem);
				        }
				        return add(elem);
				    }	
			*/ 
				
			/* Otra mas podria haber sido un simple procedimiento en esta clase con un of cointains then add else actionxRepe pero
			 * esa es la opcion mas pobre porque solo serviria en esta clase, o incluso si lo hiciera static seria una imple de un 
			 * extend de un set en si pero en esta clase que nada tiene que ver con sets cuando esa extension deberia estar en 
			 * una subclase o subinterface de set o alguna imple de set, ej, si dese aca lo sig:
			 * 			
			 * 	public static void agregarElemento(HashMap<String, Integer> mapa, String clave, int valor) {
        			if (mapa.containsKey(clave)) {
			        	// La clave ya existe, puedes manejar la situación de la manera que desees
			        	System.out.println("La clave '" + clave + "' ya existe en el HashMap. No se puede agregar el valor '" + valor + "'.");
			            // Aquí puedes lanzar una excepción, mostrar un mensaje de advertencia, etc.
			        } else {
			            // La clave no existe, se agrega el nuevo par clave-valor al HashMap
			            mapa.put(clave, valor);
			        }
		    	}
			 
			 funcionaria pero la verdad que eso esté en esta clase no tiene relacion . extender una i o una imple es lo + correcto */
				
			//	.. etc	.. 