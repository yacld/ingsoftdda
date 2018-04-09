package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.Before;
import org.junit.Test;

import presentacion.Control_Diagrama;

/**
 * 
 * @author Yaeld
 * Pruebas de la clase ControlDiagrama
 * En esta se encuentra la prueba del metodo generar
 * 
 */

public class Control_DiagramaTest {
	/**
	 * Se define las clases que necesitamos en la prueba
	 */
	Control_Diagrama cd;
	DefaultTableModel modelo;
	JTable tabla;
	DefaultTableModel modelo2;
	JTable tabla2;
	/**
	 * Este metodo es el que inicia todo lo necesario para realizar la prueba
	 * Todo esto es para iniciar un tabla y agregar elementos a ella
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		cd = new Control_Diagrama();
		modelo = new DefaultTableModel();
		modelo.addColumn("ID Paso");
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("ID Paso Anterior");
		modelo.addColumn("Conector");
		modelo.addColumn("Tipo de Forma");
		modelo.addColumn("Actor Responsable");
		modelo.addColumn("Comentarios");
		
				
		tabla = new JTable();
		tabla.setModel(modelo);
		String[] datos = {"1","Paso1","","0","Simple","Rectangulo","",""};
		modelo.addRow(datos);
		String[] datos1 = {"2","Paso2","","1","Simple","Rombo","",""};
		modelo.addRow(datos1);
		String[] datos2 = {"3","Paso3","","2","Condicion SI","Rectangulo","",""};
		modelo.addRow(datos2);
		
		
	}
	/**
	 * Aqui se realiza la prueba
	 * se llama al metodo generar de la clase controlDiagrama
	 * 
	 */
	@Test
	public void testgenerar() {
		boolean retorno = false;
		try {
			retorno = cd.generar(tabla);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean esperado = true;
		assertEquals(retorno,esperado);
	}
	
	

}
