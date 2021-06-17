package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.*;
import dao.*;
import bo.*;
import telas.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JPasswordField psswSenha;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(74, 85, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(74, 130, 46, 14);
		contentPane.add(lblSenha);
		
		textNome = new JTextField();
		textNome.setBounds(115, 82, 86, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		psswSenha = new JPasswordField();
		psswSenha.setBounds(115, 127, 86, 20);
		contentPane.add(psswSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(Color.GREEN);
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String senhaTemp = psswSenha.getText();
				String userTemp = textNome.getText();
				Usuario user = new Usuario();
				UsuarioDao dao = new UsuarioDao();
				user = dao.getUsuario(userTemp, senhaTemp);
				Admnistrador adm = new Admnistrador();
				AdmnistradorDao daoAdm = new AdmnistradorDao();
				adm = daoAdm.getAdmnistrador(userTemp, senhaTemp);
				if(user == null) {
					if (adm == null) {
						JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos");
					}
					else {
						System.out.println("certo adm");
						System.out.println(adm);
						MenuAdm menuAdm = new MenuAdm();
						menuAdm.telaMenuAdm();

					}

				}
				else {
					System.out.println("certo apreciador");
					System.out.println(user);
					MenuUser menuU = new MenuUser(user);
					menuU.telaMenuUser(user);
				}
			}
		});
		btnEntrar.setBounds(112, 189, 89, 23);
		contentPane.add(btnEntrar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cadastro cadTela = new Cadastro();
				cadTela.telaCadastro();
			}
		});
		btnCadastrar.setBounds(112, 223, 89, 23);
		contentPane.add(btnCadastrar);
	}
}
