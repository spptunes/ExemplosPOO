package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
//import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.GridLayout;

public class EmprestarLivros extends JFrame {
    private JPanel panelTitulo, panelDadosFunc, panelLbDadosFunc, panelDadosLivro, panelLbDadosLivro, panelTabela;
    private static JTable tabela;
    private static String[] colunas = { "N° Exemplar", "Nome", "Editora", "Acao" };
    private static Object[][] dados = {};

    private JLabel lbTitulo, lbAdvocacia, lbEmprestar, lbData,
            lbDadosFunc, lbDadosLivro, lbMatricula, lbOAB, lbNome, lbNExemplar;

    private JButton btPesquisar, btLimpar, btSalvar;

    private ImageIcon imgBtPesquisar = new ImageIcon(getClass().getResource("bt pesquisar.png")),
            imgBtLimpar = new ImageIcon(getClass().getResource("bt limpar.png")),
            imgBtSalvar = new ImageIcon(getClass().getResource("bt salvar.png"));

    private JTextField txtMatricula, txtOAB, txtNome, txtNExemplar;

    // Construtor
    public EmprestarLivros() {

        // Instanciacao dos componentes do painel Título
        panelTitulo = new JPanel();
        lbTitulo = new JLabel("Sistema para Controle de Biblioteca");
        lbAdvocacia = new JLabel("BWS Advocacia");
        lbEmprestar = new JLabel("Emprestar Livros");

        // Instanciacao do painel Dados do Funcionario
        panelLbDadosFunc = new JPanel();
        panelDadosFunc = new JPanel();
        lbDadosFunc = new JLabel("Dados do Funcionário");
        txtMatricula = new JTextField();
        lbMatricula = new JLabel("Matrícula");
        txtOAB = new JTextField();
        lbOAB = new JLabel("Número OAB");
        txtNome = new JTextField();
        lbNome = new JLabel("Nome");
        btLimpar = new JButton(imgBtLimpar);

        // instanciacao do painel Dados dos Livros
        panelLbDadosLivro = new JPanel();
        panelDadosLivro = new JPanel();
        lbDadosLivro = new JLabel("Dados dos Livros");
        txtNExemplar = new JTextField();
        lbNExemplar = new JLabel("N° Exemplar");

        // instanciacao do painel da tabela dos livros
        panelTabela = new JPanel();

        // instanciacao do botao Salvar
        btSalvar = new JButton(imgBtSalvar);

        // container
        Container cont = getContentPane();
        cont.setBackground(new Color(248, 248, 248));

        cont.add(panelTitulo);
        cont.add(panelDadosFunc);
        cont.add(panelLbDadosFunc);
        cont.add(panelLbDadosLivro);
        cont.add(panelDadosLivro);
        cont.add(panelTabela);

        // título Dados do Funcionario

        configPanelTitulo();
        confingLbDadosFunc();
        configPanelDadosFunc();
        configPanelDadosLivro();
        configLbDadosLivro();
        configPanelTabela();
        configBtSalvar();

        setSize(1020, 720);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Configura Painel do Titulo
    public void configPanelTitulo() {
        panelTitulo.setLayout(null);
        panelTitulo.setBounds(50, 10, 900, 90);
        panelTitulo.setBackground(new Color(243, 243, 243));
        panelTitulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(236, 236, 236), 1, true));
        // panelTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbTitulo.setBounds(240, 33, 500, 30);
        lbTitulo.setFont(new Font("Helvetica", Font.BOLD, 25));
        lbTitulo.setForeground(new Color(61, 61, 61));
        panelTitulo.add(lbTitulo);

        lbAdvocacia.setBounds(10, 7, 150, 20);
        lbAdvocacia.setFont(new Font("Helvetica", Font.BOLD, 15));
        lbAdvocacia.setForeground(new Color(61, 61, 61));
        panelTitulo.add(lbAdvocacia);

