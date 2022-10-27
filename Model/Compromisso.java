package Model;

import java.util.Date;

public class Compromisso {
	private long id;
	private Date datCompromisso;
	private Contato contato;
	private String horCompromisso,  observacao;
	
	public Compromisso(Long id, Date datCompromisso, String horCompromisso, String observacao, Contato contato) {
		this.id = id;
		this.datCompromisso = datCompromisso;
		this.horCompromisso = horCompromisso;
		this.observacao = observacao;
		this.contato = contato;
	}
	
	public Compromisso() {
		
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Date getDatCompromisso() {
		return datCompromisso;
	}

	public void setDatCompromisso(Date datCompromisso) {
		this.datCompromisso = datCompromisso;
	}

	public String getHorCompromisso() {
		return horCompromisso;
	}

	public void setHorCompromisso(String horCompromisso) {
		this.horCompromisso = horCompromisso;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}