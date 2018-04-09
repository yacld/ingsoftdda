package presentacion;
/**
 * Esta ventana es la que se muestra cuando un usuario ya tiene una cuenta 
 * y quiere entrar al sistema
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import negocio.Usuario;

public class Ventana_Entrar {

	private JFrame frmEntrar;
	private JButton btnCancelar;
	private JButton btnEntrar;
	private JButton btnRegresar;
	private JPasswordField contrasenia;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JTextField usuario;

	Ventana_Principal ventana_Principal;

	Control_Entrar ce;
	Usuario u;
	//private Control_Entrar cE;

	/**
	 * La ventana encargada de revisar si el usuario efectivamente tiene una cuenta
	 * @param control_Entrar: se encarga del acceso al sistema
	 */

	public Ventana_Entrar(Control_Entrar control_Entrar) {

		this.ce = control_Entrar;
//		ventana_Principal = new Ventana_Principal();

		//iniciar();

	}
	
	/**
	 * Inicia los componentes
	 */
	public void iniciar() {
		initComponents();
		frmEntrar.setVisible(true);
	}

	private void initComponents() {
		frmEntrar = new JFrame();
		frmEntrar.setFont(new Font("AkrutiTml2", Font.BOLD, 15));

		frmEntrar.setTitle("ENTRAR AL SISTEMA");
		frmEntrar.setBounds(100, 100, 450, 450);
		frmEntrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEntrar.getContentPane().setLayout(null);

        jPanel1 = new JPanel();
        jLabel3 = new JLabel("INICIAR SESION");

        jPanel2 = new JPanel();
        jLabel1 = new JLabel("USUARIO: ");
        jLabel2 = new JLabel("CONTRASE�A: ");
        usuario = new JTextField(20);
        contrasenia = new JPasswordField(20);
        btnEntrar = new JButton();
        btnCancelar = new JButton();
        btnRegresar = new JButton();

        
        jPanel1.setLayout(null);
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 10, 18)); // NOI18N
        jLabel3.setText("INICIAR SESION");
        jLabel1.setBounds(10, 30, 100, 25);
        frmEntrar.add(jLabel3);
        
        
//        jLabel1.setText("Usuario: "); 
        jLabel1.setBounds(120, 60, 100, 25);
        frmEntrar.add(jLabel1);
        
        usuario.setBounds(120, 90, 200, 25);
        frmEntrar.add(usuario);

        
        
//        jLabel2.setText("Contrasenia: ");
        jLabel2.setBounds(120, 150, 100, 25);
        frmEntrar.add(jLabel2);

        contrasenia.setBounds(120, 190, 200, 25);
        frmEntrar.add(contrasenia);


        btnEntrar.setText("ENTRAR");
        btnEntrar.setBounds(115, 250, 100, 25);
        btnEntrar.setBackground(Color.WHITE);
        frmEntrar.add(btnEntrar);

        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					btnEntrarActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        btnCancelar.setText("SALIR");
        btnCancelar.setBounds(225, 250, 100, 25);
        btnCancelar.setBackground(Color.WHITE);
        frmEntrar.add(btnCancelar);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });


        btnRegresar.setText("REGRESAR");
        btnRegresar.setBounds(140, 300, 150, 25);
        btnRegresar.setBackground(Color.WHITE);
        frmEntrar.add(btnRegresar);

        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        }); 
    }
//	private void btnEntrarActionPerformed(ActionEvent evt) {
//	    char[] arrC = contrasenia.getPassword();
//        String pass = new String(arrC);
//        System.out.println("Usuario: " + usuario.getText());
//        System.out.println("Contrasenia: " + pass);
//        if (usuario.getText().isEmpty()||pass.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Faltan campos por llenar");
//        } else {
//            System.out.println("Usuario: " + usuario.getText());
//            System.out.println("Contrasenia: " + pass);
//            JOptionPane.showMessageDialog(null, "Bien hecho");
//        
//		//---> Funcionamiento real con detalles en la base //
//           // u=cE.inicia(usuario.getText(), pass);
//		u= new Usuario("Brandon", "Leon", 1, "123", usuario.getText());// Funcionamiento temporal
//            if (u!=null) {
//			Primera_Ventana vent = new Primera_Ventana(u);
//			frmEntrar.dispose();
//		} else {
//			int tipoErr = cE.tipoErr;
//			switch (tipoErr) {
//			case 1:
//				JOptionPane.showMessageDialog(null, "No se encontro nombre de usuario");
//				usuario.setText("");
//				contrasenia.setText("");
//				break;
//			case 2:
//				JOptionPane.showMessageDialog(null, "Contrasenia Incorrecta \n Intente de Nuevo");
//				usuario.setText("");
//				contrasenia.setText("");
//				break;
//			 }
//
//
//		btnRegresar.setText("Regresar");
//		btnRegresar.setBounds(110, 160, 100, 25);
//		frmEntrar.getContentPane().add(btnRegresar);
//
//		btnRegresar.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				btnRegresarActionPerformed(evt);
//			}
//		});
//	}

	/**
	 * Reisa si el eusario existe o si los datos estan intruducidos correctamente
	 * @param evt
	 * @throws SQLException
	 */
	private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		char[] arrC = contrasenia.getPassword();
		String contra = new String(arrC);
		//System.out.println("Usuario: " + usuario.getText());
		//System.out.println("Contrasenia: " + pass);

		if (usuario.getText().isEmpty() || contra.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Faltan campos por llenar");
		} else {
			
			if(ce.mostrar(usuario.getText(),contra)) {
				System.out.println("Fue true");
				ce.abrir(usuario.getText());
				frmEntrar.dispose();
			}else {
				System.out.println("Fue false");
				JOptionPane.showMessageDialog(null, "¡¡El usuario que introdujo no existe");
			}
		
		}

	}
	
	/**
	 * Regresa a la ventana principal 
	 * @param evt
	 */
	private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {
		frmEntrar.dispose();
		ventana_Principal = new Ventana_Principal();

	}

	/**
	 * Cierra el sistema
	 * @param evt
	 */
	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	// Variables declaration - do not modify

	// End of variables declaration
}
