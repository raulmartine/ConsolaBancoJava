package banco.modelos;

import java.util.Date;

public class Mensaje {
	
	private int id; 
	private int id_origen;
	private int id_destino;
	private String texto;
	private Date fecha;
	
	public Mensaje() {
		
	}
	
	public Mensaje(int id, int id_origen, int id_destino, String texto) {
		this.id = id;
		this.id_origen = id_origen;
		this.id_destino = id_destino;
		this.texto = texto;
		this.fecha = new Date();
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_origen() {
		return id_origen;
	}
	
	public void setId_origen(int id_origen) {
		this.id_origen = id_origen;
	}
	
	public int getId_destino() {
		return id_destino;
	}
	
	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String toString() {
		return "Mensaje{id: " + this.id + " id_origen: " + this.id_origen + " id_destino: " + this.id_destino + " texto: " + this.texto + " fecha: " + this.fecha;
	}
}
