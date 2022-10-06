package Model;

public class Funcionario {
	//vari�veis de inst�ncia
	private int codigo;
	private String nome;
	private String cargo;
	private double salario;
	private String cpf;
	private String telefone;
	
	//construtores
	public Funcionario() {
		//construtor default
	}

	public Funcionario(int codigo, String nome, String cargo, double salario, String cpf, String telefone) {
		this.codigo = codigo;
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
	//getters e setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
