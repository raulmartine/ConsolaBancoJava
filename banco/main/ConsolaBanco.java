package banco.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import banco.modelos.Cliente;
import banco.modelos.Gestor;
import banco.modelos.Mensaje;
import banco.modelos.Transferencia;
import banco.util.Utiles;

public class ConsolaBanco {

	private List<Gestor> gestores;
	private List<Cliente> clientes;
	private List<Mensaje> mensajes;
	private List<Transferencia> transferencias;
	private Integer siguienteIdGestor;
	private Integer siguienteIdCliente;
	private int siguienteIdMensaje;
	private int siguienteIdTransferencia;
	private Scanner teclado;
	private Gestor gestorLogeado;

	public ConsolaBanco() {
		this.gestores = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.mensajes = new ArrayList<>();
		this.transferencias = new ArrayList<>();
		this.siguienteIdGestor = 1;
		this.siguienteIdCliente = 1;
		this.siguienteIdMensaje = 1;
		this.teclado = new Scanner(System.in);
	}
	
	private void insertarGestor() {
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		System.out.print("Oficina: ");
		String oficina = teclado.next();

		Gestor nuevoGestor = new Gestor(siguienteIdGestor, nombre, pass, email, oficina);
		gestores.add(nuevoGestor);
		siguienteIdGestor++;
		System.out.println("Gestor creado con éxito.\n");
	}
	
	private void insertarGestoresDePrueba() {
		System.out.print("Número de gestores: ");
		int numeroGestores = teclado.nextInt();
		for (int i = 0; i < numeroGestores; i++) {
			String usuario = Utiles.nombreAleatorio();
			String correo = Utiles.correoAleatorio();
			Gestor gestor = new Gestor(siguienteIdGestor, usuario, "1234", correo, "");
			gestores.add(gestor);
			siguienteIdGestor++;
		}
		System.out.println("Gestores creados con éxito\n");
	}
	
