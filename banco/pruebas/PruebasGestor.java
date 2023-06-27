package banco.pruebas;

import banco.modelos.Gestor;

public class PruebasGestor {
	
		public static void main(String[] args) {
			Gestor gestor = new Gestor(1, "paco", "1234", "paco@correo.com","5");
			Gestor gestorB = new Gestor(2, "ana", "6534", "ana@correo.com","6");
			
			gestorB.setId(2);
			gestorB.setUsuario("ana");
			gestorB.setUsuario("6534");
			gestorB.setCorreo("ana@correo.com");			
			
			System.out.println(gestor);
			
			if (gestor.equals(gestorB)) {
				System.out.println("Son el mismo gestor");
			}
			else {
				System.out.println("Son diferente gestor");
			}
		}
}
