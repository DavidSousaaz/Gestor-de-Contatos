package DAO;

import java.util.ArrayList;
import java.util.List;

import Model.Contato;
import Model.ContatoDTO;

public class ContatoDAO {
	
	private static ContatoDAO instancia;
	
	private List<Contato> contatos = new ArrayList<Contato>();
	
	private List<Contato> contatosDeletados = new ArrayList<Contato>();
	
	private ContatoDAO() {}

	public static ContatoDAO getInstance() {
		if (instancia == null) {
			instancia = new ContatoDAO();
		}
		return instancia;
	}
	
	
	public void cadastrarContato(ContatoDTO contatoDTO) {
		Contato novoContato = new Contato(contatoDTO.getNome(), contatoDTO.getDDD(), contatoDTO.getNumero());
		
		for(Contato c: contatos) {
			if(!(novoContato.equals(c))) {
				contatos.add(novoContato);
			} else {
				c.setNome(novoContato.getNome());
			}
		}
	}
	
}
