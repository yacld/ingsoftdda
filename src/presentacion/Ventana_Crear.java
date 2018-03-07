package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Ventana_Crear {

	private JFrame frmCrearPlantilla;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Control_Crear cc;


	public Ventana_Crear(Control_Crear control_Crear) {
		this.cc = control_Crear;
	}

	public void iniciar() {
		initialize();
		frmCrearPlantilla.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrearPlantilla = new JFrame();
		frmCrearPlantilla.setTitle("CREAR PLANTILLA");
		frmCrearPlantilla.setBounds(100, 100, 700, 326);
		frmCrearPlantilla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrearPlantilla.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.setBounds(539, 236, 89, 23);
		frmCrearPlantilla.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(23, 31, 46, 14);
		frmCrearPlantilla.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISO");
		lblNewLabel_1.setBounds(23, 77, 46, 14);
		frmCrearPlantilla.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Asesor");
		lblNewLabel_2.setBounds(23, 129, 101, 23);
		frmCrearPlantilla.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(94, 28, 258, 20);
		frmCrearPlantilla.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 74, 86, 20);
		frmCrearPlantilla.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(97, 130, 258, 20);
		frmCrearPlantilla.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] datos = new String[3];
				datos[0] = textField.getText();
				datos[1] = textField_1.getText();
				datos[2] = textField_2.getText();
					
				try {
					cc.crear(datos);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
	}
}
