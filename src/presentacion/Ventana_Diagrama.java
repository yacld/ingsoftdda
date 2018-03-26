package presentacion;

import java.io.File;

import javax.swing.JFrame;

public class Ventana_Diagrama {
	
	public JFrame frmDiagrama;
	
	public Ventana_Diagrama(Control_Diagrama cd, File file) {
		// TODO Auto-generated constructor stub
		inicia();
	}
	
	 public void inicia(){
		frmDiagrama = new JFrame("Diagrama");
		frmDiagrama.setBounds(20, 20, 500, 500);
		frmDiagrama.setVisible(true);
		frmDiagrama.setResizable(false);
		frmDiagrama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
