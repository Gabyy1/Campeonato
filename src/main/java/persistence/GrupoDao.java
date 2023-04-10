package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grupo;

public class GrupoDao implements IGrupoDao {
	private GenericDao gDao;

	public GrupoDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public List<Grupo> geraGrupos() throws SQLException, ClassNotFoundException {
		List<Grupo> grupos = new ArrayList<>();

		Connection c = gDao.getConnection();

		String exec_sql = "{CALL sp_divide_times_grupos}";

		String sql = "SELECT g.grupo, t.nome\r\n" + "FROM grupos g, times t\r\n" + "WHERE g.codigo_time = t.codigo\r\n"
				+ "ORDER BY grupo, codigo_time";

		try {
			CallableStatement cs = c.prepareCall(exec_sql);
			cs.execute();

			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Grupo grupo = new Grupo();
				grupo.setGrupo(rs.getString("grupo"));
				grupo.setTime(rs.getString("time"));
				grupos.add(grupo);
			}
			rs.close();
			ps.close();
			cs.close();

		} catch (Exception e) {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Grupo grupo = new Grupo();
				grupo.setGrupo(rs.getString("grupo"));
				grupo.setTime(rs.getString("time"));
				grupos.add(grupo);
			}

			rs.close();
			ps.close();

		}
		c.close();

		return grupos;

	}

	@Override
	public List<Grupo> listarGrupoA() throws SQLException, ClassNotFoundException {
		List<Grupo> grupoA = new ArrayList<>();
		Connection c = gDao.getConnection();

		String sql = "SELECT g.grupo, t.nome\r\n" + "FROM grupos g, times t\r\n"
				+ "WHERE g.codigo_time = t.codigo AND grupo = 'A'\r\n" + "ORDER BY grupo, codigo_time";

		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Grupo grupo = new Grupo();
			grupo.setGrupo(rs.getString("grupo"));
			grupo.setTime(rs.getString("time"));
			grupoA.add(grupo);
		}
		rs.close();
		ps.close();
		c.close();
		return grupoA;

	}

	@Override
	public List<Grupo> listarGrupoB() throws SQLException, ClassNotFoundException {
		List<Grupo> grupoB = new ArrayList<>();
		Connection c = gDao.getConnection();

		String sql = "SELECT g.grupo, t.nome\r\n" + "FROM grupos g, times t\r\n"
				+ "WHERE g.codigo_time = t.codigo AND grupo = 'B'\r\n" + "ORDER BY grupo, codigo_time";

		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Grupo grupo = new Grupo();
			grupo.setGrupo(rs.getString("grupo"));
			grupo.setTime(rs.getString("time"));
			grupoB.add(grupo);
		}
		rs.close();
		ps.close();
		c.close();
		return grupoB;
	}

	@Override
	public List<Grupo> listarGrupoC() throws SQLException, ClassNotFoundException {
		List<Grupo> grupoC = new ArrayList<>();
		Connection c = gDao.getConnection();

		String sql = "SELECT g.grupo, t.nome\r\n" + "FROM grupos g, times t\r\n"
				+ "WHERE g.codigo_time = t.codigo AND grupo = 'C'\r\n" + "ORDER BY grupo, codigo_time";

		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Grupo grupo = new Grupo();
			grupo.setGrupo(rs.getString("grupo"));
			grupo.setTime(rs.getString("time"));
			grupoC.add(grupo);
		}
		rs.close();
		ps.close();
		c.close();
		return grupoC;
	}

	@Override
	public List<Grupo> listarGrupoD() throws SQLException, ClassNotFoundException {
		List<Grupo> grupoD = new ArrayList<>();
		Connection c = gDao.getConnection();

		String sql = "SELECT g.grupo, t.nome\r\n" + "FROM grupos g, times t\r\n"
				+ "WHERE g.codigo_time = t.codigo AND grupo = 'D'\r\n" + "ORDER BY grupo, codigo_time";

		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Grupo grupo = new Grupo();
			grupo.setGrupo(rs.getString("grupo"));
			grupo.setTime(rs.getString("time"));
			grupoD.add(grupo);
		}
		rs.close();
		ps.close();
		c.close();
		return grupoD;
	}

}