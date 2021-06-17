package telas;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classes.Usuario;
import dao.UsuarioDao;
import java.awt.Color;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JPasswordField psswSenha;

	/**
	 * Launch the application.
	 */
	public static void telaCadastro() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 227, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 65, 54, 14);
		contentPane.add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(10, 123, 46, 14);
		contentPane.add(lblSenha);
		
		textNome = new JTextField();
		textNome.setBounds(52, 62, 86, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		psswSenha = new JPasswordField();
		psswSenha.setBounds(52, 120, 86, 20);
		contentPane.add(psswSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.GREEN);
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String senha = psswSenha.getText();
				String nome = textNome.getText();
				Usuario user = new Usuario();
				user.setNome(nome);
				user.setSenha(senha);
				UsuarioDao dao = new UsuarioDao();
				try {
					dao.salvar(user);
					JOptionPane.showMessageDialog(null, "Cadastrado");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnCadastrar.setBounds(49, 192, 89, 23);
		contentPane.add(btnCadastrar);
	}

}
