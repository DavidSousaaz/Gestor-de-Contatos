package testeTelas;

import java.awt.Font;

import javax.swing.JLabel;

public class TelaVisualizarContato extends TelaGenericaContato {
	public TelaVisualizarContato(Contato contato){
		super();
		jtfNome.setText(contato.getNome());
		jtfEmail.setText(contato.getEmail());
		jtfNumero.setText(contato.getNumero());
		jtfNome.setEnabled(false);
		jtfEmail.setEnabled(false);
		jtfNumero.setEnabled(false);
		addJLabelTitulo();
	}
	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Visualizar Contato");
		jbTitulo.setBounds(0,30,380,30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial",Font.BOLD,20));
		add(jbTitulo);
	}

}
