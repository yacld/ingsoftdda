package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Usuario;

/** Clase ventana contiene todo en contenido 
 * de la parte grafica y llamadas a controles 
 * sobre el caso de uso asociado que es el de modificar 
 * datos sobre la cuenta de usuario
 */

public class Ventana_Modificar {
	// Declaracion de variables
	private JFrame frmModificar;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textContra1;
	private JTextField textContra2;
	private JTextField textNick;
	private Control_Modificar cm;
	boolean modificar=false;
	Usuario usuario;

	/**
	 * Se llama al constructor de la ventana
	 */
	public Ventana_Modificar(Control_Modificar control_Modificar) {
		this.cm = control_Modificar;
	}

	/*
	 * Metodo para inicializar la ventana, se pone trues para ver la ventana
	 */
	public void iniciar(Usuario u) {
		this.usuario = u;
		initialize();
		frmModificar.setVisible(true);
	}

	/**
	 * Aqui se inicializa el contenido de la ventana Se declaran las ubicacions de
	 * los componentes, las funcionalidades de los metodos y demas cosas
	 */
	private void initialize() {
		frmModificar = new JFrame();
		frmModificar.setFont(new Font("AkrutiTml2", Font.BOLD, 15));
		frmModificar.setTitle("ACTUALIZAR CUENTA");
		frmModificar.setBounds(100, 100, 450, 450);
		frmModificar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificar.getContentPane().setLayout(null);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(35, 30, 66, 15);
		frmModificar.getContentPane().add(lblNombre);

		textNombre = new JTextField(usuario.getNombre());
		textNombre.setBounds(120, 30, 224, 20);
		frmModificar.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		textNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				modificar=true;

			}
		});
		

		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(35, 70, 66, 15);
		frmModificar.getContentPane().add(lblApellido);

		textApellido = new JTextField(usuario.getApellido());
		textApellido.setBounds(120, 70, 224, 20);
		frmModificar.getContentPane().add(textApellido);
		textApellido.setColumns(10);
		textApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				modificar=true;

			}
		});

		JLabel lblAsesor = new JLabel("ASESOR");
		lblAsesor.setBounds(35, 150, 66, 15);
		frmModificar.getContentPane().add(lblAsesor);

		JComboBox<Object> cbTipo = new JComboBox<Object>();
		// Si es cero quiere deasesor entonces se muestra asesor como primer valor por defalut
		if (usuario.getAsesor() == 0) {
			cbTipo.setModel(new DefaultComboBoxModel<Object>(new String[] { "SI", "NO" }));
		} else {
			cbTipo.setModel(new DefaultComboBoxModel<Object>(new String[] { "NO", "SI" }));
		}

		cbTipo.setBounds(120, 150, 82, 20);
		frmModificar.getContentPane().add(cbTipo);
		cbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				modificar=true;

			}
		});

		JLabel lblContra1 = new JLabel("CONTRASE�A");
		lblContra1.setBounds(35, 200, 230, 15);
		frmModificar.getContentPane().add(lblContra1);

		textContra1 = new JTextField(usuario.getContrasenia());
		textContra1.setBounds(35, 230, 240, 20);
		frmModificar.getContentPane().add(textContra1);
		textContra1.setColumns(10);
		textContra1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				modificar=true;

			}
		});

		JLabel lblContra2 = new JLabel("VERIFICAR CONTRASE�A");
		lblContra2.setBounds(35, 280, 224, 15);
		frmModificar.getContentPane().add(lblContra2);

		textContra2 = new JTextField(usuario.getContrasenia());
		textContra2.setBounds(32, 310, 240, 20);
		frmModificar.getContentPane().add(textContra2);
		textContra2.setColumns(10);
		textContra2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				modificar=true;

			}
		});

		JLabel lblNick = new JLabel("NICKNAME");
		lblNick.setBounds(35, 110, 100, 15);
		frmModificar.getContentPane().add(lblNick);

		textNick = new JTextField(usuario.getNick());
		textNick.setBounds(120, 110, 224, 20);
		frmModificar.getContentPane().add(textNick);
		textNick.setColumns(10);
		textNick.setEnabled(false);// No se puede modificar

		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(180, 350, 150, 25);
		btnModificar.setBackground(Color.WHITE);
		frmModificar.getContentPane().add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			// Metodo interno para la accion del boton modificar 
			public void actionPerformed(ActionEvent evt) {
				if(modificar) {// se actualiza anteriormente si se modifica algun campo si no no tiene caso llamar al contro

					//JOptionPane.showMessageDialog(null, "�Bien!\nYa se han modificado campos");
					modificar=false;
					int asesor=1;
					if(cbTipo.getSelectedItem() == "SI")asesor =0;
					Usuario nuevoUsuario = new Usuario (textNombre.getText(),textApellido.getText(),asesor,textContra2.getText(),textNick.getText());
					System.out.println("Usuario "+textNombre.getText()+textApellido.getText()+asesor+textContra2.getText()+textNick.getText());
					usuario = nuevoUsuario;
					System.out.println("Usuario: "+usuario.getNombre()+usuario.getApellido()+usuario.getAsesor()+usuario.getContrasenia()+usuario.getNick());
					
					boolean modifica=cm.modificar(usuario);
					System.out.println("modifica "+modifica);

					modifica=true;
					if(modifica) {
						JOptionPane.showMessageDialog(null, "Modificacion exitosa");
					}else {

						JOptionPane.showMessageDialog(null, "Hubo un error en la modificacion");
					}
					
					
				}else {

					JOptionPane.showMessageDialog(null, "No se han hecho nuevas modificaciones\nRecuerda presionar Enter despues de cualquier modificacion");
				}

			}
		});

		JButton btnCancelar = new JButton("REGRESAR");
		btnCancelar.setBounds(35, 350, 100, 25);
		btnCancelar.setBackground(Color.WHITE);
		frmModificar.getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frmModificar.dispose();
				cm.u=usuario;
				Primera_Ventana.u=usuario;

			}
		});

		
	}

}
