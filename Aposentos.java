package Telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Hotel.BancoDeDados;
import Model.Aposento;

public class Aposentos extends JFrame{
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnRemover;
	private static JTable tabela;
	private static String [] colunas = {"C�digo", "N�mero", "Descri��o", "Valor"};
	
	private static Object [][] dados = {};

	public Aposentos() {
		super("Aposentos");
		initComponents();
        atualizaTabela();
	}
	
	private void initComponents() {
		btnNovo = new JButton("Novo");
		btnNovo.setToolTipText("Novo");
		btnAlterar = new JButton("Alterar");
		btnAlterar.setToolTipText("Alterar");
		btnRemover = new JButton("Remover");
		btnRemover.setToolTipText("Remover");
		
		TableModel tableModel = new DefaultTableModel(dados,colunas);
		//tabela = new JTable(dados,colunas);
		tabela = new JTable(tableModel);
		JScrollPane barraRolagem = new JScrollPane(tabela);		
		
		setLayout(null);
		add(btnNovo);
		add(btnAlterar);
		add(btnRemover);
		getContentPane().add(barraRolagem);
		
		btnNovo.setBounds(10, 10, 100, 20);
		btnAlterar.setBounds(105, 10, 100, 20);
		btnRemover.setBounds(205, 10, 100, 20);
		barraRolagem.setBounds(10,40,300,100);
		setSize(400,200);
		
		btnNovo.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						InserirAposento janela = new InserirAposento();
						janela.setVisible(true);
					}
				});
		
		btnAlterar.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						int linhaSelecionada = tabela.getSelectedRow();
						
						if(linhaSelecionada >= 0) {
							AlterarAposento janelaAlterar = new AlterarAposento(linhaSelecionada);
							janelaAlterar.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "� necess�rio selecionar um aposento", "Aposento",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
		
		btnRemover.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						int linhaSelecionada = tabela.getSelectedRow();
						
						if(linhaSelecionada >= 0) {
							int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o aposento?");
							
							if(resposta == JOptionPane.YES_OPTION) {
								 Aposento aposento = BancoDeDados.getAposentos().get(linhaSelecionada);
						         BancoDeDados.removeAposento(aposento);

						         atualizaTabela();
							}
						}else {
							JOptionPane.showMessageDialog(null, "� necess�rio selecionar um aposento", "Aposento",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
		
	}
	
	public static void atualizaTabela(){
        TableModel tTabela = (DefaultTableModel) tabela.getModel();
        ((DefaultTableModel) tTabela).setNumRows(0);

        List<Aposento> aposentos = BancoDeDados.getAposentos();

        for (int linha = 0; linha < aposentos.size(); linha++){
            Aposento aposento = aposentos.get(linha);

            ((DefaultTableModel) tTabela).addRow(new Object[]{1});

            tabela.setValueAt(aposento.getCodigo(), linha, 0);
            tabela.setValueAt(aposento.getNumero(), linha, 1);
            tabela.setValueAt(aposento.getDescricao(), linha, 2);
            tabela.setValueAt(aposento.getValor(), linha, 3);
        }

    }
}
