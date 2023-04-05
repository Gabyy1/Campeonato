package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Grupo;

public class GrupoDao {
	
	private Connection c;
	
	public GrupoDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}
	
	public String preencheTimes() throws SQLException{
		String sql = "{CALL sp_preenche_times}";
		CallableStatement cs = c.prepareCall(sql);
		cs.execute();
		String saida = "grupos gerados";
		return saida;
	}
	
	public ArrayList<Grupo> mostraGrupo() throws SQLException, ClassNotFoundException{
		
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
		
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		
		String selectStatement = "select grupos_times.codigo_grupo, times.nome from grupos_times INNER JOIN times ON grupos_times.codigo_time = times.codigo";
		PreparedStatement pr = c.prepareStatement(selectStatement);
	    ResultSet rs = pr.executeQuery();

	    while (rs.next()) {	
	    	Grupo grupo = new Grupo();
	    	grupo.setTime(rs.getInt("time"));
	    	grupo.setGrupo(rs.getInt("grupo"));
	    	grupos.add(grupo);
	     }
	   
	     rs.close();
	     pr.close();
		 c.close();
		return grupos;
		
	}
}
