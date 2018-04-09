package presentacion;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author acer
 */
public class Ventana_Principal extends JFrame {
	Control_Principal cP;

	/**
	 * Creates new form Ventana_Principal
	 */
	public Ventana_Principal() {

		initComponents();
		cP = new Control_Principal();
		ImageIcon imagen = new ImageIcon("SOS_Consulting.png");
		Icon icono = new ImageIcon(	imagen.getImage());
		labelSOS.setIcon(icono);

	}

	private void initComponents() {

		labelSOS = new JLabel();
		btnEntrar = new JButton();
		btnCrearCuenta = new JButton();
		this.setSize(450, 450);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnEntrar.setText("INGRESAR");
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEntrar1ActionPerformed(e);
				
			}
		});

		btnCrearCuenta.setText("CREAR CUENTA");
		btnCrearCuenta.setBackground(Color.WHITE);
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCrearCuenta2ActionPerformed(evt);
			}
		});

		
		this.setLayout(null);
		this.add(btnEntrar);
		this.add(btnCrearCuenta);
		this.add(labelSOS);
		labelSOS.setBounds(30, 20, 354, 310);
		btnCrearCuenta.setBounds(220, 340, 150, 25);
		btnEntrar.setBounds(60, 340, 150, 25);
		
		JButton btnSal = new JButton("SALIR");
		this.add(btnSal);
		btnSal.setBounds(140, 370, 150, 25);
		btnSal.setBackground(Color.WHITE);
		btnSal.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
	}

	private void btnEntrar1ActionPerformed(java.awt.event.ActionEvent evt) {
		cP.inicia_Entrar();
		this.dispose();

	}

	private void btnCrearCuenta2ActionPerformed(java.awt.event.ActionEvent evt) {
		cP.inicia_Crear_Usuario();
		this.dispose();

	}

	private javax.swing.JButton btnEntrar;
	private javax.swing.JButton btnCrearCuenta;
	private javax.swing.JLabel labelSOS;
	// End of variables declaration
}
