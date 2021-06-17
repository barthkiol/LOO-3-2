package telas;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import classes.Cerveja;
import classes.Tipo;
import dao.CervejaDao;
import dao.TipoDao;
import java.awt.Color;

public class CervejaNew extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void telaNCer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CervejaNew frame = new CervejaNew();
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
	public CervejaNew() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 221, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 27, 46, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(43, 24, 111, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(43, 68, 111, 20);
		contentPane.add(comboBox);
		TipoDao tipoD = new TipoDao();
		try {
			for (Tipo t : tipoD.consultar()) {
				
				comboBox.addItem(t);
			}
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 71, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblDesc = new JLabel("Descri\u00E7\u00E3o:");
		lblDesc.setBounds(10, 127, 95, 14);
		contentPane.add(lblDesc);
		
		JTextPane textPaneDesc = new JTextPane();
		textPaneDesc.setBounds(10, 141, 181, 76);
		contentPane.add(textPaneDesc);
		
		JButton btnNovaCer = new JButton("Criar");
		btnNovaCer.setBackground(Color.GREEN);
		btnNovaCer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tipo tipoTemp = (Tipo) comboBox.getSelectedItem();				
				String descTemp = textPaneDesc.getText();
				String nome = textNome.getText();
				Cerveja cerveja = new Cerveja();
				cerveja.setNome(nome);
				cerveja.setDescricao(descTemp);
				cerveja.setTipo(tipoTemp);
				CervejaDao dao = new CervejaDao();
				try {
					dao.salvar(cerveja);
					JOptionPane.showMessageDialog(null, "Cerveja criada com sucesso!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
			}
		});
		btnNovaCer.setBounds(54, 239, 89, 23);
		contentPane.add(btnNovaCer);
		
		
	}
}
