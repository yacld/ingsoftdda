package datos;

import java.io.File;

import javax.swing.JPanel;
import javax.swing.JTable;

import negocio.Diagrama;
/**
 * 
 * @author Yaeld
 * Clase que realiza la generacion del diagrama
 * Se apoya de la clase diagrama
 */
public class DAO_Diagrama {
	/**
	 * metodo que genera el diagrama
	 * recibe la tabla con los elementos para generar el diagrama
	 * regresa el panel creado
	 * recorre las filas de la tabla y los agrega a una lista en la clase diagrama, esto para la generacion del diagrama
	 * llama al metodo repaint de la clase diagrama para dibujar el diagrama en el panel a regresar
	 * @param tabla
	 * @return
	 */
	public JPanel generaDiagrama(JTable tabla) {
		// TODO Auto-generated method stub
		String [] pasoaux  = {"0", "INICIO", "0","","Ovalo"};
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
		
		String [] pasoaux2 = {tabla.getRowCount()+1+"", "FIN", tabla.getRowCount()+"","Simple","Ovalo"};
		jpDiagrama.agregapaso(pasoaux2);
		jpDiagrama.agregapos();
		jpDiagrama.repaint();
		
		return jpDiagrama;
	}

}
