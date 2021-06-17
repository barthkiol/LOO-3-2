package telas;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classes.Tipo;
import dao.TipoDao;
import java.awt.Color;

public class NovoTipo extends JFrame {

	private JPanel contentPane;
	private JTextField textTipo;

	/**
	 * Launch the application.
	 */
	public static void novoTipoCer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoTipo frame = new NovoTipo();
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
	public NovoTipo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 296, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textTipo = new JTextField();
		textTipo.setBounds(33, 67, 115, 20);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBackground(Color.GREEN);
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomeTipo = textTipo.getText();
				Tipo tipo = new Tipo();
				tipo.setNome(nomeTipo);
				TipoDao dao = new TipoDao();
				try {
					dao.salvar(tipo);
					JOptionPane.showMessageDialog(null, "Tipo Criado");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnCriar.setBounds(170, 66, 89, 23);
		contentPane.add(btnCriar);
		
		
	}

}
