package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaGenericaContato extends JFrame {

	public TelaGenericaContato() {
		setTitle("");
		setSize(380, 420);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addJButtonVoltar();
		addJLabelNome();
		addJLabelEmail();
		addJLabelNumero();
		addJTextFieldNome();
		addJTextFieldEmail();
		addJTextFieldNumero();
		setVisible(true);
	}

	protected JTextField jtfNome;
	protected JTextField jtfDDD;
	protected JTextField jtfNumero;
	protected String nome;
	protected String ddd;
	protected String numero;

	private void addJLabelNome() {
		JLabel jbNome = new JLabel("Nome: ");
		jbNome.setBounds(30, 90, 120, 30);
		add(jbNome);
	}

	private void addJLabelEmail() {
		JLabel jbNome = new JLabel("DDD: ");
		jbNome.setBounds(30, 160, 120, 30);
		add(jbNome);
	}

	private void addJLabelNumero() {
		JLabel jbNome = new JLabel("Número: ");
		jbNome.setBounds(30, 230, 120, 30);
		add(jbNome);
	}

	private void addJButtonVoltar() {
		JButton jbVoltar = new JButton("Voltar");
		jbVoltar.setBounds(240, 320, 100, 40);
		OuvinteVoltar ouvinte = new OuvinteVoltar();
		jbVoltar.addActionListener(ouvinte);
		add(jbVoltar);

	}

	private class OuvinteVoltar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dispose();
			new TelaInicial("");
		}
	}

	private void addJTextFieldNome() {
		jtfNome = new JTextField();
		jtfNome.setBounds(30, 120, 310, 30);
		OuvinteJTFNome ouvinte = new OuvinteJTFNome();
		jtfNome.addFocusListener(ouvinte);
		add(jtfNome);
	}

	private class OuvinteJTFNome implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
		}

		@Override
		public void focusLost(FocusEvent e) {
			nome = jtfNome.getText();
		}

	}

	private void addJTextFieldEmail() {
		jtfDDD = new JTextField();
		jtfDDD.setBounds(30, 190, 310, 30);
		OuvinteJTFEmail ouvinte = new OuvinteJTFEmail();
		jtfDDD.addFocusListener(ouvinte);
		add(jtfDDD);
	}

	private class OuvinteJTFEmail implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (jtfDDD.getText() == null || jtfDDD.getText().equals(""))
				ddd = "Não informado";
			else {
				ddd = jtfDDD.getText();
			}
		}

	}

	private void addJTextFieldNumero() {
		jtfNumero = new JTextField();
		jtfNumero.setBounds(30, 260, 310, 30);
		OuvinteJTFNum ouvinte = new OuvinteJTFNum();
		jtfNumero.addFocusListener(ouvinte);
		add(jtfNumero);
	}

	private class OuvinteJTFNum implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (jtfNumero.getText() == null || jtfNumero.getText().equals(""))
				numero = "Não informado";
			else {
				numero = jtfNumero.getText();
			}
		}

	}
}
