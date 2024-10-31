package testeTelas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaAdicionarContato extends TelaGenericaContato{
	ArrayList<Contato> listaDeContatos = new ArrayList<Contato>();//TODOS OS ARRAYS SAO TEMPORARIOS, BOTEI SO PRA RODAR A TELA, AI TU RESOLVE AI.
	public TelaAdicionarContato() {
		super();
		addJLabelTitulo();
		addJButtonAdicionar();
	}
	
	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Adicionar Contato");
		jbTitulo.setBounds(0,30,380,30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial",Font.BOLD,20));
		add(jbTitulo);
	}
	
	private void addJButtonAdicionar() {
		JButton jbAdd = new JButton("Adicionar");
		jbAdd.setBounds(120,320,100,40);
		OuvinteAdd ouvinte = new OuvinteAdd(); 
		jbAdd.addActionListener(ouvinte);
		add(jbAdd);
		
	}
	private class OuvinteAdd implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(jtfNome==null || jtfNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Necessário informar o nome!");
			}else {
				Contato c = new Contato(nome, email, numero);
				listaDeContatos.add(c);
				JOptionPane.showMessageDialog(null,"Contato adicionado com sucesso!");
				dispose();
			}
		}	
	}
}
