package Model;

public class ContatoDTO {
	
private String nome;
	
	private String dDD;
	
	private String numero;
	
	
	public ContatoDTO(String nome, String dDD, String numero) {
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

}
