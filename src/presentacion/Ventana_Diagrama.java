package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana_Diagrama {
	
	public JFrame frmDiagrama;
	public JPanel jpDiagrama;
	
	public Ventana_Diagrama(Control_Diagrama cd, JPanel panel) {
		// TODO Auto-generated constructor stub
		jpDiagrama = panel;
		inicia();
	}
	
	 public void inicia(){
		frmDiagrama = new JFrame("Diagrama");
		frmDiagrama.setBounds(20, 20, 500, 500);
		frmDiagrama.setVisible(true);
		frmDiagrama.setResizable(false);
		frmDiagrama.setLayout(null);
		frmDiagrama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmDiagrama.add(jpDiagrama);
		jpDiagrama.setBounds(20, 20, 400, 400);
		
		
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
