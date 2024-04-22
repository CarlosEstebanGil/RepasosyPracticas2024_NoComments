package Repaso2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Generics2_new {

	
			public static void main(String[] args) {
				
				Generics2_new app = new Generics2_new();
			
				
				List<String> listaString= Arrays.asList("Car","noe","lali","chiqui");
				List<Circulo> listaCirculo= new ArrayList<>();
								listaCirculo.add(new Circulo(2.0));
				List<Cuadrado> listaCuadrado=new ArrayList<>();
								listaCuadrado.add(new Cuadrado(3.0)); 
				List<Triangulo> listaTriangulo =new ArrayList<>();
								listaTriangulo.add(new Triangulo(10.0)); 
				

								List<Figura> listaFiguras = new ArrayList();
								listaFiguras.add(new Circulo(2.0));
								listaFiguras.add(new Cuadrado(2.0)); listaFiguras.add(new Triangulo(0));
								
								List<Object> listaAncestraFigura; 
								listaAncestraFigura = new ArrayList();
								listaAncestraFigura.add(new String("String"));
								listaAncestraFigura.add(new Object());
								listaAncestraFigura.add(new Circulo(3.0));
								
								imprimirObjetos(listaFiguras);  
								imprimirObjetos(listaAncestraFigura); 
								
			} 
		
			static void imprimirObjetos(List<? super Figura> lista) { 
			
				lista.add(new Figura(2.0));   
				lista.add(new Circulo(2.0));	 

				for (Object object : lista) {
					System.out.println(object);
				}
			}
			

} 
class Figura {	
	
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
	
} 


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
