package presentacion;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

/**
 *
 * @author acer
 */
public class Ventana_Principal extends javax.swing.JFrame {
	Control_Principal cP;

	/**
	 * Creates new form Ventana_Principal
	 */
	public Ventana_Principal() {

		initComponents();
		cP = new Control_Principal();
		/*ImageIcon imagen = new ImageIcon("C:\\Users\\acer\\git\\ingsoftdda\\target\\SOS_Consulting.png");
		Icon icono = new ImageIcon(
				imagen.getImage().getScaledInstance(labelSOS.getWidth(), labelSOS.getHeight(), Image.SCALE_DEFAULT));
		labelSOS.setIcon(icono);
		this.repaint();*/
	}

	private void initComponents() {
		btnEntrar = new javax.swing.JButton();
		btnCrearCuenta = new javax.swing.JButton();
		this.setVisible(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		btnEntrar.setText("Entrar al Sistema");
		btnEntrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEntrar1ActionPerformed(evt);
			}
		});

		btnCrearCuenta.setText("Crear Cuenta");
		btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCrearCuenta2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(36)
					.addComponent(btnEntrar)
					.addGap(75)
					.addComponent(btnCrearCuenta)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(45)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEntrar)
						.addComponent(btnCrearCuenta))
					.addGap(43))
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>

	private void btnEntrar1ActionPerformed(java.awt.event.ActionEvent evt) {
		cP.inicia_Entrar();
		this.setVisible(false);

	}

	private void btnCrearCuenta2ActionPerformed(java.awt.event.ActionEvent evt) {
		cP.inicia_Crear_Usuario();
		this.setVisible(false);

	}

	private javax.swing.JButton btnEntrar;
	private javax.swing.JButton btnCrearCuenta;
	// End of variables declaration
}
