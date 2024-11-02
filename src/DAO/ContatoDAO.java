package DAO;

import java.util.ArrayList;
import java.util.List;

import Model.Contato;
import Model.ContatoDTO;

public class ContatoDAO {

	private static ContatoDAO instancia;

	private List<Contato> contatos = new ArrayList<Contato>();

	private List<Contato> contatosDeletados = new ArrayList<Contato>();

	private ContatoDAO() {
	}

	public static ContatoDAO getInstance() {
		if (instancia == null) {
			instancia = new ContatoDAO();
		}
		return instancia;
	}

	public void cadastrarContato(ContatoDTO contatoDTO) {
		Contato novoContato = new Contato(contatoDTO.getNome(), contatoDTO.getDDD(), contatoDTO.getNumero());

		contatos.add(novoContato);
	}
	
	public void deletarContato(int indexLixo) {
		Contato lixo = contatos.get(indexLixo);
		contatosDeletados.add(lixo);
		contatos.remove(lixo);
	}

	public boolean editarContato(Contato contatoDTO, Contato copiaTela) {
		Contato novoContato = new Contato(contatoDTO.getNome(), contatoDTO.getDDD(), contatoDTO.getNumero());

		for (Contato c : contatos) {
			if (c.getNome().equals(novoContato.getNome())) {
				contatos.remove(c);
				contatos.add(copiaTela);
				return true;
			}
		}
		return false;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public List<Contato> getContatosDeletados() {
		return contatosDeletados;
	}

}
