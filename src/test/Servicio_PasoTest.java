package test;


import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;

import org.junit.Test;

import datos.DAO_Paso;
import negocio.Servicio_Paso;

class Servicio_PasoTest {

	DAO_Paso daop = new DAO_Paso();
	Servicio_Paso sp = new Servicio_Paso(daop);
	JFrame ejemplo = new JFrame();
	JTable tabla = new JTable();
	String nombre ="ejemplo.xls";
	String nombre2 = "ejemplo1.xls";
	
	
	
	@Test
	void testExportar() {
		boolean retorno = sp.exportar(ejemplo, tabla);
		boolean esperado= true;
		assertEquals(retorno,esperado);
	}

	@Test
	void testEditar() {
		boolean retorno = sp.editar(tabla, nombre2);
		boolean esperado= true;
		assertEquals(retorno,esperado);
	}

	@Test
	void testEditar1() throws Exception {
		boolean retorno = sp.editar1(tabla, nombre);
		boolean esperado= true;
		assertEquals(retorno,esperado);
	}

	@Test
	void testExiste() throws SQLException {
		boolean retorno = sp.existe(nombre);
		boolean esperado= true;
		assertEquals(retorno,esperado);
	}

}
