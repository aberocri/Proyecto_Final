package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuariosModel {
	// Atributos de bases de datos
	ConexionDB usuariosDB;
	Statement instruccion = null;
	ResultSet conjuntoResultados = null;

	// Consultas SQL
	private static String USUARIOS_LIST = "SELECT * FROM usuarios";

	private ArrayList<String> usuarios = null;

	public UsuariosModel() {
		// Creamos la conexion con la base de datos
		usuariosDB = ConexionDB.getInstance();
		usuarios = new ArrayList<String>();
	}

	// Devolucion de los usuaios
	public ArrayList<String> getUsuarios() {

		try {
			// Preparamos la peticion
			instruccion = usuariosDB.getConexion().createStatement();
			conjuntoResultados = instruccion.executeQuery(USUARIOS_LIST);

			usuarios.clear();
			// Recorremos los resultados y los almacenamos en un ArrayList
			// Listaremos por pantalla los datos
			while (conjuntoResultados.next()) {
				usuarios.add(conjuntoResultados.getString("usuario"));
			}// fin de while
		} catch (SQLException excepcionSql) {
			excepcionSql.printStackTrace();
		} finally {
			try {
				conjuntoResultados.close();
				instruccion.close();
			} catch (SQLException excepcionSql) {
				excepcionSql.printStackTrace();
			}
		}
		return usuarios;
	}

}