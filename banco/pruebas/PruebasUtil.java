package banco.pruebas;

import java.util.List;
import java.util.ArrayList;

import banco.util.Utiles;
import banco.modelos.Gestor;

public class PruebasUtil {

		public static void main(String[] args) {
			
			// String nombreAleatorio = Utiles.nombreAleatorio(Utiles.NOMBRES, Utiles.APELLIDOS);
			
			String nombreAleatorio = Utiles.nombreAleatorio();			
			
			System.out.println(nombreAleatorio);
			
			// String correoAleatorio = Utiles.correoAleatorio(Utiles.CORREOS);
			
			String correoAleatorio = Utiles.correoAleatorio();
			
			System.out.println(correoAleatorio);
			
			List<Gestor> gestores = new ArrayList<>();
			
			for (int i = 0; i < 10; i++) {
				String usuario = Utiles.nombreAleatorio();
				String correo = Utiles.correoAleatorio();
				Gestor gestor = new Gestor(i+1,usuario,"", correo,"");
				gestores.add(gestor);
			}
			System.out.println(gestores);
		}
}
