package testeTelas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaInicial extends JFrame{
	
	protected JTable tabela;
	ArrayList<Contato> listaDeContatos = new ArrayList<Contato>();//TODOS OS ARRAYS SAO TEMPORARIOS, BOTEI SO PRA RODAR A TELA, AI TU RESOLVE AI.
	public TelaInicial() {
		setTitle("Menu Inicial");
		setSize(480, 480);
        setLayout(null);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addJLabelTitulo();
		addTabelaEdital();
		addJButtonAdicionar();
		addJButtonEditar();
		addJButtonDeletar();
		addJButtonVisualizar();
		setVisible(true);
	}
	
	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Lista de Contatos");
		jbTitulo.setBounds(0,30,480,30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial",Font.BOLD,20));
		add(jbTitulo);
	}
	
	private void addTabelaEdital() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nome");		
		modelo.addColumn("E-mail");
		modelo.addColumn("Número");
		for(Contato a:listaDeContatos) { 
			Object[] linha = new Object[2];
			linha[0] = a.getNome();
			linha[1] = a.getEmail();
			linha[2] = a.getNumero();
			modelo.addRow(linha);
		}
		tabela = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(30,80,410,290);
		add(painelTabela);
	}
	
	private void addJButtonAdicionar() {
		JButton jbADD = new JButton("Adicionar");
		jbADD.setBounds(345,380,95,50);
		OuvinteAdicionar ouvinte = new OuvinteAdicionar(); 
		jbADD.addActionListener(ouvinte);
		add(jbADD);
		
	}
	private void addJButtonEditar() {
		JButton jbEditar = new JButton("Editar");
		jbEditar.setBounds(240,380,95,50);
		OuvinteEditar ouvinte = new OuvinteEditar(); 
		jbEditar.addActionListener(ouvinte);
		add(jbEditar);
		
	}
	
	private void addJButtonDeletar() {
		JButton jbDeletar = new JButton("Deletar");
		jbDeletar.setBounds(135,380,95,50);
		OuvinteDeletar ouvinte = new OuvinteDeletar(); 
		jbDeletar.addActionListener(ouvinte);
		add(jbDeletar);
		
	}
	
	private void addJButtonVisualizar() {
		JButton jbView= new JButton("Visualizar");
		jbView.setBounds(30,380,95,50);
		OuvinteVisualizar ouvinte = new OuvinteVisualizar(); 
		jbView.addActionListener(ouvinte);
		add(jbView);
		
	}
	
	private class OuvinteVisualizar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(tabela.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null,"Selecione um contato");
			}else {
				Contato contatoSelecionado = listaDeContatos.get(tabela.getSelectedRow());
				new TelaVisualizarContato(contatoSelecionado);
				
			}
		}
		
	}
	
	private class OuvinteEditar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(tabela.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null,"Selecione um contato");
			}else {
				Contato contatoSelecionado = listaDeContatos.get(tabela.getSelectedRow());
				new TelaEditarContato(contatoSelecionado, tabela);
				
			}
		}	
	}
	
	private class OuvinteAdicionar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			new TelaAdicionarContato();

		}
	}
	
	private class OuvinteDeletar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(tabela.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null,"Selecione um contato");
			}else {
				listaDeContatos.remove(tabela.getSelectedRow());				
				dispose();
				new TelaInicial();
			}
		}
		
	}
	
	
}
