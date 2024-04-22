package Repaso2024;

import java.util.HashSet;
import java.util.function.Consumer;


public class NestedClasses {

	public static void main(String[] args) {


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
	
			
			class Bank { 
			    private String name;
			    static class Account {
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
			} 
				
	} 	

} 
