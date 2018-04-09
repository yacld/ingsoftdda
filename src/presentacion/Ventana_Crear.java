package presentacion;
/**
 * Ventana que contiene los rpincipales datos que llevara una plantilla para
 * relacionarla luego con el usuario
 * 
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import datos.DAO_Paso;
import negocio.Servicio_Paso;
import negocio.Usuario;

public class Ventana_Crear {

	private JFrame frmCrearPlantilla;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Control_Crear cc;


	/**
	 * Constructor de la ventana
	 * @param control_Crear:Relacionado a la creacion de plantillas
	 */
	public Ventana_Crear(Control_Crear control_Crear) {
		this.cc = control_Crear;
	}


	/**
	 * Inicia la ventan y la hace visible
	 * @param usuario: para saber que plantillasbuscar en la base
	 */
	public void iniciar(String usuario) {

		initialize(usuario);
		frmCrearPlantilla.setVisible(true);
	}

	/**
	 * Initializa el contenido del frame
	 */
	private void initialize(String usuario) {
		frmCrearPlantilla = new JFrame();
		frmCrearPlantilla.setTitle("CREAR PLANTILLA");
		frmCrearPlantilla.setBounds(100, 100, 450, 450);
		frmCrearPlantilla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrearPlantilla.getContentPane().setLayout(null);
		
		Font font = new Font(null, 10, 15);
		
		JLabel lbltitulo = new JLabel("CREAR PLANTILLA");
		lbltitulo.setBounds(150, 50, 150, 20);
		lbltitulo.setFont(font);
		frmCrearPlantilla.getContentPane().add(lbltitulo);
		
		
		JButton btnNewButton = new JButton("CREAR");
		btnNewButton.setBounds(150, 240, 150, 25);
		btnNewButton.setBackground(Color.WHITE);
		frmCrearPlantilla.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setBounds(50, 100, 100, 20);
		frmCrearPlantilla.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISO");
		lblNewLabel_1.setBounds(50, 150, 100, 20);
		frmCrearPlantilla.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ASESOR");
		lblNewLabel_2.setBounds(50, 200, 100, 25);
		frmCrearPlantilla.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(150, 100, 200, 20);
		frmCrearPlantilla.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 150, 200, 20);
		frmCrearPlantilla.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 200, 200, 20);
		frmCrearPlantilla.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		/**
		 * se encarga de crear una nueva plantilla en el sistema aunque no tenga datos aun
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] datos = new String[3];
				if(textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Te falta llenar datos");
				}else {
				datos[0] = textField.getText();
				datos[1] = textField_1.getText();
				datos[2] = textField_2.getText();
				try {
					//Crea la plantilla en la base de datos
					cc.crear(datos, usuario);
					frmCrearPlantilla.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				}	
				
			}
		});
		
		JButton btnRegresar = new JButton();
		btnRegresar.setText("REGRESAR");
        btnRegresar.setBounds(150, 300, 150, 25);
        btnRegresar.setBackground(Color.WHITE);
        frmCrearPlantilla.add(btnRegresar);

        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	frmCrearPlantilla.dispose();
            	try {
					Primera_Ventana p = new Primera_Ventana(cc,usuario);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//                Ventana_Principal v =new Ventana_Principal();
            }
        }); 
		
		
	}

	/*public void mostrarNueva(File name) {
		Tabla tabla = new Tabla(new Control_Paso(new Servicio_Paso(new DAO_Paso())), name, usuario);
		tabla.frmProceso.setVisible(true);
		
	}*/
}
