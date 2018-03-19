package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.swing.DefaultListModel;

import org.junit.Before;
import org.junit.Test;

import datos.DAO_Plantillas;

public class DAO_PlantillasTest {
	DAO_Plantillas daop;
	String usuario;
	DefaultListModel listModel;
	@Before
	public void setUp() throws Exception {
		
		daop = new DAO_Plantillas();
		usuario = "yacl";
		listModel = new DefaultListModel();
	}

	
	@Test
	public void testObten_Plantillas() {
		boolean retorno = false;
		try {
			retorno = daop.Obten_Plantillas(usuario, listModel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean esperado = true;
		assertEquals(retorno,esperado);
	}

}
