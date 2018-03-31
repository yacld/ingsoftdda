package presentacion;

import java.io.File;

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
		frmDiagrama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
