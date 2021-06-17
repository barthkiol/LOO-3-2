package telas;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classes.Cerveja;
import classes.Tipo;
import classes.Usuario;
import dao.CervejaDao;
import dao.TipoDao;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;

public class MenuUser extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textNome;
	private JLabel lblNome;
	private JLabel lblTipo;
	private JButton btnPesquisar;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void telaMenuUser(Usuario user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUser frame = new MenuUser(user);
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
	public MenuUser(Usuario user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 443, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                "Nome", "Descricao", "Tipo"
                }
                ));
		table.setBounds(26, 61, 265, 173);		
        
        //contentPane.add(table);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(26, 61, 265, 173);
        contentPane.add(scroll);
		
		JButton btnFavoritar = new JButton("Favoritar");
		btnFavoritar.setBackground(Color.GREEN);
		btnFavoritar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = table.getSelectedRow();
				String nome = (String)table.getValueAt(linha, 0);
				String desc = (String)table.getValueAt(linha, 1);
				Tipo tipo = (Tipo)table.getValueAt(linha, 2);
				Cerveja cer = new Cerveja();
				CervejaDao dao = new CervejaDao();
				cer = dao.getCerveja(nome);
				try {
					dao.favoritar(cer, user);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnFavoritar.setBounds(316, 80, 89, 23);
		contentPane.add(btnFavoritar);
		
		textNome = new JTextField();
		textNome.setBounds(26, 23, 86, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(26, 11, 46, 14);
		contentPane.add(lblNome);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(122, 11, 86, 14);
		contentPane.add(lblTipo);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomePesquisa = textNome.getText();
				Tipo tipoPesquisa = (Tipo)comboBox.getSelectedItem();
				int idPesquisa = tipoPesquisa.getId();
				listaCervejas(nomePesquisa, idPesquisa);
			}
		});
		btnPesquisar.setBounds(234, 22, 89, 23);
		contentPane.add(btnPesquisar);
		
		comboBox = new JComboBox();
		comboBox.setBounds(122, 22, 86, 20);
		contentPane.add(comboBox);
		TipoDao tipoD = new TipoDao();
		Tipo cbNulo = new Tipo(0, "  ");
		comboBox.addItem(cbNulo);
		try {
			for (Tipo t : tipoD.consultar()) {
				
				comboBox.addItem(t);
			}
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
	}
	
	private DefaultTableModel getModelo() {
        String[][] linhas= new String[][] {{"Itaipava", "Descricao", "Pilsen"}};
        String[] colunas = new String []{"Nome", "Descricao", "Tipo"};
        return new DefaultTableModel(linhas, colunas);
        }

//	private void listaCervejas() {
//        // Carregar o model na JTable
//        DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
//        modelo.setRowCount(0);
//        table.setModel(modelo);
//        
//        CervejaDao dao = new CervejaDao();
//        try {
//            List<Cerveja>  lista  = dao.consultar();
//            
//            for (Cerveja cerveja : lista) {
//                modelo.addRow(
//                        new Object[] {
//                                cerveja.getNome(),
//                                cerveja.getDescricao(),
//                                cerveja.getTipo()
//                        }
//                    );
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,  "Erro consultando: "+e.getMessage());
//        }
//    }
	
	private void listaCervejas(String nome, Integer id) {
        // Carregar o model na JTable
        DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
        modelo.setRowCount(0);
        table.setModel(modelo);
        
        CervejaDao dao = new CervejaDao();
        try {
            List<Cerveja>  lista  = dao.pesquisaPerso(nome, id);
            
            for (Cerveja cerveja : lista) {
                modelo.addRow(
                        new Object[] {
                                cerveja.getNome(),
                                cerveja.getDescricao(),
                                cerveja.getTipo()
                        }
                    );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  "Erro consultando: "+e.getMessage());
        }
    }
}
