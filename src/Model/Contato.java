package Model;

import java.util.Objects;

public class Contato {
	
	private String nome;
	
	private String dDD;
	
	private String numero;
	
	
	public Contato(String nome, String dDD, String numero) {
		this.nome = nome;
		this.dDD = dDD;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDDD() {
		return dDD;
	}

	public void setDDD(String dDD) {
		this.dDD = dDD;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", dDD=" + dDD + ", numero=" + numero + "]";
	}


	public boolean equals(Contato o) {
		if(this.numero.equalsIgnoreCase(o.getNumero())) {
			return true;
		}
		
		return false;
	}
	
	
	
}
