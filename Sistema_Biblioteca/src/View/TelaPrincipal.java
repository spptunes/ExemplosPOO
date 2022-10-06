package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaPrincipal extends JFrame {
	private JPanel paneltitulo, panelDadosFunc, panelDadosLivro, panelTable;
	private JTable tabela;
	private String [] colunas = {"N° Exemplar", "Nome", "Editora", "Ação"};
	private static Object [][] dados = {};
	private JLabel lbTitulo, lbAdvocacia, lbEmprestar, lbData, 
	lbSelecione, lbAutor, lbLivro, lbEditora, lbCampoPesq, lbResultado;
	private JRadioButton BtAutor, BtLivro, BtEditora;
	private JButton btPesquisar, btNovaPesquisa, btSalvar;
	private JTextField TAreaPesq;
	
	public TelaPrincipal(){
		lbTitulo = new JLabel ("Sistema para Controle de Biblioteca");
		lbAdvocacia = new JLabel ("BWS Advocacia");
		lbEmprestar = new JLabel ("Emprestar Livros");
		
		setVisible(true);
		setSize(1920,1080);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
}
