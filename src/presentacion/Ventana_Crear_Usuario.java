package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ventana_Crear_Usuario {

	private JFrame frmNuevoUsuario;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textContra1;
	private JTextField textContra2;
	private JTextField textNick;
	private Control_Crear_Usuario cc;

	/**
	 * Create the application.
	 */
	public Ventana_Crear_Usuario(Control_Crear_Usuario control_Crear) {
		this.cc = control_Crear;
	}
	
	public void iniciar() {
		initialize();
		frmNuevoUsuario.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNuevoUsuario = new JFrame();
		frmNuevoUsuario.setFont(new Font("AkrutiTml2", Font.BOLD, 15));
		frmNuevoUsuario.setTitle("Nuevo Usuario");
		frmNuevoUsuario.setBounds(100, 100, 710, 404);
		frmNuevoUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNuevoUsuario.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 31, 66, 15);
		frmNuevoUsuario.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(116, 29, 124, 19);
		frmNuevoUsuario.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(32, 71, 66, 15);
		frmNuevoUsuario.getContentPane().add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setBounds(116, 69, 124, 19);
		frmNuevoUsuario.getContentPane().add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblAsesor = new JLabel("Asesor");
		lblAsesor.setBounds(32, 122, 66, 15);
		frmNuevoUsuario.getContentPane().add(lblAsesor);
		
		JComboBox<Object> cbTipo = new JComboBox<Object>();
		cbTipo.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "SI", "NO"}));
		cbTipo.setBounds(133, 116, 82, 24);
		frmNuevoUsuario.getContentPane().add(cbTipo);
		
		JLabel lblContra1 = new JLabel("<html>Contraseña(Debe contener letras<br> y numero o algun otro simbolo</html>)");
		lblContra1.setBounds(42, 170, 230, 42);
		frmNuevoUsuario.getContentPane().add(lblContra1);
		
		textContra1 = new JTextField();
		textContra1.setBounds(32, 224, 240, 26);
		frmNuevoUsuario.getContentPane().add(textContra1);
		textContra1.setColumns(10);
		
		JLabel lblContra2 = new JLabel("Verificar contraseña");
		lblContra2.setBounds(32, 282, 224, 15);
		frmNuevoUsuario.getContentPane().add(lblContra2);
		
		textContra2 = new JTextField();
		textContra2.setBounds(32, 309, 240, 26);
		frmNuevoUsuario.getContentPane().add(textContra2);
		textContra2.setColumns(10);
		
		JLabel lblNick = new JLabel("Nombre de usuario(Nickname)");
		lblNick.setBounds(344, 43, 224, 31);
		frmNuevoUsuario.getContentPane().add(lblNick);
		
		textNick = new JTextField();
		textNick.setBounds(344, 86, 224, 37);
		frmNuevoUsuario.getContentPane().add(textNick);
		textNick.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar Usuario");
		btnAgregar.setBounds(510, 309, 145, 25);
		frmNuevoUsuario.getContentPane().add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(328, 309, 114, 25);
		frmNuevoUsuario.getContentPane().add(btnCancelar);
		
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(textNombre.getText() == null || textApellido.getText() == null || textNick.getText() == null || textContra1.getText() == null) {
					JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos");
				}else {
					String nombre = textNombre.getText();
					//System.out.println(textNombre.getText());
					String apellido = textApellido.getText();
					String nick = textNick.getText();
					String contra1 = textContra1.getText();
					String contra2 = textContra2.getText();
					if(contra1 != contra2) {
						JOptionPane.showMessageDialog(null, "Vuelve a verificar la contraseña");
					}else {
						int asesor = 1;
						if(cbTipo.getSelectedItem() == "SI") {
							asesor =0;	
						}
						try {
							if(cc.agregarUsuario(nombre, apellido, asesor, contra1, nick)) {
								JOptionPane.showMessageDialog(null, "¡¡ El usuario nueo ha sido agregado con exito!!");
							}else {
								JOptionPane.showMessageDialog(null, "¡¡ Ha ocurrido un error interno y no se pudo agregar el usuario!!");
							}
						} catch (HeadlessException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
	}
}
