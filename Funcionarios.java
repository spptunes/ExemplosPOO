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
import Model.Funcionario;

public class Funcionarios extends JFrame{
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnRemover;
	private static JTable tabela;
	private static String [] colunas = {"Codigo", "Nome", "Cargo", "Salario", "CPF", "Telefone"};
	
	private static Object [][] dados = {};

	public Funcionarios() {
		super("Funcionarios");
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
							int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o(a) funcionario(a)?");
							
							if(resposta == JOptionPane.YES_OPTION) {
								 Funcionario funcionario = BancoDeDados.getFuncionarios().get(linhaSelecionada);
						         BancoDeDados.removeFuncionario(funcionario);

						         atualizaTabela();
							}
						}else {
							JOptionPane.showMessageDialog(null, "e necessario selecionar um funcionario", "Funcionario",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
		
	}
	
	public static void atualizaTabela(){
        TableModel tTabela = (DefaultTableModel) tabela.getModel();
        ((DefaultTableModel) tTabela).setNumRows(0);

        List<Funcionario> funcionarios = BancoDeDados.getFuncionarios();

        for (int linha = 0; linha < funcionarios.size(); linha++){
            Funcionario funcionario = funcionarios.get(linha);

            ((DefaultTableModel) tTabela).addRow(new Object[]{1});

            tabela.setValueAt(funcionario.getCodigo(), linha, 0);
            tabela.setValueAt(funcionario.getNome(), linha, 1);
            tabela.setValueAt(funcionario.getCargo(), linha, 2);
            tabela.setValueAt(funcionario.getSalario(), linha, 3);
        }

    }

}

