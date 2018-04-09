package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import datos.DAO_Crear;

import datos.DAO_Paso;
import datos.DAO_Plantillas;
import datos.DAO_Usuario;
import negocio.Servicio_Crear;
import negocio.Servicio_Paso;

import negocio.Usuario;
import principal.Principal;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class Primera_Ventana {

	private JFrame frmPrincipal;
	private Principal app = new Principal();
	private JList<File> lista_p;
	static Usuario u ;
	private Control_Crear cc;
	DAO_Usuario daou;

	public Primera_Ventana(Control_Crear cc2, String u2) throws SQLException {
		this.cc = cc2;
		daou = new DAO_Usuario();
//		u=daou.recuperaUsuario(u2);
		initialize(u2);
	}

	/**
	 * Initialize the contents of the frame. Crea una Jlist que muestra las
	 * plantillas de usuario
	 * 
	 * @param
	 * @throws SQLException
	 */
	private void initialize(String u2) throws SQLException {

		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("PRINCIPAL");
		frmPrincipal.setBounds(100, 100, 450, 450);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		frmPrincipal.setVisible(true);
		DefaultListModel<File> listModel = new DefaultListModel<>();

		
		DAO_Plantillas daop  =new DAO_Plantillas();
		try {
			daop.Obten_Plantillas(u2, listModel);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lista_p = new JList<>(listModel);
		lista_p.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane jsp_l = new JScrollPane(lista_p);
        frmPrincipal.add(jsp_l);
        jsp_l.setBounds(68, 10, 300, 250);
        lista_p.addListSelectionListener(new ListSelectionListener() {
            

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if (!arg0.getValueIsAdjusting()) {
					final File selectedValue = lista_p.getSelectedValue();
					System.out.println(selectedValue.getName());
				}
			}

		});

		JButton btnCrear = new JButton("CREAR");
		btnCrear.setBounds(63, 270, 150, 25);
		btnCrear.setBackground(Color.WHITE);
		frmPrincipal.getContentPane().add(btnCrear);

		btnCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				app.Crear(u2);
				frmPrincipal.dispose();
				// initialize(usuario);
			}
		});
		/**
		 * Boton abrir, al seleccionarlo activa Evento que abrira la plantilla
		 * anteriormente hacia lo de importar ahora abre la plantilla seleccionada de la
		 * lista
		 * 
		 * @param file
		 *            seleccionado
		 */
		JButton btnAbrir = new JButton("ABRIR");
		btnAbrir.setBounds(224, 270, 150, 25);
		btnAbrir.setBackground(Color.WHITE);
		frmPrincipal.getContentPane().add(btnAbrir);

		btnAbrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					//System.out.println(lista_p.getSelectedValue().getName());
					app.paso(lista_p.getSelectedValue(),lista_p.getSelectedValue().getName());


				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		
		JButton btnImportar = new JButton("IMPORTAR");
		btnImportar.setBounds(63, 310, 150, 25);
		btnImportar.setBackground(Color.WHITE);
		frmPrincipal.getContentPane().add(btnImportar);
				
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					btnImportarActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			private void btnImportarActionPerformed(ActionEvent evt) throws IOException {// GEN-FIRST:event_btnImportarTablaActionPerformed
				
				File file = null;
				DAO_Paso daopaso=new DAO_Paso();
				Servicio_Paso sp =new Servicio_Paso(daopaso);
				Control_Paso cp= new Control_Paso(sp);
				file = cp.importar();
				String[] datos = {file.getName(),"000000000", "Asesor?"};
				DAO_Crear daoc = new DAO_Crear();
				
				
				if(daoc.importar(file,datos, u2)){
					JOptionPane.showMessageDialog(null, "Importado Exitoso");
					frmPrincipal.dispose();
					try {
						Primera_Ventana p  =new Primera_Ventana(cc, u2);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null, "NO SE HA PODIDO IMPORTAR");
				}
				
			}
		});

		
		JButton btnCuenta = new JButton("VER CUENTA");
		btnCuenta.setBounds(224, 310, 150, 25);
		btnCuenta.setBackground(Color.WHITE);
		frmPrincipal.getContentPane().add(btnCuenta);
		
		btnCuenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					u=daou.recuperaUsuario(u2);
					System.out.println(u.getNombre());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("neeeeee");
					e.printStackTrace();
				}
				app.ModificarCuenta(u);
			}
		});
		JButton btnRegresar = new JButton();
		btnRegresar.setText("REGRESAR");
        btnRegresar.setBounds(135, 350, 150, 25);
        btnRegresar.setBackground(Color.WHITE);
        frmPrincipal.add(btnRegresar);

        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frmPrincipal.dispose();
                Ventana_Principal v =new Ventana_Principal();
            }
        }); 
	}
	
//	public static void main(String[] args){
//		Primera_Ventana pv = new Primera_Ventana(new Usuario("leon","leon",2,"leon","leon"));
//	}

}
