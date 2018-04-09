package presentacion;

/**
 * Es la primera entan que ve el usuario
 * ESta ventana tiene las opcones relacionadas a la creacion o entrada
 * al sistema de un usuario 
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Ventana_Inicio {
	Control_Principal cP;
	public JFrame frame;



	/**
	 * Crea la aplicacion
	 */
	public Ventana_Inicio() {
		cP = new Control_Principal();
		initialize();
		//frame.setVisible(true);
	}

	/**
	 * Initializa los componentes
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 499, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnEntrar = new JButton("Entrar al sistema");
		btnEntrar.setBounds(34, 249, 190, 25);
		frame.getContentPane().add(btnEntrar);

		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setBounds(296, 249, 149, 25);
		frame.getContentPane().add(btnCrearCuenta);

		JLabel lbluno = new JLabel("<html>Sistema generador de Documentos <br>para auditorias</html>");
		lbluno.setHorizontalAlignment(SwingConstants.CENTER);
		lbluno.setFont(new Font("Dialog", Font.BOLD, 17));
		lbluno.setBounds(44, 48, 390, 71);
		frame.getContentPane().add(lbluno);

		
		/**
		 * ESte boton al ser presionado invoca a un Control_Principal
		 * que abrirra una nueva ventana
		 */
		btnEntrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEntrarActionPerformed(evt);
			}

			private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {
				cP.inicia_Entrar();
				frame.setVisible(false);
				frame.dispose();
			}
		});

		/**
		 * Este boton sisrve para llever a un nuevo usuario a crear una nueva cuenta
		 */
		btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCrearCuentaActionPerformed(evt);
			}

			private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {
				cP.inicia_Crear_Usuario();
				frame.setVisible(false);
				frame.dispose();
			}
		});

	}
}
