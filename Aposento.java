package Model;
// model são as classes que vc identificou no seu cenário e representarão as tabelas de seu banco de dados

public class Aposento {
	private int codigo;
	private double valor;
	private String descricao;
	private int numero;
	
	public Aposento(){
		
	}
	
	public Aposento(int codigo, double valor, String descricao, int numero){
		this.codigo = codigo;
		this.valor = valor;
		this.descricao = descricao;
		this.numero = numero;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}