	private void consultarGestor() {
		System.out.print("Id del gestor a consultar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		if (gestorResultado != null) {
			System.out.println(gestorResultado + "\n");
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor + "\n");
		}
	}
	
	private Gestor buscarGestorPorId(int idGestor) {
		Gestor gestorResultado = null;
		for (int i = 0; i < gestores.size(); i++) {
			Gestor gestor = gestores.get(i);
			if (gestor.getId() == idGestor) {
				gestorResultado = gestor;
				return gestorResultado;
			}
		}
		return null;
	}
	
	private void mostrarGestores() {
		if (gestores.isEmpty()) {
			System.out.println("Todavía no hay gestores\n");
		} else {
			gestores.forEach(gestor -> {
				System.out.println(gestor);
			});
			System.out.println("");
		}
	}
	
	private void actualizarGestor() {
		System.out.print("Id del gestor a actualizar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		if (gestorResultado != null) {
			System.out.println("[n] Nombre");
			System.out.println("[e] Email");
			System.out.println("[c] Contraseña");
			System.out.println("[o] Oficina");
			System.out.println("[x] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().toLowerCase().charAt(0);			

			switch (opcionActualizar) {

			case 'n':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				gestorResultado.setUsuario(nombre);
				break;

			case 'e':
				System.out.print("Email: ");
				String email = teclado.next();
				gestorResultado.setCorreo(email);
				break;

			case 'c':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				gestorResultado.setPassword(pass);
				break;

			case 'o':
				System.out.print("Oficina: ");
				String oficina = teclado.next();
				gestorResultado.setOficina(oficina);
				break;
			
			case 'x':
				System.out.println("Cancelando actualización...\n");
				break;
			default:
				System.out.println("Opción no válida\n");
			}
			if (opcionActualizar != 'x') {
				System.out.println("Se actualizó el gestor con el id " + idGestor + "\n");
			}
		} else {
			System.out.println("No se pudo actualizar el gestor con el id " + idGestor + "\n");
		}
	}
	
	private void eliminarGestor() {
		System.out.print("Id del gestor a eliminar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = null;
		int posicionGestor = -1;
		for (int i = 0; i < gestores.size(); i++) {
			Gestor gestor = gestores.get(i);
			if (gestor.getId() == idGestor) {
				gestorResultado = gestor;
				posicionGestor = i;
				break;
			}
		}
		if (gestorResultado != null) {
			gestores.remove(posicionGestor);
			System.out.println("Se eliminó el gestor con el id " + idGestor + "\n");
		} else {
			System.out.println("No se pudo eliminar el gestor con el id " + idGestor + "\n");
		}
	}
	
	private void insertarCliente() {
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		System.out.print("Saldo: ");
		double saldo = teclado.nextDouble();
		System.out.println();

		if(gestores.isEmpty()) {
			System.out.println("\nNo se puede crear un cliente sin haber creado gestores previamente. \nCree primero un gestor.\n");
		}
		else {
			mostrarGestores();			
			System.out.println("Elija el gestor: ");
			int idGestor = teclado.nextInt();
			
			while (idGestor <= 0 || idGestor > gestores.size()) {
				System.out.println("El gestor que indica no existe.");
				System.out.println("Indique un gestor existente\n.");
				mostrarGestores();			
				
				System.out.println("Elija el gestor: ");
				idGestor = teclado.nextInt();
			}
			
				Cliente nuevoCliente = new Cliente(siguienteIdCliente, nombre, pass, email, saldo, idGestor);
				
				clientes.add(nuevoCliente);
				siguienteIdCliente++;
				System.out.println("Cliente creado con éxito.\n");
			
				
			
		}
	}
	
	private void consultarCliente() {
		System.out.print("\nId del cliente a consultar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		if (clienteResultado != null) {
			System.out.println(clienteResultado);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idCliente + "\n");
		}
	}
	
	private Cliente buscarClientePorId(int idCliente) {
		Cliente clienteResultado = null;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getId() == idCliente) {
				clienteResultado = cliente;
				return clienteResultado;
			}
		}
		return null;
	}
	
	private void mostrarClientes() {
		if (clientes.isEmpty()) {
			System.out.println("Todavía no hay clientes\n");
		} else {
			clientes.forEach(cliente -> {
				System.out.println(cliente);
			});
			System.out.println();
		}
	}
	
	private void actualizarCliente() {
		System.out.print("\nId del cliente a actualizar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		if (clienteResultado != null) {
			System.out.println("[n] Nombre");
			System.out.println("[e] Email");
			System.out.println("[c] Contraseña");
			System.out.println("[s] Saldo");
			System.out.println("[x] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().toLowerCase().charAt(0);			

			switch (opcionActualizar) {

			case 'n':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				clienteResultado.setUsuario(nombre);
				break;

			case 'e':
				System.out.print("Email: ");
				String email = teclado.next();
				clienteResultado.setCorreo(email);
				break;

			case 'c':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				clienteResultado.setPassword(pass);
				break;

			case 's':
				System.out.print("Saldo: ");
				double saldo = teclado.nextDouble();
				clienteResultado.setSaldo(saldo);
				break;

			case 'x':
				System.out.println("Cancelando actualización...\n");
				break;

			default:
				System.out.println("Opción no válida\n");
			}
			if (opcionActualizar != 'x') {
				System.out.println("Se actualizó el cliente con el id " + idCliente + "\n");
			}
		} else {
			System.out.println("No se pudo actualizar el cliente con el id " + idCliente + "\n");
		}
	}
	
	private void eliminarCliente() {
		System.out.print("Id del cliente a eliminar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = null;
		int posicionCliente = -1;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getId() == idCliente) {
				clienteResultado = cliente;
				posicionCliente = i;
				break;
			}
		}
		if (clienteResultado != null) {
			clientes.remove(posicionCliente);
			System.out.println("Se eliminó el cliente con el id " + idCliente + "\n");
		} else {
			System.out.println("No se pudo eliminar el cliente con el id " + idCliente + "\n");
		}
	}
	
	private void consultarMensaje() {
		System.out.print("\nId del mensaje a consultar: ");
		int idMensaje = teclado.nextInt();
		Mensaje mensajeResultado = buscarMensajePorId(idMensaje);
		if (mensajeResultado != null) {
			System.out.println(mensajeResultado);
		} else {
			System.out.println("No se pudo encontrar un mensaje con el id " + idMensaje + "\n");
		}
	}
	
	private Mensaje buscarMensajePorId(int idMensaje) {
		Mensaje mensajeResultado = null;
		for (int i = 0; i < mensajes.size(); i++) {
			Mensaje mensaje = mensajes.get(i);
			if (mensaje.getId() == idMensaje) {
				mensajeResultado = mensaje;
				return mensajeResultado;
			}
		}
		return null;
	}
	
	private void mostrarMensajes() {
		if (mensajes.isEmpty()) {
			System.out.println("Todavía no hay mensajes\n");
		} else {
			mensajes.forEach(mensaje -> {
				System.out.println(mensaje);
			});
			System.out.println();
		}
	}
	
	private void enviarMensaje() {
		System.out.println("Indica el id destino: ");
		int idDestino = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce el texto: ");
		String texto = teclado.nextLine();
		int idOrigen = gestorLogeado.getId();
		
		Mensaje mensaje = new Mensaje(siguienteIdMensaje, idOrigen, idDestino, texto);
		mensajes.add(mensaje);
		siguienteIdMensaje++;
		System.out.println("Mensaje enviado correctamente.\n");
	}

	private void consultarTransferencia() {
		System.out.print("\nId de la transferencia a consultar: ");
		int idTransferencia = teclado.nextInt();
		Transferencia transferenciaResultado = buscarTransferenciaPorId(idTransferencia);
		if (transferenciaResultado != null) {
			System.out.println(transferenciaResultado);
		} else {
			System.out.println("No se pudo encontrar una transferencia con el id " + idTransferencia + "\n");
		}
	}
	
	private Transferencia buscarTransferenciaPorId(int idTransferencia) {
		Transferencia transferenciaResultado = null;
		for (int i = 0; i < transferencias.size(); i++) {
			Transferencia transferencia = transferencias.get(i);
			if (transferencia.getId() == idTransferencia) {
				transferenciaResultado = transferencia;
				return transferenciaResultado;
			}
		}
		return null;
	}
	
	private void mostrarTransferencias() {
		if (transferencias.isEmpty()) {
			System.out.println("Todavía no hay transferencias \n");
		} else {
			transferencias.forEach(transferencia -> {
				System.out.println(transferencia);
			});
			System.out.println();
		}
	}
	
	private void enviarTransferencia() {
		System.out.println("Indica el id destino: ");
		int idDestino = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce el importe: ");
		double importe = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("Introduce el concepto: ");
		String concepto = teclado.nextLine();
		int idOrigen = gestorLogeado.getId();
		
		Transferencia transferencia = new Transferencia(siguienteIdMensaje, idOrigen, idDestino, importe, concepto);
		transferencias.add(transferencia);
		siguienteIdTransferencia++;
		System.out.println("Transferencia enviado correctamente.\n");
	
	}
	
	private void cerrar() {
		System.out.println("Hasta luego!!\n");
		teclado.close();
	}

	public static void main(String[] args) {

		ConsolaBanco consola = new ConsolaBanco();
		
		consola.iniciar();
	}

	private void mostrarMenu() {
		System.out.println("1. Insertar gestor");
		System.out.println("2. Insertar gestores de prueba");
		System.out.println("3. Consultar un gestor");
		System.out.println("4. Ver todos los gestores");
		System.out.println("5. Actualizar gestor");
		System.out.println("6. Eliminar un gestor");
		System.out.println("7. Insertar un cliente");
		System.out.println("8. Consultar un cliente");
		System.out.println("9. Ver todos los clientes");
		System.out.println("10. Actualizar un cliente");
		System.out.println("11. Eliminar un cliente");
		System.out.println("12. Consultar un mensaje");
		System.out.println("13. Consultar todos los mensajes");
		System.out.println("14. Enviar un mensaje");
		System.out.println("15. Consultar una transferencia");
		System.out.println("16. Mostrar las transferencias");
		System.out.println("17. Enviar una transferencia");
		System.out.println("18. Login");
		System.out.println("0. Salir\n");

	}

