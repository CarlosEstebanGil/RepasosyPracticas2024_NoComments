package Repaso2024;

import java.util.HashSet;
import java.util.function.Consumer;

// INNER class, LOCAL method, Anonima y Static Nested Class

public class NestedClasses {

	public static void main(String[] args) {

		//1) Inner class local a un metodo: (en este caso mi ej deun metodo local a main, solo xa usarla enel main como prueba rapida) 

		class innerclassMyHashSet<E> extends HashSet<E> {
			
			public void addOrActionIfRepetead(E elem, Consumer<E> accion) {
				
				if (this.contains(elem)) {
					if (accion != null) {
						accion.accept(elem); 
					}
				}
				else { 
					this.add(elem);
				}
			}
		}
		
		innerclassMyHashSet<String> myset = new innerclassMyHashSet();
		myset.addOrActionIfRepetead("charly", null);
		System.out.println("se agregó el elem str charly al set de strings con mi addorthrow extension, x ahora todo ok xq es el 1ero"  );
		System.out.println("Intento agregar de nuevo el mismo elem str charly (mismo valor) al set mediante mi addorthrow extension:");
			myset.addOrActionIfRepetead("charly", s -> System.out.println("el elem "+ s +" está repetido. puede definir cualquier otra accion aqui"));
	
			// INNER CLASS LOCAL A UN METODO: En un ejemplo real o ambiente real, Una inner class local a un método puede ser útil cuando 
			// necesitas encapsular la lógica de un algoritmo específico dentro de un método y esta lógica no se reutilizará en otros lugares 
			// de la clase. Además, puede ayudar a mantener el contexto y la coherencia del código al agrupar la lógica relacionada cerca 
			// de donde se utiliza. En mi ej de code previo es solo probar como funcionaba y solo para usarla en mi main asi como prueba
	
		//2) Inner clase (Non-static):
			
			// Un ejemplo común de una inner class que tiene sentido ser una inner class de otra es cuando estás implementando un 
			// iterador para una estructura de datos compleja, como una lista enlazada o un árbol. En este caso, la inner class puede 
			// representar el iterador y estar directamente relacionada con la estructura de datos que está iterando.
			
			// En este ejemplo, LinkedList contiene una inner class llamada LinkedListIterator, que implementa la interfaz Iterator 
			// para iterar sobre la lista enlazada. Esta inner class está directamente relacionada con la estructura de datos 
			// (LinkedList) y encapsula la lógica de iteración dentro de la clase LinkedList. Esto hace que el código sea más modular 
			// y fácil de entender, ya que el iterador está estrechamente vinculado con la lista enlazada y no necesita ser utilizado 
			// fuera de este contexto.
			
			// Otro ejemplo común de una inner class que tiene sentido ser una inner class de otra es cuando estás desarrollando una 
			// aplicación gráfica y necesitas manejar eventos de manera específica para un componente.
			// Por ejemplo, supongamos que estás creando una clase Ventana que representa una ventana en tu aplicación, y dentro de 
			// esta ventana tienes un botón. Quieres manejar los eventos del botón de una manera específica y encapsulada dentro de la 
			// clase Ventana.

			// En este otro ejemplo, la clase Ventana contiene una inner class llamada BotonListener, que implementa la interfaz 
			// ActionListener para manejar los eventos del botón. La inner class está estrechamente relacionada con la ventana y 
			// encapsula la lógica de manejo de eventos del botón dentro de la clase Ventana. Esto hace que el código sea más 
			// organizado y modular, ya que el manejo de eventos del botón está encapsulado dentro de la clase que representa la 
			// ventana.

			
		//3) Inner clase static:
			
			// Un ejemplo sencillo pero práctico de cómo podrías usar una static nested class en un escenario real:

			// Supongamos que estás desarrollando una aplicación de gestión de cuentas bancarias. Tienes una clase principal Bank que 
			// representa un banco y deseas tener una clase interna que represente las cuentas bancarias que pertenecen a ese banco.
		
			// En este ejemplo, la clase Bank contiene una static nested class llamada Account, que representa una cuenta bancaria. 
			// Esta nested class es estática porque no necesita acceder a los miembros no estáticos de la clase externa Bank.

			// La utilidad de esta nested class radica en que la encapsulación de las cuentas bancarias está directamente relacionada 
			// con el banco. Además, no necesitamos que Account acceda directamente a los miembros no estáticos de Bank, por lo que una 
			// static nested class es adecuada para este propósito.
			
			class Bank { //public class Bank {			(obs: lo comentado es solo para pegarla aca como tmb local al main (un mix))
			    private String name;
			    static class Account {//private static class Account {
			        private String accountNumber;
			        private double balance;

			        public Account(String accountNumber) {
			            this.accountNumber = accountNumber;
			            this.balance = 0.0;
			        }

			        public void deposit(double amount) {
			            balance += amount;
			            System.out.println("Depósito de $" + amount + " realizado en la cuenta " + accountNumber);
			        }

			        public void withdraw(double amount) {
			            if (balance >= amount) {
			                balance -= amount;
			                System.out.println("Retiro de $" + amount + " realizado de la cuenta " + accountNumber);
			            } else {
			                System.out.println("Fondos insuficientes en la cuenta " + accountNumber);
			            }
			        }

			        public double getBalance() {
			            return balance;
			        }
			    }

			    public Bank(String name) {
			        this.name = name;
			    }

			    public void openAccount(String accountNumber) {
			        System.out.println("Se ha abierto una nueva cuenta en el banco " + name + " con número " + accountNumber);
			    }

			    public static void main(String[] args) {
			        Bank bank = new Bank("MyBank");
			        bank.openAccount("123456789");

			        Bank.Account account = new Bank.Account("123456789");
			        account.deposit(1000);
			        account.withdraw(500);
			        System.out.println("Saldo de la cuenta: $" + account.getBalance());
			    }
			} // de esta manera veo el ej como codigo no comentado y resaltado y no tira error pero x las dudas no lo uso xq 
				// no se si funcará este mix loco de una static inner class como a su vez iiner class local a un metodo (main)
	} //end-main	

} //end-class
