package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JuegosModel {
	// consulta
	private final static String GAMES_SEL = "SELECT * FROM juegos";
	private final static String ID_COL = "id";
	private final static String NAME_COL = "nombre";
	private final static String GENRE_COL = "genero";
	private final static String PLATFORM_COL = "plataforma";
	private final static String DESCRIPTION_COL = "descripcion";

	private final static String GAME_UPDATE = "UPDATE juegos set " + NAME_COL
			+ " = ?," + GENRE_COL + " = ?," + PLATFORM_COL + " = ? WHERE id"
			+ " = ?";

	// conexion
	private Connection conexion = null;
	private Statement instruccion = null;
	private ResultSet conjuntoResultados = null;

	private ArrayList<Game> juegos = null;

	public JuegosModel() {
		// obtenemoss la conexion
		conexion = ConexionDB.getConexion();
		// inicializamos el array
		juegos = new ArrayList<Game>();
	}

	public ArrayList getJuegos() {
		try {
			instruccion = this.conexion.createStatement();
			conjuntoResultados = instruccion.executeQuery(GAMES_SEL);
			juegos.clear();
			// listamos por pantalla los datos
			while (conjuntoResultados.next()) {
				Game game = new Game(conjuntoResultados.getInt(ID_COL),
						conjuntoResultados.getString(NAME_COL),
						conjuntoResultados.getString(GENRE_COL),
						conjuntoResultados.getString(PLATFORM_COL),
						conjuntoResultados.getString(DESCRIPTION_COL));
				juegos.add(game);
			}
			return juegos;
		} catch (SQLException excepcionSql) {
			excepcionSql.printStackTrace();
			return juegos;
		} finally {
			try {
				conjuntoResultados.close();
				instruccion.close();
			} catch (SQLException excepcionSql) {
				excepcionSql.printStackTrace();

			}
		}
	}

	public void updateJuegos(Game game) {
		try {
			PreparedStatement pst = this.conexion.prepareStatement(GAME_UPDATE);
			pst.setString(1, game.getNombre());
			pst.setString(2, game.getGenero());
			pst.setString(3, game.getPlataforma());
			pst.setInt(4, game.getId());
			pst.executeUpdate();

		} catch (SQLException excepcionSql) {
			excepcionSql.printStackTrace();
		}

	}
}

