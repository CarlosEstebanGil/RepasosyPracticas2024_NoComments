package Repaso2024;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics2_old {

	public static void main(String[] args) {
		
		 	List<? super Integer> lista = new ArrayList<Number>(); 
         	lista.add(10);  o  					

			Object obj = lista.get(0); 
        	System.out.println(obj);  
        	
        	class CarritoDeCompras<T> {
        	    						
        		private List<? super T> items; 	
        										
        	    public CarritoDeCompras() {
        	        this.items = new ArrayList<>();
        	    }

        	    public void addItem(T item) { 	
        	        items.add(item);			
        	    }

        	    public void removeItem(T item) { 
        	        items.remove(item);			 
        	    }								 
				
				public void recorrerCarrito() {  
        	        Iterator<? super T> iterator = items.iterator();
        	        while (iterator.hasNext()) {
        	            T item = (T) iterator.next(); 
        	            System.out.println(item);
        	        }
        	    }


        	}
        	
		
	}

}
