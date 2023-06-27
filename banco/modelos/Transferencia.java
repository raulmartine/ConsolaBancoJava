package banco.modelos;

import java.util.Date;

public class Transferencia {

	private int id;
	private int id_ordenante;
	private int id_beneficiario;
	private double importe;
	private String concepto;
	private Date fecha;
	
	public Transferencia() {
		
	}
	
	public Transferencia(int id, int id_ordenante, int id_beneficiario, double importe, String concepto) {
		this.id = id;
		this.id_ordenante = id_ordenante;
		this.id_beneficiario = id_beneficiario;
		this.importe = importe;
		this.concepto = concepto;
		this.fecha = new Date();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getid_ordenante() {
		return id_ordenante;
	}
	public void setid_ordenante(int id_ordenante) {
		this.id_ordenante = id_ordenante;
	}
	public int getId_beneficiario() {
		return id_beneficiario;
	}
	public void setId_beneficiario(int id_beneficiario) {
		this.id_beneficiario = id_beneficiario;
	}
	public double getImporte() {
		return importe;
	}
	public void setImpprte(double importe) {
		this.importe = importe;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	
	
	
	
	
}
