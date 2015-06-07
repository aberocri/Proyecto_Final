package Vista;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import Modelo.UsuariosModel;

import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Controlador.MainController;

public class VistaPrincipal extends JPanel {
	private JPasswordField passwordField;
	JComboBox usuario;

	/**
	 * Create the panel.
	 */
	public VistaPrincipal() {
		setLayout(null);
		Border border = LineBorder.createGrayLineBorder();
		JButton btnJuegos = new JButton("Juegos >");
		btnJuegos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().showJuegos();
			}
		});
		btnJuegos.setBounds(298, 21, 153, 23);
		add(btnJuegos);

		JButton btnPerfil = new JButton("Perfil >");
		btnPerfil.setBounds(298, 55, 153, 23);
		add(btnPerfil);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(28, 215, 46, 14);
		add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(28, 278, 81, 14);
		add(lblContrasea);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().logar();

			}
		});
		btnLogin.setBounds(28, 353, 146, 23);
		add(btnLogin);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setEnabled(false);
		btnRegistrarse.setBounds(28, 387, 146, 23);
		add(btnRegistrarse);

		passwordField = new JPasswordField();
		passwordField.setBounds(28, 303, 146, 20);
		add(passwordField);

		usuario = new JComboBox();
		usuario.setBounds(28, 240, 146, 20);
		add(usuario);

		JLabel label = new JLabel("foto");
		label.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/images.jpg")));
		label.setBounds(26, 21, 240, 183);
		label.setBorder(border);
		add(label);

	}

	public void putUsuarios(ArrayList usuarios) {
		Iterator<String> it = usuarios.iterator();
		usuario.removeAllItems();
		while (it.hasNext()) {
			usuario.addItem((String) it.next());
		}
	}
}
