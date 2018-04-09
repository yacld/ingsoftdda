package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import datos.DAO_Usuario;
import negocio.Servicio_Entrar;


class Servicio_EntrarTest {

		DAO_Usuario daou = new DAO_Usuario();
		String usuario = "tony";
		String contra = "gato";
		Servicio_Entrar se = new Servicio_Entrar(daou);


	
	@Test
	void testValida() throws SQLException {
		boolean retorno = se.valida(usuario, contra);
		boolean esperado = false;
		assertEquals(retorno,esperado);
	}

	@Test
	void testMostrar() throws SQLException {
		boolean retorno = se.mostrar(usuario, contra);
		boolean esperado = true;
		assertEquals(retorno,esperado);
	}

}
