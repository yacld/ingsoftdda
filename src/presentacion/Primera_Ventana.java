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
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import datos.DAO_Plantillas;
import principal.Principal;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class Primera_Ventana {
	
	private JFrame frmPrincipal;
	private Principal app;
	private JList<File> lista_p;
	 
	public Primera_Ventana(String usuario){
		initialize(usuario);
	}
	
//	public void iniciar() {
//		initialize();
//		frmPrincipal.setVisible(true);
//		app = new Principal();
//	}

	
	/**
	 * Initialize the contents of the frame.
	 * Crea una Jlist que muestra las plantillas de usuario
	 * @param usuario
	 */
	private void initialize(String usuario) {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("PRINCIPAL");
		frmPrincipal.setBounds(100, 100, 451, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		frmPrincipal.setVisible(true);
		DefaultListModel<File> listModel = new DefaultListModel<>();
		
		DAO_Plantillas daop  =new DAO_Plantillas();
		try {
			daop.Obten_Plantillas(usuario, listModel);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lista_p = new JList<>(listModel);
		lista_p.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista_p.addListSelectionListener(new ListSelectionListener() {
                    
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if (!arg0.getValueIsAdjusting()) {
                    final List<File> selectedValuesList = lista_p.getSelectedValuesList();
                    System.out.println(selectedValuesList);
                }
			}
        });
 
        frmPrincipal.add(new JScrollPane(lista_p));
        lista_p.setBounds(10, 10, 250, 150);
				
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.setBounds(86, 220, 89, 23);
		frmPrincipal.getContentPane().add(btnCrear);
		
		btnCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				app.Crear();
			}
		});
		
		JButton btnAbrir = new JButton("ABRIR");
		btnAbrir.setBounds(249, 220, 89, 23);
		frmPrincipal.getContentPane().add(btnAbrir);
		
		btnAbrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					app.paso();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}
}