        lbEmprestar.setBounds(10, 65, 150, 20);
        lbEmprestar.setFont(new Font("Helvetica", Font.BOLD, 15));
        lbEmprestar.setForeground(new Color(61, 61, 61));
        panelTitulo.add(lbEmprestar);

    }

    // Configura Titulo do Painel dos Dados dos Funcionario
    public void confingLbDadosFunc() {
        panelLbDadosFunc.setLayout(null);
        panelLbDadosFunc.setBounds(50, 115, 900, 70);

        panelLbDadosFunc.setOpaque(false);

        lbDadosFunc.setBounds(0, 10, 230, 30);
        lbDadosFunc.setFont(new Font("Helvetica", Font.BOLD, 20));
        lbDadosFunc.setForeground(new Color(61, 61, 61));
        lbDadosFunc.setVisible(true);
        panelLbDadosFunc.add(lbDadosFunc);

    }

    // Configura Painel dos Dados do Funcionario
    public void configPanelDadosFunc() {
        panelDadosFunc.setLayout(null);
        panelDadosFunc.setBounds(50, 155, 900, 90);
        panelDadosFunc.setBackground(new Color(243, 243, 243));
        panelDadosFunc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(236, 236, 236), 1, true));
        panelDadosFunc.setLayout(null);

        // campo Matricula
        txtMatricula.setBounds(10, 32, 100, 30);
        lbMatricula.setBounds(10, -1, 150, 50);
        lbMatricula.setFont(new Font("Helvetica", Font.BOLD, 15));
        lbMatricula.setForeground(new Color(61, 61, 61));

        btPesquisar = new JButton(imgBtPesquisar);
        btPesquisar.setBounds(100, 32, 180, 30);
        btPesquisar.setBorderPainted(false);
        btPesquisar.setFocusable(false);
        btPesquisar.setContentAreaFilled(false);

        txtOAB.setBounds(272, 32, 130, 30);
        lbOAB.setBounds(272, -1, 150, 50);
        lbOAB.setFont(new Font("Helvetica", Font.BOLD, 15));
        lbOAB.setForeground(new Color(61, 61, 61));

        txtNome.setBounds(425, 32, 300, 30);
        lbNome.setBounds(425, -1, 150, 50);
        lbNome.setFont(new Font("Helvetica", Font.BOLD, 15));
        lbNome.setForeground(new Color(61, 61, 61));

        btLimpar.setBounds(735, 32, 130, 30);
        btLimpar.setBorderPainted(false);
        btLimpar.setFocusable(false);
        btLimpar.setContentAreaFilled(false);

        panelDadosFunc.add(txtMatricula);
        panelDadosFunc.add(lbMatricula);
        panelDadosFunc.add(btPesquisar);
        panelDadosFunc.add(txtOAB);
        panelDadosFunc.add(lbOAB);
        panelDadosFunc.add(txtNome);
        panelDadosFunc.add(lbNome);
        panelDadosFunc.add(btLimpar);
    }

    // Configura título do painel Dados dos Livros
    public void configLbDadosLivro() {
        panelLbDadosLivro.setLayout(null);
        panelLbDadosLivro.setBounds(50, 270, 900, 70);
        panelLbDadosLivro.setOpaque(false);
        panelLbDadosLivro.setLayout(null);

        lbDadosLivro.setBounds(0, 10, 230, 30);
        lbDadosLivro.setFont(new Font("Helvetica", Font.BOLD, 20));
        lbDadosLivro.setForeground(new Color(61, 61, 61));
        // lbDadosLivro.setVisible(true);
        panelLbDadosLivro.add(lbDadosLivro);

    }

    // Configura painel dos Dados dos Livros
    public void configPanelDadosLivro() {
        panelDadosLivro.setBounds(50, 310, 900, 90);
        panelDadosLivro.setBackground(new Color(243, 243, 243));
        panelDadosLivro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(236, 236, 236), 1, true));
        panelDadosLivro.setLayout(null);

        txtNExemplar.setBounds(10, 32, 100, 30);
        lbNExemplar.setBounds(10, -1, 150, 50);
        lbNExemplar.setFont(new Font("Helvetica", Font.BOLD, 15));
        lbNExemplar.setForeground(new Color(61, 61, 61));

        btPesquisar = new JButton(imgBtPesquisar);
        btPesquisar.setBounds(100, 32, 180, 30);
        btPesquisar.setBorderPainted(false);
        btPesquisar.setFocusable(false);
        btPesquisar.setContentAreaFilled(false);

        panelDadosLivro.add(txtNExemplar);
        panelDadosLivro.add(lbNExemplar);
        panelDadosLivro.add(btPesquisar);

    }

    public void configPanelTabela() {
        panelTabela.setBounds(50, 405, 900, 210);
        panelTabela.setBackground(new Color(243, 243, 243));
        panelTabela.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(236, 236, 236), 1, true));
        panelTabela.setLayout(new GridLayout(1, 1));

        TableModel tableModel = new DefaultTableModel(dados, colunas);
        tabela = new JTable(tableModel);
        JScrollPane barraRolagem = new JScrollPane(tabela);

        panelTabela.add(barraRolagem);
    }

    public void configBtSalvar() {
        btSalvar.setBounds(445, 625, 130, 30);
        btSalvar.setBorderPainted(false);
        btSalvar.setFocusable(false);
        btSalvar.setContentAreaFilled(false);
        add(btSalvar);

    }

    public static void main(String[] args) {
        new EmprestarLivros();
    }

}
