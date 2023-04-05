package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Jogo;

public class JogoDao {
	
	private Connection c;
	
	public JogoDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
		
	}
	
	public String geraJogo() throws SQLException {
		String sql = "{CALL sp_gerador_jogos}";
		CallableStatement cs = c.prepareCall(sql);
		cs.execute();
		
		String saida = "As rodadas foram definidas";
		return saida;
	}
	
	public ArrayList<Jogo> mostraJogo(String data) throws SQLException, ClassNotFoundException{
		
		
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
		
		ArrayList<Jogo> jogos = new ArrayList<Jogo>();
		
		
		String selectStatement = "select * from jogos((?))";
		
		PreparedStatement pr = c.prepareStatement(selectStatement);
		pr.setString(1, data);
	    ResultSet rs = pr.executeQuery();

	    while (rs.next()) {	
	    	Jogo jogo = new Jogo();
	    	jogo.setTimeA(rs.getInt(1));
	    	jogo.setTimeB(rs.getInt(2));
	    	jogo.setGolsA(rs.getInt(3));
	    	jogo.setGolsB(rs.getInt(4));
	    	jogo.setRodada(rs.getInt(4));
	    	jogo.setData(rs.getString(4));
	    	
	    	jogos.add(jogo);
	     }
	   
	     rs.close();
	     pr.close();
		 c.close();
		return jogos;

	}
}
