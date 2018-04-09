package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * @author Yaeld
 *
 * Clase que realiza la ventana donde se muestra el diagrama
 */
public class Ventana_Diagrama {
	
	public JFrame frmDiagrama;
	public JPanel jpDiagrama;
	/**
	 * Constructor de la ventana, recibe un panel que contiene el diagrama
	 * llama al metodo inicia que crea y muestra la ventana 
	 * 
	 * @param panel
	 */
	public Ventana_Diagrama( JPanel panel) {
		// TODO Auto-generated constructor stub
		jpDiagrama = panel;
		inicia();
	}
	/**
	 * metodo que inicia la ventana
	 * integra el panel recibido en el constructor
	 */
	 public void inicia(){
		frmDiagrama = new JFrame("Diagrama");
		frmDiagrama.setBounds(20, 20, 500, 500);
		frmDiagrama.setVisible(true);
		frmDiagrama.setResizable(false);
		frmDiagrama.setLayout(null);
		frmDiagrama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmDiagrama.add(jpDiagrama);
		jpDiagrama.setBounds(20, 20, 450, 400);
		
		
		
		JButton jbregresa = new JButton("Regresa");
		jbregresa.setBounds(200, 440, 100, 25);
		frmDiagrama.add(jbregresa);
		jbregresa.setBackground(Color.WHITE);
		
		jbregresa.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frmDiagrama.dispose();
			}
			
		});
		
		
	}

}
