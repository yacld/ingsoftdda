package test;
/*
 *
 * 
 */
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import negocio.Servicio_Crear_Usuario;
import presentacion.Control_Crear_Usuario;


class Control_Crear_UsuarioTest {

	Servicio_Crear_Usuario sc2;
	String nombre = "Aguacate";
	String apellido = "Cebollin"; 
	int asesor = 1;
	String contrasenia = "cebollin123mayor"; 
	String nick = "cebollalfa";
	
	Control_Crear_Usuario cc = new Control_Crear_Usuario(sc2);  
	
	

	@Test
	void testAgregarUsuario() throws SQLException {
		boolean retorno = cc.agregarUsuario(nombre, apellido, asesor, contrasenia, nick);
		boolean esperado = true;
		assertEquals(retorno,esperado);
	}
}
