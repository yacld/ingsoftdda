package presentacion;

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
import datos.DAO_Plantillas;
import negocio.Servicio_Crear;
import negocio.Usuario;
import principal.Principal;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class Primera_Ventana {

	private JFrame frmPrincipal;
	private Principal app = new Principal();
	private JList<File> lista_p;
	private Control_Crear cc;

	public Primera_Ventana(Control_Crear cc2, String usuario) throws SQLException {
		this.cc = cc2;
		initialize(usuario);
	}

	// public void iniciar() {
	// initialize();
	// frmPrincipal.setVisible(true);
	// app = new Principal();
	// }

	/**
	 * Initialize the contents of the frame. Crea una Jlist que muestra las
	 * plantillas de usuario
	 * 
	 * @param
	 * @throws SQLException
	 */
	private void initialize(String usuario) throws SQLException {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("PRINCIPAL");
		frmPrincipal.setBounds(100, 100, 451, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		frmPrincipal.setVisible(true);
		DefaultListModel<File> listModel = new DefaultListModel<>();

		if (!cc.obtenPlantillas(usuario, listModel)) {
			JOptionPane.showMessageDialog(null, "¡¡¡Ocurrio un error y no se pudo recuperar nada de la Base!!!");
		} else {
			/*
			 * DAO_Plantillas daop =new DAO_Plantillas(); try {
			 * daop.Obten_Plantillas(usuario.getNombre(), listModel); } catch (SQLException
			 * e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
			 */
			lista_p = new JList<>(listModel);
			lista_p.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		JScrollPane jsp_l = new JScrollPane(lista_p);
		frmPrincipal.add(jsp_l);
		jsp_l.setBounds(85, 10, 250, 200);
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
		btnCrear.setBounds(86, 220, 89, 23);
		frmPrincipal.getContentPane().add(btnCrear);

		btnCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				app.Crear(usuario);
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
		btnAbrir.setBounds(249, 220, 89, 23);
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

	}

	public static void main(String[] args) throws SQLException {
		Control_Crear cc = new Control_Crear(new Servicio_Crear(new DAO_Crear()));
		Primera_Ventana pv = new Primera_Ventana(cc, "garo");
	}
}
