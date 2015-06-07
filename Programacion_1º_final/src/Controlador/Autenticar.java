package Controlador;

public class Autenticar {
	private boolean isAuth = false;

	public Autenticar() {

	}

	public boolean estaLogado() {
		return this.isAuth;

	}

	public boolean comprobarUser() {
		this.isAuth = true;
		return this.isAuth;
	}
}
