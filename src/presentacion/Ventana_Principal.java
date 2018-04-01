package presentacion;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

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

		labelSOS = new javax.swing.JLabel();
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
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup()
										.addComponent(labelSOS, javax.swing.GroupLayout.DEFAULT_SIZE, 227,
												Short.MAX_VALUE)
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(btnEntrar).addComponent(btnCrearCuenta))
										.addGap(69, 69, 69)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(36, 36, 36).addComponent(btnEntrar)
								.addGap(27, 27, 27).addComponent(btnCrearCuenta).addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addComponent(labelSOS,
								javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE)));

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
	private javax.swing.JLabel labelSOS;
	// End of variables declaration
}
