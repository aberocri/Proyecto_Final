package Modelo;

public class Game {
	// atributos
	int id = 0;
	private String nombre = "";
	private String genero = "";
	private String plataforma = "";
	private String descripcion = "";

	public Game(int id, String nombre, String genero, String plataforma,
			String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.plataforma = plataforma;
		this.descripcion = descripcion;
	}

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return this.plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String toString() {
		return this.nombre;
	}
}
