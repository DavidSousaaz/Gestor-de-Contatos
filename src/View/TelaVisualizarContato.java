package View;

import java.awt.Font;

import javax.swing.JLabel;

import Model.Contato;

public class TelaVisualizarContato extends TelaGenericaContato {
	public TelaVisualizarContato(Contato contato) {
		super();
		jtfNome.setText(contato.getNome());
		jtfDDD.setText(contato.getDDD());
		jtfNumero.setText(contato.getNumero());
		jtfNome.setEnabled(false);
		jtfDDD.setEnabled(false);
		jtfNumero.setEnabled(false);
		addJLabelTitulo();
	}

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Visualizar Contato");
		jbTitulo.setBounds(0, 30, 380, 30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		add(jbTitulo);
	}

}
