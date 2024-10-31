package testeTelas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class TelaEditarContato extends TelaGenericaContato {
	ArrayList<Contato> listaDeContatos = new ArrayList<Contato>();//TODOS OS ARRAYS SAO TEMPORARIOS, BOTEI SO PRA RODAR A TELA, AI TU RESOLVE AI.
	private JTable tabela;
	public TelaEditarContato(Contato contato, JTable tabela) {
		super();
		this.tabela = tabela;
		jtfNome.setText(contato.getNome());
		jtfEmail.setText(contato.getEmail());
		jtfNumero.setText(contato.getNumero());
		addJLabelTitulo();
		addJButtonEditar();
	}
	
	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Editar Contato");
		jbTitulo.setBounds(0,30,380,30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial",Font.BOLD,20));
		add(jbTitulo);
	}
	
	private void addJButtonEditar() {
		JButton jbEdit = new JButton("Editar");
		jbEdit.setBounds(120,320,100,40);
		OuvinteEdit ouvinte = new OuvinteEdit();
		jbEdit.addActionListener(ouvinte);
		add(jbEdit);
		
	}
	
	private class OuvinteEdit implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(jtfNome==null || jtfNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Necessário informar o nome!");
			}else {
				Contato c = new Contato(nome, email, numero);
				listaDeContatos.add(tabela.getSelectedRow(), c);
				JOptionPane.showMessageDialog(null,"Contato editado com sucesso!");
				dispose();
			}
		}	
	}
}
