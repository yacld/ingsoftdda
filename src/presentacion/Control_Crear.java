package presentacion;

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

	public void iniciar(String usuario) {
		Ventana_Crear vc= new Ventana_Crear(this);
		vc.iniciar(usuario);
		
	}

	public void crear(String[] datos, String usuario) throws IOException, SQLException {
		if(sc.Crear(datos, usuario)) {
			Primera_Ventana pv = new Primera_Ventana(this ,usuario);
		}else {
			JOptionPane.showMessageDialog(null, "¡¡¡La Plantilla no se pudo crear!!!");
		}
		
	}

	/*public void mostarNueva(File name) {
		
		Ventana_Crear vc = new Ventana_Crear(this);	
		vc.mostrarNueva(name);
	}*/
	
	public void mostrarPrincipal(Control_Crear cc2, String u) throws SQLException {
		Primera_Ventana vent = new Primera_Ventana(cc2, u);
		
	}

	public boolean obtenPlantillas(String nombre, DefaultListModel<File> listModel) throws SQLException {
		if(sc.obtenPlantillas(nombre,listModel)) {
			return true;
		}
		return false;
		
	}

}
