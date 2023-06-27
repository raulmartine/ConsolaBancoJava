package banco.pruebas;

import banco.modelos.Cliente;

public class PruebasCliente {
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente(1,"paco","1234","paco@correo.es",10.0, 1);
		
		System.out.println(cliente);
	}
}
