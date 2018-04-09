package datos;

import java.io.File;

import javax.swing.JPanel;
import javax.swing.JTable;

import negocio.Diagrama;

public class DAO_Diagrama {

	public JPanel generaDiagrama(JTable tabla) {
		// TODO Auto-generated method stub
		String [] pasoaux  = {"0", "Inicio", "0","","Ovalo"};
		Diagrama jpDiagrama = new Diagrama(pasoaux);
		
		
		
		for (int i = 0; i < tabla.getRowCount(); i++) {
            ////for (int j = 0; j < tabla.getColumnCount(); j++) {
                String id = String.valueOf(tabla.getValueAt(i, 0));
                String nombre = String.valueOf(tabla.getValueAt(i, 1));
                String idant = String.valueOf(tabla.getValueAt(i, 3));
                String conector = String.valueOf(tabla.getValueAt(i, 4));
                String forma  = String.valueOf(tabla.getValueAt(i, 5));
                
                String [] paso  = {id, nombre, idant,conector,forma};
                
                jpDiagrama.agregapaso(paso);
                if (conector.equals("Condicion SI")){
                	jpDiagrama.agregaposcond(60, 25);
                }else if(conector.equals("Condicion NO")){
                	jpDiagrama.agregaposcond(-60, 0);
                }else{
                    jpDiagrama.agregapos();
                }            
                                              
            //}
        }
		jpDiagrama.repaint();
		
		return jpDiagrama;
	}

}
