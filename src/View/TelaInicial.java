package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO.ContatoDAO;
import Model.Contato;

public class TelaInicial extends JFrame {

	protected JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane painelTabela;

	private ContatoDAO contatoDAO = ContatoDAO.getInstance();

	public TelaInicial(String contatos) {
		setTitle("Menu Inicial");
		setSize(480, 550);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addJLabelTitulo();
		addTabelaContatos();
		addJButtonAdicionar();
		addJButtonEditar();
		addJButtonDeletar();
		addJButtonVisualizar();
		addJButtonLixeira();
		popularTabela(contatos);
		setVisible(true);
	}

	private void addTabelaContatos() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Nome", "DDD", "Número" });
		tabela = new JTable(modelo);
		tabela.setFont(new Font("Arial", Font.PLAIN, 17));
		painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(30, 80, 410, 290);
		add(painelTabela);
	}

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Lista de Contatos");
		jbTitulo.setBounds(0, 30, 480, 30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));

		add(jbTitulo);
	}

	private void addJButtonAdicionar() {
		JButton jbADD = new JButton("Adicionar");
		jbADD.setBounds(345, 380, 95, 50);
		OuvinteAdicionar ouvinte = new OuvinteAdicionar();
		jbADD.addActionListener(ouvinte);
		add(jbADD);

	}
	
	private void addJButtonLixeira() {
		JButton jbLixo = new JButton("Lixeira♻️");
		jbLixo.setBounds(345, 440, 95, 50);
		OuvinteLixeira ouvinte = new OuvinteLixeira();
		jbLixo.addActionListener(ouvinte);
		add(jbLixo);

	}

	private void addJButtonEditar() {
		JButton jbEditar = new JButton("Editar");
		jbEditar.setBounds(240, 380, 95, 50);
		OuvinteEditar ouvinte = new OuvinteEditar();
		jbEditar.addActionListener(ouvinte);
		add(jbEditar);

	}

	private void addJButtonDeletar() {
		JButton jbDeletar = new JButton("Deletar");
		jbDeletar.setBounds(135, 380, 95, 50);
		OuvinteDeletar ouvinte = new OuvinteDeletar();
		jbDeletar.addActionListener(ouvinte);
		add(jbDeletar);

	}

	private void addJButtonVisualizar() {
		JButton jbView = new JButton("Visualizar");
		jbView.setBounds(30, 380, 95, 50);
		OuvinteVisualizar ouvinte = new OuvinteVisualizar();
		jbView.addActionListener(ouvinte);
		add(jbView);

	}

	private class OuvinteVisualizar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (tabela.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um contato");
			} else {
				Contato contatoSelecionado = contatoDAO.getContatos().get(tabela.getSelectedRow());
				dispose();
				new TelaVisualizarContato(contatoSelecionado);

			}
		}

	}
	
	private void popularTabela(String contatos) {
		
		if(contatos.equalsIgnoreCase("")) {
			for (Contato a : contatoDAO.getContatos()) {
				adicionarLinhaTabela(a);
			}
		} else if(contatos.equalsIgnoreCase("deletados")) {
			for (Contato a : contatoDAO.getContatosDeletados()) {
				adicionarLinhaTabela(a);
			}
		}

		

	}

	public void adicionarLinhaTabela(Contato contato) {

		Object[] linha = new Object[3];
		linha[0] = contato.getNome();
		linha[1] = contato.getDDD();
		linha[2] = contato.getNumero();

		modelo.addRow(linha);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		for (int i = 0; i < modelo.getColumnCount(); i++) {
			tabela.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
	}

	private class OuvinteEditar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (tabela.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um contato");
			} else {
				Contato contatoSelecionado = contatoDAO.getContatos().get(tabela.getSelectedRow());
				dispose();
				new TelaEditarContato(contatoSelecionado, tabela);

			}
		}
	}

	private class OuvinteLixeira implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dispose();
			new TelaInicial("deletados");

		}
	}
	
	private class OuvinteAdicionar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dispose();
			new TelaAdicionarContato();

		}
	}

	private class OuvinteDeletar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (tabela.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um contato");
			} else {
				contatoDAO.deletarContato(tabela.getSelectedRow());
				repaint();
				dispose();
				new TelaInicial("");
			}
		}

	}

}
