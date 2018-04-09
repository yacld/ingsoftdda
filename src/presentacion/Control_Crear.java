package presentacion;
/**
 * Clase que se encarga de la creacion de la plantilla
 */
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import datos.DAO_Crear;
import negocio.Servicio_Crear;
import negocio.Usuario;

public class Control_Crear {
	Servicio_Crear sc;
	Control_Paso cp;
	DAO_Crear daoc = new DAO_Crear();

	public Control_Crear(Servicio_Crear sc2) {
			
		this.sc = sc2;
		sc = new Servicio_Crear(daoc);
		
	}

	/**
	 * Inicia la ventana donde se creara la plantilla
	 * @param usuario
	 */
	public void iniciar(String usuario) {
		Ventana_Crear vc= new Ventana_Crear(this);
		vc.iniciar(usuario);
		
	}
	
	/**
	 * Metodo que crea la plantilla en la base de datos
	 * @param datos: datos que tendra la plantilla(iso asesor nombre)
	 * @param usuario: usuario ligado a la plantilla
	 * @throws IOException
	 * @throws SQLException
	 */
	public void crear(String[] datos, String usuario) throws IOException, SQLException {
		if(sc.Crear(datos, usuario)) {
			Primera_Ventana pv = new Primera_Ventana(this ,usuario);
		}else {
			JOptionPane.showMessageDialog(null, "¡¡¡La Plantilla no se pudo crear!!!");
		}
		
	}
	/**
	 * Abre una nueva ventana donde estaran las plantillas relacionadas al usuario 
	 * @param cc2
	 * @param u
	 * @throws SQLException
	 */
	public void mostrarPrincipal(Control_Crear cc2, String u) throws SQLException {
		Primera_Ventana vent = new Primera_Ventana(cc2, u);
		
	}

	/**
	 * obtiene todas la plantillas relacionadas al usuario
	 * @param nombre: nombre del usuario
	 * @param listModel: donde se guardaran losdatos de las plantillas
	 * @return: regresa true si se pudo recuperar algo de la base sin errores
	 * @throws SQLException
	 */
	public boolean obtenPlantillas(String nombre, DefaultListModel<File> listModel) throws SQLException {
		if(sc.obtenPlantillas(nombre,listModel)) {
			return true;
		}
		return false;
		
	}

}
