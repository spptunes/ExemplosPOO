package Telas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaPrincipal extends JFrame{
	 JButton btaposentos, btfuncionario;
	 
	 public  TelaPrincipal(){
		 super("Tela Principal");
		 btaposentos = new JButton("Aponsentos");
		 btfuncionario = new JButton("Funcionario");
		 
		 
		 Container telaPrincipal = getContentPane();
		 
		 setLayout (null);
		 setVisible(true);
		 setSize (600, 500);
		 
		 
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 confbtaposentos();
		 confbtfuncionario();
		 
		 
	 }
	 
	 public void confbtaposentos(){
		add(btaposentos);
		btaposentos.setBounds(40, 60, 150,100);
		btaposentos.addActionListener (new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Aposentos aposentos = new Aposentos();
		        aposentos.setVisible(true);
				}
			 });
		 
	 }
	 
	 public void confbtfuncionario() {
		 add(btfuncionario);
		 btfuncionario.setBounds(40, 170, 150, 100);
		 btfuncionario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Funcionarios funcionarios = new Funcionarios();
				funcionarios.setVisible(true);
				
			}
			 
		 });
	 }
	 
	 public static void main (String []args){
		 new TelaPrincipal();
	 }
	


}