private void iniciar() {
		
		int opcion;
		
		do {
			
			mostrarMenu();			
			
			System.out.print("Selecciona una opción: ");
			try {
				opcion = teclado.nextInt();
			} catch (Exception e) {
				opcion = -1;
			}
			
			switch (opcion) {

			case 1:
				insertarGestor();
				break;

			case 2:
				insertarGestoresDePrueba();
				break;

			case 3:
				consultarGestor();
				break;

			case 4:
				mostrarGestores();
				break;

			case 5:
				actualizarGestor();
				break;

			case 6:
				eliminarGestor();
				break;

			case 7:
				insertarCliente();
				break;

			case 8:
				consultarCliente();
				break;
				
			case 9:
				mostrarClientes();
				break;
				
			case 10:
				actualizarCliente();
				break;
				
			case 11:
				eliminarCliente();
				break;
				
			case 12:
				consultarMensaje();
				break;	
				
			case 13:
				mostrarMensajes();
				break;
				
			case 14:
				enviarMensaje();
				break;
			
			case 15:
				consultarTransferencia();
				break;	
				
			case 16:
				mostrarTransferencias();
				break;
				
			case 17:
				enviarTransferencia();
				break;
				
			case 18:
				login();
				break;
				
			case 0:
				cerrar();
				break;

			default:
				System.out.println("Opción desconocida...\n");
			}

		} while (opcion != 0);
	}

	private void login() {
		System.out.println("Id gestor: ");
		int idGestor = teclado.nextInt();
		System.out.println("Contraseña: ");
		String pass = teclado.next();
		Gestor gestor = buscarGestorPorId(idGestor);
		if (gestor!=null) {
			if (gestor.getPassword().equals(pass)) {
				System.out.println("Login Correcto!!!\n");
				gestorLogeado = gestor;
			}
			else {
				System.out.println("Login Incorrecto!!\n");
			}
		}
		else {
			System.out.println("El usuario no existe...\n");
		}
	}
	
}
