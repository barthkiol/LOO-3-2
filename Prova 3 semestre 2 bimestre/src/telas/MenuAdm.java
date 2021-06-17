package telas;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Admnistrador;
import java.awt.Color;

public class MenuAdm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void telaMenuAdm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdm frame = new MenuAdm();
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
	public MenuAdm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 240, 196);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCerveja = new JButton("Cerveja");
		btnCerveja.setBackground(Color.ORANGE);
		btnCerveja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CervejaNew telaCerNew = new CervejaNew();
				telaCerNew.telaNCer();
			}
		});
		btnCerveja.setBounds(56, 105, 89, 23);
		contentPane.add(btnCerveja);
		
		JButton btnTipo = new JButton("Tipo");
		btnTipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tipos telaTipo = new Tipos();
				telaTipo.tipoTela();
			}
		});
		btnTipo.setBounds(56, 39, 89, 23);
		contentPane.add(btnTipo);
	}

}
