package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import DAO.ContatoDAO;
import Model.Contato;

public class TelaEditarContato extends TelaGenericaContato {

	private Contato contatoEditar;

	List<Contato> listaDeContatos = ContatoDAO.getInstance().getContatos();

	private JTable tabela;

	public TelaEditarContato(Contato contatoEditar, JTable tabela) {
		super();
		this.tabela = tabela;
		this.contatoEditar = contatoEditar;
		jtfNome.setText(contatoEditar.getNome());
		jtfDDD.setText(contatoEditar.getDDD());
		jtfNumero.setText(contatoEditar.getNumero());
		addJLabelTitulo();
		addJButtonEditar();
	}

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Editar Contato");
		jbTitulo.setBounds(0, 30, 380, 30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		add(jbTitulo);
	}

	private void addJButtonEditar() {
		JButton jbEdit = new JButton("Editar");
		jbEdit.setBounds(120, 320, 100, 40);
		OuvinteEdit ouvinte = new OuvinteEdit();
		jbEdit.addActionListener(ouvinte);
		add(jbEdit);

	}

	private class OuvinteEdit implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (jtfNome == null || jtfNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Necessário informar o nome!");
			} else {
				boolean edicao = ContatoDAO.getInstance().editarContato(contatoEditar, new Contato(nome, ddd, numero));
				if (edicao == true) {
					JOptionPane.showMessageDialog(null, "Contato editado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível editar o contato!");
				}

				dispose();
				new TelaInicial("");
			}
		}
	}
}
