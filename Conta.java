package Model;

import java.awt.List;

public class Conta {
	private int codigo;
	private double valorTotal;
	private boolean pago;
	private List consumos;
	
	public Conta(int codigo, double valorTotal, boolean pago, List consumos) {
		
		this.codigo = codigo;
		this.valorTotal = valorTotal;
		this.pago = pago;
		this.consumos = consumos;
	}
	
	public Conta() {
		
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	public List getConsumos() {
		return consumos;
	}
	public void setConsumos(List consumos) {
		this.consumos = consumos;
	}
}