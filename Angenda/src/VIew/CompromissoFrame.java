package VIew;

import javax.swing.*;

import Controller.ContatoController;
import Model.Contato;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class CompromissoFrame extends JFrame {

    private JLabel lbData, lbHora, lbContato, lbObservacao;
    private JTextField txtData, txtHora, txtContato, txtObservacao, txtLocalizar;
    private JButton btnSalvar, btnAlterar, btnExcluir, btnClear, btnLocalizar;
    private JButton btnPrimeiro, btnProximo, btnAnterior, btnUltimo;

    private List contatoList = new ContatoController().listaContatos();
    private int registroAtual = 0;
	private Long key;

    public CompromissoFrame() {
        super("Compromissos");
        Container tela = getContentPane();
        setLayout(null);
        lbData = new JLabel("Data do compromisso (dd/mm/aaaa)");
        lbHora = new JLabel("Hora do compromisso (HH:mm)");
        lbContato = new JLabel("Contato");
        lbObservacao = new JLabel("Observacao");

        lbData.setBounds(10, 10, 240, 15);
        lbHora.setBounds(10, 50, 240, 15);
        lbContato.setBounds(10, 90, 240, 15);
        lbObservacao.setBounds(10, 130, 240, 15);

        lbData.setForeground(Color.BLACK);
        lbHora.setForeground(Color.BLACK);
        lbContato.setForeground(Color.BLACK);
        lbObservacao.setForeground(Color.BLACK);

        lbData.setFont(new Font("Courier New", Font.BOLD, 14));
        lbHora.setFont(new Font("Courier New", Font.BOLD, 14));
        lbContato.setFont(new Font("Courier New", Font.BOLD, 14));
        lbObservacao.setFont(new Font("Courier New", Font.BOLD, 14));

        tela.add(lbData);
        tela.add(lbHora);
        tela.add(lbContato);
        tela.add(lbObservacao);

        txtData= new JTextField();
        txtData= new JTextField();
        txtContato= new JTextField();
        txtObservacao = new JTextField();

        txtData.setBounds(10, 25, 265, 20);
        txtHora.setBounds(10, 65, 265, 20);
        txtContato.setBounds(10, 105, 265, 20);

        tela.add(txtData);
        tela.add(txtHora);
        tela.add(txtContato);

        btnSalvar = new JButton("Salvar");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");
        btnClear = new JButton("Limpar");
        btnPrimeiro = new JButton("|<");
        btnAnterior = new JButton("<<");
        btnProximo = new JButton(">>");
        btnUltimo = new JButton(">|");

        btnSalvar.setBounds(280, 25, 80, 20);
        btnAlterar.setBounds(280, 65, 80, 20);
        btnExcluir.setBounds(280, 105, 80, 20);

        tela.add(btnSalvar);
        tela.add(btnAlterar);
        tela.add(btnExcluir);

        btnPrimeiro.setBounds(10, 135, 50, 20);
        btnAnterior.setBounds(60, 135, 50, 20);
        btnClear.setBounds(110, 135, 75, 20);
        btnProximo.setBounds(185, 135, 50, 20);
        btnUltimo.setBounds(235, 135, 50, 20);

        tela.add(btnPrimeiro);
        tela.add(btnAnterior);
        tela.add(btnClear);
        tela.add(btnProximo);
        tela.add(btnUltimo);

        JLabel lbLocalizar = new JLabel("Localizar por nome");
        lbLocalizar.setBounds(10, 160, 220, 20);

        txtLocalizar = new JTextField();
        txtLocalizar.setBounds(10, 180, 220, 20);

        btnLocalizar = new JButton("Ir");
        btnLocalizar.setBounds(230, 180, 55, 20);

        tela.add(lbLocalizar);
        tela.add(txtLocalizar);
        tela.add(btnLocalizar);

        setSize(400, 250);
        setVisible(true);
        setLocationRelativeTo(null);

        btnSalvar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickSalvar();
                    }
                }
        );

        btnAlterar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickAlterar();
                    }
                }
        );

        btnExcluir.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickExcluir();
                    }
                }
        );

        btnClear.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        clearFields();
                        registroAtual = 0;
                    }
                }
        );

        btnLocalizar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickLocalizar();
                    }
                }
        );

        btnPrimeiro.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickPrimeiro();
                    }
                }
        );
        btnAnterior.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickAnterior();
                    }
                }
        );

        btnProximo.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickProximo();
                    }
                }
        );

        btnUltimo.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickUltimo();
                    }
                }
        );
    }

    private void onClickUltimo() {
        registroAtual = contatoList.size() - 1;
        getValores(registroAtual);
    }

    private void onClickProximo() {
        if (registroAtual != contatoList.size() - 1) {
            getValores(++registroAtual);
        }
    }

    private void onClickAnterior() {
        if (registroAtual != 0) {
            getValores(--registroAtual);
        }
    }

    private void onClickPrimeiro() {
        registroAtual = 0;
        getValores(registroAtual);
    }

    private void getValores(int index) {
        if (index <= contatoList.size() - 1) {
            Contato contatoAtual = (Contato) contatoList.get(index);
            txtData.setText(contatoAtual.getNome());
            txtHora.setText(contatoAtual.getApelido());
            txtContato.setText(
				new SimpleDateFormat("dd/MM/yyyy").format(contatoAtual.getDtNascimento())
			);
        }
    }

    private void onClickAlterar() {
        ContatoController cc = new ContatoController();
       
		long id = 0L;
		
		if (key == null) {
            id = ((Contato) contatoList.get(registroAtual)).getId();
        } else {
            id = key;
            key = null;
        }
		
        try {
            cc.alterar(id, txtData.getText(), txtHora.getText(), txtContato.getText());
            JOptionPane.showMessageDialog(this, "Comrpomisso alterado com sucesso!");
            clearFields();
            contatoList = new ContatoController().listaContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel alterar contato!n" + e.getLocalizedMessage());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data possui formato inv�lido!n" + e.getLocalizedMessage());
        }
    }

    private void onClickSalvar() {
        ContatoController cc = new ContatoController();
        try {
            cc.salvar(txtData.getText(), txtHora.getText(), txtContato.getText());
            JOptionPane.showMessageDialog(this, "Compromisso salvo com sucesso!");
            clearFields();
            contatoList = new ContatoController().listaContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
				"Nao foi possivel salvar contato!n" + 
				e.getLocalizedMessage()
			);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, 
				"Data possui formato invalido!" + 
				e.getLocalizedMessage()
		);
        }
    }

    private void onClickExcluir() {
        ContatoController cc = new ContatoController();
        long id = ((Contato) contatoList.get(registroAtual)).getId();
        try {
            cc.excluir(id);
            JOptionPane.showMessageDialog(this, "Contato excluido com sucesso!");
            clearFields();
            contatoList = new ContatoController().listaContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
				"Nao foi possivel excluir o contato!n" + 
				e.getLocalizedMessage()
			);
        }
    }

    private void onClickLocalizar() {
        ContatoController cc = new ContatoController();
        try {
            Contato c = cc.buscaContatoPorNome(txtLocalizar.getText());
            txtData.setText(c.getNome());
            txtHora.setText(c.getApelido());
            txtContato.setText(
				new SimpleDateFormat("dd/MM/yyyy").format(c.getDtNascimento())
			);
			key = c.getId();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
				"Ocorreu um erro, tente novamente!n" + 
				e.getLocalizedMessage()
			);
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, 
				"Contato nao localizdo ou nao existe!n" + 
				e.getLocalizedMessage()
			);
        }
    }

    private void clearFields() {
        txtData.setText("");
        txtHora.setText("");
        txtContato.setText("");
        txtLocalizar.setText("");
    }

    public static void main(String[] args) {
        CompromissoFrame frame = new CompromissoFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}