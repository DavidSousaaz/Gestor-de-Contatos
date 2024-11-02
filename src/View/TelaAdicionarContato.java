package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import DAO.ContatoDAO;
import Model.Contato;
import Model.ContatoDTO;

public class TelaAdicionarContato extends TelaGenericaContato {

	List<Contato> listaDeContatos = ContatoDAO.getInstance().getContatos();

	public TelaAdicionarContato() {
		super();
		addJLabelTitulo();
		addJButtonAdicionar();
	}

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Adicionar Contato");
		jbTitulo.setBounds(0, 30, 380, 30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		add(jbTitulo);
	}

	private void addJButtonAdicionar() {
		JButton jbAdd = new JButton("Adicionar");
		jbAdd.setBounds(120, 320, 100, 40);
		OuvinteAdd ouvinte = new OuvinteAdd();
		jbAdd.addActionListener(ouvinte);
		add(jbAdd);

	}

	private class OuvinteAdd implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (jtfNome == null || jtfNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Necessário informar o nome!");
			} else {
				ContatoDTO c = new ContatoDTO(nome, ddd, numero);
				ContatoDAO.getInstance().cadastrarContato(c);
				JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
				dispose();
				new TelaInicial("");
			}
		}
	}
}
