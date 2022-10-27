package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Compromisso;
import Model.Contato;

public class CompromissoDAO extends GenericDAO {
	
	 public void salvar(Compromisso compromisso) throws SQLException {
	        String insert = "INSERT INTO CONTATOS(datCompromisso, horCompromisso, observacao, contato) VALUES(?,?,?,?)";
	        save(insert, compromisso.getDatCompromisso(), compromisso.getHorCompromisso(), compromisso.getObservacao(), compromisso.getContato());
	    }

	    public void alterar(Compromisso compromisso) throws SQLException {
	        String update = "UPDATE COMPROMISSO " +
	                "SET datCompromisso = ?, contato = ?, horaCompromisso = ?, observ = ?" +
	                "WHERE id = ?";
	        update(update, compromisso.getId(), compromisso.getDatCompromisso(), 
	               compromisso.getHorCompromisso(), compromisso.getObservacao(), compromisso.getContato());
	    }

	    public void excluir(long id) throws SQLException {
	        String delete = "DELETE FROM COMPROMISSO WHERE id = ?";
	        delete(delete, id);
	    }

	    public List findCompromisso() throws SQLException {
	        List compromissos = new ArrayList();

	        String select = "SELECT * FROM COMPROMISSO";

	        PreparedStatement stmt = 
		    getConnection().prepareStatement(select);
				
	        ResultSet rs = stmt.executeQuery();
	        
	        Contato contato = new Contato();

	        while (rs.next()) {
	            Compromisso compromisso = new Compromisso();
	            compromisso.setId(rs.getLong("id"));
	            compromisso.setDatCompromisso(rs.getDate("datCompromisso"));
	            compromisso.setHorCompromisso(rs.getString("horaCompromisso"));
	            compromisso.setObservacao(rs.getString("observ"));
	            contato.setNome(rs.getString("contato"));
	            compromissos.add(compromisso);
	        }

	        rs.close();
	        stmt.close();
	        getConnection().close();

	        return compromissos;
	    }

	    public Compromisso findByObs(String observacao) throws SQLException {
	        String select = "SELECT * FROM COMPROMISSO WHERE observacao = ?";
	        Compromisso compromisso = null;
	        PreparedStatement stmt = 
				getConnection().prepareStatement(select);
				
	        stmt.setString(1, observacao);
	        ResultSet rs = stmt.executeQuery();
	        Contato contato = new Contato();

	        while (rs.next()) {
	            compromisso = new Compromisso();
	            compromisso.setId(rs.getLong("id"));
	            compromisso.setDatCompromisso(rs.getDate("dataCompromisso"));
	            compromisso.setHorCompromisso(rs.getString("horaCompromisso"));
	            compromisso.setObservacao(rs.getString("observ"));
	            contato.setNome(rs.getString("contato"));
	        }

	        rs.close();
	        stmt.close();
	        getConnection().close();

	        return compromisso;
	    }

}