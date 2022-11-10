package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name =  "clientes")
public class Cliente {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 private String nome;
	 private String habilidade;
	 private String aldeia;
	 private Integer idade;
	 private boolean aposentado;
	 
	 public Cliente(){
		 
	 }
	
	
	//contrutor sem o atributo id
	public Cliente(String nome, String habilidade, String aldeia, Integer idade, boolean aposentado) {
		this.nome = nome;
		this.habilidade = habilidade;
		this.aldeia = aldeia;
		this.idade = idade;
		this.aposentado = aposentado;
	}
	
	
	//getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}

	public String getAldeia() {
		return aldeia;
	}

	public void setAldeia(String aldeia) {
		this.aldeia = aldeia;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public boolean isAposentado() {
		return aposentado;
	}

	public void setAposentado(boolean aposentado) {
		this.aposentado = aposentado;
	}
 
}
