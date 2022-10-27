package Controller;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Contato;
import dao.ContatoDAO;

public class ContatoController {

    private Date formatarData(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new Date( formatter.parse(data).getTime() );
    }

    public void salvar(String nome, String apelido, String dtNascimento) 
		throws SQLException, ParseException 
	{
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setApelido(apelido);
        contato.setDtNascimento(formatarData(dtNascimento));

        new ContatoDAO().salvar(contato);
    }

    public void alterar(long id, String nome, String apelido, String dtNascimento) 
		throws ParseException, SQLException 
	{
        
		Contato contato = new Contato();
        contato.setId(id);
        contato.setNome(nome);
        contato.setApelido(apelido);
        contato.setDtNascimento(formatarData(dtNascimento));

        new ContatoDAO().alterar(contato);
    }

    public List listaContatos() {
        ContatoDAO dao = new ContatoDAO();
        try {
            return dao.findContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
				"Problemas ao localizar contato" + 
				e.getLocalizedMessage()
			);
        }
        return null;
    }

    public void excluir(long id) throws SQLException {
        new ContatoDAO().excluir(id);
    }

    public Contato buscaContatoPorNome(String nome) throws SQLException {
        ContatoDAO dao = new ContatoDAO();
        return dao.findByName(nome);
    }
}