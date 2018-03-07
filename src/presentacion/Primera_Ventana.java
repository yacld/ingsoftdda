package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

import principal.Principal;

import javax.swing.JButton;

public class Primera_Ventana {
	
	private JFrame frmPrincipal;
	private Principal app;

	public void iniciar() {
		initialize();
		frmPrincipal.setVisible(true);
		app = new Principal();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("PRINCIPAL");
		frmPrincipal.setBounds(100, 100, 451, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.setBounds(86, 113, 89, 23);
		frmPrincipal.getContentPane().add(btnCrear);
		
		btnCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				app.Crear();
			}
		});
		
		JButton btnAbrir = new JButton("ABRIR");
		btnAbrir.setBounds(249, 113, 89, 23);
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
