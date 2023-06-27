package banco.util;

import java.util.Random;

public class Utiles {

	public static final String[] NOMBRES = {"Gracia","Roberto","Norber","Pepe","Edu","Lola","Ana","Sofia","Berni","Laura","Maria"};
	
	public static final String[] APELLIDOS = {"Rubiales","Lama","Pérez","Martínez","Estela","García","López","Font","Alberola","Yamaguchi","Pitarch","Gregori"};
	
	public static final String[] CORREOS = {"gestor1@gmail.com","gestor2@gmail.com","gestor3@gmail.com","gestor4@gmail.com","gestor5@gmail.com"};
	
	public static String nombreAleatorio(String[] nombres, String[] apellidos) {
				
		Random random = new Random();
		
		int indiceNombre = random.nextInt(nombres.length);
		String nombre = nombres[indiceNombre];
		
		int indiceApellido = random.nextInt(apellidos.length);
		String apellido = apellidos[indiceApellido];
		
		return nombre + " " + apellido;		
	}
	
	public static String nombreAleatorio() {
		return nombreAleatorio(NOMBRES, APELLIDOS);
	}
	
	public static String correoAleatorio(String[] correos) {
		
		Random random = new Random();
		
		int indiceNombre = random.nextInt(correos.length);
		String correo = correos[indiceNombre];
				
		return correo;	
	}
	
	public static String correoAleatorio() {
		return correoAleatorio(CORREOS);
	}
}
